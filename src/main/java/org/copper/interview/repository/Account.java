package org.copper.interview.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private int accid;
	
	private double balance;

	private String currency;

	private double available_withdrawal_funds;

	private double available_funds;
	private double reservedFunds;
	private String accountType;
	private String username;
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	

	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public double getAvailable_withdrawal_funds() {
		return available_withdrawal_funds;
	}

	public void setAvailable_withdrawal_funds(double available_withdrawal_funds) {
		this.available_withdrawal_funds = available_withdrawal_funds;
	}

	

	public double getAvailable_funds() {
		return available_funds;
	}

	public void setAvailable_funds(double available_funds) {
		this.available_funds = available_funds;
	}

	public double getReservedFunds() {
		return reservedFunds;
	}

	public void setReservedFunds(double reservedFunds) {
		this.reservedFunds = reservedFunds;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	

}
