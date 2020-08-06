package com.itheima.factory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    用于创建对象的 Bean 工厂类

    解析Bean.xml文件, 把文件里面的 Bean标签的id,与class 对应关系 存到 Map集合中, 用于 后面的对象获取
 */
public class BeanFactory {

    //定义一个 用于存id,与class 对应关系 存到 Map集合
    private static Map<String, Object> map = new HashMap<>();

    //进行Beans.xml文件解析
    static {
        try {
            //1, 加载Beans.xml文件
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
            //2. 使用DOM4j技术 进行配置文件的解析(把每个Bean标签的 id, class所对应的object 存到到map集合中)
            Element beansElement = document.getRootElement();
            //获取所有的子标签 Bean
            List<Element> beanList = beansElement.elements();
            //遍历获取到每一个bean标签
            for (Element bean : beanList) {
                //获取id
                String idValue = bean.attributeValue("id");
                //获取class
                String classValue = bean.attributeValue("class");
                //把每个Bean标签的 id, class所对应的object 存到到map集合中
                //通过反射技术, 加载ClassValue值, 得到Object对象
                Object obj = Class.forName(classValue).newInstance();
                //存到到map集合中
                map.put(idValue, obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //提供一个方法, 用于从Map集合中, 获取指定id( 接口字符串) 所对应的value( 接口实现类对象 )
    public static Object getBean(String id){
       return map.get(id);
    }
}
