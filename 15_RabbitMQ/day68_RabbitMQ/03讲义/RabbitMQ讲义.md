

# 学习目标

- 能够说出什么是消息队列，并知晓消息队列的应用场景
- 能够说出RabbitMQ的5种模式特征
- 能够安装RabbitMQ
- 能够使用SpringBoot整合RabbitMQ

# 一、消息队列MQ概述

MQ全称为Message Queue，消息队列是应用程序和应用程序之间的通信方法。

RabbitMQ是一个Erlang开发的AMQP（Advanced Message Queuing Protocol ）的开源实现。

## 1.1 为什么使用MQ

在项目中，可将一些无需即时返回且耗时的操作提取出来，进行异步处理，而这种异步处理的方式大大的节省了服务器的请求响应时间，从而提高了系统的吞吐量。

开发中消息队列通常有如下应用场景：

**(1) 异步提速: **

​	任务异步处理将不需要同步处理的并且耗时长的操作由消息队列通知消息接收方进行异步处理。提高了应用程序的响应时间。

**(2) 应用解耦: **

​	应用程序解耦合，MQ充当中介，生产方通过MQ与消费方交互，它将应用程序进行解耦合

**(3) 削峰填谷: **

​	在访问量剧增的情况下，应用仍然需要继续发挥作用，但是这样的突发流量并不常见；如果为以能处理这类峰值访问为标准来投入资源随时待命无疑是巨大的浪费。使用MQ能够使关键组件顶住突发的访问压力，而不会因为突发的超负荷的请求而完全崩溃。

**(4) 可恢复性: **

​	系统的一部分组件失效时，不会影响到整个系统。MQ降低了进程间的耦合度，所以即使一个处理消息的进程挂掉，加入队列中的消息仍然可以在系统恢复后被处理。

**(5) 排序保证：**

​     消息队列可以控制数据处理的顺序，因为消息队列本身使用的是队列这个数据结构，`FIFO`(先进选出)，在一些场景数据处理的顺序很重要，比如商品下单顺序等。

## 1.2. 消息队列产品

市场上常见的消息队列有如下：

- ActiveMQ：基于JMS实现, 比较均衡, 不是最快的, 也不是最稳定的.
- ZeroMQ：基于C语言开发, 目前最好的队列系统.
- RabbitMQ：基于AMQP协议，erlang语言开发，稳定性好, 数据基本上不会丢失
- RocketMQ：基于JMS，阿里巴巴产品, 目前已经捐献给apahce, 还在孵化器中孵化.
- Kafka：类似MQ的产品；分布式消息系统，高吞吐量, 目前最快的消息服务器, 不保证数据完整性.

##  1.3. AMQP 和 JMS

> Dubbo协议：Dubbo 缺省协议采用单一长连接和 NIO 异步通讯，适合于小数据量大并发的服务调用，以及服务消费者机器数远大于服务提供者机器数的情况。
>
> HTTP协议（HyperText Transfer Protocol，超文本传输协议）是因特网上应用最为广泛的一种网络传输协议，所有的WWW文件都必须遵守这个标准。
>
> AMQP协议：即Advanced Message Queuing Protocol，一个提供统一消息服务的应用层标准高级消息队列协议，是应用层协议的一个开放标准，为面向消息的中间件设计。

MQ是消息通信的模型；实现MQ的大致有两种主流方式：AMQP、JMS。

### 1.3.1. AMQP

AMQP，即Advanced Message Queuing Protocol，一个提供统一消息服务的应用层标准高级消息队列协议，是应用层协议的一个开放标准，为面向消息的中间件设计。更准确的说是一种binary wire-level protocol（链接协议）。这是其和JMS的本质差别，AMQP不从API层进行限定，而是直接定义网络交换的数据格式。

### 1.3.2. JMS

JMS即Java消息服务（JavaMessage Service）应用程序接口，是一个Java平台中关于面向消息中间件（MOM）的API，用于在两个应用程序之间，或分布式系统中发送消息，进行异步通信。

### 1.3.3. AMQP 与 JMS 区别

