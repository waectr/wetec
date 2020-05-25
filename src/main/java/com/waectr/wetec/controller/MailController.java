package com.waectr.wetec.controller;

import com.waectr.wetec.response.CommonReturnType;
import com.waectr.wetec.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @Autowired
    private HttpServletRequest httpServletRequest;  //不是单例模式，就是当前用户的http请求

    /*
        邮箱验证
        前端发送 : 键名为email的数据 使用GET请求
        后台返回 ：通用返回类型，成功返回success 数据为空
     */
    @RequestMapping(value = "/getCheckCode",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getCheckCode(@RequestParam(name = "email") String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "欢迎使用小站，您的注册验证码为："+checkCode;
        mailService.sendSimpleMail(email, "注册验证码", message);
        //存储这条验证码信息
        httpServletRequest.getSession().setAttribute(email,checkCode);
        return CommonReturnType.create(null); //向前端返回成功的消息
    }

}
