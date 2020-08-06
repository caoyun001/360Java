package com.itheima.dom;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *  使用DOM思想,读取xml文件
 *  介绍dom4j 核心类
 *  1: SAXReader  DOM解析思想的核心类
 *      方法: read(绑定了这个xml文件的输入流) 读取xml文件
 *      返回文档对象,返回值是Document对象
 *
 *  2: Document对象
 *    方法: getRootElement()获取文档的根标签
 *    返回值,返回的是标签对象 Element
 *
 *  3:Element标签对象
 *    方法获取子标签  List<Element>  elements()
 *    返回所有的子标签集合List
 *
 *    方法 String attributeValue(String 属性名) 获取属性值
 *    方法 String getText() 获取到的是,标签体的文本部分
 */
public class DOMReaderXml {
    public static void main(String[] args) throws Exception{
        //使用类加载器,获取输入流,绑定xml文件
        InputStream inputStream =
                DOMReaderXml.class.getClassLoader().getResourceAsStream("beans.xml");

        //核心类,对象
        SAXReader saxReader = new SAXReader();
        //对象sax的方法read()传递字节输入流
        Document document = saxReader.read(inputStream);
        //document对象的方法,获取根标签
        Element rootElement = document.getRootElement();
        //获取根标签的2个子标签bean
        List<Element> beanElements = rootElement.elements();
        //先对集合进行判断,然后遍历
        //集合不能是null,集合的长度>0
        if(beanElements != null && beanElements.size() > 0){
            for(Element beanElement : beanElements){
                //beanElement就是获取的子标签bean
                //获取Bean标签的属性id和className
                String id = beanElement.attributeValue("id");
                String className = beanElement.attributeValue("className");
                System.out.println(id+"::"+className);
                //bean标签下,还有2个子标签property
                //beanElement bean标签对象,获取他的子标签
                List<Element> propertyElements = beanElement.elements();
                //集合不能是null,集合的长度>0
                if(propertyElements != null && propertyElements.size() > 0){
                    for(Element propertyElement : propertyElements){
                        //propertyElement就是获取的bean的子标签property
                        //property标签的属性name和value
                        String name = propertyElement.attributeValue("name");
                        String value = propertyElement.attributeValue("value");
                        //property标签的文本
                        String text = propertyElement.getText();
                        System.out.println(name+"::"+value+"::"+text);
                    }
                }
            }
        }
    }
}








