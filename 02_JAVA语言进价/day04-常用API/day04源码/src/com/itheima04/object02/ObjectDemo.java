package com.itheima.object02;

/**
 *  Object类,定义了一个方法 boolean equals(Object obj)
 *  对象和对象之间进行比较的方法
 *  两个对象相同,equals方法true
 *
 *  boolean equals方法源代码
 *  public boolean equals(Object obj) {
        return (this == obj);  //== 比较引用类型,比较内存地址
   }

   对象是要new出来的,内存地址不一样
   比较内存地址没有意义
   重写父类的equals方法,建立Person对象自己的比较形式,不比地址
   比较p1和p2对象的年龄
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Person p1 = new Person("张三",22);
        Person p2 = new Person("李四",22);
        //p1对象调用父类方法equals(p2)和p2对象进行比较
        boolean b = p1.equals(p1);
        System.out.println(b);
    }
}
