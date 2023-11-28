package com.bits.markoth.repository;

import com.bits.markoth.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends JpaRepository<UserEntity,
        Long>, JpaSpecificationExecutor<UserEntity>,
        ListCrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}