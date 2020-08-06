package com.changgou.service;

import org.springframework.http.server.reactive.ServerHttpRequest;

public interface AuthService {

    /**
     * 从cookie获取jti段令牌
     * @param request
     * @return
     */
    String getJtiFromCookie( ServerHttpRequest request);


    /**
     * 根据jti从redis获取长令牌
     * @param jti
     * @return
     */
    String getTokenFromRedis(String jti);
}
