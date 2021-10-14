package org.copper.interview.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.copper.interview.model.Data;
import org.copper.interview.model.TransferExternalAccountResult;
import org.copper.interview.model.TransferSubAccountResult;
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
		 if (accountBalance.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		return ResponseEntity.status(HttpStatus.OK).body(accountBalance);
	}

	@GetMapping("/withdrawal/history")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Data>> getWithDrawalHistory(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam Integer count,
			@RequestParam Integer offset) throws Exception {
		List<Data> withdrawHistory = cryptoWalletServiceImpl.getWithDrawalsHistory(clientID, clientSecret, currency,
				count, offset);
		
		if (withdrawHistory.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		return ResponseEntity.status(HttpStatus.OK).body(withdrawHistory);
	}

	@GetMapping("/deposit/history")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Data>> getWithDepositHistory(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam Integer count,
			@RequestParam Integer offset) throws Exception {
		List<Data> depositHistory = cryptoWalletServiceImpl.getDepositsHistory(clientID, clientSecret, currency,
				count, offset);
		if (depositHistory.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		return ResponseEntity.status(HttpStatus.OK).body(depositHistory);
	}

	@GetMapping("/transfer/subaccount")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TransferSubAccountResult> transferToSubAccounts(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam BigDecimal amount,
			@RequestParam Integer destination) throws IOException {
		TransferSubAccountResult transferBetwenAccounts = cryptoWalletServiceImpl.transferToSubAccount(clientID,
				clientSecret, currency, amount, destination);
		if(null==transferBetwenAccounts)
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(transferBetwenAccounts);
	}

	@GetMapping("/transfer/external")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TransferExternalAccountResult> transferBetweenAccounts(@RequestParam String clientSecret,
			@RequestParam String clientID, @RequestParam String currency, @RequestParam BigDecimal amount,
			@RequestParam Integer destination) throws IOException {
		TransferExternalAccountResult transferToRemoteAccount = cryptoWalletServiceImpl.transferToExternalAccounts(clientID,
				clientSecret, currency, amount, destination);
		if(null==transferToRemoteAccount)
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return ResponseEntity.status(HttpStatus.OK).body(transferToRemoteAccount);
	}

}
