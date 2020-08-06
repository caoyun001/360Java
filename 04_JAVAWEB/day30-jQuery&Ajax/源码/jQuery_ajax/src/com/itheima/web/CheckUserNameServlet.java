package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/checkUserName")
public class CheckUserNameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受请求的参数,用户名
        String username = request.getParameter("username");
       //调用业务层,传递用户名,查询结果集,User对象
        UserService service = new UserService();
        User user = service.queryUserByName(username);
        //判断user对象的结果
        if(user == null){
            //没有查询到用户数据,响应true
            response.getWriter().write("true");
        }else {
            //查询到用户数据,响应false
            response.getWriter().write("false");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
