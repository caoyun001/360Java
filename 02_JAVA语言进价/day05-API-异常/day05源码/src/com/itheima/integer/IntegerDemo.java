package com.itheima.integer;

/**
 *  基本数据类型8种
 *  提供一套包装类,基本数据类型变成对象
 *  出现更多的方法,操作基本类型
 *
 *  Integer类包装int数据类型
 *  创建出Integer类的对象
 */
public class IntegerDemo {
    public static void main(String[] args) {
        // new Integer(String str)传递数字格式的字符串
        Integer ii = new Integer("123");
        System.out.println(ii);

        //静态方法 static Integer valueOf(String str)传递数字格式的字符串
        Integer i2 = Integer.valueOf("456");
        System.out.println(i2);
    }
}
