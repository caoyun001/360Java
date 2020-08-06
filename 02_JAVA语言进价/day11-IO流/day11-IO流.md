# day11【IO流】

## 今日内容

- File类
- 递归
- 文件过滤器
- 字节流
- 文件复制
- 字节缓冲流

## 教学目标

- [ ] 能够说出File对象的创建方式
- [ ] 能够使用File类常用方法
- [ ] 能够辨别相对路径和绝对路径
- [ ] 能够遍历文件夹
- [ ] 能够解释递归的含义
- [ ] 能够使用递归的方式计算5的阶乘
- [ ] 能够说出使用递归会内存溢出隐患的原因
- [ ] 能够说出IO流的分类和功能
- [ ] 能够使用字节流复制文件
- [ ] 能够使用字节流缓冲流复制文件

# 第一章 File类

## 1.1 概述

`java.io.File` 类是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。File类将文件，文件夹和路径封装成了对象，提供大量的方法来操作这些对象。

## 1.2 File类的静态成员变量

- `static String pathSeparator` 与系统有关的路径分隔符。
  - Window操作系统，分隔符是分号。
  - Linux操作系统，分隔符是冒号。
- `static String separator` 与系统有关的默认名称分隔符。
  - Window操作系统，名称分割符号为 \。
  - Linux操作系统，名称分隔符号为 /。

## 1.3 File类构造方法

- `public File(String pathname) ` ：通过将给定的**路径名字符串**转换为抽象路径名来创建新的 File实例。  
- `public File(String parent, String child) ` ：从**父路径名字符串和子路径名字符串**创建新的 File实例。
- `public File(File parent, String child)` ：从**父抽象路径名和子路径名字符串**创建新的 File实例。  

```java
public static void main(String[] args){
    // 文件路径名
    String pathname = "D:\\aaa.txt";
    File file1 = new File(pathname); 
    System.out.println(file1);

    // 通过父路径和子路径字符串
    String parent = "d:\\aaa";
    String child = "bbb.txt";
    File file2 = new File(parent, child);
    System.out.println(file2);
    
    // 通过父级File对象和子路径字符串
    File parentDir = new File("d:\\aaa");
    String child = "bbb.txt";
    File file3 = new File(parentDir, child);
    System.out.println(file3);
}
```

**注意**：

1. 一个File对象代表硬盘中实际存在的一个文件或者目录。
2. 无论该路径下是否存在文件或者目录，都不影响File对象的创建。

## 1.4 File类的获取方法

- `public String getAbsolutePath() ` ：返回此File的绝对路径名字符串。
- ` public String getPath() ` ：将此File转换为路径名字符串。 
- `public String getName()`  ：返回由此File表示的文件或目录的名称。  
- `public long length()`  ：返回由此File表示的文件的长度。 
- `public File getParentFile()`返回由此File表示的文件或目录的父目录，如果没有父目录，返回null。

```java
public static void main(String[] args) {
    File f = new File("d:/aaa/bbb.java");     
    System.out.println("文件绝对路径:"+f.getAbsolutePath());
    System.out.println("文件构造路径:"+f.getPath());
    System.out.println("文件名称:"+f.getName());
    System.out.println("文件长度:"+f.length()+"字节");
    System.out.ptintln("文件路径的父路径"+f.getParentFile());

    File f2 = new File("d:/aaa");     
    System.out.println("目录绝对路径:"+f2.getAbsolutePath());
    System.out.println("目录构造路径:"+f2.getPath());
    System.out.println("目录名称:"+f2.getName());
    System.out.println("目录长度:"+f2.length());
    System.out.ptintln("目录父路径"+f2.getParentFile());
}
```

## 1.5 绝对路径和相对路径

- **绝对路径**：从盘符开始的路径，这是一个完整的路径，绝对路径具有唯一性。
- **相对路径**：相对于项目目录的路径，这是一个便捷的路径，开发中经常使用。

