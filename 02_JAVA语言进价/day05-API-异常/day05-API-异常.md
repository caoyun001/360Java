# day05【API、异常】

## 主要内容

- Math类
- BigInteger类
- BigDecimal类
- 基本类型包装类
- 异常

## 教学目标

- [ ] 能够使用Math类的方法
- [ ] 能够说出自动装箱、自动拆箱的概念
- [ ] 能够将基本类型转换为对应的字符串
- [ ] 能够将字符串转换为对应的基本类型
- [ ] 能够使用BigInteger类的加减乘除方法
- [ ] 能够使用BigDecimal类的除法运算
- [ ] 能够辨别程序中异常和错误的区别
- [ ] 说出异常的分类
- [ ] 列举出常见的三个运行期异常
- [ ] 能够使用try...catch关键字处理异常
- [ ] 能够使用throws关键字处理异常

# 第一章 Math类

## 1.1 概述

`java.lang.Math` 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。类似这样的工具类，其所有方法均为静态方法，并且不会创建对象，调用起来非常简单。

## 1.2 常用方法

| 方法名    方法名                     | 说明                                           |
| ------------------------------------ | ---------------------------------------------- |
| public static int   abs(int a)       | 返回参数的绝对值                               |
| public static double ceil(double a)  | 返回大于或等于参数的最小double值，等于一个整数 |
| public static double floor(double a) | 返回小于或等于参数的最大double值，等于一个整数 |
| public   static int round(float a)   | 按照四舍五入返回最接近参数的int                |

# 第二章 BigInteger类

## 2.1 概述

`java.math.BigInteger`类，不可变的任意精度的整数。如果运算中，数据的范围超过了long类型后，可以使用BigInteger类实现，该类的计算整数是不限制长度的。

## 2.2 构造方法

BigInteger(String value) 将 BigInteger 的十进制字符串表示形式转换为 BigInteger。超过long类型的范围，已经不能称为数字了，因此构造方法中采用字符串的形式来表示超大整数，将超大整数封装成BigInteger对象。

## 2.3 常用方法

| 方法名                     | 含义                                                         |
| -------------------------- | ------------------------------------------------------------ |
| add(BigInteger value)      | 返回其值为 `(this + val)` 的 BigInteger，超大整数加法运算    |
| subtract(BigInteger value) | 返回其值为 `(this - val)` 的 BigInteger，超大整数减法运算    |
| multiply(BigInteger value) | 返回其值为 `(this * val)` 的 BigInteger，超大整数乘法运算    |
| divide(BigInteger value)   | 返回其值为 `(this / val)` 的 BigInteger，超大整数除法运算，除不尽取整数部分 |

```java
public static void main(String[] args){
    BigInteger big1 = new BigInteger("987654321123456789000");
    BigInteger big2 = new BigInteger("123456789987654321");
    //加法运算
    BigInteger add = big1.add(big2);
    System.out.println("求和:"+add);
    //减法运算
    BigInteger sub = big1.subtract(big2);
    System.out.println("求差:"+sub);
    //乘法运算
    BigInteger mul = big1.multiply(big2);
    System.out.println("乘积:"+mul);
    //除法运算
    BigInteger div = big1.divide(big2);
    System.out.println("除法:"+div);
}
```

# 第三章 BigDecimal类

## 3.1 概述

`java.math.BigDecimal`类，不可变的、任意精度的有符号十进制数。该类可以实现超大浮点数据的精确运算。

## 3.2 构造方法

BigDecimal(String value)将 BigDecimal的十进制字符串表示形式转换为 BigDecimal。

## 3.3 常用方法

BigDecimal类的加法减法乘法与BigInteger类相同，不在重复。

## 3.4 除法计算

BigDecimal类实现精确的浮点数除法运算，如果两个浮点除法计算后是无限循环，那么就会抛出异常。

除法运算方法：

- BigDecimal divide(BigDecimal divisor,int scale,int roundingMode)
  - divesor：此 BigDecimal 要除以的值。
  - scale：保留的位数
  - roundingMode：舍入方式
- 舍入方式：BigDecimal类提供静态的成员变量来表示舍入的方式
  - BigDecimal.ROUND_UP  向上加1。
  - BigDecimal.ROUND_DOWN 直接舍去。
  - BigDecimal.ROUND_HALF_UP 四舍五入。

