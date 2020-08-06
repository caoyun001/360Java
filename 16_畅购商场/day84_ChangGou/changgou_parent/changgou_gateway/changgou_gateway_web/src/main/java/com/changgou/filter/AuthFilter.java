package com.changgou.filter;

import com.changgou.service.AuthService;
import com.changgou.util.UrlFilter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求及相应
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //2.判断当前登录的URL是否是登录URL，如果是就放行
        String path = request.getURI().getPath();
        boolean flag = UrlFilter.hasAuthorize(path);
        if(path.contains("/oauth/interface/login")||path.contains("/oauth/toLogin")||path.contains("/oauth/login")|| !flag){
            return chain.filter(exchange);
        }

        //3.判断请求的COOKIE有没有一个名字叫做uid的cookie值，值就是jti（短令牌），如果没有值，就报错返回
        String jti = authService.getJtiFromCookie(request);
        if(StringUtils.isEmpty(jti)){
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
            response.setStatusCode(HttpStatus.SEE_OTHER);
            response.getHeaders().set("Location", "http://web.changgou.com:8001/api/oauth/toLogin?ReturnUrl="+request.getURI());
            return response.setComplete();
        }

        //4.根据jti（短令牌）从redis里获取长令牌，如果没有，就报错返回
        String token = authService.getTokenFromRedis(jti);
        if(StringUtils.isEmpty(token)){
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
            response.setStatusCode(HttpStatus.SEE_OTHER);
            response.getHeaders().set("Location", "http://web.changgou.com:8001/api/oauth/toLogin?ReturnUrl="+request.getURI());
            return response.setComplete();
        }

        //5.传递Authoriazation请求头到具体的微服务（资源服务器）中
        request.mutate().header("authorization", "Bearer " + token);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
