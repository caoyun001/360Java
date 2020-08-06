package com.changgou.listener;

import com.changgou.service.PageService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "page_create_queue")
public class PageCreateListener {

    @Autowired
    private PageService pageService;

    @RabbitHandler
    public void msgHandle(String spuId){

        //调用生成商品静态页面的接口
        pageService.createPageHtml(spuId);
    }
}