JMS是定义了统一的接口，来对消息操作进行统一；AMQP是通过规定协议来统一数据交互的格式JMS限定了必须使用Java语言；AMQP只是协议，不规定实现方式，因此是跨语言的。JMS规定了两种消息模式；而AMQP的消息模式更加丰富.

|        | JMS      |     AMQP      |
| ------ | -------- | :-----------: |
| 定义   | Java api | Wire-protocol |
| 跨语言 | 否       |      是       |
| 跨平台 | 否       |      是       |

## 1.4. RabbitMQ

RabbitMQ是由erlang语言开发，基于AMQP（Advanced Message Queue 高级消息队列协议）协议实现的消息队列，它是一种应用程序之间的通信方法，**消息队列在分布式系统开发中应用非常广泛。**

RabbitMQ官方地址：http://www.rabbitmq.com/

RabbitMQ提供了6种模式：Hello Word简单模式，work工作模式，Publish/Subscribe发布与订阅模式，Routing路由模式，Topics主题模式(通配符模式)，RPC远程调用模式（远程调用，不太算MQ；不作介绍）

官网对应模式介绍：https://www.rabbitmq.com/getstarted.html

### **应用场景：**

### **1、双十一商品秒杀/抢票功能实现**

我们在双11的时候，当我们凌晨大量的秒杀和抢购商品，然后去结算的时候，就会发现，界面会提醒我们，让我们稍等，以及一些友好的图片文字提醒。而不是像前几年的时代，动不动就页面卡死，报错等来呈现给用户。

### **2、积分兑换(积分可用于多平台)**

积分兑换模块，有一个公司多个部门都要用到这个模块，这时候就可以通过消息队列解耦这个特性来实现。 各部门系统做各部门的事，但是他们都可以用这个积分系统进行商品的兑换等。其他模块与积分模块完全解耦。

### **3、大平台用户注册**

发送邮件、用户大数据分析操作等 基于同步变异步功能实现

用户注册真实操作步骤：

1. 用户注册选择的兴趣标签，根据用户的属性，行为进行用户分析，计算出推荐内容
2. 注册后可能需要发送邮件给用户
3. 发送短信给用户
4. 发送给用户指南的系统通知
5. ...等等

**正常情况注册，不出现高并发，假如有大量的用户注册，发生了高并发，就会出现如下情况**：

邮件接口承受不住，或是分析信息时的大量计算使 cpu 满载，这将会出现虽然用户数据记录很快的添加到数据库中了，但是却卡在发邮件或分析信息时的情况，导致请求的响应时间大幅增长，甚至出现超时，这就有点不划算了。面对这种情况一般也是将这些操作放入消息队列（生产者消费者模型），消息队列慢慢的进行处理，同时可以很快的完成注册请求，不会影响用户使用其他功能。

## 1.5 相关定义：

- **Connection：**publisher／consumer 和 broker 之间的 TCP 连接
- **Channel：** 消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务
- **Exchange：** 消息交换机，它指定消息按什么规则，路由到哪个队列
- **Queue：** 消息队列载体，每个消息都会被投入到一个或多个队列
- **VHost：** 虚拟主机，一个broker里可以开设多个vhost，用作不同用户的权限分离。

![image-20191226053108367](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226053108367.png)

==**由Exchange、Queue、RoutingKey三个才能决定一个消息从Exchange到Queue的唯一的线路。**==

# 二、安装及配置RabbitMQ

## 2.1. docker中安装RabbitMq

- 下载镜像 

```shell
docker pull rabbitmq:management
```

- 创建容器 

```shell
docker run -di --name=changgou_rabbitmq -p 5671:5617 -p 5672:5672 -p4369:4369 -p 15671:15671 -p 15672:15672 -p 25672:25672 rabbitmq:management
```

```
解释如下：
15672 (if management plugin is enabled.管理界面 )

15671 management监听端口

5672, 5671 (AMQP 0-9-1 without and with TLS 消息队列协议是一个消息协议)

4369 (epmd) epmd 代表 Erlang 端口映射守护进程

25672 (Erlang distribution)
```

- 访问后台 

浏览器中输入地址

```shell
http://192.168.200.128:15672/
```

- 设置容器开机自动启动

```shell
docker update --restart=always 容器ID
```

