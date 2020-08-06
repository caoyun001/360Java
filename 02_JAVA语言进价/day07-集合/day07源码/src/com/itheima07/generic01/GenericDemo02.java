package com.itheima.generic01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  List<E>  E : element 元素
 *  Comparator<T> T: Type 类型
 *  Iterable<T>
 *
 *      public class ArrayList<String>{
 *          public boolean add(String e){
 *
 *          }
 *      }
 *
 *    字母是什么,没有区别的 <E> 本质就是一个变量名而已
 *    特点: 变量赋值,赋的是一个数据类型
 */
public class GenericDemo02 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<String> iterator = arrayList.iterator();
        iterator.next();
    }
}
