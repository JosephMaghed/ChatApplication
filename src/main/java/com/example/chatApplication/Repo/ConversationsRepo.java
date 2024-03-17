package com.example.chatApplication.Repo;

import com.example.chatApplication.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationsRepo extends JpaRepository<Conversation,Long> {
}
