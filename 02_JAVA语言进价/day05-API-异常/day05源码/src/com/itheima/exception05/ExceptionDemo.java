package com.itheima.exception05;

/**
 * 多个catch合并为一个
 * 一个catch(异常类|异常类|异常类  变量) 异常是平级,不能有继承
 * 无论什么异常,处理方式一样的
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            show(1);
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ex){
            System.out.println("异常处理");
        }
    }

    /**
     * 需求,定义方法
     * 造异常, 创建数组越界异常,创建空指针异常
     */
    public static void show(int a){
        if(a == 0){
            int[] arr = new int[0];
            System.out.println(arr[1]);
        }else {
            int[] arr = null;
            System.out.println(arr.length);
        }
    }
}
