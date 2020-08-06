package com.itheima;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 高亮查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05HighlighterQuery {

    //注入高级别客户端对象
    @Autowired
    private RestHighLevelClient client;

    //请求体查询-基本查询
    //1.创建请求对象
    //2.客户端发送请求，获取响应对象
    //3.打印结果信息
    @Test
    public void HighlighterQuery() throws IOException {
        //1.创建请求对象
        SearchRequest request = new SearchRequest().indices("heima1").types("_doc");
        //构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //：：：term查询：不带分词器，查询条件作为关键词
        sourceBuilder.query(QueryBuilders.matchQuery("title","小米手机"));

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");//标签的前缀
        highlightBuilder.postTags("</font>");//标签的后缀
        //设置高亮的字段
        highlightBuilder.field("title");
        //设置高亮查询
        sourceBuilder.highlighter(highlightBuilder);


        request.source(sourceBuilder);
        //2.客户端发送请求，获取响应对象
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //3.打印结果信息
        printResult(response);
    }

    /**
     * 打印结果信息
     */
    private void printResult(SearchResponse response) {
        SearchHits hits = response.getHits();
        System.out.println("took:"+response.getTook());
        System.out.println("timeout:"+response.isTimedOut());
        System.out.println("total:"+hits.getTotalHits());
        System.out.println("MaxScore:"+hits.getMaxScore());
        System.out.println("hits========>>");
        for (SearchHit hit : hits) {
            //输出每条查询的结果信息
            System.out.println(hit.getSourceAsString());
            //打印高亮的信息
            System.out.println(hit.getHighlightFields());
        }
        System.out.println("<<========");
    }
}