```java
public static void main(String[] args) {
    // D盘下的bbb.java文件
    File f = new File("D:\\bbb.java");
    System.out.println(f.getAbsolutePath());

    // 项目下的bbb.java文件
    File f2 = new File("bbb.java");
    System.out.println(f2.getAbsolutePath());
}
```

## 1.6 File类判断方法

- `public boolean exists()` ：此File表示的文件或目录是否实际存在。
- `public boolean isDirectory()` ：此File表示的是否为目录。
- `public boolean isFile()` ：此File表示的是否为文件。

```java
public static void main(String[] args) {
    File f = new File("d:\\aaa\\bbb.java");
    File f2 = new File("d:\\aaa");
    // 判断是否存在
    System.out.println("d:\\aaa\\bbb.java 是否存在:"+f.exists());
    System.out.println("d:\\aaa 是否存在:"+f2.exists());
    // 判断是文件还是目录
    System.out.println("d:\\aaa 文件?:"+f2.isFile());
    System.out.println("d:\\aaa 目录?:"+f2.isDirectory());
}
```

## 1.7 File类创建删除功能的方法

- `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。 
- `public boolean delete()` ：删除由此File表示的文件或目录。  不进回收站，直接删除。
- `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。

```java
public static void main(String[] args) throws IOException {
    // 文件的创建
    File f = new File("aaa.txt");
    System.out.println("是否存在:"+f.exists()); // false
    System.out.println("是否创建:"+f.createNewFile()); // true
    System.out.println("是否存在:"+f.exists()); // true

    // 目录的创建
    File f2= new File("newDir");	
    System.out.println("是否存在:"+f2.exists());// false
    System.out.println("是否创建:"+f2.mkdirs());// true
    System.out.println("是否存在:"+f2.exists());// true

    // 文件的删除
    System.out.println(f.delete());// true

    // 目录的删除
    System.out.println(f2.delete());// true
    }
```

## 1.8 File类目录遍历方法

- `public File[] listFiles()`返回一个File数组，表示该File目录中的所有的子文件或目录、
- `public File[] listFiles(FileFilter filter)`返回一个File数组，表示该File目录中的所有的子文件或目录，filter是文件过滤器，可以过滤不需要的文件。

```java
public static void main(String[] args) {
    File dir = new File("d:\\java_code");
    //获取当前目录下的文件以及文件夹对象，只要拿到了文件对象，那么就可以获取更多信息
    File[] files = dir.listFiles();
    for (File file : files) {
    	System.out.println(file);
    }
}
```

### FileFilter接口

文件过滤器接口，此接口的实现类可以传递给方法listFiles()，实现文件的过滤功能

FileFilter接口方法：

`public boolean accept(File path)`：方法参数就是listFiles()方法获取到的文件或者目录的路径。如果方法返回true，表示需要此路径，否则此路径将被忽略。

### 遍历目录，获取所有的Java文件

```java
public static void main(String[] args){
    File dir = new File("d:\\demo");
    File[] files = dir.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        //判断如果获取到的是目录，直接放行
        if(pathname.isDirectory())
        return true;
        //获取路径中的文件名，判断是否java结尾，是就返回true
        return pathname.getName().toLowerCase().endsWith("java");
      }
    });
    for(File file : files){
    	System.out.println(file);
    }
}
```

# 第二章 方法递归

## 2.1 概述

- **递归**：指在当前方法内调用自己的这种现象。

```java
public static void a(){
    a();
}
```

## 2.2 递归求和  

### 计算1 ~ n的和

**分析**：num的累和 = num + (num-1)的累和，所以可以把累和的操作定义成一个方法，递归调用。

实现代码：

```java
public static void main(String[] args) {
    //计算1~num的和，使用递归完成
    int num = 5;
    // 调用求和的方法
    int sum = getSum(num);
    // 输出结果
    System.out.println(sum);

}
/*
通过递归算法实现.
参数列表:int 
返回值类型: int 
*/
public static int getSum(int num) {
    /* 
    num为1时,方法返回1,
    相当于是方法的出口,num总有是1的情况
    */
    if(num == 1){
    	return 1;
    }
    /*
    num不为1时,方法返回 num +(num-1)的累和
    递归调用getSum方法
    */
    return num + getSum(num-1);
}
```

