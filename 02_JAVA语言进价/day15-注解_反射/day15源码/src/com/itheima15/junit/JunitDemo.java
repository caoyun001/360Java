package com.itheima.junit;

import org.junit.Test;


/**
 * 使用Junit第三方工具,提供的一个
 * 注解 @Test
 */
public class JunitDemo {
    @Test
    public void show(){
        System.out.println("测试此方法");
    }

    //定义方法,HelloWorld
    @Test
    public void test(){
        System.out.println("HelloWorld!");
        System.out.println(1/0);
    }
}
