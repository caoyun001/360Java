-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
`sex` char(1) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '1', '2018-07-10', '北京');
INSERT INTO `user` VALUES ('2', '李四', '1', '2018-07-10', '上海');
INSERT INTO `user` VALUES ('3', '王五', '1', '2018-07-10', '广州');
INSERT INTO `user` VALUES ('4', '王六', '1', '2018-07-10', '深圳');
