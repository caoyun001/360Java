package com.itheima.list;
import java.util.ArrayList;

/**
 * ArrayList集合
 *   内部是数组: Object[] elementData;
 *   集合中添加的任意元素,都会存储在数组中
 *
 *   new ArrayList() 创建默认长度是10的空列表 (数组长度是10)
 *   new ArrayList(int initialCapacity)创建集合,指定长度
 *
 *   创建对象使用无参数的构造方法
 *      this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
 *      存储元素的数组  = 空数组 (内存地址有的,长度是0)
 *      创建了长度为10的空集合
 *      第一次存储元素的时候 arrayList.add("")数组加大到10个
 *
 *      DEFAULT_CAPACITY = 10 默认的容量大小
 *      //检查数组的容量 ,传递的参数是1
 *     private void ensureCapacityInternal(int minCapacity) {
 *                                      //计算容量,传递参数是数组,1
                ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
                ensureExplicitCapacity(10);
        }
                                             //计算容量,传递参数是数组,1
 private static int calculateCapacity(Object[] elementData, int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        //返回最大值, 10, 1
        return Math.max(DEFAULT_CAPACITY, minCapacity);// return 10
    }
         return minCapacity;
 }

 private void ensureExplicitCapacity(10) {
    if (10 - elementData.length > 0)
            //扩容,传递参数10
            grow(10);
 }

 private void grow(int 10) {
     // overflow-conscious code
     int oldCapacity = elementData.length; 0
     int newCapacity = oldCapacity + (oldCapacity >> 1); 0
          0         -  10 < 0
     if (newCapacity - minCapacity < 0)
    新容量= 10
     newCapacity = minCapacity;
     if (newCapacity - MAX_ARRAY_SIZE > 0)
     newCapacity = hugeCapacity(minCapacity);
     // minCapacity is usually close to size, so this is a win:
     //数组的赋值  Arrays工具类的方法,传递数组,容量10
     elementData = Arrays.copyOf(elementData, newCapacity);
 }
 */
/**
 *    传递指定容量,直接创建数组,效率高一些
 *     new ArrayList(10);
 *        this.elementData = new Object[initialCapacity];
 */

/**
 *  存储第11个元素
 *  数组扩容的计算是   原始长度+ 原始长度/2
 */

public class ArrayListDemo02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("1");
    }
}
