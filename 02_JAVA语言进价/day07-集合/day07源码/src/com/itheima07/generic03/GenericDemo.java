package com.itheima.generic03;

/**
 * 自定义的带有泛型的方法
 */
public class GenericDemo {
    public static void main(String[] args) {
        Factory<String> factory = new Factory<String>();
        factory.add("aaa");
        factory.show(true);
        factory.show(123);

        Factory.function("aa");
        Factory.function(1.5);
    }
}
