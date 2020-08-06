package com.itheima.function;

import java.util.function.Consumer;

/**
 * 函数式接口 java.util.function.Consumer<T>  消费
 * 接口的抽象方法 void accept(T t)
 * 消费:
 *   Consumer<String>
 *          void accept(String t)
 *          输出长度,切割,截取
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        /**
         * lambda改进实现类
         * 带参数
         * s 参数传递到方法中,方法accept()方法,接口重写方法
         * 接口方法accept,lambda中 {}
         */
        acceptString( s->System.out.println(s.length()),"Hello");
    }

    public static void acceptString(Consumer<String> consumer,String str){
        consumer.accept(str);
    }
}

//定义接口Consumer实现类
/*class MyConsumer implements Consumer<String>{
    public void accept(String str){
        System.out.println(str.length());
    }
}*/
