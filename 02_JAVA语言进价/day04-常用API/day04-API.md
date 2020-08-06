# day04 【Object类、常用API】

## 主要内容

- Object类
- 日期类
- 日期格式化
- 日历类
- System
- Arrays
- 正则表达式

## 教学目标

- [ ] 能够说出Object类的特点
- [ ] 能够重写Object类的toString方法
- [ ] 能够重写Object类的equals方法
- [ ] 能够使用将日期格式化为字符串的方法
- [ ] 能够使用将字符串转换成日期的方法
- [ ] 能够使用日历对象的方法
- [ ] 能够使用Math类的方法
- [ ] 能够使用System类获取当前系统毫秒值
- [ ] 能够说出数组冒泡排序的原理
- [ ] 能够说出数组二分查找法的原理
- [ ] 能够使用String类的matches和split方法

# 第一章 Object类

## 1.1 概述

`java.lang.Object`类是Java语言中的根类，每个类都使用 `Object` 作为超类。所有对象（包括数组）都实现这个类的方法。

如果一个类没有特别指定父类，	那么默认则继承自Object类。例如：

```java
public class MyClass /*extends Object*/ {
  	// ...
}
```

## 1.2 native本地方法

在Object类的源码中定义了`native`修饰的方法，`native`修饰的方法称为本地方法。

### 本地方法的特点：

- 被native修饰的方法，非Java语言编写，是由C++语言编写。
- 本地方法在运行时期进入本地方法栈内存，本地方法栈是一块独立内存的区域。
- 本地方法的意义是和操作系统进行交互。

```java
private static native void registerNatives();
static {
    registerNatives();
}
```

当程序运行的时候，Object类会最先被加载到内存中。类进入内存后首先加载自己的静态成员，static代码块中调用了本地方法`registerNatives()`，和操作系统进行交互。

## 1.3 toString()方法

方法声明：`public String toString()`：返回该对象的字符串表示。

Object类toString()方法源码：

```java
public String toString() {
	return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

源码分析：

- `getClass().getName()`返回类的全限定名字。
- `hashCode()`方法返回int值，可以暂时理解为对象的内存地址。
- `Integer.toHexString()`将int类型的值转成十六进制。
- 因此调用对象的toString()方法将看到内存的地址值。

创建Person类，并调用方法toString()

```java
public static void main(String[] args){
    Person person = new Person();
    String str = person.toString();
    System.out.println(str);
    System.out.println(person);
}
```

通过程序运行，得到结论，**在输出语句中打印对象，就是在调用对象的toString()方法**。

### toString()方法的重写

由于toString方法返回的结果是内存地址，而在开发中，内存地址并没有实际的应用价值，经常需要按照对象的属性得到相应的字符串表现形式，因此也需要重写它。

```java
public class Person {  
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person"+name+":"+age;
    }
    // 省略构造器与Getter Setter
}
```

## 1.4 equals方法

方法声明：`public boolean equals(Object obj)`：指示其他某个对象是否与此对象“相等”。

Object类equals()方法源码：

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

源码分析：

- this是当前对象，哪个对象调用的equals方法就表示哪个对象。
- obj表述传递的参数，参数类型Object，可以传递任意类型对象。
- this==obj 比较两个对象的内存地址是否相同

**equals方法默认比较两个对象的内存地址是否相同，相同则返回true。**

### equals()方法的重写

实际应用中，比较内存地址是否相同并没有意义，我们可以定义对象自己的比较方式，比较对象中成员变量的值是否相同。需要对方法进行重写。

需求：重写equals()方法，比较两个对象中姓名和年龄是否相同，如果姓名和年龄都相同返回true，否则返回false。

```java
public class Person {
    private String name;
    private int age;
    
    public boolean equals(Object obj){
        //判断两个对象地址弱相同，即为同一个对象
        if(this == obj)
            return true;
        //obj对象为空，无需比较，返回false
        if(obj == null)
            return  false;
        //obj如果是Person类型对象，则强制转换
        if(obj instanceof Person){
            Person person = (Person)obj;
            //比较两个对象的name属性和age属性，如果相等，返回true
            return this.name.equals(person.name) && this.age == person.age;
        }
        return false;
    }
}
```

# 第二章 Date类

`java.util.Date`类 表示特定的瞬间，精确到毫秒。1000毫秒等于1秒。

## 2.1 Date类构造方法

- `public Date()`：从运行程序的此时此刻到时间原点经历的毫秒值,转换成Date对象，分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
- `public Date(long date)`：将指定参数的毫秒值date,转换成Date对象，分配Date对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即1970年1月1日00:00:00 GMT）以来的指定毫秒数。

```java
public static void main(String[] args) {
	// 创建日期对象，把当前的时间
	System.out.println(new Date()); // Tue Jan 16 14:37:35 CST 2020
	// 创建日期对象，把当前的毫秒值转成日期对象
	System.out.println(new Date(0)); // Thu Jan 01 08:00:00 CST 1970
}
```

## 2.2 Date类的常用方法

- `public long getTime()` 把日期对象转换成对应的时间毫秒值。
- `public void setTime(long time)` 把方法参数给定的毫秒值设置给日期对象。

```java
 public static void main(String[] args) {
     //创建日期对象
     Date date = new Date();
     //public long getTime()获取的是日期对象从1970年1月1日 00:00:00到现在的毫秒值
     System.out.println(date.getTime());
     //public void setTime(long time):设置时间，给的是毫秒值
     date.setTime(0);
     System.out.println(date);
 }
