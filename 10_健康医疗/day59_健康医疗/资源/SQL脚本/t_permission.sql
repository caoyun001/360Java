/*
Navicat MySQL Data Transfer

Source Server         : ������MySQL���ݿ�
Source Server Version : 50173
Source Host           : bdm266490277.my3w.com:3306
Source Database       : bdm266490277_db

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-05-18 14:30:35
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '新增检查项', 'CHECKITEM_ADD', null);
INSERT INTO `t_permission` VALUES ('2', '删除检查项', 'CHECKITEM_DELETE', null);
INSERT INTO `t_permission` VALUES ('3', '编辑检查项', 'CHECKITEM_EDIT', null);
INSERT INTO `t_permission` VALUES ('4', '查询检查项', 'CHECKITEM_QUERY', null);
INSERT INTO `t_permission` VALUES ('5', '新增检查组', 'CHECKGROUP_ADD', null);
INSERT INTO `t_permission` VALUES ('6', '删除检查组', 'CHECKGROUP_DELETE', null);
INSERT INTO `t_permission` VALUES ('7', '编辑检查组', 'CHECKGROUP_EDIT', null);
INSERT INTO `t_permission` VALUES ('8', '查询检查组', 'CHECKGROUP_QUERY', null);
INSERT INTO `t_permission` VALUES ('9', '新增套餐', 'SETMEAL_ADD', null);
INSERT INTO `t_permission` VALUES ('10', '删除套餐', 'SETMEAL_DELETE', null);
INSERT INTO `t_permission` VALUES ('11', '编辑套餐', 'SETMEAL_EDIT', null);
INSERT INTO `t_permission` VALUES ('12', '查询套餐', 'SETMEAL_QUERY', null);
INSERT INTO `t_permission` VALUES ('13', '预约设置', 'ORDERSETTING', null);
INSERT INTO `t_permission` VALUES ('14', '查看统计报表', 'REPORT_VIEW', null);
INSERT INTO `t_permission` VALUES ('15', '新增菜单', 'MENU_ADD', null);
INSERT INTO `t_permission` VALUES ('16', '删除菜单', 'MENU_DELETE', null);
INSERT INTO `t_permission` VALUES ('17', '编辑菜单', 'MENU_EDIT', null);
INSERT INTO `t_permission` VALUES ('18', '查询菜单', 'MENU_QUERY', null);
INSERT INTO `t_permission` VALUES ('19', '新增角色', 'ROLE_ADD', null);
INSERT INTO `t_permission` VALUES ('20', '删除角色', 'ROLE_DELETE', null);
INSERT INTO `t_permission` VALUES ('21', '编辑角色', 'ROLE_EDIT', null);
INSERT INTO `t_permission` VALUES ('22', '查询角色', 'ROLE_QUERY', null);
INSERT INTO `t_permission` VALUES ('23', '新增用户', 'USER_ADD', null);
INSERT INTO `t_permission` VALUES ('24', '删除用户', 'USER_DELETE', null);
INSERT INTO `t_permission` VALUES ('25', '编辑用户', 'USER_EDIT', null);
INSERT INTO `t_permission` VALUES ('26', '查询用户', 'USER_QUERY', null);
