package com.itheima.polymorphism04;

/**
 * 猫狗案例
 *   多态的好处: 无限的扩展他的子类
 *   多态的弊端: 只能调用子类和父类的共性内容,不能调用子类的特有内容!
 *   原因:多态编译看父类造成
 *
 *  多态的转型
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        //多态创建对象
        Animal animal = new Dog();//向上转型,子类提升为父类类型
        animal.eat();
        //调用子类的特有方法
        //进行类型的强制转换,将animal类型强制转成Cat类型
        Cat cat = (Cat)animal; //强制转换,向下转型,父类转回子类类型
        cat.catchMouse();
    }
}
