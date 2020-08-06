# day06【集合】

## 今日内容

- 对象数组
- Collection接口
- 迭代器
- 数据结构
- List接口
- 斗地主案例

## 教学目标

- [ ] 能够说出集合与数组的区别
- [ ] 能够使用Collection集合的常用功能
- [ ] 能够使用迭代器对集合进行取元素
- [ ] 能够使用集合存储自定义类型
- [ ] 能够说出List集合特点
- [ ] 能够说出常见的数据结构
- [ ] 能够说出数组结构特点
- [ ] 能够说出栈结构特点
- [ ] 能够说出队列结构特点
- [ ] 能够说出单向链表结构特点

# 第一章 对象数组

数组是容器，即可以存储基本数据类型也可以存储引用数据类，存储了引用数据类型的数组称为对象数组，例如：String[]，Person[]，Student[]。

```java
public static void main(String[] args){
    //创建存储Person对象的数组
    Person[] persons = {
        new Person("张三",20),
        new Person("李四",21),
        new Person("王五",22),
    };
    //遍历数组
    for(int i = 0 ; i < persons.length; i++){
    	Person person = persons[i];
    	System.out.println(person.getName()+"::"+person.getAge());
    }
}
```

- 数组的弊端
  - 数组长度是固定的，一旦创建不可修改。
  - 需要添加元素，只能创建新的数组，将原数组中的元素进行复制。
- 为了解决数组的定长问题，Java语言从JDK1.2开始出现集合框架。

# 第二章 Collection集合

## 2.1 概述

在前面基础班我们已经学习过并使用过集合ArrayList<E> ,那么集合到底是什么呢?

- **集合**：集合是java中提供的一种容器，可以用来存储多个数据。

集合和数组既然都是容器，它们有什么区别呢？

- 数组的长度是固定的。集合的长度是可变的。
- 数组中存储的是同一类型的元素，可以存储任意类型数据。集合存储的都是引用数据类型。如果想存储基本类型数据需要存储对应的包装类型。

## 2.2 集合类的继承体系

Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是`java.util.List`和`java.util.Set`。其中，`List`的特点是元素有序、元素可重复。`Set`的特点是元素不可重复。`List`接口的主要实现类有`java.util.ArrayList`和`java.util.LinkedList`，`Set`接口的主要实现类有`java.util.HashSet`和`java.util.LinkedHashSet`。

![](img/集合继承图-2.jpg)

注意:这张图只是我们常用的集合有这些，不是说就只有这些集合。

集合本身是一个工具，它存放在java.util包中。在`Collection`接口定义着单列集合框架中最最共性的内容。

## 2.3 Collection接口方法

Collection是所有单列集合的父接口，因此在Collection中定义了单列集合(List和Set)通用的一些方法，这些方法可用于操作所有的单列集合。方法如下：

- `public boolean add(E e)`：  把给定的对象添加到当前集合中 。
- `public boolean addAll(Collection<? extends E>)`将另一个集合元素添加到当前集合中。
- `public void clear()` :清空集合中所有的元素。
- `public boolean remove(E e)`: 把给定的对象在当前集合中删除。
- `public boolean contains(Object obj)`: 判断当前集合中是否包含给定的对象。
- `public boolean isEmpty()`: 判断当前集合是否为空。
- `public int size()`: 返回集合中元素的个数。
- `public Object[] toArray()`: 把集合中的元素，存储到数组中。

# 第三章 迭代器

## 3.1 Iterator接口

在程序开发中，经常需要遍历集合中的所有元素。针对这种需求，JDK专门提供了一个接口`java.util.Iterator`。

想要遍历Collection集合，那么就要获取该集合迭代器完成迭代操作，下面介绍一下获取迭代器的方法：

- `public Iterator iterator()`: 获取集合对应的迭代器，用来遍历集合中的元素的。

下面介绍一下迭代的概念：

- **迭代**：即Collection集合元素的通用获取方式。在取元素之前先要判断集合中有没有元素，如果有，就把这个元素取出来，继续在判断，如果还有就再取出出来。一直把集合中的所有元素全部取出。这种取出方式专业术语称为迭代。

