package com.example.chatApplication.Repo;

import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.model.Messages;
import com.example.chatApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConversationsRepo extends JpaRepository<Conversation,Long> {
    @Query("SELECT c FROM Conversation c WHERE c.firstSender = :id OR c.secondSender = :id order by finalMessageDate desc")
  public  List<Conversation>findConversations(User id);
    @Query("SELECT c FROM Conversation c WHERE c.firstSender = :firstId OR c.secondSender = :firstId AND c.firstSender = :secondId OR c.secondSender = :secondId")
    public  Conversation findConversationsByTwoSenders(User firstId,User secondId);
}
