package com.changgou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pageDetail")
public class PageDetailController {

    @GetMapping("/{spuId}")
    public String detail(@PathVariable("spuId")String spuId){

        return "items/"+ spuId;
    }
}
