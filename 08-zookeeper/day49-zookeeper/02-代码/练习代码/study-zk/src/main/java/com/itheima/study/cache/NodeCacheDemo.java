package com.itheima.study.cache;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryNTimes;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/23
 * @description ：监听节点变化demo
 * @version: 1.0
 */
public class NodeCacheDemo {
    public static void main(String[] args) throws Exception {
        // 重试策略  每隔1s重试一次，共重试10次
        RetryPolicy retryPolicy = new RetryNTimes(10,1000);
        //构造客户端
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",retryPolicy);
        //启动
        client.start();

        //构造cache
        NodeCache nodeCache = new NodeCache(client,"/hello/a");
        // true-立即去zookeeper进行一次查询
        nodeCache.start(true);

        //添加监听器
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                ChildData currentData = nodeCache.getCurrentData();
                if(null == currentData){
                    System.out.println("[监听]目录删除："+nodeCache.getPath());
                }else {
                    System.out.println("[监听]数据变化path:"+nodeCache.getPath()+",value:"+new String(currentData.getData()));
                }
            }
        });

        System.in.read();
        client.close();

    }
}
