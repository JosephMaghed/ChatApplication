package com.example.chatApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//How to generate value
    @Column(nullable = false,updatable = false)
    private  Long id;
    @NotBlank(message = "Name can not be empty")
    private String name;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must e in the correct format")
    private String email;
    @NotBlank(message = "Please enter your phone number ")
    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;

}
