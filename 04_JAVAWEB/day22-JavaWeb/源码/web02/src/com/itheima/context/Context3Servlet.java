package com.itheima.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext对象的方法:
 *    String getRealPath(String path)
 *    方法: 可以获取到Web应用程序下,任何资源的绝对路径
 *    参数传递的是相对路径,返回绝对路径
 *
 *   ServletContext对象:表示整个web应用程序
 */
public class Context3Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        //获取到a.txt文件的绝对路径,参数写的是a.txt文件相对路径
        //怎么写相对路径, 相对的是谁
        //context对象相对的是web应用程序  web02
        String aPath = context.getRealPath("a.txt");
        System.out.println(aPath);

        //获取到b.txt的绝对路径
        String bPath = context.getRealPath("WEB-INF/b.txt");
        System.out.println(bPath);

        // 获取到c.txt的绝对路径
        String cPath = context.getRealPath("WEB-INF/classes/c.txt");
        System.out.println(cPath);

        // 获取到d.txt的绝对路径
        //IDEA工程下的文件,不会发布在Tomcat,获取不到
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
