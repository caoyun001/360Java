package com.itheima.argument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  方法的可变参数
 *  根据需求,发现问题:
 *    方法中参数的数据类型固定,但是参数的个数不确定
 *    JDK1.5开始,新的特性,方法可变参数
 *    语法:
 *      数据类型...变量名
 *
 *    确定: 可变参数本质上就是数组
 *
 *    可变参数使用的注意事项:
 *      1: 一个方法中,可变参数只能有一个
 *      2: 方法中的可变参数只能定义在最后一位
 */
public class VarArguments {
    public static void main(String[] args) {
        //调用方法getSum(可变参数)
        //传递几个都行,而且不传递也行
        int sum = getSum(1,2,3);
        System.out.println(sum);

        collections();
    }

    /**
     * Collections类中定义静态方法addAll(任意单列集合, 是可变参数)
     * 向集合中添加一批元素
     */
    public static void collections(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");

        Collections.addAll(list,"hehe","xixi","sisi","heihei","asd","asdfasdf","werft");
        System.out.println(list);
    }

    public static void show(int a,int b,int...c){

    }

    /**
     * 定义方法:
     *   计算整数求和,多少个整数,未知
     *   方法的可变参数
     */
    public static int getSum(int...a){
        //System.out.println(a.length);//[I@1b6d3586
        int sum = 0 ; //定义整数变量,保存求和后的值
        //数组遍历
        for(int i : a){
            sum = sum + i;
        }

        return sum;
    }

}
