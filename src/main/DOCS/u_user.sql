/*
Navicat MySQL Data Transfer

Source Server         : shirf
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : dbgril

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-21 16:40:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('10001', 'xiaoming', 'xiaoming@bonc.com.cn', '123456', '2018-08-21 11:05:51', '2018-08-21 15:42:48', '1');
