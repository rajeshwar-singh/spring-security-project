package com.example.Hospital.dto;

import org.springframework.stereotype.Component;


public class SignupResponseDto {
    public SignupResponseDto(Long id, String username)
    {
        this.id = id;
        this.username = username;
    }
    private long id;
    private String username;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
