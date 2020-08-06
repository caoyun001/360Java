package com.chongba.feign;

import com.chongba.entity.ResponseMessage;
import com.chongba.entity.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 传智播客*黑马程序员.
 */
@FeignClient("schedule-service")
public interface TaskServiceClient {
    
    
    @PostMapping("/task/push")
    public ResponseMessage push(@RequestBody Task task);
    
    @GetMapping("/task/poll/{taskType}/{priority}")
    public ResponseMessage poll(@PathVariable("taskType") int type, @PathVariable("priority") int priority);
    
    @PostMapping("/task/cancel")
    public ResponseMessage cancel(@RequestParam("taskId")Long taskId);
    
    @GetMapping("/task/refresh")
    public ResponseMessage refresh();
}
