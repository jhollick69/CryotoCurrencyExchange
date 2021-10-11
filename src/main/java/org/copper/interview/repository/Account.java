package org.copper.interview.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	public int id;
	public double balance;
	public String deposit_address;
	public String username;
	public double equity;
	public String type;
	public String currency;
	public double margin_balance;

	public double available_withdrawal_funds;
	public long creation_timestamp;
	public String system_name;
	public double initial_margin;
	public String email;
	public double available_funds;
	public double reservedFunds;

	public Account() {

	}

	public Account(double balance) {
		this.balance = balance;

	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDeposit_address() {
		return deposit_address;
	}

	public void setDeposit_address(String deposit_address) {
		this.deposit_address = deposit_address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getEquity() {
		return equity;
	}

	public void setEquity(double equity) {
		this.equity = equity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getMargin_balance() {
		return margin_balance;
	}

	public void setMargin_balance(double margin_balance) {
		this.margin_balance = margin_balance;
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

	public long getCreation_timestamp() {
		return creation_timestamp;
	}

	public void setCreation_timestamp(long creation_timestamp) {
		this.creation_timestamp = creation_timestamp;
	}

	public String getSystem_name() {
		return system_name;
	}

	public void setSystem_name(String system_name) {
		this.system_name = system_name;
	}

	public double getInitial_margin() {
		return initial_margin;
	}

	public void setInitial_margin(double initial_margin) {
		this.initial_margin = initial_margin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvailable_funds() {
		return available_funds;
	}

	public void setAvailable_funds(double available_funds) {
		this.available_funds = available_funds;
	}

	public double getReservedFunds() {
		return getAvailable_funds()-getAvailable_withdrawal_funds();
	}

	public void setReservedFunds(double reservedFunds) {
		this.reservedFunds = reservedFunds;
	}
	
	

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", deposit_address=" + deposit_address + ", username=" + username
				+ ", equity=" + equity + ", type=" + type + ", currency=" + currency + ", margin_balance="
				+ margin_balance + ", id=" + id + ", available_withdrawal_funds=" + available_withdrawal_funds
				+ ", creation_timestamp=" + creation_timestamp + ", system_name=" + system_name + ", initial_margin="
				+ initial_margin + ", email=" + email + ", available_funds=" + available_funds + ", reservedFunds="
				+ reservedFunds + "]";
	}

}