代码执行图解：

![](img/递归.jpg)

**注意**：递归一定要有条件限定，保证递归能够停止下来，否则就是四递归。递归次数不要太多，否则会发生栈内存溢出，会抛出StackOverflowError错误。

## 2.3 递归求阶乘

### **阶乘**：所有小于及等于该数的正整数的积。

分析：n的阶乘：n! = n * (n-1) *...* 3 * 2 * 1 

```java
//计算n的阶乘，使用递归完成
public static void main(String[] args) {
    int n = 3;
    // 调用求阶乘的方法
    int value = getValue(n);
    // 输出结果
    System.out.println("阶乘为:"+ value);
}
    /*
    通过递归算法实现.
    参数列表:int 
    返回值类型: int 
    */
public static int getValue(int n) {
    // 1的阶乘为1
    if (n == 1) {
    	return 1;
}
    /*
    n不为1时,方法返回 n! = n*(n-1)!
    递归调用getValue方法
    */
    return n * getValue(n - 1);
}
```

## 2.4 目录遍历

遍历`D:\aaa` 目录下的所有文件和所有的子目录。

**分析**：目录遍历，无法判断多少级目录，所以在遍历需要进行判断，如果遍历到的还是目录，就要使用递归，遍历所有目录。

```java
public static void main(String[] args){
    // 创建File对象
    File dir  = new File("D:\\aaa");
    // 调用打印目录方法
    printDir(dir);
}

public static void printDir(File dir) {
    System.out.println(dir);
    // 获取子文件和目录
    File[] files = dir.listFiles();
    // 循环打印
    for (File file : files) {
        //判断是文件，直接输出
        if (file.isFile()) {
       	 	System.out.println(file);
        } else {
        	// 是目录，继续遍历,形成递归
        	printDir(file);	
        }
    }
}
```

## 2.5 目录遍历搜索java文件

```java
public static void main(String[] args){
    // 创建File对象
    File dir  = new File("D:\\aaa");
    // 调用打印目录方法
    printDir(dir);
}

public static void printDir(File dir) {
    // 获取子文件和目录
    File[] files = dir.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            if(pathname.isDirectory())
                return true;
            return pathname.getName().toLowerCase().endsWith("java");
        }
    });
    // 循环打印
    for (File file : files) {
        if (file.isFile()) {
        	System.out.println(file);
        } else {
        	// 是目录，继续遍历,形成递归
        	printDir(file);
        }
    }
}
```

# 第三章 IO流

## 3.1 什么是IO

生活中，你肯定经历过这样的场景。当你编辑一个文本文件，忘记了`ctrl+s` ，可能文件就白白编辑了。当你电脑上插入一个U盘，可以把一个视频，拷贝到你的电脑硬盘里。那么数据都是在哪些设备上的呢？键盘、内存、硬盘、外接设备等等。

我们把这种数据的传输，可以看做是一种数据的流动，按照流动的方向，以内存为基准，分为`输入input` 和`输出output` ，即流向内存是输入流，流出内存的输出流。

Java中I/O操作主要是指使用`java.io`包下的内容，进行输入、输出操作。**输入**也叫做**读取**数据，**输出**也叫做作**写出**数据。

## 3.2 IO的分类

根据数据的流向分为：**输入流**和**输出流**。

- **输入流** ：把数据从`其他设备`上读取到`内存`中的流。 
- **输出流** ：把数据从`内存` 中写出到`其他设备`上的流。

格局数据的类型分为：**字节流**和**字符流**。

- **字节流** ：以字节为单位，读写数据的流。
- **字符流** ：以字符为单位，读写数据的流。

## 3.3 IO的流向说明图解

![](img/1_io.jpg)

## 3.4 IO流顶层父类

