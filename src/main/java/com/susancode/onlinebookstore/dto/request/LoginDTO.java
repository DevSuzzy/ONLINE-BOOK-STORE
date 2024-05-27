package com.susancode.onlinebookstore.dto.request;

import jakarta.validation.constraints.NotBlank;
/**
 * Data Transfer Object (DTO) class for representing login request data.
 * Contains fields for username and password.
 */

public class LoginDTO {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
