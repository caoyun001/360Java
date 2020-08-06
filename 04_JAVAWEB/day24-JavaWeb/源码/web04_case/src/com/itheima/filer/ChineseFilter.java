package com.itheima.filer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
/**
 * 中文乱码处理过滤器
 */
public class ChineseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    /**
     * 每次拦截执行的方法
     * 方法的参数 servletRequest,servletResponse传递到Servlet的doGet方法
     * 过滤器中,设置request对象使用编码表
     * 所有的Servlet都受益
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
