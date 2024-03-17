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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Conversation date cannot be blank")
    private Date finalMessageDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_sender_id")  // Name of the foreign key column
    private User firstSender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_sender_id")  // Name of the foreign key column
    private User secondSender;

}
