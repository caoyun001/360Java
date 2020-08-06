package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Goods;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ml.DeleteCalendarRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 目标：文档的操作
 * 1.新增文档
 * 2.修改
 * 3.根据id查询文档
 * 4.删除
 * 5.批量操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03DocumentOperation {

    @Autowired
    private RestHighLevelClient client;

    //新增文档
    //1.创建请求对象
    //2.客户端发送请求，获取响应对象
    //3.打印结果信息
    @Test
    public void saveDoc() throws IOException {
        //1.创建请求对象(创建索引库CreateIndexRequest)，索引库名称、类型名称、主键id
        IndexRequest request = new IndexRequest().index("heima1").type("_doc");
        //请求体，三种方式，
        // 1.1.直接写入字符串【太简单，不演示】

        // 1.2.写一个Goods对象将对象转为json字符串
//        Goods goods = Goods.builder().id(1L).title("小米手机").category("手机").brand("小米").price(19999.0).build();
//        //将对象转换为json字符串
//        ObjectMapper objectMapper = new ObjectMapper();
//        String goodsJsonStr = objectMapper.writeValueAsString(goods);
//        request.source(goodsJsonStr, XContentType.JSON);


        // 1.3.直接在source中写入key-value参数
        request.source(XContentType.JSON,"title","小米手机","id","2","brand","小米","category","手机","price","2699");

        //2.客户端发送请求，获取响应对象
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        ////3.打印结果信息
        System.out.println("_index:"+response.getIndex());
        System.out.println("_type:"+response.getType());
        System.out.println("_id:"+response.getId());
        System.out.println("_result:"+response.getResult());
    }
    //修改文档
    @Test
    public void update() throws IOException {
        //1.创建请求对象(创建索引库CreateIndexRequest)，索引库名称、类型名称、主键id
        UpdateRequest request = new UpdateRequest().index("heima1").type("_doc").id("1");
        //设置请求体
        request.doc(XContentType.JSON,"title","小米手机","id","2","brand","小米","category","手机","price","2699");

        //2.客户端发送请求，获取响应对象
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        ////3.打印结果信息
        System.out.println("_index:"+response.getIndex());
        System.out.println("_type:"+response.getType());
        System.out.println("_id:"+response.getId());
        System.out.println("_result:"+response.getResult());
    }
    //查询文档
    @Test
    public void getDoc() throws IOException {
        //1.创建请求对象
        GetRequest request = new GetRequest().index("heima1").type("_doc").id("1");
        //2.客户端发送请求，获取响应对象
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        ////3.打印结果信息
        System.out.println("_index:"+response.getIndex());
        System.out.println("_type:"+response.getType());
        System.out.println("_id:"+response.getId());
        System.out.println("source:"+response.getSourceAsString());
    }
    //删除文档
    @Test
    public void deleteDoc() throws IOException {
        //创建请求对象
        DeleteRequest request = new DeleteRequest().index("heima1").type("_doc").id("1");
        //客户端发送请求，获取响应对象
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        //打印信息
        System.out.println(response.toString());
    }
    //批量新增操作
    @Test
    public void bulkSave() throws IOException {
        //创建请求对象
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("heima1").type("_doc").id("1").source(XContentType.JSON,"title","小米手机"));
        request.add(new IndexRequest().index("heima1").type("_doc").id("2").source(XContentType.JSON,"title","苹果手机"));
        request.add(new IndexRequest().index("heima1").type("_doc").id("3").source(XContentType.JSON,"title","华为手机"));
        //客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("took:"+responses.getTook());
        System.out.println("items:"+responses.getItems());
    }
    //批量删除操作
    @Test
    public void bulkDelete() throws IOException {
        //创建请求对象
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("heima1").type("_doc").id("1"));
        request.add(new DeleteRequest().index("heima1").type("_doc").id("2"));
        request.add(new DeleteRequest().index("heima1").type("_doc").id("3"));
        //客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("took:"+responses.getTook());
        System.out.println("items:"+responses.getItems());
    }

}
