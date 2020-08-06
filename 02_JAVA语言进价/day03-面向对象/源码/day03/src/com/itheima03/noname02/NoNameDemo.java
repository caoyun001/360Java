package com.itheima.noname02;

/**
 *  匿名内部类
 *    实现接口重写抽象方法
 */
public class NoNameDemo {
    public static void main(String[] args) {
        /**
         * 匿名内部类,就是接口实现类的对象
         * 对象多态性:
         *   接口实现,方法重写,父类或者接口引用 = new 实现类对象()
         *
         *   父类或者接口引用 = new 实现类对象()
         */
        MyInterface  my = new MyInterface(){
            public void show(){
                System.out.println("实现类重写方法show");
            }

            public void show2(){
                System.out.println("实现类重写方法show2");
            }
        };
        my.show();
        my.show2();
    }
}
