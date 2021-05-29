package com.udacity.jwdnd.c1.review.dtos.message;

public enum MessageType {
    SAY("Say"),
    SHOUT("Shout"),
    WHISPER("Whisper");

    private final String displayValue;

    private MessageType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