Iterator接口的常用方法如下：

- `public E next()`:返回迭代的下一个元素。
- `public boolean hasNext()`:如果仍有元素可以迭代，则返回 true。

接下来我们通过案例学习如何使用Iterator迭代集合中元素：

```java
public static void main(String[] args) {
    // 使用多态方式 创建对象
    Collection<String> coll = new ArrayList<String>();
    // 添加元素到集合
    coll.add("串串星人");
    coll.add("吐槽星人");
    coll.add("汪星人");
    //遍历
    //使用迭代器 遍历   每个集合对象都有自己的迭代器
    Iterator<String> it = coll.iterator();
    //  泛型指的是 迭代出 元素的数据类型
    while(it.hasNext()){ //判断是否有迭代元素
    	String s = it.next();//获取迭代出的元素
    	System.out.println(s);
    }
}
```

## 3.2 迭代器的实现原理

我们在之前案例已经完成了Iterator遍历集合的整个过程。当遍历集合时，首先通过调用t集合的iterator()方法获得迭代器对象，然后使用hashNext()方法判断集合中是否存在下一个元素，如果存在，则调用next()方法将元素取出，否则说明已到达了集合末尾，停止遍历元素。

Iterator迭代器对象在遍历集合时，内部采用指针的方式来跟踪集合中的元素，为了让初学者能更好地理解迭代器的工作原理，接下来通过一个图例来演示Iterator对象迭代元素的过程：

![](img/迭代器原理图.jpg)

在调用Iterator的next方法之前，迭代器的索引位于第一个元素之前，不指向任何元素，当第一次调用迭代器的next方法后，迭代器的索引会向后移动一位，指向第一个元素并将该元素返回，当再次调用next方法时，迭代器的索引会指向第二个元素并将该元素返回，依此类推，直到hasNext方法返回false，表示到达了集合的末尾，终止对元素的遍历。

## 3.3 迭代器源码分析

迭代器是遍历Collection集合的通用方式，任意Collection集合都可以使用迭代器进行遍历，那么每一种集合的自身特性是不同的，也就是存储元素的方式不同，那么是如何做到遍历方式的统一呢，接下来我们分析一下迭代器的源代码。

每个Collection集合都会实现，方法 `Iterator iterator()`，返回Iterator接口实现类，以ArrayList集合为例。

- `java.util.Iterator`接口

```java
public interface Iterator<E> {
	boolean hasNext();
	E next();
}
```

