package com.itheima;

import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 目标：映射操作
 *
 * 配置映射
 * 查看映射
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02PutMappingOperation {

    @Autowired
    private RestHighLevelClient client;

    //配置映射
    //1.创建请求对象
    //2.客户端发送请求，获取响应对象
    //3.打印结果信息
    @Test
    public void putMappingMethodOne() throws IOException {
        //1.创建请求对象：索引库、类型、请求体
        //传入构造函数：索引库的名称，
        PutMappingRequest request = new PutMappingRequest("heima");
        //类型默认值，在客户端6.8.0版本当中，不支持设置type：_doc
        String requestBodyStrJson ="{\n" +
                "  \"properties\": {\n" +
                "    \"title\":{\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"subtitle\":{\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"images\":{\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"index\": false\n" +
                "    },\n" +
                "    \"price\":{\n" +
                "      \"type\": \"double\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        //请求体
        request.source(requestBodyStrJson, XContentType.JSON);
        //2.客户端发送请求，获取响应对象
        AcknowledgedResponse response = client.indices().putMapping(request, RequestOptions.DEFAULT);
        //3.打印结果信息
        System.out.println("ack:"+response.isAcknowledged());
    }
    //第二种，方式创建请求体
    @Test
    public void putMappingMethodTwo() throws IOException {
        //1.创建请求对象：索引库、类型、请求体
        //传入构造函数：索引库的名称，
        PutMappingRequest request = new PutMappingRequest("heima1");
        //类型默认值，在客户端6.8.0版本当中，不支持设置type：_doc
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
        jsonBuilder.startObject()
                .startObject("properties")
                .startObject("title")
                .field("type","text").field("analyzer","ik_max_word")
                .endObject()
                .startObject("subtitle")
                .field("type","text").field("analyzer","ik_max_word")
                .endObject()
                .startObject("category")
                .field("type","keyword")
                .endObject()
                .startObject("brand")
                .field("type","keyword")
                .endObject()
                .startObject("images")
                .field("type","keyword").field("index",false)
                .endObject()
                .startObject("price")
                .field("type","float")
                .endObject()
                .endObject()
                .endObject();
        //请求体
        request.source(jsonBuilder);
        //2.客户端发送请求，获取响应对象
        AcknowledgedResponse response = client.indices().putMapping(request, RequestOptions.DEFAULT);
        //3.打印结果信息
        System.out.println("ack:"+response.isAcknowledged());
    }

}
