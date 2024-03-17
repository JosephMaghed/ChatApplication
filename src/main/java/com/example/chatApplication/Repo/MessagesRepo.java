package com.example.chatApplication.Repo;

import com.example.chatApplication.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepo extends JpaRepository<Messages,Long> {
}
