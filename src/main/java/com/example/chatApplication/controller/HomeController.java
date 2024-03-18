package com.example.chatApplication.controller;

import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.model.User;
import com.example.chatApplication.service.ConversationService;
import com.example.chatApplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Home")
public class HomeController {
    private final UserService userService;
    private final ConversationService conversationService;

    public HomeController(UserService userService, ConversationService conversationService) {
        this.userService = userService;
        this.conversationService = conversationService;
    }

    //Get user data
    @GetMapping("/{id}")
    ResponseEntity<User> getUserDataById(@PathVariable("id")Long id){
        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);

    }

    //Update user data
    @PutMapping("/update/{id}")
    public ResponseEntity<User>getConversations(@PathVariable("id")Long id,@RequestBody User updatedUser){
        return new ResponseEntity<>(userService.updateUser(id),HttpStatus.OK);
    }

    //Get all conversations associated with user
    @GetMapping("/conversations/{id}")
    public ResponseEntity<List<Conversation>> getConversations(@PathVariable("id")Long id){
        return new ResponseEntity<>(conversationService.findConversationByUserId(id), HttpStatus.OK);
    }
}
