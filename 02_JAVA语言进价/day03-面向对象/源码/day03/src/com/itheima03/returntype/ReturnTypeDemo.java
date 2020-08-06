package com.itheima.returntype;

import java.util.ArrayList;

/**
 * 方法的返回值是引用类型
 *   public static int a(){  return 1}
 *   int i =  a();
 *   方法的返回值是类,抽象类,接口
 */
public class ReturnTypeDemo {
    public static void main(String[] args)   {
        //调用方法getPerson()接收方法的返回值
        Person person = getPerson();
        //对象调用方法
        person.eat();

        //调用方法getAnimal()接收方法的返回值
        //注意: 返回值类型是父类类型,一定不能使用子类接收!!
        Animal animal =  getAnimal();
        animal.eat();

        //调用方法getFly()接收方法的返回值
        //注意: 返回值是接口类型,一定不能使用实现类接收
        Fly fly = getFly();
        fly.fly();
    }

    /**
     * 自定义方法,没有参数
     * 要求方法的返回值是Fly接口
     * 接口没有对象,return 一定返回他的实现类对象
     */
    public static Fly getFly() {
        return new Bird();
    }

    /**
     * 自定义方法,没有参数
     * 要求方法的返回值是Animal类型
     * Animal是抽象类型,return 一定返回他的子类对象
     */
    public static Animal getAnimal(){
        return new Cat();
    }


    /**
     * 自定义方法,没有参数
     * 要求方法的返回值是Person类型
     * 方法要求返回值是引用类写,return 一定返回该类的对象
     */
    public static Person getPerson(){
        //Person person = new Person();
        return new Person();
    }
}
