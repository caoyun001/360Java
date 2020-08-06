package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author likepei
 * @data 2019/7/16 9:55
 * @description 案例 安检进行物品的过滤
 */
@WebFilter("/safe")
public class SafeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.获取浏览器提交的请求参数 (物品)
        String[] products = req.getParameterValues("product");
        //2.对物品进行过滤
        System.out.println("安检前:" + Arrays.toString(products));
        //jdk8 Stream
        List<String> list = Stream.of(products).filter(item -> !item.equals("手榴弹")).filter(item -> !item.equals("冲锋枪")).collect(Collectors.toList());
        System.out.println("安检通过后:" + list);
        //3.对过滤通过的物品 添加到 域中
        req.setAttribute("list", list);
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
