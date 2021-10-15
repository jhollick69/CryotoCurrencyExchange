package org.copper.interview.model;

public class TransferExternalResult {
	private String jsonrpc;

	private int id;

	private TransferExternalAccountResult result;

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public String getJsonrpc() {
		return this.jsonrpc;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setResult(TransferExternalAccountResult result) {
		this.result = result;
	}

	public TransferExternalAccountResult getResult() {
		return this.result;
	}
}
