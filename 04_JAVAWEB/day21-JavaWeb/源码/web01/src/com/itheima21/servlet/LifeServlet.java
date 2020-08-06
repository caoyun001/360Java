package com.itheima.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet对象的生命周期
 * 对象什么时候生,什么时候死
 * 什么时候被创建,什么时候被销毁
 *
 *  1: 对象创建
 *    Servlet对象什么时候被创建
 *    默认: 在客户端第一次访问的时候,对象会被创建
 *    Servlet中有方法 init(),对象创建的时候,会调用init()方法
 *    Tomcat引擎调用方法init()传递参数ServletConfig
 *
 *    在Tomcat启动的时候创建!!  web.xml  <load-on-startup>整数越小,启动优先级越高</load-on-startup>
 *
 *  2: 客户端访问
 *    客户端每次请求Servlet,都会执行方法service
 *    只要有1个请求,就会执行一次
 *
 *  3: 对象销毁
 *    Tomcat服务器关闭的时候,销毁对象
 *    Tomcat引擎调用方法 destroy()
 *
 *    LifeServlet类对象,对象销毁前调用
 *
 *    将你的web项目,从Tomcat的 webapps中移除
 *
 */
public class LifeServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("对象被创建");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("生命周期");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("对象被销毁");
    }
}
