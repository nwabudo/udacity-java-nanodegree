package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.dtos.entity.ChatMessage;
import com.udacity.jwdnd.c1.review.dtos.message.ChatForm;

import java.util.List;

public interface MessageService {

    void addMessage(ChatForm chatForm);

    List<ChatMessage> getAllChatMessages(String userName);
}
