package com.changgou.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page")
public class PageController {


    @Autowired
    private PageService pageService;

    @PostMapping("/createPageHtml/{spuId}")
    public Result createPageHtml(@PathVariable("spuId")String spuId){
        pageService.createPageHtml(spuId);
        return new Result(true, StatusCode.OK, "生成静态页面成功");
    }


}
