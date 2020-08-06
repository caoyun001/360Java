package com.changgou.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.service.EsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class EsManangerController {

    @Autowired
    private EsManagerService esManagerService;

    @PostMapping("/deleteIndexAndMapping")
    public Result deleteIndexAndMapping(){
        esManagerService.deleteIndexAndMapping();
        return new Result(true, StatusCode.OK, "删除索引和映射成功");
    }

    @PostMapping("/createIndexAndMapping")
    public Result createIndexAndMapping(){
        esManagerService.createIndexAndMapping();
        return new Result(true, StatusCode.OK, "创建索引和映射成功");
    }


    @PostMapping("/importAll")
    public Result importAll(){
        esManagerService.importAll();
        return new Result(true, StatusCode.OK, "导入所有数据成功");
    }
}
