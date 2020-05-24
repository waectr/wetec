package com.waectr.wetec.controller;

import com.waectr.wetec.response.CommonReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("test")
@RequestMapping("/test")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*")
public class TestController {

    @RequestMapping(value = "/test",method = {RequestMethod.GET}) //定义对应的请求方法
    @ResponseBody
    public CommonReturnType Test(){
        return CommonReturnType.create("this is a test controller");
    }
}
