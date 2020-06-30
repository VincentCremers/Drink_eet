package com.example.accessingdatamysql.securityjwt.models;


//input structure for authenticate method
public class AuthenticationRequest {

    // takes in username and password in a post request
    private String username;
    private String password;

    public  AuthenticationRequest(){

    }

    public AuthenticationRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        System.out.println(username);
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        System.out.println(password);
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}