package com.chongba.schedule.controller;

import com.chongba.entity.ResponseMessage;
import com.chongba.entity.Task;
import com.chongba.exception.ScheduleSystemException;
import com.chongba.exception.TaskNotExistException;
import com.chongba.schedule.conf.SystemParams;
import com.chongba.schedule.inf.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 传智播客*黑马程序员.
 */
/*@Controller
@ResponseBody*/
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    
    @PostMapping("/push")
    // @RequestMapping(value = "/push",method = RequestMethod.POST)
    public ResponseMessage pushTask(@RequestBody Task task){
        log.info("add task,task={}",task);
        //参数校验
        try {
            Assert.notNull(task.getTaskType(),"任务类型不能为空");
            Assert.notNull(task.getPriority(),"任务优先级不能为空");
            Assert.notNull(task.getExecuteTime(),"任务执行时间不能为空");
            long taskId = taskService.addTask(task);
            return ResponseMessage.ok(taskId);
        } catch (ScheduleSystemException e) {
            log.error("add task exception,task={}",task);
            return ResponseMessage.error(e.getMessage());
        }
    }
    
    @GetMapping("/poll/{taskType}/{priority}")
    public ResponseMessage pollTask(@PathVariable("taskType") Integer type,@PathVariable("priority") Integer priority){
        log.info("poll task,taskType={},priority={}",type,priority);
        //参数校验
        try {
            Assert.notNull(type,"任务类型不能为空");
            Assert.notNull(priority,"任务优先级不能为空");
            Task task = taskService.poll(type, priority);
            return ResponseMessage.ok(task);
        } catch (TaskNotExistException e) {
            log.error("poll task exception,type={},priority={}",type,priority);
            return ResponseMessage.error(e.getMessage());
        }
    }
    
    @PostMapping("/cancel")
    public ResponseMessage cancelTask(@RequestParam("taskId") Long taskId){
        log.info("cancel task ,taskId={}",taskId);
        try {
            Assert.notNull(taskId,"任务id不能为空");
            boolean success = taskService.cancelTask(taskId);
            return ResponseMessage.ok(success);
        } catch (TaskNotExistException e) {
            log.error("cancelTask exception,taskId={}",taskId);
            return ResponseMessage.error(e.getMessage());
        }
    }
    
    @GetMapping("/refresh")
    public ResponseMessage refresh(){
        try {
            taskService.refresh();
            return ResponseMessage.ok("");
        } catch (Exception e) {
            log.error("refresh exception,msg={}",e.getMessage());
            return ResponseMessage.error(e.getMessage());
        }
    }

    @Autowired
    private SystemParams systemParams;

    @GetMapping("/testRefresh")
    public String testRefresh(){
        return systemParams.getPreLoad()+"";
    }
}