```

## 2.3 日期对象和毫秒值的相互转换

日期是不能进行数学计算的，但是毫秒值可以，在需要对日期进行计算时，可以现将日期转成毫秒值后在进行计算。

- 日期对象转成毫秒值：
  - `Date date = new Date(); date.getTime()`
  - `System.currentTimeMillis()`
- 毫秒值转成日期对象：
  - `Date date = new Date(long 毫秒值)`
  - `date.setTime(long 毫秒值)`

# 第三章 DateFormat类

`java.text.DateFormat` 是日期/时间格式化子类的抽象类，我们通过这个类可以帮我们完成日期和文本之间的转换,也就是可以在Date对象与String对象之间进行来回转换。

- **格式化**：按照指定的格式，把Date对象转换为String对象。
- **解析**：按照指定的格式，把String对象转换为Date对象。

## 3.1 构造方法

由于DateFormat为抽象类，不能直接使用，所以需要常用的子类`java.text.SimpleDateFormat`。这个类需要一个模式（格式）来指定格式化或解析的标准。构造方法为：

- `public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。

参数pattern是一个字符串，代表日期时间的自定义格式。

常用的格式规则为：

| 标识字母（区分大小写） | 含义 |
| ---------------------- | ---- |
| y                      | 年   |
| M                      | 月   |
| d                      | 日   |
| H                      | 时   |
| m                      | 分   |
| s                      | 秒   |

> 备注：更详细的格式规则，可以参考SimpleDateFormat类的API文档。

## 3.2 转换方法

- String format(Date date)传递日期对象，返回格式化后的字符串。
- Date parse(String str)传递字符串，返回日期对象。

```java
 public static void main(String[] args) throws ParseException {
     //格式化：从 Date 到 String
     Date d = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
     String s = sdf.format(d);
     System.out.println(s);
     System.out.println("--------");

     //从 String 到 Date
     String ss = "2048-08-09 11:11:11";
     //ParseException
     SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date dd = sdf2.parse(ss);
     System.out.println(dd);
    }
```

# 第四章 Calendar日历类

## 4.1 概念

日历我们都见过

![](img/日历.jpg)

`java.util.Calendar`是日历类，在Date后出现，替换掉了许多Date的方法。该类将所有可能用到的时间信息封装为静态成员变量，方便获取。日历类就是方便获取各个时间属性的。

## 4.2 日历对象获取方式

Calendar是抽象类，不能创建对象，需要使用子类对象。`java.util.GregorianCalendar`类是Calendar的子类，但是创建日历对象需要根据本地的时区，语言环境来创建，比较困难，Calendar类提供了静态方法 getInstance()直接获取子类的对象。

`public static Calendar getInstance()`：使用默认时区和语言环境获得一个日历。

```java
Calendar cal = Calendar.getInstance();
```

## 4.3 常用方法

