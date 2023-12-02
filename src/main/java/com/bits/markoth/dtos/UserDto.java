package com.bits.markoth.dtos;

import com.bits.markoth.domain.UserEntity;

public class UserDto {
    private String email;
    private String password;
    private String username;
    private String name;
    private String phone;
    private String role;

    public UserDto(UserEntity user){
        email=user.getEmail();
        username=user.getUsername();
        password=user.getPassword();
        name=user.getName();
        phone=user.getPhone();
        role=user.getRole();
    }
    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }
    public UserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }
    public UserDto setRole(String role) {
        this.role = role;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
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

    public UserDto setName(String name) {
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