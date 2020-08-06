package com.itheima.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局的异常处理器
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest 请求对象
     * @param httpServletResponse 响应对象
     * @param handler 产生异常的处理器方法
     * @param exception 具体产生了什么异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception exception) {
        //给程序员看的错误信息
        System.out.println("exception = " + exception);
        System.out.println("handler = " + handler);
        
        //给客户看的异常友好页面
        ModelAndView modelAndView = new ModelAndView();
        //设置错误提示信息
        modelAndView.addObject("message", "亲~~, 服务器更新中, 请稍后再试");
        //设置错误显示的页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
