package com.example.chatApplication.service;

import com.example.chatApplication.Repo.ConversationsRepo;
import com.example.chatApplication.Repo.UserRepo;
import com.example.chatApplication.exception.UserNotFoundException;
import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ConversationService {
    //Constructor with the necessary repo instances
    private final ConversationsRepo conversationRepo;

    private final UserRepo userRepo;
    public ConversationService(ConversationsRepo conversationRepo, UserRepo userRepo) {
        this.conversationRepo = conversationRepo;
        this.userRepo = userRepo;
    }

   //A new conversation is created when two users exchange messages for the first time
    public Conversation addConversation(Conversation conversation){
       return conversationRepo.save(conversation);
    }
    Optional<Conversation> findConversationById(Long id){
      return   conversationRepo.findById(id);

    }

    //Mainly used to update the date for the final message
    //Final date is used to arrange the conversations
    Conversation updateConversation(Conversation conversation){
        return conversationRepo.save(conversation);
    }

    //Get conversations by date in descending order
    public List<Conversation> findConversationByUserId(Long id){
        //Search for user by id
        User user=userRepo.findById(id).orElse(null);
        return conversationRepo.findConversations(user);
    }

    //Search a conversation if exists between two users
    public Conversation findByTwoSenders(User fisrtUser,User secondUser){

        return conversationRepo.findConversationsByTwoSenders(fisrtUser,secondUser);
    }

}
