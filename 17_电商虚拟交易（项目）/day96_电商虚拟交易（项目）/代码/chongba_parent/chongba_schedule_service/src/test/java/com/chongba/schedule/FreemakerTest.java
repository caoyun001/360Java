package com.chongba.schedule;

import com.chongba.entity.Task;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by 传智播客*黑马程序员.
 */
public class FreemakerTest {

    public static void main(String[] args) throws IOException, TemplateException {
//        - 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
//        - 第二步：设置模板文件所在的路径。
        configuration.setClassForTemplateLoading(FreemakerTest.class,"/ftl");
//        - 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        configuration.setNumberFormat("#");
//        - 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("test.ftl");
//        - 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map<String,Object> map  = new HashMap<>();
        map.put("name","张三");
        map.put("message","欢迎来到充吧，使劲儿充吧!");
        map.put("likeyou",false);
        map.put("today",new Date());
        List<Task> taskList = new ArrayList<>();
        for(int i=0;i<4;i++){
            Task task = new Task();
            task.setExecuteTime(new Date().getTime());
            task.setTaskType(1001);
            task.setPriority(i);
            taskList.add(task);
        }
        map.put("taskList",taskList);
        
//        - 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer writer = new FileWriter(new File("D:/test.html"));
//        - 第七步：调用模板对象的process方法输出文件。
        template.process(map,writer);
//        - 第八步：关闭流。
        writer.close();
    }
}
