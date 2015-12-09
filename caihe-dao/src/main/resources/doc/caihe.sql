/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : caihe

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-12-09 11:41:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_group`
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group` (
  `id` varchar(32) NOT NULL COMMENT '用户组id',
  `name` varchar(100) NOT NULL COMMENT '组名',
  `parent_id` varchar(32) NOT NULL default '-1' COMMENT '父组id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_group
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_group_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_role`;
CREATE TABLE `auth_group_role` (
  `id` varchar(32) NOT NULL COMMENT '角色与组的关联表id',
  `group_id` varchar(32) NOT NULL COMMENT '组id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_group_role
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_group_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_user`;
CREATE TABLE `auth_group_user` (
  `id` varchar(32) NOT NULL COMMENT '用户与组关联表的id',
  `group_id` varchar(32) NOT NULL COMMENT '组id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_group_user
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_resource`
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource` (
  `id` varchar(32) NOT NULL default '',
  `resource_name` varchar(100) NOT NULL COMMENT '资源名称',
  `url` varchar(300) default NULL COMMENT '资源访问路径',
  `is_menu` tinyint(1) NOT NULL COMMENT '是否是菜单资源',
  `parent_id` varchar(32) NOT NULL COMMENT '父资源id',
  `order` int(3) NOT NULL default '0' COMMENT '位置',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource` VALUES ('1', 'test', '/test', '0', '-1', '0');

-- ----------------------------
-- Table structure for `auth_resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource_role`;
CREATE TABLE `auth_resource_role` (
  `id` varchar(32) NOT NULL COMMENT '资源与角色关联表id',
  `resource_id` varchar(32) NOT NULL COMMENT '资源id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_resource_role
-- ----------------------------
INSERT INTO `auth_resource_role` VALUES ('3', '1', '2');

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` varchar(32) NOT NULL COMMENT '角色id',
  `rolename` varchar(100) NOT NULL COMMENT '角色名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('2', 'test');

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(30) default NULL COMMENT '密码',
  `age` int(3) default '0' COMMENT '年龄',
  `sex` tinyint(1) default '2' COMMENT '性别 0 ：男   1 ： 牛  2 未知',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('1', 'test', 'test', '0', '2');
INSERT INTO `auth_user` VALUES ('2', 'test1', 'test1', '0', '2');

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `id` varchar(32) NOT NULL COMMENT '用户与角色关联表id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES ('1', '1', '2');

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(128) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`series`),
  KEY `idx1` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('test1', 'do9a+2iiSTkTXk6T+d7wZA==', 'dgFwiwi1Pl1x03bqlXmuNw==', '2015-12-09 11:38:48');
INSERT INTO `persistent_logins` VALUES ('test1', 't+Yhw80C/tvclCiDx22ilw==', 'HXygsYrC883NhfdWVnFglQ==', '2015-12-09 11:34:32');
INSERT INTO `persistent_logins` VALUES ('test1', 'vV8CB74g/xdAew3Uj5RP/w==', 'paUBfO5EBX03xLtE5s2hgg==', '2015-12-09 11:35:10');
