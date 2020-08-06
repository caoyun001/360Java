/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : itheima_mm

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-09-06 16:19:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tr_company_industry`
-- ----------------------------
DROP TABLE IF EXISTS `tr_company_industry`;
CREATE TABLE `tr_company_industry` (
  `company_id` int(11) NOT NULL,
  `industry_id` int(11) NOT NULL,
  PRIMARY KEY (`company_id`,`industry_id`),
  KEY `fk_ci_industry` (`industry_id`),
  CONSTRAINT `fk_ci_company` FOREIGN KEY (`company_id`) REFERENCES `t_company` (`id`),
  CONSTRAINT `fk_ci_industry` FOREIGN KEY (`industry_id`) REFERENCES `t_industry` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tr_company_industry
-- ----------------------------
INSERT INTO `tr_company_industry` VALUES ('1', '1');
INSERT INTO `tr_company_industry` VALUES ('2', '1');
INSERT INTO `tr_company_industry` VALUES ('5', '1');
INSERT INTO `tr_company_industry` VALUES ('6', '1');
INSERT INTO `tr_company_industry` VALUES ('7', '1');
INSERT INTO `tr_company_industry` VALUES ('9', '1');
INSERT INTO `tr_company_industry` VALUES ('32', '1');
INSERT INTO `tr_company_industry` VALUES ('33', '1');
INSERT INTO `tr_company_industry` VALUES ('34', '1');
INSERT INTO `tr_company_industry` VALUES ('1', '2');
INSERT INTO `tr_company_industry` VALUES ('2', '2');
INSERT INTO `tr_company_industry` VALUES ('3', '2');
INSERT INTO `tr_company_industry` VALUES ('8', '2');
INSERT INTO `tr_company_industry` VALUES ('35', '2');
INSERT INTO `tr_company_industry` VALUES ('5', '3');
INSERT INTO `tr_company_industry` VALUES ('8', '3');
INSERT INTO `tr_company_industry` VALUES ('14', '4');
INSERT INTO `tr_company_industry` VALUES ('5', '5');
INSERT INTO `tr_company_industry` VALUES ('15', '5');
INSERT INTO `tr_company_industry` VALUES ('12', '6');
INSERT INTO `tr_company_industry` VALUES ('16', '6');
INSERT INTO `tr_company_industry` VALUES ('17', '7');
INSERT INTO `tr_company_industry` VALUES ('18', '8');
INSERT INTO `tr_company_industry` VALUES ('19', '9');
INSERT INTO `tr_company_industry` VALUES ('8', '10');
INSERT INTO `tr_company_industry` VALUES ('20', '10');
INSERT INTO `tr_company_industry` VALUES ('4', '11');
INSERT INTO `tr_company_industry` VALUES ('8', '11');
INSERT INTO `tr_company_industry` VALUES ('10', '11');
INSERT INTO `tr_company_industry` VALUES ('21', '11');
INSERT INTO `tr_company_industry` VALUES ('3', '12');
INSERT INTO `tr_company_industry` VALUES ('22', '12');
INSERT INTO `tr_company_industry` VALUES ('23', '13');
INSERT INTO `tr_company_industry` VALUES ('24', '14');
INSERT INTO `tr_company_industry` VALUES ('25', '16');
INSERT INTO `tr_company_industry` VALUES ('26', '16');
INSERT INTO `tr_company_industry` VALUES ('10', '17');
INSERT INTO `tr_company_industry` VALUES ('27', '17');
INSERT INTO `tr_company_industry` VALUES ('1', '18');
INSERT INTO `tr_company_industry` VALUES ('28', '18');
INSERT INTO `tr_company_industry` VALUES ('2', '19');
INSERT INTO `tr_company_industry` VALUES ('29', '19');
INSERT INTO `tr_company_industry` VALUES ('3', '20');
INSERT INTO `tr_company_industry` VALUES ('30', '20');
INSERT INTO `tr_company_industry` VALUES ('13', '21');
INSERT INTO `tr_company_industry` VALUES ('31', '21');
INSERT INTO `tr_company_industry` VALUES ('1', '26');
INSERT INTO `tr_company_industry` VALUES ('1', '27');

-- ----------------------------
-- Table structure for `tr_member_question`
-- ----------------------------
DROP TABLE IF EXISTS `tr_member_question`;
CREATE TABLE `tr_member_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `is_favorite` int(11) DEFAULT NULL COMMENT '是否收藏：0.否 1.是',
  `tag` int(11) DEFAULT NULL COMMENT '做题标记\r\n            0 正确  \r\n            1 错误\r\n            2 理想\r\n            3 不理想',
  `answerResult` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fk_fq_member` (`member_id`),
  KEY `FK_fk_mq_question` (`question_id`),
  CONSTRAINT `FK_fk_fq_member` FOREIGN KEY (`member_id`) REFERENCES `t_wx_member` (`id`),
  CONSTRAINT `FK_fk_mq_question` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COMMENT='微信用户 试题 中间表';

-- ----------------------------
-- Records of tr_member_question
-- ----------------------------
INSERT INTO `tr_member_question` VALUES ('1', '1', '3', '1', '0', null);
INSERT INTO `tr_member_question` VALUES ('3', '1', '5', '1', '1', null);
INSERT INTO `tr_member_question` VALUES ('4', '1', '6', '1', '1', null);
INSERT INTO `tr_member_question` VALUES ('5', '1', '7', '1', '0', null);
INSERT INTO `tr_member_question` VALUES ('6', '1', '8', '0', '1', null);
INSERT INTO `tr_member_question` VALUES ('7', '1', '9', '0', '2', null);
INSERT INTO `tr_member_question` VALUES ('8', '1', '10', '0', '3', null);
INSERT INTO `tr_member_question` VALUES ('45', '6', '1', '0', '2', null);
INSERT INTO `tr_member_question` VALUES ('46', '6', '2', '0', '3', null);
INSERT INTO `tr_member_question` VALUES ('47', '6', '3', '0', '1', '[\"B\"]');
INSERT INTO `tr_member_question` VALUES ('48', '6', '4', '1', '1', '[\"A\"]');
INSERT INTO `tr_member_question` VALUES ('49', '6', '5', '0', '0', '[\"B\"]');
INSERT INTO `tr_member_question` VALUES ('50', '6', '6', '1', '0', '[\"D\",\"A\",\"B\"]');
INSERT INTO `tr_member_question` VALUES ('51', '6', '50', '0', '2', null);
INSERT INTO `tr_member_question` VALUES ('52', '6', '53', '0', '3', null);
INSERT INTO `tr_member_question` VALUES ('53', '6', '54', '0', '2', null);
INSERT INTO `tr_member_question` VALUES ('54', '6', '7', '0', '1', '[\"A\",\"B\"]');
INSERT INTO `tr_member_question` VALUES ('55', '5', '11', '0', null, null);
INSERT INTO `tr_member_question` VALUES ('56', '6', '8', '1', null, null);
INSERT INTO `tr_member_question` VALUES ('57', '6', '55', '0', '2', null);
INSERT INTO `tr_member_question` VALUES ('58', '6', '78', '0', '2', null);

-- ----------------------------
-- Table structure for `tr_question_tag`
-- ----------------------------
DROP TABLE IF EXISTS `tr_question_tag`;
CREATE TABLE `tr_question_tag` (
  `question_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`,`tag_id`),
  KEY `fk_qt_tag` (`tag_id`),
  CONSTRAINT `fk_qt_question` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`),
  CONSTRAINT `fk_qt_tag` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tr_question_tag
-- ----------------------------
INSERT INTO `tr_question_tag` VALUES ('1', '1');
INSERT INTO `tr_question_tag` VALUES ('8', '1');
INSERT INTO `tr_question_tag` VALUES ('11', '1');
INSERT INTO `tr_question_tag` VALUES ('634', '1');
INSERT INTO `tr_question_tag` VALUES ('635', '1');
INSERT INTO `tr_question_tag` VALUES ('636', '1');
INSERT INTO `tr_question_tag` VALUES ('638', '1');
INSERT INTO `tr_question_tag` VALUES ('639', '1');
INSERT INTO `tr_question_tag` VALUES ('640', '1');
INSERT INTO `tr_question_tag` VALUES ('641', '1');
INSERT INTO `tr_question_tag` VALUES ('642', '1');
INSERT INTO `tr_question_tag` VALUES ('643', '1');
INSERT INTO `tr_question_tag` VALUES ('644', '1');
INSERT INTO `tr_question_tag` VALUES ('649', '1');
INSERT INTO `tr_question_tag` VALUES ('650', '1');
INSERT INTO `tr_question_tag` VALUES ('651', '1');
INSERT INTO `tr_question_tag` VALUES ('654', '1');
INSERT INTO `tr_question_tag` VALUES ('658', '1');
INSERT INTO `tr_question_tag` VALUES ('659', '1');
INSERT INTO `tr_question_tag` VALUES ('660', '1');
INSERT INTO `tr_question_tag` VALUES ('661', '1');
INSERT INTO `tr_question_tag` VALUES ('662', '1');
INSERT INTO `tr_question_tag` VALUES ('665', '1');
INSERT INTO `tr_question_tag` VALUES ('668', '1');
INSERT INTO `tr_question_tag` VALUES ('669', '1');
INSERT INTO `tr_question_tag` VALUES ('2', '2');
INSERT INTO `tr_question_tag` VALUES ('8', '2');
INSERT INTO `tr_question_tag` VALUES ('11', '2');
INSERT INTO `tr_question_tag` VALUES ('634', '2');
INSERT INTO `tr_question_tag` VALUES ('635', '2');
INSERT INTO `tr_question_tag` VALUES ('636', '2');
INSERT INTO `tr_question_tag` VALUES ('638', '2');
INSERT INTO `tr_question_tag` VALUES ('639', '2');
INSERT INTO `tr_question_tag` VALUES ('640', '2');
INSERT INTO `tr_question_tag` VALUES ('641', '2');
INSERT INTO `tr_question_tag` VALUES ('642', '2');
INSERT INTO `tr_question_tag` VALUES ('644', '2');
INSERT INTO `tr_question_tag` VALUES ('647', '2');
INSERT INTO `tr_question_tag` VALUES ('649', '2');
INSERT INTO `tr_question_tag` VALUES ('650', '2');
INSERT INTO `tr_question_tag` VALUES ('651', '2');
INSERT INTO `tr_question_tag` VALUES ('654', '2');
INSERT INTO `tr_question_tag` VALUES ('656', '2');
INSERT INTO `tr_question_tag` VALUES ('659', '2');
INSERT INTO `tr_question_tag` VALUES ('660', '2');
INSERT INTO `tr_question_tag` VALUES ('661', '2');
INSERT INTO `tr_question_tag` VALUES ('662', '2');
INSERT INTO `tr_question_tag` VALUES ('665', '2');
INSERT INTO `tr_question_tag` VALUES ('668', '2');
INSERT INTO `tr_question_tag` VALUES ('3', '3');
INSERT INTO `tr_question_tag` VALUES ('5', '3');
INSERT INTO `tr_question_tag` VALUES ('9', '3');
INSERT INTO `tr_question_tag` VALUES ('11', '3');
INSERT INTO `tr_question_tag` VALUES ('643', '3');
INSERT INTO `tr_question_tag` VALUES ('652', '3');
INSERT INTO `tr_question_tag` VALUES ('653', '3');
INSERT INTO `tr_question_tag` VALUES ('657', '3');
INSERT INTO `tr_question_tag` VALUES ('658', '3');
INSERT INTO `tr_question_tag` VALUES ('661', '3');
INSERT INTO `tr_question_tag` VALUES ('4', '4');
INSERT INTO `tr_question_tag` VALUES ('5', '4');
INSERT INTO `tr_question_tag` VALUES ('6', '4');
INSERT INTO `tr_question_tag` VALUES ('9', '4');
INSERT INTO `tr_question_tag` VALUES ('10', '4');
INSERT INTO `tr_question_tag` VALUES ('644', '4');
INSERT INTO `tr_question_tag` VALUES ('645', '4');
INSERT INTO `tr_question_tag` VALUES ('647', '4');
INSERT INTO `tr_question_tag` VALUES ('655', '4');
INSERT INTO `tr_question_tag` VALUES ('657', '4');
INSERT INTO `tr_question_tag` VALUES ('665', '4');
INSERT INTO `tr_question_tag` VALUES ('1', '5');
INSERT INTO `tr_question_tag` VALUES ('6', '5');
INSERT INTO `tr_question_tag` VALUES ('10', '5');
INSERT INTO `tr_question_tag` VALUES ('666', '5');
INSERT INTO `tr_question_tag` VALUES ('670', '5');
INSERT INTO `tr_question_tag` VALUES ('2', '6');
INSERT INTO `tr_question_tag` VALUES ('7', '6');
INSERT INTO `tr_question_tag` VALUES ('666', '6');
INSERT INTO `tr_question_tag` VALUES ('667', '6');
INSERT INTO `tr_question_tag` VALUES ('3', '7');
INSERT INTO `tr_question_tag` VALUES ('667', '7');
INSERT INTO `tr_question_tag` VALUES ('4', '8');
INSERT INTO `tr_question_tag` VALUES ('7', '8');
INSERT INTO `tr_question_tag` VALUES ('648', '8');
INSERT INTO `tr_question_tag` VALUES ('666', '8');
INSERT INTO `tr_question_tag` VALUES ('670', '8');
INSERT INTO `tr_question_tag` VALUES ('640', '12');
INSERT INTO `tr_question_tag` VALUES ('656', '12');
INSERT INTO `tr_question_tag` VALUES ('641', '13');
INSERT INTO `tr_question_tag` VALUES ('634', '14');
INSERT INTO `tr_question_tag` VALUES ('635', '15');
INSERT INTO `tr_question_tag` VALUES ('636', '16');
INSERT INTO `tr_question_tag` VALUES ('638', '17');
INSERT INTO `tr_question_tag` VALUES ('639', '18');
INSERT INTO `tr_question_tag` VALUES ('642', '19');

-- ----------------------------
-- Table structure for `tr_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `tr_role_permission`;
CREATE TABLE `tr_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `fk_rp_permission` (`permission_id`),
  CONSTRAINT `fk_rp_permission` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`),
  CONSTRAINT `fk_rp_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of tr_role_permission
-- ----------------------------
INSERT INTO `tr_role_permission` VALUES ('1', '1');
INSERT INTO `tr_role_permission` VALUES ('1', '2');
INSERT INTO `tr_role_permission` VALUES ('2', '2');
INSERT INTO `tr_role_permission` VALUES ('1', '3');
INSERT INTO `tr_role_permission` VALUES ('1', '4');
INSERT INTO `tr_role_permission` VALUES ('1', '5');
INSERT INTO `tr_role_permission` VALUES ('1', '6');
INSERT INTO `tr_role_permission` VALUES ('2', '6');
INSERT INTO `tr_role_permission` VALUES ('1', '7');
INSERT INTO `tr_role_permission` VALUES ('2', '7');
INSERT INTO `tr_role_permission` VALUES ('1', '8');
INSERT INTO `tr_role_permission` VALUES ('2', '8');
INSERT INTO `tr_role_permission` VALUES ('1', '9');
INSERT INTO `tr_role_permission` VALUES ('2', '9');
INSERT INTO `tr_role_permission` VALUES ('1', '10');
INSERT INTO `tr_role_permission` VALUES ('2', '10');
INSERT INTO `tr_role_permission` VALUES ('1', '11');
INSERT INTO `tr_role_permission` VALUES ('2', '11');
INSERT INTO `tr_role_permission` VALUES ('1', '12');
INSERT INTO `tr_role_permission` VALUES ('2', '12');
INSERT INTO `tr_role_permission` VALUES ('1', '13');

-- ----------------------------
-- Table structure for `tr_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tr_user_role`;
CREATE TABLE `tr_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_ru_role` (`role_id`),
  CONSTRAINT `fk_ru_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `fk_ru_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of tr_user_role
-- ----------------------------
INSERT INTO `tr_user_role` VALUES ('1', '1');
INSERT INTO `tr_user_role` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `t_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `t_catalog`;
CREATE TABLE `t_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态\r\n            0 启用\r\n            1 禁用',
  `user_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course_catalog` (`course_id`),
  KEY `fk_user_catalog` (`user_id`),
  CONSTRAINT `fk_course_catalog` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`),
  CONSTRAINT `fk_user_catalog` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='学科目录';

-- ----------------------------
-- Records of t_catalog
-- ----------------------------
INSERT INTO `t_catalog` VALUES ('1', 'Java基础', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_catalog` VALUES ('2', 'JavaWeb', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_catalog` VALUES ('3', 'Spring MVC', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_catalog` VALUES ('4', 'Spring boot', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_catalog` VALUES ('5', 'Python基础', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_catalog` VALUES ('6', '函数编程', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_catalog` VALUES ('7', '面向对象编程', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_catalog` VALUES ('14', 'aaa', '2019-08-16 15:34:22', '1', '1', '1', null);
INSERT INTO `t_catalog` VALUES ('15', 'bbb', '2019-08-16 16:06:33', '1', '1', '1', null);
INSERT INTO `t_catalog` VALUES ('16', 'ccc', '2019-08-16 16:06:36', '1', '1', '1', null);
INSERT INTO `t_catalog` VALUES ('17', 'ddd', '2019-08-16 16:07:41', '1', '1', '1', null);
INSERT INTO `t_catalog` VALUES ('20', 'hhhh', '2019-08-16 16:08:31', '1', '1', '1', null);
INSERT INTO `t_catalog` VALUES ('21', 'aaa', '2019-08-28 11:37:28', '0', '1', '1', null);

-- ----------------------------
-- Table structure for `t_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `short_name` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `full_name` varchar(50) DEFAULT NULL COMMENT '公司全称',
  `is_famous` int(11) DEFAULT NULL COMMENT '是否名企：\r\n            0.不是  \r\n            1.是',
  `state` int(11) DEFAULT NULL COMMENT '状态：\r\n            0.启用\r\n            1.禁用',
  `remark` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL COMMENT '排序编号',
  PRIMARY KEY (`id`),
  KEY `fk_compone_user` (`user_id`),
  KEY `FK_fk_dict_company` (`city_id`),
  CONSTRAINT `FK_fk_dict_company` FOREIGN KEY (`city_id`) REFERENCES `t_dict` (`id`),
  CONSTRAINT `fk_compone_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COMMENT='公司表';

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('1', '北京淘宝网', null, '1', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('2', '北京支付宝', null, '1', '0', null, '2019-08-08 00:00:00', '10', '1', '1');
INSERT INTO `t_company` VALUES ('3', '北京蚂蚁金服', null, '1', '0', null, '2019-08-08 00:00:00', '10', '1', '1');
INSERT INTO `t_company` VALUES ('4', '七牛云服务', null, '1', '0', null, '2019-08-08 00:00:00', '10', '1', '1');
INSERT INTO `t_company` VALUES ('5', '拼多多', null, '1', '0', null, '2019-08-08 00:00:00', '10', '1', '1');
INSERT INTO `t_company` VALUES ('6', '唯品会', null, '1', '0', null, '2019-08-08 00:00:00', '10', '1', '1');
INSERT INTO `t_company` VALUES ('7', '唯品会', null, '1', '0', null, '2019-08-08 00:00:00', '12', '1', '1');
INSERT INTO `t_company` VALUES ('8', '腾讯公司', null, '1', '0', null, '2019-08-08 00:00:00', '13', '1', '1');
INSERT INTO `t_company` VALUES ('9', '杭州淘宝网', null, '1', '0', null, '2019-08-08 00:00:00', '13', '1', '1');
INSERT INTO `t_company` VALUES ('10', '浪潮软件', null, '1', '0', null, '2019-08-08 00:00:00', '14', '1', '1');
INSERT INTO `t_company` VALUES ('12', '简途旅行', null, '1', '0', null, '2019-08-08 00:00:00', '15', '1', '1');
INSERT INTO `t_company` VALUES ('13', '绿盟科技', null, '1', '0', null, '2019-08-08 00:00:00', '16', '1', '1');
INSERT INTO `t_company` VALUES ('14', '金信石', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('15', '贵鑫堂', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('16', '掌众金服', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('17', '晨创科技', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('18', '中软国际', null, '1', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('19', '全景网', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('20', '翼龙贷', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('21', '中烟新商盟', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('22', '西安泰晟', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('23', '联创佳讯', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('24', '神航星云', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('25', '软通动力', null, '1', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('26', '网众传媒', null, '1', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('27', '软通动力', null, '1', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('28', '文思海辉', null, '1', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('29', '赞同科技', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('30', '北正云鼎', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('31', '信雅达', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('32', '东方微银', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('33', '易宝软件', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('34', '智乾区块链', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');
INSERT INTO `t_company` VALUES ('35', '中科金财', null, '0', '0', null, '2019-08-08 00:00:00', '9', '1', '1');

-- ----------------------------
-- Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `is_show` int(11) DEFAULT NULL COMMENT '是否显示\r\n            0 显示\r\n            1 不显示',
  `user_id` int(11) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL COMMENT '排序编号',
  PRIMARY KEY (`id`),
  KEY `fk_user_course` (`user_id`),
  CONSTRAINT `fk_user_course` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='学科表\r\n';

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', 'Java', null, '2019-08-08 00:00:00', '0', '1', '1');
INSERT INTO `t_course` VALUES ('2', 'Python', null, '2019-08-08 00:00:00', '0', '1', '1');
INSERT INTO `t_course` VALUES ('3', '大数据', null, '2019-08-08 00:00:00', '0', '1', '1');
INSERT INTO `t_course` VALUES ('4', 'Php', null, '2019-08-08 00:00:00', '0', '1', '1');
INSERT INTO `t_course` VALUES ('19', 'aaaa', null, '2019-08-21 10:25:17', '1', '1', null);
INSERT INTO `t_course` VALUES ('20', '888', null, '2019-08-23 09:07:21', '0', '1', null);
INSERT INTO `t_course` VALUES ('21', 'bbbb', null, '2019-08-25 19:49:19', '0', '1', null);

-- ----------------------------
-- Table structure for `t_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `data_type` int(11) DEFAULT NULL COMMENT '数据的类型',
  `data_code` varchar(10) DEFAULT NULL COMMENT '数据的编码',
  `data_value` varchar(50) DEFAULT NULL COMMENT '数据内容',
  `data_tag` int(11) DEFAULT NULL COMMENT '数据标志',
  `data_desc` varchar(100) DEFAULT NULL COMMENT '详情',
  `order_no` int(11) DEFAULT NULL COMMENT '排序编号',
  PRIMARY KEY (`id`),
  KEY `FK_fk_id_pid` (`pid`),
  CONSTRAINT `FK_fk_id_pid` FOREIGN KEY (`pid`) REFERENCES `t_dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', null, '0', null, '北京', '0', null, '1');
INSERT INTO `t_dict` VALUES ('2', null, '0', null, '上海', '0', null, '1');
INSERT INTO `t_dict` VALUES ('3', null, '0', null, '天津', '0', null, '1');
INSERT INTO `t_dict` VALUES ('4', null, '0', null, '广东省', '0', null, '1');
INSERT INTO `t_dict` VALUES ('5', null, '0', null, '浙江省', '0', null, '1');
INSERT INTO `t_dict` VALUES ('6', null, '0', null, '山东省', '0', null, '1');
INSERT INTO `t_dict` VALUES ('7', null, '0', null, '四川省', '0', null, '1');
INSERT INTO `t_dict` VALUES ('8', null, '0', null, '陕西省', '0', null, '1');
INSERT INTO `t_dict` VALUES ('9', '1', '1', null, '北京', '1', null, '10');
INSERT INTO `t_dict` VALUES ('10', '2', '1', null, '上海', '1', null, '9');
INSERT INTO `t_dict` VALUES ('11', '3', '1', null, '天津', '1', null, '7');
INSERT INTO `t_dict` VALUES ('12', '4', '1', null, '广州', '1', null, '8');
INSERT INTO `t_dict` VALUES ('13', '4', '1', null, '深圳', '1', null, '6');
INSERT INTO `t_dict` VALUES ('14', '5', '1', null, '杭州', '0', null, '1');
INSERT INTO `t_dict` VALUES ('15', '6', '1', null, '济南', '0', null, '1');
INSERT INTO `t_dict` VALUES ('16', '7', '1', null, '成都', '0', null, '1');
INSERT INTO `t_dict` VALUES ('17', '8', '1', null, '西安', '1', null, '5');

-- ----------------------------
-- Table structure for `t_industry`
-- ----------------------------
DROP TABLE IF EXISTS `t_industry`;
CREATE TABLE `t_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '公司名称',
  `remark` varchar(100) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL COMMENT '排序编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COMMENT='行业';

-- ----------------------------
-- Records of t_industry
-- ----------------------------
INSERT INTO `t_industry` VALUES ('1', '电商平台', null, '1');
INSERT INTO `t_industry` VALUES ('2', '金融服务', null, '1');
INSERT INTO `t_industry` VALUES ('3', '电竞游戏', null, '1');
INSERT INTO `t_industry` VALUES ('4', '银行证券', null, '1');
INSERT INTO `t_industry` VALUES ('5', '在线教育', null, '1');
INSERT INTO `t_industry` VALUES ('6', '文化娱乐', null, '1');
INSERT INTO `t_industry` VALUES ('7', '通信制造', null, '1');
INSERT INTO `t_industry` VALUES ('8', '医疗卫生', null, '1');
INSERT INTO `t_industry` VALUES ('9', '生活服务', null, '1');
INSERT INTO `t_industry` VALUES ('10', '广告营销', null, '1');
INSERT INTO `t_industry` VALUES ('11', '数据服务', null, '1');
INSERT INTO `t_industry` VALUES ('12', '信息安全', null, '1');
INSERT INTO `t_industry` VALUES ('13', '物流服务', null, '1');
INSERT INTO `t_industry` VALUES ('14', '移动通讯', null, '1');
INSERT INTO `t_industry` VALUES ('15', '文化传媒', null, '1');
INSERT INTO `t_industry` VALUES ('16', '能源环保', null, '1');
INSERT INTO `t_industry` VALUES ('17', '软件开发', null, '1');
INSERT INTO `t_industry` VALUES ('18', '软件外包', null, '1');
INSERT INTO `t_industry` VALUES ('19', '平台服务', null, '1');
INSERT INTO `t_industry` VALUES ('20', '人力招聘', null, '1');
INSERT INTO `t_industry` VALUES ('21', '硬件开发', null, '1');
INSERT INTO `t_industry` VALUES ('22', '新增方向1', null, null);
INSERT INTO `t_industry` VALUES ('23', '新增方向2', null, null);
INSERT INTO `t_industry` VALUES ('24', '新增方向3', null, null);
INSERT INTO `t_industry` VALUES ('25', '新增方向4', null, null);
INSERT INTO `t_industry` VALUES ('26', '新增方向5', null, null);
INSERT INTO `t_industry` VALUES ('27', '新增方向6', null, null);

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `keyword` varchar(64) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '学科新增', 'COURSE_ADD', '增加学科');
INSERT INTO `t_permission` VALUES ('2', '学科列表', 'COURSE_LIST', '显示学科列表');
INSERT INTO `t_permission` VALUES ('3', '学科更新', 'COURSE_UPDATE', '更新学科');
INSERT INTO `t_permission` VALUES ('4', '学科删除', 'COURSE_DELETE', '删除学科');
INSERT INTO `t_permission` VALUES ('5', '学科状态更新', 'COURSE_STATE_UPDATE', '更新状态');
INSERT INTO `t_permission` VALUES ('6', '试题新增', 'QUESTION_ADD', '增加试题');
INSERT INTO `t_permission` VALUES ('7', '试题列表', 'QUESTION_LIST', '显示试题列表');
INSERT INTO `t_permission` VALUES ('8', '试题更新', 'QUESTION_UPDATE', '更新试题');
INSERT INTO `t_permission` VALUES ('9', '试题预览', 'QUESTION_PREVIEW', '预览试题');
INSERT INTO `t_permission` VALUES ('10', '试题删除', 'QUESTION_DELETE', '删除试题');
INSERT INTO `t_permission` VALUES ('11', '试题状态更新', 'QUESTION_STATE', '更新试题状态');
INSERT INTO `t_permission` VALUES ('12', '试题提交审核', 'QUESTION_REVIEW_SUBMIT', '提交审核请求');
INSERT INTO `t_permission` VALUES ('13', '试题更新审核', 'QUESTION_REVIEW_UPDATE', '更新审核，审核通过与不通过');

-- ----------------------------
-- Table structure for `t_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) DEFAULT NULL COMMENT '试题编号',
  `subject` varchar(200) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '题目类型： 1. 单选  2. 多选 5. 简答',
  `difficulty` int(11) DEFAULT NULL COMMENT '难度： \r\n            0 简单\r\n            1 一般\r\n            2 困难',
  `analysis` text COMMENT '答案解析',
  `analysis_video` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `is_classic` int(11) DEFAULT NULL COMMENT '是否精选题目\r\n            0 不是\r\n            1 是',
  `status` int(11) DEFAULT NULL COMMENT '题目状态\r\n            0 待发布（待审核、已拒绝）\r\n            1 已发布（已审核）\r\n            2 已下架（已审核）',
  `review_status` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL COMMENT '企业id',
  `catalog_id` int(11) NOT NULL COMMENT '方向id',
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_catalog_question` (`catalog_id`),
  KEY `fk_company_question` (`company_id`),
  KEY `FK_fk_user_question` (`user_id`),
  KEY `fk_course_question` (`course_id`),
  CONSTRAINT `FK_fk_user_question` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `fk_catalog_question` FOREIGN KEY (`catalog_id`) REFERENCES `t_catalog` (`id`),
  CONSTRAINT `fk_company_question` FOREIGN KEY (`company_id`) REFERENCES `t_company` (`id`),
  CONSTRAINT `fk_course_question` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=671 DEFAULT CHARSET=utf8mb4 COMMENT='试题表';

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('1', null, '<p>springmvc，mybatis的执行流程，spring中事物的管理</p>\r\n', '5', '1', '<p>springmvc执行流程：1.spring mvc将所有的请求都提交给DispatcherServlet,它会委托应用系统的其他模块负责对请求 进行真正的处理工作。<br />\r\n2.DispatcherServlet查询一个或多个HandlerMapping,找到处理请求的Controller.<br />\r\n3.DispatcherServlet请请求提交到目标Controller<br />\r\n4.Controller进行业务逻辑处理后，会返回一个ModelAndView<br />\r\n5.Dispathcher查询一个或多个ViewResolver视图解析器,找到ModelAndView对象指定的视图对象<br />\r\n6.视图对象负责渲染返回给客户端。<br />\r\n二：mybatis执行流程<br />\r\n1加载配置并初始化<br />\r\n2接收调用请求<br />\r\n3处理操作请求 触发条件：API接口层传递请求过来<br />\r\n(A)根据SQL的ID查找对应的MappedStatement对象。<br />\r\n<br />\r\n(B)根据传入参数对象解析Mapp', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('2', null, '<p>多线程通信</p>\r\n', '5', '1', '<p>1、使用volatile进行线程之间的通信<br />\r\n2、wait/notify的方法<br />\r\n3、CountDownLatch实现线程间通信</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('3', null, '下面关于线程创建的定义不正确的有（）</p>\r\n', '1', '1', '', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('4', null, '以下关于toString（）方法、equals（）方法说法正确的是？（ ）</p>\r\n', '1', '2', '', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '1', '1');
INSERT INTO `t_question` VALUES ('5', null, '以下选项对Lambda说法错误的是 ?（） </p>\r\n', '1', '2', '', '', null, '1', '3', '2', '2019-08-08 00:00:00', '1', '2', '1', '1');
INSERT INTO `t_question` VALUES ('6', null, '关于递归的描述正确的是?（）</p>\r\n', '2', '2', '', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '1', '1');
INSERT INTO `t_question` VALUES ('7', null, '下面关于线程创建的定义不正确的有（）</p>\r\n', '2', '3', '', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('8', null, '<p>数据库连表查询？</p>\r\n', '5', '3', '<p>内连接：inner&nbsp;join&nbsp;on&nbsp;；&nbsp;2.&nbsp;左连接：left&nbsp;join&nbsp;on&nbsp;；&nbsp;3.&nbsp;右连接：right&nbsp;join&nbsp;on&nbsp;;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('9', null, '<p>new_请用BeautifulSoup或者Xpath任一方式找到以下id标签里面的内容？&lt;aclass=\"sister\"href=\"http://example.com/elsie\"id=\"link1\"&gt;Elsie&lt;/a&gt;</p>', '5', '2', '<p>html.xpath(\"//a[@id=\'link1\']\")</p>', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('10', null, '<p>简单说明requests.content和requests.text的区别</p>\r\n', '5', '3', '<p>requests.text返回的是Unicode类型的数据，如果想获取文本，可以使用request.textrequests.content返回的是bytes类型的数据，也就是二进制类型的数据，如果想获取图片，文件，则可以使用requests.content</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('11', null, '<p>反爬虫措施？</p>', '5', '4', '<p>通过Headers反爬虫：从用户请求的Headers反爬虫是最常见的反爬虫策略。很多网站都会对Headers的User-Agent进行检测，还有一部分网站会对Referer进行检测（一些资源网站的防盗链就是检测Referer）。如果</p><p> 遇到了这类反爬虫机制，可以直接在爬虫中添加Headers，将浏览器的User-Agent复制到爬虫的</p><p> Headers中；或者将Referer值修改为目标网站域名。对于检测Headers的反爬虫，在爬虫中修改或</p><p> 者添加Headers就能很好的绕过。&nbsp;</p><p> 基于用户行为反爬虫：&nbsp;</p><p> 还有一部分网站是通过检测用户行为，例如同一IP短时间内多次访问同一页面，或者同一账户短时</p><p> 间内多次进行相同操作。&nbsp;</p><p> 大多数网站都是前一种情况，对于这种情况，使用IP代理就可以解决。可以专门写一个爬虫，爬取</p><p> 网上公开的代理ip，检测后全部保存起来。这样的代理ip爬虫经常会用到，最好自己准备一个。有了</p><p> 大量代理ip后可以每请求几次更</p>', '', null, '1', '0', '0', '2019-08-08 00:00:00', '1', '3', '1', '1');
INSERT INTO `t_question` VALUES ('12', null, '<p>加入Redis里面有1亿个key，其中10w个key是以某个固定的一直的前缀开头的，如何将他们全部找出来。</p>\r\n', '5', '5', '<p>使用keys指令可以扫出指定模式的key列表。<br />\r\n对方接着追问：如果这个redis正在给线上的业务提供服务，那使用keys指令会有什么问题？<br />\r\n这个时候你要回答redis关键的一个特性：redis的单线程的。keys指令会导致线程阻塞一段时间，线上服务会停顿，直到指令执行完毕，服务才能恢复。这个时候可以使用scan指令，scan指令可以无阻塞的提取出指定模式的key列表，但是会有一定的重复概率，在客户端做一次去重就可以了，但是整体所花费的时间会比直接用keys指令长。</p>\r\n', '', null, '1', '0', '0', '2019-08-08 00:00:00', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('13', null, '<p>Redis是多进程还是多线程的，简单描述redis数据库对于线程的管理机制</p>\r\n', '5', '3', '<p>单线程指的是网络请求模块使用了一个线程（所以不需考虑并发安全性），即一个线程处理所有网络请求，其他模块仍用了多个线程。redis实际上是采用了线程封闭的观念，把任务封闭在一个线程，自然避免了线程安全问题，不过对于需要依赖多个redis操作的复合操作来说，依然需要锁，而且有可能是分布式锁。</p>\r\n', '', null, '1', '0', '0', '2019-08-08 00:00:00', '1', '4', '1', '1');
INSERT INTO `t_question` VALUES ('14', null, '<p>redis相比memcached有哪些优势</p>', '5', '3', '<p>Redis在很多方面具备数据库的特征，或者说就是一个数据库系统，而Memcache只是简单的K/V缓存。</p><p> 如果要说内存使用效率，使用简单的key-value存储的话，Memcached的内存利用率更高，而如果Redis采用hash结构来做key-value存储，由于其组合式的压缩，其内存利用率会高于Memcache。当然，这和你的应用场景和数据特性有关。</p><p> 如果你对数据持久化和数据同步有所要求，那么推荐你选择Redis，因为这两个特性Memcache都不具备。即使你只是希望在升级或者重启系统后缓存数据不会丢失，选择Redis也是明智的。</p>', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('15', null, '<p>谈谈对线程池的理解?</p>\r\n', '5', '2', '<p>作用：减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务，提高系统性能。<br />\r\n可以根据系统的承受能力，调整线程池中工作线程的数目，防止因为消耗过多的内存，而把服务器累趴（每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机）。</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '4', '1', '1');
INSERT INTO `t_question` VALUES ('23', null, '<p>SQL注入的攻击原理及如何在代码中防止SQL注入</p>\r\n', '5', '3', '<p>SQL注入即是指web应用程序对用户输入数据的合法性没有判断，攻击者可以在web应用程序中事先定义好的查询语句的结尾上添加额外的SQL语句，以此来实现欺骗数据库服务器执行非授权的任意查询，从而进一步得到相应的数据信息。<br />\r\n利用参数化查询、对数据进行词法分析、使用存储过程等防止</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('26', null, '<p>Mysql的引擎</p>\r\n', '5', '2', '<p>主要&nbsp;MyISAM&nbsp;与&nbsp;InnoDB&nbsp;两个引擎，其主要区别如下：&nbsp;<br />\r\nInnoDB&nbsp;支持事务，MyISAM&nbsp;不支持，这一点是非常之重要。事务是一种高级的处理方式，如在一<br />\r\n些列增删改中只要哪个出错还可以回滚还原，而&nbsp;MyISAM就不可以了；&nbsp;<br />\r\nMyISAM&nbsp;适合查询以及插入为主的应用，InnoDB&nbsp;适合频繁修改以及涉及到安全性较高的应用；&nbsp;<br />\r\nInnoDB&nbsp;支持外键，MyISAM&nbsp;不支持；&nbsp;<br />\r\nMyISAM&nbsp;是默认引擎，InnoDB&nbsp;需要指定；&nbsp;<br />\r\nInnoDB&nbsp;不支持&nbsp;FULLTEXT&nbsp;类型的索引；&nbsp;<br />\r\nInnoDB&nbsp;中不保存表的行数，如&nbsp;select&nbsp;count()&nbsp;from&nbsp;table&nbsp;时，InnoDB；需要扫描一', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '5', '2');
INSERT INTO `t_question` VALUES ('27', null, '<p>数据库的优化</p>\r\n', '5', '2', '<p>1.优化索引、SQL&nbsp;语句、分析慢查询；&nbsp;<br />\r\n2.设计表的时候严格根据数据库的设计范式来设计数据库；&nbsp;<br />\r\n3.使用缓存，把经常访问到的数据而且不需要经常变化的数据放在缓存中，能节约磁盘IO&nbsp;<br />\r\n4.优化硬件；采用SSD，使用磁盘队列技术(RAID0,RAID1,RDID5)等&nbsp;<br />\r\n5.采用MySQL&nbsp;内部自带的表分区技术，把数据分层不同的文件，能够提高磁盘的读取效率；&nbsp;<br />\r\n6.垂直分表；把一些不经常读的数据放在一张表里，节约磁盘I/O；&nbsp;<br />\r\n7.主从分离读写；采用主从复制把数据库的读操作和写入操作分离开来；&nbsp;<br />\r\n8.分库分表分机器（数据量特别大），主要的的原理就是数据路由；&nbsp;<br />\r\n9.选择合适的表引擎，参数上的优化&nbsp;<br />\r\n10.进行架构级别的缓存，静态化和分布式；&nbsp;<br />\r\n11.不采用全文索引；&nbsp;<br />\r\n12.采用更快的存储方式，例如', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '5', '2');
INSERT INTO `t_question` VALUES ('30', null, '<p>多线程通信</p>\r\n', '5', '2', '<p>1使用volatile进行线程之间的通信&nbsp;<br />\r\n2wait/notify的方法<br />\r\n3CountDownLatch实现线程间通信</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '6', '2');
INSERT INTO `t_question` VALUES ('31', null, '<p>&nbsp;说明Session和Cookie的联系</p>\r\n', '5', '2', '<p>Session&nbsp;对&nbsp;Cookie&nbsp;的依赖：Cookie&nbsp;采用客户端存储，Session&nbsp;采用的服务端存储的机制。Se<br />\r\nssion是针对每个用户（浏览器端）的，Session值保存在服务器上，通过SessionId来区分哪个用<br />\r\n户的Session。因此SessionId需要被绑定在浏览器端。SessionId通常会默认通过Cookie在浏览<br />\r\n器端绑定，当浏览器端禁用cookie时，可通过Url重写（可以在地址栏看到sessionid=KWJHUG<br />\r\n6JJM65HS2K6&nbsp;之类的字符串）或者表单隐藏字段的方式将&nbsp;SessionId&nbsp;传回给服务器，以便服务通<br />\r\n过SessionId获取客户端对应的Session。&nbsp;<br />\r\n具体一次的请求流程：当程序需要为客户端创建一个&nbsp;Session&nbsp;的时候，服务器首先检测这个客<br />\r\n户端请求里面是否已经包含了&nbsp;Session&nbsp;的表示（Se', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '6', '2');
INSERT INTO `t_question` VALUES ('32', null, '<p>列举Java中的数据类型</p>\r\n', '5', '2', '<p>a) &nbsp;boolean、byte、char、short、int、float、douboe、long</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '7', '2');
INSERT INTO `t_question` VALUES ('33', null, '<p>Http有没有状态，如果没有状态，怎么解决http无状态？</p>\r\n', '5', '1', '<p>无状态的，一般使用cookie和session技术做会话跟踪</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '7', '2');
INSERT INTO `t_question` VALUES ('35', null, '<p>&nbsp;用Python匹配HTML&nbsp;tag的时候，&lt;.*&gt;和&lt;.*?&gt;有什么区别？&nbsp;</p>\r\n', '5', '2', '<p>术语叫贪婪匹配(&nbsp;&lt;.*&gt;&nbsp;)和非贪婪匹配(&lt;.*?&gt;&nbsp;)。</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '7', '2');
INSERT INTO `t_question` VALUES ('36', null, '<p>&nbsp;Python里面如何生成随机数？</p>\r\n', '5', '2', '<p>使用random模块。&nbsp;<br />\r\n1）随机整数：random.randint(a,b)：返回随机整数x,a&lt;=x&lt;=b&nbsp;<br />\r\nrandom.randrange(start,stop,[,step])：返回一个范围在(start,stop,step)之间的随机整数，不包<br />\r\n括结束值。&nbsp;<br />\r\n2）随机实数：random.random(&nbsp;):返回0到1之间的浮点数&nbsp;<br />\r\nrandom.uniform(a,b):返回指定范围内的浮点数。&nbsp;</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('37', null, '<p>nginx的反向代理</p>\r\n', '5', '2', '<p>本来浏览器A可以直接访问服务器C，nginx作为反向代理，实际上就是客户访问的ip地址是nginx的，而nginx再去访问服务器的ip，服务器发送的资源先通过nginx再到客户手里</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '3', '1', '1');
INSERT INTO `t_question` VALUES ('38', null, '<p>为什么不用django自带的服务器，而是用uwsgi</p>\r\n', '5', '3', '<p>runserver只适合在开发时候使用，它是单进程的，性能很差，如果出错挂掉，整个进程都会挂掉</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('41', null, '<p>数据库表A中有姓名fname的数据类型为varchar(20),要求使用SQL语句修改该字段的数据类型为nvarchar2(50)</p>\r\n', '5', '2', '<p>ALERT&nbsp;TABLE&nbsp;A&nbsp;MODIFY&nbsp;COLUMN&nbsp;fname&nbsp;nvarchar(50);</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('43', null, '<p>当输入http:mioji3.com时，返回页面的过程中发生了什么</p>\r\n', '5', '2', '<p>浏览器向DNS服务器发送mioji3.com域名解析请求DNS服务器返回解析后的ip给客户端浏览器，浏览器想该ip发送页面请求DNS服务器接收到请求后，查询该页面，并将页面发送给客户端浏览器客户端浏览器接收到页面后，解析页面中的引用，并再次向服务器发送引用资源请求服务器接收到资源请求后，查找并返回资源给客户端客户端浏览器接收到资源后，渲染，输出页面展现给用户</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('44', null, '<p>请说明HTTP状态吗的用途，请说明常见的状态码机器意义。</p>\r\n', '5', '2', '<p>通过状态码告诉客户端服务器的执行状态，以判断下一步该执行什么操作常见的状态机器码有:100-199：表示服务器成功接收部分请求，要求客户端继续提交其余请求才能完成整个处理过程。200-299：表示服务器成功接收请求并已完成处理过程，常用200（OK请求成功）300-399：为完成请求，客户需要进一步细化请求。302（所有请求页面已经临时转移到新的url），304、307（使用缓存资源）。400-499：客户端请求有错误，常用404（服务器无法找到被请求页面），403（服务器拒绝访问，权限不够）500-599：服务器端出现错误，常用500（请求未完成，服务器遇到不可预知的情况）</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('50', null, '<p>MySQL数据库有几个配&nbsp;&nbsp;置选项&nbsp;&nbsp;可以帮助&nbsp;我们及时捕获低效SQL语句</p>\r\n', '5', '5', '<p>1，slow_query_log这个参数设置为ON，可以捕获执行时间超过一定数值的SQL语句。2，long_query_time当SQL语句执行时间超过此数值时，就会被记录到日志中，建议设置为1或者更短。3，slow_query_log_file记录日志的文件名。4，log_queries_not_using_indexes这个参数设置为ON，可以捕获到所有未使用索引的SQL语句，尽管这个SQL语句有可能执行得挺快</p>\r\n', '', null, '0', '0', '0', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('53', null, '<p>简述一下Django与Tornado的关系与区别</p>\r\n', '5', '3', '<p>Django<br />\r\n注重高效开发<br />\r\n全自动化的管理后台（只需要使用起ORM，做简单的定义，就能自动生成数据库结构，全功能的管理后台）<br />\r\nsession功能<br />\r\nTornado<br />\r\n注重性能优越，速度快<br />\r\n解决高并发<br />\r\n异步非阻塞<br />\r\nwebsockets&nbsp;长连接<br />\r\n内嵌了HTTP服务器<br />\r\n单线程的异步网络程序，默认启动时根据CPU数量运行多个实例；利用CPU多核的优势。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('54', null, '<p>Django的model继承有几种形式，分别是什么？</p>\r\n', '5', '3', '<p>模型继承<br />\r\n一.抽象基类继承<br />\r\n二.多表格继承<br />\r\n三.代理模型<br />\r\n四.多继承</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('55', null, '<p>Scrapy中间件有几种类？</p>\r\n', '5', '4', '<p>scrapy的中间件理论上有三种<br />\r\nSchduler&nbsp;Middleware,<br />\r\nSpider&nbsp;Middleware,<br />\r\nDownloader&nbsp;Middleware，<br />\r\n在应用上一般有以下两种<br />\r\n1.爬虫中间件Spider&nbsp;Middleware<br />\r\n主要功能是在爬虫运行过程中进行一些处理.<br />\r\n2.下载器中间件Downloader&nbsp;Middleware</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('59', null, '<p>ArrayList 和HashSet 的区别,HastMap 和Hashtable 的区别?</p>\r\n', '5', '3', '<p>a) Set集合中的元素不能重复，arrayList是可以放入重复元素的 arrayList 效率较高<br />\r\nb) Hashtable是线程安全的 速度慢 &nbsp;<br />\r\nc) HashtMap是线程不安全安全的 速度快</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('60', null, '<p>Redis数据库结构有那些?</p>\r\n', '5', '1', '<p>String(字符串)，Hash(哈希)，List(列表)，Set(集合)及&nbsp;zset(sortedset:有序集合</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '3', '1');
INSERT INTO `t_question` VALUES ('61', null, '<p>redis用途</p>\r\n', '5', '1', '<p>Redis&nbsp;用到的地方很多，如我们最熟悉的分布式爬虫，Set&nbsp;去重等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('62', null, '<p>线程同步的关键字是什么?sleep0 和waito 有什么区别?怎么唤wait()停的线程?</p>\r\n', '5', '3', '<p>关键字 synchronized&nbsp;<br />\r\nb) sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。<br />\r\nc) 唤醒：notify() &nbsp;唤醒在此同步监视器上等待的单个线程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '3', '1');
INSERT INTO `t_question` VALUES ('63', null, '<p>MonggoDB中存入了100万条数据，如何提高查询速度?</p>\r\n', '5', '2', '<p>索引在很多数据库中是提高性能的标志优化手段，所以在大数据量的情况下索引可以提高数据的查&nbsp;询速度，如果没有索引&nbsp;MongoDB&nbsp;会扫描全部数据，才能获取满足条件的内容，在关系数据库中可以&nbsp;使用强制索引方式查询数据库，确保更准确快速的查询到满足条件的数据。<br />\r\n语法:<br />\r\n1、ensureIndex()&nbsp;基本语法&nbsp;1&nbsp;创建升序索引&nbsp;-1&nbsp;创建降序索引<br />\r\n2、mongodb&nbsp;默认所以字段&nbsp;_id&nbsp;,创建文档，会自动创建，此索引不能删除由&nbsp;mongodb&nbsp;自己维护<br />\r\n1、unique&nbsp;创建唯一索引，默认&nbsp;false&nbsp;，true&nbsp;必须唯一索引，否则报错<br />\r\n实例:<br />\r\n1、创建升序索引&nbsp;db.user.ensureIndex({age:1});&nbsp;db.user.find({age:{$gte:20}});</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('64', null, '<p>如何提高并发性能?</p>\r\n', '5', '4', '<p>1.动态页面静态化。&nbsp;2.制作数据库散列表，即分库分表。&nbsp;3.增加缓存。<br />\r\n4.增加镜像。<br />\r\n5.部署集群。<br />\r\n6.负载均衡。<br />\r\n7.异步读取，异步编程。&nbsp;<br />\r\n8.创建线程池和自定义连接池，将数据持久化。<br />\r\n9.把一件事，拆成若干件小事，启用线程，为每个线程分配一定的事做，多个线程同时进行把该事&nbsp;件搞定再合并。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('65', null, '<p>枚举类Enumeration和iterator的区别</p>\r\n', '5', '3', '<p>①java中的集合类都提供了返回Iterator的方法，就是迭代器，它和Enumeration的主要区别其实就是Iterator可以删除元素，但是Enumration却不能。<br />\r\n②还有一点要注意的就是，使用Iterator来遍历集合时，应使用Iterator的remove()方法来删除集合中的元素，使用集合的remove()方法将抛出ConncurrentModificationException异常。<br />\r\n③Enumeration 与 iterator 都是迭代输出的方法，Enumeration先进后出，iterator先进先出</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('66', null, '<p>谈谈你对Django框架的认识？</p>\r\n', '5', '3', '<p>Django&nbsp;太重了，除了&nbsp;web&nbsp;框架，自带&nbsp;ORM&nbsp;和模板引擎，灵活和自由度不够高;<br />\r\nDjango&nbsp;能开发小应用，但总会有&ldquo;杀鸡焉用牛刀&rdquo;的感觉;<br />\r\nDjango&nbsp;的自带&nbsp;ORM&nbsp;非常优秀，综合评价略高于&nbsp;SQLAlchemy;<br />\r\nDjango&nbsp;自带的模板引擎简单好用，但其强大程度和综合评价略低于&nbsp;Jinja;<br />\r\nDjango&nbsp;自带&nbsp;ORM&nbsp;也使&nbsp;Django&nbsp;与关系型数据库耦合度过高，如果想使用&nbsp;MongoDB&nbsp;等&nbsp;NoSQL&nbsp;数据，需要选取合适的第三方库，且总感觉&nbsp;Django+SQL&nbsp;才是天生一对的搭配，Django+NoSQL&nbsp;砍掉了&nbsp;Django&nbsp;的半壁江山;&nbsp;Django&nbsp;目前支持&nbsp;Jinja&nbsp;等', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('67', null, '<p>如何准确判断一个变量是数组类型</p>\r\n', '5', '1', '<p>.typeof操作符&nbsp;<br />\r\n这种方法对于一些常用的类型来说那算是毫无压力，比如Function、String、Number、Undefined等，但是要是检测Array的对象就不起作用了。&nbsp;<br />\r\n代码如下:<br />\r\nalert(typeof&nbsp;null);&nbsp;//&nbsp;&quot;object&quot;&nbsp;<br />\r\nalert(typeof&nbsp;function&nbsp;()&nbsp;{&nbsp;<br />\r\nreturn&nbsp;1;&nbsp;<br />\r\n});&nbsp;//&nbsp;&quot;function&quot;&nbsp;<br />\r\nalert(typeof&nbsp;&#39;梦龙小站&#39;);&nbsp;//&nbsp;&quot;string&quot;&nbsp;<br />\r\nalert(typeof&nbsp;1);&nbsp;//&nbsp;&quot;number&quot;&nbsp;<br />\r\nalert(typeof&nb', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '4', '1');
INSERT INTO `t_question` VALUES ('68', null, '<p>flask框架和Django框架的区别</p>\r\n', '5', '3', '<p>Flask&nbsp;确实很&ldquo;轻&rdquo;，不愧是&nbsp;Micro&nbsp;Framework，从&nbsp;Django&nbsp;转向&nbsp;Flask&nbsp;的开发者一定会如此感慨，&nbsp;除非二者均为深入使用过;<br />\r\n&nbsp;Flask&nbsp;自由、灵活，可扩展性强，第三方库的选择面广，开发时可以结合自己最喜欢用的轮子，也&nbsp;能结合最流行最强大的&nbsp;Python&nbsp;库;<br />\r\n&nbsp;入门简单，即便没有多少&nbsp;web&nbsp;开发经验，也能很快做出网站;<br />\r\n非常适用于小型网站;<br />\r\n&nbsp;非常适用于开发&nbsp;web&nbsp;服务的&nbsp;API;<br />\r\n&nbsp;开发大型网站无压力，但代码架构需要自己设计，开发成本取决于开发者的能力和经验;<br />\r\n&nbsp;各方面性能均等于或优于&nbsp;Django;<br />\r\n&nbsp;Django&nbsp;自带的或第三方的好评如潮的功能，Flask&nb', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '5', '2');
INSERT INTO `t_question` VALUES ('69', null, '<p>有一个无序数组，如何获取第&nbsp;K&nbsp;大的数，说下思路，实现后的时间复杂度?</p>\r\n', '5', '5', '<p>根据自己熟悉的算法说下思路，如:快排、二分法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '5', '2');
INSERT INTO `t_question` VALUES ('70', null, '<p>归并排序的时间复杂度?</p>\r\n', '5', '5', '<p>合并排序是比较复杂的排序，特别是对于不了解分治法基本思想的同学来说可能难以理解。总时间&nbsp;=分解时间+解决问题时间+合并时间。分解时间就是把一个待排序序列分解成两序列，时间为一常数，&nbsp;时间复杂度&nbsp;o(1).解决问题时间是两个递归式，把一个规模为&nbsp;n&nbsp;的问题分成两个规模分别为&nbsp;n/2&nbsp;的子问题，时间为&nbsp;2T(n/2).合并时间复杂度为&nbsp;o(n)。总时间&nbsp;T(n)=2T(n/2)+o(n).这个递归式可以用递归树&nbsp;来解，其解是&nbsp;o(nlogn).此外在最坏、最佳、平均情况下归并排序时间复杂度均为&nbsp;o(nlogn).从合并过程&nbsp;中可以看出合并排序稳定。<br />\r\n用递归树的方法解递归式&nbsp;T(n)=2T(n/2)+o(n):假设解决最后的子问题用时为常数&nbsp;c，则对于&nbsp;n&nbsp;个待&nbsp;排序记录来说整个问题的规模为&nbsp;cn。<br />\r\n从这个递归树可以看出，第一层时间代价为&nbsp;cn，第二层', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '5', '2');
INSERT INTO `t_question` VALUES ('71', null, '<p>如何理解反射</p>\r\n', '5', '5', '<p>①Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制<br />\r\n②反射的作用是可以获取一个运行状态下的类里面所有信息（类的实例，构造，方法，属性等）<br />\r\n③反射的应用场景：框架的配置文件都是通过反射来生成对象的，还有动态代理的底层就是反射实现的.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '6', '2');
INSERT INTO `t_question` VALUES ('72', null, '<p>Array和ArrayList区别</p>\r\n', '5', '3', '<p>同构的对象是指类型相同的对象，若声明为int[]的数组就只能存放整形数据,string[]只能存放字符型数据,但声明为object[]的数组除外。<br />\r\n而ArrayList可以存放任何不同类型的数据（因为它里面存放的都是被装箱了的Object型对象，实际上ArrayList内部就是使用&quot;object[] _items;&quot;这样一个私有字段来封装对象的）<br />\r\n3 在CLR托管对中的存放方式<br />\r\nArray是始终是连续存放的，而ArrayList的存放不一定连续。<br />\r\n4 初始化大小<br />\r\nArray对象的初始化必须只定指定大小，且创建后的数组大小是固定的，</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '6', '2');
INSERT INTO `t_question` VALUES ('73', null, '<p>什么是xml</p>\r\n', '5', '3', '<p>①可扩展标记语言，标准通用标记语言的子集，是一种用于标记电子文件使其具有结构性的标记语言<br />\r\n②用途：开发中用来传递数据，共享数据的。Webservice也用xml来传递数据。<br />\r\n③扩展，json和xml的区别：http://www.cnblogs.com/SanMaoSpace/p/3139186.html</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '6', '2');
INSERT INTO `t_question` VALUES ('74', null, '<p>xml的解析方式</p>\r\n', '5', '3', '<p>xml的解析方式有多种，我们课内学了dom和sax解析，以及第三方dom4j,除了这几种以外Android有自己的独特解析方式pull解析，接下来再讲解一下这几种解析方式的不同。<br />\r\nDOM方式<br />\r\n&bull; 原理：基于文档驱动，是先把dom全部文件读入到内存中，构建一个主流内存的树结构，然后使用DOM的API遍历所有数据，调用API检索想要的数据和操作数据。<br />\r\n所以，DOM方式的优缺点是：<br />\r\n&bull; 特点：<br />\r\n优点：整个文档树存在内存中，可对XML文档进行操作：删除、修改等等；可多次访问已解析的文档；由于在内存中以树形结构存放，因此检索和更新效率会更高。；<br />\r\n缺点：解析 XML 文件时会将整个 XML 文件的内容解析成树型结构存放在内存中并创建新对象，比较消耗时间和内存；<br />\r\n&bull; 使用情境<br />\r\n对于像手机这样的移动设备来讲，内存是非常有限的，在XML文档比较小、需要对解析文档进行一定的操作且一旦解析了文档需要多次访问这些数据的情况下可以考虑使用DOM方式，因为其检索和解析', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '7', '7', '2');
INSERT INTO `t_question` VALUES ('75', null, '<p>Java中sleep和wait的区别</p>\r\n', '5', '3', '<p>sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '7', '7', '2');
INSERT INTO `t_question` VALUES ('76', null, '<p>我们能将int 强制转换为byte 类型的变量吗? 如果该变量大于byte 类型的范围消会出现什么现象？</p>\r\n', '5', '2', '<p>a) 可以强制转换 超出范围会溢出</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '7', '2');
INSERT INTO `t_question` VALUES ('77', null, '<p>二叉树</p>\r\n', '5', '1', '<p>二叉树主要需要掌握遍历，先序、中序、后序</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('78', null, '<p>a=a+b 与a+=b 的区别?</p>\r\n', '5', '2', '<p>&nbsp;+= 结合了强制类型转换的功能 a+=b;执行的时候效率高</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '2', '1');
INSERT INTO `t_question` VALUES ('79', null, '<p>抽象类和接口的区别</p>\r\n', '5', '1', '<p>1、抽象类和接口都不能直接实例化，如果要实例化，抽象类变量必须指向实现所有抽象方法的子类对象，接口变量必须指向实现所有接口方法的类对象。2、抽象类要被子类继承，接口要被类实现。3、接口只能做方法申明，抽象类中可以做方法申明，也可以做方法实现4、接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量。5、抽象类里的抽象方法必须全部被子类所实现，如果子类不能全部实现父类抽象方法，那么该子类只能是抽象类。同样，一个实现接口的时候，如不能全部实现接口方法，那么该类也只能为抽象类。6、抽象方法只能申明，不能实现，接口是设计的结果 ，抽象类是重构的结果7、抽象类里可以没有抽象方法8、如果一个类里有抽象方法，那么这个类只能是抽象类 9、抽象方法要被实现，所以不能是静态的，也不能是私有的。10、接口可继承接口，并可多继承接口，但类只能单根继承。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '2', '1');
INSERT INTO `t_question` VALUES ('80', null, '<p>Arraylist如何扩容？ArrayList和LinkedList的区别，结合说原理说？</p>\r\n', '5', '1', '<p>当数组容量满时数组会自动一当前数组容量的2倍扩容，1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '3', '1');
INSERT INTO `t_question` VALUES ('82', null, '<p>mysql和mongodb的区别&nbsp;</p>\r\n', '5', '4', '<p>一、<br />\r\n1、基于分布式文件存储<br />\r\n2、高负载情况下添加更多节点，可以保证服务器性能<br />\r\n3、将数据存储为一个文档<br />\r\n二、比较<br />\r\n1、稳定性<br />\r\n2、索引，索引放在内存中，能够提升随机读写的性能。如果索引不能完全放在内存，一旦出现随机读写比较高的时候，就会频繁地进行磁盘交换，MongoDB的性能就会急剧下降<br />\r\n3、占用的空间很大，因为它属于典型空间换时间原则的类型。那么它的磁盘空间比普通数据库会浪费一些，而且到目前为止它还没有实现在线压缩功能，<br />\r\n在MongoDB中频繁的进行数据增删改时，如果记录变了，例如数据大小发生了变化，这时候容易产生一些数据碎片，出现碎片引发的结果，<br />\r\n一个是索引会出现性能问题，<br />\r\n另外一个就是在一定的时间后，所占空间会莫明其妙地增大，所以要定期把数据库做修复，定期重新做索引，这样会提升MongoDB的稳定性和效率。<br />\r\n在最新的版本里，它已经在实现在线压缩，估计应该在2.0版左右，应该能够实现在线压缩，可以在后台执行现在repair', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '3', '1');
INSERT INTO `t_question` VALUES ('83', null, '<p>我能在不进行强制转换的情况下将一个double 值赋值给long类型的变量吗?</p>\r\n', '5', '2', '<p>a) 不能 double范围比long的范围大</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('84', null, '<p>对https的了解？为什么安全</p>\r\n', '5', '3', '<p>HTTPS其实就是在HTTP跟TCP中间加多了一层加密层TLS/SSL。SSL是个加密套件，负责对HTTP的数据进行加密。TLS是SSL的升级版。现在提到HTTPS，加密套件基本指的是TLS。原先是应用层将数据直接给到TCP进行传输，现在改成应用层将数据给到TLS/SSL，将数据加密后，再给到TCP进行传输。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '4', '1');
INSERT INTO `t_question` VALUES ('85', null, '<p>3*0.1 ==0.3 将会返画什么? true 还是false?</p>\r\n', '5', '2', '<p>) False, 因为有些浮点数不能完全精确的表示出来</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('86', null, '<p>实现模拟登录的方式</p>\r\n', '5', '1', '<p>1)&nbsp;使用一个具有登录状态的cookie，结合请求报头一起发送，可以直接发送get请求，访问登录后才能访问的页面。<br />\r\n2)&nbsp;先发送登录界面的get请求，在登录页面HTML里获取登录需要的数据（如果需要的话），然后结合账户密码，再发送post请求，即可登录成功。然后根据获取的cookie信息，继续访问之后的页面。</p>\r\n\r\n<p>3) 如果有验证码，还需要处理验证码</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('87', null, '<p>int 和Integer 哪个会占用更多的内存?</p>\r\n', '5', '3', '<p>a) Integer 对象会占用更多的内存。Integer 是一个对象，需要存储对象的元数据。<br />\r\nb) 但是 int 是一个原始类型的数据，所以占用的空间更少。<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('88', null, '<p>a==b和&quot;a.equals(b)有什么区别</p>\r\n', '5', '3', '<p>a) a 和 b 都是对象，则 a==b 是比较两个对象的引用，只有当 a 和 b 指向的是堆中的同一个对象才会返回 true，而 a.equals(b) 是进行逻辑比较，当内容相同时，返回true，所以通常需要重写该方法来提供逻辑一致性的比较。例如，String 类重写 equals() 方法，所以可以用于两个不同对象，但是包含的字母相同的比较。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('89', null, '<p>加入solr索引库存满了，怎么办？</p>\r\n', '5', '5', '<p>在data-config.xml文件&lt;dataSource&gt;标签里添加batchSize=&quot;-1&quot;；</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('90', null, '<p>反爬虫措施？</p>\r\n', '5', '2', '<p>1.&nbsp;添加代理<br />\r\n2.&nbsp;降低访问频率<br />\r\n3.&nbsp;User-Agent<br />\r\n4.&nbsp;动态HTML数据加载<br />\r\n5.&nbsp;验证码处理</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('91', null, '<p>Java序列化与反序列化是什么？为什么需要序列化与反序列化？如何实现Java序列化与反序列化？</p>\r\n', '5', '1', '<p>序列化：把对象转换为字节序列的过程称为对象的序列化。反序列化：把字节序列恢复为对象的过程称为对象的反序列化。当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；当你想用套接字在网络上传送对象的时候；当你想通过RMI传输对象的时候；都需要序列化；实现Serializable接口即可实现序列化</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('92', null, '<p>写一个原型链继承的例子</p>\r\n', '5', '1', '<p><br />\r\nfunction&nbsp;A(){<br />\r\n<br />\r\n　　this.name=&quot;zhangsan&quot;;<br />\r\n<br />\r\n}<br />\r\n<br />\r\nA.prototype.getName=function(){<br />\r\n<br />\r\n&nbsp;　　return&nbsp;this.name;<br />\r\n<br />\r\n}<br />\r\n<br />\r\nfunction&nbsp;B(){<br />\r\n<br />\r\n　　this.age=20;<br />\r\n<br />\r\n}</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('93', null, '<p>final.finalize 和finally 的区别</p>\r\n', '5', '3', '<p>a) final为用于标识常量的关键字，final标识的关键字存储在常量池中（在这里final常量的具体用法将在下面进行介绍）；<br />\r\nb) finalize()方法在Object中进行了定义，用于在对象&ldquo;消失&rdquo;时，由JVM进行调用用于对对象进行垃圾回收，类似于C++中的析构函数；用户自定义时，用于释放对象占用的资源（比如进行I/0操作）；<br />\r\nc) finally{}用于标识代码块，与try{}进行配合，不论try中的代码执行完或没有执行完（这里指有异常），该代码块之中的程序必定会进行；</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('94', null, '<p>举例说说几个排序，并说明其排序原理&nbsp;</p>\r\n', '5', '1', '<p>冒泡、快速、二分等等，拿个冒泡举个例子/*<br />\r\n&nbsp;* 冒泡排序<br />\r\n&nbsp;*/<br />\r\npublic class BubbleSort {<br />\r\n　　public static void main(String[] args) {<br />\r\n　　　　int[] arr={6,3,8,2,9,1};<br />\r\n　　　　System.out.println(&quot;排序前数组为：&quot;);<br />\r\n　　　　for(int num:arr){<br />\r\n　　　　　　System.out.print(num+&quot; &quot;);<br />\r\n　　　　}<br />\r\n　　　　for(int i=0;i&lt;arr.length-1;i++){//外层循环控制排序趟数<br />\r\n　　　　　　for(int j=0;j&lt;arr.length-1-i;j++){//内层循环控制每一趟排序多少次<br />\r\n　　　　　　　　if(arr[j]&gt;arr[j+1]){<br />\r\n　　　　', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('95', null, '<p>谈谈你对NIO的理解</p>\r\n', '5', '1', '<p>NIO 的创建目的是为了让 Java 程序员可以实现高速 I/O 而无需编写自定义的本机代码。NIO 将最耗时的 I/O 操作(即填充和提取缓冲区)转移回操作系统，因而可以极大地提高速度。<br />\r\nNIO最重要的组成部分<br />\r\n通道 Channels<br />\r\n缓冲区 Buffers<br />\r\n选择器 SelectorsBuffer 是一个对象， 它包含一些要写入或者刚读出的数据。Channel是一个对象，可以通过它读取和写入数据</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('96', null, '<p>List.Set.Map 和Queue之间的区别</p>\r\n', '5', '3', '<p>a) list 和set 有共同的父类 它们的用法也是一样的 唯一的不太就是set中不能有相同的元素 list中可以<br />\r\nb) list和set的用途非常广泛 list可以完全代替数组来使用<br />\r\nc) map 是独立的合集 它使用键值对的方式来储存数据 键不能有重复的 值可以用&nbsp;<br />\r\nd) map不像上边两种集合那个用的广泛 不过在servlet 和jsp中 map可是绝对的重中之重 页面之间传值全靠map<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('97', null, '<p>.随便说说几个单例模式，并选择一种线程安全的</p>\r\n', '5', '1', '<p>（懒汉，线程安全）：<br />\r\npublic class SingletonDemo2 {<br />\r\n&nbsp; &nbsp; private static SingletonDemo2 instance;<br />\r\n&nbsp; &nbsp; private SingletonDemo2(){}<br />\r\n&nbsp; &nbsp; public static synchronized SingletonDemo2 getInstance(){<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; if (instance == null) {<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; instance = new SingletonDemo2();<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; }<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; return instance;<br />\r\n&nbsp; &nbsp; }<br />\r\n}<', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('98', null, '<p>描述new一个对象的过程</p>\r\n', '5', '1', '<p>&nbsp;1.&nbsp;定义构造函数；<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;2.&nbsp;通过new来创建对象实例。<br />\r\n<br />\r\n当我们使用new新建一个对象的时候，以new&nbsp;foo(...)为例：<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;1.&nbsp;一个新的对象被创建，同时继承了对象类型的原型，即foo.prototype；<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;2.&nbsp;执行对象类型的构造函数，同时该实例的属性和方法被this所引用，即this指向新构造的实例；<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;3.&nbsp;如果构造函数return了一个新的&ldquo;对象&rdquo;，那么这个对象就会取代整个new出来的结果。如果构造函数没有return对象，那么就会返回步骤1所创建的对象，即隐式返回this。（一般情况下构造函数不会返回任何值，不过在一些特殊情况下，如果用户想', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('99', null, '<p>重写equals为何要重写hashCode？</p>\r\n', '5', '1', '<p>不重写hashcode，equals方法还是用的原始的==</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('100', null, '<p>OOM你遇到过哪些情况？你是怎么搞定的？</p>\r\n', '5', '2', '<p>如果是内存泄漏，可进一步通过工具查看泄漏对象到GC Roots的引用链。于是就能找到泄漏对象时通过怎样的路径与GC Roots相关联并导致垃圾收集器无法自动回收。<br />\r\n如果不存在泄漏，那就应该检查虚拟机的参数(-Xmx与-Xms)的设置是否适当。<br />\r\n&nbsp;&nbsp;b. 虚拟机栈和本地方法栈溢出<br />\r\n如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。<br />\r\n如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常<br />\r\n这里需要注意当栈的大小越大可分配的线程数就越少。<br />\r\n&nbsp;&nbsp;c. 运行时常量池溢出<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;异常信息：java.lang.OutOfMemoryError:PermGen space<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如果要向运行时常量池中添加内容，最简单的做法就是使用Stri', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('101', null, '<p>arralylist的扩容问题</p>\r\n', '5', '1', '<p>1、ArrayList的原始大小size + 将要插入集合的大小numNew = 得到扩充后ArrayList的最小长度minCapacity&nbsp;<br />\r\n2、如果ArrayList的原始大小size为0，即ArrayList为空，ArrayList扩充后的最小长度minCapacity= Math.max(10, minCapacity)，也就是说扩充后的最小长度minCapacity，并不仅仅是原始长度size加上插入集合的长度numNew。&nbsp;<br />\r\n3、上面得到的扩充后最小长度minCapacity，并不是最终扩充后的长度，还需要进一步进行计算。&nbsp;<br />\r\n（1）得到ArrayList的原始大小oldCapacity&nbsp;<br />\r\n（2）得到新的扩充后的大小：newCapacity = oldCapacity*1.5；&nbsp;<br />\r\n（3）将上面计算的扩充后的最小长度minCapacity与这里得到的扩充后的大小newCapacity进行比较，取较大的那个最为最终扩充后的大小。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('102', null, '<p>scrapy的异步处理</p>\r\n', '5', '1', '<p>scrapy框架的异步机制是基于twisted异步网络框架处理的，在settings.py文件里可以设置具体的并发量数值（默认是并发量16）。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('103', null, '<p>synchronized 和 ReentrantLock 有什么不同</p>\r\n', '5', '2', '<p>时，首先要尝试获取对象锁。如果这个对象没被锁定，或者当前线程已经拥有了那个对象锁，把锁的计算器加1，相应的，在执行monitorexit指令时会将锁计算器就减1，当计算器为0时，锁就被释放了。如果获取对象锁失败，那当前线程就要阻塞，直到对象锁被另一个线程释放为止。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c. ReentrantLock由于ReentrantLock是java.util.concurrent包下提供的一套互斥锁，相比Synchronized，ReentrantLock类提供了一些高级功能，主要有以下3项：<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.等待可中断，持有锁的线程长期不释放的时候，正在等待的线程可以选择放弃等待，这相当于Synchronized来说可以避免出现死锁的情况。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.公平锁，多个线程等待同一个锁时，必须按照申请', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('104', null, '<p>hash碰撞</p>\r\n', '5', '2', '<p>&nbsp;（1）开放地址法</p>\r\n\r\n<p>&nbsp; （2）拉链法</p>\r\n\r\n<p>&nbsp; （3）再哈希法</p>\r\n\r\n<p>&nbsp; （4）建立公共溢出区</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('105', null, '<p>Error 和 Exception有什么区别</p>\r\n', '5', '2', '<p>Error类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢出等。如java.lang.StackOverFlowError和Java.lang.OutOfMemoryError。对于这类错误，Java编译器不去检查他们。对于这类错误的导致的应用程序中断，仅靠程序本身无法恢复和预防，遇到这样的错误，建议让程序终止。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Exception类表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，使程序恢复运行，而不应该随意终止异常。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('106', null, '<p>闭包的作用域</p>\r\n', '5', '2', '<p>先来谈谈变量的作用域&nbsp;<br />\r\n变量的作用域无非就是两种：全局变量和局部变量。&nbsp;<br />\r\n全局作用域：&nbsp;<br />\r\n最外层函数定义的变量拥有全局作用域，即对任何内部函数来说，都是可以访问的：</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('107', null, '<p>Post和get区别</p>\r\n', '5', '2', '<p>get:从指定的服务器中获取数据。<br />\r\n&nbsp;&nbsp;GET请求能够被缓存<br />\r\n&nbsp;&nbsp;GET请求会保存在浏览器的浏览记录中<br />\r\n&nbsp;&nbsp;以GET请求的URL能够保存为浏览器书签<br />\r\n&nbsp;&nbsp;GET请求有长度限制<br />\r\n&nbsp;&nbsp;GET请求主要用以获取数据<br />\r\n&nbsp;post:<br />\r\n&nbsp;&nbsp;POST请求不能被缓存下来<br />\r\n&nbsp;&nbsp;POST请求不会保存在浏览器浏览记录中<br />\r\n&nbsp;&nbsp;以POST请求的URL无法保存为浏览器书签<br />\r\n&nbsp;&nbsp;POST请求没有长度限制<br />\r\n&nbsp;&nbsp;POST请求会把请求的数据放置在HTTP请求包的包体中,POST的安全性比GET的高.可能修改变服务器上的资源的请求.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('108', null, '<p>什么是 异常链</p>\r\n', '5', '2', '<p>a.常常会再捕获一个异常后跑出另外一个异常，并且希望把异常原始信息保存下来，这被称为异常链。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;b.在JDK1.4以前，程序员必须自己编写代码来保存原始异常信息，<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;c.现在所有Throwable的子类子构造器中都可以接受一个cause对象作为参数，这个cause就异常原由，代表着原始异常，即使在当前位置创建并抛出行的异常，也可以通过这个cause追踪到异常最初发生的位置。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;d.Throwable类及其所有的子类都提供了带cause参数的构造器，其他的异常类就只有通过initCause()来设置cause了。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('109', null, '<p>悲观锁和乐观锁？</p>\r\n', '5', '3', '<p>悲观锁(Pessimistic&nbsp;Lock),&nbsp;顾名思义，就是很悲观，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会block直到它拿到锁。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。<br />\r\n<br />\r\n<br />\r\n<br />\r\n乐观锁(Optimistic&nbsp;Lock),&nbsp;顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号等机制。乐观锁适用于多读的应用类型，这样可以提高吞吐量，像数据库如果提供类似于write_condition机制的其实都是提供的乐观锁。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('110', null, '<p>并发线程的应用</p>\r\n', '5', '2', '<p>1、吞吐量：你做WEB，容器帮你做了多线程，但是他只能帮你做请求层面的。简单的说，可能就是一个请求一个线程。或多个请求一个线程。如果是单线程，那同时只能处理一个用户的请求。</p>\r\n\r\n<p>2、伸缩性：也就是说，你可以通过增加CPU核数来提升性能。如果是单线程，那程序执行到死也就利用了单核，肯定没办法通过增加CPU核数来提升性能。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('111', null, '<p>java中有哪些锁</p>\r\n', '5', '3', '<p>java重要有这些锁：偏向锁、轻量级锁、重量级锁、读写锁、重入锁、共享锁、独占锁、自旋锁、公平锁、非公平锁、死锁、活锁</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('112', null, '<p>Celery中broker的功能，异步任务的原理？</p>\r\n', '5', '3', '<p>Celery的broker其实通常是指消息队列，对消息进行接收和分发一个对象。异步任务原理本质上是把每个任务解耦，利用多进程、多线程、协程执行任务</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('113', null, '<p>库存超发怎么解决？</p>\r\n', '5', '3', '<p>1.悲观锁锁表。2.采用乐观锁，数据库设置版本号字段，增减库存的时候，通过判断版本号来减库存</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('114', null, '<p>冒泡排序、二分算法</p>\r\n', '5', '2', '<p>1.冒泡排序</p>\r\n\r\n<p>解析：1.比较相邻的两个元素，如果前一个比后一个大，则交换位置。</p>\r\n\r\n<p>　　　2.第一轮的时候最后一个元素应该是最大的一个。</p>\r\n\r\n<p>　　　3.按照步骤一的方法进行相邻两个元素的比较，这个时候由于最后一个元素已经是最大的了，所以最后一个元素不用比较。</p>\r\n\r\n<p>2.二分查找</p>\r\n\r\n<p>解析：二分查找，也为折半查找。首先要找到一个中间值，通过与中间值比较，大的放又，小的放在左边。再在两边中寻找中间值，持续以上操作，直到找到所在位置为止。</p>\r\n\r\n<p>（1）递归方法<br />\r\n（2）非递归方法</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('115', null, '<p>什么是重入锁</p>\r\n', '5', '3', '<p>举个例子可能更容易理解，如果线程A获取到了锁S，线程A再次进入的时候任然可以获取到锁S，只不过是获取锁的次数会增加1，java中的Lock锁的实现类ReentrantLock就是一个可重入锁，它具体的实现是更具AQS框架来实现的，AQS实现锁的本质是通过CAS算法实现的，CAS的优点是减少线程时间的切换，提高了效率，缺点是会出现ABA问题</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('116', null, '<p>把session放到redis我为什么要这样干？</p>\r\n', '5', '2', '<p>解决分布式系统session不能共享的问题</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('117', null, '<p>说下你对nginx的理解？</p>\r\n', '5', '2', '<p>1放置静态资源，（html+js+css+图片），2实现负载均衡。3&nbsp;反向代理</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('118', null, '<p>ABA问题怎么解决</p>\r\n', '5', '3', '<p>ABA问题是指在CAS操作时，其他线程将变量值A改为了B，但是又被改回了A，等到本线程使用期望值A与当前变量进行比较时，发现变量A没有变，于是CAS就将A值进行了交换操作，但是实际上该值已经被其他线程改变过，这与乐观锁的设计思想不符合。ABA问题的解决思路是，每次变量更新的时候把变量的版本号加1，那么A-B-A就会变成A1-B2-A3，只要变量被某一线程修改过，改变量对应的版本号就会发生递增变化，从而解决了ABA问题</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('119', null, '<p>数据库分页我要第二页的十条数据该怎么写？</p>\r\n', '5', '1', '<p>select&nbsp;*&nbsp;from&nbsp;table&nbsp;limit&nbsp;10,10</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('122', null, '<p>工作流由哪些主要结构组成？</p>\r\n', '5', '2', '<p>Activiti工作流引擎数据库表结构<br />\r\n数据库表的命名<br />\r\nAcitiviti数据库中表的命名都是以ACT_开头的。第二部分是一个两个字符用例表的标识。此用例大体与服务API是匹配的。<br />\r\nl &nbsp;ACT_RE_*:&rsquo;RE&rsquo;表示repository。带此前缀的表包含的是静态信息，如，流程定义，流程的资源（图片，规则等）。<br />\r\nl &nbsp;ACT_RU_*:&rsquo;RU&rsquo;表示runtime。这是运行时的表存储着流程变量，用户任务，变量，职责（job）等运行时的数据。Activiti只存储实例执行期间的运行时数据，当流程实例结束时，将删除这些记录。这就保证了这些运行时的表小且快。<br />\r\nl &nbsp;ACT_ID_*:&rsquo;ID&rsquo;表示identity。这些表包含标识的信息，如用户，用户组，等等。<br />\r\nl &nbsp;ACT_HI_*:&rsquo;HI&rsquo;表示history。就是这些表包含着历史的相关数据，如结束的流程实例，变量，任务，等', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('123', null, '<p>假如现在有10万条电话号码的数据，怎么能导入到redis服务器中？需要考虑什么问题吗？</p>\r\n', '5', '3', '<p>这个必须要考虑内存溢出的问题，我们可以不考虑效率，因为这些数据都是提前导入到系统中的，考虑到内存溢出，我们可以创建一个阻塞队列，把数据读入到阻塞队列中，然后从阻塞队列中把数据在导入到redis服务器中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('126', null, '<p>Tomcat内存参数在哪个文件配置?tomcat 端口号在哪个文件配置？</p>\r\n', '5', '2', '<p>/bin/catalina.bat server.xml</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('127', null, '<p>是否了解连接池，使用连接池有什么好处？</p>\r\n', '5', '2', '<p>数据库连接是非常消耗资源的，影响到程序的性能指标。连接池是用来分配、管理、释放数据库连接的，可以使应用程序重复使用同一个数据库连接，而不是每次都创建一个新的数据库连接。通过释放空闲时间较长的数据库连接避免数据库因为创建太多的连接而造成的连接遗漏问题，提高了程序性能</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('128', null, '<p>Django中 使用celery发送邮件 发送不出去，怎么解决？</p>\r\n', '5', '5', '<p>&nbsp;Celery 自带消息队列 发送成功会有回调功能 判断是否发送成功 如果成功就会删除消息队列的东西 如果不成功 他会接着发还有一种情况就是 公司邮箱本身有问题 差文档多健 日志 多分析</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('129', null, '<p>1.Iterator和ListIterator的区别是什么？</p>\r\n', '5', '2', '<p>1.ListIterator只能用于List，Iterator是通用的<br />\r\n2.Iterator容易引起并发修改异常问题，而ListIterator可以避免线程安全问题的发生，因为其有内置的add()等修改集合的方法<br />\r\n3. ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。&nbsp;</p>\r\n\r\n<p>4. ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。&nbsp;</p>\r\n\r\n<p>5. 都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iierator仅能遍历，不能修改。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('130', null, '<p>闭包的解释</p>\r\n', '5', '2', '<p>一个拥有许多变量和绑定了这些变量的环境的表达式（通常是一个函数），因而这些变量也是该表达式的一部分。闭包的特点：<br />\r\n　　1.&nbsp;作为一个函数变量的一个引用，当函数返回时，其处于激活状态。<br />\r\n　　2.&nbsp;一个闭包就是当一个函数返回时，一个没有释放资源的栈区。<br />\r\n　　简单的说，Javascript允许使用内部函数---即函数定义和函数表达式位于另一个函数的函数体内。而且，这些内部函数可以访问它们所在的外部函数中声明的所有局部变量、参数和声明的其他内部函数。当其中一个这样的内部函数在包含它们的外部函数之外被调用时，就会形成闭包。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('131', null, '<p>Java 中怎么获取一份线程 dump 文件？</p>\r\n', '5', '2', '<p>指令获取： jstack -l pid。<br />\r\n【抓dump】<br />\r\n1、一般抓法<br />\r\nadplus -hang -p 3230 -quiet 抓3230 pid进程，hang模式，相当于把那个进程暂停住，取内存快照<br />\r\nadplus -crash -pn w3wp -quiet 抓w3wp进程，crash模式，当那个进程崩溃结束的时候自动抓取当时的内存<br />\r\nadplus -hang -iis -quiet 抓IIS相关进程，包括其上host的web应用，以及iis自身<br />\r\n2、抓window服务3、远程抓<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('133', null, '<p>vue的优点是什么？</p>\r\n', '5', '2', '<p>(1)低耦合。视图（View）可以独立于Model变化和修改，一个ViewModel可以绑定到不同的&quot;View&quot;上，当View变化的时候Model可以不变，当Model变化的时候View也可以不变。(2)可重用性。你可以把一些视图逻辑放在一个ViewModel里面，让很多view重用这段视图逻辑。(3)独立开发。开发人员可以专注于业务逻辑和数据的开发（ViewModel），设计人员可以专注于页面设计，使用Expression Blend可以很容易设计界面并生成xml代码。(4)可测试。界面素来是比较难于测试的，而现在测试可以针对ViewModel来写。(5)组件之间的传值(6)路由之间跳转</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('134', null, '<p>高并发情况下提升页面加载速度的方案？</p>\r\n', '5', '3', '<p>高并发是什么？简单点说，就是同一时间内，大量的请求服务器，这个大量一般是指千万级以上的请求次数。<br />\r\n不要被&ldquo;高并发&rdquo;这3个字吓到，一个系统真正需要高并发的地方并不多，可能是一个接口或者几个接口，但这部分功能很重要。<br />\r\n1.Nginx要做负载均衡&nbsp;<br />\r\n2.程序层面做多线程，锁等机制&nbsp;<br />\r\n3.数据库层面处理，mysql+redis&nbsp;<br />\r\n4.服务器配置要尽量高</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('135', null, '<p>Tcp协议和udp协议有什么区别？</p>\r\n', '5', '2', '<p>（1）TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接<br />\r\n（2）每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;（3）TCP首部开销20字节;UDP的首部开销小，只有8个字节<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;（4）TCP的逻辑通信信道是全双工的可靠信道，UDP则是不可靠信道</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('136', null, '<p>超卖情况的解决？</p>\r\n', '5', '5', '<p>1000个人同时秒杀10 份商品，用队列的方式储存10 个，如果超过 10 条,直接已结束返回页面给用户，如果没有超过10 条，则用户可进入填写，订单及确认页面。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('137', null, '<p>Vector,ArrayList,LinkedList之间的区别</p>\r\n', '5', '2', '<p>(1)同步性&nbsp;<br />\r\nArrayList,LinkedList是不同步的，而Vestor是同步的。所以如果不要求线程安全的话，可以使用ArrayList或LinkedList，可以节省为同步而耗费的开销。但在多线程的情况下，有时候就不得不使用Vector了。当然，也可以通过一些办法包装ArrayList,LinkedList，使他们也达到同步，但效率可能会有所降低。<br />\r\n(2)数据增长&nbsp;<br />\r\n从内部实现机制来讲ArrayList和Vector都是使用Objec的数组形式来存储的。当你向这两种类型中增加元素的时候，如果元素的数目超出了内部数组目前的长度它们都需要扩展内部数组的长度，Vector缺省情况下自动增长原来一倍的数组长度，ArrayList是原来的50%,所以最后你获得的这个集合所占的空间总是比你实际需要的要大。所以如果你要在集合中保存大量的数据那么使用Vector有一些优势，因为你可以通过设置集合的初始化大小来避免不必要的资源开销。<br />\r\n(3)检索、插入、删除对象的效率<br />\r\nArrayList和Vecto', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('138', null, '<p>mysql事务的特性</p>\r\n', '5', '1', '<p>（1）原子性(Atomicity)：事务中的全部操作在数据库中是不可分割的，要么全部完成，要么均不执行。<br />\r\n（2）一致性(Consistency)：几个并行执行的事务，其执行结果必须与按某一顺序串行执行的结果相一致。<br />\r\n（3）隔离性(Isolation)：事务的执行不受其他事务的干扰，事务执行的中间结果对其他事务必须是透明的。<br />\r\n（4）持久性(Durability)：对于任意已提交事务，系统必须保证该事务对数据库的改变不被丢失，即使数据库出现故障</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('139', null, '<p>你对乐观锁和悲观锁有了解吗？</p>\r\n', '5', '2', '<p>悲观锁(Pessimistic Lock), 顾名思义，就是很悲观，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会block直到它拿到锁。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。它指的是对数据被外界（包括本系统当前的其他事务，以及来自外部系统的事务处理）修改持保守态度，因此，在整个数据处理过程中，将数据处于锁定状态。悲观锁的实现，往往依靠数据库提供的锁机制（也只有数据库层提供的锁机制才能真正保证数据访问的排他性，否则，即使在本系统中实现了加锁机制，也无法保证外部系统不会修改数据）。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp; 乐观锁(Optimistic Lock), 顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号等机制。乐观锁适用于多读的应用类型，这样可以提高吞吐量，像数据库如果提供类似于write_condition机制的其实都是提供的乐', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('140', null, '<p>redis&nbsp;和&nbsp;mysql&nbsp;的区别</p>\r\n', '5', '3', '<p>readis&nbsp;是内存数据库，&nbsp;数据保存在内存中，&nbsp;速度快。<br />\r\nmysql&nbsp;是关系型数据库，持久化存储，存放在磁盘里面，功能强大。检索的话，&nbsp;会涉及到一定的&nbsp;IO，&nbsp;数据访问也就慢。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('141', null, '<p>什么是视图？以及视图的使用场景有哪些？</p>\r\n', '5', '2', '<p>视图是一种基于数据表的一种虚表。(1)视图是一种虚表。(2)视图建立在已有表的基础上, 视图赖以建立的这些表称为基表。(3)向视图提供数据内容的语句为 SELECT 语句,可以将视图理解为存储起来的 SELECT 语句。(4)视图向用户提供基表数据的另一种表现形式。(5)视图没有存储真正的数据，真正的数据还是存储在基表中。(6)程序员虽然操作的是视图，但最终视图还会转成操作基表。(7)一个基表可以有0个或多个视图有的时候，我们可能只关系一张数据表中的某些字段，而另外的一些人只关系同一张数据表的某些字段...那么把全部的字段都都显示给他们看，这是不合理的。我们应该做到：他们想看到什么样的数据，我们就给他们什么样的数据...一方面就能够让他们只关注自己的数据，另一方面，我们也保证数据表一些保密的数据不会泄露出来...我们在查询数据的时候，常常需要编写非常长的SQL语句，几乎每次都要写很长很长....上面已经说了，视图就是基于查询的一种虚表，也就是说，视图可以将查询出来的数据进行封装。。。那么我们在使用的时候就会变得非常方便...值得注意的是：使用视图可以让我们专注与逻辑，但不提高查询', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('142', null, '<p>对事物的理解，怎么应用的，为什么使用事务</p>\r\n', '5', '2', '<p><br />\r\n&nbsp; &nbsp;&nbsp;<br />\r\nAtomic（原子性）：事务中的所有元素作为一个整体提交或回滚，事务的个元素是不可分的，事务是一个完整操作。</p>\r\n\r\n<p>&nbsp; &nbsp;&nbsp;<br />\r\nConsistency（一致性）：只有合法的数据可以被写入数据库，否则事务应该将其回滚到最初状态。事物完成时和事物开始之前，数据存储中的数据处于一致状态。保证数据的无损。</p>\r\n\r\n<p>&nbsp; &nbsp;&nbsp;<br />\r\nIsolation（隔离性）：事务允许多个用户对同一个数据进行并发访问，而不破坏数据的正确性和完整性。同时，并行事务的修改必须与其他并行事务的修改相互独立。事务查看数据时数据所处的状态，要么是另一并发事务修改它之前的状态，要么是另一事务修改它之后的状态，事务不会查看中间状态的数据。</p>\r\n\r\n<p>&nbsp; &nbsp;&nbsp;<br />\r\nDurability（持久性）：事务结束后，事务处理的结果必须能够得到固化。它对于系统的影响是永久性的。该修改即使出现致命的系统故障也将', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('144', null, '<p>数据库优化方案</p>\r\n', '5', '3', '<p>优化索引、SQL&nbsp;语句、分析慢查询<br />\r\n设计表的时候严格根据数据库的设计范式来设计数据库<br />\r\n使用缓存，把经常访问到的数据而且不需要经常变化的数据放在缓存中，能节约磁盘IO<br />\r\n优化硬件；采用SSD，使用磁盘队列技术(RAID0,RAID1,RDID5)等；<br />\r\n采用MySQL&nbsp;内部自带的表分区技术，把数据分层不同的文件，能够提高磁盘的读取效率<br />\r\n垂直分表；把一些不经常读的数据放在一张表里，节约磁盘I/O<br />\r\n主从分离读写；采用主从复制把数据库的读操作和写入操作分离开来<br />\r\n分库分表分机器（数据量特别大），主要的的原理就是数据路由<br />\r\n选择合适的表引擎，参数上的优化<br />\r\n进行架构级别的缓存，静态化和分布式<br />\r\n不采用全文索引</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('145', null, '<p>事物的传播行为</p>\r\n', '5', '2', '<p>1、PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。</p>\r\n\r\n<p>2、PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。&lsquo;</p>\r\n\r\n<p>3、PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。</p>\r\n\r\n<p>4、PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。</p>\r\n\r\n<p>5、PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。</p>\r\n\r\n<p>6、PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。</p>\r\n\r\n<p>7、PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('147', null, '<p>如何实现session信息的写入？</p>\r\n', '5', '2', '<p>flask中有三个session：<br />\r\n第一个：数据库中的session，例如:db.session.add()<br />\r\n第二个：在flask_session扩展中的session，使用：from&nbsp;flask_session&nbsp;import&nbsp;Session，使用第三方扩展的session可以把信息存储在服务器中，客户端浏览器中只存储sessionid<br />\r\n第三个：flask自带的session，是一个请求上下文，&nbsp;使用：from&nbsp;flask&nbsp;import&nbsp;session。自带的session把信息加密后都存储在客户端的浏览器cookie中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('148', null, '<p>什么是事务？</p>\r\n', '5', '2', '<p>(1)事务简单来说：一个Session中所进行所有的操作，要么同时成功，要么同时失败ACID &mdash; 数据库事务正确执行的四个基本要素包含：原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）、持久性（Durability）。一个支持事务（Transaction）中的数据库系统，必需要具有这四种特性，否则在事务过程（Transaction processing）当中无法保证数据的正确性，交易过程极可能达不到交易。举个例子:A向B转账，转账这个流程中如果出现问题，事务可以让数据恢复成原来一样【A账户的钱没变，B账户的钱也没变】。<br />\r\n(2)事务隔离级别数据库定义了4个隔离级别：Serializable【可避免脏读，不可重复读，虚读】Repeatable read【可避免脏读，不可重复读】Read committed【可避免脏读】Read uncommitted【级别最低，什么都避免不了】分别对应Connection类中的4个常量:TRANSACTION_READ_UNCOMMITTEDTRANSACTION_READ_COM', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('149', null, '<p>线程实现方式哪几种，如何保证线程安全性，说明Threadlocal的应用场景</p>\r\n', '5', '2', '<p>Java多线程有三种实现方式：<br />\r\n(1)继承Thread类，重写run函数<br />\r\n(2)实现Runnable接口，重写run函数<br />\r\n开启线程：Thread t = new Thread(对象) //创建线程对象<br />\r\nt.start()<br />\r\n(3)实现Callable接口，重写call函数 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; java的同步机制，大概是通过:<br />\r\n1.synchronized；<br />\r\n2.Object方法中的wait,notify；<br />\r\n3.ThreadLocal机制<br />\r\n来实现的, 其中synchronized有两种用法:<br />\r\n1.对类的方法进行修饰<br />\r\n2.synchronized(对象）的方法进行修饰</p>\r\n\r\n<p>　在同步机制中，通过对象的锁机制保证同一时间只有一个线程访问变量。这时该变量是多个线程共享的，使用同步', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('150', null, '<p>请求钩子的理解？</p>\r\n', '5', '3', '<p>请求钩子是通过装饰器的形式实现的，支持以下四种：<br />\r\n1，before_first_request在处理第一个请求前运行<br />\r\n2，before_request:在每次请求前运行<br />\r\n3，after_request:如果没有未处理的异常抛出，在每次请求后运行<br />\r\n4，teardown_request:即使有未处理的异常抛出，在每次请求后运行</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('151', null, '<p>1.讲讲反射机制？<br />\r\n2.设计模式你了解多少？</p>\r\n', '5', '2', '<p>程序在运行的时候可以获取任意一个类的内部信息，也可以说是动态获取</p>\r\n\r\n<p>设计模式的目的：为了代码可重用性、让代码更容易被他人理解、保证代码可靠性 &nbsp; 设计模式有23种</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('153', null, '<p>java开启多线程的几种方法</p>\r\n', '5', '2', '<p>Thread, Runnable, 线程池，Callable）<br />\r\n&nbsp; 一个类集成thread类，或者实现runnable接口，并且都要重写其run方法。如果配置线程池的话，一般都是为了减少线程创建和销毁的次数，保证现成的重复利用以及同时执行多个任务的话，才会考虑。当然在使用时，可以根据系统的承受能力去调整线程的数量及大小。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('154', null, '<p>一个变量后写多个过滤器是如何执行？</p>\r\n', '5', '2', '<p>{{&nbsp;expression&nbsp;|&nbsp;filter1&nbsp;|&nbsp;filter2&nbsp;|&nbsp;...&nbsp;}}&nbsp;&nbsp;即&nbsp;表达式(expression)使用filter1过滤后再使用filter2过滤.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('155', null, '<p>Java 的泛型是什么？有什么好处和优点？JDK 不同版本的泛型有什么区别？</p>\r\n', '5', '2', '<p>泛型是 Java SE 1.5 的新特性，泛型的本质是参数化类型，这种参数类型可以用在类、接口和方法的创建中，分别称为泛型类、泛型接口、泛型方法。在 Java SE 1.5 之前没有泛型的情况的下只能通过对类型 Object 的引用来实现参数的任意化，其带来的缺点是要做显式强制类型转换，而这种强制转换编译期是不做检查的，容易把问题留到运行时，所以 泛型的好处是在编译时检查类型安全，并且所有的强制转换都是自动和隐式的，提高了代码的重用率，避免在运行时出现 ClassCastException。JDK 1.5 引入了泛型来允许强类型在编译时进行类型检查；JDK 1.7 泛型实例化类型具备了自动推断能力，譬如 List&lt;String&gt; list = new ArrayList&lt;String&gt;(); 可以写成 List&lt;String&gt; llist = new ArrayList&lt;&gt;(); 了，JDK 具备自动推断能力。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('156', null, '<p>tcp和udp的区别？</p>\r\n', '5', '4', '<p>TCP和UDP的优缺点及区别<br />\r\nTCP的优点： 可靠，稳定 TCP的可靠体现在TCP在传递数据之前，会有三次握手来建立连接，而且在数据传递时，有确认、窗口、重传、拥塞控制机制，在数据传完后，还会断开连接用来节约系统资源。 TCP的缺点： 慢，效率低，占用系统资源高，易被攻击 TCP在传递数据之前，要先建连接，这会消耗时间，而且在数据传递时，确认机制、重传机制、拥塞控制机制等都会消耗大量的时间，而且要在每台设备上维护所有的传输连接，事实上，每个连接都会占用系统的CPU、内存等硬件资源。 而且，因为TCP有确认机制、三次握手机制，这些也导致TCP容易被人利用，实现DOS、DDOS、CC等攻击。</p>\r\n\r\n<p>UDP的优点： 快，比TCP稍安全 UDP没有TCP的握手、确认、窗口、重传、拥塞控制等机制，UDP是一个无状态的传输协议，所以它在传递数据时非常快。没有TCP的这些机制，UDP较TCP被攻击者利用的漏洞就要少一些。但UDP也是无法避免攻击的，比如：UDP Flood攻击&hellip;&hellip; UDP的缺点： 不可靠，不稳定 因为UDP没有TCP那些可', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('159', null, '<p>equals和hashCode的区别</p>\r\n', '5', '2', '<p>equals我们一般是来判断两个对象是否相等，一般来说比如在根据equals()方法比较两个对象是相等的，那么调用这两个对象中的hashCode方法都肯定会产生同样的整数结果。与之相反，如果比较后是不相等的，那么调用这两个对象的hashCode方法，就不一定会产生相同的整数结果了。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('160', null, '<p>简单说说 Comparable 和 Comparator 的区别和场景？</p>\r\n', '5', '2', '<p>Comparable 对实现它的每个类的对象进行整体排序，这个接口需要类本身去实现，若一个类实现了 Comparable 接口，实现 Comparable 接口的类的对象的 List 列表（或数组）可以通过 Collections.sort（或 Arrays.sort）进行排序，此外实现 Comparable 接口的类的对象可以用作有序映射（如TreeMap）中的键或有序集合（如TreeSet）中的元素而不需要指定比较器， 实现 Comparable 接口必须修改自身的类（即在自身类中实现接口中相应的方法），如果我们使用的类无法修改（如 SDK 中一个没有实现 Comparable 的类），我们又想排序，就得用到 Comparator 这个接口了（策略模式）。所以如果你正在编写一个值类，它具有非常明显的内在排序关系，比如按字母顺序、按数值顺序或者按年代顺序，那你就应该坚决考虑实现 Comparable 这个接口， 若一个类实现了 Comparable 接口就意味着该类支持排序，而 Comparator 是比较器，我们若需要控制某个类的次序，可以建立一个该类的比较器来进行排序。</', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('162', null, '<p>简单说说 Iterator 和 ListIterator 的区别？</p>\r\n', '5', '2', '<p>区别主要如下。</p>\r\n\r\n<p>ListIterator 有 add() 方法，可以向 List 中添加对象，而 Iterator 不能。</p>\r\n\r\n<p>ListIterator 和 Iterator 都有 hasNext() 和 next() 方法，可以实现顺序向后遍历，但是 ListIterator 有 hasPrevious() 和 previous() 方法，可以实现逆向（顺序向前）遍历，Iterator 就不可以。</p>\r\n\r\n<p>ListIterator 可以定位当前的索引位置，通过 nextIndex() 和 previousIndex() 可以实现，Iterator 没有此功能。</p>\r\n\r\n<p>都可实现删除对象，但是 ListIterator 可以实现对象的修改，通过 set() 方法可以实现，Iterator 仅能遍历，不能修改。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('163', null, '<p>过滤器和拦截器的区别</p>\r\n', '5', '2', '<p>（1）拦截器intercepter不依赖与servlet容器，而过滤器是依赖servlet容器的。（2）拦截器只是针对action的请求起作用，而过滤器则可以对几乎所有的请求起作用。（3）在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。（4）还有一个很重要的点，就是拦截器可以获取IOC容器中的各个bean，而过滤器就不行，比如在拦截器里注入一个service，可以调用业务逻辑。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('165', null, '<p>数据库垂直和水平拆分？</p>\r\n', '5', '2', '<p>垂直拆分其实就是一中把大表化成小表的一种操作，什么意思呢？比如原来表10个字段，三个字段查询比较多，剩余的7个字段单独拆出来存一个表，这样可以提高查询效率；水平拆分就是数据量比较大，例如10亿，1亿作为一个表，这样可以拆成10个，横向的数据拆分成小表为水平拆分</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('167', null, '<p>python如何解决sql注入</p>\r\n', '5', '3', '<p>SQL注入即是指web应用程序对用户输入数据的合法性没有判断，攻击者可以在web应用程序中事先定义好的查询语句的结尾上添加额外的SQL语句，以此来实现欺骗数据库服务器执行非授权的任意查询，从而进一步得到相应的数据信息。<br />\r\n利用参数化查询、对数据进行词法分析、使用存储过程等防止</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('168', null, '<p>struts2的执行流程</p>\r\n', '5', '3', '<p>Filter的配置找到FilterDispatcher,并且获取到FilterDispatcher的实例对象。FilterDispatcher对象会将该用户请求发送给ActionMapper,如果需要struts2进行处理的话ActionMapper就会通知FileterDispatcher,需要处理这个请求了,这个时候FileterDispatcher就会停止过滤器链后面的部分，然后建立一个ActionProxy实例。这个ActionProxy实例就会通过ConfigurationManager询问框架的配置文件找到需要调用的Action类，于此同时创建一个ActionInvocation实例，在由ActionInvocation实例调用Action的execute方法。最后，Action执行完毕后ActionInvocation根据struts.xml配置找到对应的返回结果。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('169', null, '<p>ArrayList和LinkedList有什么区别？</p>\r\n', '5', '2', '<p>ArrayList和LinkedList都实现了List接口，他们有以下的不同点：</p>\r\n\r\n<p>ArrayList是基于索引的数据接口，它的底层是数组。它可以以O(1)时间复杂度对元素进行随机访问。与此对应，LinkedList是以元素列表的形式存储它的数据，每一个元素都和它的前一个和后一个元素链接在一起，在这种情况下，查找某个元素的时间复杂度是O(n)。</p>\r\n\r\n<p>相对于ArrayList，LinkedList的插入，添加，删除操作速度更快，因为当元素被添加到集合任意位置的时候，不需要像数组那样重新计算大小或者是更新索引。</p>\r\n\r\n<p>LinkedList比ArrayList更占内存，因为LinkedList为每一个节点存储了两个引用，一个指向前一个元素，一个指向下一个元素。</p>\r\n\r\n<p>也可以参考ArrayList vs. LinkedList。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('171', null, '<p>你们秒杀怎么做的</p>\r\n', '5', '2', '<p>当时我们在做的时候，遇到了一些问题，当时为了减库存操作，需要考虑到两个问题：首先若是用户成功秒杀商品，我们记录了其购买明细，却没有减库存。会导致商品的超卖。还有就是减了库存却没有记录用户的购买明细，导致商品的少卖。对于上述两个问题，可以通过MySQL内置的事务机制进行处理，它可以准确的帮我们完成减库存和记录用户购买明细的过程。并且在针对高并发优化,使用了redis缓存数据库解决，使用Redis优化地址暴露接口，在dao包下新建一个cache包，然后创建一个RedisDao.java函数，在spring-dao.xml中配置redisdao构造器。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('172', null, '<p>JVM垃圾回收机制，何时触发MinorGC等操作</p>\r\n', '5', '3', '<p>不同的对象生命周期不同。把不同生命周期的对象放在不同代上，不同代上采用最合适它的垃圾回收方式进行回收。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('173', null, '<p>什么是HTTP协议</p>\r\n', '5', '2', '<p>HTTP是超文本传输协议, 是一个客户端和服务器端请求和应答的标准。底层使用TCP,客户端是终端用户，服务器端是网站。通过使用Web浏览器、网络爬虫或者其它的工具，客户端发起一个到服务器上指定端口（默认端口为80）的HTTP请求。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('174', null, '<p>描述jvm加载class文件原理和机制</p>\r\n', '5', '5', '<p>JVM中类的装载是由类加载器（ClassLoader）和它的子类来实现的，Java中的类加载器是一个重要的Java运行时系统组件，它负责在运行时查找和装入类文件中的类。&nbsp;<br />\r\n　　由于Java的跨平台性，经过编译的Java源程序并不是一个可执行程序，而是一个或多个类文件。当Java程序需要使用某个类时，JVM会确保这个类已经被加载、连接（验证、准备和解析）和初始化。类的加载是指把类的.class文件中的数据读入到内存中，通常是创建一个字节数组读入.class文件，然后产生与所加载类对应的Class对象。加载完成后，Class对象还不完整，所以此时的类还不可用。当类被加载后就进入连接阶段，这一阶段包括验证、准备（为静态变量分配内存并设置默认的初始值）和解析（将符号引用替换为直接引用）三个步骤。最后JVM对类进行初始化，包括：1)如果类存在直接的父类并且这个类还没有被初始化，那么就先初始化父类；2)如果类中存在初始化语句，就依次执行这些初始化语句。&nbsp;<br />\r\n　　类的加载是由类加载器完成的，类加载器包括：根加载器（BootStrap）、扩展加载器（', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('175', null, '<p>restful风格api？</p>\r\n', '5', '4', '<p>REST:Representational State Transfer 的缩写，翻译：&ldquo;具象状态传输&rdquo;。一般解释为&ldquo;表现层状态转换&rdquo;。REST 是设计风格而不是标准。是指客户端和服务器的交互形式。我们需要关注的重点是如何设计REST 风格的网络接口。<br />\r\nREST 的特点：<br />\r\n1.具象的。一般指表现层，要表现的对象就是资源。比如，客户端访问服务器，获取的数据就是资源。比如文字、图片、音视频等。<br />\r\n2.表现：资源的表现形式。txt 格式、html 格式、json 格式、jpg 格式等。浏览器通过 URL 确定资源的位置，但是需要在 HTTP 请求头中，用 Accept 和 Content-Type 字段指定，这两个字段是对资源表现的描述。<br />\r\n3.状态转换：客户端和服务器交互的过程。在这个过程中，一定会有数据和状态的转化，这种转化叫做状态转换。其中，GET 表示获取资源，POST 表示新建资源，PUT 表示更新资源，DELETE 表示删<br />\r\n除资源。HTTP 协议中最常用的就是这', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('176', null, '<p>对volatile有了解吗</p>\r\n', '5', '2', '<p>Java 内存模型中的可见性、原子性和有序性。<br />\r\n可见性：<br />\r\n　　可见性是一种复杂的属性，因为可见性中的错误总是会违背我们的直觉。通常，我们无法确保执行读操作的线程能适时地看到其他线程写入的值，有时甚至是根本不可能的事情。为了确保多个线程之间对内存写入操作的可见性，必须使用同步机制。<br />\r\n　　可见性，是指线程之间的可见性，一个线程修改的状态对另一个线程是可见的。也就是一个线程修改的结果。另一个线程马上就能看到。比如：用volatile修饰的变量，就会具有可见性。volatile修饰的变量不允许线程内部缓存和重排序，即直接修改内存。所以对其他线程是可见的。但是这里需要注意一个问题，volatile只能让被他修饰内容具有可见性，但不能保证它具有原子性。比如 volatile int a = 0；之后有一个操作 a++；这个变量a具有可见性，但是a++ 依然是一个非原子操作，也就是这个操作同样存在线程安全问题。<br />\r\n　　在 Java 中 volatile、synchronized 和 final 实现可见性。<br />\r\n原子性：<br /', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('177', null, '<p>cookies和session的区别？</p>\r\n', '5', '2', '<p>1.cookie 数据存放在客户的浏览器上，session 数据放在服务器上。<br />\r\n2.cookie 不是很安全，别人可以分析存放在本地的 cookie 并进行 cookie 欺骗考虑到安全应当使用 session。<br />\r\n3.session 会在一定时间内保存在服务器上。当访问增多，会比较占用服务器的性能考虑到减轻服务器性能方面，应当使用 cookie。<br />\r\n4.单个 cookie 保存的数据不能超过 4K，很多浏览器都限制一个站点最多保存 20 个 cookie。<br />\r\n5.建议： 将登陆信息等重要信息存放为 SESSION 其他信息如果需要保留，可以放在 cookie 中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('178', null, '<p>String 是最基本的数据类型吗？</p>\r\n', '5', '2', '<p>不是。Java中的基本数据类型只有8个：byte、short、int、long、float、double、char、boolean；除了基本类型（primitive type）和枚举类型（enumeration type），剩下的都是引用类型（reference type）</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('179', null, '<p>Java 线程优先级是怎么定义的</p>\r\n', '5', '2', '<p>Java 线程的优先级定义为从 1 到 10 的等级，默认为 5，设置和获取线程优先级的方法是 setPriority(int newPriority) 和 getPriority()，Java 的这个优先级会被映射到操作系统中线程的优先级，不过由于操作系统各不相同，不一定都是 10 个优先级，所以 Java中不同的优先级可能会被映射到操作系统中相同的优先级，同时优先级对操作系统而言更多的是一种建议和提示而非强制，所以我们不要过于依赖优先级。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('180', null, '<p>简单说说 java 的 Class.forName 和 ClassLoader.loadClass 方法的区别？</p>\r\n', '5', '2', '<p>一个 Java 类加载到 JVM 中会经过三个步骤，装载（查找和导入类或接口的二进制数据）、链接（校验：检查导入类或接口的二进制数据的正确性；准备：给类的静态变量分配并初始化存储空间；解析：将符号引用转成直接引用；）、初始化（激活类的静态变量的初始化 Java 代码和静态 Java 代码块）。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('181', null, '<p>ThreadLocal 用途是什么，原理是什么，用的时候要注意什么 &nbsp; &nbsp;</p>\r\n', '5', '2', '<p>我们知道,在多线程程序中,同一个线程在某个时间段只能处理一个任务.我们希望在这个时间段内,任务的某些变量能够和处理它的线程进行绑定,在任务需要使用这个变量的时候,这个变量能够方便的从线程中取出来.ThreadLocal能很好的满足这个需求,用ThreadLocal变量的程序看起来也会简洁很多,因为减少了变量在程序中的传递.<br />\r\n2.ThreadLocal的原理是怎么样的?<br />\r\n&nbsp; &nbsp; 每个运行的线程都会有一个类型为ThreadLocal.ThreadLocalMap的map,这个map就是用来存储与这个线程绑定的变量,map的key就是ThreadLocal对象,value就是线程正在执行的任务中的某个变量的包装类Entry.&nbsp;<br />\r\n3. ThreadLocal保存变量的生命周期是怎么样的?<br />\r\n&nbsp; &nbsp; ThreadLocal保存变量的生命周期 &lt;=任务的生命周期&lt;=线程的生命周期<br />\r\nThreadLocal.set，ThreadLocal.remove实际上是同样的道', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('182', null, '<p>&nbsp;redis原理,和Redis雪崩处理</p>\r\n', '5', '2', '<p>缓存穿透 一般的缓存系统,都是按照key去缓存的,如果不存在对应的value,应该去后端系统查询(比如数据库).如果key对应的value是一定不存在,并且对key并发请求量很大,就会对后端系统造成很大的压力,这就叫做缓存穿透; 缓存雪崩 缓存雪崩指的是我们设置缓存是采用了相同的过期时间,导致缓存在某一时期同时失效,请求全部转发到DB,DB瞬间压力多大雪崩; 解决方案 把缓存的时间失效分散开,比如在原来的时间基础上增加一个随机值,比如1~5分钟随机,这样每一个缓存的过期时间的重复率聚会降低,就很难引发集体失效事件;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('183', null, '<p>CocurrentHashMap原理是什么？cocurrent包下除此之外还用过哪些类？</p>\r\n', '5', '2', '<p>采用分段锁的机制 ，对每个entry数组进行加锁相比hashtable效率要高，还有atomic包</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('185', null, '<p>Java中如何实现多线程</p>\r\n', '5', '2', '<p>继承Thread类<br />\r\n实现Runnable接口<br />\r\n推荐使用Runnable接口</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('186', null, '<p>说一下AOP与IOC的概念（即spring的核心）</p>\r\n', '5', '2', '<p>a)IOC：Spring是开源框架，使用框架可以使我们减少工作量，提高工作效率并且它是分层结构，即相对应的层处理对应的业务逻辑，减少代码的耦合度。而spring的核心是IOC控制反转和AOP面向切面编程。IOC控制反转主要强调的是程序之间的关系是由容器控制的，容器控制对象，控制了对外部资源的获取。而反转即为，在传统的编程中都是由我们创建对象获取依赖对象，而在IOC中是容器帮我们创建对象并注入依赖对象，正是容器帮我们查找和注入对象，对象是被获取，所以叫反转。<br />\r\nSpring支持三种依赖注入方式，分别是属性（Setter方法）注入，构造注入和接口注入。<br />\r\n在Spring中，那些组成应用的主体及由Spring IOC容器所管理的对象被称之为Bean。<br />\r\nSpring的IOC容器通过反射的机制实例化Bean并建立Bean之间的依赖关系。<br />\r\n简单地讲，Bean就是由Spring IOC容器初始化、装配及被管理的对象。<br />\r\n获取Bean对象的过程，首先通过Resource加载配置文件并启动IOC容器，然后通过getBean方法获取be', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('187', null, '<p>fianl，finally，finalize的区别</p>\r\n', '5', '1', '<p>final&mdash;修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。&nbsp;<br />\r\nfinally&mdash;再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。&nbsp;<br />\r\nfinalize&mdash;方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('188', null, '<p>HashMap 中的 key 如果是 Object 则需要实现哪些方法？</p>\r\n', '5', '2', '<p>hashCode 方法和 equals 方法。因为 hashCode 方法用来计算 Entry 在数组中的 index 索引位置，equals 方法用来比较数组指定 index 索引位置上链表的节点 Entry 元素是否相等。否则由于 hashCode 方法实现不恰当会导致严重的 hash 碰撞，从而使 HashMap 会退化成链表结构而影响性能。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('189', null, '<p>flask中的请求钩子？</p>\r\n', '5', '3', '<p>请求钩子是通过装饰器的形式实现的，支持以下四种：<br />\r\n1，before_first_request 在处理第一个请求前运行<br />\r\n2，before_request:在每次请求前运行<br />\r\n3，after_request:如果没有未处理的异常抛出，在每次请求后运行<br />\r\n4，teardown_request:即使有未处理的异常抛出，在每次请求后运行</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('190', null, '<p>HashMap 默认的初始化长度是多少？为什么默认长度和扩容后的长度都必须是 2 的幂？</p>\r\n', '5', '2', '<p>在 JDK 中默认长度是 16（在 Android SDK 中的 HashMap 默认长度为 4），并且默认长度和扩容后的长度都必须是 2 的幂。因为我们可以先看下 HashMap 的 put 方法核心</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('191', null, '<p>描述一下对象的创建过程</p>\r\n', '5', '2', '<p>1)装载：将Java二进制代码导入jvm中，生成Class文件。<br />\r\n2)连接：<br />\r\na）校验：检查载入Class文件数据的正确性&nbsp;<br />\r\nb）准备：给类的静态变量分配存储空间&nbsp;<br />\r\nc）解析：将符号引用转成直接引用<br />\r\n3）：初始化：对类的静态变量，静态方法和静态代码块执行初始化工作。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('193', null, '<p>HashMap和Hashtbale区别？</p>\r\n', '5', '1', '<p>HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的区别。主要的区别有：线程安全性，同步(synchronization)，以及速度。</p>\r\n\r\n<p>HashMap几乎可以等价于Hashtable，除了HashMap是非synchronized的，并可以接受null(HashMap可以接受为null的键值(key)和值(value)，而Hashtable则不行)。<br />\r\nHashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。<br />\r\n另一个区别是HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('194', null, '<p>请简单描述一下ajax技术？</p>\r\n', '5', '2', '<p>ajax是指一种创建交互式网页应用的网页开发技术，简单的说就是一个异步页面交互技术</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('195', null, '<p>COOKIE的跨域</p>\r\n', '5', '3', '<p>在任何一个系统登录后，可以访问这个统一加载上的所有系统。登录之后，用户的权限和信息不再受某个系统的限制，即使某个系统出现故障(包括统一加载平台)，其他系统还是能正常使用的。这就需要用户权限等信息保存到客户端，不受服务器的限制。在cookie相关文档信息中，提到cookie是不能跨域访问的，但是在二级域名是可以共享cookie的。这样就是我们的项目有了局限性，必须将多个系统的域名统一，作为二级域名，统一平台提供使用主域名。这样就可以实cookie的单点登录了。<br />\r\ndomain属性:例如设成&quot;.hanj.com&quot;则在.hanj.com下的所有服务器下的文件都可以调用cookie.统一平台域名：www.hanj.com统一加载平台和各子系统都是不同的服务器，统一加载平台提供登录认证服务，在统一加载平台认证系统上登录后，用户都可以被其他的系统识别.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('197', null, '<p>运行时异常和一般异常有何区别？</p>\r\n', '5', '1', '<p>相同点：</p>\r\n\r\n<p>两种异常同属于Exception父类。</p>\r\n\r\n<p>不同点：</p>\r\n\r\n<p>(1)运行时异常都是RuntimeException类及其子类异常，如NullPointerException、IndexOutOfBoundsException等。</p>\r\n\r\n<p>(2)一般异常是RuntimeException以外的异常，类型上都属于Exception类及其子类。1、一般异常：</p>\r\n\r\n<p>一般异常包括IOException、SQLException等以及用户自定义的Exception异常。对于这种异常，JAVA编译器强制要求我们必需对出现的这些异常进行catch并处理，否则程序就不能编译通过。</p>\r\n\r\n<p>所以，面对这种异常不管我们是否愿意，只能自己去写一大堆catch块去处理可能的异常。</p>\r\n\r\n<p>2、常见RuntimeException：</p>\r\n\r\n<p>ArrayStoreException：试图将错误类型的对象存储到一个对象数组时抛出的异常</p>\r\n\r\n<p>ClassCastException', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('198', null, '<p>ConcurrentHashMap是什么</p>\r\n', '5', '3', '<p>并发编程实践中，ConcurrentHashMap是一个经常被使用的数据结构，相比于Hashtable以及Collections.synchronizedMap()，ConcurrentHashMap在线程安全的基础上提供了更好的写并发能力，但同时降低了对读一致性的要求。<br />\r\nConcurrentHashMap的设计与实现非常精巧，大量的利用了volatile，final，CAS等lock-free技术来减少锁竞争对于性能的影响.ConcurrentHashMap采用了分段锁的设计，只有在同一个分段内才存在竞态关系，不同的分段锁之间没有锁竞争。相比于对整个Map加锁的设计，分段锁大大的提高了高并发环境下的处理能力。但同时，由于不是对整个Map加锁，导致一些需要扫描整个Map的方法（如size(), containsValue()）需要使用特殊的实现，另外一些方法（如clear()）甚至放弃了对一致性的要求（ConcurrentHashMap是弱一致性的</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('201', null, '<p>信号量是什么</p>\r\n', '5', '3', '<p>信号量是用来解决线程间同步或互斥的一种机制，也是一个特殊的变量，变量的值代表着当前可以利用的资源。<br />\r\n信号量的本质是数据操作锁，它本身不具有数据交换的功能，而是通过控制其他的通信资源（文件，外部设备）来实现进程间通信，它本身只是一种外部资源的标识。信号量在此过程中负责数据操作的互斥、同步等功能。为了防止出现因多个程序同时访问一个共享资源而引发的一系列问题，我们需要一种方法，它可以通过生成并使用令牌来授权，在任一时刻只能有一个执行线程访问代码的临界区域。临界区域是指执行数据更新的代码需独占式地执行。而信号量就可以提供这样的一种访问机制，让一个临界区同一时间只有一个线程在访问它，也就是说信号量是用来调协进程对共享资源的访问的。其中共享内存的使用就要用到信号量。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('203', null, '<p>进程间的通信方式</p>\r\n', '5', '2', '<p>管道( pipe )：管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用。进程的亲缘关系通常是指父子进程关系。<br />\r\n有名管道 (named pipe) ： 有名管道也是半双工的通信方式，但是它允许无亲缘关系进程间的通信。<br />\r\n信号量( semophore ) ： 信号量是一个计数器，可以用来控制多个进程对共享资源的访问。它常作为一种锁机制，防止某进程正在访问共享资源时，其他进程也访问该资源。因此，主要作为进程间以及同一进程内不同线程之间的同步手段。<br />\r\n消息队列( message queue ) ： 消息队列是由消息的链表，存放在内核中并由消息队列标识符标识。消息队列克服了信号传递信息少、管道只能承载无格式字节流以及缓冲区大小受限等缺点。<br />\r\n信号 ( sinal ) ： 信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。<br />\r\n共享内存( shared memory ) ：共享内存就是映射一段能被其他进程所访问的内存，这段共享内存由一个进程创建，但多个进程都可以访问。共享内存是最快的 I', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('207', null, '<p>用PHP打印出前一天的时间格式是2006-5-10 22:21:21</p>\r\n', '5', '2', '<p>echo date(&#39;Y-m-d H:i:s&#39;,strtotime(&#39;-1 day&#39;,time()));</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('208', null, '<p>后端如何进行项目优化</p>\r\n', '5', '3', '<p>1.页面做缓存 2.主页静态化 3.阻塞操作使用celery异步 4.对数据库进行优化&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('209', null, '<p>怎么设计数据库</p>\r\n', '5', '2', '<p>第一范式：数据库表的每一列都是不可分割的原子数据项，即列不可拆分<br />\r\n第二范式：建立在第一范式的基础上，要求数据库表中的每个实例或记录必须是可以唯一被区分的，即唯一标识。<br />\r\n第三范式：建立在第二范式的基础上，任何非主属性不依赖与其他非主属性，即引用主键。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('211', null, '<p>写二分查找</p>\r\n', '5', '3', '<p>&nbsp; 1. def binary_search(alist,item): 2. n = len(alist) 3. if n == 0: 4. return False 5. mid = n // 2 6. if alist[mid] == item: 7. return True 8. elif alist[mid] &gt; item: 9. return binary_search(alist[:mid],item) 10. else: 11. return binary_search(alist[mid+1:],item) 12. 13. if __name__ == &#39;__main__&#39;: 14. li = [3,6,8,10,40,60] 15. print(binary_search(li,60))</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('212', null, '<p>什么是线程池？</p>\r\n', '5', '2', '<p>在一个应用程序中初始化一个线程集合，然后在需要执行新的任务时重用线程池中的线程，而不是创建一个新的线程。线程池中的每个线程都有被分配一个任务，一旦任务完成，线程就回到线程池中，等待下一次的任务分配</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('214', null, '<p>停止一个线程的方法</p>\r\n', '5', '3', '<p>终止线程的三种方法：<br />\r\n1. 使用退出标志，使线程正常退出，也就是当run方法完成后线程终止。<br />\r\n2. 使用stop方法强行终止线程（这个方法不推荐使用，因为stop和suspend、resume一样，也可能发生不可预料的结果）。<br />\r\n3. 使用interrupt方法中断线程。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('215', null, '<p>关于csrf的了解和其在django中如何保护</p>\r\n', '5', '3', '<p>（1）一开始用户打开浏览器，访问受信任网站A，输入用户名和密码登陆请求登陆网站A。 （2）网站A验证用户信息，用户信息通过验证后，网站A产生Cookie信息并返回给浏览器。 （3）用户登陆网站A成功后，可以正常请求网站A。 （4）用户未退出网站A之前，在同一浏览器中，打开一个TAB访问网站B。 （5）网站B看到有人方式后，他会返回一些攻击性代码。 （6）浏览器在接受到这些攻击性代码后，促使用户不知情的情况下浏览器携带Cookie（包括sessionId）信息，请求网站A。这种请求有可能更新密码，添加用户什么的操作。 &nbsp; 解决方法：settings中开启csrf保护，在表单中添加csrf_token</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('216', null, '<p>简单说说 Java 的 JVM 内存结构分为哪几个部分？</p>\r\n', '5', '2', '<p>JVM 内存共分为虚拟机栈、堆、方法区、程序计数器、本地方法栈五个部分，分别解释如下。&nbsp;<br />\r\n虚拟机栈：线程私有的，每个方法在执行时会创建一个栈帧，用来存储局部变量表、操作数栈、动态连接、方法返回地址等；其中局部变量表用于存放 8 种基本数据类型（boolean、byte、char、short、int、float、long、double）和 reference 类型。每个方法从调用到执行完毕对应一个栈帧在虚拟机栈中的入栈和出栈。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('217', null, '<p>你知道线程同步与阻塞的关系？同步一定阻塞吗？阻塞一定同步的吗？</p>\r\n', '5', '3', '<p>线程同步与否跟阻塞非阻塞没关系，同步是个过程，阻塞是线程的一种状态。多个线程操作共享变量时可能会出现竞争。这时需要同步来防止两个以上的线程同时进入临界区内，在这个过程中后进入临界区的线程将阻塞，等待先进入的线程走出临界区。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('218', null, '<p>面向对象有哪些特征？</p>\r\n', '5', '1', '<p>1.封装：封装是把过程和数据包围起来，对数据的访问只能通过已定义的界面，面向对象计算始于这个基本概念，即现实世界可以被描绘成一系列完全自治，封装的对象，这些对象通过一个受保护的接口访问其他对象</p>\r\n\r\n<p>2.继承：继承是一种联结类的层次模型，并且允许和鼓励类的重用，它提供了一种明确表达共性的方法，对象的一个新类可以从现在的类中派生，这个过程成为继承，新类继承了原始类的特性，新类成为原始类的派生类，而原始类称为新类的基类，派生类可以从他的基类那里继承方法和实例变量，并且类可以修改或增加新的方法使之更加适合特殊的需求</p>\r\n\r\n<p>3.抽象：抽象就是忽略一个主题中与当前目标无关的那些方面，以便充分的注意与当前目标有关的方面，抽象包括两个方面，一个是过程抽象，二是数据抽象</p>\r\n\r\n<p>4.多态性：多态性是指允许不同类的对象对同一消息作出响应，多态性包括参数化多态性和包含多态性，多态性语言具有灵活，抽象，行为共享，代码共享的优势，很好的解决了应用程序函数同名的问题</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('219', null, '<p>说一下单例模式</p>\r\n', '5', '3', '<p>单例模式具体实现方式非常多，有饿汉式、懒汉式、双检锁、私有静态内部类、枚举等。饿汉式是在类加载的时候由静态成员变量位置创建对象；懒汉式则是在用户在第一次调用方法的时候创建，但是高并发时会有安全隐患，由此引申出双检锁模式；但是网上有人说双检锁模式也不安全，涉及到java指令重排序问题，导致用户获取的单例对象可能残缺，需要用volatile关键字修饰成员变量，但是这种错误我曾经模拟过很多次，根本测试不出来，所以我很怀疑；私有静态内部类的方案是一种不错的方案，既能延迟对象的初始化时机，又能保证安全性；最后一种枚举方案是我比较喜欢的，因为代码简单，而且安全，尤其是用户无法通过暴力反射来打破单例状态，但是它的初始化时机也是类加载时初始化。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('220', null, '<p>前端的框架的了解</p>\r\n', '5', '1', '<p>vue，bootstrap,jquery......</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('221', null, '<p>说一下java的垃圾回收</p>\r\n', '5', '3', '<p>首先说一下垃圾确定算法：引用计数法：垃圾回收器会遍历对象列表，清理引用数为0的对象。缺点：两个对象互相引用时，清理不掉。可达性分析：思想---所有存活的对象，一定能追溯到其存活在栈（虚拟机栈/本地方法栈）、堆或方法区中的引用。也就是从GC Roots开始遍历，游离在引用链之外的对象视为垃圾。<br />\r\n目前主流虚拟机采用的是分代收集算法：主流JVM的垃圾回收算法，把堆分为新生代、老年代；方法区对应永久带。新生代（Minor GC）：刚初始化的对象，状态不稳定，每次垃圾回收时都有大量对象被回收，具有朝生夕灭的特性。大部分垃圾收集器对于新生代都采取复制算法，因为复制对象的次数较少。一般来说是将新生代划分为一块较大的Eden（伊甸园）空间和两块较小的Survivor（幸存者）空间（一般为8:1:1），每次使用Eden空间和其中的一块Survivor空间，当进行回收时，将Eden和Survivor中还存活的对象复制到另一块Survivor空间中，然后清理掉Eden和刚才使用过的Survivor空间。新生代实际可用的内存空间为自身的90%。对象在Survivor每熬过一次Minor G', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('222', null, '<p>爬虫爬过哪个网站</p>\r\n', '5', '1', '<p>根据自身项目而定，项目相关网站都可以说，同时可以说一些自己爬过的网站练手</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('223', null, '<p>==号和equals的区别</p>\r\n', '5', '2', '<p>equal:是用来比较两个对象内部的内容是否相等的，由于所有的类都是继承java.lang.Object类的，所以如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法。<br />\r\n而Object中的equal方法返回的却是==的判断，因此，如果在没有进行该方法的覆盖后，调用该方法是没有任何意义的。在java面向对象的处理中我们一般在javabean中都要选择重写equals方法，使用hibernate后，我们要生成数据库的映射文件与实体类，最好在实体类中进行equals方法的重写，重写时我们可以根据自己的定义来实现该方法只要遵守那五条原则</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('224', null, '<p>说一些自己知道的简单的算法？</p>\r\n', '5', '3', '<p>常用的且学过的：冒泡排序，快速排序，选择排序，插入排序&hellip;&hellip;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('225', null, '<p>java自带的常用线程池有那几个？</p>\r\n', '5', '2', '<p>Java通过Executors提供四种线程池，分别为：<br />\r\nnewCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。<br />\r\nnewFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。<br />\r\nnewScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。<br />\r\nnewSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('226', null, '<p>Java中，什么是构造方法？什么是构造方法重载？什么是复制构造方法？</p>\r\n', '5', '3', '<p>当新对象被创建的时候，构造方法会被调用。每一个类都有构造方法。在程序员没有给类提供构造方法的情况下，Java编译器会为这个类创建一个默认的构造方法。&nbsp;<br />\r\nJava中构造方法重载和方法重载很相似。可以为一个类创建多个构造方法。每一个构造方法必须有它自己唯一的参数列表。&nbsp;<br />\r\nJava不支持像C++中那样的复制构造方法，这个不同点是因为如果你不自己写构造方法的情况下，Java不会创建默认的复制构造方法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('227', null, '<p>scrapy爬虫原理</p>\r\n', '5', '2', '<p>1，spider打开某网页，获取到一个或者多个request，经由scrapy engine传送给调度器scheduler，request特别多并且速度特别快会在scheduler形成请求队列queue，由scheduler安排执行。<br />\r\n2，schelduler会按照一定的次序取出请求，经由引擎, 下载器中间键，发送给下载器dowmloader，这里的下载器中间键是设定在请求执行前，因此可以设定代理，请求头，cookie等。<br />\r\n3，下载下来的网页数据再次经过下载器中间键，经过引擎，经过爬虫中间键传送给爬虫spiders，这里的下载器中间键是设定在请求执行后，因此可以修改请求的结果，这里的爬虫中间键是设定在数据或者请求到达爬虫之前，与下载器中间键有类似的功能。<br />\r\n4，由爬虫spider对下载下来的数据进行解析，按照item设定的数据结构经由爬虫中间键，引擎发送给项目管道itempipeline，这里的项目管道itempipeline可以对数据进行进一步的清洗，存储等操作，这里爬虫极有可能从数据中解析到进一步的请求，request，它会把请求经由引', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('228', null, '<p>java中线程安全的集合有哪些？</p>\r\n', '5', '2', '<p>1、线程安全(Thread-safe)的集合对象：</p>\r\n\r\n<p>Vector 线程安全：<br />\r\nHashTable 线程安全：<br />\r\nStringBuffer 线程安全：<br />\r\n2、非线程安全的集合对象：</p>\r\n\r\n<p>ArrayList ：<br />\r\nLinkedList：<br />\r\nHashMap：<br />\r\nHashSet：<br />\r\nTreeMap：<br />\r\nTreeSet：<br />\r\nStringBulider：</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('229', null, '<p>文章的去重</p>\r\n', '5', '5', '<p>python去除文件中重复的文章，我们可以设置一个一个空list，res_list，用来加入没有出现过的文章！如果出现在res_list，我们就认为该行句子已经重复了</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('230', null, '<p>简述src和href的区别</p>\r\n', '5', '3', '<p>src是source的缩写，是在页面中引入某种资源,当浏览器解析到src时，会暂停浏览器的渲染，直到该资源加载完毕；href用于在当前文档和引用资源之间建立联系。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('231', null, '<p>list，set，map的是否继承collection？</p>\r\n', '5', '2', '<p>List，Set是，Map不是。Collection是最基本的集合接口，一个Collection代表一组Object，即Collection的元素。一些Collection允许相同的元素而另一些不行。一些能排序而另一些不行。Java JDK不能提供直接继承自Collection的类，Java JDK提供的类都是继承自Collection的&quot;子接口&quot;，如:List和Set。&nbsp;</p>\r\n\r\n<p>注意：Map没有继承Collection接口，Map提供key到value的映射。一个Map中不能包含相同key，每个key只能映射一个value。Map接口提供3种集合的视图，Map的内容可以被当做一组key集合，一组value集合，或者一组key-value映射。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('232', null, '<p>为什么很多 Java 规范都建议不要显式的创建 Thread，而使用线程池？</p>\r\n', '5', '2', '<p>因为使用线程池的好处是减少在创建和销毁线程上所消耗的时间和系统资源，解决资源不足的问题，如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者过渡切换问题。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('234', null, '<p>new Object()的原理是什么？</p>\r\n', '5', '3', '<p>1)创建一个空对象，并且 this 变量引用该对象，同时还继承了该函数的原型。<br />\r\n2)属性和方法被加入到 this 引用的对象中。<br />\r\n3)新创建的对象由 this 所引用，并且最后隐式的返回 this&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('235', null, '<p>列出arrylist，linklist，vectory的存储性能和特性</p>\r\n', '5', '2', '<p>&nbsp;Vector中的方法由于添加了synchronized修饰，因此Vector是线程安全的容器，但性能上较ArrayList差，因此已经是Java中的遗留容器。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; LinkedList使用双向链表实现存储（将内存中零散的内存单元通过附加的引用关联起来，形成一个可以按序号索引的线性结构，这种链式存储方式与数组的连续存储方式相比，内存的利用率更高），按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; Vector属于遗留容器（Java早期的版本中提供的容器，除此之外，Hashtable、Dictionary、BitSet、Stack、Properties都是遗留容器），已经不推荐使用，但是由于ArrayList和LinkedListed都是非线程安全的，如果遇到多个线程操作同一个容器的场景，则可以通过工具类Collectio', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('236', null, '<p>阐述线程安全和线程非安全</p>\r\n', '5', '2', '<p>线程安全就是多线程访问时，采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进行访问直到该线程读取完，其他线程才可使用。不会出现数据不一致或者数据污染。<br />\r\n&nbsp; &nbsp; &nbsp; 线程不安全就是不提供数据访问保护，有可能出现多个线程先后更改数据造成所得到的数据是脏数据</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('237', null, '<p>Java 中静态代码块、构造代码块、构造方法的执行顺序是什么？</p>\r\n', '5', '2', '<p>因为静态代码块作用于类级别，构造代码块和构造方法作用于对象级别，所以静态代码块是随着类的加载而被执行，只要类被加载了就会执行，而且只会加载一次，主要用于给类进行初始化；构造代码块在每次创建一个对象时就会执行一次且优先于构造函数，主要用于初始化不同对象共性的初始化内容和初始化实例环境；构造方法在每次创建一个对象时就会执行一次，同时构造方法是给特定对象进行初始化，而构造代码是给所有对象进行初始化；所以通过分析得出他们三者的执行顺序为 静态代码块 &gt; 构造代码块 &gt; 构造方法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('238', null, '<p>3，常用的集合有哪些</p>\r\n', '5', '2', '<p>ArrayList，HashMap，HashSet等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('239', null, '<p>3.单例和多例</p>\r\n', '5', '3', '<p>单例模式就是保证对象在内存中只有一份, 多例可以理解为是多份, Java的枚举类就可以看做是多例</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('240', null, '<p>1.ArrayList和LinkedList的区别</p>\r\n', '5', '3', '<p>ArrayList增删慢，查找快，LinkedList正好相反</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('241', null, '<p>b&nbsp;继承&nbsp;a&nbsp;的方法&nbsp;</p>\r\n', '5', '2', '<p>继承:原型继承,借用构造函数继承,组合继承,拷贝继承. 一般最简单面试会用的继承方式:原型继承:b.prototype=new a();</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('242', null, '<p>接口与抽象类的区别</p>\r\n', '5', '2', '<p>1.语法层面上的区别</p>\r\n\r\n<p>　　1）抽象类可以提供成员方法的实现细节，而接口中只能存在public abstract 方法；</p>\r\n\r\n<p>　　2）抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final类型的；</p>\r\n\r\n<p>　　3）接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法；</p>\r\n\r\n<p>　　4）一个类只能继承一个抽象类，而一个类却可以实现多个接口。</p>\r\n\r\n<p>2.设计层面上的区别</p>\r\n\r\n<p>　　1）抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。举个简单的例子，飞机和鸟是不同类的事物，但是它们都有一个共性，就是都会飞。那么在设计的时候，可以将飞机设计为一个类Airplane，将鸟设计为一个类Bird，但是不能将 飞行 这个特性也设计为类，因此它只是一个行为特性，并不是对一类事物的抽象描述。此时可以将 飞行 设计为一个接口Fly，包含方法fly( )，然后A', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('243', null, '<p>1.ArrayList和LinkedList的区别</p>\r\n', '5', '3', '<p>ArrayList增删慢，查找快，LinkedList正好相反</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('244', null, '<p>简述内存溢出的查找方式以及解决思路</p>\r\n', '5', '4', '<p>内存溢出是指应用系统中存在无法回收的内存或使用的内存过多，最终使得程序运行要用到的内存大于虚拟机能提供的最大内存。</p>\r\n\r\n<p>&nbsp; &nbsp;引起内存溢出的原因有很多种，常见的有以下几种：<br />\r\n　　1.内存中加载的数据量过于庞大，如一次从数据库取出过多数据；<br />\r\n　　2.集合类中有对对象的引用，使用完后未清空，使得JVM不能回收；<br />\r\n　　3.代码中存在死循环或循环产生过多重复的对象实体；<br />\r\n　　4.使用的第三方软件中的BUG；<br />\r\n　　5.启动参数内存值设定的过小；</p>\r\n\r\n<p>内存溢出的解决方案：<br />\r\n&nbsp; &nbsp; &nbsp; 第一步，修改JVM启动参数，直接增加内存。(-Xms，-Xmx参数一定不要忘记加。)</p>\r\n\r\n<p>　　第二步，检查错误日志，查看&ldquo;OutOfMemory&rdquo;错误前是否有其它异常或错误。</p>\r\n\r\n<p>　　第三步，对代码进行走查和分析，找出可能发生内存溢出的位置。</p>\r\n\r\n<p>重点排查以下几点：<br />', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('245', null, '<p>java 的 Integer 和 int 有什么区别？</p>\r\n', '5', '2', '<p>int 是 java 内置基本数据类型之一，java 为每个基本类型都提供了一个封装类，Integer 就是 int 的封装类（也叫包装类型）；int 变量的默认值为 0，Integer 变量的默认值为 null，所以 Integer 可以区分出未赋值和值为 0 的区别；Integer 类内部提供了一些关于整数操作的方法，例如上文用到的表示整数的最大值和最小值。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('246', null, '<p>2.HashMap的数据结构是什么</p>\r\n', '5', '3', '<p>1.7是数组+链表；1.8是数组+链表+红黑树</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('247', null, '<p>int和integer的区别</p>\r\n', '5', '2', '<p>int是java的原始数据类型，Integer是java为int提供的封装类。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('248', null, '<p>字符串的方式有哪些</p>\r\n', '5', '1', '<p>&nbsp;char&nbsp;charAt&nbsp;(int&nbsp;index)&nbsp;&nbsp;返回index所指定的字符<br />\r\n&nbsp;String&nbsp;concat(String&nbsp;str)&nbsp;&nbsp;将两字符串连接<br />\r\n&nbsp;boolean&nbsp;endsWith(String&nbsp;str)&nbsp;&nbsp;测试字符串是否以str结尾<br />\r\n&nbsp;boolean&nbsp;equals(Object&nbsp;obj)&nbsp;&nbsp;比较两对象<br />\r\n&nbsp;char[]&nbsp;getBytes&nbsp;&nbsp;将字符串转换成字符数组返回<br />\r\n&nbsp;char[]&nbsp;getBytes(String&nbsp;str)&nbsp;&nbsp;将指定的字符串转成制服数组返回<br />\r\n&nbsp;boolean&nbsp;startsWith(String&nbsp;str)&nbsp;&nbsp;测试字符串是否以str开始', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('249', null, '<p>String和StringBuff的区别</p>\r\n', '5', '2', '<p>String和StringBuff可以储存和操作字符串，即包含多个字符的字符数据。String类提供了数值不可改变的字符串，StringBuff则可变。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('250', null, '<p>java 中 char 类型变量能不能储存一个中文的汉字，为什么？</p>\r\n', '5', '2', '<p>java 的 char 类型变量是用来储存 Unicode 编码字符的，Unicode 字符集包含了汉字，所以 char 类型自然就能存储汉字，但是在某些特殊情况下某个生僻汉字可能没有包含在 Unicode 编码字符集中，这种情况下 char 类型就不能存储该生僻汉字了。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('251', null, '<p>基本数组去重的实现</p>\r\n', '5', '1', '<p>//&nbsp;最简单数组去重法<br />\r\nfunction&nbsp;unique1(array){<br />\r\n&nbsp;&nbsp;var&nbsp;n&nbsp;=&nbsp;[];&nbsp;//一个新的临时数组<br />\r\n&nbsp;&nbsp;//遍历当前数组<br />\r\n&nbsp;&nbsp;for(var&nbsp;i&nbsp;=&nbsp;0;&nbsp;i&nbsp;&lt;&nbsp;array.length;&nbsp;i++){<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;//如果当前数组的第i已经保存进了临时数组，那么跳过，<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;//否则把当前项push到临时数组里面<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;if&nbsp;(n.indexOf(array[i])&nbsp;==&nbsp;-1)&nbsp;n.push(array[i]);<br />\r\n&nbsp;&nbsp;}<br />\r\n&nbsp;&nbsp;return&', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('252', null, '<p>运行时异常和一般异常有什么区别</p>\r\n', '5', '2', '<p>运行时异常表示虚拟机的通常操作中可能发生的异常，是一种常见的运行错误。java编译时要求方法必须声明抛出可能的非运行时异常，但并不要求必须声明抛出未捕获的运行时异常。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('253', null, '<p>简单说说堆和栈各自的特点？</p>\r\n', '5', '2', '<p>栈是一种具有后进先出性质的数据结构，也就是说后存放的先取，先存放的后取。堆是一种经过排序的树形数据结构，每个结点都有一个值。通常我们所说的堆的数据结构，是指二叉堆。堆的特点是根结点的值最小（或最大），且根结点的两个子树也是一个堆。由于堆的这个特性，常用来实现优先队列，堆的存取是随意的。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('254', null, '<p>error和Exception的区别</p>\r\n', '5', '2', '<p>Error类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢等。<br />\r\nException类表示程序可以处理的异常，可以捕获且可能恢复。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('255', null, '<p>为什么不建议在代码中直接使用 Executors 创建线程池，而是推荐通过 ThreadPoolExecutor 方式创建？</p>\r\n', '5', '2', '<p>其实不直接使用工具类的目的只有一个，那就是可以明确的让我们知道线程池的运行规则，避免使用工具类的包装而不够直观内部机制而导致潜在的问题。譬如使用 Executors 的 FixedThreadPool 和 SingleThreadPool 创建线程池的原理都允许请求的队列长度为 Integer 的最大值，这样的话可能会堆积大量的请求导致 OOM；而使用 Executors 的 CachedThreadPool 和 ScheduledThreadPool 创建线程池的原理都允许创建线程数量为 Integer 的最大值，这样的话可能会导致创建大量的线程而导致 OOM，所以推荐直接通过明确的构造参数创建线程池，这样就相当与时刻提醒自己的线程池特性是什么。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('256', null, '<p>js中变量声明提前</p>\r\n', '5', '1', '<p>有许多同学知道js在执行的时候，是从上到下，从左到右，一行一行执行的，但是不知道在这之前还要做一些事情，js程序在正式执行之前，会将所有var&nbsp;声明的变量和function声明的函数，预读到所在作用域的顶部，但是对var&nbsp;声明只是将声明提前，赋值仍然保留在原位置，function&nbsp;声明，会将函数名称和函数体都提前，而且先预声明变量再预定义函数。这个过程也被叫做，&ldquo;预解析&rdquo;或者&ldquo;预编译&rdquo;。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('257', null, '<p>Java内存模型？</p>\r\n', '5', '2', '<p>1.程序计数器：是一个数据结构，用于保存当前正常执行的程序的内存地址。Java虚拟机的多线程就是通过线程轮流切换并分配处理器时间来实现的，为了线程切换后能恢复到正确的位置，每条线程都需要一个独立的程序计数器，互不影响，该区域为&ldquo;线程私有&rdquo;。<br />\r\n2.Java虚拟机栈：线程私有的，与线程生命周期相同，用于存储局部变量表，操作栈，方法返回值。局部变量表放着基本数据类型，还有对象的引用。<br />\r\n3.本地方法栈：跟虚拟机栈很像，不过它是为虚拟机使用到的Native方法服务。<br />\r\n4.Java堆：所有线程共享的一块内存区域，对象实例几乎都在这分配内存。<br />\r\n5.方法区：各个线程共享的区域，储存虚拟机加载的类信息，常量，静态变量，编译后的代码。<br />\r\n6.运行时常量池：代表运行时每个class文件中的常量表。包括几种常量：编译时的数字常量、方法或者域的引用。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('258', null, '<p>3.对JVM了解与否，还有一大堆项目中的细节问题</p>\r\n', '5', '5', '<p>jvm体系总体分四大块：</p>\r\n\r\n<ul>\r\n	<li>类的加载机制</li>\r\n	<li>jvm内存结构</li>\r\n	<li>GC算法 垃圾回收</li>\r\n	<li>GC分析 命令调优</li>\r\n</ul>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('259', null, '<p>说一说servlet的生命周期</p>\r\n', '5', '2', '<p>Servlet被服务器实例化后，容器运行其init()方法，请求到达时运行其service()方法，service方法自动派遣运行与请求对应的doXXX方法（doGet，doPost）等，当服务器决定将实例销毁的时候调用其destroy()方法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('260', null, '<p>你能不能谈谈，java GC是在什么时候，对什么东西，做了什么事情？</p>\r\n', '5', '2', '<p>1.新生代有一个Eden区和两个survivor区，首先将对象放入Eden区，如果空间不足就向其中的一个survivor区上放，如果仍然放不下就会引发一次发生在新生代的minor GC，将存活的对象放入另一个survivor区中，然后清空Eden和之前的那个survivor区的内存。在某次GC过程中，如果发现仍然又放不下的对象，就将这些对象放入老年代内存里去。<br />\r\n2.大对象以及长期存活的对象直接进入老年区。<br />\r\n3.当每次执行minor GC的时候应该对要晋升到老年代的对象进行分析，如果这些马上要到老年区的老年对象的大小超过了老年区的剩余大小，那么执行一次Full GC以尽可能地获得老年区的空间。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('261', null, '<p>overload 和 override 的区别</p>\r\n', '5', '2', '<p>Overload是重载，是有相同的方法名，但参数类型或个数彼此不同；<br />\r\nOverride是重写，是在子类与父类中，子类中的方法的方法名，参数个数、类型都与父类中的完全一样，在子类中覆盖掉了父类的改方法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('262', null, '<p>java和JavaScript的区别</p>\r\n', '5', '1', '<p>数据类型不同<br />\r\n<br />\r\nJava的数据类型分为8种，分别是：byte、short、int、long、float、double、char以及Boolean，而JavaScript的数据类型为三种，分别为：number、string和Boolean。<br />\r\n<br />\r\n除此之外，Java和Javascript变量方面也有不同。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('263', null, '<p>CAS（Compare And Swap） 无锁算法</p>\r\n', '5', '2', '<p>CAS是乐观锁技术，当多个线程尝试使用CAS同时更新同一个变量时，只有其中一个线程能更新变量的值，而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次尝试。CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('264', null, '<p>forward 和 redirect 的区别</p>\r\n', '5', '2', '<p>1.forward请求url地址栏不会改变，redirect请求会改变；<br />\r\n2.forward:转发页面和转发到的页面可以共享request域中的数据，redirect不能共享request域中的数据；<br />\r\n3.forward比redirect效率高；</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('265', null, '<p>项目当中用到了什么设计模式？</p>\r\n', '5', '2', '<p>适配器模式：将一个接口适配到另一个接口，Java I/O中InputStreamReader将Reader类适配到InputStream，从而实现了字节流到字符流的准换。<br />\r\n装饰者模式：保持原来的接口，增强原来有的功能。<br />\r\nFileInputStream 实现了InputStream的所有接口，BufferedInputStreams继承自FileInputStream是具体的装饰器实现者，将InputStream读取的内容保存在内存中，而提高读取的性能。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('266', null, '<p>Get与post传参得区别</p>\r\n', '5', '1', '<p>a)这个答案说几个很装逼别人又不知道得答案，比如get只发送一次tcp。而post发送两次tcp连接<br />\r\nb)Get传参有长度限制，post没有</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('267', null, '<p>执行完以下代码块后有几个String实例可以被垃圾回收器回收？</p>\r\n\r\n<pre>\r\n<code>String a =new String(\"a\");\r\n  String b =new String(\"b\");\r\n  String c =new String(\"c\");\r\n  b=a;\r\n  a=null;\r\n  c=b;</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '5', '2', '<p>1.只有一个String实例被回收，因为只有a实例为null,被垃圾回收器回收。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('268', null, '<p>请写出代理模式的两种模式？</p>\r\n', '5', '2', '<p>//懒汉式</p>\r\n\r\n<pre>\r\n<code>public class SingletonClass{\r\n    private static SingletonClass instance=null;\r\n    public static SingletonClass getInstance()\r\n    {\r\n        if(instance==null)\r\n        {\r\n            synchronized(SingletonClass.class)\r\n            {\r\n                if(instance==null)\r\n                    instance=new SingletonClass();\r\n            }\r\n        }\r\n        return instance;\r\n    }\r\n    private SingletonClass(){\r\n    }\r\n}</code></pre>\r\n\r\n<p><br />\r\n//饿汉式<br />\r\n&nbsp;<', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('269', null, '<p>说说使用cookie得弊端</p>\r\n', '5', '1', '<p>a)每个特定的域名下最多生成20个cookie<br />\r\nb)IE6或更低版本最多20个cookie</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('270', null, '<p>请写出ArrayList、LinkedList、vector的区别？</p>\r\n', '5', '2', '<p>ArrayList和LinkedList都间接的实现了List接口，都不是线程安全的(Vector是线程安全的)。<br />\r\nArrayList底层是基于数组结构，而LinkedList底层是基于链表(双链表)结构。<br />\r\nArrayList的查询修改快，LinkedList的增删速度快。<br />\r\nArrayList扩容是增长原来的一半也就是1.5倍(Vector是增长原来的2倍)，LinkedList是基于节点来扩容的。<br />\r\nArrayList初始化容量大小是10，vector初始化容量也是10。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('271', null, '<p>String、StringBuffer与StringBuilder之间区别？</p>\r\n', '5', '2', '<p>String为字符串常量，一旦被创建就不能修改它的值，对于已经存在的String对象修改都是重新创建一个新的对象，释放原String对象。String是final类，不能被继承。<br />\r\nStringBuffer和StringBuilder都是字符串变量，对它修改时不会像String那样重新建立对象，StringBuffer和StringBuilder只能通过构造来创建，不能通过赋值符号&quot; = &quot;来赋值，初始化为null，通过构造参数或append方法来完成赋值操作。在字符串的操作中sb的效率要高于String。<br />\r\n在一般情况下执行速度：StringBuilder &gt; &nbsp;StringBuffer &nbsp;&gt; &nbsp;String；<br />\r\n特殊情况：String的效率大于StringBuffer/StringBuilder<br />\r\nStringstr=&ldquo;Thisisonlya&rdquo;+&ldquo;simple&rdquo;+&ldquo;test&rdquo;;<br />\r\nSt', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('272', null, '<p>请说出几种减少页面加载时间得方法</p>\r\n', '5', '2', '<p>a)优化图片<br />\r\nb)减少http请求<br />\r\nc)压缩并且合并css</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('273', null, '<p>Javascript&nbsp;如何实现继承?</p>\r\n', '5', '2', '<p>原型链继承,借用构造函数继承,组合继承,寄生式继承,寄生组合继承&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('274', null, '<p>简述servlet的生命周期？</p>\r\n', '5', '2', '<p>servlet的生命周期分为三个阶段： &nbsp;<br />\r\n1、初始化阶段，调用init()方法<br />\r\n如果在web.xml的servlet标签中添加&lt;loadon-startup&gt;1&lt;/loadon-startup&gt;。那么启动服务器时加载servlet并创建servlet对象，在调用init方法初始化配置。<br />\r\n如果没配置启动项，那么当首次访问servlet时servlet对象并调用init方法初始化servlet。<br />\r\ninit()方法只执行一次，也就是说servlet是一个单例。<br />\r\n2、响应客户请求阶段 调用service()方法<br />\r\n每次请求servlet时，servlet容器会创建请求的ServletRequest对象和ServletResponse对象，然后调用Servlet的service方法。service方法从ServletRequest对象获得客户请求信息，处理该请求，并通过ServletResponse对象向客户返回响应信息。<br />\r\n3、销毁阶段 调用destroy()', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('275', null, '<p>前端页面有哪三层构成这三层分别是什么</p>\r\n', '5', '2', '<p>结构层，表示层，行为层&nbsp;&nbsp;（行为层是js操作dom得主体部分）</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('276', null, '<p>输出数据库连接池的工作机制是什么？</p>\r\n', '5', '2', '<p>数据库连接池的工作机制: 数据库连接池在初始化时将创建一定数量的数据库连接放到连接池中，这些数据库连接的数量是由最小数据库连接数来设定的。无论这些数据库连接是否被使用，连接池都将一直保证至少拥有这么多的连接数量。连接池的最大数据库连接数量限定了这个连接池能占有的最大连接数，当应用程序向连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列中。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('277', null, '<p>Javascript&nbsp;创建对象的几种方式?</p>\r\n', '5', '2', '<p>工厂方式,构造函数方式,原型模式,混合构造函数原型模式,动态原型方式&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('278', null, '<p>简单说明dom事件冒泡</p>\r\n', '5', '2', '<p>假设一个元素div，有一个下级元素p，，两个元素都绑定了click事件，用户点击了p，p先触发，div后触发，这就是事件冒泡</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('279', null, '<p>闭包是什么，有什么特性，对页面有什么影响</p>\r\n', '5', '1', '<p>闭包是一个封闭的隔离的空间，在js中表现为函数所构成的外部无法访问的区域，当函数被外部引用时，就创建了该函数的闭包&nbsp;&nbsp;闭包的实质是一个函数，是一个用于返回局部变量值的函数，因为在全局中，受JavaScript链式作用域结构的影响，父级变量中无法访问到子级的变量值，为了解决这个问题，才使用闭包这个概念。&nbsp;闭包的特性：&nbsp;①.封闭性：外界无法访问闭包内部的数据，如果在闭包内声明变量，外界是无法访问的，除非闭包主动向外界提供访问接口；&nbsp;②.持久性：一般的函数，调用完毕之后，系统自动注销函数，而对于闭包来说，在外部函数被调用之后，闭包结构依然保存在&nbsp;系统中，闭包中的数据依然存在，从而实现对数据的持久使用。&nbsp;<br />\r\n优点：&nbsp;①&nbsp;减少全局变量。&nbsp;②&nbsp;减少传递函数的参数量&nbsp;③&nbsp;封装；&nbsp;&nbsp;&nbsp;&nbsp;<br />\r\n缺点：&nbsp;使用闭包会占有内存资源，过多的使用闭包会导致内存泄露等.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('280', null, '<p>阻止事件冒泡&nbsp;</p>\r\n', '5', '2', '<p>function&nbsp;stopPropagation(e)&nbsp;{&nbsp;e&nbsp;=&nbsp;e&nbsp;||&nbsp;window.event;&nbsp;if(e.stopPropagation)&nbsp;{&nbsp;<br />\r\ne.stopPropagation();&nbsp;}&nbsp;else&nbsp;{&nbsp;<br />\r\ne.cancelBubble&nbsp;=&nbsp;true;&nbsp;<br />\r\n//DOM&nbsp;阻止冒泡方法&nbsp;<br />\r\n//IE&nbsp;阻止冒泡方法&nbsp;<br />\r\n}&nbsp;}&nbsp;</p>\r\n\r\n<pre>\r\n<code class=\"language-javascript\">\"function stopPropagation(e) { e = e || window.event; if(e.stopPropagation) { \r\ne.stopPropagation(); } else { \r\ne.cancelBubble = true;', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('281', null, '<p>你如何优化自己的代码?&nbsp;</p>\r\n', '5', '2', '<p>代码重用避免全局变量(命名空间,封闭空间,模块化&nbsp;mvc..) 拆分函数避免函数过于臃肿:单一职责原则&nbsp;适当的注释,尤其是一些复杂的业务逻辑或者是计算逻辑,都应该写出这个业务逻辑的具体过程&nbsp;内存管理,尤其是闭包中的变量释放&nbsp;<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('282', null, '<p>请尽可能详尽的解释&nbsp;ajax&nbsp;思路:先解释异步,再解释&nbsp;ajax&nbsp;如何使用(后面还有专题)&nbsp;&nbsp;</p>\r\n', '5', '2', '<p>Ajax&nbsp;的原理简单来说通过&nbsp;XmlHttpRequest&nbsp;对象来向服务器发异步请求,从服务器获得据,然后用&nbsp;javascript&nbsp;来操作&nbsp;DOM&nbsp;而&nbsp;更新页面.这其中最关键的一步就是从服务器获得请求数据.要清楚这个过程和原理,我们必须对&nbsp;XMLHttpRequest&nbsp;有所了&nbsp;解.XMLHttpRequest&nbsp;是&nbsp;ajax&nbsp;的核心机制,它是在&nbsp;IE5&nbsp;中首先引入的,是一种支持异步请求的技术.简单的说,也就是&nbsp;javascript&nbsp;可以&nbsp;及时向服务器提出请求和处理响应,而不阻塞用户.达到无刷新的效果&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('283', null, '<p>HTTP&nbsp;协议中,GET&nbsp;和&nbsp;POST&nbsp;有什么区别?分别使用什么场景?&nbsp;</p>\r\n', '5', '2', '<p>get&nbsp;传送的数据长度有限制,post&nbsp;没有get&nbsp;通过&nbsp;url&nbsp;传递,在浏览器地址栏可见,post&nbsp;是在报文中传递&nbsp;post&nbsp;一般用于表单提交. get&nbsp;一般用于简单的数据查询,严格要求不是那么高的场景&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('284', null, '<p>那些操作会造成HTML页面回流与重绘</p>\r\n', '5', '1', '<p>调整窗口大小；改变字体大小；样式表变动；元素内容变化，尤其是输入控件；CSS伪类激活；DOM操作；offsetWidth,&nbsp;width,&nbsp;clientWidth,&nbsp;scrollTop/scrollHeight的计算，&nbsp;会使浏览器将渐进回流队列Flush，立即执行回流。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('285', null, '<p>写出冒泡排序的实现</p>\r\n', '5', '2', '<pre>\r\n<code>void bubble_sort(int arr[], int len) {  \r\n    int i, j;  \r\n    for (i = 0; i &lt; len - 1; i++)    //外层循环控制趟数，总趟数为len-1\r\n        for (j = 0; j &lt; len - 1 - i; j++)  //内层循环为当前i趟数 所需要比较的次数\r\n            if (arr[j] &gt; arr[j + 1])  \r\n                swap(arr[j], arr[j + 1]);          \r\n} </code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('286', null, '<p>如何判断一个&nbsp;js&nbsp;变量是数组类型</p>\r\n', '5', '2', '<pre>\r\n<code class=\"language-javascript\">ES5:Array.isArray(); [] instanceof Array; 调用数组的 slice 方法; Object.prototype.toString.call([]); // \"[object Array]\" \r\n</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('287', null, '<p>integer如何判断相等</p>\r\n', '5', '2', '<p>Integer为对象判断是否相等还是使用equals最靠谱，int为基本类型，判断是否相等就是可以使用==</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('288', null, '<p>简述src和href的区别</p>\r\n', '5', '2', '<p>src是source的缩写，是在页面中引入某种资源,当浏览器解析到src时，会暂停浏览器的渲染，直到该资源加载完毕；href用于在当前文档和引用资源之间建立联系。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('289', null, '<p>scss&nbsp;是什么?在&nbsp;vue.cli&nbsp;中的安装使用步骤是?有哪几大特性?&nbsp;</p>\r\n', '5', '2', '<p>css&nbsp;的预编译。 使用步骤: 第一步:用&nbsp;npm&nbsp;下三个&nbsp;loader(sass-loader、css-loader、node-sass)&nbsp;<br />\r\n第二步:在&nbsp;build&nbsp;目录找到&nbsp;webpack.base.config.js，在那个&nbsp;extends&nbsp;属性中加一个拓展.scss&nbsp;第三步:还是在同一个文件，配置一个&nbsp;module&nbsp;属性 第四步:然后在组件的&nbsp;style&nbsp;标签加上&nbsp;lang&nbsp;属性&nbsp;，例如:lang=&rdquo;scss&rdquo; 有哪几大特性:&nbsp;<br />\r\n1、可以用变量，例如($变量名称=值);&nbsp;2、可以用混合器，例如() 3、可以嵌套 5、mint-ui&nbsp;是什么?怎么使用?说出至少三个组件使用方法?&nbsp;答:基于&nbsp;vue&nbsp;的前端组件库。npm&nbsp;安装，然后&nbsp;import&nbsp;样式和&nbs', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('290', null, '<p>编写一个方法，去掉一个数组的重复元素</p>\r\n', '5', '2', '<p>去除重复的数组：&nbsp;<br />\r\n&nbsp;* 方法一：需要一个存储去重后元素的数组，然后两层循环，外层遍历原数组，内容逐个判断是否和之后的元素重复，然后再提出来存入新的数组。方法System.arraycopy(被复制的数组，起始下标，接收的新数组，起始下标，结束下标);可以直接复制数组，既然这样，我就没必要纠结新数组的长度了，直接声明一个跟原数组长度一样的临时数组，只要记录下去重后的元素个数，然后就可以确定去重后数组长度再去将临时数组拷贝到新数组就行了。&nbsp;<br />\r\n&nbsp;* 方法二:只需要创建一个集合，然后遍历数组逐一放入集合，只要在放入之前用contains()方法判断一下集合中是否已经存在这个元素就行了，然后用toArray转成数组一切搞定。&nbsp;<br />\r\n&nbsp;* 方法三：最简单的方法就是利用Set集合无序不可重复的特性进行元素过滤。&nbsp;<br />\r\n&nbsp;* 方法四：链表的哈希集合：有顺序，不重复。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('291', null, '<p>new&nbsp;Object()的原理是什么？</p>\r\n', '5', '2', '<p>1)创建一个空对象，并且&nbsp;this&nbsp;变量引用该对象，同时还继承了该函数的原型。<br />\r\n2)属性和方法被加入到&nbsp;this&nbsp;引用的对象中。<br />\r\n3)新创建的对象由&nbsp;this&nbsp;所引用，并且最后隐式的返回&nbsp;this&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('292', null, '<p>axios+tp5&nbsp;进阶中，调用&nbsp;axios.post(&lsquo;api/user&rsquo;)是进行的什么操作?&nbsp;axios.put(&lsquo;api/user/8&prime;)呢?&nbsp;</p>\r\n', '5', '2', '<p>跨域，添加用户操作，更新操作。 9、什么是&nbsp;RESTful&nbsp;API?怎么使用? 答:是一个&nbsp;api&nbsp;的标准，无状态请求。请求的路由地址是固定的， 如果是&nbsp;tp5&nbsp;则先路由配置中把资源路由配置好。标准有:.post&nbsp;.put&nbsp;.delete&nbsp;10、vuex&nbsp;是什么?怎么使用?哪种功能场景使用它? 答:vue&nbsp;框架中状态管理。在&nbsp;main.js&nbsp;引入&nbsp;store，注入。 新建了一个目录&nbsp;store，.....&nbsp;export&nbsp;。&nbsp;场景有:单页应用中，组件之间的状态。音乐播放、登录状态、加入购物车&nbsp;11、mvvm&nbsp;框架是什么?它和其它框架(jquery)的区别是什么?哪些场景合?&nbsp;答:一个&nbsp;model+view+viewModel&nbsp;框架，数据模型&nbsp;model，viewModel&nbsp;连接两个&nbsp;区别:vue&nbsp;数据驱动，通过数据来', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('293', null, '<p>请写出常用的java多线程启动方式，Executors线程池有几种常用类型</p>\r\n', '5', '2', '<p>线程池作用就是限制系统中执行线程的数量。根据系统的环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；少了浪费了系统资源，多了造成系统拥挤效率不高。用线程池控制线程数量，其他线程 排队等候。一个任务执行完毕，再从队列的中取最前面的任务开始执行。若队列中没有等待进程，线程池的这一资源处于等待。当一个新任务需要运行时，如果线程 池中有等待的工作线程，就可以开始运行了；否则进入等待队列。Java里面线程池的顶级接口是Executor，但是严格意义上讲Executor并不是一个线程池，而只是一个执行线程的工具。真正的线程池接口是ExecutorService。ThreadPoolExecutor是Executors类的底层实现。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('294', null, '<p>请介绍你知道的多线程并发控制方法</p>\r\n', '5', '2', '<p>线程池、线程同步、互斥锁、读写锁、原子数、唤醒、通知、信号量、线程交换队列</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('295', null, '<p>typescript和javascript有和异同？</p>\r\n', '5', '2', '<p>typescript是javascript的超集，它可以编译成纯javascript；typescript是对es6的具体实现，引入了数据类型的概念，声明一个变量的时候如果指定了数据类型，那么赋值的时候要给其对应数据类型的值，否则程序会报错。Typescript中使用class来声明一个类，通过extends关键字来实现继承。简言之typescript使得前端开发和后端开发越来越接近。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('296', null, '<p>jdk9新特性有哪些</p>\r\n', '5', '3', '<p>1. Java 平台级模块系统。2. Linking。3. JShell : 交互式 Java REPL。4. 改进的 Javadoc。5. 集合工厂方法改进的 。6.Stream API。7. 私有接口方法。8. HTTP/2。9. 多版本兼容 JAR</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('297', null, '<p>序列化的作用是什么</p>\r\n', '5', '3', '<p>序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。序列化是为了解决对象流读写操作时可能引发的问题（如果不进行序列化可能会存在数据乱序的问题）。&nbsp;<br />\r\n要实现序列化，需要让一个类实现Serializable接口，该接口是一个标识性接口，标注该类对象是可被序列化的，然后使用一个输出流来构造一个对象输出流并通过writeObject(Object)方法就可以将实现对象写出（即保存其状态）；如果需要反序列化则可以用一个输入流建立对象输入流，然后通过readObject方法从流中读取对象。序列化除了能够实现对象的持久化之外，还能够用于对象的深度克隆</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('298', null, '<p>GC得回收机制</p>\r\n', '5', '4', '<p>GC就是垃圾回收机制：在系统运行过程中，会产生一些无用的对象，这些对象占据着一定的内存，如果不对这些对象清理回收无用对象的内存，可能会导致内存的耗尽，所以垃圾回收机制回收的是内存。同时GC回收的是堆区和方法区的内存。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('299', null, '<p>简述Javascript的垃圾回收机制</p>\r\n', '5', '1', '<p>现在各大浏览器通常用采用的垃圾回收有两种方法：标记清除、引用计数。<br />\r\n标记清除：<br />\r\n这是javascript中最常用的垃圾回收方式。当变量进入执行环境是，就标记这个变量为&ldquo;进入环境&rdquo;。从逻辑上讲，永远不能释放进入环境的变量所占用的内存，因为只要执行流进入相应的环境，就可能会用到他们。当变量离开环境时，则将其标记为&ldquo;离开环境&rdquo;。垃圾收集器在运行的时候会给存储在内存中的所有变量都加上标记。然后，它会去掉环境中的变量以及被环境中的变量引用的标记。而在此之后再被加上标记的变量将被视为准备删除的变量，原因是环境中的变量已经无法访问到这些变量了。最后。垃圾收集器完成内存清除工作，销毁那些带标记的值，并回收他们所占用的内存空间。<br />\r\n引用计数：<br />\r\n另一种不太常见的垃圾回收策略是引用计数。引用计数的含义是跟踪记录每个值被引用的次数。当声明了一个变量并将一个引用类型赋值给该变量时，则这个值的引用次数就是1。相反，如果包含对这个值引用的变量又取得了另外一个值，则这个值的引用次数就减1。当这个引用次数变成0时', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '3', '3', '1');
INSERT INTO `t_question` VALUES ('300', null, '<p>有如下一串数字1,1,2,3,5,8...用算法实现第二十个数字的值是什么（提示：递归算法）</p>\r\n', '5', '2', '<pre>\r\n<code>public class Test1 {\r\n   public static void main(String[] args) {\r\n  System.out.print(1+\",\");\r\n  System.out.print(1+\",\");\r\n  int f1 = 1, f2 = 1, f, M=10;\r\n       for(int i=3; i&lt;=M; i++) {\r\n        f = f2;\r\n        f2 = f1 + f2;\r\n        f1 = f;\r\n        System.out.print(f2+\",\");\r\n           }\r\n  }\r\n  }</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('301', null, '<p>你了解使用过哪些算法？</p>\r\n', '5', '3', '<p>见的算法和数据结构：字符串，链表，树，图，排序，递归 vs. 迭代，动态规划，位操作，概率问题，排列组合，</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('302', null, '<p>String、StringBuffer和StringBuilder之间的区别</p>\r\n', '5', '2', '<p>这三个类之间的区别主要是在两个方面，即运行速度和线程安全这两方面。<br />\r\n1、首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder &gt; StringBuffer &gt; String<br />\r\n　　String最慢的原因：<br />\r\n　　String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。<br />\r\n2、在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的。<br />\r\n3、总结一下：<br />\r\n&nbsp; &nbsp; &nbsp; String：适用于少量的字符串操作的情况<br />\r\n　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况<br />\r\n　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('303', null, '<p>请解释一下&nbsp;<strong>JavaScript&nbsp;</strong>的同源策略。</p>\r\n', '5', '2', '<p>同源策略是客户端脚本(尤其是&nbsp;Javascript)的重要的安全度量标准。它最早&nbsp;出自&nbsp;Netscape&nbsp;Navigator2.0，其目的是防止某个文档或脚本从多个不同源装&nbsp;载。所谓同源指的是:协议，域名，端口相同，同源策略是一种安全协议，指&nbsp;一段脚本只能读取来自同一来源的窗口和文档的属性。&nbsp;<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('304', null, '<p>JavaEE中的设计模式有哪些？谈谈你对工厂模式的理解？</p>\r\n', '5', '4', '<p>Java中的23种设计模式：&nbsp;<br />\r\nFactory（工厂模式）， &nbsp; &nbsp; &nbsp;Builder（建造模式）， &nbsp; &nbsp; &nbsp; Factory Method（工厂方法模式）， Prototype（原始模型模式），Singleton（单例模式）， &nbsp; &nbsp;Facade（门面模式）， Adapter（适配器模式）， &nbsp; &nbsp;Bridge（桥梁模式）， &nbsp; &nbsp; &nbsp; &nbsp;Composite（合成模式）， Decorator（装饰模式）， &nbsp; &nbsp;Flyweight（享元模式）， &nbsp; &nbsp; Proxy（代理模式）， Command（命令模式）， &nbsp; &nbsp; &nbsp;Interpreter（解释器模式）， Visitor（访问者模式）， Iterator（迭代子模式）， &nbsp; Mediator（调停者模式）， &nbsp; &nbsp;Memento（备忘录模式），&nbsp;<br /', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('305', null, '<p>多线程(实现多线程的三种方式)</p>\r\n', '5', '1', '<p>1、 继承Thread类实现多线程<br />\r\n2、 实现Runnable接口方式实现多线程<br />\r\n3、通过线程池创建线程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('306', null, '<p>ArrayList 和 LinkedList 有什么区别。</p>\r\n', '5', '2', '<p>ArrayList和LinkedList都实现了List接口，有以下的不同点：<br />\r\n1、ArrayList是基于索引的数据接口，它的底层是数组。它可以以O(1)时间复杂度对元素进行随机访问。与此对应，LinkedList是以元素列表的形式存储它的数据，每一个元素都和它的前一个和后一个元素链接在一起，在这种情况下，查找某个元素的时间复杂度是O(n)。<br />\r\n2、相对于ArrayList，LinkedList的插入，添加，删除操作速度更快，因为当元素被添加到集合任意位置的时候，不需要像数组那样重新计算大小或者是更新索引。<br />\r\n3、LinkedList比ArrayList更占内存，因为LinkedList为每一个节点存储了两个引用，一个指向前一个元素，一个指向下一个元素。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('307', null, '<p>数据库里面的索引和约束是什么?</p>\r\n', '5', '2', '<p>索引是为了提高数据的检索速度，索引是建立在数据表上，根据一个或多个字段建立的约束是为了保持数据的完整性，约束有非空约束，主键约束，外键约束等等。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('308', null, '<p>.Hibernate工作原理及为什么要用?</p>\r\n', '5', '2', '<p>原理： 1.读取并解析配置文件 2.读取并解析映射信息，创建SessionFactory 3.打开Session 4.创建事务Transation 5.持久化操作 6.提交事务 7.关闭Session 8.关闭SesstionFactory</p>\r\n\r\n<p>为什么要用： 1. 对JDBC访问数据库的代码做了封装，大大简化了数据访问层繁琐的重复性代码。 2. Hibernate是一个基于JDBC的主流持久化框架，是一个优秀的ORM实现。他很大程度的简化DAO层的编码工作 3. hibernate使用Java反射机制，而不是字节码增强程序来实现透明性。 4. hibernate的性能非常好，因为它是个轻量级框架。映射的灵活性很出色。它支持各种关系数据库，从一对一到多对多的各种复杂关系。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('309', null, '<p>Bean 工厂和 Application contexts 有什么区别？</p>\r\n', '5', '2', '<p>Application contexts提供一种方法处理文本消息，一个通常的做法是加载文件资源（比如镜像），它们可以向注册为监听器的bean发布事件。另外，在容器或容器内的对象上执行的那些不得不由bean工厂以程序化方式处理的操作，可以在Application contexts中以声明的方式处理。Application contexts实现了MessageSource接口，该接口的实现以可插拔的方式提供获取本地化消息的方法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('310', null, '<p>Enumeration和Iterator的主要区别</p>\r\n', '5', '2', '<p>（1）java中的集合类都提供了返回Iterator的方法，就是迭代器，它和Enumeration（枚举）的主要区别其实就是Iterator可以删除元素，但是Enumration却不能。<br />\r\n&nbsp;（2）还有一点要注意的就是，使 用Iterator来遍历集合时，应使用Iterator的remove()方法来删除集合中的元素，使用集合的remove()方法将抛出ConcurrentModificationException异常。<br />\r\n&nbsp;（3）Enumeration 接口的功能与 Iterator 接口的功能是重复的。此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名。新的实现应该优先考虑使用 Iterator 接口而不是Enumeration 接口。<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('311', null, '<p>Http有没有状态，如果没有状态，怎么解决http无状态？</p>\r\n', '5', '2', '<p>无状态的，一般使用cookie和session技术做会话跟踪</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('312', null, '<p>什么是分布式锁？</p>\r\n', '5', '3', '<p>控制分布式系统之间同步访问共享资源的一种方式。在分布式系统中，常常需要协调他们的动作。如果不同的系统或是同一个系统的不同主机之间共享了一个或一组资源，那么访问这些资源的时候，往往需要互斥来防止彼此干扰来保证一致性，在这种情况下，便需要使用到分布式锁。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('313', null, '<p>int和integer区别？</p>\r\n', '5', '2', '<p>（1）Integer是int的包装类；int是基本数据类型；&nbsp;<br />\r\n（2）Integer变量必须实例化后才能使用；int变量不需要；&nbsp;<br />\r\n（3）Integer实际是对象的引用，指向此new的Integer对象；int是直接存储数据值 ；&nbsp;<br />\r\n（4）Integer的默认值是null；int的默认值是0。<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('314', null, '<p>对ES678了解吗？如果了解请列举</p>\r\n', '5', '2', '<p>ES6中新增的特性：<br />\r\n箭头操作符（箭头函数）<br />\r\n类的支持（class关键字）<br />\r\n增强的对象字面量<br />\r\n字符串模板<br />\r\nlet与const&nbsp;关键字<br />\r\n模块</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('315', null, '<p>maven依赖路径最短优先原则</p>\r\n', '5', '2', '<p>一个项目Demo依赖了两个jar包，其中A-B-C-X(1.0) ， A-D-X(2.0)。由于X(2.0)路径最短，所以项目使用的是X(2.0)。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('316', null, '<p>如何解决jar冲突</p>\r\n', '5', '2', '<p>遇到冲突的时候第一步要找到maven加载的到时是什么版本的jar包，通过们mvn dependency:tree查看依赖树，通过maven的依赖原则来调整坐标在pom文件的申明顺序是最好的办法。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('318', null, '<p>请说出vue.cli项目中src目录每个文件夹和文件的用法？</p>\r\n', '5', '2', '<p>assets文件夹是放静态资源；components是放组件；router是定义路由相关的配置;view视图；app.vue是一个应用主组件；main.js是入口文件</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('319', null, '<p>active-class&nbsp;是哪个组件的属性?嵌套路由怎么定义?&nbsp;</p>\r\n', '5', '2', '<p><strong>vue-router&nbsp;模块的&nbsp;router-link&nbsp;组件。 2、怎么定义&nbsp;vue-router&nbsp;的动态路由?怎么获取传过来的动态参数?&nbsp;<br />\r\n答:在&nbsp;router&nbsp;目录下的&nbsp;index.js&nbsp;文件中，对&nbsp;path&nbsp;属性加上/:id。&nbsp;使用&nbsp;router&nbsp;对象的&nbsp;par&nbsp;ams.id&nbsp;vue-router&nbsp;有哪几种导航钩子?&nbsp;答:三种，一种是全局导航钩子:router.beforeEach(to,from,next)，&nbsp;作用:跳转前进行判断拦截。第二种:组件内的钩子;第三种:单独路由独享组件&nbsp;4、scss&nbsp;是什么?安装使用的步骤是?有哪几大特性? 答:预处理&nbsp;css，把&nbsp;css&nbsp;当前函数编写，定义变量,嵌套。&nbsp;<br />\r\n先装&nbsp;css-loader、node-loader、s', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('320', null, '<p>axios+tp5&nbsp;进阶中，调用&nbsp;axios.post(&lsquo;api/user&rsquo;)是进行的什么操作?&nbsp;axios.put(&lsquo;api/user/8&prime;)呢?</p>\r\n', '5', '2', '<p>跨域，添加用户操作，更新操作。 9、什么是&nbsp;RESTful&nbsp;API?怎么使用? 答:是一个&nbsp;api&nbsp;的标准，无状态请求。请求的路由地址是固定的， 如果是&nbsp;tp5&nbsp;则先路由配置中把资源路由配置好。标准有:.post&nbsp;.put&nbsp;.delete&nbsp;10、vuex&nbsp;是什么?怎么使用?哪种功能场景使用它? 答:vue&nbsp;框架中状态管理。在&nbsp;main.js&nbsp;引入&nbsp;store，注入。 新建了一个目录&nbsp;store，.....&nbsp;export&nbsp;。&nbsp;场景有:单页应用中，组件之间的状态。音乐播放、登录状态、加入购物车&nbsp;11、mvvm&nbsp;框架是什么?它和其它框架(jquery)的区别是什么?哪些场景合?&nbsp;答:一个&nbsp;model+view+viewModel&nbsp;框架，数据模型&nbsp;model，viewModel&nbsp;连接两个&nbsp;区别:vue&nbsp;数据驱动，通过数据来', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('321', null, '<p>SESSION 与COOKIE 的区别是什么？</p>\r\n', '5', '2', '<p>cookie 是存放在浏览器端，不同的浏览器存储的cookie数量和数据的大小都不一致。大多数情况下单个域名限制最多保存20个cookie，每个cookie保存的数据不能超过4K。session存储在服务端，默认是以文件的形式存储，也可以存储在数据库和redis、memcache等缓存内存中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('322', null, '<p>Vue&nbsp;的双向数据绑定原理是什么?</p>\r\n', '5', '2', '<p>vue.js&nbsp;是采用数据劫持结合发布者-订阅者模式的方式，通过&nbsp;Object.defineProperty()&nbsp;<br />\r\n来劫持各个属性的&nbsp;setter，getter，在数据变动时发布消息给订阅者，触发相应的监听回调。&nbsp;具体步骤:&nbsp;<br />\r\n第一步:需要&nbsp;observe&nbsp;的数据对象进行递归遍历，包括子属性对象的属性，都加上&nbsp;setter&nbsp;和&nbsp;getter&nbsp;<br />\r\n这样的话，给这个对象的某个值赋值，就会触发&nbsp;setter，那么就能监听到了数据变化&nbsp;<br />\r\n第二步:compile&nbsp;解析模板指令，将模板中的变量替换成数据，然后初始化渲染页面视图，并&nbsp;将每个指令对应的节点绑定更新函数，添加监听数据的订阅者，一旦数据有变动，收到通知，&nbsp;更新视图&nbsp;<br />\r\n第三步:Watcher&nbsp;订阅者是&nbsp;Observer&nbsp;和&nbsp;Compile&nbsp;之间', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('323', null, '<p>谈谈angularjs最核心的东西</p>\r\n', '5', '1', '<p>最为核心的是：&nbsp;<br />\r\nMVC<br />\r\n模块化<br />\r\n自动化双向数据绑定<br />\r\n语义化标签、依赖注入等等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('324', null, '<p>vue-loader&nbsp;是什么?使用它的用途有哪些? </p>\r\n', '5', '2', '<p>解析.vue&nbsp;文件的一个加载器，跟&nbsp;template/js/style&nbsp;转换成&nbsp;js&nbsp;模块。&nbsp;<br />\r\n用途:js&nbsp;可以写&nbsp;es6、style&nbsp;样式可以&nbsp;scss&nbsp;或&nbsp;less、template&nbsp;可以加&nbsp;jade&nbsp;等&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('325', null, '<p>请说出&nbsp;vue.cli&nbsp;项目中&nbsp;src&nbsp;目录每个文件夹和文件的用法?&nbsp;</p>\r\n', '5', '2', '<p><strong><strong>assets&nbsp;</strong>文件夹是放静态资源;<strong>components&nbsp;</strong>是放组件;<strong>router&nbsp;</strong>是定义路由相关的配置<strong>;vie&nbsp;w&nbsp;</strong>视图;<strong>app.vue&nbsp;</strong>是一个应用主组件;<strong>main.js&nbsp;</strong>是入口文件&nbsp;</strong></p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('326', null, '<p>说明 PHP 中传值和传引用的区别?</p>\r\n', '5', '2', '<p>传值：<br />\r\n是把实参的值赋值给形参，那么对形参的修改，不会影响实参的值<br />\r\n传地址：<br />\r\n是传值的一种特殊方式，只是他传递的是地址，不是普通的如int<br />\r\n那么传地址以后，实参和形参都指向同一个对象<br />\r\n传引用：<br />\r\n真正的以地址的方式传递参数<br />\r\n传递以后，形参和实参都是同一个对象，只是他们名字不同而已<br />\r\n对形参的修改将影响实参的值</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('327', null, '<p>vue/angular单页应用有哪些优缺点？</p>\r\n', '5', '2', '<p>优点：<br />\r\n速度：更好的用户体验，让用户在web&nbsp;app感受native&nbsp;app的速度和流畅，&nbsp;MVC：经典MVC开发模式，前后端各负其责。&nbsp;ajax：重前端，业务逻辑全部在本地操作，数据都需要通过AJAX同步、提交。&nbsp;路由：在URL中采用#号来作为当前视图的地址,改变#号后的参数，页面并不会重载。<br />\r\n分离前后端关注点，前端负责界面显示，后端负责数据存储和计算，各司其职，不会把前后端的逻辑混杂在一起；&nbsp;减轻服务器压力，服务器只用出数据就可以，不用管展示逻辑和页面合成，吞吐能力会提高几倍；&nbsp;同一套后端程序代码，不用修改就可以用于Web界面、手机、平板等多种客户端；&nbsp;<br />\r\n缺点：<br />\r\nSEO问题，现在可以通过Prerender等技术解决一部分；&nbsp;前进、后退、地址栏等，需要程序进行管理；&nbsp;书签，需要程序来提供支持；</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('328', null, '<p>vue框架的优缺点<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '2', '<p>优点：Vue.js是一个构建数据驱动的&nbsp;web&nbsp;界面的渐进式框架。Vue.js&nbsp;的目标是通过尽可能简单的&nbsp;API&nbsp;实现响应的数据绑定和组合的视图组件。核心是一个响应的数据绑定系统。1.轻量级的框架2.双向数据绑定3.指令4.插件化&nbsp;&nbsp;&nbsp;</p>\r\n\r\n<p>缺点：不支持低端浏览器。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('329', null, '<p>2.vue的HTTP请求的原理？<br />\r\n&nbsp;&nbsp;</p>\r\n', '5', '2', '<p>vue1.0中的$http服务&nbsp;&nbsp;需要引入一个叫vue-resource.js的文件，因为vue.js中没有$http服务。如果需要使用这个服务去百度下载vue-resource.js&nbsp;然后引进项目即可。vue2.0版本引入axios</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('330', null, '<p>3.瀑布流实现的原理？</p>\r\n', '5', '2', '<p>瀑布流布局要求要进行布置的元素等宽，然后计算元素的宽度与浏览器宽度之比，得到需要布置的列数。创建一个数组，长度为列数，里面的值为已布置元素的总高度（最开始为0）然后将未布置的元素依次布置到高度最小的那一列，就得到了瀑布流布局。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('331', null, '<p>JQeury常用的API有哪些？</p>\r\n', '5', '2', '<pre>\r\n<code class=\"language-javascript\">\"jQuery使用addClass()方法给元素加class\r\n$(\"\".well\"\").addClass(\"\"animated shake\"\");\r\njQuery根据id属性来获取元素\r\n渐变隐藏效果\r\n$(\"\"#target3\"\").addClass(\"\"animated fadeOut\"\");\r\n三种选择器\r\n元素选择器：$(\"\"button\"\")\r\nclass选择器：$(\"\".btn\"\")\r\nid选择器：$(\"\"#target1\"\")\r\n使用jQUery删除HTML元素的class\r\n$(\"\"#target2\"\").removeClass(\"\"btn-default\"\");\r\n使用jQUery改变HTML元素的css样式\r\n选择器.css(“属性”,”值”);\r\n$(\"\"#target1\"\").css(\"\"color\"\",\"\"red\"\");\r\n使用jQUery设置元素不可用\r\n$(\"\"#target1\"\").prop(\"\"disabled\"\",true);\r\njQuery使用text()改变文本内', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('332', null, '<p>如何做上传二进制流图片？<br />\r\n&nbsp;&nbsp;</p>\r\n', '5', '5', '<pre>\r\n<code class=\"language-javascript\">\"function convertImgToBase64(url, callback, outputFormat){\r\n    var canvas = document.createElement(\'CANVAS\'),\r\n        ctx = canvas.getContext(\'2d\'),\r\n        img = new Image;\r\n    img.crossOrigin = \'Anonymous\';\r\n    img.onload = function(){\r\n        canvas.height = img.height;\r\n        canvas.width = img.width;\r\n        ctx.drawImage(img,0,0);\r\n        var dataURL = canvas.toDataURL(outputFormat || \'image/png\');\r\n        callback.call(this, dataURL);\r\n ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('333', null, '<p>H5的离线缓存？</p>\r\n', '5', '2', '<p>&nbsp;HTML5提供了很多新的功能以及相应的接口，离线存储就是其中的一个，离线存储可以将站点的一些文件存储在本地，在没有网络的时候还是可以访问到以缓存的对应的站点页面，其中这些文件可以包括html，js，css，img等等文件，但其实即使在有网络的时候，浏览器也会优先使用已离线存储的文件，返回一个200（from&nbsp;cache）头。这跟HTTP的缓存使用策略是不同的。<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;它是浏览器自己的一种机制，随着移动互联网时代的到来，网络可靠性降低，如果我们已经将需要的文件缓存下下来，一旦网络无法访问，也能继续访问。<br />\r\n<br />\r\n而且做好相应资源的缓存可以带来更好的用户体验，当用户使用自己的流量上网时，本地缓存不仅可以提高用户访问速度，而且大大节约用户的使用流量。<br />\r\n<br />\r\n&nbsp;<br />\r\n<br />\r\n什么是Manifest：<br />\r\n<br />\r\n其实Manifest是一个简单的&nbsp;文本文件，它的扩展名是任意', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('334', null, '<p>H5的数据存储？</p>\r\n', '5', '2', '<p>HTML5&nbsp;的本地存储&nbsp;API&nbsp;中的&nbsp;localStorage&nbsp;与&nbsp;sessionStorage&nbsp;在使用方法上是相同的，区别在于&nbsp;sessionStorage&nbsp;在关闭页面后即被清空，而&nbsp;localStorage&nbsp;则会一直保存。<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('335', null, '<p>简单解释CGI,fastCGI,PHP-FPM</p>\r\n', '5', '4', '<p>CGI：CGI的英文是（COMMON GATEWAY INTERFACE）公共网关接口，它的作用就是帮助服务器与语言通信。是 Web Server 与 Web Application 之间数据交换的一种协议。<br />\r\nFastCGI：同 CGI，是一种通信协议，但比 CGI 在效率上做了一些优化，fast-cgi则是一个进程可以处理多个请求。<br />\r\nPHP-CGI：是 PHP （Web Application）对 Web Server 提供的 CGI协议的接口程序。<br />\r\nPHP-FPM：是 PHP（Web Application）对 Web Server 提供的 FastCGI 协议的接口程序，额外还提供了相对智能一些任务管理</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('336', null, '<p>什么是媒体查询？</p>\r\n', '5', '1', '<p>CSS3媒体查询，就是根据页面分辨率设置不同的css样式，达到自适应的目的。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('337', null, '<p>PHP的垃圾收集机制是怎样的</p>\r\n', '5', '4', '<p>在PHP5.3版本之前，PHP只有简单的基于引用计数的垃圾回收，当一个变量的 引用计数变为0时， PHP将在内存中销毁这个变量，只是这里的垃圾并不能称之为垃圾。 并且PHP在一个生命周期结束后就会释放此进程/线程所占的内容，这种方式决定了PHP在前期不需要过多考虑内存的泄露问题。 但是随着PHP的发展，PHP开发者的增加以及其所承载的业务范围的扩大，在PHP5.3中引入了更加完善的垃圾回收机制。 新的垃圾回收机制解决了无法处理循环的引用内存泄漏问题。PHP5.3中的垃圾回收机制使用了文章 引用计数系统中的同步周期回收(Concurrent Cycle Collection in Reference Counted Systems) &nbsp;中的同步算法。关于这个算法的介绍我们就不再赘述，在PHP的官方文档有图文并茂的介绍： 回收周期(Collecting Cycles)。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('338', null, '<p>如何清除浮动？</p>\r\n', '5', '1', '<pre>\r\n<code class=\"language-xhtml\">\"　方式一:使用overflow属性来清除浮动\r\n.ovh{overflow:hidden;}先找到浮动盒子的父元素，再在父元素中添加一个属性：overflow:hidden,就是清除这个父元素中的子元素浮动对页面的影响.注意：一般情况下也不会使用这种方式，因为overflow:hidden有一个特点，离开了这个元素所在的区域以后会被隐藏（overflow:hidden会将超出的部分隐藏起来）.\r\n　方式二:使用额外标签法\r\n.clear{clear:both;}\r\n在浮动的盒子之下再放一个标签，在这个标签中使用clear:both，来清除浮动对页面的影响.\r\na.内部标签：会将这个浮动盒子的父盒子高度重新撑开.\r\nb.外部标签：会将这个浮动盒子的影响清除，但是不会撑开父盒子.\r\n注意：一般情况下不会使用这一种方式来清除浮动。因为这种清除浮动的方式会增加页面的标签，造成结构的混乱.\r\n方法三:使用伪元素来清除浮动(after意思:后来,以后)\r\n.clearfix:after{\r\ncontent:\"\"\"\";//设置', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('339', null, '<p>如何处理多服务器共享 Session ?</p>\r\n', '5', '4', '<p>数据库/文件同步 session<br />\r\ncookie 同步 session<br />\r\n缓存 (如 memcache ）同步 session</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('340', null, '<p>eval是做什么的？</p>\r\n', '5', '2', '<p>　eval&nbsp;执行会根据上下文来判断改变的变量时局部的还是全局的，所以使用eval函数，关键是看清引用eval的作用域！</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('341', null, '<p>redis和memcached的区别</p>\r\n', '5', '4', '<p>1、网络IO模型：<br />\r\nmemcached是多线程，非阻塞IO复用的网络模型；redis使用单线程的IO复用模型，对于单存只有IO操作来说，单线程可以将速度优势发挥到最大，但是redis也提供了一些简单的计算功能。<br />\r\n2、数据支持类型<br />\r\nmemcached使用key-value形式存储和访问数据，内存维护一张大的Hash&nbsp;表；redis&nbsp;支持的数据类型：String、Hash、List、Set和Sorted&nbsp;Set。&nbsp;注：了解每种数据类型的运用场景，每个至少能举出一个例子。<br />\r\n3、内存管理机制<br />\r\nMemcached使用预分配的内存池的方式。按照预先规定的大小将分配的内存分割成特定长度的块以存储相应长度的key-value数据；redis定义一个数组来记录所有的内存分配方式的；<br />\r\n4、数据存储及持久化<br />\r\nmemcached不支持持久化；redis持久化两种方式：1、快照（snapshotting）&nbsp;2、只追加式文件（AOF）<br />\r\n5、数据一致', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('342', null, '<p>js的数据类型？</p>\r\n', '5', '1', '<p>js中有六种数据类型，包括五种基本数据类型（Number,String,Boolean,Undefined,Null）,和一种复杂数据类型（Object）</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('343', null, '<p>在大型项目中，很多数据会采用nosql数据库去缓存数据。但是会出现缓存穿透的情况，简单说下什么是缓存穿透，包括其解决方案</p>\r\n', '5', '5', '<p>缓存穿透：<br />\r\n1：对查询结果为空的情况也进行缓存，缓存时间设置短一点，或者该key对应的数据insert了之后清理缓存。<br />\r\n2：对一定不存在的key进行过滤。可以把所有的可能存在的key放到一个大的Bitmap中，查询时通过该bitmap过滤<br />\r\n缓存雪崩：<br />\r\n1：在缓存失效后，通过加锁或者队列来控制读数据库写缓存的线程数量。比如对某个key只允许一个线程查询数据和写缓存，其他线程等待。<br />\r\n2：不同的key，设置不同的过期时间，让缓存失效的时间点尽量均匀。<br />\r\n3：做二级缓存，A1为原始缓存，A2为拷贝缓存，A1失效时，可以访问A2，A1缓存失效时间设置为短期，A2设置为长期在大型项目中，很多数据会采用nosql数据库去缓存数据。但是会出现缓存穿透的情况，</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('344', null, '<p>说说多线程？</p>\r\n', '5', '2', '<p>使用threading这个高级模块，启动一个线程就是把一个函数传入并创建Thread实例，然后调用start()开始执行多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，因此，线程之间共享数据最大的危险在于多个线程同时改一个变量把内容给改乱了。锁的好处就是确保了某段关键代码只能由一个线程从头到尾完整地执行，坏处当然也很多首先是阻止了多线程并发执行，包含锁的某段代码实际上只能以单线程模式执行，效率就大大地下降了。其次，由于可以存在多个锁，不同的线程持有不同的锁，并试图获取对方持有的锁时，可能会造成死锁，导致多个线程全部挂起，既不能执行，也无法结束，只能靠操作系统强制终止。多线程编程，模型复杂，容易发生冲突，必须用锁加以隔离，同时，又要小心死锁的发生。Python解释器由于设计时有GIL全局锁，导致了多线程无法利用多核。多线程的并发在Python中就是一个美丽的梦。Python的线程虽然是真正的线程，但解释器执行代码时，有一个GIL锁：Global&nbsp;', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('345', null, '<p>防盗链的原理和实现方式？</p>\r\n', '5', '4', '<p>原理：通过判断request请求头的refer是否来源于本站。<br />\r\n实现方式：<br />\r\n1）Apache 防盗链的第一种实现方法，可以用 Rewrite 实现。首先要确认 Apache 的 rewrite module 可用：能够控制 Apache httpd.conf 文件的，打开 httpd.conf，确保有这么一行配置：<br />\r\nLoadModule rewrite_module modules/mod_rewrite.so<br />\r\n&nbsp;然后在相应虚拟主机配置的地方，加入下列代码：<br />\r\n&nbsp;ServerName&nbsp;www.itcast.com<br />\r\n&nbsp;# 防盗链配置 参数<br />\r\n&nbsp;RewriteEngine On<br />\r\n&nbsp;RewriteCond %{HTTP_REFERER} !^http://itcast.com/.*$ [NC]<br />\r\n&nbsp;RewriteCond %{HTTP_REFERER} !^http://itcast.com$&nb', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('346', null, '<p>redis的数据类型</p>\r\n', '5', '1', '<p>string、list、set、zset、hash</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('347', null, '<p>正则中贪婪与非贪婪的区别</p>\r\n', '5', '2', '<p>&lt;.*&gt;是贪婪匹配，会从第一个&ldquo;&lt;&rdquo;开始匹配，直到最后一个&ldquo;&gt;&rdquo;中间所有的字符都会匹配到，中间可能会包含&ldquo;&lt;&gt;&rdquo;。<br />\r\n&lt;.*?&gt;是非贪婪匹配，从第一个&ldquo;&lt;&rdquo;开始往后，遇到第一个&ldquo;&gt;&rdquo;结束匹配，这中间的字符串都会匹配到，但是不会有&ldquo;&lt;&gt;&rdquo;。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('348', null, '<p>常见的linux命令（不含参数）</p>\r\n', '5', '1', '<p>cd 切换路径 &nbsp; &nbsp;pwd 显示当前位置 &nbsp;who 显示当前登录的账号 rm 删除 &nbsp;ls 显示当前路径下的所有文件 chmod 修改权限 cat 查看文件内容 tar 打包/压缩 ps 查看进程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('349', null, '<p>说说多线程？</p>\r\n', '5', '2', '<p>使用threading这个高级模块，启动一个线程就是把一个函数传入并创建Thread实例，然后调用start()开始执行多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，因此，线程之间共享数据最大的危险在于多个线程同时改一个变量把内容给改乱了。锁的好处就是确保了某段关键代码只能由一个线程从头到尾完整地执行，坏处当然也很多首先是阻止了多线程并发执行，包含锁的某段代码实际上只能以单线程模式执行，效率就大大地下降了。其次，由于可以存在多个锁，不同的线程持有不同的锁，并试图获取对方持有的锁时，可能会造成死锁，导致多个线程全部挂起，既不能执行，也无法结束，只能靠操作系统强制终止。多线程编程，模型复杂，容易发生冲突，必须用锁加以隔离，同时，又要小心死锁的发生。Python解释器由于设计时有GIL全局锁，导致了多线程无法利用多核。多线程的并发在Python中就是一个美丽的梦。Python的线程虽然是真正的线程，但解释器执行代码时，有一个GIL锁：Global&nbsp;', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('350', null, '<p>说说多线程？</p>\r\n', '5', '2', '<p>使用threading这个高级模块，启动一个线程就是把一个函数传入并创建Thread实例，然后调用start()开始执行多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，因此，线程之间共享数据最大的危险在于多个线程同时改一个变量把内容给改乱了。锁的好处就是确保了某段关键代码只能由一个线程从头到尾完整地执行，坏处当然也很多首先是阻止了多线程并发执行，包含锁的某段代码实际上只能以单线程模式执行，效率就大大地下降了。其次，由于可以存在多个锁，不同的线程持有不同的锁，并试图获取对方持有的锁时，可能会造成死锁，导致多个线程全部挂起，既不能执行，也无法结束，只能靠操作系统强制终止。多线程编程，模型复杂，容易发生冲突，必须用锁加以隔离，同时，又要小心死锁的发生。Python解释器由于设计时有GIL全局锁，导致了多线程无法利用多核。多线程的并发在Python中就是一个美丽的梦。Python的线程虽然是真正的线程，但解释器执行代码时，有一个GIL锁：Global&nbsp;', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('351', null, '<p>vue&nbsp;前后端分离项目怎么进行seo优化？</p>\r\n', '5', '2', '<p>spa开发模式的最大问题就是搜索引擎无法爬取页面内容，因为页面是通过http请求服务端接口数据动态渲染的，但是搜索引擎不会等待这个过程，这就导致前后端分离项目的seo优化成为一个问题。对于vue项目来说，一般有两种解决方案：<br />\r\n1.开启服务端渲染：首先安装&nbsp;ssr&nbsp;支持：&nbsp;npm&nbsp;i&nbsp;-D&nbsp;vue-server-renderer；重要的是&nbsp;vue-server-renderer&nbsp;与&nbsp;vue&nbsp;版本必须一致匹配<br />\r\n优点：可以做到真实数据实时渲染，完全可供SEO小蜘蛛尽情的爬来爬去；完全前后端同构，路由配置共享，不再影响服务器404请求。<br />\r\n缺点：依旧只支持h5&nbsp;history的路由模式，配置比较麻烦、处理流程比较复杂&nbsp;(比对预渲染插件，复杂太多)；约束较多，不能随心所欲的乱放大招；对服务器会造成较大的压力，既然让浏览器更快的渲染了，那就得以占用服务器的性能来买单了<br />\r\n2.使用prerender-spa-plugin插件', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('352', null, '<p>让你来设计接口需要考虑哪些？如何保障接口安全性?</p>\r\n', '5', '5', '<p>在具备接口文档和实现所需功能的基础之上，需要着重考虑到接口安全问题。如项目需要，则可以从以下几个角度去考虑：1、服务器环境安全，2、数据传输安全，3、身份认证，4、数据完整性校验。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('353', null, '<p>装饰器</p>\r\n', '5', '2', '<p>装饰器本质上是一个Python函数，它可以在让其他函数在不需要做任何代码的变动的前提下增加额外的功能。 装饰器的返回值也是一个函数的对象，它经常用于有切面需求的场景。 比如：插入日志、性能测试、事务处理、缓存、权限的校验等场景 有了装饰器就可以抽离出大量的与函数功能本身无关的雷同代码并发并继续使用。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('354', null, '<p>lambda函数</p>\r\n', '5', '2', '<p>lambda 函数是一个可以接收任意多个参数(包括可选参数)并且返回单个表达式值的函数<br />\r\n1、lambda 函数比较轻便，即用即仍，很适合需要完成一项功能，但是此功能只在此一处使用，连名字都很随意的情况下；<br />\r\n2、匿名函数，一般用来给 filter， map 这样的函数式编程服务;<br />\r\n3、作为回调函数，传递给某些应用，比如消息处理</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('355', null, '<p>python的内存回收？</p>\r\n', '5', '3', '<p>内存管理机制：引用计数、垃圾回收、内存池。<br />\r\n引用计数：<br />\r\n引用计数是一种非常高效的内存管理手段， 当一个 Python 对象被引用时其引用计数增加1， 当其不再被一个变量引用时则计数减 1. 当引用计数等于0时对象被删除。<br />\r\n垃圾回收 ：<br />\r\n1. 引用计数<br />\r\n引用计数也是一种垃圾收集机制，而且也是一种最直观，最简单的垃圾收集技术。当 Python 的某个对象的引用计数降为 0 时，说明没有任何引用指向该对象，该对象就成为要被回收的垃圾了。比如某个新建对象，它被分配给某个引用，对象的引用计数变为 1。如果引用被删除，对象的引用计数为 0，那么该对象就可以被垃圾回收。不过如果出现循环引用的话，引用计数机制就不再起有效的作用了<br />\r\n2. 标记清除<br />\r\n如果两个对象的引用计数都为 1，但是仅仅存在他们之间的循环引用，那么这两个对象都是需要被回收的，也就是说，它们的引用计数虽然表现为非 0，但实际上有效的引用计数为 0。所以先将循环引用摘掉，就会得出这两个对象的有效计数。<br />\r\n3. 分代回收<br ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('356', null, '<p>项目中密码的加密方式？</p>\r\n', '5', '3', '<p>使用的是django自带的用户认证系统，用的是sha256加密、对称加密、非对称机密、不可逆加密</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('357', null, '<p>怎么看进程，杀死？</p>\r\n', '5', '1', '<p>ps -aux |grep 进程名字 &nbsp; kill -9 进程id &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('358', null, '<p>进程、线程、协程 的理解&nbsp; ？</p>\r\n', '5', '2', '<p>&nbsp;进程包括线程 进程占用cpu资源大 线程其次 ，协程最小 进程是分配资源单位 线程是程序调度的单位吗，协程主要的目的是 利用消耗时间处于协调作用 进程相当于一个工厂 线程是工厂的生产线 协程是生产线的工人</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('359', null, '<p>多线程 进程 以及锁的运用？</p>\r\n', '5', '3', '<p>多线程：一个程序是有一个主进程 线程里面 可以有多个子线程 线程之间更相数据&nbsp;<br />\r\n多进程：相当于多个程序 多个进程同时展开 不共享数据 可以理解 一个qq是一个进程 可以同时开多个qq锁 python中提供的对线程控制的对象 有互斥锁 死锁等 互斥锁保证在同一时间内cpu必须执行完当前的代码 死锁是有多个 互斥锁嵌套发生搓澡 造成死锁，GIL全局解释器锁 作用是限制多线程同时执行 保证同一时间 只有一个线程执行 所以cpython中多线程其实就是为多线程更改办法 换成java python或者，协程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('360', null, '<p>re匹配所有标点</p>\r\n', '5', '1', '<p>/W</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('361', null, '<p>常见的linux命令（不含参数）</p>\r\n', '5', '1', '<p>cd 切换路径 &nbsp; &nbsp;pwd 显示当前位置 &nbsp;who 显示当前登录的账号 rm 删除 &nbsp;ls 显示当前路径下的所有文件 chmod 修改权限 cat 查看文件内容 tar 打包/压缩 ps 查看进程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('362', null, '<p>正则中贪婪与非贪婪的区别</p>\r\n', '5', '2', '<p>&lt;.*&gt;是贪婪匹配，会从第一个&ldquo;&lt;&rdquo;开始匹配，直到最后一个&ldquo;&gt;&rdquo;中间所有的字符都会匹配到，中间可能会包含&ldquo;&lt;&gt;&rdquo;。<br />\r\n&lt;.*?&gt;是非贪婪匹配，从第一个&ldquo;&lt;&rdquo;开始往后，遇到第一个&ldquo;&gt;&rdquo;结束匹配，这中间的字符串都会匹配到，但是不会有&ldquo;&lt;&gt;&rdquo;。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('363', null, '<p>redis的数据类型</p>\r\n', '5', '1', '<p>string、list、set、zset、hash</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('364', null, '<p>谈谈对ajax的理解</p>\r\n', '5', '3', '<p>ajax可以实现局部刷新，也叫做无刷新，无刷新指的是整个页面不刷新，只是局部刷新，ajax可以自己发送http请求，不用通过浏览器的地址栏，所以页面整体不会刷新，ajax获取到后台数据，更新页面显示数据的部分，就做到了页面局部刷新。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('365', null, '<p>对于生成器迭代器的理解？</p>\r\n', '5', '2', '<p>说这个问题我们首先来谈一下for循环遍历对象的本质&nbsp;<br />\r\nfor循环来遍历列表等容器对象时，先对容器对象调用iter()函数。iter()是python的内置函数<br />\r\niter()函数会返回一个定义了next()方法的迭代器对象，它在容器中逐个访问容器中的元素。next()也是python的内置函数。没有后续元素时，next()会抛出StopIteration异常，此时for循环结束。</p>\r\n\r\n<p>接下来我们再来说迭代器（Iterator）<br />\r\n迭代器用来帮助我们记录每次迭代访问到的位置。<br />\r\n当对迭代器使用next()函数的时候，迭代器会返回它所记录位置的下一个位置的数据。<br />\r\n实际上，使用next()函数的时候，调用的是迭代器的__next__方法。所以一个迭代器必须有__next__方法。<br />\r\n但是这还不够，python本身要求迭代器本身也必须是可迭代的。因此迭代器还必须有一个__iter__方法，这给__iter__方法就是让for循环遍历时使用的，又因为__iter__方法要返回一个迭代器，所', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('366', null, '<p>python常用的标准库？</p>\r\n', '5', '3', '<p>os sys re math random unittest（测试） datatime</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('367', null, '<p>django 和 flask 的区别？</p>\r\n', '5', '2', '<p>flask比较轻量级 Django是重量级 简单的flask是一个可以修饰的毛坯房自己自主的搭配 提供核心的东西，django 是一个已经成型得房子修改性小，在某些方面Django太重了，除了web框架，自带ORM和模板引擎，自带的数据库管理app，第三方库最丰富，模块化是集成在命令里的，Django的配置主要还是靠settings.py来做<br />\r\nFlask通过Blueprint来提供模块化，Flask的配置很灵活，有多种方法配置，不同环境的配置也非常方便。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('368', null, '<p>状态码及使用？</p>\r\n', '5', '2', '<p>通过状态码告诉客户端服务器的执行状态，以判断下一步该执行什么操作。常见的状态机器码有：<br />\r\n100-199：表示服务器成功接收部分请求，要求客户端继续提交其余请求才能完成整个处理过程。<br />\r\n200-299：表示服务器成功接收请求并已完成处理过程，常用 200（OK 请求成功）。<br />\r\n300-399：为完成请求，客户需要进一步细化请求。302（所有请求页面已经临时转移到新的 url）。304、307（使用缓存资源）。<br />\r\n400-499：客户端请求有错误，常用 404（服务器无法找到被请求页面），403（服务器拒绝访问，权限不够）。<br />\r\n500-599：服务器端出现错误，常用 500（请求未完成，服务器遇到不可预知的情况）。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('369', null, '<p>&nbsp;str和byte的区别</p>\r\n', '5', '1', '<p>python&nbsp;3中最重要的新特性可能就是将文本(text)和二进制数据做了更清晰的区分。文本总是用unicode进行编码，以str类型表示；而二进制数据以bytes类型表示。<br />\r\nstrings可以被编码(encode)成字bytes,bytes也可以解码(decode)成strings：</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('370', null, '<p>list、tuple、set和dict的区别？</p>\r\n', '5', '2', '<p>1.list、tuple是有序列表；dict、set是无序列表<br />\r\n2.list元素可变、tuple元素不可变<br />\r\n3.dict和set的key值不可变，唯一性<br />\r\n4.set只有key没有value<br />\r\n5.set的用途：去重、并集、交集等<br />\r\n6.list、tuple：+、*、索引、切片、检查成员等<br />\r\n7.dict查询效率高，但是消耗内存多；list、tuple查询效率低、但是消耗内存少</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('371', null, '<p>react的生命周期，如何发送Ajax？<br />\r\n<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '4', '<p>我们应当将AJAX&nbsp;请求放到&nbsp;componentDidMount&nbsp;函数中执行，主要原因有下：<br />\r\n　　React&nbsp;下一代调和算法&nbsp;Fiber&nbsp;会通圌过开始或停止渲染的方式优化应用性能，其会影响到&nbsp;componenТWillMount&nbsp;的触发次数。对于&nbsp;componenТWillMount&nbsp;这个生命周期函数的调用次数会变得不确定，React&nbsp;可能会多次频繁调用&nbsp;componenТWillMount。如果我们将&nbsp;AJAX&nbsp;请求放到&nbsp;componenТWillMount&nbsp;函数中，那么显而易见其会被触发多次，自然也就不是好的选择。<br />\r\n　　如果我们将&nbsp;AJAX&nbsp;请求放置在生命周期的其他函数中，我们并不能保证请求仅在组件挂载完毕后才会要求响应。如果我们的数据请求在组件挂载之前就完成，并且调用了setState函数将数据添加到组件状态中，对于未挂载的组件则会报错。而在&nbsp;componen', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('372', null, '<p>列表的去重？</p>\r\n', '5', '1', '<p>list转set</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('373', null, '<p>Python进程间通信，不用socket怎么通讯</p>\r\n', '5', '3', '<p>（1）管道（Pipe）：管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用，允许一个进程和另一个与它有共同祖先的进程之间进行通信。<br />\r\n<br />\r\n（2）命名管道（named&nbsp;pipe）：也是半双工的通信方式，除具有管道所具有的功能外，它还允许无亲缘关系进程间的通信。命名管道在文件系统中有对应的文件名。命名管道通过命令mkfifo或系统调用mkfifo来创建。<br />\r\n<br />\r\n（3）信号（Signal）：信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。是Unix系统中使用的最古老的进程间通信的方法之一。操作系统通过信号来通知进程系统中发生了某种预先规定好的事件（一组事件中的一个），它也是用户进程之间通信和同步的一种原始机制。<br />\r\n<br />\r\n（4）消息（Message）队列：消息队列是消息的链接表，包括Posix消息队列system&nbsp;V消息队列。有足够权限的进程可以向队列中添加消息，被赋予读权限的进程则可以读走队列中的消息。消息队列克服了信号承载信息量少，管道只能承载无格式', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('374', null, '<p>MySQL数据库存储引擎有哪些？InnoDB与MyISAM的区别？</p>\r\n', '5', '4', '<p>MyISAM、InnoDB、MERGE、MEMORY(HEAP)、BDB(BerkeleyDB)、EXAMPLE、FEDERATED、ARCHIVE、CSV、BLACKHOLE<br />\r\ninnoDB<br />\r\n一、InnoDB支持事务，MyISAM不支持，这一点是非常之重要。事务是一种高级的处理方式，如在一些列增删改中只要哪个出错还可以回滚还原，而MyISAM就不可以了。<br />\r\n二、MyISAM适合查询以及插入为主的应用，InnoDB适合频繁修改以及涉及到安全性较高的应用<br />\r\n三、InnoDB支持外键，MyISAM不支持<br />\r\n四、InnoDB不支持FULLTEXT类型的索引<br />\r\n五、InnoDB中不保存表的行数，如select count(*) from table时，InnoDB需要扫描一遍整个表来计算有多少行，但是MyISAM只要简单的读出保存好的行数即可。注意的是，当count(*)语句包含where条件时MyISAM也需要扫描整个表<br />\r\n六、对于自增长的字段，InnoDB中必须包含只有该字段的索引，但是在MyISA', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('375', null, '<p>**args和**kwargs？</p>\r\n', '5', '2', '<p>*args 是不定长参数，他可以表示输入参数是不确定的，可以是任意多个。<br />\r\n**kwargs 是关键字参数，赋值的时候是以键 = 值的方式，参数是可以任意多对在定义函数的时候不确定会有多少参数会传入时，就可以使用两个参数。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('376', null, '<p>使用装饰器实现单例模式？</p>\r\n', '5', '3', '<p>class fun_1(object):<br />\r\n&nbsp; &nbsp; def __init__(self, cls):<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; self._cls = cls<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; self._instances = None;</p>\r\n\r\n<p>&nbsp; &nbsp; def __call__(self, *args):<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; if not self._instances:<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; self._instances = self._cls(*args)<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; return self._instances<br />\r\n@fun_1<br />\r\nclass fun_2(object):<br />\r\n&nbsp; &nbsp; def _', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('377', null, '<p>用一行代码python 写出1+2+3+4+&hellip;&hellip;10348？</p>\r\n', '5', '2', '<p>print(sum(range(1,10349)))</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('378', null, '<p>同步异步阻塞非阻塞的了解具体说说？</p>\r\n', '5', '2', '<p>异步：某个事情需要10s完成。而我只需要调用某个函数告诉xxx来帮我做（然后我再干其他的事情）<br />\r\n同步：某个事情需要10s完成，我需要一直等它完成（等10s），再能继续后面的工作。<br />\r\n阻塞：做某件事情，直到完成，除非超时<br />\r\n非阻塞：尝试做，如果不能做，就不做（直接返回），如果能做，就做。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('379', null, '<p>如何实现react组件的通信？</p>\r\n', '5', '3', '<p>1.父-子组件通信<br />\r\n1.1通信的手段<br />\r\n这是最常见的通信方式，父组件只需要将子组件需要的props传给子组件，子组件直接通过this.props来使用。<br />\r\n1.2&nbsp;通信内容<br />\r\n更多要提的是如何合理的设置子组件的props，要想将子组件设计成一个复用性强的通用组件，需要将能够复用的部分抽象出来，<br />\r\n抽象出来的props有两种形成，一种是简单的变量，另一种是抽象出来处理某种逻辑的函数。2.&nbsp;子-父组件通信<br />\r\n2.1&nbsp;通信的手段<br />\r\n父-子组件通信的手段是通过子组件的props是子组件用父组件的东西，子-父组件通信，是父组件用子组件的东西，肿么用，在开发过程中<br />\r\n暂时没有用到这种情景。我想到的方法就是将传递的内容直接写在子组件上，然后给子组件设置ref，父组件直接通过ref操作子组件的属性。<br />\r\n2.2&nbsp;通信的内容<br />\r\n子组件的属性<br />\r\n2.3&nbsp;通信的动机<br />\r\n父组件想要调用子组件的属性3.1通信的方式', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('380', null, '<p>python的内存管理机制？</p>\r\n', '5', '2', '<p>采用引用计数为主，标记清除、分代回收机制为辅</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('381', null, '<p>什么是闭包？</p>\r\n', '5', '1', '<p>在函数内部再定义一个函数，并且这个函数用到了外边函数的变量，那么将这个函数以及用到的一些变量称之为闭包</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('382', null, '<p>python2和3的区别。</p>\r\n', '5', '3', '<p>&gt;&nbsp;1.&nbsp;print不再是语句，而是函数，比如原来是&nbsp;print&nbsp;&#39;abc&#39;&nbsp;现在是&nbsp;print(&#39;abc&#39;)<br />\r\n但是&nbsp;python2.6+&nbsp;可以使用&nbsp;from&nbsp;__future__&nbsp;import&nbsp;print_function&nbsp;来实现相同功能<br />\r\n&gt;&nbsp;2.&nbsp;在Python&nbsp;3中，没有旧式类，只有新式类，也就是说不用再像这样&nbsp;class&nbsp;Foobar(object):&nbsp;pass&nbsp;显式地子类化object<br />\r\n但是最好还是加上.&nbsp;主要区别在于&nbsp;old-style&nbsp;是&nbsp;classtype&nbsp;类型而&nbsp;new-style&nbsp;是&nbsp;type类型<br />\r\n&gt;&nbsp;3.&nbsp;原来1/2（两个整数相除）结果是0，现在是0.5了<b', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('383', null, '<p>进程间的数据共享和线程间的数据共享</p>\r\n', '5', '2', '<p>进程间数据共享:<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;多进程中，每个进程都是独立的，各自持有一份数据，无法共享。本篇文章介绍三种用于进程<br />\r\n数据共享的方法Queue:<br />\r\n&nbsp;1.&nbsp;from&nbsp;multiprocessing&nbsp;import&nbsp;queues&nbsp;2.&nbsp;import&nbsp;multiprocessing<br />\r\n3<br />\r\n4.&nbsp;def&nbsp;func(i,&nbsp;q):<br />\r\n5.&nbsp;q.put(i)<br />\r\n6.&nbsp;print(&quot;---&gt;&quot;,&nbsp;i,&nbsp;q.qsize())<br />\r\n7.<br />\r\n8.<br />\r\n9.&nbsp;q&nbsp;=&nbsp;queues.Queue(9,&nbsp;ctx=multiprocessing)&nbsp;10.&nbsp;for&nbsp;i&nbsp;in&nbsp;range(5):<br ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('384', null, '<p>fastcgi通过端口监听和通过文件监听的区别?</p>\r\n', '5', '4', '<p>端口监听和文件监听。区别如下：<br />\r\n端口监听方式的形式为&ldquo;fastcgi_pass 127.0.0.1:9000&rdquo;，此时Nginx连接fastcgi使用的是tcp协议。<br />\r\n文件监听方式的形式为&ldquo;fastcgi_pass /tmp/php_cgi.sock &rdquo;，，此时Nginx连接fastcgi的方式为Unix domain Socket。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('385', null, '<p>python多线程与多进程的区别</p>\r\n', '5', '2', '<p>进程:一个运行的程序(代码)就是一个进程，没有运行的代码叫程序，进程是系统资源分配的最<br />\r\n小单位，进程拥有自己独立的内存空间，所以进程间数据不共享，开销大。<br />\r\n线程:&nbsp;调度执行的最小单位，也叫执行路径，不能独立存在，依赖进程存在一个进程至少有一个&nbsp;线程，叫主线程，而多个线程共享内存(数据共享，共享全局变量)，从而极大地提高了程序的运行效率</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('386', null, '<p>python多线程</p>\r\n', '5', '2', '<p>这个问题被问的概率相当之大，其实多线程，多进程，在实际开发中用到的很少，除非是那些对项&nbsp;目性能要求特别高的，有的开发工作几年了，也确实没用过，你可以这么回答，给他扯扯什么是进程，&nbsp;线程(cpython&nbsp;中是伪多线程)的概念就行，实在不行你就说你之前写过下载文件时，用过多线程技术，&nbsp;或者业余时间用过多线程写爬虫，提升效率。<br />\r\n&nbsp;&nbsp;进程:一个运行的程序(代码)就是一个进程，没有运行的代码叫程序，进程是系统资源分配的最<br />\r\n小单位，进程拥有自己独立的内存空间，所以进程间数据不共享，开销大。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('387', null, '<p>sockets（套接字）编程有三种，哪三种？</p>\r\n', '5', '3', '<p>套接字有三种类型:流式套接字(SOCK_STREAM),数据报套接字(SOCK_DGRAM)及原始套接字。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('388', null, '<p>应用webpack自动代码分割需要如何调整js代码？<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '5', '<p>代码分一切都还不错，直到有一天遇到不能以单文件形式下载整个应用的情况。有时候你必须在应用程序中使用多个打包的脚本。<br />\r\n<br />\r\n这就是需要对代码进行分割的地方。通过将应用程序拆解成多个部分，你才可以按照用户当前操作提供应用程序中相关的部分。<br />\r\n<br />\r\n提到最小的单包，Webpack&nbsp;通常最后来处理文件大小，但这往往不是恰当的时机。Rollup&nbsp;在这方面就好得多，但它对代码分割的支持则较弱。<br />\r\n<br />\r\nWebpack&nbsp;各分块文件的大小总和会超出单个&nbsp;Rollup&nbsp;打包出来的文件的大小，但这在你的应用中很可能不是什么问题。<br />\r\n<br />\r\n如果你根据需求来对&nbsp;Webpack&nbsp;产生和各个包进行懒加载，那么用户最终下载的内容可能只是完整&nbsp;Rollup&nbsp;生成的包文件的一部分。<br />\r\n<br />\r\n最终，更小更有针对性的打包会比单包给用户带来更多好处。当然如果你的应用中没什么机会用以懒加载，这些好处就不存在。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('389', null, '<p>分别阐述三种引号用的场景与区别</p>\r\n', '5', '2', '<p>单引号，双引号，三引号都可以表示字符串，双引号可以和单引号嵌套使用，三引号一般表示多行字符串或者注释，三引号可以嵌套双引号和单引号</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('390', null, '<p>Python的内存管理机制</p>\r\n', '5', '4', '<p>1.引用计数：通过引用计数来保持对内存中的变量跟踪，Python内部记录中所有在使用对象各有多少个引用。Python中有个内部跟踪变量叫做引用计数器，每个变量有多少个引用，简称引用计数。当对象被创建时就创建了一个引用计数。当某个对象的引用计数为0时，对象就不在需要，就列入了垃圾回收队列。引用计数增加：1.对象被创建：x=4;2.另外的别人被创建：y=x;3.被作为参数传递给函数：foo(x);4.作为容器对象的一个元素：a=[1,x,&#39;33&#39;];引用计数减少时：1.一个本地引用离开了它的作用域。比如上面的foo(x)函数结束时，x指向的对象引用减1;2.对象的别名被显式的销毁：delx；或者del&nbsp;y;&nbsp;3.对象的一个别名被赋值给其他对象：x=7894.对象从一个窗口对象中移除：myList.remove(x)5.窗口对象本身被销毁delmyList，或者窗口对象本身离开了作用域。2.垃圾回收1.引用计数：&nbsp;每个对象中都有ob-refcnt来做引用计数。当一个对象...,ob-refcnt就会增加，当引用的对象删除，那么ob-refc', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('391', null, '<p>域名和IP之间有什么关系，如何查看某个域名对应的所有IP？</p>\r\n', '5', '3', '<p>输入域名----域名&nbsp;解析服务器（dns）解析成ip地址---访问IP地址---完成访问的内容---返回信息国际互联网(Internet)上有成千百万台主机（host），为了区分这些主机，人们给每台主机都分配了一个专门的&ldquo;地址&rdquo;作为标识，称为IP地址由于IP地址全是些的数字，为了便于用户记忆，Internet上引进了域名服务系统DNS（DomainName&nbsp;System）。当您键入某个域名的时候，这个信息首先到达提供此域名解析的服务器上，再将此域名解析为相应网站的IP地址。完成这一任务的过程就称为域名解析。1.ping&nbsp;&nbsp;2.nslookup&nbsp;3.使用站长工具等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('392', null, '<p>&nbsp;假设&nbsp;a=(1,2,3)&nbsp;&nbsp;改变a的值变为(3,2,3)</p>\r\n', '5', '1', '<p>b=list（a）&nbsp;&nbsp;b[0]=3&nbsp;&nbsp;a=b</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('393', null, '<p>如何在一个多级目录下,找出所有包含有&rsquo;abc&rsquo;字符的文件</p>\r\n', '5', '1', '<p>grep&nbsp;&lsquo;abc&rsquo;&nbsp;./*</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('394', null, '<p>如何抓取ping包</p>\r\n', '5', '4', '<p>tcpdump&nbsp;-i&nbsp;eth0&nbsp;-nn&nbsp;&#39;icmp&#39;&nbsp;&nbsp;&nbsp;ping命令使用的是icmp协议</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('395', null, '<p>git&nbsp;push等同于那两个git命令？<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '3', '<pre>\r\n<code class=\"language-javascript\">\"git push命令用于将本地分支的更新，推送到远程主机。它的格式与git pull命令相仿。注意，分支推送顺序的写法是&lt;来源地&gt;:&lt;目的地&gt;，所以git pull是&lt;远程分支&gt;:&lt;本地分支&gt;，而git push是&lt;本地分支&gt;:&lt;远程分支&gt;。\r\n\r\n如果省略远程分支名，则表示将本地分支推送与之存在”追踪关系”的远程分支(通常两者同名)，如果该远程分支不存在，则会被新建。\"\r\n</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('396', null, '<p>print(dir(&lsquo;a&rsquo;))输出的是什么？</p>\r\n', '5', '2', '<p>会打印出字符型的所有的内置方法[&#39;__add__&#39;,&nbsp;&#39;__class__&#39;,&nbsp;&#39;__contains__&#39;,&nbsp;&#39;__delattr__&#39;,&nbsp;&#39;__doc__&#39;,&nbsp;&#39;__eq__&#39;,&nbsp;&#39;__format__&#39;,&nbsp;&#39;__ge__&#39;,&nbsp;&#39;__getattribute__&#39;,&nbsp;&#39;__getitem__&#39;,&nbsp;&#39;__getnewargs__&#39;,&nbsp;&#39;__getslice__&#39;,&nbsp;&#39;__gt__&#39;,&nbsp;&#39;__hash__&#39;,&nbsp;&#39;__init__&#39;,&nbsp;&#39;__le__&#39;,&nbsp;&#39;__len__&#39;,&nbsp;&#39;__lt__&#39;,&nbsp;&#39;__mod__&', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('397', null, '<p>nginx的负载均衡实现方式?</p>\r\n', '5', '4', '<p>轮询<br />\r\n用户IP哈希<br />\r\n指定权重<br />\r\nfair（第三方）<br />\r\nurl_hash（第三方）</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('398', null, '<p>__new__和__init__的区别？</p>\r\n', '5', '2', '<p>__new__是一个静态方法,而__init__是一个实例方法.__new__方法会返回一个创建的实例,而__init__什么都不返回.只有在__new__返回一个cls的实例时后面的__init__才能被调用.当创建一个新实例时调用__new__,初始化一个实例时用__init__</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('399', null, '<p>一个包里有三个模块，mod1.py,&nbsp;mod2.py,&nbsp;mod3.py，但使用from&nbsp;demopack&nbsp;import&nbsp;*导入模块时，如何保证只有mod1、mod3被导入了</p>\r\n', '5', '2', '<p>增加__init__.py文件，并在文件中增加：__all__&nbsp;=&nbsp;[&#39;mod1&#39;,&#39;mod3&#39;]</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '4', '4', '1');
INSERT INTO `t_question` VALUES ('400', null, '<p>如实现extend的函数？<br />\r\n<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '4', '<pre>\r\n<code class=\"language-javascript\">\"\r\nvar class2type = {}\r\nfunction type(obj) {\r\n  return obj == null ? String(obj) :\r\n    class2type[toString.call(obj)] || \"\"object\"\"\r\n}\r\nfunction isFunction(value) { return type(value) == \"\"function\"\" }\r\nfunction isWindow(obj)     { return obj != null &amp;&amp; obj == obj.window }\r\nfunction isDocument(obj)   { return obj != null &amp;&amp; obj.nodeType == obj.DOCUMENT_NODE }\r\nfunction isObject(obj)     { return type(obj) == \"\"object\"\" }\r\nfunction isPlain', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('401', null, '<p>Python里面match()和search()的区别？&nbsp;</p>\r\n', '5', '1', '<p>re模块中match(pattern,string[,flags]),检查string的开头是否与pattern匹配。&nbsp;<br />\r\nre模块中research(pattern,string[,flags]),在string搜索pattern的第一个匹配值。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('402', null, '<p>如何保证线程安全？</p>\r\n', '5', '1', '<p>通常加锁也有2种不同的粒度的锁：&nbsp;&nbsp;<br />\r\n1.&nbsp;fine-grained(细粒度)，程序员需要自行加/解锁来保证线程安全&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />\r\n2.&nbsp;coars', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('403', null, '<p>Python线程和进程的区别</p>\r\n', '5', '2', '<p>1)调度：线程作为调度和分配的基本单位，进程作为拥有资源的基本单位。&nbsp;<br />\r\n2)并发性：不仅进程之间可以并发执行，同一个进程的多个线程之间也可并发执行。&nbsp;<br />\r\n3）拥有资源：进程是拥有资源的一个独立单位，线程不拥有系统资源，但可以访问隶属于进程的资<br />\r\n源.&nbsp;<br />\r\n4）系统开销：在创建或撤消进程时，由于系统都要为之分配和回收资源，导致系统的开销明显大于<br />\r\n创建或撤消线程时的开销。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('404', null, '<p>Python内存管理机制</p>\r\n', '5', '5', '<p>引用计数机制<br />\r\n垃圾回收机制<br />\r\n内存池机制</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('405', null, '<p>说说你对TCP&nbsp;IP协议的理解</p>\r\n', '5', '1', '<p>TCP/IP（Transmission&nbsp;Control&nbsp;Protocol/Internet&nbsp;Protocol）协议是传输层协议，主要解决数据如何在网络中传输。HTTP是应用层协议，主要解决如何包装数据。IP协议对应于网络层。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('406', null, '<p>表单中get与post提交方法的区别?</p>\r\n', '5', '4', '<p>GET在浏览器回退时是无害的，而POST会再次提交请求。<br />\r\nGET产生的URL地址可以被Bookmark，而POST不可以。<br />\r\nGET请求会被浏览器主动cache，而POST不会，除非手动设置。<br />\r\nGET请求只能进行url编码，而POST支持多种编码方式。<br />\r\nGET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留。<br />\r\nGET请求在URL中传送的参数是有长度限制的，而POST没有。<br />\r\n对参数的数据类型，GET只接受ASCII字符，而POST没有限制。<br />\r\nGET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。<br />\r\nGET参数通过URL传递，POST放在Request body中。<br />\r\nGET产生一个TCP数据包，POST产生两个TCP数据包。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('407', null, '<p>简述HTTP缓存机制</p>\r\n', '5', '3', '<p>在客户端第一次请求数据时，此时缓存数据库中没有对应的缓存数据，需要请求服务器，服务器返回后，将数据存储至缓存数据库中。<br />\r\n对于强制缓存，服务器通知浏览器一个缓存时间，在缓存时间内，下次请求，直接用缓存，不在时间内，执行比较缓存策略。<br />\r\n对于比较缓存，将缓存信息中的Etag和Last-Modified通过请求发送给服务器，由服务器校验，返回304状态码时，浏览器直接使用缓存。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('408', null, '<p>如何避免python中模块间的循环引用</p>\r\n', '5', '3', '<p>解决循环import的方法主要有几种。<br />\r\n1.延迟导入(lazy&nbsp;import)<br />\r\n即把import语句写在方法或函数里面，将它的作用域限制在局部。<br />\r\n这种方法的缺点就是会有性能问题。<br />\r\n<br />\r\n2.将from&nbsp;xxx&nbsp;import&nbsp;yyy改成import&nbsp;xxx;xxx.yyy来访问的形式<br />\r\n<br />\r\n3.组织代码<br />\r\n出现循环import的问题往往意味着代码的布局有问题。<br />\r\n可以合并或者分离竞争资源。<br />\r\n合并的话就是都写到一个文件里面去。<br />\r\n分离的话就是把需要import的资源提取到一个第三方文件去。<br />\r\n总之就是将循环变成单向。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('409', null, '<p>如何避免python中模块间的循环引用</p>\r\n', '5', '3', '<p>解决循环import的方法主要有几种。<br />\r\n1.延迟导入(lazy&nbsp;import)<br />\r\n即把import语句写在方法或函数里面，将它的作用域限制在局部。<br />\r\n这种方法的缺点就是会有性能问题。<br />\r\n<br />\r\n2.将from&nbsp;xxx&nbsp;import&nbsp;yyy改成import&nbsp;xxx;xxx.yyy来访问的形式<br />\r\n<br />\r\n3.组织代码<br />\r\n出现循环import的问题往往意味着代码的布局有问题。<br />\r\n可以合并或者分离竞争资源。<br />\r\n合并的话就是都写到一个文件里面去。<br />\r\n分离的话就是把需要import的资源提取到一个第三方文件去。<br />\r\n总之就是将循环变成单向。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('410', null, '<p>用Python&nbsp;re模块匹配HTML&nbsp;tag的时候，&lt;.*&gt;和&lt;.*?&gt;有什么区别</p>\r\n', '5', '2', '<p>&lt;.*&gt;这种匹配称作贪心匹配&lt;.*?&gt;称作非贪心匹配第一种写法是，尽可能多的匹配，就是匹配到的字符串尽量长，第二中写法是尽可能少的匹配，就是匹配到的字符串尽量短。比如&lt;tag&gt;tag&gt;tag&gt;end，第一个会匹配&lt;tag&gt;tag&gt;tag&gt;,第二个会匹配&lt;tag&gt;,如果要匹配到二个&gt;，就只能自己写</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('411', null, '<p>Jquery底层你都了解什么？<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '5', '<p>jQuery&nbsp;闭包结构<br />\r\n//&nbsp;用一个函数域包起来，就是所谓的沙箱<br />\r\n//&nbsp;在这里边&nbsp;var&nbsp;定义的变量，属于这个函数域内的局部变量，避免污染全局<br />\r\n//&nbsp;把当前沙箱需要的外部变量通过函数参数引入进来<br />\r\n//&nbsp;只要保证参数对内提供的接口的一致性，你还可以随意替换传进来的这个参数<br />\r\njQuery&nbsp;具体的实现，都被包含在了一个立即执行函数构造的闭包里面，为了不污染全局作用域，只在后面暴露&nbsp;$&nbsp;和&nbsp;jQuery&nbsp;这&nbsp;2&nbsp;个变量给外界，尽量的避开变量冲突。常用的还有另一种写法：<br />\r\n比较推崇的的第一种写法，也就是&nbsp;jQuery&nbsp;的写法。二者有何不同呢，当我们的代码运行在更早期的环境当中（pre-ES5，eg.&nbsp;Internet&nbsp;Explorer&nbsp;8），undefined&nbsp;仅是一个变量且它的值是可以被覆盖的。意味着你可以做这', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('412', null, '<p>&nbsp;Python的传参是传值还是传址</p>\r\n', '5', '3', '<p>Python的参数传递有：&nbsp;位置参数、&nbsp;默认参数、&nbsp;可变参数、&nbsp;关键字参数&nbsp;函数的传值到底是值传递还是引用传递，&nbsp;要分情况：&nbsp;不可变参数用值传递：&nbsp;像整数和字符串这样的不可变对象，&nbsp;是通过拷贝进行传递的，&nbsp;因为你无论如何都不可能在原处改变不可变对象&nbsp;可变参数是引用传递的：&nbsp;比如像列表，&nbsp;字典这样的对象是通过引用传递、&nbsp;和C语言里面的用指针传递数组很相似，&nbsp;可变对象能在函数内部改变</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('414', null, '<p>如何在一个function里面设置一个全局的变量</p>\r\n', '5', '1', '<p>如果要给全局变量在一个函数里赋值，&nbsp;必须使用global语句。global&nbsp;VarName的表达式会告诉Python，VarName是一个全局变量，&nbsp;这样Python就不会在局部命名空间里寻找这个变量</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('415', null, '<p>描述下SOAP的交互流程</p>\r\n', '5', '3', '<p>SOAP(简&nbsp;单&nbsp;对&nbsp;象&nbsp;访&nbsp;问&nbsp;协&nbsp;议)：SOAP是&nbsp;使&nbsp;用XML通&nbsp;过Internet发送信息和访问动态Web服务的友好界面。其主要作用在于确保信息通过互联网在业务应用之间传输的可靠性。作为一种用在分布式环境中交换结构化数据的协议，它包括三个部分：信封、报头(可选)和协议消息体。信封标记SOAP消息的开始与结束。它还可以规定在网络上数据的编码规则。SOAP报头可以包含发送给一个地址或多个地址的邮件、一个支付代码或有关RPC类型互动的信息。一个信封中可以有多个报头或完全没有报头。SOAP消息体传送自描述结构或RPC类型接口格式的数据。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('416', null, '<p>Git命令以及根据所写的命令说出意思</p>\r\n', '5', '2', '<p>1、git config --global user.name &#39;userName&#39; ，登录git设置账户<br />\r\n2、mkdir php，创建文件夹PHP<br />\r\n3、touch .gitignore，创建忽略文件<br />\r\n4、git commit -m &#39;备注信息&#39;，添加到版本库中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('417', null, '<p>这两个参数什么意思&nbsp;*args&nbsp;**kwargs，我们为什么要使用他们？</p>\r\n', '5', '2', '<p>缺省参数指在调用函数的时候没有传入参数的情况下，调用默认的参数，在调用函数的同时赋值时，<br />\r\n所传入的参数会替代默认参数。&nbsp;<br />\r\n*args&nbsp;是不定长参数，他可以表示输入参数是不确定的，可以是任意多个。&nbsp;<br />\r\n**kwargs&nbsp;是关键字参数，赋值的时候是以键&nbsp;=&nbsp;值的方式，参数是可以任意多对在定义函数的时候<br />\r\n不确定会有多少参数会传入时，就可以使用两个参数。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('418', null, '<p>Python关键字yield的用法？</p>\r\n', '5', '3', '<p>yield&nbsp;就是保存当前程序执行状态。你用&nbsp;for&nbsp;循环的时候，每次取一个元素的时候就会计算一次。用&nbsp;yield&nbsp;的函数<br />\r\n叫generator，和&nbsp;iterator一样，它的好处是不用一次计算所有元素，而是用一次算一次，可以节省很多空间。generator<br />\r\n每次计算需要上一次计算结果，所以用yield，否则一return，上次计算结果就没了。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('419', null, '<p>函数参数的传递？</p>\r\n\r\n<p>def add（a，s_list=[]）:</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; s_list.append(a) &nbsp; &nbsp;</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;return s_list &', '5', '2', '<p>[1],[1,2],[1,2,3]</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('420', null, '<p>Python线程和进程的区别？</p>\r\n', '5', '2', '<p>1)调度：线程作为调度和分配的基本单位，进程作为拥有资源的基本单位。&nbsp;<br />\r\n2)并发性：不仅进程之间可以并发执行，同一个进程的多个线程之间也可并发执行。&nbsp;<br />\r\n3）拥有资源：进程是拥有资源的一个独立单位，线程不拥有系统资源，但可以访问隶属于进程的资<br />\r\n源.&nbsp;<br />\r\n4）系统开销：在创建或撤消进程时，由于系统都要为之分配和回收资源，导致系统的开销明显大于<br />\r\n创建或撤消线程时的开销。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('421', null, '<p>Python线程和进程的区别？</p>\r\n', '5', '2', '<p>1)调度：线程作为调度和分配的基本单位，进程作为拥有资源的基本单位。&nbsp;<br />\r\n2)并发性：不仅进程之间可以并发执行，同一个进程的多个线程之间也可并发执行。&nbsp;<br />\r\n3）拥有资源：进程是拥有资源的一个独立单位，线程不拥有系统资源，但可以访问隶属于进程的资<br />\r\n源.&nbsp;<br />\r\n4）系统开销：在创建或撤消进程时，由于系统都要为之分配和回收资源，导致系统的开销明显大于<br />\r\n创建或撤消线程时的开销。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('422', null, '<p>mysql优化</p>\r\n', '5', '4', '<p>MySQL优化三大方向<br />\r\n① 优化MySQL所在服务器内核(此优化一般由运维人员完成)。<br />\r\n② 对MySQL配置参数进行优化（my.cnf）此优化需要进行压力测试来进行参数调整③ 对SQL语句以及表优化。<br />\r\n对MySQL语句性能优化的16条具体措施<br />\r\n① 为查询缓存优化查询<br />\r\n② EXPLAIN 我们的SELECT查询(可以查看执行的行数)<br />\r\n③ 当只要一行数据时使用LIMIT 1<br />\r\n④ 为搜索字段建立索引<br />\r\n⑤ 在Join表的时候使用相当类型的列，并将其索引<br />\r\n⑥ 千万不要 ORDER BY RAND&nbsp; ()<br />\r\n⑦ 避免SELECT *<br />\r\n⑧ 永远为每张表设置一个ID<br />\r\n⑨ 可以使用ENUM 而不要VARCHAR<br />\r\n⑩ 尽可能的使用NOT NULL<br />\r\n⑪ 固定长度的表会更快<br />\r\n⑫ 垂直分割<br />\r\n⑬ 拆分打的DELETE或INSERT语句<br />\r\n⑭ 越小的列会越快<br />', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('423', null, '<p>说说多线程？</p>\r\n', '5', '2', '<p>使用threading这个高级模块，启动一个线程就是把一个函数传入并创建Thread实例，然后调用start()开始执行多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，因此，线程之间共享数据最大的危险在于多个线程同时改一个变量把内容给改乱了。锁的好处就是确保了某段关键代码只能由一个线程从头到尾完整地执行，坏处当然也很多首先是阻止了多线程并发执行，包含锁的某段代码实际上只能以单线程模式执行，效率就大大地下降了。其次，由于可以存在多个锁，不同的线程持有不同的锁，并试图获取对方持有的锁时，可能会造成死锁，导致多个线程全部挂起，既不能执行，也无法结束，只能靠操作系统强制终止。多线程编程，模型复杂，容易发生冲突，必须用锁加以隔离，同时，又要小心死锁的发生。Python解释器由于设计时有GIL全局锁，导致了多线程无法利用多核。多线程的并发在Python中就是一个美丽的梦。Python的线程虽然是真正的线程，但解释器执行代码时，有一个GIL锁：Global&nbsp;', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('424', null, '<p>webpack是如何配置？</p>\r\n', '5', '5', '<p>1.&nbsp;安装&nbsp;Node&nbsp;Js<br />\r\n首先，Webpack&nbsp;是基于&nbsp;NodeJs&nbsp;的工具，你必须首先安装&nbsp;NodeJs.&nbsp;NodeJs&nbsp;仅仅只需要在你的系统中安装一次就可以了。<br />\r\n<br />\r\n2.&nbsp;全局安装&nbsp;Webpack<br />\r\n我们希望能够在系统的任何文件夹中使用&nbsp;Webpack，使用的方式是通过&nbsp;Webpack&nbsp;命令来完成的，这需要我们全局安装&nbsp;Webpack。这也只需要安装一次，以后每个项目就不需要重新全局安装了。<br />\r\n<br />\r\nnpm&nbsp;install&nbsp;webpack&nbsp;-g<br />\r\n&nbsp;成功安装之后，你应该能够在任何目录中执行&nbsp;webpack&nbsp;命令，如果你还没有项目的配置文件的话，应该会看到当前的&nbsp;Webpack&nbsp;版本和一个命令的帮助列表。3.&nbsp;在项目中安装&nbsp;Webpack<br ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('425', null, '<p>Linux的命令</p>\r\n', '5', '2', '<p>1、uname -m 显示机器的处理器架构<br />\r\n2、uname -r 显示正在使用的内核版本<br />\r\n3、shutdown -h now 关闭系统<br />\r\n4、rm -rf dir1 删除一个叫做 &#39;dir1&#39; 的目录并同时删除其内容<br />\r\n5、find / -user user1 搜索属于用户 &#39;user1&#39; 的文件和目录<br />\r\n6、groupadd group_name 创建一个新用户组<br />\r\n7、groupdel group_name 删除一个用户组</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('426', null, '<p>如何实现购物车的计算功能？&nbsp;&nbsp;</p>\r\n', '5', '5', '<p>（1）我们平时购物的时候，有时候点击商品页面的加入购物车，然后商品就直接加入到购物车列表中，不管用户是否登录。然后我们换了一台设备，发现该网站我们之前在另一台设备上加入购物车的商品不存在。由此我们可以推断出：购物车列表的内容不是存放在数据库，而是在cookie中。，所以购物车功能实现是在客户端实现的。<br />\r\n<br />\r\n（2）购物车我们需要实现的功能有哪些呢？<br />\r\n<br />\r\n展示购物车列表、向购物车列表中添加商品（add）、修改购物车列表中商品的数量、删除列表中的商品。<br />\r\n<br />\r\n逻辑实现：<br />\r\n<br />\r\n一、展示购物车列表：<br />\r\n<br />\r\n因为购物车的商品列表是保存在cookie中的，所以我们获取购物车列表就是从cookie中获取商品列表。<br />\r\n<br />\r\n首先cookie中保存形式也是key-value的形式，key指的是保存的名称，比如TT_CART,是一个标志而已。value是保存的商品的具体信息，是以字符串的形式保存的，我们通常将列表的形式转换成json格式的数据，因为json', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('427', null, '<p>&nbsp;数组去重es5、es6？</p>\r\n', '5', '3', '<pre>\r\n<code class=\"language-javascript\">\"let array = Array.from(new Set([1, 1, 1, 2, 3, 2, 4]));\r\nconsole.log(array);\r\n// =&gt; [1, 2, 3, 4]\r\n附：ES5实现数组去重\r\n\r\nvar array = [1, \'1\', 1, 2, 3, 2, 4];\r\nvar tmpObj = {};\r\nvar result = [];\r\narray.forEach(function(a) {\r\n  var key = (typeof a) + a;\r\n  if (!tmpObj[key]) {\r\n    tmpObj[key] = true;\r\n    result.push(a);\r\n  }\r\n});\r\nconsole.log(result);\r\n// =&gt; [1, \"\"1\"\", 2, 3, 4]\"\r\n</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('428', null, '<p>跨域的实现？</p>\r\n', '5', '3', '<p>①通过jsonp跨域<br />\r\n②CORS<br />\r\n核心思想：在服务器端通过检查请求头部的origin，从而决定请求应该成功还是失败。具体的方法是在服务端设置Response&nbsp;Header响应头中的Access-Control-Allow-Origin为对应的域名，实现了CORS（跨域资源共享），这里出于在安全性方面的考虑就是尽量不要用&nbsp;*，但对于一些不重要的数据则随意。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('429', null, '<p>vuex放在那个目录中？&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '5', '<p>文件之间的关系：<br />\r\n<br />\r\nstore文件夹&nbsp;-&nbsp;存放vuex的系列文件<br />\r\n<br />\r\nstore.js&nbsp;-&nbsp;引入vuex，设置state状态数据，引入getter、mutation和action<br />\r\n<br />\r\ngetter.js&nbsp;-&nbsp;获取store内的状态<br />\r\n<br />\r\nmutation.js&nbsp;-&nbsp;更改store中状态用的函数的存储之地<br />\r\n<br />\r\naction.js&nbsp;-&nbsp;提交mutation以达到委婉地修改state状态，可异步操作</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('430', null, '<p>c3新特性？<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '3', '<p>&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n\r\n<pre>\r\n<code class=\"language-javascript\">\"选择器\r\n\r\n框模型\r\n\r\n背景和边框 \r\nborder-radius、box-shadow、border-image、 \r\nbackground-size：规定背景图片的尺寸 \r\nbackground-origin：规定背景图片的定位区域 \r\nbackground-clip：规定背景的绘制区域\r\n文本效果（常用） \r\ntext-shadow：设置文字阴影 \r\nword-wrap：强制换行 \r\nword-break \r\ncss3提出@font-face规则，规则中定义了font-family、font-weight、font-style、font-stretch、src、unicode-range\r\n2/3D转换 \r\ntransform：向元素应用2/3D转换 \r\ntransition：过渡\r\n动画\r\n@keyframes规则： \r\nanimation、animation-name、animation-duration等\r\n用户界面（', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('431', null, '<p>vue和angular的生命周期？<br />\r\n<br />\r\n&nbsp;</p>\r\n', '5', '5', '<pre>\r\n<code class=\"language-javascript\">\"\r\n　　vue【beforeCreate】\r\n　　在实例开始初始化时同步调用。此时数据观测、事件等都尚未初始化\r\n【created】\r\n在实例创建之后调用。此时已完成数据观测、事件方法，但尚未开始DOM编译，即未挂载到document中\r\n【beforeMount】\r\n　　在mounted之前运行\r\n\r\n【mounted】\r\n\r\n　　在编译结束时调用。此时所有指令已生效，数据变化已能触发DOM更新，但不保证$el已插入文档　　\r\n\r\n【beforeUpdate】\r\n\r\n　　在实例挂载之后，再次更新实例(例如更新 data)时会调用该方法，此时尚未更新DOM结构\r\n\r\n【updated】\r\n\r\n　　在实例挂载之后，再次更新实例并更新完DOM结构后调用\r\n\r\n【beforeDestroy】\r\n\r\n　　在开始销毁实例时调用，此刻实例仍然有效\r\n\r\n【destroyed】\r\n\r\n　　在实例被销毁之后调用。此时所有绑定和实例指令都已经解绑，子实例也被销毁\r\n\r\n【activated】\r\n\r\n　　需要配合动态组件k', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('432', null, '<p>如何获取url上面的参数？</p>\r\n', '5', '3', '<p>js获取URL中的参数<br />\r\njs获取URL中的一些参数的意思<br />\r\n<br />\r\nlocation对象&nbsp;含有当前URL的信息.&nbsp;属性&nbsp;href&nbsp;整个URL字符串.<br />\r\nprotocol&nbsp;含有URL第一部分的字符串,如http:<br />\r\nhost&nbsp;包含有URL中主机名:端口号部分的字符串.如//www.cenpok.net/server/<br />\r\nhostname&nbsp;包含URL中主机名的字符串.如http://www.cenpok.net&nbsp;;<br />\r\nport&nbsp;包含URL中可能存在的端口号字符串.<br />\r\npathname&nbsp;URL中&quot;/&quot;以后的部分.如~list/index.htm<br />\r\nhash&nbsp;&quot;#&quot;号(CGI参数)之后的字符串.<br />\r\nsearch&nbsp;&quot;?&quot;号(CGI参数)之后的字符串.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('433', null, '<p>阐述你了解的web的攻击技术？</p>\r\n', '5', '5', '<p>一、主动攻击<br />\r\n主动攻击是指攻击者通过直接访问Web应用，把攻击代码传入的攻击模式。由于该模式是直接针对服务器上的资源进行攻击的，因此攻击者需要能够访问到这些资源。主动攻击模式里具有代表性的攻击是SQL注入攻击和OS命令注入攻击。<br />\r\n<br />\r\na、SQL注入<br />\r\n<br />\r\n定义：通过把SQL命令插入到Web表单递交或输入域名或页面请求的查询字符串中，最终达到欺骗服务器执行恶意SQL命令的目的。<br />\r\n<br />\r\n上述命令，where&nbsp;语句永远成立，且在执行后会删除student表，这样执行后果很严重。<br />\r\n<br />\r\n如何防止SQL注入：<br />\r\n<br />\r\n不信任用户的输入；<br />\r\n不使用动态拼接sql，可使用参数化的sql或直接使用存储过程进行数据查询存取；<br />\r\n不使用管理员权限的数据库连接；<br />\r\n对机密信息进行加密或hash掉密码和敏感信息；<br />\r\n应用异常尽可能少在web提示，最好使用自定义信息对应用的异常信息进行包装；<br />\r\n采用工具或', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('434', null, '<p>css3怎么实现平移，旋转，缩放，倾斜以及过渡效果</p>\r\n', '5', '2', '<p>transform:translate(100px,100px);&nbsp;<br />\r\n&nbsp;&nbsp;&nbsp;transform:&nbsp;rotate(7deg);<br />\r\n&nbsp;&nbsp;&nbsp;transform:&nbsp;scale(1.1);<br />\r\n&nbsp;&nbsp;&nbsp;transform:skew(10deg,10deg);<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;transition:&nbsp;all&nbsp;2s;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('435', null, '<p>vue&nbsp;前后端分离项目怎么进行seo优化？</p>\r\n', '5', '2', '<p>spa开发模式的最大问题就是搜索引擎无法爬取页面内容，因为页面是通过http请求服务端接口数据动态渲染的，但是搜索引擎不会等待这个过程，这就导致前后端分离项目的seo优化成为一个问题。对于vue项目来说，一般有两种解决方案：<br />\r\n1.开启服务端渲染：首先安装&nbsp;ssr&nbsp;支持：&nbsp;npm&nbsp;i&nbsp;-D&nbsp;vue-server-renderer；重要的是&nbsp;vue-server-renderer&nbsp;与&nbsp;vue&nbsp;版本必须一致匹配<br />\r\n优点：可以做到真实数据实时渲染，完全可供SEO小蜘蛛尽情的爬来爬去；完全前后端同构，路由配置共享，不再影响服务器404请求。<br />\r\n缺点：依旧只支持h5&nbsp;history的路由模式，配置比较麻烦、处理流程比较复杂&nbsp;(比对预渲染插件，复杂太多)；约束较多，不能随心所欲的乱放大招；对服务器会造成较大的压力，既然让浏览器更快的渲染了，那就得以占用服务器的性能来买单了<br />\r\n2.使用prerender-spa-plugin插件', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('436', null, '<p>ajax的实现原理？</p>\r\n', '5', '4', '<p>　Ajax的原理简单来说通过XmlHttpRequest对象来向服务器发异步请求，从服务器获得数据，然后用javascript来操作DOM而更新页面。这其中最关键的一步就是从服务器获得请求数据。要清楚这个过程和原理，我们必须对&nbsp;XMLHttpRequest有所了解。<br />\r\n<br />\r\nXMLHttpRequest是ajax的核心机制，它是在IE5中首先引入的，是一种支持异步请求的技术。简单的说，也就是javascript可以及时向服务器提出请求和处理响应，而不阻塞用户。达到无刷新的效果。<br />\r\n<br />\r\n&nbsp;&nbsp;　所以我们先从XMLHttpRequest讲起，来看看它的工作原理。<br />\r\n<br />\r\n&nbsp;&nbsp;　首先，我们先来看看XMLHttpRequest这个对象的属性。<br />\r\n<br />\r\n&nbsp;&nbsp;　　它的属性有：<br />\r\n<br />\r\n&nbsp;&nbsp;　　onreadystatechange&nbsp;&nbsp;每次状态改变所触发事件的事件处理程序。<br', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('437', null, '<p>你有哪些性能优化的方法？</p>\r\n', '5', '2', '<p>（1）&nbsp;减少http请求次数：CSS&nbsp;Sprites,&nbsp;JS、CSS源码压缩、图片大小控制合适；网页Gzip，CDN托管，data缓存&nbsp;，图片服务器。<br />\r\n（2）&nbsp;前端模板&nbsp;JS+数据，减少由于HTML标签导致的带宽浪费，前端用变量保存AJAX请求结果，每次操作本地变量，不用请求，减少请求次数<br />\r\n（3）&nbsp;用innerHTML代替DOM操作，减少DOM操作次数，优化javascript性能。<br />\r\n（4）&nbsp;当需要设置的样式很多时设置className而不是直接操作style。<br />\r\n（5）&nbsp;少用全局变量、缓存DOM节点查找的结果。减少IO读取操作。<br />\r\n（6）&nbsp;避免使用CSS&nbsp;Expression（css表达式)又称Dynamic&nbsp;properties(动态属性)。<br />\r\n（7）&nbsp;图片预加载，将样式表放在顶部，将脚本放在底部&nbsp;&nbsp;加上时间戳。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('438', null, '<p>webpack怎么配置&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;', '5', '5', '<p>1.&nbsp;安装&nbsp;Node&nbsp;Js<br />\r\n首先，Webpack&nbsp;是基于&nbsp;NodeJs&nbsp;的工具，你必须首先安装&nbsp;NodeJs.&nbsp;NodeJs&nbsp;仅仅只需要在你的系统中安装一次就可以了。<br />\r\n<br />\r\n2.&nbsp;全局安装&nbsp;Webpack<br />\r\n我们希望能够在系统的任何文件夹中使用&nbsp;Webpack，使用的方式是通过&nbsp;Webpack&nbsp;命令来完成的，这需要我们全局安装&nbsp;Webpack。这也只需要安装一次，以后每个项目就不需要重新全局安装了。<br />\r\n<br />\r\nnpm&nbsp;install&nbsp;webpack&nbsp;-g<br />\r\n&nbsp;成功安装之后，你应该能够在任何目录中执行&nbsp;webpack&nbsp;命令，如果你还没有项目的配置文件的话，应该会看到当前的&nbsp;Webpack&nbsp;版本和一个命令的帮助列表。3.&nbsp;在项目中安装&nbsp;Webpack<br ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('439', null, '<p>&nbsp;ajax请求中json和jsonp得区别&nbsp;简要回答</p>\r\n', '5', '2', '<p>a)json是一种轻量级的数据交换格式。<br />\r\nb)jsonp是一种跨域数据交互协议。<br />\r\nc)json的优点：（1）基于纯文本传递极其简单，（2）轻量级数据格式适合互联网传递，（3）容易编写和解析。<br />\r\nd)相同点：都是请求一个url<br />\r\ne)不同点：ajax的核心是通过xmlHttpRequest获取内容</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('440', null, '<p>如何实现购物车的计算功能&nbsp;</p>\r\n', '5', '5', '<p>（1）我们平时购物的时候，有时候点击商品页面的加入购物车，然后商品就直接加入到购物车列表中，不管用户是否登录。然后我们换了一台设备，发现该网站我们之前在另一台设备上加入购物车的商品不存在。由此我们可以推断出：购物车列表的内容不是存放在数据库，而是在cookie中。，所以购物车功能实现是在客户端实现的。<br />\r\n<br />\r\n（2）购物车我们需要实现的功能有哪些呢？<br />\r\n<br />\r\n展示购物车列表、向购物车列表中添加商品（add）、修改购物车列表中商品的数量、删除列表中的商品。<br />\r\n<br />\r\n逻辑实现：<br />\r\n<br />\r\n一、展示购物车列表：<br />\r\n<br />\r\n因为购物车的商品列表是保存在cookie中的，所以我们获取购物车列表就是从cookie中获取商品列表。<br />\r\n<br />\r\n首先cookie中保存形式也是key-value的形式，key指的是保存的名称，比如TT_CART,是一个标志而已。value是保存的商品的具体信息，是以字符串的形式保存的，我们通常将列表的形式转换成json格式的数据，因为json', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('441', null, '<p>解决跨域的问题解决方案有哪些?</p>\r\n', '5', '2', '<p>具体是通过动态创建script标签，然后通过标签的src属性获取js文件中的js脚本，该脚本的内容是一个函数调用，参数就是服务器返回的数据，为了处理这些返回的数据，需要事先在页面定义好回调函数.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('442', null, '<p>简述一下jsonp跨域的原理</p>\r\n', '5', '2', '<p>具体是通过动态创建script标签，然后通过标签的src属性获取js文件中的js脚本，该脚本的内容是一个函数调用，参数就是服务器返回的数据，为了处理这些返回的数据，需要事先在页面定义好回调函数.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('443', null, '<p>数组去重es5&nbsp;es6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '4', '<pre>\r\n<code class=\"language-javascript\">\" let array = [1, 1, 1, 1, 2, 3, 4, 4, 5, 3];\r\n let set = new Set(array);\r\n console.log(set);\r\n // =&gt; Set {1, 2, 3, 4, 5}\"\r\n</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('444', null, '<p>vuex的是放在哪个目录结构中的&nbsp;&nbsp;</p>\r\n', '5', '3', '<p>放在src下面的store文件中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('445', null, '<p>跨域的实现过程&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '4', '<p>&nbsp;Cross-Origin&nbsp;Resource&nbsp;Sharing（CORS）跨域资源共享是一份浏览器技术的规范，提供了&nbsp;Web&nbsp;服务从不同域传来沙盒脚本的方法，以避开浏览器的同源策略，确保安全的跨域数据传输。现代浏览器使用CORS在API容器如XMLHttpRequest来减少HTTP请求的风险来源。与&nbsp;JSONP&nbsp;不同，CORS&nbsp;除了&nbsp;GET&nbsp;要求方法以外也支持其他的&nbsp;HTTP&nbsp;要求。服务器一般需要增加如下响应头的一种或几种：<br />\r\n<br />\r\nAccess-Control-Allow-Origin:&nbsp;*<br />\r\nAccess-Control-Allow-Methods:&nbsp;POST,&nbsp;GET,&nbsp;OPTIONS<br />\r\nAccess-Control-Allow-Headers:&nbsp;X-PINGOTHER,&nbsp;Content-Type<br />\r\nAccess-Control-Max-A', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('446', null, '<p>.简单讲了一下项目&nbsp;遇到的难题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nb', '5', '3', '<p>遇到过一个页面传参不会，后来查资料发现可以通过url和H5的数据存储可以解决</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('447', null, '<p>vue&nbsp;的双向数据绑定原理</p>\r\n', '5', '4', '<p>VueJS&nbsp;则使用&nbsp;ES5&nbsp;提供的&nbsp;Object.defineProperty()&nbsp;方法，监控对数据的操作，从而可以自动触发数据同步。并且，由于是在不同的数据上触发同步，可以精确的将变更发送给绑定的视图，而不是对所有的数据都执行一次检测。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('448', null, '<p>&nbsp;url栏中网址&nbsp;敲回车后会发生什么&nbsp;&nbsp;</p>\r\n', '5', '3', '<p><br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;浏览器向DNS服务器（先查找缓存）查找输入URL对应的IP地址<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;DNS服务器返回对应的IP地址<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;浏览器根据IP地址与目标web服务器在80端口上建立TCP连接<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;浏览器获取请求页面的html代码<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;浏览器在显示窗口内渲染HTML<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;窗口关闭时，浏览器中止与服务器的连接</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('449', null, '<p>larave与tp的区别</p>\r\n', '5', '3', '<p>1.渲染模版方式的不同:</p>\r\n\r\n<p>在Laravel框架里,使用return view()来渲染模版;而ThinkPHP里则使用了$this-&gt;display()的方式渲染模版;</p>\r\n\r\n<p>2.在Laravel框架里,由于其考虑到了跨站请求伪造, 所以如果使用form表单以post方式进行传值时,如果不再form表单中加入{{csrf_field()}}则会报出TokenMethodnotfound的语法错误;而TP框架则需要自己手动完成防止跨站攻击的代码;</p>\r\n\r\n<p>3.Laravel是一个重路由的框架(5.4),所有的功能都是由路由发起的,哪怕没有控制器方法,只要写了路由就能够访问,thinkPHP(3.2),必须要有控制器方法才能正常访问;</p>\r\n\r\n<p>4.laravel具有强大的社区化扩展，（composer扩展自动加载）;</p>\r\n\r\n<p>5.laravel具有强大的Blade模版引擎;</p>\r\n\r\n<p>6.中间件，Laravel特点，可以实现访问前后的处理，例如请求和返回，权限认证等;</p>\r\n\r\n<p>7.条件判', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('450', null, '<p>&nbsp;闭包的运用场景和优缺点</p>\r\n', '5', '3', '<p>继承，内存泄漏</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('451', null, '<p>post和get请求的区别&nbsp;</p>\r\n', '5', '3', '<p>GET请求，请求的数据会附加在URL之后，以?分割URL和传输数据，多个参数用&amp;连接。URL的编码格式采用的是ASCII编码，而不是uniclde，即是说所有的非ASCII字符都要编码之后再传输。<br />\r\n<br />\r\nPOST请求：POST请求会把请求的数据放置在HTTP请求包的包体中。上面的item=bandsaw就是实际的传输数据。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('452', null, '<p>还有sessionStorage和localStorage</p>\r\n', '5', '4', '<p>localStorage生命周期是永久，这意味着除非用户显示在浏览器提供的UI上清除localStorage信息，否则这些信息将永远存在。存放数据大小为一般为5MB,而且它仅在客户端（即浏览器）中保存，不参与和服务器的通信。sessionStorage仅在当前会话下有效，关闭页面或浏览器后被清除。存放数据大小为一般为5MB,而且它仅在客户端（即浏览器）中保存，不参与和服务器的通信。源生接口可以接受，亦可再次封装来对Object和Array有更好的支持。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('453', null, '<p>以及cookie的区别&nbsp;</p>\r\n', '5', '3', '<p>生命期为只在设置的cookie过期时间之前一直有效，即使窗口或浏览器关闭。&nbsp;存放数据大小为4K左右&nbsp;。有个数限制（各浏览器不同），一般不能超过20个。与服务器端通信：每次都会携带在HTTP头中，如果使用cookie保存过多数据会带来性能问题。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('454', null, '<p>谈谈js脚本攻击</p>\r\n', '5', '3', '<p>每当接受用户输入的内容并重新显示这些内容时，网站就很容易遭受&nbsp;JavaScript&nbsp;注入攻击。让我们研究一个容易遭受&nbsp;JavaScript&nbsp;注入攻击的具体应用程序。假设已经创建了一个客户反馈网站。客户可以访问网站并输入对产品的反馈信息。当客户提交反馈时，反馈信息重新显示在反馈页面上。<br />\r\n<br />\r\n客户反馈网站是一个简单的网站。不幸的是，此网站容易遭受&nbsp;JavaScript&nbsp;注入攻击</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('455', null, '<p>懒加载的原理</p>\r\n', '5', '4', '<p>先将img标签中的src链接设为同一张图片（空白图片），将其真正的图片地址存储再img标签的自定义属性中（比如data-src）。当js监听到该图片元素进入可视窗口时，即将自定义属性中的地址存储到src属性中，达到懒加载的效果。<br />\r\n这样做能防止页面一次性向服务器响应大量请求导致服务器响应慢，页面卡顿或崩溃等问题</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('456', null, '<p>怎么实现登陆&nbsp;注册</p>\r\n', '5', '4', '<p>点击登录按钮，我们跳转到登录页面，通过获取到用户输入的input值，通过下标的方法取得输入的username和pwd的值，通过连接数据库，判断回调函数返回的状态值，如果成功，给予提示用户注册成功，紧接着进行页面的跳转，如果出现异常，给出提示，并相应的跳转到错误页面，在此处我们可以使用try{}catch(){}方法进行拦截，打印出具体的错误信息。<br />\r\n<br />\r\n紧接着，我们再来讲一下注册的操作，顾名思义，注册就是将原本不存在于数据库的用户资料通过数据库的insert语句插入数据库中，道理和登录有些类似，首先，我们需要输入需要注册的信息，然后获取到这些信息，然后再发送一个异步请求验证数据库是否有这些资料，如果没有的话就直接创建这些资料</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('457', null, '<p>轮播图的原理</p>\r\n', '5', '2', '<p>实现轮播图最主要的就是定时器&nbsp;（setInterval&nbsp;函数和&nbsp;clearInterval&nbsp;函数），他们分别是定时和清除定时器</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('458', null, '<p>&nbsp;手写数组冒泡排序</p>\r\n', '5', '3', '<pre>\r\n<code class=\"language-javascript\">\"var arr = [3,1,4,2,5,21,6,15,63];\r\n\r\nfunction sortA(arr){\r\n    for(var i=0;i&lt;arr.length-1;i++){\r\n        for(var j=i+1;j&lt;arr.length;j++){\r\n                      //获取第一个值和后一个值比较\r\n            var cur = arr[i];\r\n            if(cur&gt;arr[j]){\r\n                      // 因为需要交换值，所以会把后一个值替换，我们要先保存下来\r\n                var index = arr[j];\r\n                        // 交换值\r\n                arr[j] = cur;\r\n                arr[i] = index;\r\n            }\r\n        }', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('459', null, '<p>还有就是看着简历上的项目&nbsp;问一些功能&nbsp;怎么实现的</p>\r\n', '5', '3', '<p>根据面试官的问题，灵活应对</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('460', null, '<p>公司的技术栈</p>\r\n', '5', '2', '<p>h5&nbsp;&nbsp;c3&nbsp;&nbsp;&nbsp;ajax&nbsp;&nbsp;bootstrap&nbsp;&nbsp;angular&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('461', null, '<p>angular&nbsp;</p>\r\n', '5', '4', '<p>AngularJS有着诸多特性，最为核心的是：MVVM、模块化、自动化双向数据绑定、语义化标签、依赖注入等等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('462', null, '<p>vue</p>\r\n', '5', '4', '<p>Vue的核心定位并不是一个框架[3]，设计上也没有完全遵循MVVM模式，可以看到在图中只有State和View两部分，&nbsp;Vue的核心功能强调的是状态到界面的映射，对于代码的结构组织并不重视，&nbsp;所以单纯只使用其核心功能时，它并不是一个框架，而更像一个视图模板引擎，这也是为什么Vue开发者把其命名成读音类似于view的原因</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('463', null, '<p>浏览器兼容&nbsp;性的理解&nbsp;&nbsp;</p>\r\n', '5', '2', '<p>览器的类型及版本的不同会造成&nbsp;CSS&nbsp;效果不尽相同，因此需要实现浏览器兼容，也可以针对不同的浏览器编写不同的CSS。<br />\r\n目前，各主流浏览器的新版本，对于&nbsp;W3C&nbsp;的标准支持很好，因此，首先保证代码符合W3C的标准，这是解决浏览器兼容问题的前提。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('464', null, '<p>vue和angular区别&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '4', '<p>在&nbsp;API&nbsp;与设计两方面上&nbsp;Vue.js&nbsp;都比&nbsp;Angular&nbsp;简单得多，因此你可以快速地掌握它的全部特性并投入开发。<br />\r\nVue.js&nbsp;是一个更加灵活开放的解决方案。它允许你以希望的方式组织应用程序，而不是任何时候都必须遵循&nbsp;Angular&nbsp;制定的规则。它仅仅是一个视图层，所以你可以将它嵌入一个现有页面而不一定要做成一个庞大的单页应用。在配合其他库方面它给了你更大的的空间，但相应，你也需要做更多的架构决策。例如，Vue.js&nbsp;核心默认不包含路由和&nbsp;Ajax&nbsp;功能，并且通常假定你在应用中使用了一个模块构建系统。这可能是最重要的区别。<br />\r\nAngular&nbsp;使用双向绑定，Vue&nbsp;也支持双向绑定，不过默认为单向绑定，数据从父组件单向传给子组件。在大型应用中使用单向绑定让数据流易于理解。<br />\r\n在&nbsp;Vue.js&nbsp;中指令和组件分得更清晰。指令只封装&nbsp;DOM&nbsp;操作，而组件代表一个自给自足', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('465', null, '<p>项目中主要用的技术</p>\r\n', '5', '3', '<p>jq+vue</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('466', null, '<p>xss攻击&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '5', '<p>XSS攻击是Web攻击中最常见的攻击方法之一，它是通过对网页注入可执行代码且成功地被浏览器<br />\r\n执行，达到攻击的目的，形成了一次有效XSS攻击，一旦攻击成功，它可以获取用户的联系人列<br />\r\n表，然后向联系人发送虚假诈骗信息，可以删除用户的日志等等，有时候还和其他攻击方式同时实<br />\r\n施比如SQL注入攻击服务器和数据库、Click劫持、相对链接劫持等实施钓鱼，它带来的危害是巨<br />\r\n大的，是web安全的头号大敌。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('467', null, '<p>原型链</p>\r\n', '5', '4', '<p>在&nbsp;JavaScript&nbsp;中，每当定义一个对象（函数也是对象）时候，对象中都会包含一些预定义的属性。其中每个函数对象都有一个prototype&nbsp;属性，这个属性指向函数的原型对象。当一个对象查找有个属性或者方法的时候，首先在自身上查找，如果没有就到原型上查找，这样形成的链条我们成为原型链</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('468', null, '<p>box-sizing的了解</p>\r\n', '5', '2', '<p>box-sizing，css3新属性，为了改变ie浏览器的盒模型遗留的width（名副其实）bug</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('469', null, '<p>webpack有用么？</p>\r\n', '5', '4', '<p>工程化工具&nbsp;代码编译、压缩、合并、CSS解析&nbsp;等等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('470', null, '<p>es6有哪些新特性，let和var有什么区别</p>\r\n', '5', '5', '<p>通过var定义的变量，作用域是整个封闭函数，是全域的&nbsp;。通过let定义的变量，作用域是在块级或是子块中</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('471', null, '<p>抓包工具有哪些</p>\r\n', '5', '5', '<p>Fiddler&nbsp;Charles&nbsp;Anyproxy&nbsp;mitmproxy/mitmdump</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('472', null, '<p>状态码知道那些&nbsp;&nbsp;</p>\r\n', '5', '3', '<p>200&nbsp;&nbsp;&nbsp;（成功）&nbsp;&nbsp;服务器已成功处理了请求，300&nbsp;&nbsp;&nbsp;（多种选择）&nbsp;&nbsp;针对请求，服务器可执行多种操作，400&nbsp;&nbsp;&nbsp;（错误请求）&nbsp;服务器不理解请求的语法，404&nbsp;&nbsp;&nbsp;（未找到）&nbsp;服务器找不到请求的网页。500&nbsp;&nbsp;&nbsp;（服务器内部错误）&nbsp;&nbsp;服务器遇到错误，无法完成请求</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('473', null, '<p>call和apply的区别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '5', '<p>call函数和apply方法的第一个参数都是要传入给当前对象的对象，及函数内部的this。后面的参数都是传递给当前对象的参数。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('474', null, '<p>对原生js的了解&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '4', '<p>原生态js是指遵循ECMAscript标准的javascript，不同于微软的jscript也不依赖于任何框架，依托于浏览器标准引擎的脚本语言，jquery是在原生态的js上集成的框架资源，使用jquery并不代表代码就不是你写的，区别在于使用jquery只是使用了它的语法，更利于兼容以及实现，jquery已经将常规的js兼容问题解决，所以使用起来出现不兼容的情况会更少，更利于开发，但同时，要使用jquery等框架也需要去学习相关的语法，拥有js基础的同学学习jquery时会发现很轻松，在使用时也会发现很方便</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('475', null, '<p>数据返回有问题了怎么处理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '5', '<p>这个要看具体的是报的什么错误，根据提示的错误信息来进行修改</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('476', null, '<p>除了npm你还知道什么&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n', '5', '5', '<p>包管理工具&nbsp;还有&nbsp;yarn&nbsp;cnpm</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('477', null, '<p>怎么获取载入当前文档的前一个url</p>\r\n', '5', '4', '<p>document.URL;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('478', null, '<p>权限管理如何实现的</p>\r\n', '5', '4', '<p>RBAC就是用户通过角色与权限进行关联。简单地说，一个用户拥有若干角色，每一个角色拥有若干权限。这样，就构造成&ldquo;用户-角色-权限&rdquo;的授权模型。在这种模型中，用户与角色之间，角色与权限之间，一般者是多对多的关系。当用户发生变化的时候，相应的角色也相应变化，并且改变人员的角色信息，添加保存，添加保存的基本思路是先把数据库里人员对应的角色信息全部删除，然后再取到选中的部分，添加到数据库。一般说来有三表、四表、五表三种方式可以实现RBAC，我们常用五表来做，因为对表的操作更加灵活，拓展性更好</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('479', null, '<p>redis的特性有哪些</p>\r\n', '5', '4', '<p>Redis 特点<br />\r\n一、Redis数据库完全在内存中，使用磁盘仅用于持久性。<br />\r\n二、相比许多键值数据存储，Redis拥有一套较为丰富的数据类型。<br />\r\n三、Redis可以将数据复制到任意数量的从服务器。</p>\r\n\r\n<p>Redis 优势<br />\r\n1、异常快速：Redis的速度非常快，每秒能执行约11万集合，每秒约81000+条记录。<br />\r\n2、支持丰富的数据类型：Redis支持Redis支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及zset(sorted set：有序集合)。这使得它非常容易解决各种各样的问题，因为我们知道哪些问题是可以处理通过它的数据类型更好。<br />\r\n3、操作都是原子性：所有Redis操作是原子的，这保证了如果两个客户端同时访问的Redis服务器将获得更新后的值。<br />\r\n4、多功能实用工具：Redis是一个多实用的工具，可以在多个用例如缓存，消息，队列使用(Redis原生支持发布/订阅)，任何短暂的数据，应用程序，如Web应用程序会话，网页命中计数等', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('480', null, '<p>模糊查询怎么实现的</p>\r\n', '5', '4', '<p>模糊查询有四种方式：1、% ：表示任意0个或多个字符。可匹配任意类型和长度的字符，有些情况下若是中文，请使用两个百分号（%%）表示；<br />\r\n2，_ ： 表示任意单个字符。匹配单个任意字符，它常用来限制表达式的字符长度语句；<br />\r\n3，[ ] ：表示括号内所列字符中的一个（类似正则表达式）。指定一个字符、字符串或范围，要求所匹配对象为它们中的任一个<br />\r\n4，[^ ] ：表示不在括号所列之内的单个字符。其取值和 [] 相同，但它要求所匹配对象为指定字符以外的任一个字符</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('481', null, '<p>如何实现分页</p>\r\n', '5', '4', '<p>首次渲染页面时通过获取数据总数然后除以每页显示的数量结果向上取整获取到总的页码数，将页码展示在页面上，通过点击页码传递需要展示页数，后端接收页码配合每页的数量获取数据，此处需要使用sql语句中的limit语句，查询并返回需要的数据。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('482', null, '<p>谈谈对oop的理解</p>\r\n', '5', '2', '<p>OOP 达到了软件工程的三个主要目标：重用性、灵活性和扩展性<br />\r\nOOP有三大特性：继承、封装、多态<br />\r\nOOP的优点：<br />\r\n代码维护更容易<br />\r\n代码质量更高<br />\r\n开发的效率更高<br />\r\n易拓展<br />\r\nOOP思想中有MVC结构</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('483', null, '<p>Empty和isset以及is_null的区别</p>\r\n', '5', '2', '<p>Empty，检测变量是否为&ldquo;空&rdquo;<br />\r\n说明：任何一个未初始化的变量、值为 0 或 false 或 空字符串&rdquo;&quot; 或 null的变量、空数组、没有任何属性的对象，都将判断empty==true&nbsp;；<br />\r\n未初始化的变量也能被empty检测为&ldquo;空&rdquo;，empty只能检测变量，而不能检测语句<br />\r\nisset判断变量是否被初始化&nbsp;<br />\r\n&nbsp;说明：它并不会判断变量是否为空，并且可以用来判断数组中元素是否被定义过,当使用isset来判断数组元素是否被初始化过时，它的效率比array_key_exists高4倍左右<br />\r\nis_null：检测变量是否为&ldquo;null&rdquo;，当变量被赋值为&ldquo;null&rdquo;时，检测结果为true</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('484', null, '<p>Include require include_once require_once 的区别.</p>\r\n', '5', '2', '<p>处理失败方式不同：<br />\r\nrequire 失败时会产生一个致命级别错误，并停止程序运行。<br />\r\ninclude 失败时只产生一个警告级别错误，程序继续运行。<br />\r\ninclude_once/require_once和include/require 处理错误方式一样，<br />\r\n唯一区别在于当所包含的文件代码已经存在时候，不在包含。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('485', null, '<p>Include require include_once require_once 的区别.</p>\r\n', '5', '2', '<p>处理失败方式不同：<br />\r\nrequire 失败时会产生一个致命级别错误，并停止程序运行。<br />\r\ninclude 失败时只产生一个警告级别错误，程序继续运行。<br />\r\ninclude_once/require_once和include/require 处理错误方式一样</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('486', null, '<p>ajax是什么？</p>\r\n', '5', '2', '<p>ajax是指一种创建交互式网页应用的网页开发技术，简单的说就是一个异步页面交互技术</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('487', null, '<p>说出你知道的一些php魔术方法</p>\r\n', '5', '2', '<p>__construct()&nbsp; 实例化类时自动调用。<br />\r\n__destruct()&nbsp; 类对象使用结束时自动调用。<br />\r\n__set()&nbsp; 在给未定义的属性赋值的时候调用。<br />\r\n__get()&nbsp; 调用未定义的属性时候调用。<br />\r\n__isset()&nbsp; 使用isset()或empty()函数时候会调用。<br />\r\n__unset()&nbsp; 使用unset()时候会调用。<br />\r\n__sleep()&nbsp; 使用serialize序列化时候调用。<br />\r\n__wakeup()&nbsp; 使用unserialize反序列化的时候调用</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('488', null, '<p>优化SQL语句执行效率的方法，如何分析SQL语句</p>\r\n', '5', '4', '<p>（1）选择最有效率的表名顺序<br />\r\n（2）WHERE子句中的连接顺序<br />\r\n（3）SELECT子句中避免使用&lsquo;*&rsquo;<br />\r\n（4）用Where子句替换HAVING子句<br />\r\n（5）通过内部函数提高SQL效率<br />\r\n（6）避免在索引列上使用计算。<br />\r\n（7）提高GROUP BY 语句的效率, 可以通过将不需要的记录在GROUP BY 之前过滤掉</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('489', null, '<p>MYSQL索引的实现？</p>\r\n', '5', '4', '<p>按照分类，将索引列分成N多个磁盘块，使用B-Ztree或者B+Ztree（就是二叉树）查找，这样时间复杂度就是㏒(m+1)N，这里假设当前数据表的数据为N，每个磁盘块的数据项的数量是m</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('490', null, '<p>对于大流量的网站,您采用什么样的方法来解决各页面访问量统计问题</p>\r\n', '5', '5', '<p>1、通过第三方统计&nbsp; 站长之家等<br />\r\n2、收集分析web服务器访问日志(access.log)<br />\r\n3、自行通过编程方式，实现统计系统</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('491', null, '<p>MySQL数据库作发布系统的存储，一天五万条以上的增量，预计运维三年,怎么优化？</p>\r\n', '5', '5', '<p>a. 设计良好的数据库结构，允许部分数据冗余，尽量避免join查询，提高效率。<br />\r\nb. 选择合适的表字段数据类型和存储引擎，适当的添加索引。<br />\r\nc. mysql库主从读写分离。<br />\r\nd. 找规律分表，减少单表中的数据量提高查询速度。<br />\r\ne。添加缓存机制，比如memcached，apc等。<br />\r\nf. 不经常改动的页面，生成静态页面。<br />\r\ng. 书写高效率的SQL。比如 SELECT * FROM TABEL 改为 SELECT field_1, field_2, field_3 FROM TABLE.</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('492', null, '<p>优化某网页的加载速度</p>\r\n', '5', '5', '<p>1、gzip压缩<br />\r\n2、减少http请求（负载均衡技术，集群技术）<br />\r\n3、压缩js、css文件<br />\r\n4、使用页面静态化技术<br />\r\n5、页面懒加载技术<br />\r\n6、使用CDN - web服务器离用户更近，则多个HTTP请求的响应时间将缩短</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('493', null, '<p>什么是存储过程、事务</p>\r\n', '5', '2', '<p>是两个概念，存储过程是完成一定功能的可重复调用的程序。即，存储过程是程序。<br />\r\n事务是可以整个撤消的一段操作，可能是一个或几个或部份的存储过程，也可能是一条或几条指令，事务是记录的一系列的操作和变化。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('494', null, '<p>有用过跨越请求吗，有几种方式可以实现</p>\r\n', '5', '4', '<p>四种跨越请求：1、通过json跨域；2、通过doument.domian来跨子域；3通过window.name来跨域；4、使用HTML5中新引进的window.postMessage方法来跨域传送数据</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('495', null, '<p>如何防止SQL注入</p>\r\n', '5', '4', '<p>（1）使用mysql_real_escape_string：转义 SQL 语句中使用的字符串中的特殊字符，并考虑到连接的当前字符集<br />\r\n（2）打开magic_quotes_gpc来防止SQL注入：php.ini中有一个设置：magic_quotes_gpc = Off这个默认是关闭的，如果它打开后将自动把用户提交对sql的查询进行转换，比如把 &#39; 转为 \\&#39;等，对于防止sql注射有重大作用。<br />\r\n（3）如果magic_quotes_gpc=Off，则使用addslashes()函数<br />\r\n或者是使用自定义函数：利用正则匹配；判断参数的合法性</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('496', null, '<p>XSS攻击有哪些常见的形式？如何防止XSS攻击</p>\r\n', '5', '4', '<p>XSS是用户在表单中有意或无意输入一些恶意字符，从而破坏页面的表现！<br />\r\n看看常见的恶意字符XSS 输入：<br />\r\n1.XSS 输入通常包含 JavaScript 脚本，如弹出恶意警告框：&lt;script&gt;alert(&quot;XSS&quot;);&lt;/script&gt;<br />\r\n2.XSS 输入也可能是 HTML 代码段，譬如：<br />\r\n(1).网页不停地刷新 &lt;meta http-equiv=&quot;refresh&quot; content=&quot;0;&quot;&gt;<br />\r\n(2).嵌入其它网站的链接 &lt;iframe src=http://xxxx width=250 height=250&gt;&lt;/iframe&gt;<br />\r\n防止XSS攻击：1、利用 htmlspecialchars() 函数 和 htmlentities() 函数;2、可以定义一个xss_clean()函数（笔记中有，可以自行查看）;3、可以使用自定义函数，实现放sql注入和xss，具体的代码可以自行搜索</', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('497', null, '<p>如何防止暴力破解</p>\r\n', '5', '4', '<p>1、使用验证码<br />\r\n2、使用token令牌<br />\r\n3、提交前客户端加密后台解密<br />\r\n4、IP及IP段限制进行访问限制</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('498', null, '<p>memcache是怎么工作的？Memcache的缓存策略是什么？</p>\r\n', '5', '4', '<p>Memcache的缓存策略：当memcache服务器的hash表满了之后，新的插入数据会替代老的数据，更新的策略是LRU（最近最少使用），以及每个kv对的有效时限。Kv对存储有效时限是在mc端设置并作为参数传给memcache服务器的。<br />\r\n同时memcache服务器采用是偷懒替代法，memcache服务器不会开额外的进程来实时监测过时的kv对并删除，而是当且仅当，新来一个插入的数据，而此时又没有多余的空间放了，才会进行清除动作。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('499', null, '<p>memcache的优缺点</p>\r\n', '5', '4', '<p>memcached的特点：<br />\r\n1.全内存运转<br />\r\n2.哈希方式存储<br />\r\n3.简单文本协议进行数据通信<br />\r\n4.只操作字符型数据<br />\r\n5.其它类型数据由应用解释，序列化以及反序列化<br />\r\n6.集群也由应用进行控制，采用一致性散列（哈希）算法<br />\r\n&nbsp;Memcached的最大优势是：memcached之间没有相互通信，因此不会增加memcached的负载；没有多播协议，不会网络通信量爆炸（implode）</p>\r\n\r\n<p>Memcached的缺点<br />\r\n1、纯内存操作，关机后数据全部丢失<br />\r\n2、保存字节数据，数据类型贫乏<br />\r\n3、LRU算法导致数据不可控的丢失<br />\r\n4、一致性处理简单<br />\r\n5、应用端太厚，服务器端太薄<br />\r\n6、应用场景有限，难以被看成是完整的数据库产品</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('500', null, '<p>memcached、redis 和MySQL的query&nbsp;的对比</p>\r\n', '5', '4', '<p>Redis 和 memcached ：<br />\r\n1、Redis只使用单核，而Memcached可以使用多核。<br />\r\n2、Redis在存储小数据时比Memcached性能更高；而在100k以上的数据中，Memcached性能要高于Redis<br />\r\n3、简单的key-value存储，Memcached的内存利用率更高。而如果Redis采用hash结构来做key-value存储，由于其组合式的压缩，其内存利用率会高于Memcached<br />\r\n4、如果对数据持久化和数据同步有所要求，那么Redis性能高于Memcached<br />\r\n5、Redis相比Memcached来说，拥有更多的数据结构，并支持更丰富的数据操作<br />\r\n6、在Redis中，复杂的操作通常和一般的GET/SET一样高效。需要缓存能够支持更复杂的结构和操作，所以Redis 在这方面的性能要更高</p>\r\n\r\n<p>memcached和MySQL的query cache：<br />\r\n1、当修改表时，MySQL的query cache会立刻被刷新（flush）。存储一个memca', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '5', '1', '1');
INSERT INTO `t_question` VALUES ('501', null, '<p>memcached的cache机制是怎样的</p>\r\n', '5', '5', '<p>Memcached主要的cache机制是LRU（最近最少用）算法+超时失效。当存数据到memcached中，可以指定该数据在缓存中可以呆多久。如果memcached的内存不够用了，过期的数据会优先被替换，接着就轮到最老的未被使用的数据。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('502', null, '<p>Redis 常见的性能问题都有哪些？如何解决</p>\r\n', '5', '4', '<p>1、写内存快照：当快照比较大时对性能影响是非常大的，会间断性暂停服务，所以主服务器最好不要写内存快照。<br />\r\n2、AOF持久化：如果不重写AOF文件，这个持久化方式对性能的影响是最小的，但是AOF文件会不断增大，AOF文件过大会影响主服务器重启的恢复速度。主服务器最好不要做任何持久化工作，包括内存快照和AOF日志文件，特别是不要启用内存快照做持久化,如果数据比较关键，某个从服务器开启AOF备份数据，策略为每秒同步一次。<br />\r\n3、主服务器调用重写AOF文件，AOF在重写的时候会占大量的CPU和内存资源，导致服务load过高，出现短暂服务暂停现象。<br />\r\n4、Redis主从复制的性能问题，为了主从复制的速度和连接的稳定性，从服务器和主服务器最好在同一个局域网内</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('503', null, '<p>PHP静态化技术</p>\r\n', '5', '4', '<p>A、什么是PHP静态化<br />\r\n&nbsp;PHP静态化的简单理解就是使网站生成页面以静态HTML的形式展现在访客面前，PHP静态化分纯静态化（主要是用到ob缓存）和伪静态化（重写机制），两者的区别在于PHP生成静态页面的处理机制不同。<br />\r\nB、为什么要让网页静态化<br />\r\n&nbsp;一、加快页面打开浏览速度，静态页面无需连接数据库打开速度较动态页面有明显提高；<br />\r\n&nbsp;二、有利于搜索引擎优化SEO，Baidu、Google都会优先收录静态页面，不仅被收录的快还收录的全；<br />\r\n&nbsp;三、减轻服务器负担，浏览网页无需调用系统数据库；<br />\r\n&nbsp;四、网站更安全，HTML页面不会受php相关漏洞的影响； 观看一下大一点的网站基本全是静态页面，而且可以减少攻击，防sql注入。<br />\r\n&nbsp;五、数据库出错时，不影响网站正常访问。</p>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('504', null, '<p>MySQL对千万级的大表要怎么优化</p>\r\n', '5', '5', '<p>第一优化sql和索引；<br />\r\n第二加缓存，memcached,redis；<br />\r\n第三做主从复制或主主复制，读写分离，可以在应用层做，效率高，也可以用三方工具<br />\r\n第四mysql自带分区表，这个对用户的应用是透明的，无需更改代码,但是sql语句是需要针对分区表做优化的，sql条件中要带上分区条件的列，从而使查询定位到少量的分区上，否则就会扫描全部分区，另外分区表也是可以的<br />\r\n第五做垂直拆分，其实就是根据模块的耦合度，将一个大的系统分为多个小的系统，也就是分布式系统；<br />\r\n第六水平切分，针对数据量大的表，要选择一个合理的sharding key,为了有好的查询效率，表结构也要改动，做一定的冗余，应用也要改，sql中尽量带sharding key，将数据定位到限定的表上去查，而不是扫描全部的表</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('505', null, '<p>MySQL常用的函数</p>\r\n', '5', '4', '<p>mysql_affected_rows &mdash; 取得前一次 MySQL 操作所影响的记录行数<br />\r\nmysql_close &mdash; 关闭 MySQL 连接<br />\r\nmysql_connect &mdash; 打开一个到 MySQL 服务器的连接<br />\r\nmysql_create_db &mdash; 新建一个 MySQL 数据库<br />\r\nmysql_data_seek &mdash; 移动内部结果的指针<br />\r\nmysql_db_name &mdash; 取得结果数据<br />\r\nmysql_db_query &mdash; 发送一条 MySQL 查询<br />\r\nmysql_drop_db &mdash; 丢弃（删除）一个 MySQL 数据库</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('506', null, '<p>PHP缓存技术有哪些</p>\r\n', '5', '5', '<p>1. 全页面静态化缓存，也就是将页面全部生成html静态页面，用户访问时直接访问的静态页面，而不会去走php服务器解析的流程<br />\r\n2. 页面部分缓存，将一个页面中不经常变的部分进行静态缓存，而经常变化的块不缓存，最后组装在一起显示<br />\r\n3. 数据缓存，通过一个id进行请求的数据,将数据缓存到一个php文件中,id和文件是对应的,下次通过这个id进行请求时 直接读php文件<br />\r\n4. 查询缓存，和数据缓存差不多,根据查询语句进行缓存;<br />\r\n5. 内存式缓存，Redis和memcache</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('507', null, '<p>MVC的优缺点</p>\r\n', '5', '4', '<p>优点：<br />\r\n分散关注、松散耦合、逻辑复用、标准定义<br />\r\na. 开发人员可以只关注整个结构中的其中某一层，方便多开发人员间的分工<br />\r\nb. 可以很容易的用新的实现来替换原有层次的实现<br />\r\nc. 降低层与层之间的依赖<br />\r\nd. 利于各层逻辑的复用，有利于标准化<br />\r\ne. 对单元测试的支持更加出色<br />\r\n缺点：<br />\r\na. 清晰的构架以代码的复杂性为代价， 对小项目优可能反而降低开发效率<br />\r\nb. 降低了系统的性能，例如业务造访数据库现在必须通过中间层来完成<br />\r\nc. 控制层和表现层有时会过于紧密，导致没有真正分离和重用<br />\r\nd. 有时会导致级联的修改，如果在表示层中增加一个功能，为保证符合分层式结构，可能需要在相应的控制层和模型层中都增加相应的代码</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('508', null, '<p>说几个你知道的设计模式</p>\r\n', '5', '5', '<p>单例模式：保证一个类仅有一个实例，并提供一个访问他的全局访问点例如框架中的数据库连接<br />\r\n简单工厂模式：它具有创建对象的某些方法，可以使用工厂类创建对象，而不直接使用 new。例如初始化数据库的时候会用到，比如MySQL，MSSQL<br />\r\n策略模式：针对一组算法，将每一个算法封装到具有共同接口的独立的类中，例如进入个人主页时，根据浏览者的不同，给予不同的显示与操作<br />\r\n注册模式：提供了在程序中有条理的存放并管理一组全局对象 (object)，例如ZF框架中的Zend_Registry::set<br />\r\n适配器模式：将不同接口适配成统一的API接口，例如数据操作有mysql、mysqli、pdo等，可利用适配器模式统一接口<br />\r\n观察者模式：一个对象通过添加一个方法使本身变得可观察。当可观察的对象更改时，它会将消息发送到已注册的观察者。例如实现实现消息推送<br />\r\n装饰器模式：不修改原类代码和继承的情况下动态扩展类的功能，例如框架的每个Controller文件会提供before和after方法</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('509', null, '<p>shell命令方式向PHP传入参数的三种方式</p>\r\n', '5', '5', '<p>使用$argc $argv；使用getopt函数()；提示用户输入，然后获取输入的参数</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('510', null, '<p>php获取文件内容的方法，对应的函数</p>\r\n', '5', '4', '<p>a.&nbsp;file_get_contents得到文件的内容（可以以get和post的方式获取），整个文件读入一个字符串中<br />\r\nb. 用fopen打开url, 以get方式获取内容（借助fgets()函数）<br />\r\nc. 用fsockopen函数打开url（可以以get和post的方式获取），以get方式获取完整的数据，包括header和body<br />\r\nd. 使用curl库获取内容，使用curl库之前，需要查看php.ini，查看是否已经打开了curl扩展</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('511', null, '<p>HTTP协议的特点有哪些</p>\r\n', '5', '4', '<p>1、支持客户/服务器模式。<br />\r\n2、简单快速：客户向服务器请求服务时，只需传送请求方法和路径。请求方法常用的有GET、HEAD、POST。每种方法规定了客户与服务器联系的类型不同。由于HTTP协议简单，使得HTTP服务器的程序规模小，因而通信速度很快。<br />\r\n3、灵活：HTTP允许传输任意类型的数据对象。正在传输的类型由Content-Type加以标记。<br />\r\n4、无连接：无连接的含义是限制每次连接只处理一个请求。服务器处理完客户的请求，并收到客户的应答后，即断开连接。采用这种方式可以节省传输时间。<br />\r\n5、无状态：HTTP协议是无状态协议。无状态是指协议对于事务处理没有记忆能力。缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就较快</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('512', null, '<p>HTTP请求有哪些部分组成?http响应有哪些部分组成</p>\r\n', '5', '4', '<p>HTTP请求由三部分组成，分别是：请求行、消息报头、请求正文<br />\r\nHTTP响应由三部分组成，分别是：状态行、消息报头、响应正文</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('513', null, '<p>存储过程那这个技术有什么有点？</p>\r\n', '5', '4', '<p>存储过程的优点：<br />\r\n1存储过程只在创造时进行编译，以后每次执行存储过程都不需再重新编译，而一般SQL语句每执行一次就编译一次,所以使用存储过程可提高数据库执行速度。<br />\r\n2当对数据库进行复杂操作时(如对多个表进行Update,Insert,Query,Delete时），可将此复杂操作用存储过程封装起来与数据库提供的事务处理结合一起使用。<br />\r\n3存储过程可以重复使用,可减少数据库开发人员的工作量<br />\r\n4安全性高,可设定只有某此用户才具有对指定存储过程的使用权</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('514', null, '<p>如何用node监听80端口</p>\r\n', '5', '5', '<p>这题有陷阱！在类Unix系统中你不应该尝试去监听80端口，因为这需要超级用户权限。 因此不推荐让你的应用直接监听这个端口。<br />\r\n目前，如果一定要让应用监听80端口的话，你可以有通过在Node应用的前方再增加一层反向代理 （例如nginx）来实现。否则，建议你直接监听大于1024的端口</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('515', null, '<p>什么是事件循环</p>\r\n', '5', '4', '<p>Node采用的是单线程的处理机制（所有的I/O请求都采用非阻塞的工作方式），至少从Node.js开发者的角度是这样的。 而在底层，Node.js借助libuv来作为抽象封装层， 从而屏蔽不同操作系统的差异，Node可以借助livuv来来实现多线程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('516', null, '<p>请写一段PHP代码，确保多个进程同时写入同一个文件成功</p>\r\n', '5', '4', '<p>function writeData($path, $mode, $data){<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; $fp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = fopen($path, $mode);<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; $retries&nbsp;&nbsp;&nbsp;&nbsp; = 0;<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; $max_retries = 100;<br />\r\n&nbsp;&nbsp;&nbs', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('517', null, '<p>Linux下修改/usr/local目录下的文件file的权限为755，修改/home/th1下的所有文件的所有者和组为th1和ggv？</p>\r\n', '5', '4', '<p>chmod 755 /usr/local/file<br />\r\nchown -R th1:ggv /home/th1</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('518', null, '<p>php保存序列化对象到session中，并可以从session中获取序列化对象的值，用什么序列化函数？</p>\r\n', '5', '4', '<p>serialize()函数序列化对象; unserialize()函数还原序列化对象。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('519', null, '<p>php中的文件读写操作，读取文件test.txt中前300字节的内容</p>\r\n', '5', '4', '<p>$handle=fopen(&quot;test.txt&quot;,&quot;r&quot;);<br />\r\n$contents=fread($handle,300);<br />\r\nfclose($handle);</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('520', null, '<p>如何用PHP和MySQL上传视频</p>\r\n', '5', '4', '<p>可以在数据库中存放视频的地址，而不需要将真正的视频数据存在数据库中。可以将视频数据存放在服务器的指定文件夹下，上传的默认大小是2MB，但是我们也可以在php.ini文件中修改max_file size选项来改变。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('521', null, '<p>前端性能优化的方式有哪些</p>\r\n', '5', '4', '<p>1.减少DOM操作<br />\r\n2.部署前，图片压缩，代码压缩<br />\r\n3.优化JS代码结构，减少冗余代码<br />\r\n4.减少HTTP请求，合理设置HTTP缓存<br />\r\n5.使用内容分发CDN加速<br />\r\n6.静态资源缓存<br />\r\n7.图片延迟加载</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('522', null, '<p>一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）</p>\r\n', '5', '5', '<p>1.浏览器查找域名的 IP 地址<br />\r\n2.这一步包括 DNS 具体的查找过程，包括：浏览器缓存-&gt;系统缓存-&gt;路由器缓存&hellip;<br />\r\n3.浏览器向 web 服务器发送一个 HTTP 请求<br />\r\n4.服务器的永久重定向响应（从 http://example.com 到 http://www.example.com）<br />\r\n5.浏览器跟踪重定向地址<br />\r\n6.服务器处理请求<br />\r\n7.服务器返回一个 HTTP 响应<br />\r\n8.浏览器显示 HTML<br />\r\n9.浏览器发送请求获取嵌入在 HTML 中的资源（如图片、音频、视频、CSS、JS等等）<br />\r\n10.浏览器发送异步请求</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('523', null, '<p>js深度复制的方式</p>\r\n', '5', '5', '<p>1.使用jq的$.extend(true,&nbsp;target,&nbsp;obj)<br />\r\n2.newobj&nbsp;=&nbsp;Object.create(sourceObj)，// 但是这个是有个问题就是 newobj的更改不会影响到 sourceobj但是 sourceobj的更改会影响到newObj<br />\r\n3.newobj&nbsp;=&nbsp;JSON.parse(JSON.stringify(sourceObj))</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('524', null, '<p>解释一下rem</p>\r\n', '5', '1', '<p>em&nbsp;是相对于&nbsp;html&nbsp;元素的&nbsp;font-size&nbsp;的一个单位。如果&nbsp;html&nbsp;上定义了&nbsp;font-size:&nbsp;20px;，则无论在任何地方都是&nbsp;1rem&nbsp;=&nbsp;20px&nbsp;这个大小不会受到父元素的影响。<br />\r\n<br />\r\n我们统一使用rem对页面进行整体缩放。强烈建议大家对需要适应页面大小的任何元素都使用&nbsp;rem&nbsp;为单位来定义。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('525', null, '<p>position有几个值</p>\r\n', '5', '1', '<p>四个值</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('526', null, '<p>怎样使一个盒子垂直居中</p>\r\n', '5', '2', '<p>tatic<br />\r\n默认值。无特殊定位，对象遵循HTML定位规则（忽略&nbsp;top,&nbsp;bottom,&nbsp;left,&nbsp;right&nbsp;或者&nbsp;z-index&nbsp;声明）。<br />\r\nabsolute<br />\r\n将对象从文档流中拖出，使用&nbsp;left&nbsp;，&nbsp;right&nbsp;，&nbsp;top&nbsp;，&nbsp;bottom&nbsp;等属性相对于其最接近的一个最有定位设置的父对象进行绝对定位。如果不存在这样的父对象，则依据&nbsp;body对象。而其层叠通过z-index属性定义<br />\r\nfixed<br />\r\n未支持。对象定位遵从绝对(absolute)方式。但是要遵守一些规范<br />\r\nrelative<br />\r\n对象不可层叠，但将依据&nbsp;left&nbsp;，&nbsp;right&nbsp;，&nbsp;top&nbsp;，&nbsp;bottom&nbsp;等属性在正常文档流中偏移位置</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('527', null, '<p>css中权重顺序</p>\r\n', '5', '1', '<p>important&nbsp;&gt;&nbsp;内嵌样式&nbsp;&gt;&nbsp;ID&nbsp;&gt;&nbsp;类&nbsp;&gt;&nbsp;标签&nbsp;|&nbsp;伪类&nbsp;|&nbsp;属性选择&nbsp;&gt;&nbsp;伪对象&nbsp;&gt;&nbsp;继承&nbsp;&gt;&nbsp;通配符</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('528', null, '<p>opacity和rgba在ie下有什么区别</p>\r\n', '5', '1', '<p>CSS样式中，设置透明度的方式有两种。其一，opacity；其二rgba()。<br />\r\n<br />\r\nopacity和rgba()在一定程度上是没什么区别。<br />\r\n<br />\r\n但是，如果你只想给背景加上一个透明度，而背景上的字体获取其他元素保持不变的话，那么最好的办法就是用rgba()。因为opacity的透明度会传递给他的子元素，使得子元素也变得透明，看起来很不爽。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('529', null, '<p>行内元素的padding、margin是否无效？</p>\r\n', '5', '1', '<p>行内元素的padding-top、padding-bottom、margin-top、margin-bottom属性设置是无效的；<br />\r\n行内元素的padding-left、padding-right、margin-left、margin-bottom属性设置是有效的；<br />\r\n行内元素的padding-top、padding-bottom从显示的效果上是增加的，但其实设置的是无效的。并不会对他周围的元素产生任何影响。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('530', null, '<p>简单描述下微信小程序的相关文件类型?&nbsp;</p>\r\n', '5', '1', '<p>微信小程序项目结构主要有四个文件类型,如下&nbsp;<br />\r\n（1）、WXML&nbsp;(WeiXin&nbsp;Markup&nbsp;Language)是框架设计的一套标签语言，结合基础组&nbsp;件、事件系统，可以构建出页面的结构。内部主要是微信自己定义的一套组件。&nbsp;<br />\r\n（2）、WXSS&nbsp;(WeiXin&nbsp;Style&nbsp;Sheets)是一套样式语言，用于描述&nbsp;WXML&nbsp;的组件样式，&nbsp;二、js&nbsp;逻辑处理，网络请求 三、json&nbsp;小程序设置，如页面注册，页面标题及&nbsp;tabBar。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('531', null, '<p>你是怎么封装微信小程序的数据请求的?&nbsp;</p>\r\n', '5', '2', '<p>（1）、将所有的接口放在统一的&nbsp;js&nbsp;2）、在&nbsp;app.js&nbsp;中创建封装请求数据的方法&nbsp;三、在子页面中调用封装的方法请求数据文件中并导出&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('532', null, '<p>有哪些参数传值的方法?&nbsp;</p>\r\n', '5', '2', '<p>（1）、给&nbsp;HTML&nbsp;元素添加&nbsp;data-*属性来传递我们需要的值，然后通过&nbsp;e.currentTarget.dataset&nbsp;或&nbsp;onload&nbsp;的&nbsp;param&nbsp;参数获取。但&nbsp;data-名称不能有大写字母&nbsp;和不可以存放对象 二、设置&nbsp;id&nbsp;的方法标识来传值通过&nbsp;e.currentTarget.id&nbsp;获取设置的&nbsp;id&nbsp;的值,然后通过设置&nbsp;全局对象的方式来传递数值 三、在&nbsp;navigator&nbsp;中添加参数传值&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('533', null, '<p>你使用过哪些方法，来提高微信小程序的应用速度?&nbsp;</p>\r\n', '5', '2', '<p>&nbsp;一、提高页面加载速度&nbsp;二、用户行为预测&nbsp;三、减少默认&nbsp;data&nbsp;的大小&nbsp;四、组件化方案</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('534', null, '<p>小程序与原生&nbsp;App&nbsp;哪个好?</p>\r\n', '5', '2', '<p>小程序除了拥有公众号的低开发成本、低获客成本低以及无需下载等优势，在服务请&nbsp;求延时与用户使用体验是都得到了较大幅度&nbsp;的提升，使得其能够承载跟复杂的服务功能&nbsp;以及使用户获得更好的用户体验。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('535', null, '<p>简述微信小程序原理?&nbsp;</p>\r\n', '5', '2', '<p>微信小程序采用&nbsp;JavaScript、WXML、WXSS&nbsp;三种技术进行开发，从技术讲和现有的&nbsp;前端开发差不多，但深入挖掘的话却又有所不同。&nbsp;<br />\r\nJavaScript:首先&nbsp;JavaScript&nbsp;的代码是运行在微信&nbsp;App&nbsp;中的，并不是运行在浏览器中，因&nbsp;此一些&nbsp;H5&nbsp;技术的应用，需要微信&nbsp;App&nbsp;提供对应的&nbsp;API&nbsp;支持，而这限制住了&nbsp;H5&nbsp;技术的应&nbsp;用，且其不能称为严格的&nbsp;H5，可以称其为伪&nbsp;H5，同理，微信提供的独有的某些&nbsp;API，H5&nbsp;也不支持或支持的不是特别好。&nbsp;<br />\r\nWXML:WXML&nbsp;微信自己基于&nbsp;XML&nbsp;语法开发的，因此开发时，只能使用微信提供的现有&nbsp;<br />\r\n标签，HTML&nbsp;的标签是无法使用的。&nbsp;<br />\r\nWXSS:WXSS&nbsp;具有&nb', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('536', null, '<p>分析下微信小程序的优劣势?&nbsp;</p>\r\n', '5', '2', '<p>优势:&nbsp;<br />\r\n1、无需下载，通过搜索和扫一扫就可以打开。&nbsp;<br />\r\n2、良好的用户体验:打开速度快。&nbsp;<br />\r\n3、开发成本要比&nbsp;App&nbsp;要低。&nbsp;<br />\r\n4、安卓上可以添加到桌面，与原生&nbsp;App&nbsp;差不多。&nbsp;<br />\r\n5、为用户提供良好的安全保障。小程序的发布，微信拥有一套严格的审查流程，&nbsp;不能通&nbsp;过审查的小程序是无法发布到线上的。&nbsp;<br />\r\n劣势: 1、限制较多。页面大小不能超过&nbsp;1M。不能打开超过&nbsp;5&nbsp;个层级的页面。&nbsp;<br />\r\n2、样式单一。小程序的部分组件已经是成型的了，样式不可以修改。例如:幻灯片、导&nbsp;航。&nbsp;<br />\r\n3、推广面窄，不能分享朋友圈，只能通过分享给朋友，附近小程序推广。其中附近小程&nbsp;序也受到微信的限制。&nbsp;<br />\r\n4、依托于微信，无法开发后台管理功能。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('537', null, '<p>微信小程序与&nbsp;H5&nbsp;的区别?&nbsp;</p>\r\n', '5', '2', '<p>第一条是运行环境的不同&nbsp;<br />\r\n传统的&nbsp;HTML5&nbsp;的运行环境是浏览器，包括&nbsp;webview，而微信小程序的运行环境并非完整&nbsp;的浏览器，是微信开发团队基于浏览器内核完全重构的一个内置解析器，针对小程序专门&nbsp;做了优化，配合自己定义的开发语言标准，提升了小程序的性能。&nbsp;<br />\r\n第二条是开发成本的不同&nbsp;<br />\r\n只在微信中运行，所以不用再去顾虑浏览器兼容性，不用担心生产环境中出现不可预料的&nbsp;奇妙&nbsp;BUG&nbsp;<br />\r\n第三条是获取系统级权限的不同&nbsp;系统级权限都可以和微信小程序无缝衔接&nbsp;<br />\r\n第四条便是应用在生产环境的运行流畅度&nbsp;<br />\r\n长久以来，当&nbsp;HTML5&nbsp;应用面对复杂的业务逻辑或者丰富的页面交互时，它的体验总是不&nbsp;尽人意，需要不断的对项目优化来提升用户体验。但是由于微信小程序运行环境独立&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('538', null, '<p>怎么解决小程序的异步请求问题?&nbsp;</p>\r\n', '5', '2', '<p>9、怎么解决小程序的异步请求问题?&nbsp;<br />\r\n答:&nbsp;在回调函数中调用下一个组件的函数:&nbsp;<br />\r\napp.js&nbsp;<br />\r\nsuccess:&nbsp;function&nbsp;(info)&nbsp;{&nbsp;<br />\r\nthat.apirtnCallback(info)&nbsp;}&nbsp;<br />\r\nindex.js&nbsp;<br />\r\nonLoad:&nbsp;function&nbsp;()&nbsp;{&nbsp;app.apirtnCallback&nbsp;=&nbsp;res&nbsp;=&gt;&nbsp;{&nbsp;<br />\r\nconsole.log(res)&nbsp;}&nbsp;<br />\r\n}&nbsp;<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('539', null, '<p>小程序的双向绑定和&nbsp;vue&nbsp;哪里不一样?&nbsp;</p>\r\n', '5', '2', '<p>小程序直接&nbsp;this.data&nbsp;的属性是不可以同步到视图的，必须调用:&nbsp;this.setData({&nbsp;noBind:true&nbsp;<br />\r\n})</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('540', null, '<p>小程序的&nbsp;wxss&nbsp;和&nbsp;css&nbsp;有哪些不一样的地方?</p>\r\n', '5', '2', '<p>一、wxss&nbsp;的图片引入需使用外链地址;二、没有&nbsp;Body;样式可直接使用&nbsp;import&nbsp;导&nbsp;入</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('541', null, '<p>webview&nbsp;中的页面怎么跳回小程序中?&nbsp;</p>\r\n', '5', '5', '<p>首先要引入最新版的&nbsp;jweixin-1.3.2.js，然后&nbsp;<br />\r\nwx.miniProgram.navigateTo({&nbsp;<br />\r\nurl:&nbsp;&#39;/pages/login/login&#39;+&#39;$params&#39;&nbsp;})&nbsp;<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('543', null, '<p>小程序关联微信公众号如何确定用户的唯一性?</p>\r\n', '5', '2', '<p>使用&nbsp;wx.getUserInfo&nbsp;方法&nbsp;withCredentials&nbsp;为&nbsp;true&nbsp;时&nbsp;可获取&nbsp;encryptedData，里&nbsp;面有&nbsp;union_id。后端需要进行对称解密&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('544', null, '<p>如何实现下拉刷新?&nbsp;</p>\r\n', '5', '5', '<p>用&nbsp;view&nbsp;代替&nbsp;scroll-view,,设置&nbsp;onPullDownRefresh&nbsp;函数实现&nbsp;(责任编辑:admin)</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('545', null, '<p>你是怎么封装微信小程序的数据请求的?&nbsp;</p>\r\n', '5', '2', '<p>一、将所有的接口放在统一的&nbsp;js&nbsp;文件中并导出&nbsp;<br />\r\n二、在&nbsp;app.js&nbsp;中创建封装请求数据的方法&nbsp;三、在子页面中调用封装的方&nbsp;法请求数据&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('546', null, '<p>有哪些参数传值的方法?&nbsp;</p>\r\n', '5', '2', '<p>一、给&nbsp;HTML&nbsp;元素添加&nbsp;data-*属性来传递我们需要的值，然后通过&nbsp;e.currentTarget.dataset&nbsp;或&nbsp;onload&nbsp;的&nbsp;param&nbsp;参数获取。但&nbsp;data-名称不能&nbsp;有大写字母&nbsp;和不可以存放对象 二、设置&nbsp;id&nbsp;的方法标识来传值通过&nbsp;<br />\r\ne.currentTarget.id&nbsp;获取设置的&nbsp;id&nbsp;的值,然后通过设置&nbsp;全局对象的方式来&nbsp;传递数值 三、在&nbsp;navigator&nbsp;中添加参数传值&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('547', null, '<p>&nbsp;谈谈你对前端性能优化得理解</p>\r\n', '5', '2', '<p>a)要避免代码的深层级嵌套。因为层级越深的节点在初始化时更占内存。<br />\r\nb)诸如img、link、script等元素的src或href属性的值不为空，因为就算我们写为src=&quot;&quot;浏览器仍会发送http请求<br />\r\nc)在html文档开始就指定文档字符集，这样做的目的是在有助于浏览器加载时就能立即解析html代码</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('548', null, '<p>谈谈作为一个前端开发人员来讲，seo优化需要考虑什么</p>\r\n', '5', '2', '<p>a)做好404页面<br />\r\nb)目录结构不易过深，最好不超出三层&lsquo;<br />\r\nc)图片一定要加alt属性，便于引擎搜索</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('549', null, '<p>自定义指令(v-check、v-focus)的方法有哪些?它有哪些钩子函数?还有哪些钩子&nbsp;函数参数?&nbsp;</p>\r\n', '5', '2', '<p>全局定义指令:在&nbsp;vue&nbsp;对象的&nbsp;directive&nbsp;方法里面有两个参数，一个是指令名称，另外一&nbsp;个是函数。组件内定义指令:directives&nbsp;<br />\r\n钩子函数:bind(绑定事件触发)、inserted(节点插入的时候触发)、update(组件内相关更&nbsp;新)&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('550', null, '<p>说出至少&nbsp;4&nbsp;种&nbsp;vue&nbsp;当中的指令和它的用法?&nbsp;</p>\r\n', '5', '3', '<p>v-if:判断是否隐藏;v-for:数据循环出来;v-bind:class:绑定一个属性;v-mode&nbsp;<br />\r\n实现双向绑定&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('551', null, '<p>导航钩子有哪些?它们有哪些参数?&nbsp;</p>\r\n', '5', '3', '<p>导航钩子有:a/全局钩子和组件内独享的钩子。b/beforeRouteEnter、afterEnter、be&nbsp;foreRouterUpdate、beforeRouteLeave&nbsp;<br />\r\n参数:有&nbsp;to(去的那个路由)、from(离开的路由)、next(一定要用这个函数才能去到下&nbsp;一个路由，如果不用就拦截)最常用就这几种&nbsp;<br />\r\nrEnter、be&nbsp;foreRouterUpdate、beforeRouteLeave&nbsp;<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('552', null, '<p>请详细说下你对&nbsp;vue&nbsp;生命周期的理解?&nbsp;</p>\r\n', '5', '3', '<p>总共分为&nbsp;8&nbsp;个阶段创建前/后，载入前/后，更新前/后，销毁前/后。&nbsp;<br />\r\n创建前/后:&nbsp;在&nbsp;beforeCreated&nbsp;阶段，vue&nbsp;实例的挂载元素$el&nbsp;和数据对象&nbsp;data&nbsp;都为&nbsp;undefi&nbsp;ned，还未初始化。在&nbsp;created&nbsp;阶段，vue&nbsp;实例的数据对象&nbsp;data&nbsp;有了，$el&nbsp;还没有。&nbsp;<br />\r\n载入前/后:在&nbsp;beforeMount&nbsp;阶段，vue&nbsp;实例的$el&nbsp;和&nbsp;data&nbsp;都初始化了，但还是挂载之前为&nbsp;虚拟的&nbsp;dom&nbsp;节点，data.message&nbsp;还未替换。在&nbsp;mounted&nbsp;阶段，vue&nbsp;实例挂载完成，data.&nbsp;message&nbsp;成功渲染。&nbsp;<br />\r\n更新前/后:当&nbsp;data&nb', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('553', null, '<p>请说下封装&nbsp;vue&nbsp;组件的过程?</p>\r\n', '5', '3', '<p>首先，组件可以提升整个项目的开发效率。能够把页面抽象成多个相对独立的模块，解决&nbsp;<br />\r\n了我们传统项目开发:效率低、难维护、复用性等问题。&nbsp;<br />\r\n然后，使用&nbsp;Vue.extend&nbsp;方法创建一个组件，然后使用&nbsp;Vue.component&nbsp;方法注册组件。子组&nbsp;件需要数据，可以在&nbsp;props&nbsp;中接受定义。而子组件修改好数据后，想把数据传递给父组件。可&nbsp;以采用&nbsp;emit&nbsp;方法。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('554', null, '<p>你是怎么认识&nbsp;vuex&nbsp;的?</p>\r\n', '5', '3', '<p>vuex&nbsp;可以理解为一种开发模式或框架。比如&nbsp;PHP&nbsp;有&nbsp;thinkphp，java&nbsp;有&nbsp;spring&nbsp;等。&nbsp;<br />\r\n通过状态(数据源)集中管理驱动组件的变化(好比&nbsp;spring&nbsp;的&nbsp;IOC&nbsp;容器对&nbsp;bean&nbsp;进行集中管&nbsp;理)。&nbsp;<br />\r\n应用级的状态集中放在&nbsp;store&nbsp;中;&nbsp;改变状态的方式是提交&nbsp;mutations，这是个同步的事物;&nbsp;异步逻辑应该封装在&nbsp;action&nbsp;中。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('555', null, '<p>聊聊你对&nbsp;Vue.js&nbsp;的&nbsp;template&nbsp;编译的理解?&nbsp;</p>\r\n', '5', '3', '<p>简而言之，就是先转化成&nbsp;AST&nbsp;树，再得到的&nbsp;render&nbsp;函数返回&nbsp;VNode(Vue&nbsp;的虚拟&nbsp;DO&nbsp;M&nbsp;节点)&nbsp;<br />\r\n详情步骤:&nbsp;<br />\r\n首先，通过&nbsp;compile&nbsp;编译器把&nbsp;template&nbsp;编译成&nbsp;AST&nbsp;语法树(abstract&nbsp;syntax&nbsp;tree&nbsp;即&nbsp;源&nbsp;代码的抽象语法结构的树状表现形式)，compile&nbsp;是&nbsp;createCompiler&nbsp;的返回值，createCo&nbsp;mpiler&nbsp;是用以创建编译器的。另外&nbsp;compile&nbsp;还负责合并&nbsp;option。&nbsp;<br />\r\n然后，AST&nbsp;会经过&nbsp;generate(将&nbsp;AST&nbsp;语法树转化成&nbsp;render&nbsp;funtion&nbsp;字符串的过程)', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('556', null, '<p>使用过&nbsp;element.ui&nbsp;吗?说下它其中两个组件的使用方法?</p>\r\n', '5', '3', '<p>使用过用过一个布局的，它是由&nbsp;24&nbsp;份，它的写法是:span&nbsp;后面带的数字它占&nbsp;24&nbsp;份里面&nbsp;的宽度。:offset&nbsp;是它&nbsp;<br />\r\n的间距，后面也是跟数字，也是从&nbsp;24&nbsp;份里面取的。 input&nbsp;按钮，标签是&nbsp;el-input，后面&nbsp;type&nbsp;跟上一个属性就是显示不同按钮的类型，有默认的&nbsp;<br />\r\ndefault&nbsp;(默认的)、success(成功的)、warning(警告)、danger(危险)、info()、primar&nbsp;<br />\r\ny() </p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('557', null, '<p>说出你所使用过的&nbsp;vue&nbsp;指令</p>\r\n', '5', '3', '<p>第一点、可以通用 &nbsp; &nbsp; 第二点、代码尽量简洁&nbsp;<br />\r\n第三点、容易修改&nbsp; &nbsp; 第四点、功能要多一点&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('558', null, '<p>vuex&nbsp;有哪几种属性?&nbsp;</p>\r\n', '5', '3', '<p>有五种，分别是&nbsp;State、&nbsp;Getter、Mutation&nbsp;、Action、&nbsp;Module&nbsp;<br />\r\n<br />\r\n&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('559', null, '<p>vuex&nbsp;的&nbsp;State&nbsp;特性是?</p>\r\n', '5', '3', '<p>一、Vuex&nbsp;就是一个仓库，仓库里面放了很多对象。其中&nbsp;state&nbsp;就是数据源存放地，对应于与&nbsp;一般&nbsp;Vue&nbsp;对象里面的&nbsp;data&nbsp;<br />\r\n二、state&nbsp;里面存放的数据是响应式的，Vue&nbsp;组件从&nbsp;store&nbsp;中读取数据，若是&nbsp;store&nbsp;中的数据&nbsp;发生改变，依赖这个数据的组件也会发生更新&nbsp;<br />\r\n三、它通过&nbsp;mapState&nbsp;把全局的&nbsp;state&nbsp;和&nbsp;getters&nbsp;映射到当前组件的&nbsp;computed&nbsp;计算属性&nbsp;中&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('560', null, '<p>vuex&nbsp;的&nbsp;Getter&nbsp;特性是? </p>\r\n', '5', '3', '<p> 一、getters&nbsp;可以对&nbsp;State&nbsp;进行计算操作，它就是&nbsp;Store&nbsp;的计算属性 二、&nbsp;虽然在组件内也可以做计算属性，但是&nbsp;getters&nbsp;可以在多组件之间复用&nbsp;三、&nbsp;如果一个状态只在一个组件内使用，是可以不用&nbsp;getters 4、vuex&nbsp;的&nbsp;Mutation&nbsp;特性是? 答: 一、Action&nbsp;类似于&nbsp;mutation，不同在于:&nbsp;<br />\r\n二、Action&nbsp;提交的是&nbsp;mutation，而不是直接变更状态。&nbsp;<br />\r\n三、Action&nbsp;可以包含任意异步操作&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('561', null, '<p>不用&nbsp;Vuex&nbsp;会带来什么问题?&nbsp;</p>\r\n', '5', '3', '<p>一、可维护性会下降，你要想修改数据，你得维护三个地方&nbsp;<br />\r\n二、可读性会下降，因为一个组件里的数据，你根本就看不出来是从哪来的&nbsp;<br />\r\n三、增加耦合，大量的上传派发，会让耦合性大大的增加，本来&nbsp;Vue&nbsp;用&nbsp;Component&nbsp;就是为&nbsp;了减少耦合，现在这么用，和组件化的初衷相背。&nbsp;<br />\r\n生命周期 1、什么是&nbsp;vue&nbsp;生命周期?&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('562', null, '<p>vue&nbsp;生命周期的作用是什么?&nbsp;</p>\r\n', '5', '3', '<p>它的生命周期中有多个事件钩子，让我们在控制整个&nbsp;Vue&nbsp;实例的过程时更容易形成好的逻&nbsp;辑。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('563', null, '<p>第一次页面加载会触发哪几个钩子</p>\r\n', '5', '3', '<p>第一次页面加载时会触发&nbsp;<strong>beforeCreate,&nbsp;created,&nbsp;beforeMount,&nbsp;mounted&nbsp;</strong>这几个钩&nbsp;子</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('564', null, '<p>axios&nbsp;的特点有哪些?&nbsp;</p>\r\n', '5', '3', '<p>一、Axios&nbsp;是一个基于&nbsp;promise&nbsp;的&nbsp;HTTP&nbsp;库，支持&nbsp;promise&nbsp;所有的&nbsp;API&nbsp;二、它可以拦截请求和响应&nbsp;三、它可以转换请求数据和响应数据，并对响应回来的内容自动转换成&nbsp;JSON&nbsp;类型的数据&nbsp;四、安全性更高，客户端支持防御&nbsp;XSRF&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('565', null, '<p>axios&nbsp;有哪些常用方法?</p>\r\n', '5', '3', '<p>一、axios.get(url[,&nbsp;config])&nbsp;//get&nbsp;请求用于列表和信息查询&nbsp;<br />\r\n二、axios.delete(url[,&nbsp;config])&nbsp;//删除 <br />\r\n三、axios.post(url[,&nbsp;data[,&nbsp;config]])&nbsp;//post&nbsp;请求用于信息的添加&nbsp;<br />\r\n四、axios.put(url[,&nbsp;data[,&nbsp;config]])&nbsp;//更新操作&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('567', null, '<p>谈谈以前端角度出发做好&nbsp;SEO&nbsp;需要考虑什么?&nbsp;</p>\r\n', '5', '3', '<p>主要包括主题(Title),网站描述(Description),和关键词(Keywords).其他还有&nbsp;Author(作者),Category(目录),Language(编码语种)等.&nbsp;放置关键词&nbsp;<br />\r\n关键词分析和选择是&nbsp;SEO&nbsp;最重要的工作之一.首先要给网站确定主关键词(一般在&nbsp;5&nbsp;个上下),然后针对这些关键词进行优化,包括&nbsp;关键词密度(Density),相关度(Relavancy),突出性(Prominency)等等.&nbsp;<br />\r\n的搜索引擎&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('568', null, '<p>简介盒子模型</p>\r\n', '5', '2', '<p>CSS&nbsp;的盒子模型有两种:IE&nbsp;盒子模型、标准的&nbsp;W3C&nbsp;盒子模型模型.&nbsp;内容(content)、填充(padding)、边框(border)、边界(margin)都是盒模型的基本属性.&nbsp;<br />\r\n区别: 标准的&nbsp;W3C&nbsp;盒子模型模型:&nbsp;设置的&nbsp;border&nbsp;值只包括&nbsp;content&nbsp;和&nbsp;padding.&nbsp;IE&nbsp;盒子模型:设置的&nbsp;border&nbsp;值包括&nbsp;content,padding&nbsp;和&nbsp;border&nbsp;值.&nbsp;<br />\r\nCSS&nbsp;的盒子模型有两种:IE&nbsp;盒子模型、标准的&nbsp;W3C&nbsp;盒子模型模型.&nbsp;内容(content)、填充(padding)、边框(border)、边界(margin)都是盒模型的基本属性.&nbsp;<br />\r\n区别: 标准的&nbsp;W3C&nbsp;盒子模型模型:&nbsp', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('569', null, '<p>如何垂直居中一个浮动元素?&nbsp;</p>\r\n', '5', '2', '<p>1.已知浮动元素的宽高设定父元素为相对定位,浮动元素为绝对定位&nbsp;top&nbsp;和&nbsp;left&nbsp;为&nbsp;50%,再设置浮动元素的&nbsp;margin-left/top&nbsp;值为浮动元素宽高一半的负值.&nbsp;<br />\r\n2.不知道浮动元素的宽高设定父元素为相对定位,浮动元素为绝对定位.且&nbsp;left/right/top/bottom&nbsp;设置为&nbsp;0,再给浮动元素设置&nbsp;margin&nbsp;auto.&nbsp;<br />\r\n另:如何居中&nbsp;div?&nbsp;答:默认&nbsp;div&nbsp;有宽度,设置&nbsp;margin:0&nbsp;auto; </p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('570', null, '<p>Sass、LESS&nbsp;是什么?大家为什么要使用他们?</p>\r\n', '5', '2', '<p>CSS&nbsp;预处理器是一种语言用来为&nbsp;CSS&nbsp;增加一些编程的的特性,无需考虑浏览器的兼容性问题,例如你可以在&nbsp;CSS&nbsp;中使用变量、&nbsp;简单的程序逻辑、函数等等在编程语言中的一些基本技巧,可以让你的&nbsp;CSS&nbsp;更见简洁,适应性更强,代码更直观等诸多好处.SASS、&nbsp;LESS&nbsp;是最常见的&nbsp;&nbsp;.&nbsp;<br />\r\nLess&nbsp;是一种&nbsp;&nbsp;.将&nbsp;CSS&nbsp;赋予了动态语言的特性,如变量,继承,运算,&nbsp;函数.&nbsp;LESS&nbsp;既可以在客户端上运行&nbsp;(支持&nbsp;IE&nbsp;6+,&nbsp;Webkit,&nbsp;Firefox),也可一在服务端运行(借助&nbsp;Node.js).&nbsp;<br />\r\n优点: 结构清晰,便于扩展.&nbsp;<br />\r\n可以方便地屏蔽浏览器私有语法差异.这个不用多说,封装对浏览器语法差异的重复处理, 减少无意义的机械劳动. 可以轻松实现多重', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('571', null, '<p>语义化的理解?</p>\r\n', '5', '2', '<p>1、利于&nbsp;SEO,搜索引擎的爬虫依赖于标记来确定上下文和各个关键字的权重,&nbsp;页面是否对爬虫容易理解非常重要,因为爬虫&nbsp;很大程度上会忽略用于表现的标记,而只注重语义标记&nbsp;<br />\r\n2、让页面的内容结构化,便于各种终端根据其自身的条件来合适地显示页面,虽然部分&nbsp;HTML&nbsp;标签存在默认样式,甚至浏览&nbsp;器都各有默认样式,这种表现虽然不是语义化&nbsp;HTML&nbsp;结构的有点,但同样是为了更好的表达&nbsp;HTML&nbsp;语义&nbsp;<br />\r\n3、便于维护,方便阅读源码,&nbsp;去掉或样式丢失的时候能让页面呈现清晰的结构&nbsp;<br />\r\n4、便于团队开发和维护,W3C&nbsp;给我们定了一个很好的标准,在团队中大家都遵循这个标准,可以减少很多差异化的东西,方便&nbsp;开发和维护,提高开发效率,甚至实现模块化开发&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('572', null, '<p>什么是响应式设计?&nbsp;</p>\r\n', '5', '2', '<p>网页制作的过程中让不同的设备有不同的尺寸和不同的功能.包括弹性网格和布局、图片、CSS&nbsp;media&nbsp;query&nbsp;媒体查询的&nbsp;使用等.响应式网页设计就是一个网站能够兼容多个终端,而不必多次开发.&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('573', null, '<p>TP框架的架构是怎么样的</p>\r\n', '5', '5', '<p>ThinkPHP的架构： 是 核心 + 行为 + 驱动，TP官方简称为：CBD<br />\r\n核心（Core）：就是框架的核心代码，不可缺少的东西，TP本身是基于MVC思想开发的框架。<br />\r\n行为（Behavior） ：行为在新版ThinkPHP的架构里面起着举足轻重的作用，在系统核心之上，设置了很多标签扩展位，而每个标签位置可以依次执行各自的独立行为。行为扩展就因此而诞生了，而且很多系统功能也是通过内置的行为扩展完成的，所有行为扩展都是可替换和增加的，由此形成了底层框架可组装的基础。<br />\r\n驱动（ Driver ）：数据库驱动、缓存驱动、标签库驱动和模板引擎驱动，以及外置的类扩展。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('574', null, '<p>factory、service 和 provider 是什么关系</p>\r\n', '5', '5', '<p>从底层实现上来看，service 调用了 factory，返回其实例；factory 调用了 provider，返回其&nbsp;$get&nbsp;中定义的内容。factory 和 service 功能类似，只不过 factory 是普通 function，可以返回任何东西；service 是构造器，可以不返回（绑定到 this 的都可以被访问）；provider 是加强版 factory，返回一个可配置的 factory。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('576', null, '<p>说说多线程？</p>\r\n', '5', '2', '<p>使用threading这个高级模块，启动一个线程就是把一个函数传入并创建Thread实例，然后调用start()开始执行多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，因此，线程之间共享数据最大的危险在于多个线程同时改一个变量把内容给改乱了。锁的好处就是确保了某段关键代码只能由一个线程从头到尾完整地执行，坏处当然也很多首先是阻止了多线程并发执行，包含锁的某段代码实际上只能以单线程模式执行，效率就大大地下降了。其次，由于可以存在多个锁，不同的线程持有不同的锁，并试图获取对方持有的锁时，可能会造成死锁，导致多个线程全部挂起，既不能执行，也无法结束，只能靠操作系统强制终止。多线程编程，模型复杂，容易发生冲突，必须用锁加以隔离，同时，又要小心死锁的发生。Python解释器由于设计时有GIL全局锁，导致了多线程无法利用多核。多线程的并发在Python中就是一个美丽的梦。Python的线程虽然是真正的线程，但解释器执行代码时，有一个GIL锁：Global&nbsp;', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('577', null, '<p>Python线程和进程的区别？</p>\r\n', '5', '2', '<p>1)调度：线程作为调度和分配的基本单位，进程作为拥有资源的基本单位。&nbsp;<br />\r\n2)并发性：不仅进程之间可以并发执行，同一个进程的多个线程之间也可并发执行。&nbsp;<br />\r\n3）拥有资源：进程是拥有资源的一个独立单位，线程不拥有系统资源，但可以访问隶属于进程的资<br />\r\n源.&nbsp;<br />\r\n4）系统开销：在创建或撤消进程时，由于系统都要为之分配和回收资源，导致系统的开销明显大于<br />\r\n创建或撤消线程时的开销。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('578', null, '<p>函数参数的传递？</p>\r\n\r\n<p>def add（a，s_list=[]）:</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; s_list.append(a) &nbsp; &nbsp;</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;return s_list &', '5', '2', '<p>[1],[1,2],[1,2,3]</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('579', null, '<p>Python关键字yield的用法？</p>\r\n', '5', '3', '<p>yield&nbsp;就是保存当前程序执行状态。你用&nbsp;for&nbsp;循环的时候，每次取一个元素的时候就会计算一次。用&nbsp;yield&nbsp;的函数<br />\r\n叫generator，和&nbsp;iterator一样，它的好处是不用一次计算所有元素，而是用一次算一次，可以节省很多空间。generator<br />\r\n每次计算需要上一次计算结果，所以用yield，否则一return，上次计算结果就没了。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('580', null, '<p>这两个参数什么意思&nbsp;*args&nbsp;**kwargs，我们为什么要使用他们？</p>\r\n', '5', '2', '<p>缺省参数指在调用函数的时候没有传入参数的情况下，调用默认的参数，在调用函数的同时赋值时，<br />\r\n所传入的参数会替代默认参数。&nbsp;<br />\r\n*args&nbsp;是不定长参数，他可以表示输入参数是不确定的，可以是任意多个。&nbsp;<br />\r\n**kwargs&nbsp;是关键字参数，赋值的时候是以键&nbsp;=&nbsp;值的方式，参数是可以任意多对在定义函数的时候<br />\r\n不确定会有多少参数会传入时，就可以使用两个参数。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('581', null, '<p>描述下SOAP的交互流程</p>\r\n', '5', '3', '<p>SOAP(简&nbsp;单&nbsp;对&nbsp;象&nbsp;访&nbsp;问&nbsp;协&nbsp;议)：SOAP是&nbsp;使&nbsp;用XML通&nbsp;过Internet发送信息和访问动态Web服务的友好界面。其主要作用在于确保信息通过互联网在业务应用之间传输的可靠性。作为一种用在分布式环境中交换结构化数据的协议，它包括三个部分：信封、报头(可选)和协议消息体。信封标记SOAP消息的开始与结束。它还可以规定在网络上数据的编码规则。SOAP报头可以包含发送给一个地址或多个地址的邮件、一个支付代码或有关RPC类型互动的信息。一个信封中可以有多个报头或完全没有报头。SOAP消息体传送自描述结构或RPC类型接口格式的数据。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('582', null, '<p>如何在一个function里面设置一个全局的变量</p>\r\n', '5', '1', '<p>如果要给全局变量在一个函数里赋值，&nbsp;必须使用global语句。global&nbsp;VarName的表达式会告诉Python，VarName是一个全局变量，&nbsp;这样Python就不会在局部命名空间里寻找这个变量</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('583', null, '<p>&nbsp;Python的传参是传值还是传址</p>\r\n', '5', '3', '<p>Python的参数传递有：&nbsp;位置参数、&nbsp;默认参数、&nbsp;可变参数、&nbsp;关键字参数&nbsp;函数的传值到底是值传递还是引用传递，&nbsp;要分情况：&nbsp;不可变参数用值传递：&nbsp;像整数和字符串这样的不可变对象，&nbsp;是通过拷贝进行传递的，&nbsp;因为你无论如何都不可能在原处改变不可变对象&nbsp;可变参数是引用传递的：&nbsp;比如像列表，&nbsp;字典这样的对象是通过引用传递、&nbsp;和C语言里面的用指针传递数组很相似，&nbsp;可变对象能在函数内部改变</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('584', null, '<p>用Python&nbsp;re模块匹配HTML&nbsp;tag的时候，&lt;.*&gt;和&lt;.*?&gt;有什么区别</p>\r\n', '5', '2', '<p>&lt;.*&gt;这种匹配称作贪心匹配&lt;.*?&gt;称作非贪心匹配第一种写法是，尽可能多的匹配，就是匹配到的字符串尽量长，第二中写法是尽可能少的匹配，就是匹配到的字符串尽量短。比如&lt;tag&gt;tag&gt;tag&gt;end，第一个会匹配&lt;tag&gt;tag&gt;tag&gt;,第二个会匹配&lt;tag&gt;,如果要匹配到二个&gt;，就只能自己写</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('585', null, '<p>如何避免python中模块间的循环引用</p>\r\n', '5', '3', '<p>解决循环import的方法主要有几种。<br />\r\n1.延迟导入(lazy&nbsp;import)<br />\r\n即把import语句写在方法或函数里面，将它的作用域限制在局部。<br />\r\n这种方法的缺点就是会有性能问题。<br />\r\n<br />\r\n2.将from&nbsp;xxx&nbsp;import&nbsp;yyy改成import&nbsp;xxx;xxx.yyy来访问的形式<br />\r\n<br />\r\n3.组织代码<br />\r\n出现循环import的问题往往意味着代码的布局有问题。<br />\r\n可以合并或者分离竞争资源。<br />\r\n合并的话就是都写到一个文件里面去。<br />\r\n分离的话就是把需要import的资源提取到一个第三方文件去。<br />\r\n总之就是将循环变成单向。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('586', null, '<p>简述HTTP缓存机制</p>\r\n', '5', '3', '<p>在客户端第一次请求数据时，此时缓存数据库中没有对应的缓存数据，需要请求服务器，服务器返回后，将数据存储至缓存数据库中。<br />\r\n对于强制缓存，服务器通知浏览器一个缓存时间，在缓存时间内，下次请求，直接用缓存，不在时间内，执行比较缓存策略。<br />\r\n对于比较缓存，将缓存信息中的Etag和Last-Modified通过请求发送给服务器，由服务器校验，返回304状态码时，浏览器直接使用缓存。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('587', null, '<p>说说你对TCP&nbsp;IP协议的理解</p>\r\n', '5', '1', '<p>TCP/IP（Transmission&nbsp;Control&nbsp;Protocol/Internet&nbsp;Protocol）协议是传输层协议，主要解决数据如何在网络中传输。HTTP是应用层协议，主要解决如何包装数据。IP协议对应于网络层。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('588', null, '<p>Python内存管理机制</p>\r\n', '5', '5', '<p>引用计数机制<br />\r\n垃圾回收机制<br />\r\n内存池机制</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('589', null, '<p>Python线程和进程的区别</p>\r\n', '5', '2', '<p>1)调度：线程作为调度和分配的基本单位，进程作为拥有资源的基本单位。&nbsp;<br />\r\n2)并发性：不仅进程之间可以并发执行，同一个进程的多个线程之间也可并发执行。&nbsp;<br />\r\n3）拥有资源：进程是拥有资源的一个独立单位，线程不拥有系统资源，但可以访问隶属于进程的资<br />\r\n源.&nbsp;<br />\r\n4）系统开销：在创建或撤消进程时，由于系统都要为之分配和回收资源，导致系统的开销明显大于<br />\r\n创建或撤消线程时的开销。&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('590', null, '<p>如何保证线程安全？</p>\r\n', '5', '1', '<p>通常加锁也有2种不同的粒度的锁：&nbsp;&nbsp;<br />\r\n1.&nbsp;fine-grained(细粒度)，程序员需要自行加/解锁来保证线程安全&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />\r\n2.&nbsp;coars', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('591', null, '<p>Python里面match()和search()的区别？&nbsp;</p>\r\n', '5', '1', '<p>re模块中match(pattern,string[,flags]),检查string的开头是否与pattern匹配。&nbsp;<br />\r\nre模块中research(pattern,string[,flags]),在string搜索pattern的第一个匹配值。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('592', null, '<p>一个包里有三个模块，mod1.py,&nbsp;mod2.py,&nbsp;mod3.py，但使用from&nbsp;demopack&nbsp;import&nbsp;*导入模块时，如何保证只有mod1、mod3被导入了</p>\r\n', '5', '2', '<p>增加__init__.py文件，并在文件中增加：__all__&nbsp;=&nbsp;[&#39;mod1&#39;,&#39;mod3&#39;]</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('593', null, '<p>__new__和__init__的区别？</p>\r\n', '5', '2', '<p>__new__是一个静态方法,</p>\r\n\r\n<p>而__init__是一个实例方法.</p>\r\n\r\n<p>__new__方法会返回一个创建的实例, 而__init__什么都不返回.</p>\r\n\r\n<p>只有在__new__返回一个cls的实例时后面的__init__才能被调用.</p>\r\n\r\n<p>当创建一个新实例时调用__new__,初始化一个实例时用__init__</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('594', null, '<p>print(dir(&lsquo;a&rsquo;))输出的是什么？</p>\r\n', '5', '2', '<p>会打印出字符型的所有的内置方法[&#39;__add__&#39;,&nbsp;&#39;__class__&#39;,&nbsp;&#39;__contains__&#39;,&nbsp;&#39;__delattr__&#39;,&nbsp;&#39;__doc__&#39;,&nbsp;&#39;__eq__&#39;,&nbsp;&#39;__format__&#39;,&nbsp;&#39;__ge__&#39;,&nbsp;&#39;__getattribute__&#39;,&nbsp;&#39;__getitem__&#39;,&nbsp;&#39;__getnewargs__&#39;,&nbsp;&#39;__getslice__&#39;,&nbsp;&#39;__gt__&#39;,&nbsp;&#39;__hash__&#39;,&nbsp;&#39;__init__&#39;,&nbsp;&#39;__le__&#39;,&nbsp;&#39;__len__&#39;,&nbsp;&#39;__lt__&#39;,&nbsp;&#39;__mod__&', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('595', null, '<p>如何在一个多级目录下,找出所有包含有&rsquo;abc&rsquo;字符的文件</p>\r\n', '5', '1', '<p>grep&nbsp;&lsquo;abc&rsquo;&nbsp;./*</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('596', null, '<p>如何抓取ping包</p>\r\n', '5', '4', '<p>tcpdump&nbsp;-i&nbsp;eth0&nbsp;-nn&nbsp;&#39;icmp&#39;&nbsp;&nbsp;&nbsp;ping命令使用的是icmp协议</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('597', null, '<p>&nbsp;假设&nbsp;a=(1,2,3)&nbsp;&nbsp;改变a的值变为(3,2,3)</p>\r\n', '5', '1', '<p>a = tuple([3] + list(a[1:]))</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('598', null, '<p>域名和IP之间有什么关系，如何查看某个域名对应的所有IP？</p>\r\n', '5', '3', '<p>输入域名----域名&nbsp;解析服务器（dns）解析成ip地址---访问IP地址---完成访问的内容---返回信息国际互联网(Internet)上有成千百万台主机（host），为了区分这些主机，人们给每台主机都分配了一个专门的&ldquo;地址&rdquo;作为标识，称为IP地址由于IP地址全是些的数字，为了便于用户记忆，Internet上引进了域名服务系统DNS（DomainName&nbsp;System）。当您键入某个域名的时候，这个信息首先到达提供此域名解析的服务器上，再将此域名解析为相应网站的IP地址。完成这一任务的过程就称为域名解析。1.ping&nbsp;&nbsp;2.nslookup&nbsp;3.使用站长工具等</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('599', null, '<p>Python的内存管理机制</p>\r\n', '5', '4', '<p>1.引用计数：通过引用计数来保持对内存中的变量跟踪，Python内部记录中所有在使用对象各有多少个引用。Python中有个内部跟踪变量叫做引用计数器，每个变量有多少个引用，简称引用计数。当对象被创建时就创建了一个引用计数。当某个对象的引用计数为0时，对象就不在需要，就列入了垃圾回收队列。引用计数增加：1.对象被创建：x=4;2.另外的别人被创建：y=x;3.被作为参数传递给函数：foo(x);4.作为容器对象的一个元素：a=[1,x,&#39;33&#39;];引用计数减少时：1.一个本地引用离开了它的作用域。比如上面的foo(x)函数结束时，x指向的对象引用减1;2.对象的别名被显式的销毁：delx；或者del&nbsp;y;&nbsp;3.对象的一个别名被赋值给其他对象：x=7894.对象从一个窗口对象中移除：myList.remove(x)5.窗口对象本身被销毁delmyList，或者窗口对象本身离开了作用域。2.垃圾回收1.引用计数：&nbsp;每个对象中都有ob-refcnt来做引用计数。当一个对象...,ob-refcnt就会增加，当引用的对象删除，那么ob-refc', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('600', null, '<p>分别阐述三种引号用的场景与区别</p>\r\n', '5', '2', '<p>单引号，双引号，三引号都可以表示字符串，双引号可以和单引号嵌套使用，三引号一般表示多行字符串或者注释，三引号可以嵌套双引号和单引号</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('601', null, '<p>sockets（套接字）编程有三种，哪三种？</p>\r\n', '5', '3', '<p>套接字有三种类型:流式套接字(SOCK_STREAM),数据报套接字(SOCK_DGRAM)及原始套接字。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('602', null, '<p>python多线程</p>\r\n', '5', '2', '<p>这个问题被问的概率相当之大，其实多线程，多进程，在实际开发中用到的很少，除非是那些对项&nbsp;目性能要求特别高的，有的开发工作几年了，也确实没用过，你可以这么回答，给他扯扯什么是进程，&nbsp;线程(cpython&nbsp;中是伪多线程)的概念就行，实在不行你就说你之前写过下载文件时，用过多线程技术，&nbsp;或者业余时间用过多线程写爬虫，提升效率。<br />\r\n&nbsp;&nbsp;进程:一个运行的程序(代码)就是一个进程，没有运行的代码叫程序，进程是系统资源分配的最<br />\r\n小单位，进程拥有自己独立的内存空间，所以进程间数据不共享，开销大。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('603', null, '<p>python多线程与多进程的区别</p>\r\n', '5', '2', '<p>进程:一个运行的程序(代码)就是一个进程，没有运行的代码叫程序，进程是系统资源分配的最<br />\r\n小单位，进程拥有自己独立的内存空间，所以进程间数据不共享，开销大。<br />\r\n线程:&nbsp;调度执行的最小单位，也叫执行路径，不能独立存在，依赖进程存在一个进程至少有一个&nbsp;线程，叫主线程，而多个线程共享内存(数据共享，共享全局变量)，从而极大地提高了程序的运行效率</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('604', null, '<p>进程间的数据共享和线程间的数据共享</p>\r\n', '5', '2', '<p>进程间数据共享:<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;多进程中，每个进程都是独立的，各自持有一份数据，无法共享。本篇文章介绍三种用于进程<br />\r\n数据共享的方法Queue:<br />\r\n&nbsp;1.&nbsp;from&nbsp;multiprocessing&nbsp;import&nbsp;queues&nbsp;2.&nbsp;import&nbsp;multiprocessing<br />\r\n3<br />\r\n4.&nbsp;def&nbsp;func(i,&nbsp;q):<br />\r\n5.&nbsp;q.put(i)<br />\r\n6.&nbsp;print(&quot;---&gt;&quot;,&nbsp;i,&nbsp;q.qsize())<br />\r\n7.<br />\r\n8.<br />\r\n9.&nbsp;q&nbsp;=&nbsp;queues.Queue(9,&nbsp;ctx=multiprocessing)&nbsp;10.&nbsp;for&nbsp;i&nbsp;in&nbsp;range(5):<br ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('605', null, '<p>列举几项python2和3的区别？</p>\r\n', '5', '3', '<p>&gt;&nbsp;1.&nbsp;print不再是语句，而是函数，比如原来是&nbsp;print&nbsp;&#39;abc&#39;&nbsp;现在是&nbsp;print(&#39;abc&#39;)<br />\r\n但是&nbsp;python2.6+&nbsp;可以使用&nbsp;from&nbsp;__future__&nbsp;import&nbsp;print_function&nbsp;来实现相同功能<br />\r\n&gt;&nbsp;2.&nbsp;在Python&nbsp;3中，没有旧式类，只有新式类，也就是说不用再像这样&nbsp;class&nbsp;Foobar(object):&nbsp;pass&nbsp;显式地子类化object<br />\r\n但是最好还是加上.&nbsp;主要区别在于&nbsp;old-style&nbsp;是&nbsp;classtype&nbsp;类型而&nbsp;new-style&nbsp;是&nbsp;type类型<br />\r\n&gt;&nbsp;3.&nbsp;原来1/2（两个整数相除）结果是0，现在是0.5了<b', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('606', null, '<p>什么是闭包？</p>\r\n', '5', '1', '<p>在函数内部再定义一个函数，并且这个函数用到了外边函数的变量，那么将这个函数以及用到的一些变量称之为闭包</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('607', null, '<p>python的内存管理机制？</p>\r\n', '5', '2', '<p>采用引用计数为主，标记清除、分代回收机制为辅</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('608', null, '<p>同步异步阻塞非阻塞的了解具体说说？</p>\r\n', '5', '2', '<p>异步：某个事情需要10s完成。而我只需要调用某个函数告诉xxx来帮我做（然后我再干其他的事情）<br />\r\n同步：某个事情需要10s完成，我需要一直等它完成（等10s），再能继续后面的工作。<br />\r\n阻塞：做某件事情，直到完成，除非超时<br />\r\n非阻塞：尝试做，如果不能做，就不做（直接返回），如果能做，就做。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('609', null, '<p>用一行代码python 写出1+2+3+4+&hellip;&hellip;10348？</p>\r\n', '5', '2', '<p>print(sum(range(1,10349)))</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('610', null, '<p>使用装饰器实现单例模式？</p>\r\n', '5', '3', '<p>class fun_1(object):<br />\r\n&nbsp; &nbsp; def __init__(self, cls):<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; self._cls = cls<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; self._instances = None;</p>\r\n\r\n<p>&nbsp; &nbsp; def __call__(self, *args):<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; if not self._instances:<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; self._instances = self._cls(*args)<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; return self._instances<br />\r\n@fun_1<br />\r\nclass fun_2(object):<br />\r\n&nbsp; &nbsp; def _', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('611', null, '<p>简单谈谈**args和**kwargs的理解</p>\r\n', '5', '2', '<p>两者都是不定长参数</p>\r\n\r\n<p>*args 是不定长位置参数，他可以表示输入参数是不确定的，可以是任意多个，args变量实则是一个元组。<br />\r\n**kwargs 是不定长关键字参数，赋值的时候是以键 = 值的方式，参数是可以任意多对在定义函数的时候不确定会有多少参数会传入时，就可以使用两个参数，kwargs变量实则是一个字典。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('612', null, '<p>Python进程间通信，除了socket方式，还有哪些方式可以实现通讯？</p>\r\n', '5', '3', '<p>（1）管道（Pipe）：管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用，允许一个进程和另一个与它有共同祖先的进程之间进行通信。<br />\r\n<br />\r\n（2）命名管道（named&nbsp;pipe）：也是半双工的通信方式，除具有管道所具有的功能外，它还允许无亲缘关系进程间的通信。命名管道在文件系统中有对应的文件名。命名管道通过命令mkfifo或系统调用mkfifo来创建。<br />\r\n<br />\r\n（3）信号（Signal）：信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。是Unix系统中使用的最古老的进程间通信的方法之一。操作系统通过信号来通知进程系统中发生了某种预先规定好的事件（一组事件中的一个），它也是用户进程之间通信和同步的一种原始机制。<br />\r\n<br />\r\n（4）消息（Message）队列：消息队列是消息的链接表，包括Posix消息队列system&nbsp;V消息队列。有足够权限的进程可以向队列中添加消息，被赋予读权限的进程则可以读走队列中的消息。消息队列克服了信号承载信息量少，管道只能承载无格式', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('613', null, '<p>如何快速实现列表的去重？</p>\r\n', '5', '1', '<p>最快速的方法是使用set函数转换为集合</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('614', null, '<p>简单对比一下list、tuple、set和dict的区别？</p>\r\n', '5', '2', '<p>1.list、tuple是有序列表；dict、set是无序列表<br />\r\n2.list元素可变、tuple元素不可变<br />\r\n3.dict和set的key值不可变，唯一性<br />\r\n4.set只有key没有value<br />\r\n5.set的用途：去重、并集、交集等<br />\r\n6.list、tuple：+、*、索引、切片、检查成员等<br />\r\n7.dict查询效率高，但是消耗内存多；list、tuple查询效率低、但是消耗内存少</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('615', null, '<p>请简要对比Python3中str和byte的区别</p>\r\n', '5', '1', '<p>python&nbsp;3中最重要的新特性可能就是将文本(text)和二进制数据做了更清晰的区分。文本总是用unicode进行编码，以str类型表示；而二进制数据以bytes类型表示。<br />\r\nstrings可以被编码(encode)成字bytes, bytes也可以解码(decode)成strings：</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('616', null, '<p>简单谈谈HTTP响应状态码及使用？</p>\r\n', '5', '2', '<p>通过状态码告诉客户端服务器的执行状态，以判断下一步该执行什么操作。常见的状态机器码有：<br />\r\n100-199：表示服务器成功接收部分请求，要求客户端继续提交其余请求才能完成整个处理过程。<br />\r\n200-299：表示服务器成功接收请求并已完成处理过程，常用 200（OK 请求成功）。<br />\r\n300-399：为完成请求，客户需要进一步细化请求。302（所有请求页面已经临时转移到新的 url）。304、307（使用缓存资源）。<br />\r\n400-499：客户端请求有错误，常用 404（服务器无法找到被请求页面），403（服务器拒绝访问，权限不够）。<br />\r\n500-599：服务器端出现错误，常用 500（请求未完成，服务器遇到不可预知的情况）。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('617', null, '<p>简单谈谈django和flask的区别？</p>\r\n', '5', '2', '<p>flask比较轻量级，Django是重量级</p>\r\n\r\n<p>简单的比喻就是：flask是一个可以修饰的毛坯房自己自主的搭配，提供核心的东西，django 是一个已经成型得房子修改性小，在某些方面Django使用起来灵活性差，显得比较笨重。</p>\r\n\r\n<p>django中除了web框架，自带ORM和模板引擎，自带的数据库管理app，第三方库最丰富，模块化是集成在命令里的，Django的配置主要还是靠settings.py来做<br />\r\nFlask通过Blueprint来提供模块化，Flask的配置很灵活，有多种方法配置，不同环境的配置也非常方便。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('618', null, '<p>列举一下python常用的标准库？</p>\r\n', '5', '3', '<p>os sys re math random unittest（测试） datatime</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('619', null, '<p>简单谈谈对迭代器与生成器的理解？</p>\r\n', '5', '2', '<p>说这个问题我们首先来谈一下for循环遍历对象的本质&nbsp;<br />\r\nfor循环来遍历列表等容器对象时，先对容器对象调用iter()函数。iter()是python的内置函数<br />\r\niter()函数会返回一个定义了next()方法的迭代器对象，它在容器中逐个访问容器中的元素。next()也是python的内置函数。没有后续元素时，next()会抛出StopIteration异常，此时for循环结束。</p>\r\n\r\n<p>接下来我们再来说迭代器（Iterator）<br />\r\n迭代器用来帮助我们记录每次迭代访问到的位置。<br />\r\n当对迭代器使用next()函数的时候，迭代器会返回它所记录位置的下一个位置的数据。<br />\r\n实际上，使用next()函数的时候，调用的是迭代器的__next__方法。所以一个迭代器必须有__next__方法。<br />\r\n但是这还不够，python本身要求迭代器本身也必须是可迭代的。因此迭代器还必须有一个__iter__方法，这给__iter__方法就是让for循环遍历时使用的，又因为__iter__方法要返回一个迭代器，所', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('620', null, '<p>谈谈对ajax的理解</p>\r\n', '5', '3', '<p>ajax可以实现局部刷新，也叫做无刷新，无刷新指的是整个页面不刷新，只是局部刷新，ajax可以自己发送http请求，不用通过浏览器的地址栏，所以页面整体不会刷新，ajax获取到后台数据，更新页面显示数据的部分，就做到了页面局部刷新。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('621', null, '<p>Redis的数据类型有哪些？</p>\r\n', '5', '1', '<p>string、list、set、zset、hash</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('622', null, '<p>Python正则表达式中贪婪与非贪婪的区别</p>\r\n', '5', '2', '<p>&lt;.*&gt;是贪婪匹配，会从第一个&ldquo;&lt;&rdquo;开始匹配，直到最后一个&ldquo;&gt;&rdquo;中间所有的字符都会匹配到，中间可能会包含&ldquo;&gt;&rdquo;。<br />\r\n&lt;.*?&gt;是非贪婪匹配，从第一个&ldquo;&lt;&rdquo;开始往后，遇到第一个&ldquo;&gt;&rdquo;结束匹配，这中间的字符串都会匹配到，但是不会有&ldquo;&gt;&rdquo;。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('623', null, '<p>常见的linux命令（不含参数）</p>\r\n', '5', '1', '<p>cd 切换路径 &nbsp;</p>\r\n\r\n<p>pwd 显示当前位置 &nbsp;</p>\r\n\r\n<p>who 显示当前登录的账号</p>\r\n\r\n<p>rm 删除 &nbsp;</p>\r\n\r\n<p>ls 显示当前路径下的所有文件</p>\r\n\r\n<p>chmod 修改权限</p>\r\n\r\n<p>cat 查看文件内容</p>\r\n\r\n<p>tar 打包/压缩</p>\r\n\r\n<p>ps 查看进程</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('624', null, '<p>Python中如何使用正则匹配所有标点符号？</p>\r\n', '5', '1', '<p>/W&nbsp; &nbsp;</p>\r\n\r\n<p>理由：因为小写/w匹配所有的字母和数字</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('625', null, '<p>简单谈谈多线程、多进程、协程以及锁的运用？</p>\r\n', '5', '3', '<p>多线程的优点：</p>\r\n\r\n<p>1. 创建进程的空间和时间开销要大于线程，进程之间有着不同的地址空间，而同一进程里的多线程则使用同一地址空间，共享该进程里的堆、数据资源；</p>\r\n\r\n<p>2. 方便高效的通信方式：线程间共享内存，通信方便，而进程通信需使用IPC；</p>\r\n\r\n<p>3. 较轻的切换开销 ：不用切换地址空间，不用更改CR3寄存器，不用刷新TLB</p>\r\n\r\n<p>多进程的优点：</p>\r\n\r\n<p>1. 一个进程crash不会导致整个系统崩溃</p>\r\n\r\n<p>2. python中多进程能使用起多核</p>\r\n\r\n<p>协程：</p>\r\n\r\n<p>1. 协程又被为微线程，拥有线程的大部分优点</p>\r\n\r\n<p>2. 相比于线程最主要的优点是协程的切换效率更高，不用惊动CPU，而是交由应用程序自己调度切换</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>多线程和协程适合IO密集型应用程序；多进程适合计算密集型任务</p>\r\n\r\n<p>多线程中由于共享资源问题，如果出现资源竞争那么就需要锁来进行限制；同理多进程中，如果出现多进程间共享资源竞争等问', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('626', null, '<p>简要谈谈你对进程、线程、协程的理解&nbsp; ？</p>\r\n', '5', '2', '<p>进程和线程其实都是CPU工作时间段的描述，不过是颗粒大小不同</p>\r\n\r\n<p>进程就是包换上下文切换的程序执行时间总和&nbsp;=&nbsp;CPU加载上下文+CPU执行+CPU保存上下文</p>\r\n\r\n<p>线程直接共享上下文，不用考虑加载的问题</p>\r\n\r\n<p>所以说进程在执行过程中拥有独立的内存资源，而多个线程共享内存同一份内存资源；进程间切换代价大，线程间切换代价小</p>\r\n\r\n<p>同时一个程序至少有一个进程,一个进程至少有一个线程；</p>\r\n\r\n<p>协程又称为微线程，因为其很多特征和线程几乎一样，只是线程的调度切换完全交由操作系统/CPU来做，而协程之间的切换完全基于用户来管理。</p>\r\n\r\n<p>通常多进程单指多个进程，多线程指单进程中多个线程、协程也指的单线程中的协程；</p>\r\n\r\n<p>但也有可能使用多进程+多线程；多进程+协程；多线程+协程的方式设计程序，此时就要考虑他们之间哪些资源是共享的、哪些的调度需要用户来管理的。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('627', null, '<p>Unix/Linux系统上，如何查看进程或杀死进程？</p>\r\n', '5', '1', '<p>查看某进程：ps -aux |grep 进程名字 &nbsp;</p>\r\n\r\n<p>杀死某进程：kill -9 进程id &nbsp; &nbsp;</p>\r\n\r\n<p>注意： -9 代表信号&nbsp; &nbsp;kill -l 查看更多信号类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('628', null, '<p>Django项目中密码的加密方式是怎样的？</p>\r\n', '5', '3', '<p>使用的是django自带的用户认证系统，用的是sha256加密、对称加密、非对称机密、不可逆加密</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('629', null, '<p>简要谈谈python的内存回收机制？</p>\r\n', '5', '3', '<p>内存管理机制：引用计数、垃圾回收、内存池。<br />\r\n引用计数：<br />\r\n引用计数是一种非常高效的内存管理手段， 当一个 Python 对象被引用时其引用计数增加1， 当其不再被一个变量引用时则计数减 1. 当引用计数等于0时对象被删除。<br />\r\n垃圾回收 ：<br />\r\n1. 引用计数<br />\r\n引用计数也是一种垃圾收集机制，而且也是一种最直观，最简单的垃圾收集技术。当 Python 的某个对象的引用计数降为 0 时，说明没有任何引用指向该对象，该对象就成为要被回收的垃圾了。比如某个新建对象，它被分配给某个引用，对象的引用计数变为 1。如果引用被删除，对象的引用计数为 0，那么该对象就可以被垃圾回收。不过如果出现循环引用的话，引用计数机制就不再起有效的作用了<br />\r\n2. 标记清除<br />\r\n如果两个对象的引用计数都为 1，但是仅仅存在他们之间的循环引用，那么这两个对象都是需要被回收的，也就是说，它们的引用计数虽然表现为非 0，但实际上有效的引用计数为 0。所以先将循环引用摘掉，就会得出这两个对象的有效计数。<br />\r\n3. 分代回收<br ', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('630', null, '<p>谈谈你对lambda函数的理解</p>\r\n', '5', '2', '<p>lambda 函数俗称匿名函数，是一个可以接收任意多个参数(包括可选参数)并且返回单个表达式值的函数</p>\r\n\r\n<p>1、lambda 函数比较轻便，即用即仍，很适合需要完成一项功能，通常只在该函数只会被使用一次的场景下使用；<br />\r\n2、匿名函数内部只能写一句表达式，并以此表达式的计算结果作为返回值<br />\r\n3、任何使用函数的场景理论上都是可以使用匿名函数的，但是要注意第二条</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('631', null, '<p>谈谈你对装饰器的理解</p>\r\n', '5', '2', '<p>装饰器本质上是一个Python函数，它可以在让其他函数在不需要做任何代码的变动的前提下增加额外的功能。 装饰器的返回值也是一个函数的对象，它经常用于有切面需求的场景。 比如：插入日志、性能测试、事务处理、缓存、权限的校验等场景。有了装饰器就可以抽离出大量的逻辑相似代码，并进行复用，实现解耦，从而便于代码编写和维护。</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('632', null, '<p>如何在一个function里面设置一个全局的变量</p>\r\n', '5', '1', '<p>如果要给全局变量在一个函数里赋值，&nbsp;必须使用global语句。global&nbsp;VarName的表达式会告诉Python，VarName是一个全局变量，&nbsp;这样Python就不会在局部命名空间里寻找这个变量</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('633', null, '<p>写出冒泡排序的实现</p>\r\n', '5', '1', '<pre>\r\n<code class=\"language-java\">void bubble_sort(int arr[], int len) {  \r\n    int i, j;  \r\n    for (i = 0; i &lt; len - 1; i++)    //外层循环控制趟数，总趟数为len-1\r\n        for (j = 0; j &lt; len - 1 - i; j++)  //内层循环为当前i趟数 所需要比较的次数\r\n            if (arr[j] &gt; arr[j + 1])  \r\n                swap(arr[j], arr[j + 1]);          \r\n} </code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '', null, '1', '1', '1', '2019-08-08 00:00:00', '1', '6', '2', '1');
INSERT INTO `t_question` VALUES ('634', null, 'test33333', '2', '3', '111', '1111', '', '1', '0', '0', '2019-08-15 16:09:48', '1', null, '3', '1');
INSERT INTO `t_question` VALUES ('635', null, 'test33333', '2', '3', '111', '1111', '', '0', '0', '0', '2019-08-15 16:25:45', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('636', null, 'test33333', '2', '3', '111', '1111', '', '0', '0', '0', '2019-08-15 16:27:56', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('638', null, 'test33333', '2', '3', '111', '1111', '', '0', '0', '0', '2019-08-16 08:04:39', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('639', null, 'test33333', '2', '3', '111', '1111', '', '0', '0', '0', '2019-08-16 08:29:08', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('640', null, 'test', '1', '2', '', '', '', '0', '0', '0', '2019-08-16 09:02:01', '1', '1', '2', '1');
INSERT INTO `t_question` VALUES ('641', null, 'test33333', '2', '3', '111', '1111', '', '0', '0', '0', '2019-08-16 09:08:52', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('642', null, 'test33333', '2', '3', '111', '1111', '', '1', '1', '1', '2019-08-16 09:45:01', '1', '2', '3', '1');
INSERT INTO `t_question` VALUES ('643', null, '<p>a</p>', '5', '1', '<p>a</p>', '', 'a', '0', '0', '0', '2019-08-21 11:13:08', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('644', null, '<p>bb</p>', '2', '2', '<p>b</p>', '', 'b', '0', '0', '0', '2019-08-21 11:22:05', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('645', null, '<p>cccc</p>', '2', '2', '<p>cccc</p>', '', 'cccc', '1', '0', '0', '2019-08-21 11:28:12', '1', '3', '5', '2');
INSERT INTO `t_question` VALUES ('646', null, '<p>c222222</p>', '2', '2', '<p>cccc</p>', '', 'cccc', '0', '0', '0', '2019-08-21 11:30:30', '1', '3', '4', '1');
INSERT INTO `t_question` VALUES ('647', null, '', '5', '1', '', '', '', '0', '0', '0', '2019-08-21 15:21:20', '1', '1', '2', '1');
INSERT INTO `t_question` VALUES ('648', null, '', '1', '1', '', 'aaa', 'aaa', '0', '0', '0', '2019-08-22 09:12:21', '1', '3', '6', '2');
INSERT INTO `t_question` VALUES ('649', null, '', '1', '1', '', '', '', '0', '0', '0', '2019-08-22 09:29:43', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('650', null, '', '1', '1', '', '', '图片单选', '0', '0', '0', '2019-08-22 09:36:24', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('651', null, '', '1', '1', '', '', '图片单选', '0', '0', '0', '2019-08-22 09:43:12', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('652', null, '', '1', '1', '', '', 'sss', '0', '0', '0', '2019-08-22 09:57:06', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('653', null, '', '5', '1', '', '', 'sss', '0', '0', '0', '2019-08-22 09:57:31', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('654', null, '<p>图片选择</p>', '1', '1', '<p>图片选择</p>', '', '图片选择', '0', '0', '0', '2019-08-22 10:52:49', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('655', null, '<p>xxx</p>', '1', '1', '<p>xxx</p>', '', 'xxx', '0', '0', '0', '2019-08-22 13:02:55', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('656', null, '<p>图片2</p>', '1', '1', '<p>图片2</p>', '', '图片2', '0', '0', '0', '2019-08-22 15:08:20', '1', '1', '2', '1');
INSERT INTO `t_question` VALUES ('657', null, '<p>aaa</p>', '1', '1', '<p>c</p>', '', 'c', '0', '0', '0', '2019-08-22 16:20:56', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('658', null, '<p>bbbb</p>', '1', '1', '<p>abcd</p>', '', 'abcd', '0', '0', '0', '2019-08-22 16:24:48', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('659', null, '<p>bbbbb</p>', '2', '1', '<p>bbbb</p>', '', 'bbbb', '0', '0', '0', '2019-08-22 16:26:54', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('660', null, '<p>dddd</p>', '2', '1', '<p>abceeeee</p>', '', 'badd', '1', '0', '0', '2019-08-22 16:28:00', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('661', null, '<p>新的多选多选</p>', '2', '1', '<p>新的多选多选</p>', '', '新的多选多选', '1', '0', '0', '2019-08-23 07:47:50', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('662', null, '<p>图片选择</p>', '1', '1', '<p>图片选择</p>', '', '图片选择', '1', '0', '0', '2019-08-23 07:50:45', '1', '2', '2', '1');
INSERT INTO `t_question` VALUES ('663', null, '<p>11</p>', '1', '1', '<p>aa</p>', 'aa', 'aa', '0', '0', '0', '2019-08-27 13:43:38', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('664', null, '<p>111xxxx</p>', '1', '1', '<p>aa</p>', 'aa', 'aa', '0', '0', '0', '2019-08-27 13:55:11', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('665', null, '<p>22222xxxxxx</p>', '2', '2', '<p>aa</p>', 'aa', 'aa', '0', '0', '0', '2019-08-27 14:40:25', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('666', null, '<p>111xxxx</p>', '2', '2', '<p>aa</p>', 'aa', 'aa', '0', '0', '0', '2019-08-27 14:42:42', '1', '5', '5', '2');
INSERT INTO `t_question` VALUES ('667', null, '<p>aa</p>', '1', '1', '<p>aa</p>', '', 'aa', '1', '1', '1', '2019-08-27 15:50:36', '1', '2', '5', '2');
INSERT INTO `t_question` VALUES ('668', null, '<p>aaa</p>', '2', '1', '<p>a</p>', '', 'a', '1', '1', '1', '2019-08-28 08:27:34', '1', '2', '1', '1');
INSERT INTO `t_question` VALUES ('669', null, '<p>aaa</p>', '5', '1', '<p>aaa</p>', 'aa', 'aaa', '1', '1', '1', '2019-08-28 11:38:57', '1', '1', '1', '1');
INSERT INTO `t_question` VALUES ('670', null, '<p>ss</p>', '2', '1', '<p>dd</p>', '', 'dd', '0', '0', '0', '2019-08-28 15:48:28', '1', '5', '5', '2');

-- ----------------------------
-- Table structure for `t_question_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_question_item`;
CREATE TABLE `t_question_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  `is_right` int(11) DEFAULT NULL COMMENT '是否正确答案\r\n            0 不是\r\n            1 是',
  `question_id` int(11) DEFAULT NULL COMMENT '隶属题目',
  PRIMARY KEY (`id`),
  KEY `FK_fk_question_item` (`question_id`),
  CONSTRAINT `FK_fk_question_item` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 COMMENT='试题选项';

-- ----------------------------
-- Records of t_question_item
-- ----------------------------
INSERT INTO `t_question_item` VALUES ('1', 'new Thread(){ 	 public void run() { 	System.out.println(\"ThreadOne重写run方法！！\"); 	 } };', null, '0', '3');
INSERT INTO `t_question_item` VALUES ('2', 'class ThreadOne extends Thread{ 	 public void run() { 	System.out.println(\"ThreadOne重写run方法！！\"); 	 } }', null, '0', '3');
INSERT INTO `t_question_item` VALUES ('3', 'class ThreadOne extends Runnable{ 	 public void run() { 	 System.out.println(\"ThreadOne重写run方法！！\"); 	 } }', null, '1', '3');
INSERT INTO `t_question_item` VALUES ('4', 'new Thread(new Runnable() { 	public void run() { 	System.out.println(\"ThreadOne重写run方法！！\"); 	} 	  } 	);', null, '0', '3');
INSERT INTO `t_question_item` VALUES ('5', '重写Object类的toString（）方法是为了方便打印对象的地址值。', null, '0', '4');
INSERT INTO `t_question_item` VALUES ('6', '重写Object类的equals（）方法是为了比较对象的地址值。', null, '0', '4');
INSERT INTO `t_question_item` VALUES ('7', '未重写Object类的equals()方法默认是比较对象中的属性值。	 ', null, '0', '4');
INSERT INTO `t_question_item` VALUES ('8', '重写Object类的toString()方法是方便打印对象中的属性值 。', null, '1', '4');
INSERT INTO `t_question_item` VALUES ('9', '必须有接口且接口中只有一个抽象方法。', null, '0', '5');
INSERT INTO `t_question_item` VALUES ('10', 'Lambda表达式的参数列表 ，没有参数时小括号可省略。', null, '1', '5');
INSERT INTO `t_question_item` VALUES ('11', 'Lambda表达式的都是延迟执行。	 ', null, '0', '5');
INSERT INTO `t_question_item` VALUES ('12', 'Lambda表达式的参数列表的 参数数据类型可以省略。', null, '0', '5');
INSERT INTO `t_question_item` VALUES ('13', '是一种直接或间接地调用自身的算法。', null, '1', '6');
INSERT INTO `t_question_item` VALUES ('14', '使程序变得简洁', null, '1', '6');
INSERT INTO `t_question_item` VALUES ('15', '递归的次数对程序的运行没有任何影响', null, '0', '6');
INSERT INTO `t_question_item` VALUES ('16', '递归一定要有条件限定，保证递归能够停止下来', null, '1', '6');
INSERT INTO `t_question_item` VALUES ('17', '<? extends E> E包括E的子类，也叫向上限定。', null, '1', '7');
INSERT INTO `t_question_item` VALUES ('18', '<? super E> E包括E的父类，也叫向下限定。', null, '1', '7');
INSERT INTO `t_question_item` VALUES ('19', '泛型的上限：只能接收该类型及其子类。', null, '1', '7');
INSERT INTO `t_question_item` VALUES ('20', '泛型的下限：只能接收该类型及其父类型。', null, '1', '7');
INSERT INTO `t_question_item` VALUES ('25', '必须有接口且接口中只有一个抽象方法。', null, '0', '636');
INSERT INTO `t_question_item` VALUES ('26', 'Lambda表达式的参数列表 ，没有参数时小括号可省略。', null, '1', '636');
INSERT INTO `t_question_item` VALUES ('27', 'Lambda表达式的都是延迟执行。	 ', null, '0', '636');
INSERT INTO `t_question_item` VALUES ('28', 'Lambda表达式的参数列表的 参数数据类型可以省略。', null, '0', '636');
INSERT INTO `t_question_item` VALUES ('37', '必须有接口且接口中只有一个抽象方法。', null, '0', '639');
INSERT INTO `t_question_item` VALUES ('38', 'Lambda表达式的参数列表 ，没有参数时小括号可省略。', null, '1', '639');
INSERT INTO `t_question_item` VALUES ('39', 'Lambda表达式的都是延迟执行。	 ', null, '0', '639');
INSERT INTO `t_question_item` VALUES ('40', 'Lambda表达式的参数列表的 参数数据类型可以省略。', null, '0', '639');
INSERT INTO `t_question_item` VALUES ('41', '必须有接口且接口中只有一个抽象方法-111。', null, '1', '642');
INSERT INTO `t_question_item` VALUES ('42', 'Lambda表达式的参数列表 ，没有参数时小括号可省略-111。', null, '1', '642');
INSERT INTO `t_question_item` VALUES ('43', 'Lambda表达式的都是延迟执行-111。	 ', null, '1', '642');
INSERT INTO `t_question_item` VALUES ('44', 'Lambda表达式的参数列表的 参数数据类型可以省略--111。', null, '1', '642');
INSERT INTO `t_question_item` VALUES ('45', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '641');
INSERT INTO `t_question_item` VALUES ('46', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '634');
INSERT INTO `t_question_item` VALUES ('47', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '635');
INSERT INTO `t_question_item` VALUES ('48', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '636');
INSERT INTO `t_question_item` VALUES ('49', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '638');
INSERT INTO `t_question_item` VALUES ('50', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '639');
INSERT INTO `t_question_item` VALUES ('51', 'Lambda表达式的参数列表的 参数数据类型可以省略-new 。', null, '0', '642');
INSERT INTO `t_question_item` VALUES ('52', '', null, '0', '643');
INSERT INTO `t_question_item` VALUES ('53', '', null, '0', '643');
INSERT INTO `t_question_item` VALUES ('54', '', null, '0', '643');
INSERT INTO `t_question_item` VALUES ('55', '', null, '0', '643');
INSERT INTO `t_question_item` VALUES ('56', '', null, '0', '643');
INSERT INTO `t_question_item` VALUES ('57', '', null, '0', '643');
INSERT INTO `t_question_item` VALUES ('58', 'b1', null, '1', '644');
INSERT INTO `t_question_item` VALUES ('59', 'b2', null, '1', '644');
INSERT INTO `t_question_item` VALUES ('60', 'b3', null, '0', '644');
INSERT INTO `t_question_item` VALUES ('61', 'b4', null, '0', '644');
INSERT INTO `t_question_item` VALUES ('62', '', null, '0', '644');
INSERT INTO `t_question_item` VALUES ('63', '', null, '0', '644');
INSERT INTO `t_question_item` VALUES ('64', 'c1', null, '1', '646');
INSERT INTO `t_question_item` VALUES ('65', 'c2', null, '1', '646');
INSERT INTO `t_question_item` VALUES ('66', 'c3', null, '1', '646');
INSERT INTO `t_question_item` VALUES ('67', 'c4', null, '0', '646');
INSERT INTO `t_question_item` VALUES ('68', '', 'img\\upload\\2019-08-22\\f99f6a0074a44f918127866efdfd239f.jpg', '0', '651');
INSERT INTO `t_question_item` VALUES ('69', '', 'img\\upload\\2019-08-22\\e74c526242044119bed2f94eda8d6767.jpg', '1', '651');
INSERT INTO `t_question_item` VALUES ('70', '', 'img\\upload\\2019-08-22\\47abb03482f24ed5bbeee2f7948bc153.jpg', '0', '651');
INSERT INTO `t_question_item` VALUES ('71', '', 'img\\upload\\2019-08-22\\d248e25ad83249a0a531f80d8d6d4fc3.jpg', '0', '651');
INSERT INTO `t_question_item` VALUES ('72', '', 'img\\upload\\2019-08-22\\d41c49fc364a4a7bb7909605f1ab86f0.jpg', '0', '654');
INSERT INTO `t_question_item` VALUES ('73', '', 'img\\upload\\2019-08-22\\51f28b6b9a744063ab7138bd0360a750.jpg', '0', '654');
INSERT INTO `t_question_item` VALUES ('74', '', 'img\\upload\\2019-08-22\\c82346327a5742afb3a10457daf81073.jpg', '0', '654');
INSERT INTO `t_question_item` VALUES ('75', '', 'img\\upload\\2019-08-22\\58c1e62f40794e449429ccb1f0e90cfb.jpg', '0', '654');
INSERT INTO `t_question_item` VALUES ('76', '', 'img\\upload\\2019-08-22\\892d37a4738244d48deb0868e412e678.jpg', '0', '655');
INSERT INTO `t_question_item` VALUES ('77', '', 'img\\upload\\2019-08-22\\2b014b22607d4440ac46f5e3fa76bae6.jpg', '0', '655');
INSERT INTO `t_question_item` VALUES ('78', '', 'img\\upload\\2019-08-22\\0145567fb0ce44759447541ce0d45d6c.jpg', '1', '655');
INSERT INTO `t_question_item` VALUES ('79', '', 'img\\upload\\2019-08-22\\06659f8691004890b74f70b75055c8b1.jpg', '0', '655');
INSERT INTO `t_question_item` VALUES ('80', '', 'img\\upload\\2019-08-22\\dabf333119034ec29be7304d15360e45.jpg', '0', '656');
INSERT INTO `t_question_item` VALUES ('81', '', 'img\\upload\\2019-08-22\\751e631475b24da8be71794f46796980.jpg', '0', '656');
INSERT INTO `t_question_item` VALUES ('82', '', 'img\\upload\\2019-08-22\\59b7c2022cc14343a4f8c39d71b16621.jpg', '0', '656');
INSERT INTO `t_question_item` VALUES ('83', '', 'img\\upload\\2019-08-22\\0089d58e5aaf4f42ae05fa5d6b3440a5.jpg', '0', '656');
INSERT INTO `t_question_item` VALUES ('84', 'a', '', '0', '657');
INSERT INTO `t_question_item` VALUES ('85', 'b', null, '1', '657');
INSERT INTO `t_question_item` VALUES ('86', 'c', null, '0', '657');
INSERT INTO `t_question_item` VALUES ('87', 'd', null, '0', '657');
INSERT INTO `t_question_item` VALUES ('88', 'aaaaa', '', '1', '658');
INSERT INTO `t_question_item` VALUES ('89', 'bbbb', '', '0', '658');
INSERT INTO `t_question_item` VALUES ('90', 'cccc', '', '0', '658');
INSERT INTO `t_question_item` VALUES ('91', 'ddd', '', '0', '658');
INSERT INTO `t_question_item` VALUES ('92', 'ddd1', '', '1', '660');
INSERT INTO `t_question_item` VALUES ('93', 'de2', '', '1', '660');
INSERT INTO `t_question_item` VALUES ('94', 'd3', '', '1', '660');
INSERT INTO `t_question_item` VALUES ('95', 'd3', '', '0', '660');
INSERT INTO `t_question_item` VALUES ('96', '新的多选多选\nA', '', '1', '661');
INSERT INTO `t_question_item` VALUES ('97', '新的多选多选\nB', '', '1', '661');
INSERT INTO `t_question_item` VALUES ('98', '新的多选多选', '', '0', '661');
INSERT INTO `t_question_item` VALUES ('99', '新的多选多选', '', '0', '661');
INSERT INTO `t_question_item` VALUES ('100', '', 'img\\upload\\2019-08-23\\2f7a48bf162f4352889711bb0b2d7996.jpg', '0', '662');
INSERT INTO `t_question_item` VALUES ('101', '', 'img\\upload\\2019-08-23\\30e9c788c49d41ec8fce6b44f540796b.jpg', '0', '662');
INSERT INTO `t_question_item` VALUES ('102', '', 'img\\upload\\2019-08-23\\9f2a16bf79034de7b71133169ace9364.jpg', '1', '662');
INSERT INTO `t_question_item` VALUES ('103', '', 'img\\upload\\2019-08-23\\2c294d790b8548889afeefb51bf911aa.jpg', '0', '662');
INSERT INTO `t_question_item` VALUES ('104', '11xx', '', '0', '664');
INSERT INTO `t_question_item` VALUES ('105', '22xx', '', '1', '664');
INSERT INTO `t_question_item` VALUES ('106', '33xx', '', '0', '664');
INSERT INTO `t_question_item` VALUES ('107', '44tttt', '', '0', '664');
INSERT INTO `t_question_item` VALUES ('108', '11xxaaa', '', '1', '665');
INSERT INTO `t_question_item` VALUES ('109', '22xxxxxxxxxxxx', '', '1', '665');
INSERT INTO `t_question_item` VALUES ('110', '33xx', '', '0', '665');
INSERT INTO `t_question_item` VALUES ('111', '44tttt', '', '0', '665');
INSERT INTO `t_question_item` VALUES ('112', '11xxaaa', '', '1', '666');
INSERT INTO `t_question_item` VALUES ('113', '22xxxxxxxxxxxx', '', '1', '666');
INSERT INTO `t_question_item` VALUES ('114', '33xx', '', '0', '666');
INSERT INTO `t_question_item` VALUES ('115', '44tttt', '', '0', '666');
INSERT INTO `t_question_item` VALUES ('116', '', 'img\\upload\\5b1cfd6d25cb4dc18430771d63bd8390.jpg', '1', '667');
INSERT INTO `t_question_item` VALUES ('117', '', 'img\\upload\\b7d4e841605649f7a0b12c741debd16c.jpg', '0', '667');
INSERT INTO `t_question_item` VALUES ('118', '', 'img\\upload\\bbf812e62a924bd09352c0a4999afd64.jpg', '0', '667');
INSERT INTO `t_question_item` VALUES ('119', '', 'img\\upload\\3af2e074d13c4ab888b53f1465ad8b01.jpg', '0', '667');
INSERT INTO `t_question_item` VALUES ('120', 'aa', 'img\\upload\\a42431d602084809b92051859e350536.jpg', '0', '668');
INSERT INTO `t_question_item` VALUES ('121', 'bb', 'img\\upload\\4fde19c4f0cd458bafd78fc4aa3bf314.jpg', '1', '668');
INSERT INTO `t_question_item` VALUES ('122', 'cc', 'img\\upload\\29a594dfc5c548479533cdc4a8db3e3f.jpg', '1', '668');
INSERT INTO `t_question_item` VALUES ('123', 'dd', 'img\\upload\\b5af5470fbeb4b2bab487e62056ff069.jpg', '0', '668');
INSERT INTO `t_question_item` VALUES ('124', '', 'img\\upload\\49bb774ad2c649f9a72f4293d3a2e211.jpg', '0', '669');
INSERT INTO `t_question_item` VALUES ('125', 'ss', '', '0', '670');
INSERT INTO `t_question_item` VALUES ('126', 'ss', '', '1', '670');
INSERT INTO `t_question_item` VALUES ('127', 'dd', '', '0', '670');
INSERT INTO `t_question_item` VALUES ('128', 'dd', '', '0', '670');
INSERT INTO `t_question_item` VALUES ('129', 'dd', '', '0', '670');

-- ----------------------------
-- Table structure for `t_review_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_review_log`;
CREATE TABLE `t_review_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '审核状态\r\n            0 未审核\r\n            1 已审核\r\n            2 已拒绝',
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '审核人ID',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_review` (`question_id`),
  KEY `FK_fk_user_review` (`user_id`),
  CONSTRAINT `FK_fk_user_review` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `fk_question_review` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2069 DEFAULT CHARSET=utf8mb4 COMMENT='审核日志';

-- ----------------------------
-- Records of t_review_log
-- ----------------------------
INSERT INTO `t_review_log` VALUES ('1', '未审核，等待审核', '0', '1', '1', '2019-08-09 10:35:24');
INSERT INTO `t_review_log` VALUES ('2', '已审核，非常好', '1', '8', '1', '2019-08-09 10:35:24');
INSERT INTO `t_review_log` VALUES ('3', '已拒绝，需要重新录入', '2', '9', '1', '2019-08-09 10:35:24');
INSERT INTO `t_review_log` VALUES ('4', '通过', '1', '1', '1', '2019-08-14 10:35:24');
INSERT INTO `t_review_log` VALUES ('8', '审核通过', '1', '642', '1', '2019-08-16 11:32:12');
INSERT INTO `t_review_log` VALUES ('9', '已下架', '2', '642', '1', '2019-08-16 11:33:30');
INSERT INTO `t_review_log` VALUES ('10', '审核通过', '1', '642', '1', '2019-08-16 11:36:18');
INSERT INTO `t_review_log` VALUES ('11', '暂时下架', '2', '642', '1', '2019-08-16 11:36:48');
INSERT INTO `t_review_log` VALUES ('12', '暂时下架', '2', '642', '1', '2019-08-16 11:39:38');
INSERT INTO `t_review_log` VALUES ('13', '审核通过', '1', '642', '1', '2019-08-16 11:40:12');
INSERT INTO `t_review_log` VALUES ('14', '审核通过', '1', '642', '1', '2019-08-19 16:51:30');
INSERT INTO `t_review_log` VALUES ('1042', '', '2', '1', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1043', '', '1', '2', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1044', '', '1', '3', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1045', '', '1', '4', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1046', '', '2', '5', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1047', '', '1', '6', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1048', '', '1', '7', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1049', '', '1', '8', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1050', '', '1', '9', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1051', '', '1', '10', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1052', '', '0', '11', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1053', '', '0', '12', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1054', '', '0', '13', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1055', '', '0', '14', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1056', '', '0', '15', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1057', '', '0', '23', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1058', '', '0', '26', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1059', '', '0', '27', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1060', '', '0', '30', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1061', '', '0', '31', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1062', '', '0', '32', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1063', '', '0', '33', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1064', '', '0', '35', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1065', '', '0', '36', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1066', '', '0', '37', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1067', '', '0', '38', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1068', '', '0', '41', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1069', '', '0', '43', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1070', '', '0', '44', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1071', '', '0', '50', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1072', '', '1', '53', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1073', '', '1', '54', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1074', '', '1', '55', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1075', '', '1', '59', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1076', '', '1', '60', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1077', '', '1', '61', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1078', '', '1', '62', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1079', '', '1', '63', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1080', '', '1', '64', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1081', '', '1', '65', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1082', '', '1', '66', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1083', '', '1', '67', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1084', '', '1', '68', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1085', '', '1', '69', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1086', '', '1', '70', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1087', '', '1', '71', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1088', '', '1', '72', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1089', '', '1', '73', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1090', '', '1', '74', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1091', '', '1', '75', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1092', '', '1', '76', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1093', '', '1', '77', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1094', '', '1', '78', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1095', '', '1', '79', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1096', '', '1', '80', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1097', '', '1', '82', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1098', '', '1', '83', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1099', '', '1', '84', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1100', '', '1', '85', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1101', '', '1', '86', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1102', '', '1', '87', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1103', '', '1', '88', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1104', '', '1', '89', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1105', '', '1', '90', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1106', '', '1', '91', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1107', '', '1', '92', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1108', '', '1', '93', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1109', '', '1', '94', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1110', '', '1', '95', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1111', '', '1', '96', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1112', '', '1', '97', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1113', '', '1', '98', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1114', '', '1', '99', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1115', '', '1', '100', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1116', '', '1', '101', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1117', '', '1', '102', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1118', '', '1', '103', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1119', '', '1', '104', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1120', '', '1', '105', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1121', '', '1', '106', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1122', '', '1', '107', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1123', '', '1', '108', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1124', '', '1', '109', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1125', '', '1', '110', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1126', '', '1', '111', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1127', '', '1', '112', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1128', '', '1', '113', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1129', '', '1', '114', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1130', '', '1', '115', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1131', '', '1', '116', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1132', '', '1', '117', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1133', '', '1', '118', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1134', '', '1', '119', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1135', '', '1', '122', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1136', '', '1', '123', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1137', '', '1', '126', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1138', '', '1', '127', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1139', '', '1', '128', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1140', '', '1', '129', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1141', '', '1', '130', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1142', '', '1', '131', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1143', '', '1', '133', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1144', '', '1', '134', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1145', '', '1', '135', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1146', '', '1', '136', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1147', '', '1', '137', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1148', '', '1', '138', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1149', '', '1', '139', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1150', '', '1', '140', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1151', '', '1', '141', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1152', '', '1', '142', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1153', '', '1', '144', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1154', '', '1', '145', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1155', '', '1', '147', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1156', '', '1', '148', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1157', '', '1', '149', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1158', '', '1', '150', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1159', '', '1', '151', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1160', '', '1', '153', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1161', '', '1', '154', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1162', '', '1', '155', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1163', '', '1', '156', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1164', '', '1', '159', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1165', '', '1', '160', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1166', '', '1', '162', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1167', '', '1', '163', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1168', '', '1', '165', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1169', '', '1', '167', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1170', '', '1', '168', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1171', '', '1', '169', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1172', '', '1', '171', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1173', '', '1', '172', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1174', '', '1', '173', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1175', '', '1', '174', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1176', '', '1', '175', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1177', '', '1', '176', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1178', '', '1', '177', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1179', '', '1', '178', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1180', '', '1', '179', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1181', '', '1', '180', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1182', '', '1', '181', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1183', '', '1', '182', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1184', '', '1', '183', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1185', '', '1', '185', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1186', '', '1', '186', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1187', '', '1', '187', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1188', '', '1', '188', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1189', '', '1', '189', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1190', '', '1', '190', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1191', '', '1', '191', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1192', '', '1', '193', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1193', '', '1', '194', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1194', '', '1', '195', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1195', '', '1', '197', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1196', '', '1', '198', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1197', '', '1', '201', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1198', '', '1', '203', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1199', '', '1', '207', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1200', '', '1', '208', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1201', '', '1', '209', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1202', '', '1', '211', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1203', '', '1', '212', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1204', '', '1', '214', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1205', '', '1', '215', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1206', '', '1', '216', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1207', '', '1', '217', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1208', '', '1', '218', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1209', '', '1', '219', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1210', '', '1', '220', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1211', '', '1', '221', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1212', '', '1', '222', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1213', '', '1', '223', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1214', '', '1', '224', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1215', '', '1', '225', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1216', '', '1', '226', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1217', '', '1', '227', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1218', '', '1', '228', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1219', '', '1', '229', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1220', '', '1', '230', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1221', '', '1', '231', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1222', '', '1', '232', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1223', '', '1', '234', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1224', '', '1', '235', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1225', '', '1', '236', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1226', '', '1', '237', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1227', '', '1', '238', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1228', '', '1', '239', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1229', '', '1', '240', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1230', '', '1', '241', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1231', '', '1', '242', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1232', '', '1', '243', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1233', '', '1', '244', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1234', '', '1', '245', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1235', '', '1', '246', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1236', '', '1', '247', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1237', '', '1', '248', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1238', '', '1', '249', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1239', '', '1', '250', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1240', '', '1', '251', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1241', '', '1', '252', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1242', '', '1', '253', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1243', '', '1', '254', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1244', '', '1', '255', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1245', '', '1', '256', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1246', '', '1', '257', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1247', '', '1', '258', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1248', '', '1', '259', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1249', '', '1', '260', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1250', '', '1', '261', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1251', '', '1', '262', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1252', '', '1', '263', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1253', '', '1', '264', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1254', '', '1', '265', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1255', '', '1', '266', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1256', '', '1', '267', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1257', '', '1', '268', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1258', '', '1', '269', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1259', '', '1', '270', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1260', '', '1', '271', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1261', '', '1', '272', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1262', '', '1', '273', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1263', '', '1', '274', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1264', '', '1', '275', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1265', '', '1', '276', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1266', '', '1', '277', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1267', '', '1', '278', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1268', '', '1', '279', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1269', '', '1', '280', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1270', '', '1', '281', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1271', '', '1', '282', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1272', '', '1', '283', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1273', '', '1', '284', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1274', '', '1', '285', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1275', '', '1', '286', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1276', '', '1', '287', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1277', '', '1', '288', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1278', '', '1', '289', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1279', '', '1', '290', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1280', '', '1', '291', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1281', '', '1', '292', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1282', '', '1', '293', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1283', '', '1', '294', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1284', '', '1', '295', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1285', '', '1', '296', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1286', '', '1', '297', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1287', '', '1', '298', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1288', '', '1', '299', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1289', '', '1', '300', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1290', '', '1', '301', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1291', '', '1', '302', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1292', '', '1', '303', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1293', '', '1', '304', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1294', '', '1', '305', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1295', '', '1', '306', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1296', '', '1', '307', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1297', '', '1', '308', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1298', '', '1', '309', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1299', '', '1', '310', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1300', '', '1', '311', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1301', '', '1', '312', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1302', '', '1', '313', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1303', '', '1', '314', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1304', '', '1', '315', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1305', '', '1', '316', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1306', '', '1', '318', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1307', '', '1', '319', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1308', '', '1', '320', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1309', '', '1', '321', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1310', '', '1', '322', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1311', '', '1', '323', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1312', '', '1', '324', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1313', '', '1', '325', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1314', '', '1', '326', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1315', '', '1', '327', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1316', '', '1', '328', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1317', '', '1', '329', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1318', '', '1', '330', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1319', '', '1', '331', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1320', '', '1', '332', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1321', '', '1', '333', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1322', '', '1', '334', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1323', '', '1', '335', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1324', '', '1', '336', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1325', '', '1', '337', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1326', '', '1', '338', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1327', '', '1', '339', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1328', '', '1', '340', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1329', '', '1', '341', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1330', '', '1', '342', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1331', '', '1', '343', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1332', '', '1', '344', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1333', '', '1', '345', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1334', '', '1', '346', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1335', '', '1', '347', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1336', '', '1', '348', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1337', '', '1', '349', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1338', '', '1', '350', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1339', '', '1', '351', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1340', '', '1', '352', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1341', '', '1', '353', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1342', '', '1', '354', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1343', '', '1', '355', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1344', '', '1', '356', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1345', '', '1', '357', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1346', '', '1', '358', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1347', '', '1', '359', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1348', '', '1', '360', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1349', '', '1', '361', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1350', '', '1', '362', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1351', '', '1', '363', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1352', '', '1', '364', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1353', '', '1', '365', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1354', '', '1', '366', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1355', '', '1', '367', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1356', '', '1', '368', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1357', '', '1', '369', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1358', '', '1', '370', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1359', '', '1', '371', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1360', '', '1', '372', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1361', '', '1', '373', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1362', '', '1', '374', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1363', '', '1', '375', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1364', '', '1', '376', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1365', '', '1', '377', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1366', '', '1', '378', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1367', '', '1', '379', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1368', '', '1', '380', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1369', '', '1', '381', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1370', '', '1', '382', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1371', '', '1', '383', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1372', '', '1', '384', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1373', '', '1', '385', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1374', '', '1', '386', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1375', '', '1', '387', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1376', '', '1', '388', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1377', '', '1', '389', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1378', '', '1', '390', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1379', '', '1', '391', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1380', '', '1', '392', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1381', '', '1', '393', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1382', '', '1', '394', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1383', '', '1', '395', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1384', '', '1', '396', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1385', '', '1', '397', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1386', '', '1', '398', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1387', '', '1', '399', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1388', '', '1', '400', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1389', '', '1', '401', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1390', '', '1', '402', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1391', '', '1', '403', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1392', '', '1', '404', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1393', '', '1', '405', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1394', '', '1', '406', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1395', '', '1', '407', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1396', '', '1', '408', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1397', '', '1', '409', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1398', '', '1', '410', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1399', '', '1', '411', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1400', '', '1', '412', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1401', '', '1', '414', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1402', '', '1', '415', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1403', '', '1', '416', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1404', '', '1', '417', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1405', '', '1', '418', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1406', '', '1', '419', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1407', '', '1', '420', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1408', '', '1', '421', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1409', '', '1', '422', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1410', '', '1', '423', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1411', '', '1', '424', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1412', '', '1', '425', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1413', '', '1', '426', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1414', '', '1', '427', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1415', '', '1', '428', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1416', '', '1', '429', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1417', '', '1', '430', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1418', '', '1', '431', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1419', '', '1', '432', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1420', '', '1', '433', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1421', '', '1', '434', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1422', '', '1', '435', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1423', '', '1', '436', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1424', '', '1', '437', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1425', '', '1', '438', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1426', '', '1', '439', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1427', '', '1', '440', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1428', '', '1', '441', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1429', '', '1', '442', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1430', '', '1', '443', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1431', '', '1', '444', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1432', '', '1', '445', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1433', '', '1', '446', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1434', '', '1', '447', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1435', '', '1', '448', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1436', '', '1', '449', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1437', '', '1', '450', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1438', '', '1', '451', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1439', '', '1', '452', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1440', '', '1', '453', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1441', '', '1', '454', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1442', '', '1', '455', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1443', '', '1', '456', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1444', '', '1', '457', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1445', '', '1', '458', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1446', '', '1', '459', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1447', '', '1', '460', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1448', '', '1', '461', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1449', '', '1', '462', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1450', '', '1', '463', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1451', '', '1', '464', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1452', '', '1', '465', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1453', '', '1', '466', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1454', '', '1', '467', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1455', '', '1', '468', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1456', '', '1', '469', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1457', '', '1', '470', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1458', '', '1', '471', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1459', '', '1', '472', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1460', '', '1', '473', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1461', '', '1', '474', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1462', '', '1', '475', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1463', '', '1', '476', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1464', '', '1', '477', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1465', '', '1', '478', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1466', '', '1', '479', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1467', '', '1', '480', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1468', '', '1', '481', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1469', '', '1', '482', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1470', '', '1', '483', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1471', '', '1', '484', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1472', '', '1', '485', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1473', '', '1', '486', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1474', '', '1', '487', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1475', '', '1', '488', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1476', '', '1', '489', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1477', '', '1', '490', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1478', '', '1', '491', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1479', '', '1', '492', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1480', '', '1', '493', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1481', '', '1', '494', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1482', '', '1', '495', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1483', '', '1', '496', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1484', '', '1', '497', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1485', '', '1', '498', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1486', '', '1', '499', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1487', '', '1', '500', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1488', '', '1', '501', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1489', '', '1', '502', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1490', '', '1', '503', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1491', '', '1', '504', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1492', '', '1', '505', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1493', '', '1', '506', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1494', '', '1', '507', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1495', '', '1', '508', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1496', '', '1', '509', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1497', '', '1', '510', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1498', '', '1', '511', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1499', '', '1', '512', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1500', '', '1', '513', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1501', '', '1', '514', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1502', '', '1', '515', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1503', '', '1', '516', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1504', '', '1', '517', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1505', '', '1', '518', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1506', '', '1', '519', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1507', '', '1', '520', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1508', '', '1', '521', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1509', '', '1', '522', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1510', '', '1', '523', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1511', '', '1', '524', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1512', '', '1', '525', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1513', '', '1', '526', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1514', '', '1', '527', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1515', '', '1', '528', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1516', '', '1', '529', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1517', '', '1', '530', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1518', '', '1', '531', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1519', '', '1', '532', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1520', '', '1', '533', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1521', '', '1', '534', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1522', '', '1', '535', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1523', '', '1', '536', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1524', '', '1', '537', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1525', '', '1', '538', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1526', '', '1', '539', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1527', '', '1', '540', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1528', '', '1', '541', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1529', '', '1', '543', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1530', '', '1', '544', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1531', '', '1', '545', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1532', '', '1', '546', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1533', '', '1', '547', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1534', '', '1', '548', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1535', '', '1', '549', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1536', '', '1', '550', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1537', '', '1', '551', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1538', '', '1', '552', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1539', '', '1', '553', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1540', '', '1', '554', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1541', '', '1', '555', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1542', '', '1', '556', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1543', '', '1', '557', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1544', '', '1', '558', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1545', '', '1', '559', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1546', '', '1', '560', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1547', '', '1', '561', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1548', '', '1', '562', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1549', '', '1', '563', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1550', '', '1', '564', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1551', '', '1', '565', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1552', '', '1', '567', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1553', '', '1', '568', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1554', '', '1', '569', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1555', '', '1', '570', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1556', '', '1', '571', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1557', '', '1', '572', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1558', '', '1', '573', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1559', '', '1', '574', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1560', '', '1', '576', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1561', '', '1', '577', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1562', '', '1', '578', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1563', '', '1', '579', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1564', '', '1', '580', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1565', '', '1', '581', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1566', '', '1', '582', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1567', '', '1', '583', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1568', '', '1', '584', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1569', '', '1', '585', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1570', '', '1', '586', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1571', '', '1', '587', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1572', '', '1', '588', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1573', '', '1', '589', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1574', '', '1', '590', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1575', '', '1', '591', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1576', '', '1', '592', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1577', '', '1', '593', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1578', '', '1', '594', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1579', '', '1', '595', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1580', '', '1', '596', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1581', '', '1', '597', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1582', '', '1', '598', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1583', '', '1', '599', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1584', '', '1', '600', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1585', '', '1', '601', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1586', '', '1', '602', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1587', '', '1', '603', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1588', '', '1', '604', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1589', '', '1', '605', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1590', '', '1', '606', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1591', '', '1', '607', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1592', '', '1', '608', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1593', '', '1', '609', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1594', '', '1', '610', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1595', '', '1', '611', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1596', '', '1', '612', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1597', '', '1', '613', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1598', '', '1', '614', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1599', '', '1', '615', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1600', '', '1', '616', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1601', '', '1', '617', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1602', '', '1', '618', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1603', '', '1', '619', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1604', '', '1', '620', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1605', '', '1', '621', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1606', '', '1', '622', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1607', '', '1', '623', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1608', '', '1', '624', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1609', '', '1', '625', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1610', '', '1', '626', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1611', '', '1', '627', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1612', '', '1', '628', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1613', '', '1', '629', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1614', '', '1', '630', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1615', '', '1', '631', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1616', '', '1', '632', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1617', '', '1', '633', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1618', '', '0', '634', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1619', '', '0', '635', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1620', '', '0', '636', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1621', '', '0', '638', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1622', '', '0', '639', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1623', '', '0', '640', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1624', '', '0', '641', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1625', '', '1', '642', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1626', '', '0', '643', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1627', '', '0', '644', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1628', '', '0', '645', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1629', '', '0', '646', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('1630', '', '0', '647', '1', '2019-08-21 16:13:43');
INSERT INTO `t_review_log` VALUES ('2065', '', '1', '1', '1', '2019-08-21 16:28:29');
INSERT INTO `t_review_log` VALUES ('2066', '审核通过', '1', '669', '1', '2019-08-29 14:25:13');
INSERT INTO `t_review_log` VALUES ('2067', '', '1', '668', '1', '2019-08-29 14:28:40');
INSERT INTO `t_review_log` VALUES ('2068', '', '1', '667', '1', '2019-08-29 14:36:03');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `keyword` varchar(64) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '系统管理员', 'ROLE_ADMIN', '系统管理员，具有最大权限');
INSERT INTO `t_role` VALUES ('2', '试题录入员', 'ROLE_QUESTION_RECORDER', '试题录入员，仅有基础题库录入权限');

-- ----------------------------
-- Table structure for `t_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态\r\n            0 启用\r\n            1 禁用',
  `user_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course_tag` (`course_id`),
  KEY `fk_user_tag` (`user_id`),
  CONSTRAINT `fk_course_tag` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`),
  CONSTRAINT `fk_user_tag` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('1', 'String字符串', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_tag` VALUES ('2', 'Java类与对象', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_tag` VALUES ('3', 'Servlet', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_tag` VALUES ('4', '多线程', '2019-08-08 00:00:00', '0', '1', '1', '1');
INSERT INTO `t_tag` VALUES ('5', '数据类型与变量', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_tag` VALUES ('6', 'list', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_tag` VALUES ('7', '切片', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_tag` VALUES ('8', '多重基础', '2019-08-08 00:00:00', '0', '1', '2', '1');
INSERT INTO `t_tag` VALUES ('12', '新增标签3', '2019-08-16 09:02:01', null, '1', '1', null);
INSERT INTO `t_tag` VALUES ('13', '新增标签4', '2019-08-16 09:08:52', null, '1', '2', null);
INSERT INTO `t_tag` VALUES ('14', '新增标签4', null, null, '1', '2', null);
INSERT INTO `t_tag` VALUES ('15', '新增标签4', null, null, '1', '2', null);
INSERT INTO `t_tag` VALUES ('16', '新增标签4', null, null, '1', '2', null);
INSERT INTO `t_tag` VALUES ('17', '新增标签4', null, '0', '1', '2', null);
INSERT INTO `t_tag` VALUES ('18', '新增标签4', '2019-08-16 09:43:23', '0', '1', '2', null);
INSERT INTO `t_tag` VALUES ('19', '新增标签4', '2019-08-16 09:45:01', '0', '1', '2', null);
INSERT INTO `t_tag` VALUES ('23', 'bbb', '2019-08-16 15:49:47', '0', '1', '1', null);
INSERT INTO `t_tag` VALUES ('25', 'ccc', '2019-08-16 15:50:01', '0', '1', '1', null);
INSERT INTO `t_tag` VALUES ('26', 'abb', '2019-08-16 15:50:06', '0', '1', '1', null);
INSERT INTO `t_tag` VALUES ('27', 'accc', '2019-08-16 15:50:08', '0', '1', '1', null);
INSERT INTO `t_tag` VALUES ('31', 'aaaccc', '2019-08-16 15:52:10', '0', '1', '1', null);
INSERT INTO `t_tag` VALUES ('32', 'ddddd', '2019-08-16 16:01:04', '0', '1', '1', null);
INSERT INTO `t_tag` VALUES ('33', 'cccccc', '2019-08-26 10:47:29', '0', '1', '1', null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '用户状态\r\n            0 启用\r\n            1 禁用',
  `email` varchar(100) DEFAULT NULL,
  `source` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '0', 'admin@mm.itheima.cn', '后台', '2019-08-08 00:00:00', '默认系统管理员');
INSERT INTO `t_user` VALUES ('2', 'zhangsan', '123456', '0', 'zhangsan@mm.itheima.cn', '后台', '2019-08-08 00:00:00', '测试账号');

-- ----------------------------
-- Table structure for `t_wx_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_member`;
CREATE TABLE `t_wx_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL,
  `avatar_url` text,
  `gender` char(2) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `open_id` varchar(50) DEFAULT NULL,
  `union_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `last_category_kind` int(11) DEFAULT NULL,
  `last_category_type` int(11) DEFAULT NULL,
  `last_category_id` int(11) DEFAULT NULL,
  `last_question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_member` (`last_question_id`),
  CONSTRAINT `fk_question_member` FOREIGN KEY (`last_question_id`) REFERENCES `t_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='会员表\r\n';

-- ----------------------------
-- Records of t_wx_member
-- ----------------------------
INSERT INTO `t_wx_member` VALUES ('1', 'shaofeng zeng', 'https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJVuY6TibKiad6f9opp3jd3AsJPO8IbA6WCbPIoorkLOpY694T7QG0P2n', '1', 'Xiamen', 'Fujian', 'China', 'zh_CN', 'oiu565aTc09ooXMxznSkWiYD1T5Q', null, '2018-07-16 10:46:33', '1', '1', null, null, null, null);
INSERT INTO `t_wx_member` VALUES ('2', '静，由心生！', 'https://wx.qlogo.cn/mmopen/vi_32/lpqia8qJZqrfJAiaCnkK1yfNjHjO5aNeaL7t7iadwuzGJvfibUAqcg686BRaWLCXRAk', '2', '', '', 'China', 'zh_CN', 'oiu565WN-acgqPak8TKNGETqNhmw', null, '2018-07-16 10:56:18', '1', '1', null, null, null, null);
INSERT INTO `t_wx_member` VALUES ('3', '快乐时光', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLiac0gFHH6DtMiaJ5EhytptXOBagUtmDmV6z9NvddIoCo6NEzTgng6kw4', '1', 'Haidian', 'Beijing', 'China', 'zh_CN', 'oiu565dj_usqolSgah95XdOHOxhs', null, '2018-07-16 11:05:02', '1', '1', null, null, null, null);
INSERT INTO `t_wx_member` VALUES ('4', '叶子', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIia6JywZv309v5Rh5m7hSH422SoYPiblrL3Kk1ZJun8jEiaN4fP6eF2uJ', '2', 'Changping', 'Beijing', 'China', 'zh_CN', 'oiu565XGe5FqWS_Df7VEXG0QgpD0', null, '2018-07-16 11:05:15', '1', '1', null, null, null, null);
INSERT INTO `t_wx_member` VALUES ('5', 'hans', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJZ66KpnQNReXSEWpS47dUaiaAZGQz0BDj1zjef6ysibjK69VhqrkZbvDd', '1', 'West', 'Beijing', 'China', 'zh_CN', 'oiu565SzoTCXctUD0y6Ll-RQOkFg', null, '2018-07-16 11:30:38', '2', '2', '1', '100', '1', '7');
INSERT INTO `t_wx_member` VALUES ('6', '皓月', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzJEK3Msde5mUX1zuAq406aZuJvquEWKgVia26yibFsIhG7MNhsvgHEgMhdwJdY1iaDoxndNpBibDxhA/132', '1', 'Chaoyang', 'Beijing', 'China', 'zh_CN', 'oDQVX48njUTb-4iQbel3hRpyoRIs', null, '2019-08-21 08:39:31', '9', '1', '1', '100', '2', '78');