```java
public static void main(String[] args){
      BigDecimal big1 = new BigDecimal("5.25");
      BigDecimal big2 = new BigDecimal("3.25");
      //加法计算
      BigDecimal add = big1.add(big2);
      System.out.println("求和:"+add);
      //减法计算
      BigDecimal sub = big1.subtract(big2);
      System.out.println("求差:"+sub);
      //乘法计算
      BigDecimal mul = big1.multiply(big2);
      System.out.println("乘法:"+mul);
      //除法计算
      BigDecimal div = big1.divide(big2,2,BigDecimal.ROUND_HALF_UP);
      System.out.println(div);
}
```

# 第四章 基本类型包装类

## 4.1 概述

Java提供了两个类型系统，基本类型与引用类型，使用基本类型在于效率，然而很多情况，会创建对象使用，因为对象可以做更多的功能，如果想要我们的基本类型像对象一样操作，就可以使用基本类型对应的包装类，如下：

| 基本类型 | 对应的包装类（位于java.lang包中） |
| -------- | --------------------------------- |
| byte     | Byte                              |
| short    | Short                             |
| int      | **Integer**                       |
| long     | Long                              |
| float    | Float                             |
| double   | Double                            |
| char     | **Character**                     |
| boolean  | Boolean                           |

## 4.2 Integer类

- Integer类概述

  包装一个对象中的原始类型 int 的值

- Integer类构造方法及静态方法

| 方法名                                  | 说明                                     |
| --------------------------------------- | ---------------------------------------- |
| public Integer(int   value)             | 根据 int 值创建 Integer 对象(过时)       |
| public Integer(String s)                | 根据 String 值创建 Integer 对象(过时)    |
| public static Integer valueOf(int i)    | 返回表示指定的 int 值的 Integer   实例   |
| public static Integer valueOf(String s) | 返回一个保存指定值的 Integer 对象 String |

```java
public static void main(String[] args) {
    //public Integer(int value)：根据 int 值创建 Integer 对象(过时)
    Integer i1 = new Integer(100);
    System.out.println(i1);

    //public Integer(String s)：根据 String 值创建 Integer 对象(过时)
    Integer i2 = new Integer("100");
    //Integer i2 = new Integer("abc"); //NumberFormatException
    System.out.println(i2);
    System.out.println("--------");

    //public static Integer valueOf(int i)：返回表示指定的 int 值的 Integer 实例
    Integer i3 = Integer.valueOf(100);
    System.out.println(i3);

    //public static Integer valueOf(String s)：返回一个保存指定值的Integer对象 String
    Integer i4 = Integer.valueOf("100");
    System.out.println(i4);
}
```

## 4.3 装箱与拆箱

基本类型与对应的包装类对象之间，来回转换的过程称为”装箱“与”拆箱“：

- **装箱**：从基本类型转换为对应的包装类对象。
- **拆箱**：从包装类对象转换为对应的基本类型。

用Integer与 int为例：（看懂代码即可）

基本数值---->包装对象

```java
Integer i = new Integer(4);//使用构造函数函数
Integer iii = Integer.valueOf(4);//使用包装类中的valueOf方法
```

包装对象---->基本数值

```java
int num = i.intValue();
```

## 4.4 自动装箱与自动拆箱

由于我们经常要做基本类型与包装类之间的转换，从Java 5（JDK 1.5）开始，基本类型与包装类的装箱、拆箱动作可以自动完成。例如：

```java
Integer i = 4;//自动装箱。相当于Integer i = Integer.valueOf(4);
i = i + 5;//等号右边：将i对象转成基本数值(自动拆箱) i.intValue() + 5;
//加法运算完成后，再次装箱，把基本数值转成对象。
```

## 4.5 基本类型与字符串之间的转换

基本类型转换为String

- 转换方式
  - 方式一：直接在数字后加一个空字符串
  - 方式二：通过String类静态方法valueOf()
- 示例代码

```java
public static void main(String[] args) {
    //int --- String
    int number = 100;
    //方式1
    String s1 = number + "";
    System.out.println(s1);
    //方式2
    //public static String valueOf(int i)
    String s2 = String.valueOf(number);
    System.out.println(s2);
    System.out.println("--------");
}
```

String转换成基本类型 

除了Character类之外，其他所有包装类都具有parseXxx静态方法可以将字符串参数转换为对应的基本类型：

