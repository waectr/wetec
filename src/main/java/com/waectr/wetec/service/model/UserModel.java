package com.waectr.wetec.service.model;

//Service层的用户模型
public class UserModel {

    private Integer userId;

    private String userName;

    private Integer userPasswordId;

    private Integer userStatus;

    private String userEmail;

    private String userPassword;

    public UserModel(){
    }

    public UserModel(Integer userId, String userName, Integer userPasswordId, Integer userStatus, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPasswordId = userPasswordId;
        this.userStatus = userStatus;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserPasswordId() {
        return userPasswordId;
    }

    public void setUserPasswordId(Integer userPasswordId) {
        this.userPasswordId = userPasswordId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
