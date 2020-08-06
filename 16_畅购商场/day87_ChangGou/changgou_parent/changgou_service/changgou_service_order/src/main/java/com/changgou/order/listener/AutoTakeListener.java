package com.changgou.order.listener;

import com.changgou.order.dao.OrderConfigMapper;
import com.changgou.order.dao.OrderMapper;
import com.changgou.order.pojo.Order;
import com.changgou.order.pojo.OrderConfig;
import com.changgou.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * 从rabbitmq中接收到占位符, 则执行一次自动收货任务
 */
@Component
@RabbitListener(queues = "order_tack")
public class AutoTakeListener {

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void messageHandler(String message) {
        System.out.println("=====执行自动收货==========");
        OrderConfig orderConfig = orderConfigMapper.selectByPrimaryKey(1);
        //获取到收货超时时间
        Integer takeTimeout = orderConfig.getTakeTimeout();

        //获取当前时间, 这个对象方便日期做加减计算
        LocalDate localDate = LocalDate.now();
        //当前日期减去超时时间, 得到具体哪一天之前发货的超时日期
        LocalDate consTime = localDate.plusDays(-takeTimeout);

        //创建复杂查询对象
        Example example = new Example(Order.class);
        //创建sql语句中的where查询条件对象
        Example.Criteria criteria = example.createCriteria();
        //设置条件支付状态为1已经支付的
        criteria.andEqualTo("payStatus", "1");
        //设置条件发货状态为1已发货的
        criteria.andEqualTo("consignStatus", "1");
        //设置条件发货时间小于等于具体超时日期的
        criteria.andLessThanOrEqualTo("consignTime", consTime);
        List<Order> orders = orderMapper.selectByExample(example);

        if (orders != null && orders.size() > 0) {
            for (Order order : orders) {
                //第二个参数是收货人, system代表系统自动执行的
                orderService.take(order.getId(), "system");
            }
        }
    }
}
