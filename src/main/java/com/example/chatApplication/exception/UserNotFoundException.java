package com.example.chatApplication.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
    super(message);
    }
}
