package com.example.javaappversion13.Domain;

public class structChatView {

    private int profileImage ;
    private String profileName ;
    private String profileLastMessage ;
    private String profileLastSeen ;

    public structChatView(int profileImage, String profileName, String profileLastMessage, String profileLastSeen)
    {
        this.profileImage = profileImage ;
        this.profileName = profileName ;
        this.profileLastMessage = profileLastMessage ;
        this.profileLastSeen = profileLastSeen ;

    }


    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileLastMessage() {
        return profileLastMessage;
    }

    public void setProfileLastMessage(String profileLastMessage) {
        this.profileLastMessage = profileLastMessage;
    }

    public String getProfileLastSeen() {
        return profileLastSeen;
    }

    public void setProfileLastSeen(String profileLastSeen) {
        this.profileLastSeen = profileLastSeen;
    }
}