package com.example.Hospital.dto;

import org.springframework.stereotype.Component;


public class LoginResponseDto {
    String jwt;
    Long userId;

    public LoginResponseDto(String token, Long userId) {
        this.jwt = token;
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
