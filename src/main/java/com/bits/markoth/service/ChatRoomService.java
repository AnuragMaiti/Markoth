package com.bits.markoth.service;

import com.bits.markoth.domain.ChatRoomEntity;
import com.bits.markoth.repository.ChatRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatRoomService extends GenericService<ChatRoomEntity, Long> {
    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    ChatRoomService(final ChatRoomRepository repository) {
        super(repository);
    }
}