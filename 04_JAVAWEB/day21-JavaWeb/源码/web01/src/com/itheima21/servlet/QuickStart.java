package com.itheima.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 *  Servlet技术快速入门
 *  运行在服务器端的程序,称为Servlet, 必须在服务器中运行 Tomcat
 *  等待客户端访问,连接
 *
 *  Servlet技术,客户端交互技术,请求和响应
 *
 *  Sun公司,JavaEE平台上的十三个规范之一
 *
 *  定义接口: javax.servlet.Servlet
 *
 *  Servlet技术快速入门:
 *   1: 创建类,实现接口Servlet
 *   2: 重写抽象方法,5个 (关注一个方法 service )
 *   3: 编写核心配置文件
 */
public class QuickStart implements Servlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet快速入门");

        servletResponse.getWriter().write("welcome to ");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