![image-20191224135410717](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224135410717.png)

## 2.2. 用户以及Virtual Hosts配置

### 2.2.1. 用户角色

RabbitMQ在安装好后，可以访问http://localhost:15672；其自带了guest/guest的用户名和密码；如果需要创建自定义用户；那么也可以登录管理界面后，如下操作：

![image-20191224130727629](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224130727629.png)

**角色说明：**

1、超级管理员(administrator)可登陆管理控制台，可查看所有的信息，并且可以对用户，策略(policy)进行操作。

2、监控者(monitoring)可登陆管理控制台，同时可以查看rabbitmq节点的相关信息(进程数，内存使用情况，磁盘使用情况等)

3、策略制定者(policymaker)可登陆管理控制台, 同时可以对policy进行管理。但无法查看节点的相关信息(上图红框标识的部分)。

4、普通管理者(management)仅可登陆管理控制台，无法看到节点信息，也无法对策略进行管理。

5、其他无法登陆管理控制台，通常就是普通的生产者和消费者。

### 2.2.2. Virtual Hosts配置

RabbitMQ的权限管理；在RabbitMQ中可以虚拟消息服务器Virtual Host，每个Virtual Hosts相当于一个相对独立的RabbitMQ服务器，每个VirtualHost之间是相互隔离的。exchange、queue、message不能互通。相当于mysql的db。Virtual Name一般以/开头。

1. 创建Virtual Hosts

   ![image-20191224130914131](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224130914131.png)

2. 设置Virtual Hosts权限

   ![image-20191224131458585](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224131458585.png)

   

   ![image-20191224131421263](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224131421263.png)

### 2.2.3 添加队列

![image-20191224131854869](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224131854869.png)

持久化：如果选durable，则队列消息自动持久化到磁盘上，如果选transient，则不会持久化；

自动删除：默认值no，如果yes，则在消息队列没有使用的情况下，队列自行删除。

### 2.2.4 添加交换机

![image-20191224132241282](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224132241282.png)

自动删除：默认值no，如果是yes，则在将所有队列与交换机取消绑定之后，交换机将自动删除。

交换机类型：

- fanout：广播类型
- direct：路由类型
- topic：通配符类型，基于消息的路由键路由
- headers：通配符类型，基于消息的header路由

内部交换器：默认值no，如果是yes，消息无法直接发送到该交换机，必须通过交换机的转发才能到达次交换机。本交换机只能与交换机绑定。

### 2.2.5 队列与交换机进行绑定

![image-20191224132352207](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224132352207.png)

![image-20191224132603345](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224132603345.png)

# 三、Spring Boot整合RabbitMQ

## 3.1. 简介

在spring boot项目中，只需要引入start-amqp起步依赖，即可整合RabbitMQ成功；我们基于SpringBoot封装的RabbitTemplate模板对象，可以非常方便的发送消息，接收消息(使用注解)。

amqp的官方GitHub地址：https://github.com/spring-projects/spring-amqp

一般在开发过程中，我们有两个角色：

![image-20191224123350539](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224123350539.png)

## **3.2. 搭建步骤：**

**1、创建父工程：**

**2、生产者工程：**

1. 创建SpringBoot工程：rabbitmq-producer
2. 勾选起步依赖坐标：spring for RabbitMQ
3. 配置RabbitMQ：服务host地址及端口、虚拟主机、服务账户密码

**3、消费者工程：**

1. 创建SpringBoot工程：
2. 勾选起步依赖坐标：spring for RabbitMQ
3. 配置RabbitMQ：服务host地址及端口、虚拟主机、服务账户密码

## 3.3. 搭建过程：

### 3.3.1 创建父工程：

创建父maven空的工程：springboot-rabbitmq-parent

![image-20191224124426479](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224124426479.png)

### 3.3.2 搭建生产者工程

#### 1、创建工程

创建SpringBoot的生产者工程：rabbitmq-producer

![image-20191224124514886](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224124514886.png)

#### 2、起步依赖坐标

![image-20191224124625375](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224124625375.png)

