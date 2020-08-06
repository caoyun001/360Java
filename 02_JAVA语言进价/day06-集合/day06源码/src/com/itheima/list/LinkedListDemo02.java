package com.itheima.list;

import java.util.LinkedList;

/**
 * LinkedList集合,定义成员变量
 *   Node: 节点  Node类是LinkedList的内部类
 *   private static class Node<E> {
         E item; 链表要存储的对象
         Node<E> next; 这个元素的下一个元素内存地址
         Node<E> prev; 这个元素的上一个元素内存地址

         this.item = "1";
         this.next = null;
         this.prev = null;
   }
      LinkedList集合在内存中,是双向链表

         集合中存储字符串 "1"
         void linkLast("1") {
         final Node<E> l = last;   l =  null
         final Node<E> newNode = new Node<>(null, "1", null);
         last = newNode;
         if (l == null)
         first = newNode;
         else
         l.next = newNode;
         size++;
         modCount++;
         }
 */

/**
 *      if (index < (size >> 1)) {
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
 *
 *
 */
public class LinkedListDemo02 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        System.out.println(linkedList.get(0));
    }
}
