package com.tutorial.sultana.moduls.auth;

public class AuthResponse {
    private String token;
    public AuthResponse(String token){
        this.token=token;
    }
    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
