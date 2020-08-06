package com.itheima.arguments;

/**
 * 方法的参数:
 *   方法的参数可以是基本数据类型,也可以是引用数据类型
 *   引用数据类型要多于基本类型
 *   方法的参数可以是类,可以是抽象类,可以是接口
 */
public class ArgumentsDemo {
    public static void main(String[] args) {
        //调用方法usePerson,传递相应参数
        //传递Person的对象
        // Person person = new Person();
        usePerson( new Person() );

        //调用方法useAnimal,传递相应参数
        //只能传递子类的对象 Cat
        //Cat cat = new Cat();
        useAnimal(new Cat());

        //调用方法useFly,传递相应参数
        //只能传递实现类对象 Bird
        useFly( new Bird() );
    }
    /**
     * 自定义方法,要求方法的参数是接口Fly类型
     * 参数是接口类型,接收Fly接口实现类对象
     * fly对象调用方法 fly();
     */
    public static void useFly(Fly fly){
        fly.fly();
    }

    /**
     * 自定义方法,要求方法的参数是抽象类Animal类型
     * 参数抽象类型,接收Animal的子类对象
     * 对象animal是可以调用方法eat
     */
    public static void useAnimal(Animal animal){
        animal.eat();
    }

    /**
     * 自己定义方法,要求方法的参数是类Person类型
     * person类型的变量,可以调用Person对象的方法
     */
    public static void usePerson(Person person){
        person.eat();
    }
}
