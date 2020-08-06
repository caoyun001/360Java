package com.itheima.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  IDEA工具创建出的Servlet
 *  包含2个方法
 *    doPost : 处理客户端的POST请求方式
 *    doGet  : 处理客户端的GET请求方式
 *
 *    Servlet接口,是Sun公司标准
 *    Tomcat引擎调用该接口实现类的方法 service
 *
 *    MyHttpServlet肯定是Servlet接口实现类
 *    MyHttpServlet继承HttpServlet
 *    HttpServlet继承GenericServlet
 *    GenericServlet实现接口Servlet
 *
 *    结论:
 *      客户端请求服务器的时候,Tomcat引擎创建MyHttpServlet对象,调用方法service()
 *      来自于父类的继承,而父类中的service()调用回到我们自己的方法doGet()
 *
 *
 *    无论什么请求方式,都用一个方法来处理
 */
public class MyHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //调用doGet()
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
    }
}
