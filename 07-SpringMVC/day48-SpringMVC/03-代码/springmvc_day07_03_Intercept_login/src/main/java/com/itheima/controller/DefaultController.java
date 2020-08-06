package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 控制器( 理解为 相当与WEB阶段的 Servlet)
 */
@Controller
@RequestMapping("default")
public class DefaultController {

    /**
     * 所有的拦截器都放行 true, 才会执行到 Handler方法
     */
    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request){

        /**
         * 如果账号为zhang3, 密码123
         * 认为账号密码正确, 可以登录, 否则不能登录
         */
        if("zhang3".equals(username) && "123".equals(password)){
            //把当前登录的账户名存到Session域中
            request.getSession().setAttribute("username", username);
            //登录成功, 跳转到查询所有账户信息的页面
            return "redirect:/account/findAll.do";
        } else {
            //登录失败( 返回到 输入用户名密码的 登录页面)
            return "redirect:/index.jsp";
        }
    }
}
