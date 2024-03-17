package com.example.chatApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="messages")
public class Messages {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//How to generate value
    @Column(nullable = false,updatable = false)
    private final Long id;
    @NotBlank(message = "Cannot send an empty message")
    private final String message;
}
