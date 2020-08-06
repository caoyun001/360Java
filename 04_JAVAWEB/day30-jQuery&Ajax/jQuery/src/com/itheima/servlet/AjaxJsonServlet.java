package com.itheima.servlet;

import com.itheima.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajaxJson")
public class AjaxJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("name"));
        /**
         * 使用pojo对象,数据取出,转成json响应
         */
       // Student s = new Student("jack",15);
        //s对象的数据转成json
        //转成对象  {  "name":"jack","age":15 }
        String json = "{ \"name\":\"jack\",\"age\":15  }";
        response.getWriter().write(json);
    }
}
