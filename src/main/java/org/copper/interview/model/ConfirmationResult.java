package org.copper.interview.model;

public class ConfirmationResult {
	   private String jsonrpc;

	    private int id;

	    private TransferSubAccountResult result;

	    public void setJsonrpc(String jsonrpc){
	        this.jsonrpc = jsonrpc;
	    }
	    public String getJsonrpc(){
	        return this.jsonrpc;
	    }
	    public void setId(int id){
	        this.id = id;
	    }
	    public int getId(){
	        return this.id;
	    }
	    public void setResult(TransferSubAccountResult result){
	        this.result = result;
	    }
	    public TransferSubAccountResult getResult(){
	        return this.result;
	    }
}
