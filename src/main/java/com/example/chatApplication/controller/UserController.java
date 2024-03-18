package com.example.chatApplication.controller;

import com.example.chatApplication.Repo.UserRepo;
import com.example.chatApplication.model.User;
import com.example.chatApplication.service.ConversationService;
import com.example.chatApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserService userService;
    private final ConversationService conversationService;

    public UserController(UserService userService, ConversationService conversationService) {
        this.userService = userService;
        this.conversationService = conversationService;
    }

    @PostMapping("/signUp")
    ResponseEntity<User>SignUp(@RequestBody User newUser){
        return new ResponseEntity<>(userService.addUser(newUser),HttpStatus.OK);

    }

   @GetMapping("/search")
    ResponseEntity<Optional<List<User>>>SearchByUerName(@RequestBody User search){
return new ResponseEntity<>(userService.findUserByUserName(search),HttpStatus.OK);
    }

}

