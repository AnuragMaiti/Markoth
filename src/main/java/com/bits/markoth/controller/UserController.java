package com.bits.markoth.controller;

import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markoth/users")
public class UserController extends GenericController<UserEntity, Long> {
    @Autowired
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

}