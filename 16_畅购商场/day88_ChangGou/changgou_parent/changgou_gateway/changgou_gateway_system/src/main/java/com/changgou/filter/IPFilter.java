package com.changgou.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 记录用户请求IP地址的过滤器
 */
@Component
public class IPFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //得到IP地址
        ServerHttpRequest request = exchange.getRequest();
        String ip = request.getRemoteAddress().getHostName();

        //TODO 记录到DB
        System.out.println("第一个过滤器，记录用户请求的IP地址：" + ip);

        return chain.filter(exchange);//放行
    }

    @Override
    public int getOrder() {
        return 0;//数字越小优先级别越高
    }
}