| 类                   | 含义                                                    |
| -------------------- | ------------------------------------------------------- |
| java.io.OutputStream | 字节输出流顶层父类，抽象类，定义了写出数据方法write()。 |
| java.io.InputStream  | 字节输入流顶层父类，抽象类，定义了读取数据方法read()。  |
| java.io.Writer       | 字符输出流顶层父类，抽象类，定义了写出数据方法write()。 |
| java.io.Reader       | 字符输入流顶层父类，抽象类，定义了读取数据方法read()。  |

# 第四章 字节流

## 4.1 一切都是字节

一切文件数据(文本、图片、视频等)在存储时，都是以二进制数字的形式保存，都一个一个的字节，那么传输时一样如此。所以，字节流可以传输任意文件数据。在操作流的时候，我们要时刻明确，无论使用什么样的流对象，底层传输的始终为二进制数据。

**提示**：8个二进制位为1个字节，0000-0000 是1个字节。

## 4.2 字节输出流OutputStream

`java.io.OutputStream `抽象类是表示字节输出流的所有类的超类，将指定的字节信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `public void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  
- `public void write(byte[] b)`：将 b.length字节从指定的字节数组写入此输出流。  
- `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。  
- `public abstract void write(int b)` ：将指定的字节输出流。

**注意**：close方法，当完成流的操作时，必须调用此方法，释放系统资源。

## 4.3 FileOutputStream类

`OutputStream`有很多子类，我们从最简单的一个子类开始。

`java.io.FileOutputStream `类是文件输出流，用于将数据写出到文件。

### 构造方法

- `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
- `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有这个文件，会清空这个文件的数据。

```java
public class FileOutputStreamConstructor  {
    public static void main(String[] args) throws IOException{
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);
      
        // 使用文件名称创建流对象
        //FileOutputStream fos = new FileOutputStream("b.txt");
    }
}
```

### 写出字节数据

- **写出字节**：`write(int b)` 方法，每次可以写出一个字节数据，代码使用演示：

```java
public static void main(String[] args) throws IOException {
    // 使用文件名称创建流对象
    FileOutputStream fos = new FileOutputStream("fos.txt");     
    // 写出数据
    fos.write(97); // 写出第1个字节
    fos.write(98); // 写出第2个字节
    fos.write(99); // 写出第3个字节
    // 关闭资源
    fos.close();
}
```

**注意**：

1. 虽然参数为int类型四个字节，但是只会保留一个字节的信息写出。
2. 写出的整数被直接写在目的文件中。
3. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。

- **写出字节数组**：`write(byte[] b)`，每次可以写出数组中的数据，代码使用演示：

```java
public static void main(String[] args) throws IOException {
    // 使用文件名称创建流对象
    FileOutputStream fos = new FileOutputStream("fos.txt");     
    // 字符串转换为字节数组
    byte[] b = "abcdef".getBytes();
    // 写出字节数组数据
    fos.write(b);
    // 关闭资源
    fos.close();
}
```

- **写出指定长度字节数组**：`write(byte[] b, int off, int len)` ,每次写出从off索引开始，len表示写出的个字节个数。

```java
public static void main(String[] args) throws IOException {
    // 使用文件名称创建流对象
    FileOutputStream fos = new FileOutputStream("fos.txt");     
    // 字符串转换为字节数组
    byte[] b = "abcde".getBytes();
    // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
    fos.write(b,2,2);
    // 关闭资源
    fos.close();
}
```

### 数据追加续写

经过以上的演示，每次程序运行，创建输出流对象，都会清空目标文件中的数据。如何保留目标文件中数据，还能继续添加新数据呢？

- `public FileOutputStream(File file, boolean append)`： 创建文件输出流以写入由指定的 File对象表示的文件。  
- `public FileOutputStream(String name, boolean append)`： 创建文件输出流以指定的名称写入文件。  

这两个构造方法，参数中都需要传入一个boolean类型的值，`true` 表示追加数据，`false` 表示清空原有数据。这样创建的输出流对象，就可以指定是否追加续写了，代码使用演示：

