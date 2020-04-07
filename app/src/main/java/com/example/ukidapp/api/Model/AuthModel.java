package com.example.ukidapp.api.Model;

import com.google.gson.JsonObject;

import java.util.HashMap;

public class AuthModel {

    private String message;
    private boolean result;
    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthModel(HashMap<String, Object> user){
        this.email = (String) user.get("email");
        this.password = (String) user.get("password");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
