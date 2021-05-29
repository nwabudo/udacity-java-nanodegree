package com.udacity.jdnd.course1.dto.message;

import java.util.Date;

public class ChatMessage {
    private String username;
    private String messageText;
    private String time;

    public ChatMessage(String username, String messageText) {
        this.username = username;
        this.messageText = messageText;
        this.time = new Date().toString();
    }

    public ChatMessage() {}

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
