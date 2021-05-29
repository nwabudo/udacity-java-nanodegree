package com.udacity.jwdnd.c1.review.service.impl;

import com.udacity.jwdnd.c1.review.dtos.entity.ChatMessage;
import com.udacity.jwdnd.c1.review.dtos.message.ChatForm;
import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageMapper messageMapper;

    public MessageServiceImpl(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    @Override
    public void addMessage(ChatForm chatForm){
        ChatMessage chatMessage;
        String message = "";
        switch(chatForm.getMessageType().getDisplayValue()){
            case "Say":
                message = chatForm.getMessageText();
                break;
            case "Shout":
                message = chatForm.getMessageText().toUpperCase();
                break;
            case "Whisper":
                message = chatForm.getMessageText().toLowerCase();
                break;
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        chatMessage = new ChatMessage(username, message);
        this.messageMapper.insert(chatMessage);
    }

    @Override
    public List<ChatMessage> getAllChatMessages(String userName){
        return this.messageMapper.getMessages(userName);
    }
}
