package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateMessageDTO;
import com.group1j.backend.entities.Message;
import com.group1j.backend.services.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
public class MessageController {
    //Fields
    private MessageService messageService;

    //Constructor
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public Message createMessage(@RequestBody CreateMessageDTO createMessageDTO){
        return messageService.createMessage(createMessageDTO);
    }
}
