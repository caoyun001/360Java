package com.itheima.exception02;

/**
 * 程序中出现异常:
 *   异常是如何进行处理的,JVM的默认处理方式
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr  = {1,2,3};
        int i = getArray(arr);
        System.out.println(i);
        System.out.println("程序结束");
    }

    public static int getArray(int[] arr){
        return arr[5];
    }
}
