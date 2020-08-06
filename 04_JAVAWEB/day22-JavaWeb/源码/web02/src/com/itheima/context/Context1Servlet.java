package com.itheima.context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  ServletContext对象 (Servlet上下文对象)
 *  接口: ServletContext
 *  接口实现类对象 Tomcat启动的时候,已经创建好了,获取使用
 *  获取方式简单:
 *    父类的父类中,定义方法  public ServletContext getServletContext()
 *    继承关系,直接调用即可
 *      org.apache.catalina.core.ApplicationContextFacade@3759bbab
 *
 *   作用; ServletContext的作用
 *   就是Web应用程序对象,描述的是整个web程序
 *   每个应用程序只有一个对象
 *
 *   原理: Tomcat服务器会在启动的时候扫描 webapps
 *   找所有的Web程序,每个web程序 ,创建对象ServletContext
 *
 */
public class Context1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context =  getServletContext();
        System.out.println(context);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
