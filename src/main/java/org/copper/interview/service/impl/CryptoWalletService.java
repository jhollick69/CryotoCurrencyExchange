package org.copper.interview.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.copper.interview.model.Data;
import org.copper.interview.model.TransferExternalAccountResult;
import org.copper.interview.model.TransferSubAccountResult;



public interface CryptoWalletService {
	/*
	 * Getting history of withdrawals and deposits and both.
	 */
	List<Data> getWithDrawalsHistory(String clientId, String clientsecret,String currency,Integer count,Integer offset) throws IOException;
	List<Data>  getDepositsHistory(String clientId, String clientsecret,String currency, Integer count, Integer offset) throws IOException;
	List<Data>  getWihdrawalAndDepositsHistory(String clientId, String clientsecret,String currency, Integer count, Integer offset) throws IOException;
	/*
	 * Withdraw from exchange to external  address.
	 */
	TransferSubAccountResult transferToSubAccount(String clientId, String clientsecret,String currency,
		      BigDecimal amount, Integer subAccountID) throws IOException;

	/*
	 *  Transfer between main account and sub account.
	 */
	TransferExternalAccountResult transferToExternalAccounts(String clientId, String clientsecret,
			String currency, BigDecimal amount, String destination) throws IOException;
	
	
	
	
}
