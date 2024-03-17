package com.example.chatApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "conversations")
public class Conversation {
    @Id
    @Column(nullable = false,updatable = false)
    private final Long id;
    @NotBlank(message="Conversation date cannot be blank")
    private Date finalMessageDate;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "senderId")  // Name of the foreign key column
    private final UserModel firstSender;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "senderId")  // Name of the foreign key column
    private final UserModel secondSender;
}
