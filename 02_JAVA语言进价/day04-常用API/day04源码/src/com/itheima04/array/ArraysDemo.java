package com.itheima.array;

import java.util.Arrays;

/**
 *   Sun公司: 比较善良
 *   排序和二分搜索比较难
 *   开发好了,直接使用即可
 *
 *   java.util.Arrays 操作数组的工具类
 *   私有修饰构造方法,无需创建对象
 *   方法全部静态修饰
 */
public class ArraysDemo {
    public static void main(String[] args) {
        method_3();
    }
    /**
     * static int binarySearch(数组,被查找的元素)
     * 二分搜索法
     * 找不到元素,返回 (-插入点-1)
     */
    public static void method_3(){
        int[] arr = {2,5,8,12,16,19,25};
        int index = Arrays.binarySearch(arr,1);
        System.out.println(index);
    }

    /**
     * static void sort(数组)
     * 对数组进行升序排序
     */
    public static void method_2(){
        int[] arr = {1,4,1,3,6,78,56,4};
        Arrays.sort(arr);
        String str = Arrays.toString(arr);
        System.out.println(str);
    }

    /**
     * static String toString(数组)
     * 把数组变成字符串
     */
    public static void method(){
        int[] arr = {1,4,1,3,6,78,56,4};
        String str = Arrays.toString(arr);
        System.out.println(str);
    }
}
