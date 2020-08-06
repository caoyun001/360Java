package com.itheima.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/jackson")
public class JackSonServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 转换工具 jackson,Java对象和json字符串的转换
         */
        test6();
    }
    /**
     * json数据转成Map集合
     */
    public void test6() throws IOException {
        String json = "{\"s3\":{\"name\":\"赵丽颖3\",\"age\":353},\"s1\":{\"name\":\"赵丽颖1\",\"age\":351},\"s2\":{\"name\":\"赵丽颖2\",\"age\":352}}";
        HashMap<String,Student> map = mapper.readValue(json,new TypeReference<HashMap<String,Student>>(){});
        System.out.println(map);
    }

    /**
     * json数据转成对象List集合
     */
    public void test5() throws IOException {
        String json = "[{\"name\":\"赵丽颖1\",\"age\":351},{\"name\":\"赵丽颖2\",\"age\":352},{\"name\":\"赵丽颖3\",\"age\":353}]";
        //TypeReference 带泛型
        List<Student> list =  mapper.readValue(json,new TypeReference<List<Student>>(){});
        for(Student s: list){
            System.out.println(s);
        }
    }

    /**
     * json数据转成对象 pojo
     */
    public void test4() throws IOException {
        String json = "{\"name\":\"赵丽颖\",\"age\":35}";
        //mapper对象的方法readValue() json数据转回对象
       Student student =  mapper.readValue(json,Student.class);
        System.out.println(student);
    }

    /**
     * Map集合转成json
     */
    public void test3() throws JsonProcessingException {
        Student s1 = new Student("赵丽颖1",351);
        Student s2 = new Student("赵丽颖2",352);
        Student s3 = new Student("赵丽颖3",353);

        Map<String,Student> map = new HashMap<String, Student>();
        map.put("s1",s1);
        map.put("s2",s2);
        map.put("s3",s3);

        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    /**
     *  list集合转成json
     */
    public void test2() throws JsonProcessingException {
        Student s1 = new Student("赵丽颖1",351);
        Student s2 = new Student("赵丽颖2",352);
        Student s3 = new Student("赵丽颖3",353);

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        String json =  mapper.writeValueAsString(list);
        System.out.println(json);
    }

    /*
    *   pojo对象转成json
    * */
    public void test1() throws JsonProcessingException {
        Student s = new Student("赵丽颖",35);
        //ObjectMapper()对象方法 writeValueAsString()对象转成json
        String json = mapper.writeValueAsString(s);
        System.out.println(json);
    }

}
