package com.example.chatApplication.Repo;

import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MessagesRepo extends JpaRepository<Messages,Long> {

    @Query("SELECT c FROM Messages c WHERE c.conversationId = :id order by messageDate desc")

    Optional<List<Messages>> findAllByConversationId(Optional<Conversation> id);
}
