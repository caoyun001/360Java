package com.changgou.seckill.aspect;

import com.alibaba.fastjson.JSON;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Scope
@Aspect
public class AccessLimitAop {

    @Autowired
    private HttpServletResponse httpServletResponse;

    //设置令牌生成的频率
    private RateLimiter rateLimiter = RateLimiter.create(50.0); //支持每秒并发访问50

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.changgou.seckill.aspect.AccessLimit)")
    public void limit() {
    }

    @Around("limit()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {

        //判断当前是否可以访问
        boolean flag = rateLimiter.tryAcquire();

        Object obj = null;
        if (flag) {

            //允许访问
            try {
                obj = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            //不允许访问
            String errorMessage = JSON.toJSONString(new Result<>(false, StatusCode.ACCESSERROR, "当前访问流量过大，请重试"));

            //写回客户端
            out(httpServletResponse, errorMessage);

        }
        return obj;
    }

    private void out(HttpServletResponse response, String errorMessage) {
        ServletOutputStream outputStream = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
