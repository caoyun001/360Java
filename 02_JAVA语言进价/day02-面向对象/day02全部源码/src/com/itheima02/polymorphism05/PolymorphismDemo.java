package com.itheima.polymorphism05;

/**
 * 分析: 类型转换异常 ClassCastException出现的原因
 * Animal animal = new Cat() 创建的对象是Cat对象
 *
 *  (Dog)animal, 强制转换,本质上是Cat对象,不可能转成Dog对象
 *
 *  解决办法:
 *    思路, 猫只能转猫 Cat->Cat
 *          狗只能转狗 Dog->Dog
 *
 *    animal:判断是Cat对象还是Dog对象
 *    如果判断 animal对象到底是Cat,还是Dog  if
 *    比较运算符,计算结果是布尔类型 true,false
 *    关键字 instanceof
 *
 *    使用方式:
 *      对象 instanceof 类名   判断出现这个对象,是不是由这个类创建的
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        //判断,如果animal是Cat对象,强制转成Cat类型
        if( animal instanceof Cat ){
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }

        //判断,如果animal是Dog对象,强制转成Dog类型
       else if(animal instanceof Dog){
            Dog dog = (Dog)animal;
            dog.lookHome();
        }

        //判断animal对象,是不是Cat类创建的
        //boolean b =  animal instanceof Cat;
        //System.out.println(b);
    }
}
