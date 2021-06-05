package com.udacity.jwdnd.c1.review.dtos.message;

public class ChatForm {

    private String messageText = "";
    private MessageType messageType;

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
        this.messageText = "";
        this.messageType = MessageType.SAY;
    }
}