pom.xml文件内容为如下：

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.9.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
<dependencies>
    <!--amqp协议的起步依赖坐标-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <!--rabbit测试依赖坐标-->
    <dependency>
        <groupId>org.springframework.amqp</groupId>
        <artifactId>spring-rabbit-test</artifactId>
        <scope>test</scope>
    </dependency>
    <!--SpringBoot测试依赖坐标-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### 3、启动类

```java
@SpringBootApplication
public class SpringbootRabbitmqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqProducerApplication.class, args);
    }
}
```

#### 4、配置RabbitMQ

1）配置文件application.properties，内容如下：

```properties
# RabbitMQ 服务host地址
spring.rabbitmq.host=192.168.200.128
# 端口
spring.rabbitmq.port=5672
# 虚拟主机地址
spring.rabbitmq.virtual-host=/itheima
# rabbit服务的用户名
spring.rabbitmq.username=heima
# rabbit服务的密码
spring.rabbitmq.password=heima
```



### 3.3.3 搭建消费者工程

#### 1、创建工程

创建SpringBoot的消费者工程：rabbitmq-consumer

![image-20191224125050553](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224125050553.png)

#### 2、勾选起步依赖坐标

![image-20191224125207084](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191224125207084.png)

pom.xml文件内容为如下：

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.9.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
<dependencies>
    <!--amqp的起步依赖坐标-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
</dependencies>
```

#### 3、启动类

```java
@SpringBootApplication
public class SpringbootRabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqConsumerApplication.class, args);
    }

}
```

#### 4、配置RabbitMQ

application.properties，内容如下:

```properties
# RabbitMQ 服务host地址
spring.rabbitmq.host=192.168.200.128
# 端口
spring.rabbitmq.port=5672
# 虚拟主机地址
spring.rabbitmq.virtual-host=/itheima
# rabbit服务的用户名
spring.rabbitmq.username=heima
# rabbit服务的密码
spring.rabbitmq.password=heima
```



# 四、RabbitMQ五种工作模式【重要】

## 4.1 Hello World简单模式

### 4.1.1 什么是简单模式

![1575274339325](RabbitMQ%E8%AE%B2%E4%B9%89.assets/1575274339325.png)

在上图的模型中，有以下概念：

**P：生产者: **  也就是要发送消息的程序

**C：消费者：**消息的接受者，会一直等待消息到来。

**queue：**消息队列，图中红色部分。可以缓存消息；生产者向其中投递消息，消费者从其中取出消息。

【最简单消息队列模式】

### 4.1.2 RabbitMQ管理界面操作

- 创建simple_queue队列用于演示Hello World简单模式


![07](images\07.png)

- 点击 `simple_queue` 可以进入到这个queue的管理界面


![08](images\08.png)

- 点击 `Get Message` 按钮可以获取查看队列中的消息


![09](images\09.png)

### 4.1.3 生产者代码

- rabbitmq-producer项目测试代码如下:


```java
package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01TestSimpleQueue {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //向消息队列发送一条简单消息
        /**
         * 参数1：消息队列名称
         * 参数2：消息内容
         */
        rabbitTemplate.convertAndSend("simple_queue","hello 小兔子！");
    }
}

```



### 4.1.4 消费者代码

- rabbitmq-consumer项目创建监听器:


```java
package com.itheima.rabbitmq.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者，接收消息队列消息监听器
 * 必须将当前监听器对象注入Spring的容器中
 */
@Component
@RabbitListener(queues = "simple_queue")
public class SimpleListener {

    @RabbitHandler
    public void simpleHandler(String msg){
        System.out.println("=====接收消息====>"+msg);
    }
}

