package com.changgou.listener;

import com.changgou.service.EsManagerService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商品下架队列消费者监听器
 */
@Component
@RabbitListener(queues = "search_del_queue")
public class GoodsDownListener {

    @Autowired
    private EsManagerService esManagerService;

    @RabbitHandler
    public void msgHandle(String spuId){

        //根据spuId查询sku数据从ES中删除掉
        esManagerService.delBySpuId(spuId);
    }
}
