package com.bits.markoth.dtos;

public class RegisterUserDto {
    private String email;
    private String password;
    private String username;
    private String name;
    private String phone;
    private String role;

    public String getEmail() {
        return email;
    }

    public RegisterUserDto setEmail(String email) {
        this.email = email;
        return this;
    }
    public RegisterUserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RegisterUserDto setUsername(String username) {
        this.username = username;
        return this;
    }
    public RegisterUserDto setRole(String role) {
        this.role = role;
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

    public String getPhone() {
        return phone;
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
                ", phone='" + phone + '\'' +
                '}';
    }
}