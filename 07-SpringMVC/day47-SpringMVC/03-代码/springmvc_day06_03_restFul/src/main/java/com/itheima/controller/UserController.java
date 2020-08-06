package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class UserController {

    //查询
    @RequestMapping(value={"/user/{id}"}, method = RequestMethod.GET)
    public String gotoResultGet(@PathVariable("id") Integer ids, ModelMap modelMap){
        //封装数据
        //modelMap.addAttribute("nowDate", new Date()+"==="+ ids +"===查询, GET");
        System.out.println("GET  ids = " + ids);
        //指定页面
        return "result";
    }

    //增加
    @RequestMapping(value={"/user/{id}"}, method = RequestMethod.POST)
    public String gotoResultPost(@PathVariable("id") Integer ids, ModelMap modelMap){
        //封装数据
        //modelMap.addAttribute("nowDate", new Date()+"==="+ ids +"===查询, Post");
        System.out.println("POST ids = " + ids);
        //指定页面
        return "result";
    }

    //更新
    @RequestMapping(value={"/user/{id}"}, method = RequestMethod.PUT)
    public String gotoResultPut(@PathVariable("id") Integer ids, ModelMap modelMap){
        //封装数据
        //modelMap.addAttribute("nowDate", new Date()+"==="+ ids +"===查询, Post");
        System.out.println("PUT ids = " + ids);
        //指定页面
        return "result";
    }

    //删除
    @RequestMapping(value={"/user/{id}"}, method = RequestMethod.DELETE)
    public String gotoResultDelete(@PathVariable("id") Integer ids, ModelMap modelMap){
        //封装数据
        //modelMap.addAttribute("nowDate", new Date()+"==="+ ids +"===查询, Post");
        System.out.println("DELETE ids = " + ids);
        //指定页面
        return "result";
    }
}
