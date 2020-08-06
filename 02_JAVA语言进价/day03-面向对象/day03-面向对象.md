# day03 面向对象【修饰符，内部类，参数传递】

## 今日内容

- final
- static
- 访问权限
- 内部类
- 引用类型参数

## 教学目标

- [ ] 描述final修饰的类的特点
- [ ] 描述final修饰的方法的特点
- [ ] 描述final修饰的变量的特点

- [ ] 能够掌握static关键字修饰的变量调用方式
- [ ] 能够掌握static关键字修饰的方法调用方式
- [ ] 能够写出静态代码块的格式
- [ ] 能够说出权限修饰符作用范围
- [ ] 能够说出内部类概念
- [ ] 能够理解匿名内部类的编写格式
- [ ] 能够使用引用类型作为方法的参数并调用

# 第一章 final关键字

## 1.1 概述

学习了继承后，我们知道，子类可以在父类的基础上改写父类内容，比如，方法重写。那么我们能不能随意的继承API中提供的类，改写其内容呢？显然这是不合适的。为了避免这种随意改写的情况，Java提供了`final` 关键字，用于修饰**不可改变**内容。

- **final**：  不可改变。可以用于修饰类、方法和变量。
  - 类：被修饰的类，不能被继承。
  - 方法：被修饰的方法，不能被重写。
  - 变量：被修饰的变量，不能被重新赋值。

## 1.2 使用方式

### 修饰类

格式如下：

```java
final class 类名 {
  
}
```

查询API发现像 `public final class String` 、`public final class Math` 、`public final class Scanner` 等，很多我们学习过的类，都是被final修饰的，目的就是供我们使用，而不让我们所以改变其内容。

### 修饰方法

格式如下：

```java
修饰符 final 返回值类型 方法名(参数列表){
    //方法体
}
```

重写被 `final`修饰的方法，编译时就会报错。

### 修饰变量

- **局部变量——基本类型**

基本类型的局部变量，被final修饰后，只能赋值一次，不能再更改。代码如下：

```java
public class FinalDemo1 {
    public static void main(String[] args) {
        // 声明变量，使用final修饰
        final int a;
        // 第一次赋值 
        a = 10;
        // 第二次赋值
        a = 20; // 报错,不可重新赋值


        // 声明变量，直接赋值，使用final修饰
        final int b = 10;
        // 第二次赋值
        b = 20; // 报错,不可重新赋值
    }
}
```

- **局部变量——引用类型**

引用类型的局部变量，被final修饰后，只能指向一个对象，地址不能再更改。但是不影响对象内部的成员变量值的修改，代码如下：

```java
public class FinalDemo2 {
    public static void main(String[] args) {
        // 创建 User 对象
        final   User u = new User();
        // 创建 另一个 User对象
        u = new User(); // 报错，指向了新的对象，地址值改变。

        // 调用setName方法
        u.setName("张三"); // 可以修改
    }
}

```

- **成员变量**

成员变量涉及到初始化的问题，初始化方式有两种，只能二选一：

1. 显示初始化；

   ```java
   public class User {
       final String USERNAME = "张三";
       private int age;
   }
   ```

2. 构造方法初始化。

   ```java
   public class User {
       final String USERNAME ;
       private int age;
       public User(String username, int age) {
           this.USERNAME = username;
           this.age = age;
       }
   }
   ```
   
   被final修饰的常量名称，一般都有书写规范，所有字母都**大写**。
# 第二章 static关键字

## 2.1 概述

static是静态修饰符，一般修饰成员。被static修饰的成员属于类，不属于单个这个类的某个对象。static修饰的成员被多个对象共享。static修饰的成员属于类，但是会影响每一个对象。被static修饰的成员又叫类成员，不叫对象的成员。

## 2.2 特点

1. 被static修饰的属于类,不属于对象
2. 优先于对象存在
3. static修饰的成员,可以作为共享的数据(只要是根据static修饰的成员所在的类创建出来的对象,都可以共享这个数据)

## 2.3 定义和使用格式

### 类变量

当 `static` 修饰成员变量时，该变量称为**类变量**。该类的每个对象都**共享**同一个类变量的值。任何对象都可以更改该类变量的值，但也可以在不创建该类的对象的情况下对类变量进行操作。

- **类变量**：使用 static关键字修饰的成员变量。

定义格式：

```java
static 数据类型 变量名； 
```

举例：

```java
static String room；
```

比如说，同学们来黑马程序员学校学习,那么我们所有学生的学校都是黑马程序员，而且每个学生都一样,跟每个学生无关。

所以，我们可以这样定义一个静态变量school，代码如下：

