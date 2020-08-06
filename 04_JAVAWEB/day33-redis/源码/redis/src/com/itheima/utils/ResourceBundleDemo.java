package com.itheima.utils;

import java.util.ResourceBundle;

/**
 * java.util.ResourceBundle类
 * 专门处理配置文件 properties文件
 * 静态方法 static  ResourceBundle getBundle(String 文件名)返回子类对象
 * ResourceBundle对象调用方法 getString(配置文件中的键)返回值
 */
public class ResourceBundleDemo {
    public static void main(String[] args) {
        ResourceBundle bundle =  ResourceBundle.getBundle("a");
        String name = bundle.getString("name");
        String age = bundle.getString("age");
        String address = bundle.getString("address");
        System.out.println(name);
        System.out.println(age);
        System.out.println(address);

    }
}
