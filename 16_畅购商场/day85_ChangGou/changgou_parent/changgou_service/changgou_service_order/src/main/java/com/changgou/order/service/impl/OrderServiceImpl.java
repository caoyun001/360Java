package com.changgou.order.service.impl;

import com.changgou.config.RabbitMQConfig;
import com.changgou.entity.Constants;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.order.dao.OrderItemMapper;
import com.changgou.order.dao.OrderLogMapper;
import com.changgou.order.dao.OrderMapper;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.pojo.OrderLog;
import com.changgou.order.service.CartService;
import com.changgou.order.service.OrderService;
import com.changgou.order.pojo.Order;
import com.changgou.pay.feign.PayFeign;
import com.changgou.util.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private OrderLogMapper orderLogMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PayFeign payFeign;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Order> findAll() {
        return orderMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Order findById(String id){
        return  orderMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param order
     */
    @Override
    public void add(Order order){
        /**
         * 1. 根据当前登录用户的用户名获取redis中的购物车
         */
        Map cartMap = cartService.list(order.getUsername());
        if (cartMap != null && cartMap.size() > 0) {
        /**
         * 2. 获取购物车列表
         */
            List<OrderItem> orderItemList  = (List<OrderItem>)cartMap.get("orderItemList");
            /**
             * 3. 获取购买总数据量和总金额
             */
            Integer totalNum = Integer.parseInt(String.valueOf(cartMap.get("totalNum")));
            Integer totalPrice = Integer.parseInt(String.valueOf(cartMap.get("totalPrice")));


            /**
             * 4. 保存订单到数据库订单表中
             */
            //订单主键id
            order.setId(String.valueOf(idWorker.nextId()));
            //数据来源1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面
            order.setSourceType("1");
            //总购买数量
            order.setTotalNum(totalNum);
            //总价钱
            order.setTotalMoney(totalPrice);
            //支付价钱
            order.setPayMoney(totalPrice);
            //优惠金额
            order.setPreMoney(0);
            //运费
            order.setPostFee(0);
            //发货状态, 0未发货
            order.setConsignStatus("0");
            //订单状态, 0待支付
            order.setOrderStatus("0");
            //支付状态, 0 未支付
            order.setPayStatus("0");
            //更新时间
            order.setUpdateTime(new Date());
            //创建时间
            order.setCreateTime(new Date());
            orderMapper.insertSelective(order);

            /**
             * 5. 保存订单对象到redis中作为待支付订单使用
             *   待支付订单放入redis中的格式例如:
             *   登录用户的用户名:
             *                  订单id, order
             *
             */
            redisTemplate.boundHashOps(Constants.REDIS_ORDER_PAY + order.getUsername()).put(order.getId(), order);


            if (orderItemList != null) {
                for (OrderItem orderItem : orderItemList) {


                /**
                 * 6. 保存订单详情
                 */
                //订单详情主键id
                orderItem.setId(String.valueOf(idWorker.nextId()));
                //订单详情所属订单的id
                orderItem.setOrderId(order.getId());
                orderItemMapper.insertSelective(orderItem);

                /**
                 * 7. 扣减库存, 增加销量
                 */
                skuFeign.decrCount(orderItem.getSkuId(), orderItem.getNum());
                }
            }

            /**
             * 8. 删除购物车
             */
            redisTemplate.delete(Constants.REDIS_CART + order.getUsername());

            /**
             * 9. 将订单id, 作为消息发送给rabbitmq的realyQueue队列中
             *     设置消息的超时时间为20分钟, 这个时间也就是订单支付的超时时间
             *     在开发测试的时候, 如果专门想测试这套业务流程, 可以将超时时间设置为20秒
             */
            //第一个参数: 路由键或者是队列名称, 第二个参数: 发送的内容, 第三个参数:设置超时时间属性
            rabbitTemplate.convertAndSend(RabbitMQConfig.RELAY_QUEUE, (Object) order.getId(), new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    //获取消息属性, 设置消息超时时间为20秒, 等上线阶段设置为20分钟
                    message.getMessageProperties().setExpiration("20000");
                    return message;
                }
            });
        }
    }


    /**
     * 修改
     * @param order
     */
    @Override
    public void update(Order order){
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        orderMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Order> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return orderMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Order> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Order>)orderMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Order> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Order>)orderMapper.selectByExample(example);
    }

    @Override
    public void paySuccesOrder(String transId, String orderId) {
        /**
         * 1. 根据订单id, 更改数据库中订单数据的支付状态
         */
        Order order = new Order();
        //订单主键id
        order.setId(orderId);
        //交易流水号
        order.setTransactionId(transId);
        //订单更新时间
        order.setUpdateTime(new Date());
        //支付状态 1已支付
        order.setPayStatus("1");
        //支付时间
        order.setPayTime(new Date());
        //订单状态 2已支付
        order.setOrderStatus("2");
        orderMapper.updateByPrimaryKeySelective(order);

        /**
         * 2. 保存支付日志
         */
        OrderLog orderLog = new OrderLog();
        //日志主键id
        orderLog.setId(String.valueOf(idWorker.nextId()));
        //订单状态  2已支付
        orderLog.setOrderStatus("2");
        //订单id
        orderLog.setOrderId(orderId);
        //操作人, system系统自动操作
        orderLog.setOperater("system");
        //操作时间
        orderLog.setOperateTime(new Date());
        //支付状态, 1已支付
        orderLog.setPayStatus("1");
        //发货状态, 0未发货
        orderLog.setConsignStatus("0");
        orderLogMapper.insertSelective(orderLog);


        /**
         * 3. 删除redis中对应的待支付订单数据
         */
        order = orderMapper.selectByPrimaryKey(orderId);
        redisTemplate.boundHashOps(Constants.REDIS_ORDER_PAY + order.getUsername()).delete(orderId);
    }

    @Override
    public void payCancelOrder(String orderId) {
        //1. 根据订单id, 到数据库中查询订单对象
        Order order = orderMapper.selectByPrimaryKey(orderId);
        //2. 调用微信的关闭订单接口, 关闭支付通道
        payFeign.closePay(orderId);

        //3. 更改订单状态为关闭订单
        //更新时间
        order.setUpdateTime(new Date());
        //订单状态 9关闭订单
        order.setOrderStatus("9");
        //订单关闭时间
        order.setCloseTime(new Date());
        orderMapper.updateByPrimaryKeySelective(order);

        //4. 记录订单变动日志
        OrderLog orderLog = new OrderLog();
        //日志主键id
        orderLog.setId(String.valueOf(idWorker.nextId()));
        //订单状态  9关闭订单
        orderLog.setOrderStatus("9");
        //订单id
        orderLog.setOrderId(orderId);
        //操作人, system系统自动操作
        orderLog.setOperater("system");
        //操作时间
        orderLog.setOperateTime(new Date());
        //支付状态, 1未支付
        orderLog.setPayStatus("0");
        //发货状态, 0未发货
        orderLog.setConsignStatus("0");
        orderLogMapper.insertSelective(orderLog);

        //5. 删除redis中的待支付订单对象
        redisTemplate.boundHashOps(Constants.REDIS_ORDER_PAY + order.getUsername()).delete(order.getId());

        //6. 恢复库存, 恢复销量
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", order.getId());
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
        if (orderItems != null) {
            for (OrderItem orderItem : orderItems) {
                skuFeign.incrCount(orderItem.getSkuId(), orderItem.getNum());
            }
        }

    }

    @Override
    public void sends(List<Order> orderList) {
        if (orderList != null) {
            for (Order order : orderList) {
                if (StringUtils.isEmpty(order.getShippingName())) {
                    throw new RuntimeException("请选择快递公司");
                }
                if (StringUtils.isEmpty(order.getShippingCode())) {
                    throw new RuntimeException("请填写快递单号");
                }

                /**
                 * 更改订单表数据
                 */
                order.setUpdateTime(new Date());
                //订单状态   4已发货
                order.setOrderStatus("4");
                //发货状态  1已发货
                order.setConsignStatus("1");
                //发货时间
                order.setConsignTime(new Date());
                orderMapper.updateByPrimaryKeySelective(order);

                //记录订单变动日志
                OrderLog orderLog = new OrderLog();
                //日志主键id
                orderLog.setId(String.valueOf(idWorker.nextId()));
                //订单状态  4已发货
                orderLog.setOrderStatus("4");
                //订单id
                orderLog.setOrderId(order.getId());
                //操作人, system系统自动操作
                orderLog.setOperater("system");
                //操作时间
                orderLog.setOperateTime(new Date());
                //支付状态, 1已支付
                orderLog.setPayStatus("1");
                //发货状态, 1已发货
                orderLog.setConsignStatus("1");
                orderLogMapper.insertSelective(orderLog);

            }
        }
    }

    @Override
    public void take(String orderId, String oprator) {
        Order order = new Order();
        order.setId(orderId);
        order.setUpdateTime(new Date());
        //订单状态  5已收货
        order.setOrderStatus("5");
        //发货状态 2已收货
        order.setConsignStatus("2");
        orderMapper.updateByPrimaryKeySelective(order);

        //记录订单变动日志
        OrderLog orderLog = new OrderLog();
        //日志主键id
        orderLog.setId(String.valueOf(idWorker.nextId()));
        //订单状态  5已收货
        orderLog.setOrderStatus("5");
        //订单id
        orderLog.setOrderId(order.getId());
        //操作人
        orderLog.setOperater(oprator);
        //操作时间
        orderLog.setOperateTime(new Date());
        //支付状态, 1已支付
        orderLog.setPayStatus("1");
        //发货状态, 2已收货
        orderLog.setConsignStatus("2");
        orderLogMapper.insertSelective(orderLog);

    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 订单id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andEqualTo("id",searchMap.get("id"));
           	}
            // 支付类型，1、在线支付、0 货到付款
            if(searchMap.get("payType")!=null && !"".equals(searchMap.get("payType"))){
                criteria.andEqualTo("payType",searchMap.get("payType"));
           	}
            // 物流名称
            if(searchMap.get("shippingName")!=null && !"".equals(searchMap.get("shippingName"))){
                criteria.andLike("shippingName","%"+searchMap.get("shippingName")+"%");
           	}
            // 物流单号
            if(searchMap.get("shippingCode")!=null && !"".equals(searchMap.get("shippingCode"))){
                criteria.andLike("shippingCode","%"+searchMap.get("shippingCode")+"%");
           	}
            // 用户名称
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
           	}
            // 买家留言
            if(searchMap.get("buyerMessage")!=null && !"".equals(searchMap.get("buyerMessage"))){
                criteria.andLike("buyerMessage","%"+searchMap.get("buyerMessage")+"%");
           	}
            // 是否评价
            if(searchMap.get("buyerRate")!=null && !"".equals(searchMap.get("buyerRate"))){
                criteria.andLike("buyerRate","%"+searchMap.get("buyerRate")+"%");
           	}
            // 收货人
            if(searchMap.get("receiverContact")!=null && !"".equals(searchMap.get("receiverContact"))){
                criteria.andLike("receiverContact","%"+searchMap.get("receiverContact")+"%");
           	}
            // 收货人手机
            if(searchMap.get("receiverMobile")!=null && !"".equals(searchMap.get("receiverMobile"))){
                criteria.andLike("receiverMobile","%"+searchMap.get("receiverMobile")+"%");
           	}
            // 收货人地址
            if(searchMap.get("receiverAddress")!=null && !"".equals(searchMap.get("receiverAddress"))){
                criteria.andLike("receiverAddress","%"+searchMap.get("receiverAddress")+"%");
           	}
            // 订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面
            if(searchMap.get("sourceType")!=null && !"".equals(searchMap.get("sourceType"))){
                criteria.andEqualTo("sourceType",searchMap.get("sourceType"));
           	}
            // 交易流水号
            if(searchMap.get("transactionId")!=null && !"".equals(searchMap.get("transactionId"))){
                criteria.andLike("transactionId","%"+searchMap.get("transactionId")+"%");
           	}
            // 订单状态
            if(searchMap.get("orderStatus")!=null && !"".equals(searchMap.get("orderStatus"))){
                criteria.andEqualTo("orderStatus",searchMap.get("orderStatus"));
           	}
            // 支付状态
            if(searchMap.get("payStatus")!=null && !"".equals(searchMap.get("payStatus"))){
                criteria.andEqualTo("payStatus",searchMap.get("payStatus"));
           	}
            // 发货状态
            if(searchMap.get("consignStatus")!=null && !"".equals(searchMap.get("consignStatus"))){
                criteria.andEqualTo("consignStatus",searchMap.get("consignStatus"));
           	}
            // 是否删除
            if(searchMap.get("isDelete")!=null && !"".equals(searchMap.get("isDelete"))){
                criteria.andEqualTo("isDelete",searchMap.get("isDelete"));
           	}

            // 数量合计
            if(searchMap.get("totalNum")!=null ){
                criteria.andEqualTo("totalNum",searchMap.get("totalNum"));
            }
            // 金额合计
            if(searchMap.get("totalMoney")!=null ){
                criteria.andEqualTo("totalMoney",searchMap.get("totalMoney"));
            }
            // 优惠金额
            if(searchMap.get("preMoney")!=null ){
                criteria.andEqualTo("preMoney",searchMap.get("preMoney"));
            }
            // 邮费
            if(searchMap.get("postFee")!=null ){
                criteria.andEqualTo("postFee",searchMap.get("postFee"));
            }
            // 实付金额
            if(searchMap.get("payMoney")!=null ){
                criteria.andEqualTo("payMoney",searchMap.get("payMoney"));
            }

        }
        return example;
    }

}
