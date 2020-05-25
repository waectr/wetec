package com.waectr.wetec.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.waectr.wetec.dao.PasswordDOMapper;
import com.waectr.wetec.dao.UserDOMapper;
import com.waectr.wetec.dataobject.PasswordDO;
import com.waectr.wetec.dataobject.UserDO;
import com.waectr.wetec.error.EmOptionException;
import com.waectr.wetec.error.OptionException;
import com.waectr.wetec.response.CommonReturnType;
import com.waectr.wetec.service.UserService;
import com.waectr.wetec.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UserDOMapper userDOMapper;

    @Autowired
    PasswordDOMapper passwordDOMapper;

    @Override
    public void regist(UserModel userModel) throws OptionException {
        //1、检验数据是否为空
        if(userModel.getUserEmail()==null||userModel.getUserName()==null
                ||userModel.getUserPassword()==null){
            throw new OptionException(EmOptionException.PARAMETER_VALIDATION_ERROR,"传入的字段有空");
        }
        //检查用户名是否重复
        UserDO userchekDO = userDOMapper.selectByEmail(userModel.getUserEmail());
        if(userchekDO!=null){
            throw new OptionException(EmOptionException.PARAMETER_VALIDATION_ERROR,"该邮箱已经被注册");
        }
        //2.构建UserDO passwordDO
        PasswordDO passwordDO = new PasswordDO();
        passwordDO.setPasswordContext(userModel.getUserPassword());

        UserDO userDO=UserModeltoUserDO(userModel);
        //3.创建密码
        passwordDOMapper.insertSelective(passwordDO);//用这个方法添加后会返回主键
        userDO.setUserPasswordId(passwordDO.getPasswordId());//插入对应id

        //4.添加用户
        userDOMapper.insertSelective(userDO);//插入用户信息

        return;
    }

    @Override
    public UserModel validateLogin(String email, String password) throws OptionException {
        //获取用户信息
        UserDO userDO = userDOMapper.selectByEmail(email);
        if(userDO==null){
            throw new OptionException(EmOptionException.USER_LOGIN_FAIL);
        }
        PasswordDO userPasswordDO = passwordDOMapper.selectByPrimaryKey(userDO.getUserPasswordId());
        UserModel userModel=convertFromDataObject(userDO,userPasswordDO);

        //进行密码比对
        if(!StringUtils.equals(password,userModel.getUserPassword())){
            throw new OptionException(EmOptionException.PARAMETER_VALIDATION_ERROR);
        }
        return userModel;
    }

    @Override
    public UserModel getUserInform(String email) {
        UserDO userDO = userDOMapper.selectByEmail(email);
        UserModel userModel = convertFromDataObject(userDO, null);
        return userModel;
    }

    //改变用户的状态
    @Override
    public void changeUserStatusByemail(String email, int changenum) {
        int i = userDOMapper.updateStatusByEmail(email, changenum);
        return;
    }

    private UserModel convertFromDataObject(UserDO userDO, PasswordDO userPasswordDO) {
        if(userDO==null) {
            return null;
        }

        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        if(userPasswordDO!=null) {
            userModel.setUserPassword(userPasswordDO.getPasswordContext());
        }

        return userModel;
    }

    //将用户的服务层模型转为持久层模型
    private UserDO UserModeltoUserDO(UserModel userModel) {
        if(userModel==null){
            return null;
        }

        UserDO userDO=new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;
    }


}
