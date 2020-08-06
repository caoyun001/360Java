package com.changgou.listener;

import com.changgou.service.EsManagerService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商品上架队列消费者监听器
 */
@Component
@RabbitListener(queues = "search_add_queue")
public class GoodsUpListener {

    @Autowired
    private EsManagerService esManagerService;

    @RabbitHandler
    public void msgHandle(String spuId){

        //根据spuId查询sku数据导入ES中
        esManagerService.importBySpuId(spuId);
    }
}
