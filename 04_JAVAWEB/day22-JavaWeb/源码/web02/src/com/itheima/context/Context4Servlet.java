package com.itheima.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  ServletContext对象,域对象
 *  是个容器,存储数据
 *  作用域:
 *    最大的一个作用域,在ServletContext对象中,存储的任何数据
 *    在整个Web应用程序中,全有效
 *
 *  域对象的方法  (JavaWeb中包含的4个域对象):
 *    void setAttribute(String key, Object value)键值对存储在域对象
 *    Object getAttribute(String key)取出键对应的值
 *    void removeAttribute(String key)移除键值对
 */
public class Context4Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        //域对象存储键值对
        context.setAttribute("java","heima");
        //取出域对象中的数据
        Object o = context.getAttribute("java");
        System.out.println(o);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
