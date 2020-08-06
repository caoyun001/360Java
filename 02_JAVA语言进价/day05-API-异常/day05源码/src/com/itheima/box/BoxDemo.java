package com.itheima.box;

import java.util.ArrayList;

/**
 *  JDK1.5版本,出现的新特性自动装箱和自动拆箱
 *  自动装箱 : 基本数据类型自动转成对象
 *  自动拆箱 : 对象自动转成基本数据类型
 */
public class BoxDemo {
    public static void main(String[] args) {
        //自动装箱: 将基本数据类型转成对象
        Integer i  = 100;// 100基本数据类型,自动转成Integer对象
        //自动拆箱; 将对象转成基本数据类型
        i = i + 1; //拆箱,i转成基本类型 i.intValue()+1,计算结果101,再次装箱,自动转成Integer对象
        System.out.println(i);
    }
    public static void show(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);// 自动装箱
        arrayList.add(2);
        int i =  arrayList.get(0);//取出的元素,Integer对象,拆箱
    }
}
