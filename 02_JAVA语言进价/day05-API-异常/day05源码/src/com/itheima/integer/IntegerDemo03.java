package com.itheima.integer;

/**
 * 基本数据类型包装类
 * 做大意义:
 *   提供了基本数据类型和字符串之间的互转
 *   数据源来,JavaWeb开发,数据是用户从浏览器中输入的 (String)
 *
 *   Integer类中静态方法 static int parseInt(String s)
 *   参数字符串转成基本数据类型int, 字符串必须数字格式
 *   String -> int
 *
 *   int ->String  +""
 *   new StringBuilder().append(1)
 *
 *
 */
public class IntegerDemo03 {
    public static void main(String[] args) {
        int i = Integer.parseInt("100");
        System.out.println(i*5);

        //字符串转成基本类型
        Integer integer = new Integer("200");
        int j = integer.intValue();
        System.out.println(j*5);
    }
}
