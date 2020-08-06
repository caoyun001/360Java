# day01 面向对象【继承、抽象类】

## 今日内容

- 继承
- 方法重写
- this/super关键字
- 抽象类

## 教学目标

- [ ] 能够写出类的继承格式
- [ ] 能够说出继承的特点
- [ ] 能够区分this和super的作用
- [ ] 能够说出方法重写的概念
- [ ] 能够说出方法重写的注意事项
- [ ] 能够写出抽象类的格式
- [ ] 能够写出抽象方法的格式
- [ ] 能够完成员工类综合案例

# 第一章 面向对象回顾 

## 1.1 类与对象

​	  什么是类？类是现实事物的抽象，将现实事物描述成对应的类，其行为封装为方法，属性封装为成员变量。比如说人，人都有哪些属性？姓名，年龄，性别...等等这些都属于人的属性，可以将其封装为类的成员变量。人都有哪些行为？吃饭，睡觉...等等都属于人的行为，可以将其封装为类的成员方法。那么就可以定义一个Person类来描述人这一类事物！

```java
public class Person {
    private String name;//姓名
    private int age;//年龄
	
  	//吃饭
    public void eat(){
        System.out.println("人吃了");
    }
  	//睡觉
    public void sleep(){
        System.out.println("人睡了");
    }
	//空参构造
    public Person() {
    }
	//带参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
	//get/set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```
​	什么是对象?对象是从类中得到的具体实例！在定义Person类并没有一个具体的人出现，而创建对象后，就会出现一个具体的人，比如:
```java
  public class Test {
    public static void main(String[] args) {
		Person p = new Person();
		p.setName("张三");
		p.setAge(18);
		p.eat();
		p.sleep();
    }
}
```

## 1.2 对象的内存解释

​	对象在内存中的位置:对象由new关键字创建，如同数组，实体存在于堆内存中.任何事物均可以定义成类，创建对象，属于引用类型.而对象的引用变量是一个普通变量。存储的值是该对象堆内存中的地址.

​							**引用类型赋值代码解释**

![](img/对象.png)

​					              **引用类型赋值对应内存图**

![](img/对象2.png)



# 第二章 继承

## 2.1 概述

​	在现实生活中，继承一般指的是子女继承父辈的财产。在程序中，继承描述的是事物之间的所属关系，通过继承可以使多种事物之间形成一种关系体系。例如学校中的讲师、助教、班主任都属于员工。这些员工之间会形成一个继承体系，具体如下图所示。

![](img/1.png)

在Java中，类的继承是指在一个现有类的基础上去构建一个新的类，构建出来的新类被称作子类，现有类被称作父类，子类会自动拥有父类所有可继承的属性和方法。

**继承的概念**:当要定义一个类(讲师)时，发现已有类(员工)和要定义的类相似，并且要定义的类属于已有类的一种时，可以将要定义类定义为已有类的子类。同时也可以反过来思考，当多个类(讲师，助教，班主任)有共性内容，可以将共性内容向上抽取，抽取到一个新的类(员工)中,那么多个类和新的类形成的关系叫做继承。

## 2.2 继承的格式

通过 `extends` 关键字，可以声明一个子类继承另外一个父类，定义格式如下：

```java
class 父类 {
	...
}

class 子类 extends 父类 {
	...
}

```

继承演示，代码如下：

```java
/*
 * 定义员工类Employee，做为父类
 */
class Employee {
	String name; // 定义name属性
	// 定义员工的工作方法
	public void work() {
		System.out.println("尽心尽力地工作");
	}
}

/*
 * 定义讲师类Teacher 继承 员工类Employee
 */
class Teacher extends Employee {
	// 定义一个打印name的方法
	public void printName() {
		System.out.println("name=" + name);
	}
}

/*
 * 定义测试类
 */
public class ExtendDemo01 {
	public static void main(String[] args) {
        // 创建一个讲师类对象
		Teacher t = new Teacher();
      
        // 为该员工类的name属性进行赋值
		t.name = "小明"; 
      
      	// 调用该员工的printName()方法
		t.printName(); // name = 小明
		
      	// 调用Teacher类继承来的work()方法
      	t.work();  // 尽心尽力地工作
	}
}

```

