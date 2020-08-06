package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *  Stream接口中的方法:
 *    foreach()集合中的元素一一进行了操作
 *    函数式接口 Consumer 是方法foreach的参数
 *    传递此接口实现类
 *
 *    函数式接口 Consumer 消费
 *    抽象方法accept
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bcd");
        list.add("cde");
        list.add("def");
        list.add("efg");
        //集合方法,获取Stream流对象
        Stream<String> stream = list.stream();
        // void accept(String t);
        //stream操作的集合泛型是String
        //遍历名s,代表了集合中的元素,s传递到accept方法体
        stream.forEach( s->System.out.println(s) );
    }
}
