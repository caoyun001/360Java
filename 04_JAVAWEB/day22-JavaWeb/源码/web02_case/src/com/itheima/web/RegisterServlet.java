package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *  处理客户端注册的请求
 *   1: 设置request对象使用的编码表
 *   2: request对象,获取客户端提交的参数 Map<String,String[]>
 *   3: 取出Map集合中的数据
 *     取出6个数据,封装到pojo对象 User
 *   4: 调用业务层方法,传递User对象
 *   5: 注册成功
 *     页面跳转到登录去
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1: 设置request对象使用的编码表
        request.setCharacterEncoding("utf-8");
        //2: request对象,获取客户端提交的参数 Map<String,String[]>
        /**
         * Map集合,键是name属性值,和pojo中User的变量名是一致
         */
        Map<String, String[]> maps = request.getParameterMap();
        //3: 取出Map集合中的数据,封装到pojo对象 User
        User user = new User();
        //apache: 开发工具类 beanutils
        //类BeanUtils,定义静态方法 populate(对象,Map集合)
        //Map集合中的数据,封装到User对象
        try {
            BeanUtils.populate(user, maps);
        }catch (Exception ex){ex.printStackTrace();}

        //4: 调用业务层方法,传递User对象
        UserService service = new UserService();
        service.register(user);
        //5: 页面跳转到登录去  重定向,转发
        //Servlet中,没有数据回传页面,重定向
        response.sendRedirect("/web02_case/login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