在上述代码中，Teacher类通过extends关键字继承了Employee类，这样Teacher类便是Employee类的子类。从运行结果不难看出，子类虽然没有定义name属性和work()方法，但是却能访问这两个成员。这就说明，子类在继承父类的时候，会自动拥有父类的成员。

### 继承的好处

1. 提高**代码的复用性**。
2. 类与类之间产生了关系，是**多态的前提**。

## 2.3 继承后的特点——非私有成员变量

当类之间产生了关系后，其中各类中的成员变量，又产生了哪些影响呢？

### 成员变量不重名

如果子类父类中出现**不重名**的成员变量，这时的访问是**没有影响的**。代码如下：

```java
class Fu {
	// Fu中的成员变量。
	int num = 5;
}
class Zi extends Fu {
	// Zi中的成员变量
	int num2 = 6;
	// Zi中的成员方法
	public void show() {
		// 访问父类中的num，
		System.out.println("Fu num="+num); // 继承而来，所以直接访问。
		// 访问子类中的num2
		System.out.println("Zi num2="+num2);
	}
}
class ExtendDemo02 {
	public static void main(String[] args) {
        // 创建子类对象
		Zi z = new Zi(); 
      	// 调用子类中的show方法
		z.show();  
	}
}

演示结果：
Fu num = 5
Zi num2 = 6
```

### 成员变量重名

如果子类父类中出现**重名**的成员变量，这时的访问是**有影响的**。代码如下：

```java
class Fu {
	// Fu中的成员变量。
	int num = 5;
}
class Zi extends Fu {
	// Zi中的成员变量
	int num = 6;
	public void show() {
		// 访问父类中的num
		System.out.println("Fu num=" + num);
		// 访问子类中的num
		System.out.println("Zi num=" + num);
	}
}
class ExtendsDemo03 {
	public static void main(String[] args) {
      	// 创建子类对象
		Zi z = new Zi(); 
      	// 调用子类中的show方法
		z.show(); 
	}
}
演示结果：
Fu num = 6
Zi num = 6

```

子父类中出现了同名的成员变量时，在子类中需要访问父类中非私有成员变量时，需要使用`super` 关键字，修饰父类成员变量，类似于之前学过的 `this` 。

使用格式：

```java
super.父类成员变量名
```

子类方法需要修改，代码如下：

```java
class Zi extends Fu {
	// Zi中的成员变量
	int num = 6;
	public void show() {
		//访问父类中的num
		System.out.println("Fu num=" + super.num);
		//访问子类中的num
		System.out.println("Zi num=" + this.num);
	}
}
演示结果：
Fu num = 5
Zi num = 6
```

> 小贴士：Fu 类中的成员变量是非私有的，子类中可以直接访问。若Fu 类中的成员变量私有了，子类是不能直接访问的。通常编码时，我们遵循封装的原则，使用private修饰成员变量，那么如何访问父类的私有成员变量呢？对！可以在父类中提供公共的getXxx方法和setXxx方法。



## 2.4 super和this

### 父类空间优先于子类对象产生

在每次创建子类对象时，先初始化父类空间，再创建其子类对象本身。目的在于子类对象中包含了其对应的父类空间，便可以包含其父类的成员，如果父类成员非private修饰，则子类可以随意使用父类成员。代码体现在子类的构造方法调用时，一定先调用父类的构造方法。理解图解如下：

![](img/2.jpg)

### super和this的含义

- **super** ：代表父类的**存储空间标识**(可以理解为父亲的引用)。

- **this** ：代表**当前对象的引用**(谁调用就代表谁)。

### super和this的用法

1. 访问成员

