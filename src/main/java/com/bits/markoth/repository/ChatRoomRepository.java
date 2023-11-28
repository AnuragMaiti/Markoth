package com.bits.markoth.repository;

import com.bits.markoth.domain.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;

public interface ChatRoomRepository extends
        JpaRepository<ChatRoomEntity, Long>,
        JpaSpecificationExecutor<ChatRoomEntity>,
        ListCrudRepository<ChatRoomEntity, Long> {
}