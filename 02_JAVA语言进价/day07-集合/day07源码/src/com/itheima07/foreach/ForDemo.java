package com.itheima.foreach;

import com.itheima.domain.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK1.5版本开始,出现了新特性,增强型的for循环
 * JDK1.5版本后,添加接口: java.lang.Iterable
 * 凡是此接口下的任何实现类,都可以使用for循环
 * Iterable子接口Collection
 *   Collection子接口,List Set
 *  任何单列集合,都可以使用增强for循环
 *  包含数组
 *
 *  增强for循环的格式:
 *    for(数据类型 变量名 : 数组或者集合){
 *
 *    }
 *
 *    增强for循环是 "障眼法"
 *    javac编译器,for循环,直接编译为迭代器Iterator  -- 集合
 *    javac编译器,for循环,直接编译为传统for i++     -- 数组
 */
public class ForDemo {
    public static void main(String[] args) {
        method_3();
    }
    /**
     * 增强for循环遍历集合
     * 自定义对象
     */
    public static void method_3(){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("a",3));
        list.add(new Person("b",2));
        list.add(new Person("c",1));
        for(Person p :list){
            System.out.println(p);
        }
    }

    /**
     * 增强for循环遍历集合
     */
    public static void method_2(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("q");
        list.add("w");
        list.add("s");
        for(String s : list){
            System.out.println(s);
        }
    }

    /**
     * 增强for循环遍历数组
     * 思考问题:
     *    好处: 减少代码量,适合遍历
     *    弊端: 不能动容器中的任何元素
     */
    public static void method(){
        int[] arr = {1,5,7,9};

        //for增强遍历
        for(int i : arr){
            System.out.println(i);
        }
        //System.out.println(arr[0]);
    }
}