```

然后启动SpringbootRabbitmqConsumerApplication, 就可以接收到RabbitMQ服务器发送来的消息



## 4.2 Work queues工作队列模式

### 4.2.1 什么是工作队列模式

![image-20191205102457994](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191205102457994.png)

Work Queues与入门程序的简单模式相比，多了一个或一些消费端，多个消费端共同消费同一个队列中的消息。**应用场景：对于任务过重或任务较多情况使用工作队列可以提高任务处理的速度。**

**在一个队列中如果有多个消费者，那么消费者之间对于同一个消息的关系是竞争的关系。**

【多个节点分片任务处理，提升任务处理的效率】

### 4.2.2 RabbitMQ管理界面操作

- 创建 `work_queue` 队列用于演示work工作队列模式


![12](images\12.png)

### 4.2.3 生产者代码

rabbitmq-producer项目测试代码如下:

```java
package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02TestWorkQueue {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void contextLoads() {
        //向工作队列发送1千条消息
        for (int i = 0; i < 1000; i++) {
            /**
             * 参数1：消息队列名称
             * 参数2：消息内容
             */
            rabbitTemplate.convertAndSend("work_queue","hello 我是小兔子【"+i+"】！");
        }
    }
}
```



### 4.2.4 消费者代码

- rabbitmq-consumer项目创建监听器1:


```java
package com.itheima.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 工作队列：消费者接收监听器1，接收来自消息队列中的消息
 */
@Component
@RabbitListener(queues = "work_queue")
public class WorkListener1 {

    @RabbitHandler
    public void workHandler(String msg){
        System.out.println("=====工作队列接收消息端1====>"+msg);
    }
}

```

- rabbitmq-consumer项目创建监听器2:


```java
package com.itheima.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 工作队列：消费者接收监听器2，接收来自消息队列中的消息
 */
@Component
@RabbitListener(queues = "work_queue")
public class WorkListener2 {

    @RabbitHandler
    public void workHandler(String msg){
        System.out.println("=====工作队列消息接收端2====>"+msg);
    }
}
```

## 4.3 三种模式概览

![image-20191205102917088](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191205102917088.png)

前面2个案例中，只有3个角色：

- P：生产者，也就是要发送消息的程序

- C：消费者：消息的接受者，会一直等待消息到来。

- queue：消息队列，图中红色部分

  

而在订阅模型中，多了一个exchange角色，而且过程略有变化：

- P：生产者，也就是要发送消息的程序，但是不再发送到队列中，而是发给X（交换机）
- C：消费者，消息的接受者，会一直等待消息到来。
- Queue：消息队列，接收消息、缓存消息。
- Exchange：交换机，图中的X。一方面，接收生产者发送的消息。另一方面，知道如何处理消息，例如递交给某个特别队列、递交给所有队列、或是将消息丢弃。到底如何操作，取决于Exchange的类型。



Exchange有常见以下3种类型：

- **Fanout：广播**  将消息交给所有绑定到交换机的队列, 不处理路由键。只需要简单的将队列绑定到交换机上。**fanout 类型交换机转发消息是最快的。**

- **Direct：定向**  把消息交给符合指定routing key 的队列. 处理路由键。需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。如果一个队列绑定到该交换机上要求路由键 “dog”，则只有被标记为 “dog” 的消息才被转发，不会转发 dog.puppy，也不会转发 dog.guard，只会转发dog。

  **其中，路由模式使用的是 direct 类型的交换机。**

- **Topic：主题(通配符)**  把消息交给符合routing pattern（路由模式）的队列. 将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。符号 “#” 匹配一个或多个词，符号"\*"匹配不多不少一个词。因此“audit.#” 能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到 “audit.irs”。

  **其中，主题模式(通配符模式)使用的是 topic 类型的交换机。**

  

**Exchange（交换机）只负责转发消息，不具备存储消息的能力，因此如果没有任何队列与Exchange绑定，或者没有符合路由规则的队列，那么消息会丢失**



## 4.4 Publish/Subscribe发布与订阅模式

### 4.4.1 什么是发布订阅模式

![image-20191205102917088](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191205102917088-1577312524234.png)

发布订阅模式： 

​	1、每个消费者监听自己的队列。 

​	2、生产者将消息发给broker，由交换机将消息转发到绑定此交换机的每个队列，每个绑定交换机的队列都将接收到消息

【广播消息：一次性将消息发送给所有消费者，每个消费者收到消息均一致】

### 4.4.2 RabbitMQ管理界面操作

- 创建两个队列 fanout_queue1和 fanout_queue2

![image-20191226053743533](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226053743533.png)

- 创建Exchange交换器 `fanout_exchange`

![image-20191226053920763](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226053920763.png)

- 将创建的fanout_exchange交换器和 fanout_queue1,  fanout_queue2队列绑定

![image-20191226054038545](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226054038545.png)

### 4.4.3 生产者代码

- rabbitmq-producer项目测试代码如下:

```java
package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 目标：将消息发送给交换机，通过交换机广播给消息队列，路由键为空字符串
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03TestPublishAndSubscribe {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //向广播交换机发送1千条消息
        for (int i = 0; i < 1000; i++) {
            /**
             * 参数1：交换机名称
             * 参数2：路由键
             * 参数3：消息内容
             */
            rabbitTemplate.convertAndSend("fanout_exchange","","hello 我是小兔子【"+i+"】！");
        }
    }
}

