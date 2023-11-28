package com.bits.markoth.repository;

import com.bits.markoth.domain.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepository extends
        JpaRepository<MessageEntity, Long>,
        JpaSpecificationExecutor<MessageEntity>,
        ListCrudRepository<MessageEntity, Long> {
}