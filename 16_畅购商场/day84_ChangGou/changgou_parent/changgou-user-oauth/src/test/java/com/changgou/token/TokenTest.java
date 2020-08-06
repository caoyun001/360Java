package com.changgou.token;

import com.changgou.OAuthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@SpringBootTest(classes = OAuthApplication.class)
@RunWith(SpringRunner.class)
public class TokenTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 密码模式下-申请令牌测试
     */
    @Test
    public void testApplyToken(){
        String clientId = "wujintao"; //客户端应用的ID
        String clientSecret = "wujintao"; //客户端应用的密钥
        String username = "heima"; //用户（资源所有者）的用户名
        String password = "itcast"; //用户（资源所有者）的密码


        //1.获取及拼接URL
        String url = loadBalancerClient.choose("USER-AUTH").getUri() + "/oauth/token";

        //2.定义HTTP请求头Authorization （http basic）
        // Authorization 这个值的组成结构： Basic Base64(clientId:clientSecret)
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.set("Authorization", getHttpBasic(clientId, clientSecret));

        //3.定义OAuth2密码模式下申请令牌的业务参数
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.set("grant_type", "password"); // OAuth密码模式的值
        body.set("username", username );
        body.set("password",  password);

        //4.封装一个HTTP请求实例
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(body, headers);

        //5.执行POST发送请求
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                //对于401和400响应码，不抛异常
               if(response.getRawStatusCode()!=400 && response.getRawStatusCode()!=401){
                   super.handleError(response);
               }
            }
        });
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        //6.请求完成得到结果
        Map resultMap = response.getBody();
        if(resultMap!=null && resultMap.size()>0){
            for (Object key : resultMap.keySet()) {
                System.out.println(key + " <====> " + resultMap.get(key));
            }
        }

    }

    private String getHttpBasic(String clientId, String clientSecret){
        String str = clientId + ":" + clientSecret;
        str = Base64Utils.encodeToString(str.getBytes());
        return "Basic " + str;
    }
}
