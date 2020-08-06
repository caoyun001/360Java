package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  java.util.stream.Stream 流对象的接口(流水线)
 *  获取到实现类
 *
 *  集合:
 *    Collection接口,JDK8定义方法  Stream接口类型 stream()
 *
 *  数组:
 *    Arrays静态方法 Stream stream()
 *
 *  接口Stream定义静态方法 of(T... values)
 *
 */
public class StreamDemo {
    public static void main(String[] args) {
        //集合,获取Stream流对象
        List<String> list = new ArrayList<>();
        list.add("abc");
        //集合对象的方法stream()
        Stream<String> listStream =  list.stream();
        System.out.println(listStream);

        //Stream接口静态方法,of将多个元素组合成Stream流对象
        Stream<String> stringStream = Stream.of("abc","bcd","cdf");
    }
}
