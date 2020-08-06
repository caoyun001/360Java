package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 控制器( 理解为 相当与WEB阶段的 Servlet)
 */
@Controller
public class DefaultController {

    /**
     * 所有的拦截器都放行 true, 才会执行到 Handler方法
     */
    @RequestMapping("gotoResult")
    public ModelAndView gotoResult(ModelAndView modelAndView){

        System.out.println("gotoResult 方法执行了 " );

        //封装数据
        modelAndView.addObject("nowDate", new Date());
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