```java
 public static void main(String[] args) throws IOException {
     // 使用文件名称创建流对象
     FileOutputStream fos = new FileOutputStream("fos.txt"，true);     
     // 字符串转换为字节数组
     byte[] b = "abcde".getBytes();
     // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
     fos.write(b); 
     // 关闭资源
     fos.close();
 }
```

## 4.4 IO中write方法的源码解析

- 我调用write方法写出数据的时候，JDK源代码中最终调用的方法是writeBytes()方法。
- `private native void writeBytes(byte b[], int off, int len, boolean append)throws IOException`
  - 方法是本地方法是和操作系统交互的方法。
  - 操作系统本身就具有IO功能，因此JVM是调用操作系统中的功能实现数据的读写！

## 4.5 字节输入流InputStream

`java.io.InputStream `抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入流的基本共性功能方法。

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。    
- `public abstract int read()`： 从输入流读取数据的下一个字节。 
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

## 4.6 FileInputStream类

`java.io.FileInputStream `类是文件输入流，从文件中读取字节。

### 构造方法

- `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 
- `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出`FileNotFoundException` 

```java
public class FileInputStreamConstructor {
    public static void main(String[] args) throws IOException{
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileInputStream fos = new FileInputStream(file);
      
        // 使用文件名称创建流对象
        FileInputStream fos = new FileInputStream("b.txt");
    }
}
```

### 读取字节数据

- **读取字节**：`read`方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回`-1`，代码使用演示：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象
    FileInputStream fis = new FileInputStream("read.txt");
    // 读取数据，返回一个字节
    int read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    // 读取到末尾,返回-1
    read = fis.read();
    System.out.println( read);
    // 关闭资源
    fis.close();
}
```

**注意**：如果文件中存在-1，我们在读取文件时也不会直接读取到-1，因为-1是两个字节，即`-`和`1`。每个文件都会被操作系统赋予一个结束的标识，JVM调用操作系统功能实现文件读取的，因此操作系统读取到文件结束标识后，会将表示返回到JVM中，而JVM接收到文件结束标识后，返回read()方法-1。

使用循环改进：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象
    FileInputStream fis = new FileInputStream("read.txt");
    // 定义变量，保存数据
    int b = 0 ;
    // 循环读取
    while ((b = fis.read())!=-1) {
    	System.out.println((char)b);
    }
    // 关闭资源
    fis.close();
}
```

### 使用字节数组读取

`read(byte[] b)`，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回`-1` ，代码使用演示：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象.
    FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
    // 定义变量，作为有效个数
    int len ；
    // 定义字节数组，作为装字节数据的容器   
    byte[] b = new byte[2];
    // 循环读取
    while (( len= fis.read(b))!=-1) {
    // 每次读取后,把数组变成字符串打印
    	System.out.println(new String(b));
    }
    // 关闭资源
    fis.close();
}
```

错误数据`d`，是由于最后一次读取时，只读取一个字节`e`，数组中，上次读取的数据没有被完全替换，所以要通过`len` ，获取有效的字节，代码使用演示：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象.
    FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
    // 定义变量，作为有效个数
    int len ；
    // 定义字节数组，作为装字节数据的容器   
    byte[] b = new byte[2];
    // 循环读取
    while (( len= fis.read(b))!=-1) {
    // 每次读取后,把数组的有效字节部分，变成字符串打印
    	System.out.println(new String(b，0，len));//  len 每次读取的有效字节个数
    }
    // 关闭资源
    fis.close();
}
```

# 第五章 IO流中的异常处理

在字节流的案例中，我们一直使用的是throws抛出异常。如果出现异常的话，程序将不会执行close()方法，因此异常需要使用try catch进行处理。

- try外声明变量，try内建立对象。
  - 目的是提升变量的作用域。
- finally中进行资源释放。
  - 进行流对象非空判断。
  - 如果有多个流对象，单独进行释放

