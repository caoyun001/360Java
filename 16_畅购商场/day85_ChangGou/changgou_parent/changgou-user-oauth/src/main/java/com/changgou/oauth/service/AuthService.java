package com.changgou.oauth.service;

import com.changgou.oauth.util.AuthToken;

public interface AuthService {

    AuthToken applyToken(String clientId, String clientSecret, String username, String password);
}
