package com.itheima.exception11;

/**
 * 自定义异常:
 *   JDK中,提供大量的异常,但是不够
 *   传递负数边长,JDK没有定义过边长不能为负数的异常
 *
 * 如何自定义异常:
 *   为什么所有的类都会继承Object,一切都是对象
 *   继承Object,我们的任何类都是对象
 *
 *   继承Exception
 */
public class ExceptionDemo {
    public static void main(String[] args) {

       /* int[] arr = {1};
        System.out.println(arr[5]);*/

        try {
            int area = getArea(-5);
            System.out.println(area);
        }catch (FuShuException ex){
            ex.printStackTrace();
        }
    }

    /**
     * 定义方法,传递边长,计算面积
     */
    public static int getArea(int a)throws FuShuException{
        if( a <= 0)
            //手动抛出异常,抛出自定义的异常
            throw new FuShuException("边长是负数");
        return a*a;
    }
}
