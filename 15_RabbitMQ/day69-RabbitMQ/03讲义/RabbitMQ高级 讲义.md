# 学习目标

* 掌握RabbitMQ 高级特性：
  * 生产者确认
  * 消费者确认
  * 消费端限流
  * TTL
  * 死信队列
* 能够搭建RabbitMQ 集群



# 一、RabbitMQ 高级特性

### 基础案例环境搭建：

目标：使用路由模式，基于SpringMVC中controller，生产者通过RabbitTemplate发送消息给消费者！

**实现步骤：**

1. 创建rabbit-parent空的父工程
2. 创建producer-publisher-confirm，Maven工程模块，用于演示生产者确认
3. 配置消息队列
   - 创建消息队列order.A
   - 创建交换机order_exchange，类型是direct类型
   - 绑定此交换机与消息队列，设置路由键order.A
4. 在producer-publisher-confirm模块中，创建SpringBoot工程生产者producer子模块
   - 创建producer的SpringBoot子模块，勾选起步依赖坐标
   - 配置RabbitMQ：服务地址，端口，账户，密码及虚拟主机
   - 编写MessageController，用于向消息队列发送消息
5. 在producer-publisher-confirm模块中，创建SpringBoot工程生产者consumer子模块
   - 创建consumer的SpringBoot子模块，勾选起步依赖坐标
   - 配置RabbitMQ：服务地址，端口，账户，密码及虚拟主机
   - 编写消息接收监听器，用于接收消息队列中消息
6. 在谷歌浏览器中发送请求进行测试：http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=order.B&msg=购买苹果手机

**实现过程：**

1. 创建rabbit-parent空的父工程![image-20191227212615807](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227212615807.png)![image-20191227212656725](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227212656725.png)

2. 创建producer-publisher-confirm，Maven工程模块，用于演示生产者确认![image-20191227212751527](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227212751527.png)

3. 配置消息队列

   - 创建消息队列order.A![image-20191227214408627](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227214408627.png)
   - 创建交换机order_exchange![image-20191227214446745](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227214446745.png)
   - 绑定此交换机与消息队列，设置路由键order.A![image-20191227214526249](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227214526249.png)

4. 在producer-publisher-confirm模块中，创建SpringBoot工程生产者producer子模块

   - 创建producer的SpringBoot子模块，勾选起步依赖坐标![image-20191227213050070](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227213050070.png)![image-20191227213136050](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227213136050.png)

   - 配置RabbitMQ：服务地址，端口，账户，密码及虚拟主机

     ```properties
     # 消息队列服务地址
     spring.rabbitmq.host=192.168.200.128
     # 消息队列端口
     spring.rabbitmq.port=5672
     # 消息队列账户
     spring.rabbitmq.username=heima
     # 消息队列账户密码
     spring.rabbitmq.password=heima
     # 设置虚拟主机,不设置默认是根路径(/)
     spring.rabbitmq.virtual-host=/itheima
     ```

   - 编写MessageController，用于向消息队列发送消息

     ```java
     /**
      * 向消息队列发送消息
      */
     @RestController
     public class MessageController {
     
         //注入RabbitMQ模板对象
         @Autowired
         private RabbitTemplate rabbitTemplate;
     
         //调用RabbitMQ模板发送消息方法，向消息队列发送消息内容
         @RequestMapping("/direct/sendMsg")
         public String sendMsg(String exchange,String routingkey,String msg){
             /**
              * 向交换机发送消息
              * 参数1：exchange：交换机
              * 参数2：routingkey：路由键
              * 参数3：msg：发送消息的内容
              */
             rabbitTemplate.convertAndSend(exchange,routingkey,msg);
             return "已投递~";
         }
     }
     ```

     

5. 在producer-publisher-confirm模块中，创建SpringBoot工程生产者consumer子模块

   - 创建consumer的SpringBoot子模块，勾选起步依赖坐标![image-20191227213008721](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227213008721.png)![image-20191227213158947](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227213158947.png)

   - 配置RabbitMQ：服务地址，端口，账户，密码及虚拟主机

     ```properties
     # 消息队列服务地址
     spring.rabbitmq.host=192.168.200.128
     # 消息队列端口
     spring.rabbitmq.port=5672
     # 消息队列账户
     spring.rabbitmq.username=heima
     # 消息队列账户密码
     spring.rabbitmq.password=heima
     # 设置虚拟主机,不设置默认是根路径(/)
     spring.rabbitmq.virtual-host=/itheima
     ```

   - 编写消息接收监听器，用于接收消息队列中消息

     ```java
     /**
      * 消息队列接收消息监听器
      */
     @Component
     @RabbitListener(queues = "order.A")
     public class ConsumerQueueListener {
     
         //接收消息，监听器调用此方法执行业务逻辑
         @RabbitHandler
         public void queueListenerHandle(String msg){
             System.out.println("下单消息{}，内容："+msg);
         }
     }
     ```

