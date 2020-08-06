package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/product")
public class ProductServlet extends BaseServlet {
    //添加商品
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet add ");
    }
    //删除商品
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet delete");
    }
    //更新商品
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //查询商品
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //分页查询商品
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


       if ("add".equals(md)) {
            add(request, response); //调用添加商品
        } else if ("delete".equals(md)) {
            delete(request, response); //调用删除商品
        } else if ("update".equals(md)) {
            update(request, response); //调用更新商品
        } else if ("findAll".equals(md)) {
            findAll(request, response); //调用查找商品
        } else if ("findByPage".equals(md)) {
            findByPage(request, response); //分页查询商品
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
*/
