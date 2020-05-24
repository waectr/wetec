package com.waectr.wetec.controller;


import com.waectr.wetec.error.EmOptionException;
import com.waectr.wetec.error.OptionException;
import com.waectr.wetec.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
//用于拦截错误
public class BaseController {

    public static final String CONTENT_TYPE_FORMED="application/x-www-form-urlencoded";
    //定义excptionHandler解决违背controller层吸收的exception
    @ExceptionHandler(Exception.class) //指定，当出现Exception这个异常的时候就执行相关的代码
    @ResponseStatus(HttpStatus.OK)  //让他以正常的状态返回
    @ResponseBody
    public CommonReturnType handlerException(HttpServletRequest request, Exception ex){
        ex.printStackTrace();
        Map<String, Object> responseData = new HashMap<>();
        if(ex instanceof OptionException) {
            OptionException optionException = (OptionException) ex;
            responseData.put("errCode", optionException.getErrCode());
            responseData.put("errMsg", optionException.getErrMsg());
            return CommonReturnType.create(responseData, "fail");
        }else {
            responseData.put("errCode",EmOptionException.UNKNOWN_ERROR);
            responseData.put("errMsg", EmOptionException.UNKNOWN_ERROR.getErrMsg());
            return CommonReturnType.create(responseData, "fail");
        }
    }
}
