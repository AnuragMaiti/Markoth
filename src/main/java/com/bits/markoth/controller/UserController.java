package com.bits.markoth.controller;

import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.dtos.UserDto;
import com.bits.markoth.security.CustomUserDetails;
import com.bits.markoth.service.UserMapper;
import com.bits.markoth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/markoth/users")
public class UserController extends GenericController<UserEntity, Long> {
    @Autowired
    UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

//    @GetMapping("/me")
//    public ResponseEntity<UserEntity> authenticatedUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        UserEntity currentUser = (UserEntity) authentication.getPrincipal();
//
//        return ResponseEntity.ok(currentUser);
//    }

//    @GetMapping
//    public ResponseEntity<List<UserEntity>> allUsers() {
//        List<UserEntity> users = userService.allUsers();
//
//        return ResponseEntity.ok(users);
//    }

    @GetMapping("/me")
    public UserDto getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
        return userMapper.toUserDto(userService.validateAndGetUserByUsername(currentUser.getUsername()));
    }
//
//    @GetMapping
//    public List<UserDto> getUsers() {
//        return userService.getUsers().stream()
//                .map(userMapper::toUserDto)
//                .collect(Collectors.toList());
//    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userMapper.toUserDto(userService.validateAndGetUserByUsername(username));
    }

    @DeleteMapping("/{username}")
    public UserDto deleteUser(@PathVariable String username) {
        UserEntity user = userService.validateAndGetUserByUsername(username);
        userService.deleteUser(user);
        return userMapper.toUserDto(user);
    }
}