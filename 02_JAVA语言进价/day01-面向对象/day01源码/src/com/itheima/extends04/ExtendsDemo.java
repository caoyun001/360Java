package com.itheima.extends04;

/**
 * 继承中非常关键点：方法的重写 override
 * 概念： 子类和父类中，出现了完全一样的方法，子类重写父类的方法 （覆盖，复写）
 *
 * 回顾方法的重载 overload
 * 必须是同一个类，方法名相同，参数列表不同，返回类型，修饰符无关
 *
 * 继承后，子类父类中方法的特点
 *   子类重写了父类的方法，执行子类重写
 *   子类没有重写父类的方法，执行父类
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        //创建子类的对象
        Zi zi = new Zi();
        zi.show();
    }
}
