package com.waectr.wetec.controller.viewobject;

//用户前端交互层
public class UserVO {

    //用户ID
    private Integer userId;

    //用户名
    private String userName;

    /*用户登录状态
        0表示账号无法使用
        1表示账号正常使用
        3管理员
    */
    private Integer userStatus;

    /*
        用户邮箱
     */
    private String userEmail;

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
