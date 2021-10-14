package org.copper.interview.model;

import java.util.List;
public class AccountResponse
{
	    private String jsonrpc;

	    private int id;

	    private List<Result> result;

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
	    public void setResult(List<Result> result){
	        this.result = result;
	    }
	    public List<Result> getResult(){
	        return this.result;
	    }
	}
	    
	

