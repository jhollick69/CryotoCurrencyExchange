package org.copper.interview.model;

public class TransferSubAccountResult {
	
	    private int updated_timestamp;

	    private String type;

	    private String state;

	    private String other_side;

	    private int id;

	    private String direction;

	    private String currency;

	    private int created_timestamp;

	    private double amount;

	    public void setUpdated_timestamp(int updated_timestamp){
	        this.updated_timestamp = updated_timestamp;
	    }
	    public int getUpdated_timestamp(){
	        return this.updated_timestamp;
	    }
	    public void setType(String type){
	        this.type = type;
	    }
	    public String getType(){
	        return this.type;
	    }
	    public void setState(String state){
	        this.state = state;
	    }
	    public String getState(){
	        return this.state;
	    }
	    public void setOther_side(String other_side){
	        this.other_side = other_side;
	    }
	    public String getOther_side(){
	        return this.other_side;
	    }
	    public void setId(int id){
	        this.id = id;
	    }
	    public int getId(){
	        return this.id;
	    }
	    public void setDirection(String direction){
	        this.direction = direction;
	    }
	    public String getDirection(){
	        return this.direction;
	    }
	    public void setCurrency(String currency){
	        this.currency = currency;
	    }
	    public String getCurrency(){
	        return this.currency;
	    }
	    public void setCreated_timestamp(int created_timestamp){
	        this.created_timestamp = created_timestamp;
	    }
	    public int getCreated_timestamp(){
	        return this.created_timestamp;
	    }
	    public void setAmount(double amount){
	        this.amount = amount;
	    }
	    public double getAmount(){
	        return this.amount;
	    }
	}



