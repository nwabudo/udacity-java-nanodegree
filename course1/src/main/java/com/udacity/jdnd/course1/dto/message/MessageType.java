package com.udacity.jdnd.course1.dto.message;

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
