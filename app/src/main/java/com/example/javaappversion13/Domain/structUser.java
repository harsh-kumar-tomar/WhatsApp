package com.example.javaappversion13.Domain;

public class structUser {

    String UserProfilePicPath ;
    String UserName ;
    String UserMail ;
    String UserPassword ;
    String UserId ;

    public structUser(String userProfilePicPath, String userName, String userMail, String userPassword, String userId) {
        UserProfilePicPath = userProfilePicPath;
        UserName = userName;
        UserMail = userMail;
        UserPassword = userPassword;
        UserId = userId;
    }

    public structUser ()
    {

    }
        //sign up constructor
    public  structUser (String userName , String userMail , String userPassword)
    {
        UserName = userName;
        UserMail = userMail;
        UserPassword = userPassword;
    }

    public String getUserProfilePicPath() {
        return UserProfilePicPath;
    }

    public void setUserProfilePicPath(String userProfilePicPath) {
        UserProfilePicPath = userProfilePicPath;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String userMail) {
        UserMail = userMail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
