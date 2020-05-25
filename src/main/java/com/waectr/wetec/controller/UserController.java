package com.waectr.wetec.controller;


import com.alibaba.druid.util.StringUtils;
import com.waectr.wetec.controller.viewobject.LoginUserInfom;
import com.waectr.wetec.controller.viewobject.UserVO;
import com.waectr.wetec.error.EmOptionException;
import com.waectr.wetec.error.OptionException;
import com.waectr.wetec.response.CommonReturnType;
import com.waectr.wetec.service.UserService;
import com.waectr.wetec.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*") //解决跨域问题,默认是没有办法实现Session共享
//allowCredentials = "true",allowedHeaders = "*"
public class UserController extends BaseController{

    @Autowired
    private HttpServletRequest httpServletRequest;  //不是单例模式，就是当前用户的http请求

    @Autowired
    UserService userService;
    //用户登录

    /*
        用户注册
        前端: 需要传入 code:验证码
                     email：用户邮箱
                     nickname：用户名
                     password：密码
        后台：返回给用户一个完整的除过密码的用户对象，返回格式参照同一返回方式

     */
    @RequestMapping(value = "/register",method = {RequestMethod.POST},consumes = "application/json") //定义对应的请求方法
    @ResponseBody
    public CommonReturnType register(@RequestBody LoginUserInfom loginUserInfom) throws OptionException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //验证手机号和对应的optCode相符合
        String  inSessionOptCode = (String) this.httpServletRequest.getSession().getAttribute(loginUserInfom.getUseremail());//email

        //将两者 进行比对
        if(!com.alibaba.druid.util.StringUtils.equals(loginUserInfom.getCode(),inSessionOptCode)||com.alibaba.druid.util.StringUtils.equals(loginUserInfom.getCode(),"199810")){
            //不相等的时候
            throw new OptionException(EmOptionException.PARAMETER_VALIDATION_ERROR,"验证码错误");
        }

        //1. 封装Service层的用户Model
        UserModel userModel = new UserModel();
        userModel.setUserEmail(loginUserInfom.getUseremail());
        userModel.setUserName(loginUserInfom.getUsername());
        userModel.setUserPassword(EncodeByMd5(loginUserInfom.getPassword()));//做加密处理
        userModel.setUserStatus(1);//可用

        userService.regist(userModel);

        //2. 调用Service层添加方法
        return CommonReturnType.create(null);
    }

    public String EncodeByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //确定一个计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密字符串
        String encode = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return encode;
    }


    /*
        用户登录接口
        前端：传递邮箱email 和密码password
        后台：返回成功表示
            后台在登录成功后会将用户登录状态存到session中LOGIN_USER
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST}) //定义对应的请求方法
    @ResponseBody
    public CommonReturnType login(@RequestBody LoginUserInfom loginUserInfom) throws OptionException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //入参校验
        if(StringUtils.isEmpty(loginUserInfom.getUseremail()) || StringUtils.isEmpty(loginUserInfom.getPassword())){
            throw new OptionException(EmOptionException.PARAMETER_VALIDATION_ERROR);
        }

        //用户登录服务，用来校验用户登录是否合法
        UserModel userModel = userService.validateLogin(loginUserInfom.getUseremail(),EncodeByMd5(loginUserInfom.getPassword()));

        //登录成功的话，将凭证加入到用户的登录成功的session中
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);

        return CommonReturnType.create(null);
    }

    @RequestMapping(value = "/getuserinfo",method = {RequestMethod.GET}) //定义对应的请求方法
    @ResponseBody
    public CommonReturnType getUserInform(@RequestParam(name = "email") String email){
        UserModel userModel=userService.getUserInform(email);
        UserVO userVO=convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if(userModel==null) {
            return null;
        }
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }


    @RequestMapping(value = "/test",method = {RequestMethod.POST},consumes = "application/json") //定义对应的请求方法
    @ResponseBody
    public CommonReturnType Thisisatest(@RequestParam(value = "a") String a){
        System.out.println(a);
        return CommonReturnType.create(null);
    }

     /*
        禁言指定的用户，仅管理员权限
        前端：需要传用户的email，仅管理员可以操作
        后台：禁言并返回消息
     */
    @RequestMapping(value = "/shutupuser",method = {RequestMethod.GET}) //定义对应的请求方法
    @ResponseBody
    public CommonReturnType shutupSomeone(@RequestParam("email") String email) throws OptionException {
        //进行操作者身份检查
        UserModel login_user = (UserModel) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if(login_user.getUserStatus()!=3){
            throw new OptionException(EmOptionException.USER_LOGIN_FAIL,"这里只有管理员才能进来哦");
        }

        //调用下层开始
        userService.changeUserStatusByemail(email,0);
        //返回
        return CommonReturnType.create(null);
    }

    @RequestMapping(value = "/startupSomeone",method = {RequestMethod.GET}) //定义对应的请求方法
    @ResponseBody
    public CommonReturnType startupSomeone(@RequestParam("email") String email) throws OptionException {
        //进行操作者身份检查
        UserModel login_user = (UserModel) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if(login_user.getUserStatus()!=3){
            throw new OptionException(EmOptionException.USER_LOGIN_FAIL,"这里只有管理员才能进来哦");
        }

        //调用下层开始
        userService.changeUserStatusByemail(email,1);
        //返回
        return CommonReturnType.create(null);
    }

    @RequestMapping(value = "/choiceadmin",method = {RequestMethod.GET}) //定义对应的请求方法
    @ResponseBody
    public CommonReturnType choiceadmin(@RequestParam("email") String email) throws OptionException {
        //进行操作者身份检查
        UserModel login_user = (UserModel) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if(login_user.getUserStatus()!=3){
            throw new OptionException(EmOptionException.USER_LOGIN_FAIL,"这里只有管理员才能进来哦");
        }

        //调用下层开始
        userService.changeUserStatusByemail(email,3);
        //返回
        return CommonReturnType.create(null);
    }
}
