package com.itheima.study.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/23
 * @description ：增删改查demo
 * @version: 1.0
 */
public class CRUDDemo {
    public static void main(String[] args) throws Exception {
        // 重试策略  每隔1s重试一次，共重试10次
        RetryPolicy retryPolicy = new RetryNTimes(10,1000);
        //构造客户端
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",retryPolicy);
        //启动
        client.start();

        ///////////////////////////查询目录//////////
        List<String> rootPaths = client.getChildren().forPath("/");
        System.out.println("[查询子目录]根节点:"+rootPaths);

        ///////////////////////////创建////////////
        //1-创建目录
        client.create().forPath("/a");
        //2-创建目录并制定数据
        client.create().forPath("/b","这是b节点的初始化数据".getBytes());
        //3-创建多级目录
        client.create().creatingParentsIfNeeded().forPath("/c/d");
        //4-指定模式
        //持久节点
        client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/e");
        //持久有序节点
        client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/f");
        //临时节点
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/g");
        //临时有序节点
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/h");
        System.out.println("[创建]完成，根节点:"+client.getChildren().forPath("/"));

        System.out.println("[创建]完成，输入任何字符继续……");
        System.in.read();

        ///////////////////////////查询数据////////////
        byte[] bytes = client.getData().forPath("/b");
        System.out.println("[查询]path：/b,value:"+new String(bytes));

        ///////////////////////////修改数据////////////
        client.setData().forPath("/b","这是b节点修改后的数据".getBytes());
        System.out.println("[修改]完成，path：/b,value:"+new String(client.getData().forPath("/b")));
        ///////////////////////////删除////////////
        client.delete().deletingChildrenIfNeeded().forPath("/a");
        client.delete().deletingChildrenIfNeeded().forPath("/b");
        client.delete().deletingChildrenIfNeeded().forPath("/c");
        client.delete().deletingChildrenIfNeeded().forPath("/e");
        System.out.println("[删除]完成，根节点:"+client.getChildren().forPath("/"));

        //关闭
        client.close();
    }
}
