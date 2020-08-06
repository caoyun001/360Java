package com.itheima.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Es的配置类，将Es中的核心的客户端对象，注入Spring的容器中
 */
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@Component
public class ElatiscsearchHightLevelConfiguration {

    private String host = "127.0.0.1";//服务的host地址
    private int port = 9200;//服务端口

    //将ElasticSearch的核心RestHighLevelClient客户端对象，注入

    /**
     * Bean对象是有生命周期方法：销毁执行的方法，初始化执行的方法
     * @return
     */
    @Bean(destroyMethod = "close")
    public RestHighLevelClient client(){
        //对当前的url地址的一个封装对象
        HttpHost httpHost = new HttpHost(host, port, "http");
        //创建rest客户端构建器对象
        RestClientBuilder clientBuilder = RestClient.builder(httpHost);
        //创建高级别客户端对象
        return new RestHighLevelClient(clientBuilder);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
