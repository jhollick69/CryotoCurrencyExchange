package org.copper.interview.model;

public class AssetResponse {
	private String jsonrpc;

	private int id;

	private AssetResult result;

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

	public void setResult(AssetResult result) {
		this.result = result;
	}

	public AssetResult getResult() {
		return this.result;
	}

}
