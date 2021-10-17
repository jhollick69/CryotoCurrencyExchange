package org.copper.interview.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.copper.interview.controller.HttpUtils;
import org.copper.interview.model.AssetResponse;
import org.copper.interview.model.ConfirmationResult;
import org.copper.interview.model.Data;
import org.copper.interview.model.TransferExternalAccountResult;
import org.copper.interview.model.TransferSubAccountResult;
import org.copper.interview.test.constants.URLConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoWalletServiceImpl implements CryptoWalletService {

	@Override
	public List<Data> getWithDrawalsHistory(String clientId, String clientsecret, String currency, Integer count,
			Integer offset) throws IOException {
		List<Data> listData = new ArrayList<Data>();

		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/get_withdrawals?count=" + count
					+ "&currency=" + currency + "&offset=" + offset;
			ResponseEntity<AssetResponse> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity,
					AssetResponse.class);

			listData = responseEntity.getBody().getResult().getData();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	@Override
	public List<Data> getDepositsHistory(String clientId, String clientsecret, String currency, Integer count,
			Integer offset) throws IOException {
		List<Data> listData = new ArrayList<Data>();
		ResponseEntity<AssetResponse> responseEntity = null;
		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/get_deposits?" + "currency=" + currency
					+ "&count=" + count + "&offset" + offset;
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity, AssetResponse.class);

			listData = responseEntity.getBody().getResult().getData();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;
	}

	@Override
	public TransferSubAccountResult transferToSubAccount(String clientId, String clientsecret, String currency,
			BigDecimal amount, Integer destination) throws IOException {
		ResponseEntity<ConfirmationResult> responseEntity = null;
		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/submit_transfer_to_subaccount?currency="
					+ currency + "&amount=" + amount + "&destination=" + destination;
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity, ConfirmationResult.class);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseEntity.getBody().getResult();
	}

	@Override
	public TransferExternalAccountResult transferToExternalAccounts(String clientId, String clientsecret,
			String currency, BigDecimal amount, String destination) throws IOException {
		ResponseEntity<TransferExternalAccountResult> responseEntity = null;
		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/submit_transfer_to_user?amount=" + amount
					+ "&currency=" + currency + "destination=" + destination;
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity,
					TransferExternalAccountResult.class);
			System.out.println("h");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseEntity.getBody();
	}

	@Override
	public List<Data> getWihdrawalAndDepositsHistory(String clientId, String clientsecret, String currency,
			Integer count, Integer offset) throws IOException {

		List<Data> collatedList = new ArrayList<>();
		Stream.of(getDepositsHistory(clientId, clientsecret, currency, count, offset),
				getWithDrawalsHistory(clientId, clientsecret, currency, count, offset)).forEach(collatedList::addAll);

		return collatedList;
	}

}
