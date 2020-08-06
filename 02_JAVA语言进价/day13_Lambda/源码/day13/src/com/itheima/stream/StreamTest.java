package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  1. 第一个队伍只要名字为3个字的成员姓名；
 2. 第一个队伍筛选之后只要前3个人；
 3. 第二个队伍只要姓张的成员姓名；
 4. 第二个队伍筛选之后不要前2个人；
 5. 将两个队伍合并为一个队伍；
 6. 打印整个队伍的姓名信息。
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        //获取第一组 one集合的流对象
        //filter方法获取3个字的人,要前3个
        Stream<String> onStream = one.stream().filter( s->s.length() == 3 ).limit(3);

        //获取第二组 two集合的流对象
        //filter方法过滤姓张,不要前两个
        Stream<String> twoStream = two.stream().filter( s -> s.startsWith("张")).skip(2);

        //onStream,twoStream 合并为一个流对象,Stream接口静态方法concat
        Stream<String> stream = Stream.concat(onStream, twoStream);
        stream.forEach( s -> System.out.println(s) );
    }
}
