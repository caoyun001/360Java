package com.changgou.token;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;


public class ParseJwtTest {

    /***
     * 校验令牌
     */
    @Test
    public void testParseToken(){
        //令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTU3ODc1Nzc2OCwianRpIjoiMzZlYTZlMGUtZDQ0MS00MjY0LWEzMDAtYzRkM2RkYzkzZGIyIiwiY2xpZW50X2lkIjoid3VqaW50YW8iLCJ1c2VybmFtZSI6Ind1amludGFvIn0.gA4EVPUmyBlmVcWCWBacaseeWpSqZTMkIR6oylFaB1Ti_TscnTCnSPGE5BD0IkbdlFYKIXrlUZMsWAeBbe7C1aVqoD1EfRVWC8Ks4Maz9HBcDXWlROWibde_4764-PjmJC-0UYEtcpI-r5f0rZOIwdro9MaBjkRp-oWwsuNoYv-0-vGwKoLmJYS54Sl5zQBwFIEAy5ZWAyyYM9vuPnxXzWK0BaSthDKWPqUVd0LBAjS6NUL2s54S0xDYAjDWBI2O2fzVLJ92lKxgcxwW9VMLmBIyWd6qV61a9O9IDwljPkVJbkHsrk_DRIGf-wera8CdCW7w9jscXUxEloXR_1iVnA";

        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvFsEiaLvij9C1Mz+oyAmt47whAaRkRu/8kePM+X8760UGU0RMwGti6Z9y3LQ0RvK6I0brXmbGB/RsN38PVnhcP8ZfxGUH26kX0RK+tlrxcrG+HkPYOH4XPAL8Q1lu1n9x3tLcIPxq8ZZtuIyKYEmoLKyMsvTviG5flTpDprT25unWgE4md1kthRWXOnfWHATVY7Y/r4obiOL1mS5bEa/iNKotQNnvIAKtjBM4RlIDWMa6dmz+lHtLtqDD2LF1qwoiSIHI75LQZ/CNYaHCfZSxtOydpNKq8eb1/PGiLNolD4La2zf0/1dlcr5mkesV570NxRmU1tFm8Zd3MZlZmyv9QIDAQAB-----END PUBLIC KEY-----";

        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims);

        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
