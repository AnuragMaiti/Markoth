package com.bits.markoth.controller;

import com.bits.markoth.domain.ChatRoomEntity;
import com.bits.markoth.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markoth/chatrooms")
public class ChatRoomController extends
        GenericController<ChatRoomEntity, Long> {
    @Autowired
    ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService) {
        super(chatRoomService);
    }

}