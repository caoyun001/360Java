package com.itheima.generic04;

import java.util.ArrayList;

/**
 * 自定义带有泛型的接口
 * 接口必须有实现类才能使用
 * 1: 实现类实现接口,但是不明确泛型
 * 2: 实现类实现接口,同时明确泛型
 */
public class GenericDemo {
    public static void main(String[] args) {
        InterImpl<String> inter = new InterImpl<String>();
        inter.show("");
    }
}
