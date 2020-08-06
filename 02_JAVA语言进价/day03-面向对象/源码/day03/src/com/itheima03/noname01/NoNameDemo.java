package com.itheima.noname01;

/**
 * 匿名内部类
 *   匿名
 *   内部类
 *
 *  定义接口,实现类实现接口,重写方法
 *  匿名内部类,简化实现类的书写
 *
 *  使用匿名内部类,省去有名类的编写
 *  使用前提: 一定要有接口实现,或者是父类继承
 *  格式:
 *    new 接口或者父类(){
 *        方法的重写
 *    }
 *    称为匿名内部类
 *    本质: 匿名内部类就是接口实现类的对象
 *
 *    匿名内部类,依然有class文件
 *    NoNameDemo$1
 */
public class NoNameDemo {
    public static void main(String[] args) {
       /* MyInterfaceImpl my = new MyInterfaceImpl();
        my.inter();*/

        //new关键字创建对象
        //new 创建接口实现类的对象

       new MyInterface(){
           //重写接口抽象方法
           public void inter(){
               System.out.println("匿名内部类重写方法");
           }
       }.inter();

    }
}
