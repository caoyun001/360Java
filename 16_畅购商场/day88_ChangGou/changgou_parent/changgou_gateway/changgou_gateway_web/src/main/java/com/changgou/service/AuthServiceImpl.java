package com.changgou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getJtiFromCookie(ServerHttpRequest request) {
        HttpCookie uid = request.getCookies().getFirst("uid");
        if(uid!=null){
            return uid.getValue();
        }
        return null;
    }

    @Override
    public String getTokenFromRedis(String jti) {
        return stringRedisTemplate.boundValueOps(jti).get();
    }
}