```java
public class Student {
  private String name;
  private int age;
  // 类变量，记录学生学习的学校
  public static String school = "黑马程序员学校";

  public Student(String name, int age){
    this.name = name;
    this.age = age;     
  }

  // 打印属性值
  public void show() {
    System.out.println("name=" + name + ", age=" + age + ", school=" + school );
  }
}

public class StuDemo {
  public static void main(String[] args) {
    Student s1 = new Student("张三", 23);
    Student s2 = new Student("李四", 24);
    Student s3 = new Student("王五", 25);
    Student s4 = new Student("赵六", 26);

    s1.show(); // Student : name=张三, age=23, school=黑马程序员学校
    s2.show(); // Student : name=李四, age=24, school=黑马程序员学校
    s3.show(); // Student : name=王五, age=25, school=黑马程序员学校
    s4.show(); // Student : name=赵六, age=26, school=黑马程序员学校
  }
}
```

### 静态方法

当`static` 修饰成员方法时，该方法称为**类方法** 。静态方法在声明中有`static` ，建议使用类名来调用，而不需要创建类的对象。调用方式非常简单。

- **类方法**：使用 static关键字修饰的成员方法，习惯称为**静态方法**。

定义格式：

```java
修饰符 static 返回值类型 方法名 (参数列表){ 
	// 执行语句 
}
```

举例：在Student类中定义静态方法

```java
public static void showNum() {
  System.out.println("num:" +  numberOfStudent);
}
```

- **静态方法调用的注意事项：**
  - 静态方法可以直接访问类变量和静态方法。
  - 静态方法**不能直接访问**普通成员变量或成员方法。反之，成员方法可以直接访问类变量或静态方法。
  - 静态方法中，不能使用**this**关键字。

### 调用格式

被static修饰的成员可以并且建议通过**类名直接访问**。虽然也可以通过对象名访问静态成员，原因即多个对象均属于一个类，共享使用同一个静态成员，但是不建议，会出现警告信息。

格式：

```java  
// 访问类变量
类名.类变量名；

// 调用静态方法
类名.静态方法名(参数)； 
```

调用演示，代码如下：

```java
public class StuDemo2 {
  public static void main(String[] args) {      
    // 访问类变量
    System.out.println(Student.numberOfStudent);
    // 调用静态方法
    Student.showNum();
  }
}
```



## 2.4 静态原理图解

`static` 修饰的内容：

- 是随着类的加载而加载的，且只加载一次。
- 存储于一块固定的内存区域（静态区），所以，可以直接被类名调用。
- 它优先于对象存在，所以，可以被所有对象共享。

![](img/3.jpg)

## 2.5 静态代码块

- **静态代码块**：定义在成员位置，使用static修饰的代码块{ }。
  - 位置：类中方法外。
  - 执行：随着类的加载而执行且执行一次，优先构造方法的执行。

格式：

```java
public class Person {
	private String name;
	private int age;
 //静态代码块
	static{
		System.out.println("静态代码块执行了");
	}
}
```

## 2.6 静态导入

 静态导入就是java包的静态导入，使用import static 静态导入包 , 这样可以直接使用方法名去调用静态的方法。

静态导入格式: 

```java
import static 包名.类名.方法名;
import static 包名.类名.*;
```

定义A类 如下, 含有两个静态方法 :  

```java
package com.itcast; 
public class A {
    public static void print(String s){
        System.out.println(s);
    }

    public static void print2(String s){
        System.out.println(s);
    }
}
```

 静态导入一个类的某个静态方法 ,  使用static和类名A .方法名 , 表示导入A类中的指定方法 , 代码演示 :  

```java
import static com.itcast.A.print;
public class Demo {
    public static void main(String[] args) {
        print("test string");
    }
}
```

如果有多个静态方法  , 使用static和类名A . * , 表示导入A类里的所有的静态方法, 代码演示 :

```java
import static com.itcast.A.*;
public class Demo {
    public static void main(String[] args) {
        print("test string");
        print2("test2 string");
    }
}
```

# 第三章 权限修饰符

## 3.1 概述

在Java中提供了四种访问权限，使用不同的访问权限修饰符修饰时，被修饰的内容会有不同的访问权限，

- public：公共的。
- protected：受保护的
- default：默认的
- private：私有的

## 3.2 不同权限的访问能力

|              | public | protected | default（空的） | private |
| ------------ | ------ | --------- | ----------- | ------- |
| 同一类中         | √      | √         | √           | √       |
| 同一包中(子类与无关类) | √      | √         | √           |         |
| 不同包的子类       | √      | √         |             |         |
| 不同包中的无关类     | √      |           |             |         |

可见，public具有最大权限。private则是最小权限。

编写代码时，如果没有特殊的考虑，建议这样使用权限：

- 成员变量使用`private` ，隐藏细节。
- 构造方法使用` public` ，方便创建对象。
- 成员方法使用`public` ，方便调用方法。

# 第四章 内部类

## 4.1 概述

### 什么是内部类

将一个类A定义在另一个类B里面，里面的那个类A就称为**内部类**，B则称为**外部类**。

## 4.2 成员内部类

* **成员内部类** ：定义在**类中方法外**的类。

定义格式：

```java
class 外部类 {
    class 内部类{

    }
}
```

在描述事物时，若一个事物内部还包含其他事物，就可以使用内部类这种结构。比如，汽车类`Car` 中包含发动机类`Engine` ，这时，`Engine `就可以使用内部类来描述，定义在成员位置。

代码举例：

