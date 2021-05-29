package com.udacity.jdnd.course1.service;

import com.udacity.jdnd.course1.dto.message.ChatForm;
import com.udacity.jdnd.course1.dto.message.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> chatMessages;

    public boolean addMessage(ChatForm chatForm) {
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
        chatMessage = new ChatMessage(chatForm.getUsername(), message);
        return this.chatMessages.add(chatMessage);
    }

    public List<ChatMessage> getAllChatMessages(){
        return this.chatMessages;
    }

    @PostConstruct
    public void postConstruct() {
        chatMessages = new ArrayList<>();
    }
}