6. 在谷歌浏览器中发送请求进行测试：http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=order.B&msg=购买苹果手机

   - ![image-20191227213901180](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227213901180.png)

   - 消费者工程控制台打印![image-20191227213735451](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227213735451.png)

## 1. 生产者确认

> 如果保证消息的可靠性？需要解决如下问题
>
> 问题1：生产者能百分之百将消息发送给消息队列！
>
> - 两种意外情况：
>   - 第一，消费者发送消息给MQ失败，消息丢失；
>   - 第二，交换机路由到队列失败，路由键写错；
>
> 

在使用 RabbitMQ 的时候，作为消息发送方希望杜绝任何消息丢失或者投递失败场景。RabbitMQ 为我们提供了两种方式用来控制消息的投递可靠性模式。

* confirm 确认模式

* return  退回模式

rabbitmq 整个消息投递的路径为：

![image-20191215164355458](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164355458.png)

* 消息从生产者(producer)发送消息到交换机(exchange)，不论是否成功，都会执行一个确认回调方法confirmCallback 。

* 消息从交换机(exchange)到消息队列( queue )投递失败则会执行一个返回回调方法 returnCallback 。

我们将利用这两个 callback 控制消息的可靠性投递

### 1.1 confirm 确认模式

**目标：演示消息确认模式效果**

生产者发布消息确认模式特点，不论消息是否进入交换机均执行回调方法

**实现步骤：**

1. 在配置文件中，开启生产者发布消息确认模式
2. 编写生产者确认回调方法
3. 在RabbitTemplate中，设置消息发布确认回调方法
4. 请求测试：
   - 测试成功回调：
   - 测试失败回调：

**实现过程：**

1. 在配置文件中，开启生产者发布消息确认模式

   ```properties
   # 开启生产者确认模式：(confirm),投递到交换机，不论失败或者成功都回调
   spring.rabbitmq.publisher-confirms=true
   ```

2. 编写生产者确认回调方法

   ```java
   //发送消息回调确认类，实现回调接口ConfirmCallback,重写其中confirm()方法
   @Component
   public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback {
       /**
        * 投递到交换机，不论投递成功还是失败都回调次方法
        * @param correlationData 投递相关数据
        * @param ack 是否投递到交换机
        * @param cause 投递失败原因
        */
       @Override
       public void confirm(CorrelationData correlationData, boolean ack, String cause) {
           if (ack){
               System.out.println("消息进入交换机成功{}");
           } else {
               System.out.println("消息进入交换机失败{} ， 失败原因：" + cause);
           }
       }
   }
   ```

   

3. 在RabbitTemplate中，设置消息发布确认回调方法

   ```java
   @Component
   public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback{
   
       @Autowired
       private RabbitTemplate rabbitTemplate;
       /**
        * 创建RabbitTemplate对象之后执行当前方法，为模板对象设置回调确认方法
        * 设置消息确认回调方法
        * 设置消息回退回调方法
        */
       @PostConstruct
       public void initRabbitTemplate(){
           //设置消息确认回调方法
           rabbitTemplate.setConfirmCallback(this::confirm);
       }
       /**
        * 投递到交换机，不论投递成功还是失败都回调次方法
        * @param correlationData 投递相关数据
        * @param ack 是否投递到交换机
        * @param cause 投递失败原因
        */
       @Override
       public void confirm(CorrelationData correlationData, boolean ack, String cause) {
           if (ack){
               System.out.println("消息进入交换机成功{}");
           } else {
               System.out.println("消息进入交换机失败{} ， 失败原因：" + cause);
           }
       }
   }
   ```

4. 请求测试：

   - 测试成功回调：`http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=order.A&msg=购买苹果手机`
   - ![image-20191227215535373](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227215535373.png)
   - 测试失败回调：`http://localhost:8080/direct/sendMsg?exchange=order_xxxxxxx&routingkey=order.A&msg=购买苹果手机`
   - ![image-20191227215727720](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227215727720.png)

### 1.2 return 退回模式

**目标：演示消息回退模式效果**

