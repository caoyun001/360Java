package com.itheima.dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 *  xpath表达式,快速精准定位xml
 *  不能单独使用,依靠dom4j (Document)
 *
 *  表达式:
 *    /AAA/DDD/BBB： 表示一层一层的，AAA下面 DDD下面的BBB
 *    //BBB： 表示和这个名称相同，表示只要名称是BBB 都得到
 *    //BBB[@id]： 表示只要BBB元素上面有id属性 都得到
 *    //BBB[@id='b1'] 表示元素名称是BBB,在BBB上面有id属性，并且id的属性值是b1
 *
 *
 *    xpath的方法支持
 *      Element对象的方法:
 *        List<Node> selectNodes(//BBB)找文档中的所有BBB标签元素
 *        Node selectSingleNode(//BBB)找文档中的第一个BBB标签元素
 *
 */
public class XPathReadXml {
    public static void main(String[] args) throws Exception {
        //类的加载器,获取字节输入流
        InputStream inputStream =
                XPathReadXml.class.getClassLoader().getResourceAsStream("student.xml");
        //DOM4J核心对象
        SAXReader saxReader = new SAXReader();
        //read()方法传递字节输入流,返回Document对象
        Document document = saxReader.read(inputStream);
        //获取根标签
        Element rootElement = document.getRootElement();
        //获取age标签,student/age
        /*List<Node> list = rootElement.selectNodes("/students/student/age");
        System.out.println(list);*/

        //获取标签sex,xpath最常用的一个形式 //sex
        //返回的是Node节点对象
        Element node = (Element) rootElement.selectSingleNode("//sex");
        System.out.println(node.getText());


        //获取标签是name,属性是id,有这个属性就行
        //List<Node> list = rootElement.selectNodes("//name[@id]");

        //获取标签是name,属性是id,属性值必须是itheima
        List<Node> list = rootElement.selectNodes("//name[@id='itheima']");
        System.out.println(list.size());

    }
}
