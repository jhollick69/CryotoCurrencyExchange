package org.copper.interview.model;

import java.util.List;
public class AccountResponse
{
	    private String jsonrpc;

	    
	    private List<Result> result;

	    public void setJsonrpc(String jsonrpc){
	        this.jsonrpc = jsonrpc;
	    }
	    public String getJsonrpc(){
	        return this.jsonrpc;
	    }
	   
	    public void setResult(List<Result> result){
	        this.result = result;
	    }
	    public List<Result> getResult(){
	        return this.result;
	    }
	}
	    
	