消息回退模式特点：**消息进入交换机**，路由到队列过程中出现异常则执行回调方法

**实现步骤：**

1. 在配置文件中，开启生产者发布消息回退模式
2. 在MessageConfirmCallback类中，实现接口RabbitTemplate.ReturnCallback
3. 并重写RabbitTemplate.ReturnCallback接口中returnedMessage()方法
4. 在RabbitTemplate中，设置消息发布回退回调方法
5. 请求测试：
   - 测试成功回调：
   - 测试失败回调：

**实现过程：**

1. 在配置文件中，开启生产者发布消息回退模式

   ```properties
   # 开启生产者回退模式:(returns)，交换机将消息路由到队列，出现异常则回调
   spring.rabbitmq.publisher-returns=true
   ```

2. 在MessageConfirmCallback类中，实现接口RabbitTemplate.ReturnCallback

   ```java
   @Component
   public class RabbitConfirm implements RabbitTemplate.ConfirmCallback
       ,RabbitTemplate.ReturnCallback {
   	//..省略
   }
   ```

3. 并重写RabbitTemplate.ReturnCallback接口中returnedMessage()方法

   ```java
   /**
        * 当消息投递到交换机，交换机路由到消息队列中出现异常，执行returnedMessaged方法
        * @param message 投递消息内容
        * @param replyCode 返回错误状态码
        * @param replyText 返回错误内容
        * @param exchange 交换机名称
        * @param routingKey 路由键
        */
       @Override
       public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
           System.out.println("交换机路由至消息队列出错：>>>>>>>");
           System.out.println("交换机："+exchange);
           System.out.println("路由键："+routingKey);
           System.out.println("错误状态码："+replyCode);
           System.out.println("错误原因："+replyText);
           System.out.println("发送消息内容："+message.toString());
           System.out.println("<<<<<<<<");
       }
   ```

4. 在RabbitTemplate中，设置消息发布回退回调方法

   ```java
   @PostConstruct
   public void initRabbitTemplate(){
       //设置消息确认回调方法
       rabbitTemplate.setConfirmCallback(this::confirm);
       //设置消息回退回调方法
       rabbitTemplate.setReturnCallback(this::returnedMessage);
   }
   ```

5. 请求测试失败执行returnedMessage方法：`http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=xxxxx&msg=购买苹果手机`

   - ![image-20191227220939316](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227220939316.png)

### 1.1.3 小结

确认模式：

* 设置publisher-confirms="true" 开启 确认模式。
* 实现RabbitTemplate.ConfirmCallback接口，重写confirm方法
* 特点：不论消息是否成功投递至交换机，都回调confirm方法，只有在发送失败时需要写业务代码进行处理。

退回模式

* 设置publisher-returns="true" 开启 退回模式。
* 实现RabbitTemplate.ReturnCallback接口，重写returnedMessage方法
* 特点：消息进入交换机后，只有当从exchange路由到queue失败，才去回调returnedMessage方法；

## 2. 消费者确认(ACK)

> 问题2：消费者能百分百接收到请求，且业务执行过程中还不能出错！



ack指 **Acknowledge**，拥有确认的含义，是消费端收到消息的一种确认机制；

消息确认的三种类型：

- 自动确认：acknowledge="**none**"

- 手动确认：acknowledge="**manual**"

- 根据异常情况确认：acknowledge="**auto**"，（这种方式使用麻烦，不作讲解）


其中自动确认是指，当消息一旦被Consumer接收到，则自动确认收到，并将相应 message 从 RabbitMQ 的消息缓存中移除。但是在实际业务处理中，很可能消息接收到，业务处理出现异常，那么该消息就会丢失。

如果设置了手动确认方式，则需要在业务处理成功后，调用`channel.basicAck()`，手动签收，如果出现异常，则调用`channel.basicNack()`方法，让其自动重新发送消息。

![image-20191215164355458](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164355458.png)

自定义监听器涉及三个对象：三个对象必须注入Spring容器

1. 自定义监听器对象
2. 自定义监听器的适配器Adaptor对象
3. 监听器的容器对象



### 2.1 代码实现

**目标：演示消费者手动确认效果**

自定义消费者接收消息监听器，监听收到消息的内容，手动进行签收；当业务系统抛出异常则拒绝签收，重回队列

**实现步骤：**

