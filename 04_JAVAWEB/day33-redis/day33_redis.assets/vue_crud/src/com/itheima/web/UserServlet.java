package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserService service = new UserService();
    private ObjectMapper mapper = new ObjectMapper();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取客户端请求参数
         * 反射调用相关方法
         */
        try{
            response.setContentType("text/html;charset=utf-8");
            String operator = request.getParameter("operator");
            System.out.println();
            Class clazz = this.getClass();
            Method method = clazz.getMethod(operator, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 删除用户数据
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.delete(id);
        response.getWriter().write("删除成功");
    }
    /**修改的请求
     * */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端请求的数据,(json)
        InputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        //读取到数组变成字符串
        String json = new String( bytes,0,len,"utf-8" );
        //json转成User对象
        User user = mapper.readValue(json, User.class);
        service.update(user);
        response.getWriter().write("修改成功");
    }
    /**
     *  修改数据之前的回显
     */
    public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = service.findById(id);
        response.getWriter().write(mapper.writeValueAsString(user));
    }
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 用户注册,新增
         * 获取客户端请求的参数
         * name,money 传递业务层,写入数据库
         *
         * 注意: 客户端请求的数据格式是json格式  {"name":"张三","money":"10000"} 对象,对象中有2个键
         * request对象的方法 getParameter,getParameterValues(), getParameterMap() 全部失去意义
         * 只能获取 k=v&k=v
         *
         * 客户端和服务器通信: 无论请求的数据是什么,IO流实现
         * request.getInputStream 字节输入流
         */
        InputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String json = new String(bytes,0,len,"utf-8");//{"name":"张三","money":"10000"}
        //json数据转成User对象
        User user = mapper.readValue(json, User.class);
        //调用业务层传递 user对象
        service.register(user);
        response.getWriter().write("添加成功");

    }
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 调用业务层,获取数据集合
         * 转成json响应
         */
        List<User> userList = service.findAll();
        String json = mapper.writeValueAsString(userList);
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
