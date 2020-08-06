package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  Stream接口方法
 *    limit(long n)  取出前几个元素
 *    skip(long n)   跳过前几个元素
 */
public class StreamDemo04 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        //获取String流对象
        Stream<Integer> stream = list.stream();
        //取出前4个元素,跳过前2个
        stream.limit(4).skip(2).forEach( s->System.out.println(s) );
    }
}