1. 搭建新的案例工程consumer-received-ack，用于演示ack消费者签收
2. 在消费者工程中，创建自定义监听器类CustomAckConsumerListener，实现ChannelAwareMessageListener接口
3. 编写监听器配置类ListenerConfiguration，配置自定义监听器绑定消息队列`order.A`
   - 注入消息队列监听器适配器对象到ioc容器
   - 注入消息队列监听器容器对象到ioc容器：
     - 配置连接工厂
     - 配置自定义监听器适配器对象
     - 配置消息队列
     - 开启手动签收
4. 启动消费者服务，观察控制台，消费者监听器是否与RabbitMQ建立Connection
5. 测试发送消息手动签收
6. 模拟业务逻辑出现异常情况
7. 测试异常情况，演示拒绝签收消息，消息重回队列

**实现过程：**

1. 搭建新的案例工程consumer-received-ack，搭建过程类似于生产者确认

   - ![image-20191227230420747](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227230420747.png)

2. 在消费者工程中，创建自定义监听器类CustomAckConsumerListener，实现ChannelAwareMessageListener接口

   ```java
   /**
    * 自定义监听器，监听到消息之后，立即执行onMessage方法
    */
   @Component
   public class CustomAckConsumerListener implements ChannelAwareMessageListener {
       /**
        * 监听到消息之后执行的方法
        * @param message 消息内容
        * @param channel 消息所在频道
        */
       @Override
       public void onMessage(Message message, Channel channel) throws Exception {
           //获取消息内容
           byte[] messageBody = message.getBody();
           String msg = new String(messageBody, "utf-8");
           System.out.println("接收到消息，执行具体业务逻辑{} 消息内容："+msg);
           //获取投递标签
           MessageProperties messageProperties = message.getMessageProperties();
           long deliveryTag = messageProperties.getDeliveryTag();
           /**
            * 签收消息，前提条件，必须在监听器的配置中，开启手动签收模式
            * 参数1：消息投递标签
            * 参数2：是否批量签收：true一次性签收所有，false，只签收当前消息
            */
           channel.basicAck(deliveryTag,false);
           System.out.println("手动签收完成：{}");
       }
   }
   ```

3. 编写监听器配置类ListenerConfiguration，配置自定义监听器绑定消息队列`order.A`

   - 注入消息队列监听器适配器对象到ioc容器

   - 注入消息队列监听器容器对象到ioc容器：

     - 配置连接工厂
     - 配置自定义监听器
     - 配置消息队列
     - 开启手动签收

   - ```java
     /**
      * 消费者监听器配置，将监听器绑定到消息队列上
      */
     @Configuration
     public class ListenerConfiguration {
     
         /**
          * 注入消息监听器适配器
          * @param customAckConsumerListener 自定义监听器对象
          */
         @Bean
         public MessageListenerAdapter messageListenerAdapter(CustomAckConsumerListener customAckConsumerListener){
             //创建自定义监听器适配器对象
             return new MessageListenerAdapter(customAckConsumerListener);
         }
     
         /**
          * 注入消息监听器容器
          * @param connectionFactory 连接工厂
          * @param messageListenerAdapter 自定义的消息监听器适配器
          */
         @Bean
         public SimpleMessageListenerContainer simpleMessageListenerContainer(
                 ConnectionFactory connectionFactory,
                 MessageListenerAdapter messageListenerAdapter){
     
             //简单的消息监听器容器对象
             SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
             //绑定消息队列
             container.setQueueNames("order.A");
             //设置连接工厂对象
             container.setConnectionFactory(connectionFactory);
             //设置消息监听器适配器
             container.setMessageListener(messageListenerAdapter);
             //设置手动确认消息：NONE(不确认消息)，MANUAL(手动确认消息)，AUTO(自动确认消息)
             container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
             return container;
         }
     }
     ```

4. 启动消费者控制，观察控制台，消费者监听器是否与RabbitMQ建立Connection![image-20191227230832733](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227230832733.png)

5. 测试发送消息手动签收，请求地址http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=order.A&msg=购买苹果手机

   - ![image-20191227230942274](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227230942274.png)

