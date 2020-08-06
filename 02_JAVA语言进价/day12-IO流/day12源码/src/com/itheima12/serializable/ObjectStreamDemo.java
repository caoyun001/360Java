package com.itheima.serializable;

import java.io.*;

/**
 *  对象的序列化和对象的反序列化
 *  java.io.ObjectOutputStream 写对象 序列化流
 *  java.io.ObjectInputStream  读对象 反序列化流
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException ,ClassNotFoundException{
//        write();
        read();

      /*  Person person = new Person("a",5);
        System.out.println(person);*/
    }

    /**
     * 对象的反序列化,从硬盘中读取对象
     * ObjectInputStream
     * 构造方法,传递字节输入流(绑定文件,必须是序列化文件)
     *     Object readObject()
     *
     *   读取对象的方法 readObject()抛出异常,抛出的是ClassNotFoundException
     *   反序列化,必须有class文件支持
     */
    public static void read()throws IOException,ClassNotFoundException{
        //创建反序列化流,构造方法传递字节输入流
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream("day12/person.txt"));
        //读取对象
        Object object =  ois.readObject();
        System.out.println(object);
    }

    /**
     * 对象的序列化,对象写入到硬盘中存储
     * ObjectOutputStream
     * 构造方法,传递字节输出流(绑定文件)
     *    void writeObject(Object obj)
     */
    public static void write()throws IOException{
        //创建序列化流,构造方法传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("day12/person.txt"));
        Person person = new Person("张三",20);
        //写入对象
        oos.writeObject(person);

        oos.close();
    }
}
