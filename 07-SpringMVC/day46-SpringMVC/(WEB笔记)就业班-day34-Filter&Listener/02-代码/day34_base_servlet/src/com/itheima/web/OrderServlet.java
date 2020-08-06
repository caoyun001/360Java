package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {
    //private OrderService service = new OrderService();

    //添加订单
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet add");

    }
    //删除订单
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet delete");
    }
    //查找订单
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //查找分页订单
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet findByPage");
    }
}

/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String md = request.getParameter("method");
            //1. 反射的方式,找到要执行的方法
            System.out.println("this对象 = " + this);

            Class clazz = this.getClass();
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            //2. 反射的方式, 执行方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

       *//*
        if ("add".equals(md)) {
            add(request, response); //调用添加订单
        } else if ("delete".equals(md)) {
            delete(request, response); //调用删除订单
        } else if ("findAll".equals(md)) {
            findAll(request, response); //调用查找商品
        }
        *//*
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    */

