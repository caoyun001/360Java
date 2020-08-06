package com.itheima.utils;

import com.itheima.service.UserService;

import java.util.ResourceBundle;

public class BeanFactory {
    /**
     * 读取配置文件，创建实现类对象返回
     * 方法： 传递接口，根据接口名读取键值对
     * 创建出接口实现类对象
     *
     * 参数是一个接口的class对象
     *
     * UserService=com.itheima.service.impl.UserServiceImpl
     *
     * Class类方法： getSimpleName()获取class对象的简单名字
     *
     * UserService
     */
    public static <T> T getInstance(Class<T> clazz){
        T obj = null;
        try {
            //获取到接口名
            String simpleName = clazz.getSimpleName();
            //System.out.println(simpleName);

            ResourceBundle bundle = ResourceBundle.getBundle("bean");
            //接口名作为键
            String className = bundle.getString(simpleName);
            //反射创建对象
            obj =(T)  Class.forName(className).newInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  obj;
    }
}
