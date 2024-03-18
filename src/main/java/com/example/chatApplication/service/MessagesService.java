package com.example.chatApplication.service;

import com.example.chatApplication.Repo.ConversationsRepo;
import com.example.chatApplication.Repo.MessagesRepo;
import com.example.chatApplication.Repo.UserRepo;
import com.example.chatApplication.model.Conversation;
import com.example.chatApplication.model.Messages;
import com.example.chatApplication.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class MessagesService {

    //Constructor with necessary instances
    private final MessagesRepo messagesRepo;
    private final UserService userService;
    private final ConversationService conversationService;

    public MessagesService(MessagesRepo messagesRepo, UserService userService, ConversationService conversationService) {
        this.messagesRepo = messagesRepo;
        this.userService = userService;
        this.conversationService = conversationService;
    }



    //Send a message
    public Messages SendMessage(Messages messages){
        //Get local date
        LocalDate today = LocalDate.now();
        messages.setMessageDate(today);

        //Search the conversation between the two senders if exists & if it does not exist create new record
        Conversation searchedConversation=conversationService.
                findByTwoSenders(userService.findUserById(messages.getSender().getId()) //Sender as first user
                        ,userService.findUserById(messages.getReceiver().getId()));//Receiver as second user

        //Check if the conversation exists
        if(searchedConversation==null){//If it does not create a new one & attach its parameters
            //Two senders id is attached
            searchedConversation.setFirstSender(userService.findUserById(messages.getSender().getId()));
            searchedConversation.setSecondSender(userService.findUserById(messages.getReceiver().getId()));

            //Date of the final message
            searchedConversation.setFinalMessageDate(today);

            //Add the conversation & add it as a foreign key in the message record
            conversationService.addConversation(searchedConversation);
            messages.setConversationId(searchedConversation);
        }else {
            //If it does exist simply add it as a foreign key in the message record
            messages.setConversationId(
                    conversationService.
                            findByTwoSenders(userService.findUserById(messages.getSender().getId()),//Second user
                                    userService.findUserById(messages.getReceiver().getId())));//First user
        }
        //Set receiver as first user
       messages.setReceiver(userService.findUserById(messages.getReceiver().getId()));
      //Set sender as second user
       messages.setSender(userService.findUserById(messages.getSender().getId()));
       messagesRepo.save(messages);
        return messages;
    }

    void deleteMessage(Long id){
        messagesRepo.deleteById(id);
    }
    void updateMessage(Long id){
        messagesRepo.deleteById(id);
    }

    //Retrieve all messages in a given conversation
    public Optional<List<Messages>>findMessagesByConversationId(Long id){
        return messagesRepo.findAllByConversationId(conversationService.findConversationById(id));
    }

}