- `public int get(int field)`：返回给定日历字段的值。
- `public void set(int field, int value)`：将给定的日历字段设置为给定值。
- `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
- `public Date getTime()`：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。

## 4.4 日历字段

Calendar类中提供很多静态成员，直接类名调用，代表给定的日历字段：

| 字段值       | 含义                                  |
| ------------ | ------------------------------------- |
| YEAR         | 年                                    |
| MONTH        | 月（从0开始，可以+1使用）             |
| DAY_OF_MONTH | 月中的天（几号）                      |
| HOUR         | 时（12小时制）                        |
| HOUR_OF_DAY  | 时（24小时制）                        |
| MINUTE       | 分                                    |
| SECOND       | 秒                                    |
| DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |

代码使用简单演示：

```java
public static void main(String[] args) {
    // 创建Calendar对象
    Calendar cal = Calendar.getInstance();
    // 获取年
    int year = cal.get(Calendar.YEAR);
    //设置年份为2020年
    cal.set(Calendar.YEAR, 2020);
    //将年份修改为2000年
    cal.add(Calendar.YEAR,-20)     
    //将日历对象转换为日期对象
    Date d = cal.getTime();
    System.out.println(d);
}    
```

## 4.5 Calendar类练习

- 案例需求

  获取任意一年的二月有多少天

- 案例分析：
  - 可以将日历设置到任意年的三月一日
  - 向前偏移一天
  - 获取偏移后的日历即可

- 代码实现

```java
public static void main(String[] args) {
    //键盘录入任意的年份
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入年：");
    int year = sc.nextInt();

    //设置日历对象的年、月、日
    Calendar c = Calendar.getInstance();
    c.set(year, 2, 1);

    //3月1日往前推一天，就是2月的最后一天
    c.add(Calendar.DATE, -1);

    //获取这一天输出即可
    int date = c.get(Calendar.DATE);
    System.out.println(year + "年的2月份有" + date + "天");
}
```

# 第六章 System

## 6.1 概述

`java.lang.System`类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作。System类私有修饰构造方法，不能创建对象，直接类名调用。

### 常用方法

| 方法名                                                       | 说明                                             |
| ------------------------------------------------------------ | ------------------------------------------------ |
| public   static void exit(int status)                        | 终止当前运行的   Java   虚拟机，非零表示异常终止 |
| public   static long currentTimeMillis()                     | 返回当前时间(以毫秒为单位)                       |
| public static void arrayCopy(Object src, int srcPos, Object dest, int destPos, int length) | 从指定源数组中复制一个数组                       |
| public static void gc()                                      | 运行垃圾回收器。                                 |

## 6.2 练习

在控制台输出1-10000，计算这段代码执行了多少毫秒 

```java
public static void main(String[] args) {
    //获取当前时间毫秒值
    System.out.println(System.currentTimeMillis()); 
    //计算程序运行时间
    long start = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
        	System.out.println(i);
        }
    long end = System.currentTimeMillis();
    System.out.println("共耗时毫秒：" + (end - start));
    }  
