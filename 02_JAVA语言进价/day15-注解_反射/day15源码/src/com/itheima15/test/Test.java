package com.itheima.test;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射案例:
 *   利用反射技术,创建对象,运行对象的方法
 *   配置文件,写的是类的名字和方法名字
 *   IO读取文件,获取类和方法名, 反射调用
 *
 *  实现步骤:
 *    1: 创建配置文件
 *       本质就是文本,记事本,写键值对
 *       A: 后缀名properties
 *       B: 文件放在哪里?存储在src目录下,切记
 *
 *         项目开发完毕,交给用户使用,是编译后的class文件
 *         src 源代码,编译后产生class文件, 是同步的
 *
 *         如何读取src目录下的文件
 *         使用类的加载器
 *         ClassLoader类定义方法
 *           InputStream getResourceAsStream("文件名")返回字节输入流
 *           此流会自动从类目录下扫描问文件读取
 *
 *    2: IO读取配置文件
 *       读取文件中的键值对
 *    3: 键值存储在集合 Properties
 *
 *    4: 集合中取出键值对
 *      拿到类名,和方法名
 *
 *    5: 反射调用
 */
public class Test {
    public static void main(String[] args)throws Exception {
        //Test的类加载器,必须先获取到这个类的class文件对象
        ClassLoader loader = Test.class.getClassLoader();
        //加载器获取字节输入流
        InputStream inputStream = loader.getResourceAsStream("config.properties");
        //System.out.println(inputStream);
        //流对象和集合关联使用
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
       // System.out.println(properties);
        //集合方法,获取值
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //反射,获取这个类的class文件对象
        Class c =  Class.forName(className);
        //创建对象
        Object object = c.newInstance();
        //获取方法
        Method method = c.getMethod(methodName);
       //运行方法
        method.invoke(object);
    }
}
