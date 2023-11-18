package com.example.javaappversion13.Domain;

public class MessageModel {
    private String message ;
    private String UID ;
    private String timeStamp;

    public MessageModel()
    {}


    public MessageModel(String message, String UID, String timeStamp) {
        this.message = message;
        this.UID = UID;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
