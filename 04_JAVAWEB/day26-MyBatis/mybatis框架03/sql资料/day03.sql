



/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `RID` int(11) NOT NULL auto_increment COMMENT '角色id',
  `RNAME` varchar(30) default NULL COMMENT '角色名称',
  `RDESC` varchar(60) default NULL COMMENT '角色描述',
  PRIMARY KEY  (`RID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`RID`,`RNAME`,`RDESC`) values (1,'丈夫',''),(2,'农民工',''),(3,'公务员',''),(4,'教师','');


/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `UID` int(11) NOT NULL COMMENT '用户编号',
  `RID` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY  (`UID`,`RID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`UID`,`RID`) values (2,1),(2,2),(3,1),(3,3),(4,1),(4,4);