6. 模拟业务逻辑出现异常情况，修改自定义监听器

   ```java
   @Override
   public void onMessage(Message message, Channel channel) throws Exception {
       //获取消息内容
       byte[] messageBody = message.getBody();
       String msg = new String(messageBody, "utf-8");
       System.out.println("接收到消息，执行具体业务逻辑{} 消息内容："+msg);
       //获取投递标签
       MessageProperties messageProperties = message.getMessageProperties();
       long deliveryTag = messageProperties.getDeliveryTag();
       try {
           if (msg.contains("苹果")){
               throw new RuntimeException("不允许卖苹果手机！！！");
           }
           /**
            * 手动签收消息
            * 参数1：消息投递标签
            * 参数2：是否批量签收：true一次性签收所有，false，只签收当前消息
            */
           channel.basicAck(deliveryTag,false);
           System.out.println("手动签收完成：{}");
           
       } catch (Exception ex){
           /**
            * 手动拒绝签收
            * 参数1：当前消息的投递标签
            * 参数2：是否批量签收：true一次性签收所有，false，只签收当前消息
            * 参数3：是否重回队列，true为重回队列，false为不重回
            */
           channel.basicNack(deliveryTag,false,true);
           System.out.println("拒绝签收，重回队列：{}"+ex);
       }
   }
   ```

7. 测试异常情况，演示拒绝签收消息，消息重回队列

   - 请求地址包含苹果，抛出异常：http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=order.A&msg=购买苹果手机
   - 控制台打印结果![image-20191227231706003](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227231706003.png)


### 2.2 小结

- 如果想手动签收消息，那么需要自定义实现消息接收监听器，实现ChannelAwareMessageListener接口
- 设置AcknowledgeMode模式
  -  none：自动
  - auto：异常模式
  - manual：手动
- 调用channel.basicAck方法签收消息
- 调用channel.basicNAck方法拒签消息

## 3. 消费端限流

![image-20191228073743952](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228073743952.png)

如上图所示：

**第一种情况：**

- 如果在A系统中需要维护相关的业务功能，可能需要将A系统的服务停止，那么这个时候消息的生产者还是一直会向MQ中发送待处理的消息，消费者此时服务已经关闭，导致大量的消息都会在MQ中累积。
- 如果当A系统成功启动后，消费者会一次性将MQ中累积的大量的消息拉取到自己的服务，导致服务在短时间内会处理大量的业务，可能会导致系统服务的崩溃。 所以消费端限流是非常有必要的。

**第二种情况：**当大量用户注册时，高并发请求过来，邮件接口只支持小量并发，这时消费端限流也非常必要；

消费端限流配置：设置监听器容器属性container.setPrefetchCount(1)；表示消费端每次从mq拉去1条消息来消费，直到手动确认消费完毕后，才会继续拉去下一条消息。

### 3.1 代码实现

**目标：演示消费端限流效果**

基于消费端确认的工程进行演示

消费端限流要求， 消费端确认模式必须为手动确认

**实现步骤：**

1. 在自定义消息监听器配置类ListenerConfiguration类中，配置每次拉取消息1条
2. 在自定义监听器接收消息方法中，休眠3秒，否则拉取过快，看不出效果
3. 重启消费者工程，查看控制面板频道中，每次拉取1消息配置是否生效
4. 多次发送请求进行测试

**实现过程：**

1. 在自定义消息监听器配置类ListenerConfiguration类中，配置每次拉取消息1条

   ```java
   /**
    * 注入消息监听器容器
    * @param connectionFactory 连接工厂
    * @param messageListenerAdapter 自定义的消息监听器适配器
    */
   @Bean
   public SimpleMessageListenerContainer simpleMessageListenerContainer(
           ConnectionFactory connectionFactory,
           MessageListenerAdapter messageListenerAdapter){
   
       //简单的消息监听器容器对象
       SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
       //绑定消息队列
       container.setQueueNames("order.A");
       //设置连接工厂对象
       container.setConnectionFactory(connectionFactory);
       //设置消息监听器适配器
       container.setMessageListener(messageListenerAdapter);
       //设置手动确认消息：NONE(不确认消息)，MANUAL(手动确认消息)，AUTO(自动确认消息)
       container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
       //设置消费端限流，每次拉取消息多少条，默认是250条
       container.setPrefetchCount(1);
       return container;
   }
   ```

   
   
