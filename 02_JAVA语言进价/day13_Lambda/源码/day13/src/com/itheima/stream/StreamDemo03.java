package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream对象的方法 filter 过滤
 * 过滤掉不需要的集合元素
 *
 * 过滤:只要姓张的
 *
 * filter方法的参数,是函数式接口 Predicate (判断)方法test
 * 方法返回true,不过滤元素,要
 *
 * 配合: 实现过滤,看不到过滤后的结果,流中的元素逐一操作,方法foreach
 */
public class StreamDemo03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("张三丰");

        Stream<String> stream = list.stream();
        //Stream流对象的方法 filter
        //s表示集合中的每个元素,传递到方法test中
        stream.filter( s->s.startsWith("张")).forEach( s->System.out.println(s) );

        System.out.println(list);
    }
}
