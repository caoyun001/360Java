package com.itheima.math;

import java.util.function.DoubleToIntFunction;

/**
 * java.lang.Math类
 *   数学计算类,功能全部是数学上的计算
 *   私有构造方法,全部静态方法,类名调用
 *
 *   圆周率 : Math.PI
 */
public class MathDemo {
    public static void main(String[] args) {
        method_5();
    }
    /**
     * static double pow(double a,double b)
     * 幂运算,a的b次幂
     */
    public static void method_5(){
        double d = Math.pow(2,3);
        System.out.println(d);
    }

    /**
     * static double round(double d)
     * 四舍五入取整数,参考小数点后1位
     */
    public static void method_4(){
        double d = Math.round(10.599);
        System.out.println(d);
    }

    /**
     * static double floor(double d)
     * 向下取整数
     * 返回小于或者等于参数的最大整数
     */
    public static void method_3(){
        double d = Math.floor(-12.5);
        System.out.println(d);
    }

    /**
     * static double ceil(double d)
     * 向上取整数
     * 返回大于或者等于参数的最小整数
     */
    public static void method_2(){
        double d = Math.ceil(12.5);
        System.out.println(d);
    }

    /**
     *  static int abs(int a)返回参数的绝对值
     *  正数的绝对值是他自己
     *  负数的绝对值是去掉符号
     */
    public static void method(){
        int i = Math.abs(-5);
        System.out.println(i);
    }
}
