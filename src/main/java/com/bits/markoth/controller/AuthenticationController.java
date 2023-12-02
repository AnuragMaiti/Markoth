package com.bits.markoth.controller;

import com.bits.markoth.dtos.LoginUserDto;
import com.bits.markoth.dtos.RegisterUserDto;
import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.responses.LoginResponse;
import com.bits.markoth.security.CustomUserDetails;
import com.bits.markoth.service.AuthenticationService;
import com.bits.markoth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@CrossOrigin
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterUserDto registerUserDto) {
        UserEntity registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Authentication authentication = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generate(authentication);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}