package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 所有的客户端的用户操作请求
 * 我来实现,方法实现
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端超链接的参数
        String operator = request.getParameter("operator");
        //反射, 获取客户端参数 operator 是方法名
        try {
            Class clazz = this.getClass();
            //获取方法,operator方法名
            Method method =
                    clazz.getMethod(operator,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //方法处理登录
    public void login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("处理登录的方法");
    }

    //方法处理注册
    public void register(HttpServletRequest request, HttpServletResponse response){
        System.out.println("处理注册方法");
    }

    //方法处理改密
    public void updatePassword(HttpServletRequest request, HttpServletResponse response){
        System.out.println("处理修改密码方法");
    }

    public void findPassword(HttpServletRequest request, HttpServletResponse response){
        System.out.println("处理找回密码方法");
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
/**
 *  if("login".equals(operator)){
 login(request, response);
 }else if("register".equals(operator)){
 register(request, response);
 }else if("updatePassword".equals(operator)){
 updatePassword(request, response);
 }*/
