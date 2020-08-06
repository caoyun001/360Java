package com.itheima.polymorphism03;

/**
 * 多态扩展性的体现
 *   父类 = new 子类()
 *
 *  扩展性: 父类 = new 子类可以随意变换();
 *          调用方法,执行子类的方法重写
 */
public class Polymorphism03 {
    public static void main(String[] args)  {
        //多态的形式创建对象
        Animal animal = new Cat();
        animal.eat();
        /**
         * Animal = new 可以是Animal的任意子类
         * Animal = new Cat();
         * Animal = new Dog();
         * Animal = new Bird();
         * Animal = new Pig();
         */
        animal = new Dog();
        animal.eat();

        animal = new Pig();
        animal.eat();
    }
}
