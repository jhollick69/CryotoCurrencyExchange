package org.copper.interview.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.copper.interview.controller.HttpUtils;
import org.copper.interview.model.AccountResponse;
import org.copper.interview.repository.Account;
import org.copper.interview.repository.ClientBalanceRepository;
import org.copper.interview.test.constants.URLConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

	@Autowired
	private ClientBalanceRepository clientBalanceRepository;

	public List<Account> getUserBalances(String clientID, String clientSecret, boolean withPortfolio)
			throws IOException, ExecutionException, InterruptedException {
		List<Account> accountBalance = getSubAccounts(clientID, clientSecret, withPortfolio);
		saveBalances(accountBalance);
		return accountBalance;

	}

	private void saveBalances(List<Account> accountBalance) {
		for (Account balance : accountBalance) {
			clientBalanceRepository.save(balance);
		}
	}

	private List<Account> getSubAccounts(String clientId, String clientsecret, boolean withPortfolio)
			throws IOException {
		List<Account> listOfAccs = new ArrayList();
		;

		try {
			final HttpEntity<String> entity = new HttpEntity<String>(
					HttpUtils.createHttpHeaders(clientId, clientsecret));

			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "private/get_subaccounts?with_portfolio="
					+ withPortfolio;

			ResponseEntity<AccountResponse> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity,
					AccountResponse.class);

			listOfAccs = responseEntity.getBody().getResult().stream().map(x -> x.getPortfolio().getAssest())
					.collect(Collectors.toList());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listOfAccs;
	}

}
