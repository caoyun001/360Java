package com.chongba.schedule;

import com.alibaba.fastjson.JSON;
import com.chongba.entity.Task;

import java.util.Date;

/**
 * Created by 传智播客*黑马程序员.
 */
public class TaskToJson {

    public static void main(String[] args) {
        Task task = new Task();
        task.setTaskType(1001);
        task.setPriority(1);
        task.setExecuteTime(new Date().getTime());
        System.out.println(JSON.toJSONString(task));
    }
}
