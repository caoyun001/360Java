package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping("findAll")
    public String findAll(ModelMap modelMap){
        modelMap.addAttribute("message", "模拟查询出来了5条账户信息");

        return "result";
    }
}
