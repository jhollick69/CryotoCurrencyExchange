package org.copper.interview.model;

public class Data {
	private String address;

    private double amount;

    private String confirmed_timestamp;

    private String created_timestamp;

    private String currency;

    private double fee;

    private int id;

    private double priority;

    private String state;

    private String transaction_id;

    private String updated_timestamp;

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return this.amount;
    }
    public void setConfirmed_timestamp(String confirmed_timestamp){
        this.confirmed_timestamp = confirmed_timestamp;
    }
    public String getConfirmed_timestamp(){
        return this.confirmed_timestamp;
    }
    public void setCreated_timestamp(String created_timestamp){
        this.created_timestamp = created_timestamp;
    }
    public String getCreated_timestamp(){
        return this.created_timestamp;
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    public void setFee(double fee){
        this.fee = fee;
    }
    public double getFee(){
        return this.fee;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setPriority(double priority){
        this.priority = priority;
    }
    public double getPriority(){
        return this.priority;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setTransaction_id(String transaction_id){
        this.transaction_id = transaction_id;
    }
    public String getTransaction_id(){
        return this.transaction_id;
    }
    public void setUpdated_timestamp(String updated_timestamp){
        this.updated_timestamp = updated_timestamp;
    }
    public String getUpdated_timestamp(){
        return this.updated_timestamp;
    }

}