- `public static byte parseByte(String s)`：将字符串参数转换为对应的byte基本类型。
- `public static short parseShort(String s)`：将字符串参数转换为对应的short基本类型。
- `public static int parseInt(String s)`：将字符串参数转换为对应的int基本类型。
- `public static long parseLong(String s)`：将字符串参数转换为对应的long基本类型。
- `public static float parseFloat(String s)`：将字符串参数转换为对应的float基本类型。
- `public static double parseDouble(String s)`：将字符串参数转换为对应的double基本类型。
- `public static boolean parseBoolean(String s)`：将字符串参数转换为对应的boolean基本类型。

# 第五章 异常

## 5.1 异常概念

异常，就是不正常的意思。在生活中:医生说,你的身体某个部位有异常,该部位和正常相比有点不同,该部位的功能将受影响.在程序中的意思就是：

- **异常** ：指的是程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常停止。

在Java等面向对象的编程语言中，异常本身是一个类，产生异常就是创建异常对象并抛出了一个异常对象。Java处理异常的方式是中断处理。

> 异常指的并不是语法错误,语法错了,编译不通过,不会产生字节码文件,根本不能运行.

## 5.2 异常体系

异常机制其实是帮助我们**找到**程序中的问题，异常的根类是`java.lang.Throwable`，其下有两个子类：`java.lang.Error`与`java.lang.Exception`，平常所说的异常指`java.lang.Exception`。

![](img/异常体系.png)

**Throwable体系：**

- **Error**:严重错误Error，无法通过处理的错误，只能事先避免，好比绝症。
- **Exception**:表示异常，异常产生后程序员可以通过代码的方式纠正，使程序继续运行，是必须要处理的。好比感冒、阑尾炎。

**Throwable中的常用方法：**

- `public void printStackTrace()`:打印异常的详细信息。

  *包含了异常的类型,异常的原因,还包括异常出现的位置,在开发和调试阶段,都得使用printStackTrace。*

- `public String getMessage()`:获取发生异常的原因。

  *提示给用户的时候,就提示错误原因。*

- `public String toString()`:获取异常的类型和异常描述信息(不用)。

***出现异常,不要紧张,把异常的简单类名,拷贝到API中去查。***

![](img/简单的异常查看.jpg)

## 5.3 异常分类

我们平常说的异常就是指Exception，因为这类异常一旦出现，我们就要对代码进行更正，修复程序。

**异常(Exception)的分类**:根据在编译时期还是运行时期去检查异常?

- **编译时期异常**:checked异常。在编译时期,就会检查,如果没有处理异常,则编译失败。(如日期格式化异常)
- **运行时期异常**:runtime异常。在运行时期,检查异常.在编译时期,运行异常不会编译器检测(不报错)。(如数学异常)

![](img/异常的分类.png)

## 5.4 异常的产生过程解析

先运行下面的程序，程序会产生一个数组索引越界异常ArrayIndexOfBoundsException。我们通过图解来解析下异常产生的过程。

 工具类：

```java
public class ArrayTools {
    // 对给定的数组通过给定的角标获取元素。
    public static int getElement(int[] arr, int index) {
        int element = arr[index];
        return element;
    }
}
```

测试类：

```java
public class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = { 34, 12, 67 };
        intnum = ArrayTools.getElement(arr, 4)
        System.out.println("num=" + num);
        System.out.println("over");
    }
}
```

上述程序执行过程图解：

![](img/异常产生过程.png)

# 第六章 异常处理

Java异常处理的五个关键字：**try、catch、finally、throw、throws**

## 6.1 抛出异常throw

在编写程序时，我们必须要考虑程序出现问题的情况。比如，在定义方法时，方法需要接受参数。那么，当调用方法使用接受到的参数时，首先需要先对参数数据进行合法的判断，数据若不合法，就应该告诉调用者，传递合法的数据进来。这时需要使用抛出异常的方式来告诉调用者。

在java中，提供了一个**throw**关键字，它用来抛出一个指定的异常对象。那么，抛出一个异常具体如何操作呢？

1. 创建一个异常对象。封装一些提示信息(信息可以自己编写)。

2. 需要将这个异常对象告知给调用者。怎么告知呢？怎么将这个异常对象传递到调用者处呢？通过关键字throw就可以完成。throw 异常对象。

   throw**用在方法内**，用来抛出一个异常对象，将这个异常对象传递到调用者处，并结束当前方法的执行。

**使用格式：**

```java
throw new 异常类名(参数);
```

学习完抛出异常的格式后，我们通过下面程序演示下throw的使用。

