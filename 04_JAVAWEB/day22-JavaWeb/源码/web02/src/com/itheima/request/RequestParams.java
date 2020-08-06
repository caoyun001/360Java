package com.itheima.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 *  request获取表单参数,不分GET还是POST
 *    String getParameter("表单中name属性值"); 获取表单参数
 *    String[] getParameterValues("表单中name属性值"); 获取表单参数,一个键对应多个值 checkbox
 *    Map<String,String[]> getParameterMap();获取所有的表单参数
 *      键: 就是表单的name属性值
 *      值: 客户在页面中填写的值
 */
@WebServlet(urlPatterns = "/params")
public class RequestParams extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String getParameter("表单中name属性值"); 获取表单参数
        String user = request.getParameter("user");
        System.out.println(user);

        //String[] getParameterValues("表单中name属性值"); 获取表单参数,一个键对应多个值 checkbox
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        System.out.println("========");

        //Map<String,String[]> getParameterMap();获取所有的表单参数
        Map<String,String[]> maps =  request.getParameterMap();
        for(String key : maps.keySet()){
            System.out.println(key+"::"+ Arrays.toString(maps.get(key))  );
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