```



### 4.4.4 消费者代码

- rabbitmq-consumer项目创建监听器:

```java
package com.itheima.rabbitmq.pubandsub;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅模式：消息监听1
 */
@Component
@RabbitListener(queues = "fanout_queue1")
public class PubAndSubListener1 {

    @RabbitHandler
    public void pubAndSubHandler(String msg){
        System.out.println("=====发布订阅模式接收消息端【1】=====>"+msg);
    }
}


```

- rabbitmq-consumer项目创建监听器:

```java
package com.itheima.rabbitmq.pubandsub;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅模式：消息监听2
 */
@Component
@RabbitListener(queues = "fanout_queue2")
public class PubAndSubListener2 {

    @RabbitHandler
    public void pubAndSubHandler(String msg){
        System.out.println("=====发布订阅模式接收消息端【2】=====>"+msg);
    }
}
```



## 4.5 Routing路由模式

### 4.5.1 什么是路由模式

路由模式特点：队列与交换机的绑定，不能是任意绑定了，而是要指定一个RoutingKey（路由key）消息的发送方在向 Exchange发送消息时，也必须指定消息的RoutingKey。Exchange不再把消息交给每一个绑定的队列，而是根据消息的Routing Key进行判断，只有队列的Routingkey与消息的Routing key完全一致，才会接收到消息.

![image-20191205103846484](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191205103846484.png)

图解：

P：生产者，向Exchange发送消息，发送消息时，会指定一个routing key。

X：Exchange（交换机），接收生产者的消息，然后把消息递交给与routing key完全匹配的队列

C1：消费者，其所在队列指定了需要routing key 为 error 的消息

C2：消费者，其所在队列指定了需要routing key 为 info、error、warning 的消息

【有选择性的接收消息】

### 4.5.2 RabbitMQ管理界面操作

1. 创建两个队列分别叫做 `routing_queue1` 和 `routing_queue2` 用户演示![image-20191226055442517](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226055442517.png)

2. 创建交换器 `routing_exchange` , 类型为 `direct` , 用于演示路由模式![image-20191226055720887](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226055720887.png)

3. 设置绑定: 将创建的交换器` routing_exchange` 和 `routing_queue1 `, `routing_queue2` 绑定在一起, 路由键Routing Key分别为 `info` 和 `error`；![image-20191226055838905](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226055838905.png)



### 4.5.3 生产者代码

- rabbitmq-producer项目测试代码如下:

```java
package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 目标：将消息发送给交换机，通过交换机路由给指定的消息队列，通过路由键类指定
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo04TestRoutingModel {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //向路由交换机发送1千条消息
        for (int i = 0; i < 1000; i++) {
            /**
             * 参数1：交换机名称
             * 参数2：路由键:error , info ，指定要投递的消息队列
             * 参数3：消息内容
             */
            if(i%2 == 0){
                rabbitTemplate.convertAndSend("routing_exchange","info","hello 我是小兔子【"+i+"】！");
            } else {
                rabbitTemplate.convertAndSend("routing_exchange","error","hello 我是小兔子【"+i+"】！");
            }
        }
    }
}
```



### 4.5.4 消费者代码

- rabbitmq-consumer项目创建监听器:

```java
package com.itheima.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 路由模式：消息队列接收监听器1，接收来自路由模式发送的消息
 */
@Component
@RabbitListener(queues = "routing_queue1")
public class RoutingListener1 {

    @RabbitHandler
    public void routingHandler(String msg){
        System.out.println("=====路由模式消息接收监听器【1】=====>"+msg);
    }
}