```java
public static void main(String[] args){
	FileOutputStream fos = null;
    try{
    	fos.write(100);
    }catch(IOException ex){
    	ex.PrintStackTrace();
    }finally{
        if(fos!=null)
            try{
                fos.close();
            }catch(IOException ex){
                ex.PrintStackTrace();
            }
    }
}
```

# 第六章 文件复制

使用字节流可以进行任何文件的复制，因为字节流操作的是组成文件的最小单元-字节。

复制原理图解：

![](img/2_copy.jpg)

**案例实现**

```java
 public static void main(String[] args) throws IOException {
     // 1.创建流对象
     // 1.1 指定数据源
     FileInputStream fis = new FileInputStream("D:\\test.jpg");
     // 1.2 指定目的地
     FileOutputStream fos = new FileOutputStream("test_copy.jpg");

     // 2.读写数据
     // 2.1 定义数组
     byte[] b = new byte[1024];
     // 2.2 定义长度
     int len;
     // 2.3 循环读取
     while ((len = fis.read(b))!=-1) {
         // 2.4 写出数据
         fos.write(b, 0 , len);
     }

     // 3.关闭资源
     fos.close();
     fis.close();
}
```

# 第七章 字节缓冲流

## 7.1 缓冲流介绍

缓冲流：针对基础流对象进行高效处理的流对象。或者为基础流增加功能。

**字节缓冲流**：`BufferedInputStream`，`BufferedOutputStream` 

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

## 7.2 字节缓冲流

BufferedOutputStream继承OutputStream，write()方法不必从新学习。

BufferedInputStream继承InputStream，read()方法不必从新学习。

### 构造方法

- `public BufferedInputStream(InputStream in)` ：创建一个 新的缓冲输入流。 
- `public BufferedOutputStream(OutputStream out)`： 创建一个新的缓冲输出流。

```java
// 创建字节缓冲输入流
BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bis.txt"));
// 创建字节缓冲输出流
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));
```

**注意**：在使用缓冲流时，必须传递基础流。

### 效率测试

查询API，缓冲流读写方法与基本的流是一致的，我们通过复制大文件（375MB），测试它的效率。

- 基础流：

```java
public static void main(String[] args) throws IOException {
    // 记录开始时间
    long start = System.currentTimeMillis();
    // 创建流对象
    
    FileInputStream fis = new FileInputStream("jdk8.exe");
    FileOutputStream fos = new FileOutputStream("copy.exe")
   
    // 读写数据
    int b = 0;
    while ((b = fis.read()) != -1) {
    	fos.write(b);
    }
    
    // 记录结束时间
    long end = System.currentTimeMillis();
    System.out.println("普通流复制时间:"+(end - start)+" 毫秒");
}
```

- 缓冲流：

```java
public static void main(String[] args) throws FileNotFoundException {
    // 记录开始时间
    long start = System.currentTimeMillis();
    // 创建流对象
  
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("jdk8.exe"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.exe"));
    // 读写数据
    int len = 0;
    byte[] bytes = new byte[8*1024];
    while ((len = bis.read(bytes)) != -1) {
    	bos.write(bytes, 0 , len);
    }
   
    // 记录结束时间
    long end = System.currentTimeMillis();
    System.out.println("缓冲流使用数组复制时间:"+(end - start)+" 毫秒");
}
缓冲流复制时间:8016 毫秒
```

- 缓冲流+数组方式：

```java
public static void main(String[] args) throws FileNotFoundException {
    // 记录开始时间
    long start = System.currentTimeMillis();
    // 创建流对象
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("jdk8.exe"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.exe"));
    
    // 读写数据
    int len = 0;
    byte[] bytes = new byte[8*1024];
    while ((len = bis.read(bytes)) != -1) {
    	bos.write(bytes, 0 , len);
    }
    
    // 记录结束时间
    long end = System.currentTimeMillis();
    System.out.println("缓冲流使用数组复制时间:"+(end - start)+" 毫秒");
}
缓冲流使用数组复制时间:666 毫秒
```

