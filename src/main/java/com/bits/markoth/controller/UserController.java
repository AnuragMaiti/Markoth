package com.bits.markoth.controller;

import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/markoth/users")
public class UserController extends GenericController<UserEntity, Long> {
    @Autowired
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

    @GetMapping("/me")
    public ResponseEntity<UserEntity> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserEntity currentUser = (UserEntity) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

//    @GetMapping
//    public ResponseEntity<List<UserEntity>> allUsers() {
//        List<UserEntity> users = userService.allUsers();
//
//        return ResponseEntity.ok(users);
//    }
}