```

- rabbitmq-consumer项目创建监听器:

```java
package com.itheima.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 路由模式：消息队列接收监听器2，接收来自路由模式发送的消息
 */
@Component
@RabbitListener(queues = "routing_queue2")
public class RoutingListener2 {

    @RabbitHandler
    public void routingHandler(String msg){
        System.out.println("=====路由模式消息接收监听器【2】=====>"+msg);
    }
}
```



## 4.6 Topics通配符模式(主题模式)

### 4.6.1 什么是通配符(主题)模式

`Topic`类型与`Direct`相比，都是可以根据RoutingKey把消息路由到不同的队列。只不过Topic类型Exchange可以让队列在绑定Routing key的时候使用通配符！

`Routingkey`: 一般都是有一个或多个单词组成，多个单词之间以”.”分割，例如：`item.insert`

通配符规则：

#：匹配一个或多个词，多个词用点号分隔

*：匹配不多不少恰好1个词

举例：

**item.#：** 能够匹配`item.insert.abc.bbc`或者`item.insert`

**item.*：**只能匹配`item.insert`

![image-20191205104428234](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191205104428234.png)

【基于通配符接收消息】

### 4.6.2 RabbitMQ管理界面操作

1. 创建队列 `topic_queue1` 和 `topic_queue1`![image-20191226060931347](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226060931347.png)

2. 创建交换器 `topic_exchange` , type类型为 `topic`![image-20191226061017346](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226061017346.png)

3. 设置绑定: 

   ​	`topic_queue1`绑定的Routing Key路由键为`item.*`

   ​	`topic_queue2`绑定的Routing Key路由键为`item.#`![image-20191226061135494](RabbitMQ%E8%AE%B2%E4%B9%89.assets/image-20191226061135494.png)



### 4.6.3 生产者代码

- rabbitmq-producer项目测试代码如下:

```java
package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 目标：将消息发送给交换机，通过交换机路由给指定的消息队列，路由键使用通配符
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05TestTopicModel {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //向通配符交换机发送消息
        rabbitTemplate.convertAndSend("topic_exchange","item.insert","hello 我是小兔子，路由键item.insert");
        rabbitTemplate.convertAndSend("topic_exchange","item.insert.abc","hello 我是小兔子，路由键：item.insert.abc");
    }
}

```



### 4.6.4 消费者代码

- rabbitmq-consumer项目创建监听器:

```java
package com.itheima.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 通配符模式：消息队列接收监听器1，接收来自通配符模式发送的消息
 *
 */
@Component
@RabbitListener(queues = "topic_queue1")
public class TopicListener1 {

    @RabbitHandler
    public void topicHandler(String msg){
        System.out.println("=====通配符模式消息接收监听器【1】=====>"+msg);
    }
}
```

- rabbitmq-consumer项目创建监听器:

```java
package com.itheima.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 通配符模式：消息队列接收监听器1，接收来自通配符模式发送的消息
 *
 */
@Component
@RabbitListener(queues = "topic_queue2")
public class TopicListener2 {

    @RabbitHandler
    public void topicHandler(String msg){
        System.out.println("=====通配符模式消息接收监听器【2】=====>"+msg);
    }
}
```



## 4.7 模式总结RabbitMQ

工作模式：

**1、简单模式 HelloWorld : ** 一个生产者、一个消费者，不需要设置交换机（使用默认的交换机）

**2、工作队列模式 Work Queue:**  一个生产者、多个消费者（竞争关系），不需要设置交换机（使用默认的交换机）

**3、发布订阅模式 Publish/subscribe: **需要设置类型为**==fanout==**的交换机，并且交换机和队列进行绑定，当发送消息到交换机后，交换机会将消息广播发送到绑定的队列

**4、路由模式 Routing: ** 需要设置类型为**==direct==**的交换机，交换机和队列进行绑定，并且指定routing key，当发送消息到交换机后，交换机会根据routing key将消息发送到对应的队列

**5、通配符模式 Topic: ** 需要设置类型为==**topic**==的交换机，交换机和队列进行绑定，并且指定通配符方式的routing key，当发送消息到交换机后，交换机会根据routing key将消息发送到对应的队列





