```java
this.成员变量    	--    本类的
super.成员变量    	--    父类的

this.成员方法名()  	--    本类的    
super.成员方法名()   --    父类的

```

用法演示，代码如下：

```java
class Animal {
    public void eat() {
        System.out.println("animal : eat");
    }
}
 
class Cat extends Animal {
    public void eat() {
        System.out.println("cat : eat");
    }
    public void eatTest() {
        this.eat();   // this  调用本类的方法
        super.eat();  // super 调用父类的方法
    }
}
 
public class ExtendsDemo08 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        Cat c = new Cat();
        c.eatTest();
    }
}

输出结果为：
animal : eat
cat : eat
animal : eat
```

2. 访问构造方法

```java
this(...)    	--    本类的构造方法
super(...)   	--    父类的构造方法
```

> 子类的每个构造方法中均有默认的super()，调用父类的空参构造。手动调用父类构造会覆盖默认的super()。
>
> super() 和 this() 都必须是在构造方法的第一行，所以不能同时出现。



## 2.5 继承后的特点——非私有成员方法

当类之间产生了关系，其中各类中的成员方法，又产生了哪些影响呢？

### 成员方法不重名

如果子类父类中出现**不重名**的成员方法，这时的调用是**没有影响的**。对象调用方法时，会先在子类中查找有没有对应的方法，若子类中存在就会执行子类中的方法，若子类中不存在就会执行父类中相应的方法。代码如下：

```java
class Fu{
	public void show(){
		System.out.println("Fu类中的show方法执行");
	}
}
class Zi extends Fu{
	public void show2(){
		System.out.println("Zi类中的show2方法执行");
	}
}
public  class ExtendsDemo04{
	public static void main(String[] args) {
		Zi z = new Zi();
     	//子类中没有show方法，但是可以找到父类方法去执行
		z.show(); 
		z.show2();
	}
}

```

### 成员方法重名——重写(Override)

如果子类父类中出现**重名**的成员方法，这时的访问是一种特殊情况，叫做**方法重写** (Override)。

* **方法重写** ：子类中出现与父类一模一样的方法时（返回值类型，方法名和参数列表都相同），会出现覆盖效果，也称为重写或者复写。**声明不变，重新实现**。

代码如下：

```java
class Fu {
	public void show() {
		System.out.println("Fu show");
	}
}
class Zi extends Fu {
	//子类重写了父类的show方法
	public void show() {
		System.out.println("Zi show");
	}
}
public class ExtendsDemo05{
	public static void main(String[] args) {
		Zi z = new Zi();
     	// 子类中有show方法，只执行重写后的show方法
		z.show();  // Zi show
	}
}

```

### 重写的应用

子类可以根据需要，定义特定于自己的行为。既沿袭了父类的功能名称，又根据子类的需要重新实现父类方法，从而进行扩展增强。比如新的手机增加来电显示头像的功能，代码如下：

```java
class Phone {
	public void sendMessage(){
		System.out.println("发短信");
	}
	public void call(){
		System.out.println("打电话");
	}
	public void showNum(){
		System.out.println("来电显示号码");
	}
}

//智能手机类
class NewPhone extends Phone {
	
	//重写父类的来电显示号码功能，并增加自己的显示姓名和图片功能
	public void showNum(){
		//调用父类已经存在的功能使用super
		super.showNum();
		//增加自己特有显示姓名和图片功能
		System.out.println("显示来电姓名");
		System.out.println("显示头像");
	}
}

public class ExtendsDemo06 {
	public static void main(String[] args) {
      	// 创建子类对象
      	NewPhone np = new NewPhone()；
        
        // 调用父类继承而来的方法
        np.call();
      
      	// 调用子类重写的方法
      	np.showNum();

	}
}

```

> 小贴士：这里重写时，用到super.父类成员方法，表示调用父类的成员方法。

### 注意事项

1. 子类方法覆盖父类方法，必须要保证权限大于等于父类权限。
2. 子类方法覆盖父类方法，返回值类型、函数名和参数列表都要一模一样。

