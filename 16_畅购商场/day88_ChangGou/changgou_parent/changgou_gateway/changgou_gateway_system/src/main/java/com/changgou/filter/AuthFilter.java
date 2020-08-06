package com.changgou.filter;

import com.changgou.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 用户登录后访问资源进行统一鉴权的过滤器
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //1.获取请求
        ServerHttpRequest request = exchange.getRequest();

        //2.获取响应
        ServerHttpResponse response = exchange.getResponse();

        //3.获取请求URL是否是登录URL
        String path = request.getURI().getPath();

        //4.如果URL是登录就放行，如果不是就继续判断
        if(path.contains("/admin/login")){
            return chain.filter(exchange);
        }

        //5.获取请求头中的token值
        String token = request.getHeaders().getFirst("token");

        //6.判断token值是否为空，如果为空，就拒绝用户，如果不为空继续判断
        if(StringUtils.isEmpty(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //7.进行TOKEN值的解析操作（鉴权），如果解析超失败，就拒绝用户
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }


        //8.如果解析成功，就放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
