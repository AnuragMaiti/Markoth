package com.bits.markoth.service;

import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserService extends GenericService<UserEntity, Long> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService(final UserRepository repository) {
        super(repository);
    }
}