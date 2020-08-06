package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  流对象转成集合
 *  Stream接口方法, collect
 */
public class StreamDemo06 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("张三丰");

        Stream<String> stream = list.stream();
        //Stream流对象collect()传递Collectors静态方法toList() 流对象元素转成集合
        List<String> newList =  stream.filter( s->s.startsWith("张")).collect(Collectors.toList());
        System.out.println(newList);
    }
}
