package com.itheima.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取当前拦截的请求URL信息
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        //2. 如果当前请求是 登录请求,拦截器放行,可以登录  requestURI = /default/login.do
        if("/default/login.do".equals(requestURI)){
            //登录请求,拦截器放行,可以登录
            return true;
        }
        //3.如果当前用户 已经登录, 用户执行的操作 都放行
        //根据Session域中的用户名是否为null, 来判断当前是否已登录
        Object username = request.getSession().getAttribute("username");
        if(username == null){
            //用户未登录, 本次请求不放行, 跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/index.html");
            return false;
        } else {
            //用户已登录, 放行请求, 正常执行
            return true;
        }
    }

}
