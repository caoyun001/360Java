package com.itheima.stream;

import java.util.stream.Stream;

/**
 * Stream接口方法 concat 将两个Stream对象,合为一个对象
 * 静态方法 接口名.concat
 */
public class StreamDemo05 {
    public static void main(String[] args) {
        Stream<String> stream01 = Stream.of("a","b","c");
        Stream<String> stream02 = Stream.of("d","e","f");

        //Stream接口的静态方法,01和02合并一个流
        Stream<String> stream = Stream.concat(stream01,stream02);
        stream.forEach( s -> System.out.println(s));
    }
}
