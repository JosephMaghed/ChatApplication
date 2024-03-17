package com.example.chatApplication.controller;

import com.example.chatApplication.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
@Autowired
    UserRepo userRepo;

}
