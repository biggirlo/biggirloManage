/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : biggirlos

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-12 21:00:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bs_sys_handle
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_handle`;
CREATE TABLE `bs_sys_handle` (
  `id` int(11) NOT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `handle_code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `url` varchar(400) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `is_available` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_handle
-- ----------------------------

-- ----------------------------
-- Table structure for bs_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_menu`;
CREATE TABLE `bs_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(100) DEFAULT NULL,
  `menu_name` varchar(200) DEFAULT NULL,
  `url` varchar(400) DEFAULT NULL,
  `menu_icon` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_menu
-- ----------------------------
INSERT INTO `bs_sys_menu` VALUES ('1', 'SYS', '系统管理', '', 'fa fa-home', null, '1', '0', '2017-09-20 00:28:55', '1', '1', '2017-11-02 19:46:02');
INSERT INTO `bs_sys_menu` VALUES ('2', 'SYS_USER', '用户管理', '/page/system/user/sys_user_list.html', 'fa fa-user', null, '1', '1', '2017-09-20 00:34:35', '1', '1', '2017-11-02 19:50:40');
INSERT INTO `bs_sys_menu` VALUES ('3', 'Test3', '测试菜单22', 'www', 'fa fa-home', null, '1', '0', '2017-09-20 00:35:05', '1', '1', '2017-11-02 19:45:42');
INSERT INTO `bs_sys_menu` VALUES ('4', 'Test4', '测试子菜单4', '/page/ttt/Test.html', 'fa fa-home', null, '1', '3', '2017-09-20 00:35:34', '1', null, null);
INSERT INTO `bs_sys_menu` VALUES ('5', 'Test5', '测试子菜单5', 'wwww', 'fa fa-home', null, '1', '3', '2017-09-20 00:35:51', '1', '1', '2017-09-20 00:35:55');
INSERT INTO `bs_sys_menu` VALUES ('6', 'SYS_MANAGE', '菜单管理', '/page/system/menu/sys_menu.html', 'fa fa-industry', null, '1', '1', '2017-10-27 19:07:49', '1', null, '2017-11-02 19:51:59');
INSERT INTO `bs_sys_menu` VALUES ('11', 'SYS_ROLE', '角色管理', '/page/system/role/sys_role.html', 'fa fa-users', null, '1', '1', '2017-11-02 19:48:54', null, null, '2017-11-02 23:06:57');
INSERT INTO `bs_sys_menu` VALUES ('12', '测试', '测试', '测试', '测试', null, '2', '4', '2017-11-03 00:57:17', null, null, null);

-- ----------------------------
-- Table structure for bs_sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_organization`;
CREATE TABLE `bs_sys_organization` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `organization_code` varchar(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `summary` varchar(1000) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `is_available` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for bs_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_role`;
CREATE TABLE `bs_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(100) DEFAULT NULL,
  `role_name` varchar(150) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_role
-- ----------------------------
INSERT INTO `bs_sys_role` VALUES ('1', 'sysAdmin', '超级管理员', null, '2017-11-03 00:14:31', null, null, '2017-11-04 12:35:07');
INSERT INTO `bs_sys_role` VALUES ('2', 'test', '测试2', null, '2017-11-04 02:19:07', null, null, '2017-11-05 13:50:30');
INSERT INTO `bs_sys_role` VALUES ('3', '他说他', '111', null, '2017-11-04 02:54:17', null, null, null);

-- ----------------------------
-- Table structure for bs_sys_role_handle
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_role_handle`;
CREATE TABLE `bs_sys_role_handle` (
  `id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `handle_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_role_handle
-- ----------------------------

-- ----------------------------
-- Table structure for bs_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_role_menu`;
CREATE TABLE `bs_sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT=' ';

-- ----------------------------
-- Records of bs_sys_role_menu
-- ----------------------------
INSERT INTO `bs_sys_role_menu` VALUES ('37', '2', '6', '2017-11-08 00:32:32', '1', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('38', '2', '2', '2017-11-08 00:32:32', '1', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('39', '2', '11', '2017-11-08 00:32:32', '1', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('40', '2', '1', '2017-11-08 00:32:32', '1', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('41', '2', '0', '2017-11-08 00:32:32', '1', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('49', '1', '6', '2017-11-08 01:40:48', '2', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('50', '1', '1', '2017-11-08 01:40:48', '2', null, null);
INSERT INTO `bs_sys_role_menu` VALUES ('51', '1', '0', '2017-11-08 01:40:48', '2', null, null);

-- ----------------------------
-- Table structure for bs_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_user`;
CREATE TABLE `bs_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `hard_img` varchar(500) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `moblie` varchar(11) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `is_available` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of bs_sys_user
-- ----------------------------
INSERT INTO `bs_sys_user` VALUES ('2', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, '测试', '13751878576', '645614025@qq.com', null, '1', null, null, '2', '2017-11-08 01:23:47');
INSERT INTO `bs_sys_user` VALUES ('3', 'test', '123456', null, '测试号', '13751878576', '645614025@qq.com', null, '1', '2017-11-08 01:26:46', '2', '2', '2017-11-08 01:26:54');

-- ----------------------------
-- Table structure for bs_sys_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_user_organization`;
CREATE TABLE `bs_sys_user_organization` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_user_organization
-- ----------------------------

-- ----------------------------
-- Table structure for bs_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `bs_sys_user_role`;
CREATE TABLE `bs_sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_sys_user_role
-- ----------------------------
INSERT INTO `bs_sys_user_role` VALUES ('13', '3', '2', '2017-11-08 00:47:54', '1', null, null);
