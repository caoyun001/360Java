package com.changgou.seckill.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.seckill.feign.SeckillOrderFeign;
import com.changgou.seckill.util.CookieUtil;
import com.changgou.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *  秒杀下单
 *
 *  由于页面都是ajax请求, 返回json数据, 所以这里类上使用@RestController注解
 */
@RestController
@RequestMapping("/wseckillorder")
public class WebSeckillOrderController {

    @Autowired
    private SeckillOrderFeign seckillOrderFeign;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 秒杀下单
     * @param time
     * @param id
     * @param token   页面令牌
     * @return
     */
    @GetMapping("/add")
    public Result add(String time, String id, String token) {
        /**
         * 隐藏下单接口业务
         */
        //1. 判断页面令牌如果为空不允许下单
        if (StringUtils.isEmpty(token)) {
            return new Result(false, StatusCode.ERROR, "页面令牌为空, 不允许下单");
        }
        //2. 从浏览器cookie中获取短令牌jti
        String jti = getJtiFromCookie();
        //3. 判断如果cookie中短令牌jti为空不允许下单
        if (StringUtils.isEmpty(jti)) {
            return new Result(false, StatusCode.ERROR, "没有登录不允许下单");
        }
        //4. 根据jti短令牌作为key到redis中获取redis中存储的页面令牌
        Object redisToken = redisTemplate.boundValueOps("interfaceToken" + jti).get();
        //5. 判断如果redis中的页面令牌为空不允许下单
        if (redisToken == null) {
            return new Result(false, StatusCode.ERROR, "非法操作不允许下单");
        }

        //6. 判断页面传入的令牌和redis中存储的令牌一致允许下单
        if (String.valueOf(redisToken).equals(token)) {
            /**
             * 下单业务
             */
            Boolean flag = seckillOrderFeign.add(time, id);
            if (flag) {
                return new Result(true, StatusCode.OK, "下单成功!");
            } else {
                return new Result(true, StatusCode.OK, "下单失败, 此商品已售罄");
            }
        }
        //6. 其他没有想到的情况都不允许下单
        return new Result(false, StatusCode.ERROR, "非法操作不允许下单");
    }

    /**
     * 获取页面令牌
     * @return
     */
    @GetMapping("/getToken")
    public String getToken() {
        //1. 获取浏览器cookie中的短令牌jti, 在浏览器cookie中, 我们保存的key叫做uid
        String jti = getJtiFromCookie();
        //2. 生成随机字符串作为页面令牌
        String randomStr = RandomUtil.getRandomString();
        //3. 将浏览器中的短令牌作为key, 页面令牌作为value存入redis作用一份, 生存时间5秒
        redisTemplate.boundValueOps("interfaceToken" + jti).set(randomStr, 5, TimeUnit.SECONDS);
        //4. 返回页面令牌给页面
        return randomStr;
    }

    /**
     * 从cookie中获取短令牌jti
     * @return
     */
    private String getJtiFromCookie() {
        Map<String, String> cookieMap = CookieUtil.readCookie(request, "uid");
        String jti = cookieMap.get("uid");
        return jti;
    }
}
