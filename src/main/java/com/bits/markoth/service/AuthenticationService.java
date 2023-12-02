package com.bits.markoth.service;

import com.bits.markoth.dtos.LoginUserDto;
import com.bits.markoth.dtos.RegisterUserDto;
import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.repository.UserRepository;
import com.bits.markoth.security.CustomUserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity signup(RegisterUserDto input) {
        var user = new UserEntity();
        user.setUsername(input.getUsername());
        user.setName(input.getName());
        user.setEmail(input.getEmail());
//        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setPassword(input.getPassword());

        return userRepository.save(user);
    }

    public Authentication authenticate(LoginUserDto input) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );
        return auth;
//        return userRepository.findByUsernameAndPassword(input.getUsername(), input.getPassword()).orElseThrow();
    }

    public List<UserEntity> allUsers() {
        List<UserEntity> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}