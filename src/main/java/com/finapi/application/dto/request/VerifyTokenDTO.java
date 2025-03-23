package com.finapi.application.dto.request;

public class VerifyTokenDTO {

    private String token;

    public VerifyTokenDTO() {
    }

    public VerifyTokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
