package com.chongba.schedule.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by 传智播客*黑马程序员.
 */

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) //不继承equals和hashcode方法

@TableName("taskinfo_logs")
public class TaskInfoLogsEntity extends TaskInfoEntity{

    /**
     *  `version` INT(11) NOT NULL COMMENT '版本号,用乐观锁',
     `status` INT(11) DEFAULT '0' COMMENT '状态 0=初始化状态 1=EXECUTED 2=CANCELLED',
     */
    @Version
    private Integer version;
    
    @TableField
    private Integer status;
    

}
