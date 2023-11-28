package com.bits.markoth.service;

import com.bits.markoth.domain.MessageEntity;
import com.bits.markoth.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageService extends GenericService<MessageEntity, Long> {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageService(final MessageRepository repository) {
        super(repository);
    }
}