1. 私有方法不能被重写(父类私有成员子类是不能继承的)


## 2.6 继承后的特点——构造方法

当类之间产生了关系，其中各类中的构造方法，又产生了哪些影响呢？

首先我们要回忆两个事情，构造方法的定义格式和作用。

1. 构造方法的名字是与类名一致的。所以子类是无法继承父类构造方法的。
2. 构造方法的作用是初始化成员变量的。所以子类的初始化过程中，必须先执行父类的初始化动作。子类的构造方法中默认有一个`super()` ，表示调用父类的构造方法，父类成员变量初始化后，才可以给子类使用。代码如下：

```java
class Fu {
  private int n;
  Fu(){
    System.out.println("Fu()");
  }
}
class Zi extends Fu {
  Zi(){
    // super（），调用父类构造方法
    super();
    System.out.println("Zi（）");
  }  
}
public class ExtendsDemo07{
  public static void main (String args[]){
    Zi zi = new Zi();
  }
}
输出结果：
Fu（）
Zi（）

```

## 2.7 继承的特点

1. Java只支持单继承，不支持多继承。

```java
//一个类只能有一个父类，不可以有多个父类。
class C extends A{} 	//ok
class C extends A，B...	//error
```

2. Java支持多层继承(继承体系)。

```java
class A{}
class B extends A{}
class C extends B{}
```

3. 所有的类都直接或者间接继承了Object类，Object类是所有类的父类。

# 第三章 抽象类

## 3.1 概述

### 由来

​	当编写一个类时，我们往往会为该类定义一些方法，这些方法是用来描述该类的功能具体实现方式，那么这些方法都有具体的方法体。分析事物时，发现了共性内容，就出现向上抽取。会有这样一种特殊情况，就是方法功能声明相同，但方法功能主体不同。那么这时也可以抽取，但只抽取方法声明，不抽取方法主体。那么此方法就是一个抽象方法。

如：

​	描述讲师的行为：工作。

​	描述助教的行为：工作。

​	描述班主任的行为：工作。

​	讲师、助教、班主任之间有共性，可以进行向上抽取。抽取它们的所属共性类型：员工。由于讲师、助教、班主任都具有工作功能，但是他们具体工作内容却不一样。这时在描述员工时，发现了有些功能不能够具体描述，那么，这些不具体的功能，需要在类中标识出来，通过java中的关键字abstract(抽象)修饰。当定义了抽象函数的类也必须被abstract关键字修饰，被abstract关键字修饰的类是抽象类。

### 定义

- **抽象方法** ： 没有方法体的方法。
- **抽象类**：包含抽象方法的类。

## 3.2 abstract使用格式

### 抽象方法

使用`abstract` 关键字修饰方法，该方法就成了抽象方法，抽象方法只包含一个方法名，而没有方法体。

定义格式：

```java
修饰符 abstract 返回值类型 方法名 (参数列表)；
```

代码举例：

```java
public abstract void run()；
```

### 抽象类

如果一个类包含抽象方法，那么该类必须是抽象类。

定义格式：

```java
public abstract class 类名字 { 
  
}
```

代码举例：

```java
public abstract class Employee {
    public abstract void work()；
}
```

### 抽象类的使用

继承抽象类的子类**必须重写父类所有的抽象方法**。否则，该子类也必须声明为抽象类。最终，必须有子类实现该父类的抽象方法，否则，从最初的父类到最终的子类都不能创建对象，失去意义。

代码举例：

```java
public class Teacher extends Employee {
    public void work (){
      	System.out.println("讲课")； 	 
    }
}
public class CatTest {
 	 public static void main(String[] args) {
        // 创建子类对象
        Teacher t = new Teacher(); 
       
        // 调用run方法
        t.work();
  	}
}
输出结果：
	讲课

```

此时的方法重写，是子类对父类抽象方法的完成实现，我们将这种方法重写的操作，也叫做**实现方法**。

## 3.3 注意事项

