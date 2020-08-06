package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 事务的切面通知类
 */
@Component
@Aspect
public class TransactionManager {

    //依赖注入
    @Autowired
    private Connection connection;

    //配置通用的切入点表达式
    @Pointcut("execution(* com.itheima.service..*.*(..))")
    public void pointcut(){}

    //环绕通知的事务方法
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object rtValue = null;

        try {
            //前置通知(开启事务)
            this.begin();

            //获取原有方法的执行时所需要的实际参数值
            Object[] args = joinPoint.getArgs();
            System.out.println("args = " + Arrays. toString(args));
            System.out.println("joinPoint = " + joinPoint);
            //执行原有方法
            rtValue = joinPoint.proceed(args);

            //后置通知(提交事务)
            this.commit();

        } catch (Throwable throwable) {
            throwable.printStackTrace();

            //异常通知(事务回滚)
            this.rollback();
        } finally {
            //最终通知(事务 释放连接)
            this.close();
        }

        return rtValue;
    }

    //开启事务方法
    public void begin(){
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务方法
    public void commit(){
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务方法
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //释放连接方法
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
