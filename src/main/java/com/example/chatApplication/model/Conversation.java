package com.example.chatApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "conversations")
public class Conversation {
    @Id
    @Column(nullable = false,updatable = false)
    private final Long id;
}
