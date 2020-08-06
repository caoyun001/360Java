package com.itheima.service;

import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void testString(){
        //使用ThreadLocal对象, 实现将当前线程 绑定一个String变量
        //1. 创建ThreadLocal对象
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        //2. 把当前线程 绑定一个String变量
        threadLocal.set("传智播客");
        //3. 获取当前线程上 绑定的值
        String str = threadLocal.get();
        System.out.println("str = " + str);

        //多次获取当前线程中的String变量获取
        String str2 = threadLocal.get();
        System.out.println("str2 = " + str2);

        //创建一个新的线程, 测试是否能获取到 传智播客, 结果是false
        new Thread(()->{
            String str3 = threadLocal.get();
            System.out.println("str3 = " + str3);
        }).start();
    }
}
