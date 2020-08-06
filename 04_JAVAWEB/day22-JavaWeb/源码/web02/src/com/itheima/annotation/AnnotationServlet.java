package com.itheima.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet程序的注解开发
 * 注解取代配置
 * Servlet版本3.0以后,有的注解开发
 * 注解 @WebServlet  写在类上
 * 注解属性 String[] urlPatterns() default {};
 * 数组赋值一个
 *
 * 原理: Tomcat引擎启动的时候,读取 web.xml
 * 会扫描你的所有Servlet接口实现类,获取类上的注解
 * 获取注解值  /annotation,浏览器的访问地址
 */
@WebServlet(urlPatterns = "/annotation")
public class AnnotationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("欢迎使用注解开发");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