```java
public static void main(String[] args) {
    //创建一个数组 
    int[] arr = {2,4,52,2};
    //根据索引找对应的元素 
    int index = 4;
    int element = getElement(arr, index);

    System.out.println(element);
    System.out.println("over");
}
  /*
   * 根据 索引找到数组中对应的元素
   */
public static int getElement(int[] arr,int index){ 
    //判断  索引是否越界
    if(index<0 || index>arr.length-1){
        /*
             判断条件如果满足，当执行完throw抛出异常对象后，方法已经无法继续运算。
             这时就会结束当前方法的执行，并将异常告知给调用者。这时就需要通过异常来解决。 
              */
        throw new ArrayIndexOutOfBoundsException("哥们，角标越界了~~~");
    }
    int element = arr[index];
    return element;
}
```

注意：如果产生了问题，我们就会throw将问题描述类即异常进行抛出，也就是将问题返回给该方法的调用者。

那么对于调用者来说，该怎么处理呢？一种是进行捕获处理，另一种就是继续讲问题声明出去，使用throws声明处理。

## 6.2  声明异常throws

**声明异常**：将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，而没有捕获处理（稍后讲解该方式），那么必须通过throws进行声明，让调用者去处理。

关键字**throws**运用于方法声明之上,用于表示当前方法不处理异常,而是提醒该方法的调用者来处理异常(抛出异常).

**声明异常格式：**

```java
修饰符 返回值类型 方法名(参数) throws 异常类名1,异常类名2…{   }	
```

声明异常的代码演示：

```java
public static void main(String[] args) throws FileNotFoundException {
	read("a.txt");
}

// 如果定义功能时有问题发生需要报告给调用者。可以通过在方法上使用throws关键字进行声明
public static void read(String path) throws FileNotFoundException {
	if (!path.equals("a.txt")) {//如果不是 a.txt这个文件 
	// 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
	throw new FileNotFoundException("文件不存在");
	}
}
```

throws用于进行异常类的声明，若该方法可能有多种异常情况产生，那么在throws后面可以写多个异常类，用逗号隔开。

```java
public static void main(String[] args) throws IOException {
	read("a.txt");
}

public static void read(String path)throws FileNotFoundException, IOException {
	if (!path.equals("a.txt")) {//如果不是 a.txt这个文件 
	// 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
	throw new FileNotFoundException("文件不存在");
	}
	if (!path.equals("b.txt")) {
		throw new IOException();
	}
}
```

## 6.3  捕获异常try…catch

如果异常出现的话,会立刻终止程序,所以我们得处理异常:

1. 该方法不处理,而是声明抛出,由该方法的调用者来处理(throws)。
2. 在方法中使用try-catch的语句块来处理异常。

**try-catch**的方式就是捕获异常。

- **捕获异常**：Java中对异常有针对性的语句进行捕获，可以对出现的异常进行指定方式的处理。

捕获异常语法如下：

```java
try{
     编写可能会出现异常的代码
}catch(异常类型  e){
     处理异常的代码
     //记录日志/打印异常信息/继续抛出异常
}
```

演示如下：

```java
public static void main(String[] args) {
	try {// 当产生异常时，必须有处理方式。要么捕获，要么声明。
	read("b.txt");
	} catch (FileNotFoundException e) {// 括号中需要定义什么呢？
	//try中抛出的是什么异常，在括号中就定义什么异常类型
	System.out.println(e);
	}
	System.out.println("over");
}
/*
*
* 我们 当前的这个方法中 有异常  有编译期异常
*/
public static void read(String path) throws FileNotFoundException {
	if (!path.equals("a.txt")) {//如果不是 a.txt这个文件 
	// 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
	throw new FileNotFoundException("文件不存在");
	}
}
```

如何获取异常信息：

Throwable类中定义了一些查看方法:

