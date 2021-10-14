package org.copper.interview.model;

public class Result
{
    private String email;

    private int id;

    private boolean is_password;

    private boolean login_enabled;

    private Portfolio portfolio;

    private boolean receive_notifications;

    private String system_name;

    private boolean tfa_enabled;

    private String type;

    private String username;

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setIs_password(boolean is_password){
        this.is_password = is_password;
    }
    public boolean getIs_password(){
        return this.is_password;
    }
    public void setLogin_enabled(boolean login_enabled){
        this.login_enabled = login_enabled;
    }
    public boolean getLogin_enabled(){
        return this.login_enabled;
    }
    public void setPortfolio(Portfolio portfolio){
        this.portfolio = portfolio;
    }
    public Portfolio getPortfolio(){
        return this.portfolio;
    }
    public void setReceive_notifications(boolean receive_notifications){
        this.receive_notifications = receive_notifications;
    }
    public boolean getReceive_notifications(){
        return this.receive_notifications;
    }
    public void setSystem_name(String system_name){
        this.system_name = system_name;
    }
    public String getSystem_name(){
        return this.system_name;
    }
    public void setTfa_enabled(boolean tfa_enabled){
        this.tfa_enabled = tfa_enabled;
    }
    public boolean getTfa_enabled(){
        return this.tfa_enabled;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
}

