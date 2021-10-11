package org.copper.interview.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.copper.interview.model.Deposits;
import org.copper.interview.model.TransferToSubAccount;
import org.copper.interview.model.TransferToExternalAccount;
import org.copper.interview.model.Withdrawal;



public interface CryptoWalletService {
	/*
	 * Getting history of withdrawals and deposits.
	 */
	List<Withdrawal> getWithDrawalsHistory(String clientId, String clientsecret,String currency,Integer count,Integer offset) throws IOException;
	List<Deposits>  getDepositsHistory(String clientId, String clientsecret,String currency, Integer count, Integer offset) throws IOException;

	/*
	 * Withdraw from exchange to external  address.
	 */
	TransferToSubAccount transferToSubAccount(String clientId, String clientsecret,String currency,
		      BigDecimal amount, Integer subAccountID) throws IOException;

	/*
	 *  Transfer between main account and sub account.
	 */
	TransferToExternalAccount transferToExternalAccounts(String clientId, String clientsecret,
			String currency, BigDecimal amount, Integer destination) throws IOException;
	
	
	
	
}
