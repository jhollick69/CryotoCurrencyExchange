package org.copper.interview.test.constants;

public enum CurrencyCode {
	  ETH("ETH", "Etherium"),
	  BTC("BTC", "Bitcoin"),
	  USD("USDT", "US Dollar token");

	  private final String code;
	  private final String description;

	  CurrencyCode(String code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public String getCode() {
	    return code;
	  }

	  public String getDescription() {
	    return description;
	  }
}
