package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

public class UsernameOnlyDto {
    private final String username;

    public UsernameOnlyDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
