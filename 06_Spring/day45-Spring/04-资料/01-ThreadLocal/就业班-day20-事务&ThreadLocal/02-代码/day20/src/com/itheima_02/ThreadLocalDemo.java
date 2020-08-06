package com.itheima_02;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        //在main的线程上, 创建 ThreadLocal对象
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //在main的线程上, 向threadLocal中 存入 "传智播客"
        threadLocal.set("传智播客");
        //在main的线程上, 获取 "传智播客"
        String str = threadLocal.get();
        System.out.println("str = " + str);

        //创建一个新线程, 获取 "传智播客", 结果获取不到
        new Thread(()->{
            String data = threadLocal.get();
            System.out.println("data = " + data);
        }).start();
    }
}
