package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 控制器
 */
@Controller
@RequestMapping("user")
public class UserController {

    //用法1: 多个URL路径映射到同一个Handler（同一个方法）
    @RequestMapping(value={"gotoResultURL1","gotoResultURL2"})
    public ModelAndView gotoResultURL(ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date() +"===User===gotoResultURL");
        //指定页面
        modelAndView.setViewName("result");

        return modelAndView;
    }

    //普通用户
    @RequestMapping(value={"login"}, params = {"type=user"})
    public ModelAndView loginUser(ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date() +"===user");
        //指定页面
        modelAndView.setViewName("result");

        return modelAndView;
    }
    //管理员
    @RequestMapping(value={"login"}, params = {"type=admin"})
    public ModelAndView loginAdmin(ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date() +"===admin");
        //指定页面
        modelAndView.setViewName("result");

        return modelAndView;
    }
    //VIP
    @RequestMapping(value={"login"}, params = {"type=vip"})
    public ModelAndView loginVIP(ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date() +"===VIP");
        //指定页面
        modelAndView.setViewName("result");

        return modelAndView;
    }

    /*
     * url相同，请求方式相同，请求参数不同
     * @RequestMapping注解属性params
     * id：表示请求必须包含名为 id 的请求参数
     *        演示: http://localhost:8080/user/gotoResultParamsURL.do?id=11
     * !id：表示请求不能包含名为 id 的请求参数
     *        演示: http://localhost:8080/user/gotoResultParamsURL?id=123
     * id=100：表示请求包含名为 param1 的请求参数，但其值不能为 100
     *       演示: http://localhost:8080/user/gotoResultParamsURL.do?id=100
     *{“id!=100”, “name”}：请求必须包含名为 id 和 name 的两个请求参数，
     *      http://localhost:8080/user/gotoResultParamsURL.do?id=123
     */
    @RequestMapping(value={"gotoResultParamsURL"}, params = {"id!=100","name"})
    public ModelAndView gotoResultParamsURL (ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date() +"===gotoResultParamsURL");
        //指定页面
        modelAndView.setViewName("result");

        return modelAndView;
    }

}
