package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: hero brother
 * @date: Created in 2019/12/16
 * @description:
 * @version: 1.0
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/sendHttp")
    public String sendHttpRequest(){
        //https://baidu.com/
        /**
         * 请求方式：
         * get：getForObject()
         * post：postForObject()
         * delete：delete
         * put：put
         */
        String responseBody = restTemplate.getForObject("http://baidu.com", String.class);
        System.out.println(responseBody);
        return "发送请求成功了";
    }
}
