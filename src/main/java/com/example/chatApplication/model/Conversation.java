package com.example.chatApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    //To display conversations by date
    private LocalDate finalMessageDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_sender_id",nullable = false,updatable = false)  // Name of the foreign key column

    private User firstSender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_sender_id",nullable = false,updatable = false)  // Name of the foreign key column

    private User secondSender;

}
