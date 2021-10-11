package org.copper.interview.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.copper.interview.repository.Account;


public interface AccountBalanceService {
	/*
	 * Getting the user's current balances and reserved funds for all available currencies 
	 * (‘reserved’ means are not available for withdrawal). This data must be stored in the relational database 
	 * and updated by each call of  the method, if it is needed.
	 */

	List<Account> getUserBalances(String clientID, String clientSecret,boolean withPortfolio) throws IOException, ExecutionException, InterruptedException;
}
