DROP database if exists `chongba_schedule0`;
CREATE DATABASE `chongba_schedule0` DEFAULT CHARACTER SET utf8;
USE `chongba_schedule0`;
CREATE TABLE `taskinfo_0` (
  `task_id` bigint(20) NOT NULL    comment '任务id',
  `execute_time` datetime(3) NOT NULL comment '执行时间',
  `parameters` longblob  comment '参数',
  `priority` int(11) NOT NULL      comment '优先级',
  `task_type` int(11) NOT NULL     comment '任务类型',
  PRIMARY KEY (`task_id`),
  KEY `index_taskinfo_time` (`task_type`,`priority`,`execute_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taskinfo_1` (
  `task_id` bigint(20) NOT NULL    comment '任务id',
  `execute_time` datetime(3) NOT NULL comment '执行时间',
  `parameters` longblob  comment '参数',
  `priority` int(11) NOT NULL      comment '优先级',
  `task_type` int(11) NOT NULL     comment '任务类型',
  PRIMARY KEY (`task_id`),
  KEY `index_taskinfo_time` (`task_type`,`priority`,`execute_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taskinfo_logs_0` (
  `task_id` bigint(20) NOT NULL     comment '任务id',
  `execute_time` datetime(3) NOT NULL  comment '执行时间',
  `parameters` longblob   comment '参数',
  `priority` int(11) NOT NULL       comment '优先级',
  `task_type` int(11) NOT NULL      comment '任务类型',
  `version` int(11) NOT NULL        comment '版本号,用乐观锁',
  `status` int(11) DEFAULT '0' COMMENT '状态 0=初始化状态 1=EXECUTED 2=CANCELLED',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taskinfo_logs_1` (
  `task_id` bigint(20) NOT NULL     comment '任务id',
  `execute_time` datetime(3) NOT NULL  comment '执行时间',
  `parameters` longblob   comment '参数',
  `priority` int(11) NOT NULL       comment '优先级',
  `task_type` int(11) NOT NULL      comment '任务类型',
  `version` int(11) NOT NULL        comment '版本号,用乐观锁',
  `status` int(11) DEFAULT '0'      comment '状态 0=初始化状态 1=EXECUTED 2=CANCELLED',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
drop database if exists `chongba_schedule1`;
CREATE DATABASE `chongba_schedule1` DEFAULT CHARACTER SET utf8;
USE `chongba_schedule1`;
CREATE TABLE `taskinfo_0` (
  `task_id` bigint(20) NOT NULL    comment '任务id',
  `execute_time` datetime(3) NOT NULL comment '执行时间',
  `parameters` longblob  comment '参数',
  `priority` int(11) NOT NULL      comment '优先级',
  `task_type` int(11) NOT NULL     comment '任务类型',
  PRIMARY KEY (`task_id`),
  KEY `index_taskinfo_time` (`task_type`,`priority`,`execute_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taskinfo_1` (
  `task_id` bigint(20) NOT NULL    comment '任务id',
  `execute_time` datetime(3) NOT NULL comment '执行时间',
  `parameters` longblob  comment '参数',
  `priority` int(11) NOT NULL      comment '优先级',
  `task_type` int(11) NOT NULL     comment '任务类型',
  PRIMARY KEY (`task_id`),
  KEY `index_taskinfo_time` (`task_type`,`priority`,`execute_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taskinfo_logs_0` (
  `task_id` bigint(20) NOT NULL     comment '任务id',
  `execute_time` datetime(3) NOT NULL  comment '执行时间',
  `parameters` longblob   comment '参数',
  `priority` int(11) NOT NULL       comment '优先级',
  `task_type` int(11) NOT NULL      comment '任务类型',
  `version` int(11) NOT NULL        comment '版本号,用乐观锁',
  `status` int(11) DEFAULT '0'      comment '状态 0=初始化状态 1=EXECUTED 2=CANCELLED',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taskinfo_logs_1` (
  `task_id` bigint(20) NOT NULL     comment '任务id',
  `execute_time` datetime(3) NOT NULL  comment '执行时间',
  `parameters` longblob   comment '参数',
  `priority` int(11) NOT NULL       comment '优先级',
  `task_type` int(11) NOT NULL      comment '任务类型',
  `version` int(11) NOT NULL        comment '版本号,用乐观锁',
  `status` int(11) DEFAULT '0'      comment '状态 0=初始化状态 1=EXECUTED 2=CANCELLED',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


