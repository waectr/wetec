package com.waectr.wetec.controller.viewobject;

/*
创建一个类来接收
 */
public class LoginUserInfom {
    //用户名
    private String username;

    /*
        用户邮箱
     */
    private String useremail;

    private String code;

    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
