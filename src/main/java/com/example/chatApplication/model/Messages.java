package com.example.chatApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name="messages")
public class Messages {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//How to generate value
    @Column(nullable = false,updatable = false)
    private  Long id;

    @NotBlank(message = "Cannot send an empty message")
    private  String message;

    //Since one sender can send many messages
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "senderId")  // Name of the foreign key column

    private  User sender;

    //Assuming the scenario where one message can be forwarded to many receiver
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverId")  // Name of the foreign key column
    private User receiver;

    @NotBlank(message = "Date cannot be blank")
    private final Date messageDate;
}