2. 在自定义监听器接收消息方法中，休眠3秒，否则拉取过快，看不出效果

   ```java
   @Component
   public class CustomAckConsumerListener implements ChannelAwareMessageListener {
       /**
        * 监听到消息之后执行的方法
        * @param message 消息内容
        * @param channel 消息所在频道
        */
       @Override
       public void onMessage(Message message, Channel channel) throws Exception {
           //获取消息内容
           byte[] messageBody = message.getBody();
           String msg = new String(messageBody, "utf-8");
           System.out.println("接收到消息，执行具体业务逻辑{} 消息内容："+msg);
           //获取投递标签
           MessageProperties messageProperties = message.getMessageProperties();
           long deliveryTag = messageProperties.getDeliveryTag();
           try {
               //休眠3秒
               Thread.sleep(3000);
               /**
                * 手动签收消息
                * 参数1：消息投递标签
                * 参数2：是否批量签收：true一次性签收所有，false，只签收当前消息
                */
               channel.basicAck(deliveryTag,false);
               System.out.println("手动签收完成：{}");
   
           } catch (Exception ex){
               /**
                * 手动拒绝签收
                * 参数1：当前消息的投递标签
                * 参数2：是否批量签收：true一次性签收所有，false，只签收当前消息
                * 参数3：是否重回队列，true为重回队列，false为不重回
                */
               channel.basicNack(deliveryTag,false,true);
               System.out.println("拒绝签收，重回队列：{}"+ex);
           }
       }
   }
   ```

   

3. 重启消费者工程，查看控制面板频道中，每次拉取1消息配置是否生效![image-20191227232947490](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227232947490.png)

4. 多次发送请求进行测试http://localhost:8080/direct/sendMsg?exchange=order_exchange&routingkey=order.A&msg=购买苹果手机

   - ![image-20191227233203057](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227233203057.png)

### 3.2 小结

* 消费端自定义消息监听器绑定消息队列时，设置每次拉取消息1条setPrefetchCount(1);
* 注意，如果想进行消费端限流，那么消息必须手动确认，AcknowledgeMode为MANUAL



## 4. TTL(消息存活时间)

TTL 全称 Time To Live（存活时间/过期时间）。当消息到达存活时间后，还没有被消费，会被自动清除。

RabbitMQ可以对消息设置过期时间，也可以对整个队列（Queue）设置过期时间。

**注意：给单个消息设置过期时间没实际意义。**

![image-20191215164653426](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164653426.png)

### 4.1 TTL案例

**目标：演示消息队列中消息超时失效**

**实现步骤：**

1. 在RabbitMQ管理控制台中，新增消息队列`order.B`，并设置消息失效时间为5秒
2. 在RabbitMQ管理控制台中，将消息队列`order.B`绑定到交换机`order_exchange`上
3. 测试发送消息到消息队列order.B中，该队列没有消费者接收消息
4. 等待5秒，消息自动消失

**实现过程：**

1. 在RabbitMQ管理控制台中，新增消息队列`order.B`，并设置消息失效时间为5秒![image-20191227234400542](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227234400542.png)
2. 在RabbitMQ管理控制台中，将消息队列`order.B`绑定到交换机`order_exchange`上![image-20191227234448275](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227234448275.png)
3. 测试发送消息到消息队列order.B中，该队列没有消费者接收消息![image-20191227234533958](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227234533958.png)
4. 等待5秒，消息自动消失![image-20191227234601079](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227234601079.png)

设置消息失效时间：

![image-20191227235259582](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191227235259582.png)

### 4.2 小结

* 设置队列过期时间使用参数：x-message-ttl，单位：ms(毫秒)，会对整个队列消息统一过期。
* 由于队列是先进先出的，所以如果设置单个消息的过期时间并没有实际意义
  * 例如：设置消息A的过期时间为10秒，消息B的过期时间为5秒，但是先将消息A发送至队列，那么只有等消息A被消费或者到期移除后才会将消息B消费或者到期移除。

## 5. 死信队列

> 消息丢失，发送失败如何处理？任由消息消失？

死信队列：当消息成为Dead message后，可以被重新发送到另一个交换机，这个交换机就是Dead Letter Exchange（死信交换机 简写：DLX）。

![image-20191215164711777](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164711777.png)

**消息成为死信的三种情况：**

1. 队列消息长度到达限制；

2. 消费者拒接消息(basicNack)，并且不把消息重新放回源队列，requeue=false；

3. 源队列存在消息过期设置，消息到达超时时间未被消费；

**设置死信队列绑定死信交换机：**

给队列设置参数： x-dead-letter-exchange 和 x-dead-letter-routing-key

![image-20191215164722602](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164722602.png)

### 5.1 死信队列案例

**目标：演示消息队列中消息超时失效**

**实现步骤：**

1. 在RabbitMQ管理控制台中，创建死信队列`deadQueue`

2. 在RabbitMQ管理控制台中，创建死信交换机`deadExchange`

3. 死信队列绑定死信交换机，路由键为`order.dead`

4. 消息队列order.B绑定死信交换机

5. 向消息队列`order.B`中发送消息【消息队列order.B中的消息失效时间为5秒】

