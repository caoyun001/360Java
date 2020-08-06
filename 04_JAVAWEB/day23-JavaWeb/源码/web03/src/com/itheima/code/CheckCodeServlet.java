package com.itheima.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/checkCode")
public class CheckCodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 进行验证码的校验
         * 客户端提交验证码,获取 request.getParameter()  ==字符串
         * 从session域中,获取验证码
         */
        //客户端提交验证码,获取 request.getParameter()
        String code = request.getParameter("code");
        //session域中,取出验证码
        String sessionCode = (String) request.getSession().getAttribute("code");
        if(sessionCode.equalsIgnoreCase(code)){
            response.getWriter().write("code OK");
        }else {
            response.getWriter().write("code NO OK");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
