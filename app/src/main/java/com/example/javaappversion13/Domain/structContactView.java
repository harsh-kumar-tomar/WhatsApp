package com.example.javaappversion13.Domain;

public class structContactView {

    int profileImage ;
    String profileName ;
    String profileDescription ;

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

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public structContactView(int profileImage, String profileName, String profileDescription) {
        this.profileImage = profileImage;
        this.profileName = profileName;
        this.profileDescription = profileDescription;
    }
}
