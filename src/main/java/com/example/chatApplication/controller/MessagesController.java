package com.example.chatApplication.controller;

import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.model.Messages;
import com.example.chatApplication.service.ConversationService;
import com.example.chatApplication.service.MessagesService;
import com.example.chatApplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/chat")
public class MessagesController {
    private final MessagesService messagesService;
    private final ConversationService conversationService;
    private final UserService userService;

    public MessagesController(MessagesService messagesService, ConversationService conversationService, UserService userService) {
        this.messagesService = messagesService;
        this.conversationService = conversationService;
        this.userService = userService;
    }
    @GetMapping("/messages/{id}")
        Optional<List<Messages>> getMessagesByUserId(@PathVariable("id")Long id){
        return messagesService.findMessagesByConversationId(id);
    }
    @PostMapping("send")
    ResponseEntity<Messages> sendMessage(@RequestBody Messages message){


        return new ResponseEntity<>(messagesService.SendMessage(message),HttpStatus.OK);

    }


}
