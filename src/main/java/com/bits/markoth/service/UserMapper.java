package com.bits.markoth.service;

import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper{
    public UserDto toUserDto(UserEntity user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user);
    }

}
