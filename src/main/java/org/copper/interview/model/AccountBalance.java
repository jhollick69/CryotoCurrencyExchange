package org.copper.interview.model;

public class AccountBalance {
	private String currency;

    private double account_balance; 

    private double reserved_balance; //  available_funds - available_withdrawal_funds

    private double initial_margin;

    private double margin_balance;

    private String deposit_address;
}