- `java.util.ArrayList`类

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
   /*
	*  ArrayList实现接口Collection
    *  重写方法iterator()
    *  返回Iterator接口实现类 Itr类的对象
	*/
	public Iterator<E> iterator() {
        return new Itr();
    }
    
   /*
    * ArrayList中定义内部类Itr,实现接口Iterator
    * 重写hasNext(),next()方法
    */
    private class Itr implements Iterator<E> {
    	public boolean hasNext() { }
        
        public E next() { }
    }
}
```

- 结论
  - 所有集合的迭代器，全由内部类实现。
  - 集合中定义内部类，实现迭代器接口，可以使所有集合的遍历方式统一。
  - 调用迭代器的方法hasNext()，next()均执行集合中内部类的重写方法。

## 3.2 并发修改异常

在使用迭代器遍历集合中，不能使用集合本身的方法改变集合的长度，一旦被改变将会抛出ConcurrentModificationException并发修改异常。

```java
public static void main(String[] args){
    Collection<String> coll = new ArrayList<String>();
    coll.add("hello1");
    coll.add("hello2");
    coll.add("hello3");
    coll.add("hello4");
    Iterator<String> it = coll.iterator();
    while (it.hasNext()){
      String str = it.next();
      if("hello2".equals(str)){
         coll.add("hello5");
    }
}
```

以上程序，在迭代器遍历过程中，使用了集合add方法修改集合的长度，这个操作是不允许的，被禁止的，程序中会抛出并发修改异常。

**注意**：如果我们使用集合的remove()方法同样会抛出并发修改异常，但是删除倒数第二个元素则不会抛出异常。原因：抛出并发修改异常的方法是迭代器的next()方法，当删除倒数第二个元素后，本次循环结束，再次执行while循环时，此时条件为false，循环停止，没有再执行next()方法，所以没有异常抛出。

# 第四章 数据结构

## 4.1 数据结构介绍

数据结构 : 数据用什么样的方式在内存中存储。

## 4.2 常见数据结构

数据存储的常用结构有：栈、队列、数组、链表和红黑树。我们分别来了解一下：

### 栈

- **栈**：**stack**,又称堆栈，它是运算受限的线性表，其限制是仅允许在标的一端进行插入和删除操作，不允许在其他任何位置进行添加、查找、删除等操作。

简单的说：采用该结构的集合，对元素的存取有如下的特点

- 先进后出（即，存进去的元素，要在后它后面的元素依次取出后，才能取出该元素）。例如，子弹压进弹夹，先压进去的子弹在下面，后压进去的子弹在上面，当开枪时，先弹出上面的子弹，然后才能弹出下面的子弹。
- 栈的入口、出口的都是栈的顶端位置。

![](img/堆栈.png)

这里两个名词需要注意：

- **压栈**：就是存元素。即，把元素存储到栈的顶端位置，栈中已有元素依次向栈底方向移动一个位置。
- **弹栈**：就是取元素。即，把栈的顶端位置元素取出，栈中已有元素依次向栈顶方向移动一个位置。

### 队列

- **队列**：**queue**,简称队，它同堆栈一样，也是一种运算受限的线性表，其限制是仅允许在表的一端进行插入，而在表的另一端进行删除。

简单的说，采用该结构的集合，对元素的存取有如下的特点：

- 先进先出（即，存进去的元素，要在后它前面的元素依次取出后，才能取出该元素）。例如，小火车过山洞，车头先进去，车尾后进去；车头先出来，车尾后出来。
- 队列的入口、出口各占一侧。例如，下图中的左侧为入口，右侧为出口。

![](img/队列.png)

### 数组

- **数组**:**Array**,是有序的元素序列，数组是在内存中开辟一段连续的空间，并在此空间存放元素。就像是一排出租屋，有100个房间，从001到100每个房间都有固定编号，通过编号就可以快速找到租房子的人。

简单的说,采用该结构的集合，对元素的存取有如下的特点：

- 查找元素快：通过索引，可以快速访问指定位置的元素。
- 增删元素慢
  - **指定索引位置增加元素**：需要创建一个新数组，将指定新元素存储在指定索引位置，再把原数组元素根据索引，复制到新数组对应索引的位置。

![](img/数组.png)

### 链表

- **链表**:**linked list**,由一系列结点node（链表中每一个元素称为结点）组成，结点可以在运行时i动态生成。每个结点包括两个部分：一个是存储数据元素的数据域，另一个是存储下一个结点地址的指针域。我们常说的链表结构有单向链表与双向链表，那么这里给大家介绍的是**单向链表**。

简单的说，采用该结构的集合，对元素的存取有如下的特点：

- 多个结点之间，通过地址进行连接。例如，多个人手拉手，每个人使用自己的右手拉住下个人的左手，依次类推，这样多个人就连在一起了。
- 查找元素慢：想查找某个元素，需要通过连接的节点，依次向后查找指定元素
- 增删元素快：

![](img/链表.png)



# 第四章 List集合

`java.util.List`接口，继承Collection接口，有序的 collection（也称为*序列*）。此接口的用户可以对列表中每个元素的插入位置进行精确地控制。用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。与Set接口不同，List接口通常允许重复元素。

## 4.1 List接口特点

- List集合是有序的集合，存储和取出的顺序一致。
- List集合允许存储重复的元素。
- List集合中的每个元素具有索引。

**提示：**集合类名后缀是List，例如ArrayList，LinkedList等，都是List接口实现类，都具有List接口的特点。

## 4.2 List接口特有方法（带有索引）

- `public void add(int index,E element)`在列表的指定位置上插入元素。
- `public E get(int index)` 返回列表中指定位置的元素。
- `public E set(int index,E element)` 用指定元素替换列表中指定位置的元素，并返回替换前的元素。
- `public E remove(int index)` 移除列表中指定位置的元素，并返回被移除之前的元素。

# 第五章 ArrayList集合

## 5. 1 概述

`java.util.ArrayList`集合数据存储的结构是数组结构。元素增删慢，查找快，线程不安全，运行速度快。由于日常开发中使用最多的功能为查询数据、遍历数据，所以`ArrayList`是最常用的集合。

许多程序员开发时非常随意地使用ArrayList完成任何需求，并不严谨，这种用法是不提倡的。

## 5.2 ArrayList源代码分析

- 底层是Object对象数组，数组存储的数据类型是Object，数组名字为elementData。

```java
transient Object[] elementData;
```

### 创建ArrayList对象分析：无参数

- 初始化ArrayList对象，创建一个为10的空列表。也可以指定列表长度，构造方法传递长度即可。


```java
new ArrayList(); //默认长度为10
new ArrayList(int initialCapacity); //指定长度
```

- ArrayList无参数构造方法分析：

```java
//定义Object对象类型的空数组，数组在内存中存在，但长度为0
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}; 
public ArrayList() {
	this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
 }