关于抽象类的使用，以下为语法上要注意的细节，虽然条目较多，但若理解了抽象的本质，无需死记硬背。

1. 抽象类**不能创建对象**，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。

   > 理解：假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。

2. 抽象类中，可以有构造方法，是供子类创建对象时，初始化父类成员使用的。

   > 理解：子类的构造方法中，有默认的super()，需要访问父类构造方法。

3. 抽象类中，可以有成员变量。

   > 理解：子类的共性的成员变量 , 可以定义在抽象父类中。

4. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。

   > 理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设计。

5. 抽象类的子类，必须重写抽象父类中**所有的**抽象方法，否则，编译无法通过而报错。除非该子类也是抽象类。 

   > 理解：假设不重写所有抽象方法，则类中可能包含抽象方法。那么创建对象后，调用抽象的方法，没有意义。

# 第四章  综合案例---员工类体系

## 4.1案例介绍

某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部员工、维护部员工）。研发部根据所需研发的内容不同，又分为JavaEE工程师、Android工程师；维护部根据所需维护的内容不同，又分为网络维护工程师、硬件维护工程师。

公司的每名员工都有他们自己的员工编号、姓名，并要做它们所负责的工作。

工作内容:

-  JavaEE工程师： 员工号为xxx的 xxx员工，正在研发淘宝网站

-  Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件
-  网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
-  硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机

请根据描述，完成员工体系中所有类的定义，并指定类之间的继承关系。进行XX工程师类的对象创建，完成工作方法的调用。

## 4.2案例分析

- 根据上述部门的描述，得出如下的员工体系图

  ![员工类综合案例](img/员工类综合案例.bmp)

- 根据员工信息的描述，确定每个员工都有员工编号、姓名、要进行工作。则，把这些共同的属性与功能抽取到父类中（员工类），关于工作的内容由具体的工程师来进行指定。

  工作内容:

  - JavaEE工程师：员工号为xxx的 xxx员工，正在研发淘宝网站
  - Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件
  - 网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
  - 硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机

- 创建JavaEE工程师对象，完成工作方法的调用

## 4.3示例代码

定义员工类(抽象类)

```java
public abstract class Employee {
	private String id;// 员工编号
	private String name; // 员工姓名

	public String getId() {
		returnid;
	}
	publicvoid setId(String id) {
		this.id = id;
	}
	public String getName() {
		returnname;
	}
	publicvoid setName(String name) {
		this.name = name;
	}
	
	//工作方法（抽象方法）
	public abstract void work(); 
}
```

定义研发部员工类Developer 继承 员工类Employee

```java
public abstract class Developer extends Employee {
}
```

定义维护部员工类Maintainer 继承 员工类Employee

```java
public abstract class Maintainer extends Employee {
}
```

定义JavaEE工程师 继承 研发部员工类，重写工作方法

```java
public class JavaEE extends Developer {
	@Override
	public void work() {
		System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在研发淘宝网站");
	}
}
```
定义Android工程师 继承 研发部员工类，重写工作方法

```java
public class Android extends Developer {
	@Override
	public void work() {
		System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在研发淘宝手机客户端软件");
	}
}
```

定义Network网络维护工程师 继承 维护部员工类，重写工作方法

```java
public class Network extends Maintainer {
	@Override
	public void work() {
		System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在检查网络是否畅通");
	}
}
```

定义Hardware硬件维护工程师 继承 维护部员工类，重写工作方法

```java
public class Hardware extends Maintainer {
	@Override
	public void work() {
		System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在修复打印机");
	}
}
```

在测试类中，创建JavaEE工程师对象，完成工作方法的调用

```java
public class Test {
	public static void main(String[] args) {
		//创建JavaEE工程师员工对象
		JavaEE ee = new JavaEE();
		//设置该员工的编号
		ee.setId("000015");
		//设置该员工的姓名
		ee.setName("小明");
		//调用该员工的工作方法
		ee.work();
	}
}
```