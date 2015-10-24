/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : caihe

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-10-24 16:54:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Database structure for caihe
-- ----------------------------
DROP DATABASE IF EXISTS `caihe`;
CREATE DATABASE `caihe`;
USE `caihe`;

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