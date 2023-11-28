package com.bits.markoth.controller;

import com.bits.markoth.domain.MessageEntity;
import com.bits.markoth.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/markoth/messages")
public class MessageController extends GenericController<MessageEntity, Long> {
    @Autowired
    MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        super(messageService);
    }
}