```

**解析**：这里可以看出，当我们new ArrayList()的时候，并没有创建长度为10的数组，而是创建了一个长度为0的数组，当我们使用add()方法添加元素的时候，就会将数组由0长度，扩容为10长度。

- ArrayList添加元素add方法分析：

```java
//ArrayList的成员变量size，默认为0，统计集合中元素的个数
private int size;
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  
    elementData[size++] = e;
    return true;
}
```

**解析**：集合添加元素之前，先调用方法ensureCapacityInternal()增加容量，传递size+1，size默认为0。传递参数0+1的结果。

- ensureCapacityInternal()增加容量方法分析：

```java
private void ensureCapacityInternal(int minCapacity) {
	ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
}
```

**解析**：方法ensureCapacityInternal()接收到参数1，继续调用方法calculateCapacity()计算容量，传递数组和1。

- calculateCapacity()计算容量方法分析：

```java
private static final int DEFAULT_CAPACITY = 10;
private static int calculateCapacity(Object[] elementData, int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
}
```

**解析**：方法中判断elementData是否和DEFAULTCAPACITY_EMPTY_ELEMENTDATA数组相等，在构造方法中：

this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;因此结果为true，方法将会返回参数DEFAULT_CAPACITY（=10）和 minCapacity（=1）中最大的值，return 10;

此时方法calculateCapacity()结束，继续执行() ensureExplicitCapacity()，传递参数10

- ensureExplicitCapacity()保证明确容量方法分析：

```java
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
```

**解析**：方法中进行判断（10-elemetData.length>0）结果为true，10-0>0。调用方法grow()传递10。

- grow()增加容量方法分析：

```java
private void grow(int minCapacity) {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        //**将10赋值给变量newCapacity
    	newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
    	newCapacity = hugeCapacity(minCapacity);
    //**数组复制， Arrays.copyOf底层实现是System.arrayCopy()
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

**解析**：方法grow()接收到参数10，进过计算，执行newCapacity = minCapacity;这行程序，此时变量newCapacity的值为10，然后进行数组复制操作，复制新数组的长度为10，为此ArrayList集合初始化创建过程完毕。

### 创建ArrayList对象分析：带有初始化容量构造方法

- ArrayList有参数构造方法分析：new ArrayList(10)

```java
public ArrayList(int initialCapacity) {
	if (initialCapacity > 0) {
		this.elementData = new Object[initialCapacity];
	} else if (initialCapacity == 0) {
		this.elementData = EMPTY_ELEMENTDATA;
	} else {
		throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
	}
}
```

**解析**：创建ArrayList集合，传递参数10，变量initialCapacity接收到10，直接进行数组的创建：`this.elementData = new Object[initialCapacity]`。如果传递的参数为0，那么结果就和使用无参数构造方法相同，如果传递的参数小于0，抛出IllegalArgumentException无效参数异常。

### add添加元素方法分析

```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
```

**解析**：集合添加元素，调用方法add并传递被添加的元素，首先调用方法ensureCapacityInternal()进行容量的检查，然后将元素添加到elemenetData数组中，size变量是记录存储多少个元素的，默认值为0，添加第一个元素的时候，size为0，添加第一个元素，再++。返回true，List集合允许重复元素。

ensureCapacityInternal()方法最终会执行到grow方法。

```java
private void grow(int minCapacity) {
    //定义变量（老容量），保存数组的长度 = 10
    int oldCapacity = elementData.length;
    //定义变量（新容量） = 老容量+老容量右移1位
    //右移是二进制位计算，相等于除以2,得出新容量=老容量+老容量/2
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
    	newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
    	newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

**解析**：例如当前的集合中的数组长度为10，进行扩容。**得出新容量+老容量=老容量/2**

# 第六章 LinkedList集合

## 6.1 概述

`java.util.LinkedList`集合数据存储的结构是链表结构。方便元素添加、删除的集合。

集合特点：元素增删快，查找慢，线程不安全，运行速度快。

LinkedList是一个双向链表，那么双向链表是什么样子的呢，我们用个图了解下：

![](img/双向链表.png)

## 6.2 LinkedList集合特有方法

实际开发中对一个集合元素的添加与删除经常涉及到首尾操作，而LinkedList提供了大量首尾操作的方法。这些方法我们作为**了解即可**：

- `public void addFirst(E e)`:将指定元素插入此列表的开头。
- `public void addLast(E e)`:将指定元素添加到此列表的结尾。
- `public E getFirst()`:返回此列表的第一个元素。
- `public E getLast()`:返回此列表的最后一个元素。
- `public E removeFirst()`:移除并返回此列表的第一个元素。
- `public E removeLast()`:移除并返回此列表的最后一个元素。
- `public E pop()`:从此列表所表示的堆栈处弹出一个元素。
- `public void push(E e)`:将元素推入此列表所表示的堆栈。
- `public boolean isEmpty()`：如果列表不包含元素，则返回true。

LinkedList是List的子类，List中的方法LinkedList都是可以使用，这里就不做详细介绍，我们只需要了解LinkedList的特有方法即可。在开发时，LinkedList集合也可以作为堆栈，队列的结构使用。

## 6.3 LinkedList源代码分析

### LinkedList成员变量分析：

```java
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable{
	transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
}
```

**解析**：成员变量size是长度，记录了集合中存储元素的个数。first和last分别表示链表开头和结尾的元素，因此链表可以方便的操作开头元素和结尾元素。

### LinkedList内部类Node类分析：

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

	Node(Node<E> prev, E element, Node<E> next) {
		this.item = element;
		this.next = next;
		this.prev = prev;
	}
}
```

**解析**：LinkedList集合中的内部类Node，表示链表中的节点对象，Node类具有3个成员变量:

- item：存储的对象。
- next：下一个节点。
- prev：上一个节点。

从Node类的源代码中可以分析出，LinkedList是双向链表，一个对象，他记录了上一个节点，也记录了下一个节点。

### LinkedList添加元素方法add()分析：

```java
public boolean add(E e) {
	linkLast(e);
	return true;
}
```

```java
void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
    	first = newNode;
    else
    	l.next = newNode;
    size++;
    modCount++;
}
```

**解析**：调用集合方法add()添加元素，本质上调用的是linkLast()方法进行添加。

- `final Node<E> l = last`：当集合中添加第一个元素时last=null。
- `final Node<E> newNode = new Node<>(l, e, null)`：创建Node类内部类对象，传递null（上一个节点），被添加的元素和null（下一个节点）。
- `last = newNode`：将新增的节点newNode,复制给链表中的最后一个节点last。
- `if(l == null)`：第一次添加元素时，结果为true，first=newNode，链表中的第一个节点=新添加的节点。
- `size++` ：记录了集合中元素的个数。
- `modCount++`：记录了集合被操作的次数。

#### LinkedList获取元#素方法get()分析：

```java
public E get(int index) {
	checkElementIndex(index);
	return node(index).item;
}
```

```java
Node<E> node(int index) {
    if (index < (size >> 1)) {
    Node<E> x = first;
    for (int i = 0; i < index; i++)
    	x = x.next;
    	return x;
    } else {
    Node<E> x = last;
    for (int i = size - 1; i > index; i--)
    	x = x.prev;
    return x;
	}
}
```

**解析**：index < (size >> 1)采用二分法，如果要获取元素的索引小于长度的一般，那么就从0开始，找到集合长度的一半，如果要获取的元素的长度大于集合的一半，那么就从最大索引开始，找到集合长度的一半。

**结论**：链表本身并没有索引，当我们通过索引获取的时候，内部采用了循环到集合长度的方式依次查找的。

## 第七章：集合模拟斗地主案例

## 7.1 案例介绍

按照斗地主的规则，完成洗牌发牌的动作。
具体规则：

使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。

## 7.2 案例分析

- 准备牌：

  牌可以设计为一个ArrayList<String>,每个字符串为一张牌。
  每张牌由花色数字两部分组成，我们可以使用花色集合与数字集合嵌套迭代完成每张牌的组装。
  牌由Collections类的shuffle方法进行随机排序。

- 发牌

  将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。

- 看牌

  直接打印每个集合。

## 7.3 代码实现

```java
public class Poker {
    public static void main(String[] args) {
        /*
        * 1: 准备牌操作
        */
        //1.1 创建牌盒 将来存储牌面的 
        ArrayList<String> pokerBox = new ArrayList<String>();
        //1.2 创建花色集合
        ArrayList<String> colors = new ArrayList<String>();

        //1.3 创建数字集合
        ArrayList<String> numbers = new ArrayList<String>();

        //1.4 分别给花色 以及 数字集合添加元素
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");

        for(int i = 2;i<=10;i++){
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        //1.5 创造牌  拼接牌操作
        // 拿出每一个花色  然后跟每一个数字 进行结合  存储到牌盒中
        for (int i =0 ; i<colors.size() : i++) {
            //color每一个花色 guilian
            //遍历数字集合
            for(int j = 0; j <numbers.size() : j++){
                //结合
                String card = colors.get(i)+numbers.get(j);
                //存储到牌盒中
                pokerBox.add(card);
            }
        }
        //1.6大王小王
        pokerBox.add("小☺");
        pokerBox.add("大☠");	  
        // System.out.println(pokerBox);
        //洗牌 是不是就是将  牌盒中 牌的索引打乱 
        // Collections类  工具类  都是 静态方法
        // shuffer方法   
        /*
         * static void shuffle(List<?> list) 
         *     使用默认随机源对指定列表进行置换。 
         */
        //2:洗牌
        Collections.shuffle(pokerBox);
        //3 发牌
        //3.1 创建 三个 玩家集合  创建一个底牌集合
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> dipai = new ArrayList<String>();	  

        //遍历 牌盒  必须知道索引   
        for(int i = 0;i<pokerBox.size();i++){
            //获取 牌面
            String card = pokerBox.get(i);
            //留出三张底牌 存到 底牌集合中
            if(i>=51){//存到底牌集合中
                dipai.add(card);
            } else {
                //玩家1   %3  ==0
                if(i%3==0){
                  	player1.add(card);
                }else if(i%3==1){//玩家2
                  	player2.add(card);
                }else{//玩家3
                  	player3.add(card);
                }
            }
        }
        //看看
        System.out.println("令狐冲："+player1);
        System.out.println("田伯光："+player2);
        System.out.println("绿竹翁："+player3);
        System.out.println("底牌："+dipai);  
	}
}
```

