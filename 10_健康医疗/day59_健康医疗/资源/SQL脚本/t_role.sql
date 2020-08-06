/*
Navicat MySQL Data Transfer

Source Server         : ∞¢¿Ô‘∆MySQL ˝æ›ø‚
Source Server Version : 50173
Source Host           : bdm266490277.my3w.com:3306
Source Database       : bdm266490277_db

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-05-18 14:31:06
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'Á≥ªÁªüÁÆ°ÁêÜÂëò', 'ROLE_ADMIN', null);
INSERT INTO `t_role` VALUES ('2', 'ÂÅ•Â∫∑ÁÆ°ÁêÜÂ∏à', 'ROLE_HEALTH_MANAGER', null);
