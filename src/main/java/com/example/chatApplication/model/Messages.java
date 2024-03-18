package com.example.chatApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name="messages")
@NoArgsConstructor(force = true)
public class Messages {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//How to generate value
    @Column(nullable = false,updatable = false)
    private  Long id;

    @NotBlank(message = "Cannot send an empty message")
    private  String message;

    //Since one sender can send many messages
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "senderId",nullable = false,updatable = false)  // Name of the foreign key column

    private  User sender;

    //Assuming the scenario where one message can be forwarded to many receiver
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverId",nullable = false,updatable = false)  // Name of the foreign key column
    private User receiver;

    @ManyToOne
    private Conversation conversationId;

    private  LocalDate messageDate;
}