```

## 6.3 arrayCopy方法：

- Object src：要复制的数据源数组
- int srcPost：数据源数组的开始索引
- Object dest：复制后的目的数组
- int destPos：目的数组开始索引
- int length：要复制的数组元素的个数

## 6.4 练习：数组元素复制

将源数组中从1索引开始，复制3个元素到目的数组中

```java
public static void main(String[] args){
    int[] src = {1,2,3,4,5};
    int[] dest = {6,7,8,9,0};
    //将源数组中从1索引开始，复制3个元素到目的数组中
    System.arraycopy(src,1,dest,0,3);
    for(int i = 0 ; i < dest.length;i++){
    System.out.println(dest[i]);
}
```

## 6.5 gc()方法

  运行垃圾回收器，JVM将从堆内存中清理对象，清理对象的同时会调用对象的finalize()方法，JVM的垃圾回收器是通过另一个线程开启的，因此程序中的效果并不明显。

```java
public class Person {
    protected void finalize() throws Throwable {
        System.out.println("对象被回收");
}
```

```java
public static void main(String[] args){
	new Person();
	new Person();
	new Person();
	new Person();
	new Person();
	new Person();
	System.gc();
}
```

# 第七章 冒泡排序

  数组的排序，是将数组中的元素按照大小进行排序，默认都是以升序的形式进行排序，数组排序的方法很多，我们讲解的是数组的冒泡排序。

  排序，都要进行数组 元素大小的比较，再进行位置的交换。冒泡排序法是采用数组中相邻元素进行比较换位。

## 7.1 冒泡排序图解

![](img/冒泡排序.png)

## 7.2 代码实现

```java
public static void main(String[] args) {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {7, 6, 5, 4, 3};
        System.out.println("排序前：" + arrayToString(arr));
        // 这里减1，是控制每轮比较的次数
        for (int x = 0; x < arr.length - 1; x++) {
            // -1是为了避免索引越界，-x是为了调高比较效率
            for (int i = 0; i < arr.length - 1 - x; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("排序后：" + arrayToString(arr));
    }
        //把数组中的元素按照指定的规则组成一个字符串：[元素1, 元素2, ...]
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }
        sb.append("]");
        String s = sb.toString();
        return s;
    }
```

# 第八章 数组的二分查找法

所谓数组的二分查找法，对于一个有序数组，查找一个元素是否存在于数组中，如果存在就返回出现的索引，如果不存在就返回负数。

## 8.1 二分查找法原理

取数组中间的元素和被查找的元素进行比较，如果被查找元素大于数组中间元素，就舍去数组元素的一半，对另一半继续进行查找。

![](img/二分查找.jpg)

## 8.2 代码实现

```java
 public static void main(String[] args) {
        int[] arr = {5,13,19,21,37,56,64,75,80,88,92};
        int key = 21;
        int index = binarySearch(arr, key);
        System.out.println(index);

    }
    public static int binarySearch(int[]arr,int key){
        //最小索引
        int low = 0;
        //最大索引
        int height = arr.length - 1;
        //初始化中间索引
        int mid = 0;
        //循环折半，最小索引小于等于最大索引时，才能折半
        while (low <= height){
            //折半，计算中间索引
            mid = (height + low) / 2;
            if(key > arr[mid]){
                //元素大于数组中间索引元素，移动最小索引
                low = mid + 1;
            }else if(key < arr[mid]){
                //元素小于数组中间索引元素，移动最大索引
                height = mid - 1;
            }else{
                //查询到元素，返回索引
                return mid;
            }
        }
        //循环查找结束后，找不到元素，返回-1
        return - 1;
    }
```

# 第九章 Arrays

## 9.1 概述

`java.util.Arrays`  此类包含用来操作数组的各种方法，比如排序和搜索等。Arrays类私有修饰构造方法，其所有方法均为静态方法，调用起来非常简单。

## 9.2 常用方法

| 方法名                                          | 说明                                            |
| ----------------------------------------------- | ----------------------------------------------- |
| public static void sort(int[] a)                | 对指定的int数组进行升序排列                     |
| public static int binarySearch(int[] a,int key) | 对数组进行二分查找法，找不到元素返回(-插入点)-1 |
| public static String toString(int[] a)          | 将数组转成字符串                                |

```java
public static void main(String[] args){
	int[] arr = {5,1,9,2,33,18,29,51};
    //数组升序排列
    Arrays.sort(arr);
    //数组转成字符串
    String arrStr = Arrays.toString(arr);
    System.out.println(arrStr);
    //数组二分查找
    int index = Arrays.binarySearch(arr,9);
    System.out.println(index);
}
```

# 第十章 正则表达式

正则表达式是对字符串操作的一种规则，事先定义好一些字符串，这些字符串称为规则字符串，使用规则字符串表达一些逻辑功能。

例如：指定一个字符串itheima123@itcast.cn，判断出这个字符串是否符合电子邮件的规则。使用字符串String对象的方法是可以完成的，但是非常复杂，若使用正则表达式则会非常的简单实现。

## 10.1 正则规则-字符类

| 规则写法    | 规则含义                                    |
| ----------- | ------------------------------------------- |
| [abc]       | a、b 或 c（简单类）                         |
| [^abc]      | 任何字符，除了 a、b 或 c（否定）            |
| [a-zA-Z]    | a 到 z 或 A到 Z，两头的字母包括在内（范围） |
| [0-9]       | 0到9，两头的数字包括在内（范围）            |
| [a-zA-Z0-9] | a 到 z 或 A到 Z或0-9                        |

## 10.2 正则规则-预定义字符类

| 规则写法 | 规则含义                  |
| -------- | ------------------------- |
| .        | 任何字符                  |
| \d       | 数字[0-9]                 |
| \D       | 非数字 `[^0-9]`           |
| \w       | 单词字符 [a-zA-Z0-9_]     |
| \W       | 非单词字符`[^a-zA-Z0-9_]` |

## 10.3 正则规则-数量词

| 规则写法 | 规则含义                       |
| -------- | ------------------------------ |
| X{?}     | 一次或一次也没有               |
| X{*}     | 零次或多次                     |
| X{+}     | 一次或多次                     |
| X{n}     | 恰好 *n* 次                    |
| X{n,}    | 至少 *n* 次                    |
| X{n,m}   | 至少 *n* 次，但是不超过 *m* 次 |

## 10.4 正则练习-String类matches方法

方法：boolean matches(String regex)传递正则表达式规则，检测字符串是否匹配正则表达式规则，匹配返回true。

需求：检查手机号，检查邮件地址。

分析：

- 手机号：只能1开头，第二位可以是345678任意一个，第三位开始全数字，总长11位。
- 邮件地址：@前面可以是数字，字母，下划线。@后面是字母和.。

```java
public static void main(String[] args){
    //验证手机号码
    String tel = "13800138000";
    String telRegex = "1[345678][0-9]{9}";
    boolean flag = tel.matches(telRegex);
    System.out.println(flag);
    //验证邮件地址
    String email = "s_123456@sina.com.cn.";
    String emailRegex = "[a-zA-Z0-9_]+@([a-z]+\\.[a-z]+)+";
    flag = email.matches(emailRegex);
    System.out.println(flag);
}
```

## 10.5 正则练习-String类split方法

方法：String[] split(String regex)传递正则表达式规则，以正则规则对字符串进行切割。

```java
public static void main(String[] args){
    String str1 = "ab  a   bbb  abc   aa      c";
    //对空格进行切割
    String[] strArr =str1.split(" +");
    System.out.println(Arrays.toString(strArr));

    String str2 = "192.168.22.123";
    strArr = str2.split("\\.");
    System.out.println(Arrays.toString(strArr));
}
```

**注意：输出数组元素时会看到存在一个多余空格，Arrays.toString()方法源码中追加的空格。**