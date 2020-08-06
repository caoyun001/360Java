package com.itheima.di;

import com.itheima.domain.Person;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

/**
 *  <person className="com.itheima.domain.Person">
         <property name="name">张三</property>
         <property name="address">北京市</property>
    </person>

   要求: DOM4j,读取xml文件
   className的属性值 com.itheima.domain.Person 反射创建该类的对象
   读取到name="name"  张三  反射调用 setName()方法存储张三
   读取到 name="address" 反射调用setAddress()存储北京市

 Person person = new Person();
 person.setName("张三");
 person.setAddress("北京市");
 System.out.println(person);
 */
public class DiDemo {
    public static void main(String[] args) throws Exception{
        InputStream inputStream = DiDemo.class.getClassLoader().getResourceAsStream("person.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        //获取根标签
        Element rootElement = document.getRootElement();
        //获取子标签person
        List<Element> personElements = rootElement.elements();
        if(personElements != null && personElements.size() > 0){
            for(Element personElement : personElements){
               //personElement person标签对象
                //获取person标签的属性 className的值
                String className = personElement.attributeValue("className");
                //反射,将类加入内存
                Class c = Class.forName(className);
                //创建类对象
                Object object = c.newInstance();
                //获取person标签的子标签 property
                List<Element> propertyElements = personElement.elements();
                if(propertyElements != null && propertyElements.size() > 0) {
                    for(Element propertyElement : propertyElements){
                        //propertyElement每个子标签property
                        //取出property标签的属性name和他的标签体文本
                        String name = propertyElement.attributeValue("name");//name
                        String text = propertyElement.getText();//张三
                        //反射获取该成员变量的set方法,进行赋值
                        //name setName    address=setAddress
                        String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                        Method method = c.getMethod(methodName,String.class);
                        method.invoke(object,text);
                    }
                }
                System.out.println(object);
            }
        }
    }
}
