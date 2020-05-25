package com.waectr.wetec.service;

import com.github.pagehelper.Page;
import com.waectr.wetec.error.OptionException;
import com.waectr.wetec.service.model.UserModel;

/*
    定义用户操作的一系列接口
 */
public interface UserService {

    //用户注册 传入Service的视图模型（在控制层构造好）
    void regist(UserModel userModel) throws OptionException;

    UserModel validateLogin(String email, String passwor) throws OptionException;

    UserModel getUserInform(String email);

    //改变用户状态列，指定用户指定数字
    void changeUserStatusByemail(String email,int changenum);

    Page<UserModel> getUserList(Integer pageNum, Integer pageSize);
}
