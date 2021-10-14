package org.copper.interview.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double balance;

	private String currency;

	private double available_withdrawal_funds;

	private double available_funds;
	private double reservedFunds;

	public Account() {
		
		
	}

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

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return getReservedFunds();
	}

	public void setReservedFunds(double reservedFunds) {
		this.reservedFunds = reservedFunds;
	}

	
	

}
