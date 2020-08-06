package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  处理客户端登录的请求
 *  用户名密码, tom 123
 *  登录验证
 *    登录成功,页面跳转到 resource/welcome.jsp
 *    登录信息存储到session域
 *
 *    登录失败,回到登录页面去
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("tom".equals(username) && "123".equals(password)){
            //登录成功,用户名存储在session
            request.getSession().setAttribute("username",username);
            //页面跳转到 resource/welcome.jsp
            //重定向,需要写web应用名称
            response.sendRedirect(request.getContextPath()+"/resource/welcome.jsp");
        }else{
            //登录失败
            //回到登录页面,告知用户登录失败,request域存储登录失败的信息
            request.setAttribute("message","登录失败,用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
