package com.itheima.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyHandlerInterceptor implements HandlerInterceptor {

    //在Controller控制器中的Handler方法执行之前 执行
    //返回值: true, 执行后续的请求(情况一: 执行后续的其他的拦截器; 情况二: 所有的拦截器都执行完毕并放行, 执行Handler方法)
    //返回值: false, 后续的请求代码不再执行 (拦截住了)
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle 执行了 ");

        return true;
    }

    //handler逻辑真正执行完成但尚未返回页面
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 执行了 ");
    }

    //返回页面之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 执行了");
    }
}