6. 在RabbitMQ管理控制台中，将消息队列`order.B`绑定到交换机`order_exchange`上

7. 等待5秒，消息队列order.B中的消息进入死信队列

**实现过程：**

1. 在RabbitMQ管理控制台中，创建死信队列`deadQueue`![image-20191228000211773](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228000211773.png)
2. 在RabbitMQ管理控制台中，创建死信交换机`deadExchange`![image-20191228000241915](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228000241915.png)
3. 死信队列绑定死信交换机，路由键为`order.dead`![image-20191228000315612](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228000315612.png)
4. 删除`order.B`消息队列，重建之后绑定死信交换机![image-20191228001106506](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228001106506.png)![image-20191228001121823](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228001121823.png)
5. 向消息队列`order.B`中发送消息【消息队列order.B中的消息失效时间为5秒】![image-20191228001257845](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228001257845.png)
6. 等待5秒，消息队列order.B中的消息进入死信队列![image-20191228001240771](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228001240771.png)

### 5.2 小结

1. 死信交换机和死信队列和普通的没有区别

2. 当消息成为死信后，如果该队列绑定了死信交换机，则消息会被死信交换机重新路由到死信队列

3. 消息成为死信的三种情况：
   * 队列消息长度到达限制；

   * 消费者拒接消费消息，并且不重回队列；

   * 原队列存在消息过期设置，消息到达超时时间未被消费；

## 6. 延迟队列

**什么是延迟队列？即消息进入队列后不会立即被消费，只有到达指定时间后，才会被消费。**

需求场景：

1. 下单后，30分钟未支付，取消订单，回滚车票。

2. 新用户注册成功7天后，发送短信问好。



















实现方法：

1. 定时器

2. 延迟队列

![image-20191215164748948](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164748948.png)

注意：在RabbitMQ中并未提供延迟队列功能。

但是可以使用：**TTL+死信队列** 组合实现延迟队列的效果。

![image-20191215164803451](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215164803451.png)

# 二、RabbitMQ 应用问题

##  2.1 消息幂等性处理【了解】

**==幂等性==**指一次和多次请求某一个资源，对于资源本身应该具有同样的结果。也就是说，其任意多次执行对资源本身所产生的影响均与一次执行的影响相同。

在MQ中指，消费多条相同的消息，得到与消费该消息一次相同的结果。

使用 **乐观锁机制** 保证消息的幂等操作原理；

> #### 乐观锁
>
> 总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号机制和CAS算法实现。**乐观锁适用于多读的应用类型，这样可以提高吞吐量**。

![image-20191228071153141](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228071153141.png)

第一次执行：version=1

![image-20191228140203670](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228140203670.png)

```sql
-- 先查询再更新：id=1,money=4000,version=1
update account set money=money-500,version=version+1 where id=1 and version=1;
```

![image-20191228140318964](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228140318964.png)

第二次执行：version=2，相同的SQL语句无法生效

```sql
update account set money=money-500,version=version+1 where id=1 and version=1;
```

第n次执行：version=2，只有第一次执行有效果！因为version为1

```sql
update account set money=money-500,version=version+1 where id=1 and version=1;
```

# 三、RabbitMQ 集群搭建

摘要：实际生产应用中都会采用消息队列的集群方案，如果选择RabbitMQ那么有必要了解下它的集群方案原理

一般来说，如果只是为了学习RabbitMQ或者验证业务工程的正确性那么在本地环境或者测试环境上使用其单实例部署就可以了，但是出于MQ中间件本身的可靠性、并发性、吞吐量和消息堆积能力等问题的考虑，在生产环境上一般都会考虑使用RabbitMQ的集群方案。

## 3.1 集群方案的原理

RabbitMQ这款消息队列中间件产品本身是基于Erlang编写，Erlang语言天生具备分布式特性（通过同步Erlang集群各节点的magic cookie来实现）。因此，RabbitMQ天然支持Clustering。集群是保证可靠性的一种方式，同时可以通过水平扩展以达到增加消息吞吐量能力的目的，这里只需要保证erlang_cookie的参数一致集群即可通信。

## 3.2 集群搭建

主要参考官方文档：https://www.rabbitmq.com/clustering.html

```shell
# docker run 命令解释
docker run --link 可以用来链接2个容器，使得源容器（被链接的容器）和接收容器（主动去链接的容器）之间可以互相通信。

# -p 映射一个端口 
# -v 挂载数据卷
# --name为当前容器设置一个别名
# -di 启动守护式容器
# -it 启动交互式容器
# 进入容器之后执行的命令/bin/bash
# -e 设置默认参数
# --hostname 设置当前容器中虚拟机的主机名称

# --link的格式: name:hostname
# name是源容器的名称；hostname是源容器在的hostname。
```



