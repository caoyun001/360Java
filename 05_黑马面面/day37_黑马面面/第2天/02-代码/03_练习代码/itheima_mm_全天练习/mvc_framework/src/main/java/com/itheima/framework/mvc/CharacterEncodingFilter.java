package com.itheima.framework.mvc;
import javax.servlet.*;
import java.io.IOException;

/**
 * 字符集过滤器
 * 统一处理请求与响应字符集
 * 默认utf-8
 */
public class CharacterEncodingFilter implements Filter {

    //定义变量存储编码
    private String encoding = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获得该filter的初始化参数 即编码
        encoding = filterConfig.getInitParameter("encoding")==null?encoding:filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset="+encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
