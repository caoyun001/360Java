package com.itheima.generic05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型的通配符号
 * 可以匹配任意的泛型 ? 遍历
 */
public class GenericDemo {
    public static void main(String[] args) {
        //定义List集合,存储字符串
        List<String> stringList = new ArrayList<String>();
        stringList.add("abc");
        stringList.add("bcd");
        //定义List集合,存储整数
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(123);
        integerList.add(456);

        iterator(stringList);
        iterator(integerList);
    }
    /**
     * 要求:
     *   定义一个方法,方法只能写一个参数
     *   可以同时遍历上面的两个集合
     *   ? 通配,可以匹配任意的泛型
     */
    public static void iterator(List<?> list){
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            //it.next()元素取出,返回值是什么
            Object object = it.next();
            System.out.println(object);
        }
    }
}
