package com.itheima.array;

/**
 * 数组: 容器,存储数据
 * 可以存储基本数据类型,也可存储引用数据类型
 * int[] byte[]  double[]  基本类型数组
 * String[]  Person[] 引用类型数组,对象数组
 *
 * 问题分析:
 *   Java中的数组存在一个弊端: 长度固定,一旦创建好了数组,长度固定不变
 *   在存储2个Person对象,创建新数组,原始数组的元素复制到新数组
 *
 *   解决数组定长问题: JDK1.2版本开始,出现集合容器
 *
 * 数组和集合的相同点和不同点:
 *   相同: 容器,存储数据
 *   不同: 数组定长,集合变长
 *   不同: 数组可以存基本类型,引用类型
 *         集合只能存储引用类型,不存储基本类型
 *
 *   记住: 数据多了存储数组,对象多了存储集合
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //数组,存储多个Person对象
        Person[] persons = {new Person("张三",20),new Person("李四",21),new Person("王五",22)};
        System.out.println(persons.length);
        //数组元素的遍历
        for(int i = 0 ; i < persons.length; i++){
            //数组中存储的对象是Person类型,遍历取出元素的时候
            //取出的数据类型,Person类型变量接收
            Person p = persons[i];
            System.out.println(p);//默认调用方法toString()
        }
    }
}
