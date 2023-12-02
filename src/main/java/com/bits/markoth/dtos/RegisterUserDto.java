package com.bits.markoth.dtos;

public class RegisterUserDto {
    private String email;
    private String password;
    private String username;
    private String name;
    private String role;

    public String getEmail() {
        return email;
    }

    public RegisterUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegisterUserDto setUsername(String username) {
        this.email = username;
        return this;
    }
    public RegisterUserDto setRole(String role) {
        this.email = role;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }

    public RegisterUserDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}