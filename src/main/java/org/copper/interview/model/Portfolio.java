package org.copper.interview.model;

import org.copper.interview.repository.Account;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Portfolio
{
	
	@JsonAlias({"btc","usdt","eth"})
    private Account assest;


	public Account getAssest() {
		return assest;
	}

	public void setAssest(Account assest) {
		this.assest = assest;
	}

	
    
    
}
