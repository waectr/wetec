package com.waectr.wetec.handler;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
//        if(request.getSession().getAttribute("user")==null){
//            //TODO
//            response.sendRedirect("/admin");//TODO
//            return false;
//        }else {
            return super.preHandle(request,response,handler);
//        }
    }
}
