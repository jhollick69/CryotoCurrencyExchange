package org.copper.interview.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.copper.interview.repository.Account;

public interface AccountBalanceService {

	List<Account> getUserBalances(String clientID, String clientSecret, boolean withPortfolio)
			throws IOException, ExecutionException, InterruptedException;
}
