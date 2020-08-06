package com.changgou;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class JWTTest {


    /**
     * 生成JWT字符串，也称为TOKEN值
     * 应用的场景：一般用于用户登录的时候系统给当前登录成功的用户生成这个TOKEN值
     */
    @Test
    public void createJwt(){
        String secret = "itheima";

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, secret) //设置头部的算法和签名的密钥
                .setId(UUID.randomUUID().toString()) //设置JWT的唯一ID标识
                .setSubject("黑马程序员") //设置JWT的主题
                .setIssuedAt(new Date()) //设置JWT的系统签发时间
                .compact();
        System.out.println("JWT值：" + jwt);
    }

    /**
     * JWT超时时间
     */
    @Test
    public void createJwtExpire(){
        String secret = "itheima";

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, secret) //设置头部的算法和签名的密钥
                .setId(UUID.randomUUID().toString()) //设置JWT的唯一ID标识
                .setSubject("黑马程序员") //设置JWT的主题
                .setIssuedAt(new Date()) //设置JWT的系统签发时间
                .setExpiration(new Date(System.currentTimeMillis()+3600000)) //设置为有效期为1个小时
                .compact();
        System.out.println("JWT值：" + jwt);
    }

    @Test
    public void createJwtCustom(){
        String secret = "itheima";
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, secret) //设置头部的算法和签名的密钥
                .setId(UUID.randomUUID().toString()) //设置JWT的唯一ID标识
                .setSubject("黑马程序员") //设置JWT的主题
                .setIssuedAt(new Date()) //设置JWT的系统签发时间
                .setExpiration(new Date(System.currentTimeMillis()+3600000))
                .claim("username", "zhangsan") //设置自定义用户属性，用户名
                .claim("age", 22) //设置自定义用户属性，用户年龄
                .compact();
        System.out.println("JWT值：" + jwt);
    }


    /**
     * 解析JWT字符串
     * 应用的场景：用户登录成功后访问其他页面或资源，携带JWT字符串，服务端进行解析验证
     */
    @Test
    public void parseJwt(){
        String secret = "itheima";
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwZjM0NmEyMC0xMWU2LTQ4MzgtODYxOC1hMTM3YjQyZDg5YzciLCJzdWIiOiLpu5HpqaznqIvluo_lkZgiLCJpYXQiOjE1Nzc5NDc0ODcsImV4cCI6MTU3Nzk1MTA4NywidXNlcm5hbWUiOiJ6aGFuZ3NhbiIsImFnZSI6MjJ9.1rO-aDvG8wzg_YEnTOTXlkzwdIrspN7iSbQZ4lS9v3Q";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt);
        JwsHeader header = claimsJws.getHeader();
        Claims body = claimsJws.getBody();
        String signature = claimsJws.getSignature();
        System.out.println("解析JWT的头：" + header);
        System.out.println("解析JWT的载荷："+body);
        System.out.println("解析JWT的签名：" + signature);
    }
}
