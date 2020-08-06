package com.itheima.hashcode;

/**
 * String类,继承Object
 * 重写了父类的方法 hashCode() 建立自己的哈希值
 * 哈希值: 和字符串的本质内容相关,和new内存地址,无关
 *
 * 计算方式:
 *   31 * 上一次计算的哈希值 + 字符ASCII码
 *   31质数,降低哈希值的碰撞
 *
 *   尽量避免,字符不同,计算出哈希值是相同
 *   字符不同,有可能计算出相同的哈希值
 */
public class HashCodeDemo02 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1==s2);// false
        System.out.println(s1.equals(s2));//true

        //String 继承Object,可以调用方法hashCode()
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        System.out.println("通话".hashCode());
        System.out.println("重地".hashCode());

        System.out.println("通话".equals("重地"));
    }
}
