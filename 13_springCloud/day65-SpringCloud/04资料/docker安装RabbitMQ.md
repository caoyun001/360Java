## 安装及配置RabbitMQ

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

..