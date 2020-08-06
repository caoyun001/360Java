package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author likepei
 * @data 2019/7/16 9:53
 * @description 给浏览器响应 安检后的物品数据
 */
@WebServlet("/safe")
public class SafeResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从域中, 获取Filter 过滤通过的物品, 把这个物品 响应回 浏览器
        //Object list = request.getAttribute("list");
        response.getWriter().print( "违禁品已没收, 安检通过的物品清单:" + request.getAttribute("list") );

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
