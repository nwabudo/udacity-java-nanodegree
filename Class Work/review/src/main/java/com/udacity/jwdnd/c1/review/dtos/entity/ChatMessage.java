package com.udacity.jwdnd.c1.review.dtos.entity;

import java.util.Date;

public class ChatMessage {
    private Integer messageId;
    private String username;
    private String messageText;
    private String time;

    public ChatMessage(String username, String messageText) {
        this.username = username;
        this.messageText = messageText;
        this.time = new Date().toString();
    }

    public ChatMessage() {

    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
