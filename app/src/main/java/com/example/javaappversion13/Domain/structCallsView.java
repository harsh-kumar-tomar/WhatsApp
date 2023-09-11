package com.example.javaappversion13.Domain;

public class structCallsView {

    private int profileImage ;
    private String profileName ;
    private String DateTime ;


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

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public structCallsView(int profileImage, String profileName, String dateTime) {
        this.profileImage = profileImage;
        this.profileName = profileName;
        DateTime = dateTime;
    }

}