```java
class Car { //外部类
    class Engine { //内部类

    }
}
```

###  访问特点

- 内部类可以直接访问外部类的成员，包括私有成员。

- 外部类要访问内部类的成员，必须要建立内部类的对象。

创建内部类对象格式：

```java
外部类名.内部类名 对象名 = new 外部类型().new 内部类型()；
```

访问演示，代码如下：

定义类：

```java
public class Person {
    private  boolean live = true;
    class Heart {
        public void jump() {
            // 直接访问外部类成员
            if (live) {
                System.out.println("心脏在跳动");
            } else {
                System.out.println("心脏不跳了");
            }
        }
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

}
```

定义测试类：

```java
public class InnerDemo {
    public static void main(String[] args) {
        // 创建外部类对象 
        Person p  = new Person();
        // 创建内部类对象
        Person.Heart heart = p.new Heart();
        // 调用内部类方法
        heart.jump();
        // 调用外部类方法
        p.setLive(false);
        // 调用内部类方法
        heart.jump();
    }
}
输出结果:
心脏在跳动
心脏不跳了
```

> 内部类仍然是一个独立的类，在编译之后会内部类会被编译成独立的.class文件，但是前面冠以外部类的类名和$符号 。
>
> 比如，Person$Heart.class  

## 4.3 匿名内部类

* **匿名内部类** ：是内部类的简化写法。它的本质是一个`带具体实现的` `父类或者父接口的` `匿名的` **子类对象**。

开发中，最常用到的内部类就是匿名内部类了。以接口举例，当你使用一个接口时，似乎得做如下几步操作，

1. 定义子类
2. 重写接口中的方法
3. 创建子类对象
4. 调用重写后的方法

我们的目的，最终只是为了调用方法，那么能不能简化一下，把以上四步合成一步呢？匿名内部类就是做这样的快捷方式。

### 前提

存在一个**类或者接口**，这里的**类可以是具体类也可以是抽象类**。

### 格式

```java
new 父类名或者接口名(){
    // 方法重写
    @Override 
    public void method() {
        // 执行语句
    }
};

```

### 使用方式

以接口为例，匿名内部类的使用，代码如下：

定义接口：

```java
public abstract class FlyAble{
    public abstract void fly();
}
```

匿名内部类可以通过多态的形式接受

```java
public class InnerDemo01 {
    public static void main(String[] args) {
        /*
        	1.等号右边:定义并创建该接口的子类对象
        	2.等号左边:是多态,接口类型引用指向子类对象
       */
        FlyAble  f = new FlyAble(){
            public void fly() {
                System.out.println("我飞了~~~");
            }
        };
    }
}
```

匿名内部类直接调用方法

```java
public class InnerDemo02 {
    public static void main(String[] args) {
        /*
        	1.等号右边:定义并创建该接口的子类对象
        	2.等号左边:是多态,接口类型引用指向子类对象
       */
       	new FlyAble(){
            public void fly() {
                System.out.println("我飞了~~~");
            }
        }.fly();
    }
}
```

# 第五章 引用类型的传递

## 5.1 类名作为方法参数和返回值

- 类名作为方法的形参

  方法的形参是类名，其实需要的是该类的对象

  实际传递的是该对象的【地址值】

- 类名作为方法的返回值

  方法的返回值是类名，其实返回的是该类的对象

  实际传递的，也是该对象的【地址值】

- 示例代码：

  ```java
  public class Person{
    public void eat(){
      System.out.println("人吃了");
    }
  }
  public class Test{
    public static void main(String[] args){
          method(new Person());
     		Person p = method2();
    }
    pubic static void method(Person p){
         p.eat();
    }
    public static Person method2(){
      	return new Person();
    }
  }

  ```
  

## 5.2 抽象类作为形参和返回值

- 抽象类作为形参和返回值

  - 方法的形参是抽象类名，其实需要的是该抽象类的子类对象
  - 方法的返回值是抽象类名，其实返回的是该抽象类的子类对象

- 示例代码：

  ```java
  public abstract class Animal{
    	public abstract void eat();
  }
  public class Cat extends Animal{
    public void eat(){
      System.out.println("猫吃鱼");
    }
  }
  public class Test{
    public static void main(String[] args){
        method(new Cat());
      
       Animal a = method2();
      
    }
    public static void method(Animal a){
         a.eat();
    }
    public static Animal method2(){
      	return new cat();
    }
  }

  ```

## 5.3 接口名作为形参和返回值

- 接口作为形参和返回值

  - 方法的形参是接口名，其实需要的是该接口的实现类对象
  - 方法的返回值是接口名，其实返回的是该接口的实现类对象

- 示例代码：

  ```java
   public interface Fly{
      public abstract void fly();
   }
  public class Bird implements Fly{
    public void fly(){
      System.out.println("我飞了");
    }
  }
  public class Test{
    public static void main(String[] args){
        method(new Bird());
      
       Fly f = method2();
      
    }
    public static void method(Fly f){
       	f.fly();
    }
    public static Fly method2(){
      	return new Bird();
    }
  }
  ```
