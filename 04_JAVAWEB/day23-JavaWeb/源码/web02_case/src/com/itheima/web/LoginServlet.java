package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  客户端登录请求的Servlet
 *  1: 获取客户端提交参数, 用户名 密码
 *  2: 调用业务层的方法 ,传递用户名,密码
 *  3: 获取业务层返回的查询结果集  User对象
 *  4: 判断User对象
 *     == null 登录失败的响应
 *
 *     != null 登录成功的响应
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1: 获取客户端提交参数, 用户名 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2: 调用业务层的方法 ,传递用户名,密码
        UserService userService = new UserService();
        //3: 获取业务层返回的查询结果集  User对象
        User user = userService.login(username, password);
        //4: 判断User对象
        if(user == null){
            //登录失败的响应
            //响应的页面,还是登录页面
            String message = "用户名或者密码错误";//提示信息,显示在客户端浏览器上
            //数据存在到request域中
            request.setAttribute("message",message);
            //响应回原来的登录页面,重定向还是转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //用户信息存在session域对象,目的,不关闭浏览器,走到任何页面,都能展示用户名
            request.getSession().setAttribute("user",user);

            //登录成功的响应,页面跳转到首页,重定向还是转发
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
