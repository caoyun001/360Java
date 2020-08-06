package com.changgou.oauth.service;

import com.changgou.oauth.util.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${auth.ttl}")
    private Long ttl; //redis过期时间

    @Override
    public AuthToken applyToken(String clientId, String clientSecret, String username, String password) {

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
        Object accessToken = null;
        Object jti = null;
        Object refreshToken = null;
        if(resultMap!=null){
            accessToken = resultMap.get("access_token");
            jti = resultMap.get("jti");
            refreshToken = resultMap.get("refresh_token");
        }
        if(resultMap==null || accessToken==null || jti==null || refreshToken==null){
            throw new RuntimeException("申请令牌失败！");
        }

        //封装令牌结果对象
        AuthToken authToken = new AuthToken();
        authToken.setAccessToken(String.valueOf(accessToken));
        authToken.setJti(String.valueOf(jti));
        authToken.setRefreshToken(String.valueOf(refreshToken));

        stringRedisTemplate.boundValueOps(String.valueOf(jti)).set(String.valueOf(accessToken), ttl, TimeUnit.SECONDS);

        return authToken;
    }


    private String getHttpBasic(String clientId, String clientSecret){
        String str = clientId + ":" + clientSecret;
        str = Base64Utils.encodeToString(str.getBytes());
        return "Basic " + str;
    }
}
