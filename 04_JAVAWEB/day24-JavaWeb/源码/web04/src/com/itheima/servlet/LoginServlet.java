package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理记住用户名操作
 *  1: 用户名密码的验证
 *  2: 记录用户名
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("tom".equals(username) && "123".equals(password)){
            response.getWriter().write("login OK");
        }else{
            response.getWriter().write("login NO");
        }
        //2: 记录用户名
        //判断是否勾选复选框,获取复选框的value值
        String rem =  request.getParameter("rem"); //remUsername
        System.out.println(rem);
        if(rem != null){
            //勾选记住用户名
            Cookie cookie = new Cookie("user",username);
            cookie.setMaxAge(60*10);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
