package com.example.chatApplication.controller;

import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.service.ConversationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/Home")
public class ConversationController {
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    ConversationService conversationService;



}
