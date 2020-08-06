package com.itheima;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 目标：索引库的操作
 * Java领域：一切皆对象，write once run anyway(JVM)，一次编写到处运行
 * 创建索引库
 *      1.请求的url路径(包含要做什么？)，请求体
 *      2.kibana(客户端)，postman、head、...restTemplate
 *      3.单击发送请求
 *      4.es服务接收请求之后，处理，返回响应信息
 *      5.关闭客户端，释放资源
 *      抽取步骤：
 *      1.创建请求对象(封装了操作)，http请求
 *      2.注入客户端对象，执行请求的发送，返回响应对象
 *      3.打印响应结果信息
 *      4.关闭客户端，释放资源，bean对象的生命周期方法destroy，init
 * 查看索引库
 * 删除索引库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01IndexOperation {

    //注入高级别客户端对象
    @Autowired
    private RestHighLevelClient client;

    //创建索引库
    @Test
    public void createIndex() throws IOException {
        //1.创建请求对象(封装了操作)，http请求
        CreateIndexRequest request = new CreateIndexRequest("heima");
        //2.注入客户端对象，执行请求的发送，返回响应对象
        IndicesClient indicesClient = client.indices();//返回的是创建索引的客户端对象：索引的新增，删除，配置映射等操作
        //执行创建索引的请求操作，第一个参数：创建索引的请求对象，第二个参数：当前请求对象的配置(请求头【空】，响应内容的缓存大小100m，异常的回调方法【默认空】)
        CreateIndexResponse response = indicesClient.create(request, RequestOptions.DEFAULT);
        //3.打印响应结果信息
        System.out.println("ack:"+response.isAcknowledged());
        System.out.println("index:"+response.index());
        //4.关闭客户端，释放资源，bean对象的生命周期方法destroy，init
        //client.close();
    }
    //查看索引库
    @Test
    public void getIndex() throws IOException {
        //1.创建请求对象：查询索引库
        GetIndexRequest request = new GetIndexRequest("heima");
        //2.客户端执行请求发送，返回响应对象
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        //3.打印结果信息
        System.out.println("aliases:"+response.getAliases());
        System.out.println("mappings:"+response.getMappings());
        System.out.println("settings:"+response.getSettings());
        //4.关闭客户端
        //client.close();
    }
    //删除索引库
    @Test
    public void deleteIndex() throws IOException {
        //1.创建请求对象
        DeleteIndexRequest request = new DeleteIndexRequest("heima");
        //2.客户端发送请求，获取响应对象
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        //3.打印结果信息
        System.out.println("ack:"+response.isAcknowledged());
    }

}
