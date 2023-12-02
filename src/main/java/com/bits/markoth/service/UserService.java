package com.bits.markoth.service;

import com.bits.markoth.domain.UserEntity;
import com.bits.markoth.exception.ResourceException;
import com.bits.markoth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService extends GenericService<UserEntity, Long> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService(final UserRepository repository) {
        super(repository);
    }

    public List<UserEntity> allUsers() {
        List<UserEntity> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public Long getUsersCount() {
        return userRepository.count();
    }

    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    boolean hasUserWithUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserEntity validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new ResourceException(String.format("User with username %s not found", username)));
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void deleteUser(UserEntity user) {
        userRepository.delete(user);

    }

}