### 1. 启动三个启动RabbitMQ

```shell
# 1.1 启动RabbitMQ1
docker run  -d --hostname rabbitmq1 --name=m1 -p 15673:15672 -p 5673:5672 -e RABBITMQ_ERLANG_COOKIE='rabbitmqcookie' rabbitmq:management

# -e 注入参数，RABBITMQ_ERLANG_COOKIE: erlang_cookie参数，集群中的节点必须保持一致

# 1.2 启动RabbitMQ2
docker run -d --hostname rabbitmq2 --name=m2 -p 15674:15672 -p 5674:5672 --link m1:rabbitmq1  -e RABBITMQ_ERLANG_COOKIE='rabbitmqcookie' rabbitmq:management

# 1.3 启动RabbitMQ3
docker run -d --hostname rabbitmq3 --name m3 -p 15675:15672 -p 5675:5672 --link m2:rabbitmq2 --link m1:rabbitmq1 -e RABBITMQ_ERLANG_COOKIE='rabbitmqcookie' rabbitmq:management
```

### 2. 进入RabbitMQ容器m1，重置rabbitmq服务

1. 停止rabbitmq服务
2. 重置rabbitmq服务
3. 启动rabbitmq服务

```shell
#进入myrabbiratmq1容器 
docker exec -it m1 bash
#停止rabbit应用
rabbitmqctl stop_app
#重置rabbitmq
rabbitmqctl reset
#启动rabbit应用
rabbitmqctl start_app
```

### 3. 进入RabbitMQ容器m2，加入集群：连接节点1rabbitmq服务

1. 停止rabbitmq服务
2. 重置rabbitmq服务
3. 加入集群：连接节点1rabbitmq服务
4. 启动rabbitmq服务

```shell
#3.进入myrabbitmq2容器 
docker exec -it m2 bash
#停止rabbit应用
rabbitmqctl stop_app
#重置rabbitmq
rabbitmqctl reset
#加入集群 
rabbitmqctl join_cluster --ram rabbit@rabbitmq1
## --ram 设置内存节点
#启动rabbit应用
rabbitmqctl start_app
```

### 4. 进入RabbitMQ容器m3，加入集群：连接节点1rabbitmq服务

1. 停止rabbitmq服务
2. 重置rabbitmq服务
3. 加入集群：连接节点1rabbitmq服务
4. 启动rabbitmq服务

```shell
#4.进入myrabbitmq3容器 
docker exec -it m3 bash
#停止rabbit应用
rabbitmqctl stop_app
#重置rabbitmq
rabbitmqctl reset
#加入集群 硬盘节点
rabbitmqctl join_cluster rabbit@rabbitmq1
#启动rabbit应用
rabbitmqctl start_app
```

### 5.启动完成查看集群状态

```shell
#查看集群状态
rabbitmqctl cluster_status
```

**注意：**

​	**集群中必须至少存在一个磁盘节点！！！**

![image-20191228070903172](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228070903172.png)

## 3.3 集群存在问题

上述配置的RabbitMQ集群模式，并不能保证队列的高可用性，尽管交换机绑定队列的内容，可以复制到集群里的任何一个节点，但是队列内容不会复制，队列节点宕机直接导致该队列无法应用，只能等待节点重启，所以要想在队列节点宕机或故障也能正常应用，就要复制队列内容到集群里的每个节点，须要创建镜像队列。

镜像队列可以同步queue和message，当主queue挂掉，从queue中会有一个变为主queue来接替工作。

镜像队列是基于普通的集群模式的，所以你还是得先配置普通集群，然后才能设置镜像队列。

镜像队列设置后，会分一个主节点和多个从节点，如果主节点宕机，从节点会有一个选为主节点，原先的主节点起来后会变为从节点。

```shell
#设置镜像队列命令,随便在一台节点都可以执行
rabbitmqctl set_policy ha-all "^" '{"ha-mode":"all"}'
```

![image-20191228070841384](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228070841384.png)

然后将主节点停止后测试是否可以正常收发消息。

![image-20191228070817528](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191228070817528.png)

![image-20191215175634148](RabbitMQ%E9%AB%98%E7%BA%A7%20%E8%AE%B2%E4%B9%89.assets/image-20191215175634148.png)



