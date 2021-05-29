package com.udacity.jdnd.course1.dto.message;

public class ChatForm {

    private String username = "";
    private String messageText = "";
    private MessageType messageType;

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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public void nilOffForm(){
        this.username = "";
        this.messageText = "";
        this.messageType = MessageType.SAY;
    }
}