- `public String getMessage()`:获取异常的描述信息,原因(提示给用户的时候,就提示错误原因。

- `public String toString()`:获取异常的类型和异常描述信息(不用)。
- `public void printStackTrace()`:打印异常的跟踪栈信息并输出到控制台。

包含了异常的类型,异常的原因,还包括异常出现的位置,在开发和调试阶段,都得使用printStackTrace。

在开发中呢也可以在catch将编译期异常转换成运行期异常处理。

## 6.4 finally 代码块

**finally**：有一些特定的代码无论异常是否发生，都需要执行。另外，因为异常会引发程序跳转，导致有些语句执行不到。而finally就是解决这个问题的，在finally代码块中存放的代码都是一定会被执行的。

什么时候的代码必须最终执行？

当我们在try语句块中打开了一些物理资源(磁盘文件/网络连接/数据库连接等),我们都得在使用完之后,最终关闭打开的资源。

finally的语法:

 try...catch....finally:自身需要处理异常,最终还得关闭资源。

> 注意:finally不能单独使用。

比如在我们之后学习的IO流中，当打开了一个关联文件的资源，最后程序不管结果如何，都需要把这个资源关闭掉。

finally代码参考如下：

```java
public static void main(String[] args) {
	try {
	read("a.txt");
	} catch (FileNotFoundException e) {
	//抓取到的是编译期异常  抛出去的是运行期 
	throw new RuntimeException(e);
	} finally {
	System.out.println("不管程序怎样，这里都将会被执行。");
	}
	System.out.println("over");
}
/*
*
* 我们 当前的这个方法中 有异常  有编译期异常
*/
public static void read(String path) throws FileNotFoundException {
	if (!path.equals("a.txt")) {//如果不是 a.txt这个文件 
	// 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
	throw new FileNotFoundException("文件不存在");
	}
}
```

## 6.5 异常注意事项

- 运行时异常被抛出可以不处理。即不捕获也不声明抛出。

- 如果父类抛出了多个异常,子类覆盖父类方法时,只能抛出相同的异常或者是他的子集。

- 父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出

- 当多异常处理时，捕获处理，前边的类不能是后边类的父类

- 在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收。

- 多个异常使用捕获又该如何处理呢？

  1. 多个异常分别处理。
  2. 多个异常一次捕获，多次处理。
  3. 多个异常一次捕获一次处理。

  一般我们是使用一次捕获多次处理方式，格式如下：

```java
try{
     编写可能会出现异常的代码
}catch(异常类型A  e){  当try中出现A类型异常,就用该catch来捕获.
     处理异常的代码
     //记录日志/打印异常信息/继续抛出异常
}catch(异常类型B  e){  当try中出现B类型异常,就用该catch来捕获.
     处理异常的代码
     //记录日志/打印异常信息/继续抛出异常
}
```

# 第七章 自定义异常

## 7.1 概述

**为什么需要自定义异常类:**

我们说了Java中不同的异常类,分别表示着某一种具体的异常情况,那么在开发中总是有些异常情况是SUN没有定义好的,此时我们根据自己业务的异常情况来定义异常类。,例如年龄负数问题,考试成绩负数问题。

在上述代码中，发现这些异常都是JDK内部定义好的，但是实际开发中也会出现很多异常,这些异常很可能在JDK中没有定义过,例如年龄负数问题,考试成绩负数问题.那么能不能自己定义异常呢？

**什么是自定义异常类:**

在开发中根据自己业务的异常情况来定义异常类.

自定义一个业务逻辑异常: **LoginException**。一个登陆异常类。

**异常类如何定义:**

1. 自定义一个编译期异常: 自定义类 并继承于`java.lang.Exception`。
2. 自定义一个运行时期的异常类:自定义类 并继承于`java.lang.RuntimeException`。

## 7.2 自定义异常的练习

要求：我们模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。

首先定义一个登陆异常类LoginException：

```java
// 业务逻辑异常
public class LoginException extends Exception {
    /**
     * 空参构造
     */
    public LoginException() {
    }

    /**
     *
     * @param message 表示异常提示
     */
    public LoginException(String message) {
        super(message);
    }
}
```

模拟登陆操作，使用数组模拟数据库中存储的数据，并提供当前注册账号是否存在方法用于判断。

```java
public class Demo {
    // 模拟数据库中已存在账号
    private static String[] names = {"bill","hill","jill"};
   
    public static void main(String[] args) {     
        //调用方法
        try{
              // 可能出现异常的代码
            checkUsername("nill");
            System.out.println("注册成功");//如果没有异常就是注册成功
        }catch(LoginException e){
            //处理异常
            e.printStackTrace();
        }
    }

    //判断当前注册账号是否存在
    //因为是编译期异常，又想调用者去处理 所以声明该异常
    public static boolean checkUsername(String uname) throws LoginException{
        for (String name : names) {
            if(name.equals(uname)){//如果名字在这里面 就抛出登陆异常
                throw new LoginException("亲"+name+"k已经被注册了！");
            }
        }
        return true;
    }
}
```

