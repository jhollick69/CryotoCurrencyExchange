package org.copper.interview.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.copper.interview.model.Deposits;
import org.copper.interview.model.TransferToExternalAccount;
import org.copper.interview.model.TransferToSubAccount;
import org.copper.interview.model.Withdrawal;
import org.copper.interview.repository.Account;
import org.copper.interview.service.impl.AccountBalanceService;
import org.copper.interview.service.impl.CryptoWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CryptoController {

	@Autowired
	private AccountBalanceService accountBalanceServiceImpl;

	@Autowired
	private CryptoWalletService cryptoWalletServiceImpl;

	public CryptoController() {

	}

	@GetMapping("/account/balances")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Account>> getAccountBalances(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam boolean withPortfolio) throws Exception {
		List<Account> accountBalance = accountBalanceServiceImpl.getUserBalances(clientID, clientSecret, withPortfolio);

		return ResponseEntity.status(HttpStatus.OK).body(accountBalance);
	}

	@GetMapping("/withdrawal/history")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Withdrawal>> getWithDrawalHistory(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam Integer count,
			@RequestParam Integer offset) throws Exception {
		List<Withdrawal> withdrawHistory = cryptoWalletServiceImpl.getWithDrawalsHistory(clientID, clientSecret, currency,
				count, offset);

		return ResponseEntity.status(HttpStatus.OK).body(withdrawHistory);
	}

	@GetMapping("/deposit/history")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Deposits>> getWithDepositHistory(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam Integer count,
			@RequestParam Integer offset) throws Exception {
		List<Deposits> depositHistory = cryptoWalletServiceImpl.getDepositsHistory(clientID, clientSecret, currency,
				count, offset);

		return ResponseEntity.status(HttpStatus.OK).body(depositHistory);
	}

	@GetMapping("/transfer/subaccount")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TransferToSubAccount> transferToSubAccounts(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam BigDecimal amount,
			@RequestParam Integer destination) throws IOException {
		TransferToSubAccount transferBetwenAccounts = cryptoWalletServiceImpl.transferToSubAccount(clientID,
				clientSecret, currency, amount, destination);

		return ResponseEntity.status(HttpStatus.OK).body(transferBetwenAccounts);
	}

	@GetMapping("/transfer/external")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TransferToExternalAccount> transferBetweenAccounts(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam BigDecimal amount,
			@RequestParam Integer destination) throws IOException {
		TransferToExternalAccount transferToRemoteAccount = cryptoWalletServiceImpl.transferToExternalAccounts(clientID,
				clientSecret, currency, amount, destination);

		return ResponseEntity.status(HttpStatus.OK).body(transferToRemoteAccount);
	}

}
