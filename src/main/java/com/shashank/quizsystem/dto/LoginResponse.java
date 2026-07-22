package com.shashank.quizsystem.dto;

public class LoginResponse {

    private String message;
    private String name;
    private String username;
    private String email;
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(String message, String name, String username, String email, String role) {
        this.message = message;
        this.name = name;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}