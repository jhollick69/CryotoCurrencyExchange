package org.copper.interview.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.copper.interview.controller.HttpUtils;
import org.copper.interview.model.AccountDepositResponse;
import org.copper.interview.model.Deposits;
import org.copper.interview.model.TransferToSubAccount;
import org.copper.interview.model.TransferToExternalAccount;
import org.copper.interview.model.Withdrawal;
import org.copper.interview.model.WithdrawalResponse;
import org.copper.interview.test.constants.URLConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoWalletServiceImpl implements CryptoWalletService {

	
	@Override
	public List<Withdrawal> getWithDrawalsHistory(String clientId, String clientsecret,  String currency,
			Integer count,Integer offset) throws IOException {
		List<Withdrawal> listData = new ArrayList<Withdrawal>();

		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/get_withdrawals?count=+" + count
					+ "&currency=" + currency + "&offset=" + offset;
			ResponseEntity<WithdrawalResponse> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity,
					WithdrawalResponse.class);
			listData = responseEntity.getBody().result;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	@Override
	public List<Deposits> getDepositsHistory(String clientId, String clientsecret, String currency, Integer count,
			Integer offset) throws IOException {
		List<Deposits> listData = new ArrayList<Deposits>();
		ResponseEntity<AccountDepositResponse> responseEntity = null;
		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/get_deposits?" + "currency=" + currency
					+ "&count=" + count + "&offset" + offset;
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity, AccountDepositResponse.class);

			listData = responseEntity.getBody().result;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;
	}

	@Override
	public TransferToSubAccount transferToSubAccount(String clientId, String clientsecret, String currency,
			BigDecimal amount, Integer destination) throws IOException {
		ResponseEntity<TransferToSubAccount> responseEntity = null;
		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/submit_transfer_to_subaccount?amount="
					+ amount + "&currency=" + currency + "&destination=" + destination;
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity, TransferToSubAccount.class);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseEntity.getBody();
	}

	@Override
	public TransferToExternalAccount transferToExternalAccounts(String clientId, String clientsecret, String currency,
			BigDecimal amount, Integer destination) throws IOException {
		ResponseEntity<TransferToExternalAccount> responseEntity = null;
		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/submit_transfer_to_subaccount?amount="
					+ amount + "&currency=" + currency + "destination=" + destination;
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity, TransferToExternalAccount.class);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseEntity.getBody();
	}

}
