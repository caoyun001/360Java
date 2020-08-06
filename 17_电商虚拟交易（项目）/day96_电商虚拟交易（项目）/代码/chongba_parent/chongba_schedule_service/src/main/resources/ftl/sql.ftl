<#list  0..sqlbean.db_count-1 as dbCount>
DROP database if exists `chongba_schedule${dbCount}`;
CREATE DATABASE `chongba_schedule${dbCount}` DEFAULT CHARACTER SET utf8;
USE `chongba_schedule${dbCount}`;

<#list 0..sqlbean.taskinfo_count-1 as taskCount>
CREATE TABLE `taskinfo_${taskCount}` (
`task_id` bigint(20) NOT NULL    comment '任务id',
`execute_time` datetime(3) NOT NULL comment '执行时间',
`parameters` longblob   comment '参数',
`priority` int(11) NOT NULL      comment '优先级',
`task_type` int(11) NOT NULL     comment '任务类型',
PRIMARY KEY (`task_id`),
KEY `index_taskinfo_time` (`task_type`,`priority`,`execute_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
</#list>

<#list sqlbean.taskinfo_logs_monthList as month>
CREATE TABLE `taskinfo_logs_${month}` (
`task_id` bigint(20) NOT NULL COMMENT '任务id',
`execute_time` datetime(3) COMMENT '执行时间',
`parameters` longblob  COMMENT '参数',
`priority` int(11) NOT NULL COMMENT '优先级',
`task_type` int(11) NOT NULL COMMENT '任务类型',
`version` int(11) NOT NULL COMMENT '版本号,用乐观锁',
`status` int(11) DEFAULT '0' COMMENT '状态 0=初始化状态 1=EXECUTED 2=CANCELLED',
PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
</#list>
</#list>


