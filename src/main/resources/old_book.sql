/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : old_book

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-05-09 20:09:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply_for_business
-- ----------------------------
DROP TABLE IF EXISTS `apply_for_business`;
CREATE TABLE `apply_for_business` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `apply_person_name` varchar(10) DEFAULT NULL COMMENT '申请人姓名',
  `status` smallint(1) unsigned DEFAULT NULL COMMENT '审批状态  0-未审批 1-审批通过 2-审批不通过',
  `apply_reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `return_message` varchar(255) DEFAULT NULL COMMENT '回执信息',
  `apply_time` datetime DEFAULT NULL COMMENT '申请成为商家的时间',
  `approval_time` datetime DEFAULT NULL COMMENT '管理员审批时间',
  `is_active` tinyint(1) DEFAULT NULL COMMENT '该条记录是否可用 0-不可用 1-可用',
  `user_id` int(10) DEFAULT NULL COMMENT '申请成为商家的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply_for_business
-- ----------------------------
INSERT INTO `apply_for_business` VALUES ('1', '何晓波', '2', '二手书籍太多,扔了怪可惜的', '请完善信息', '2018-05-08 10:52:59', '2018-05-08 23:41:06', '0', '1');
INSERT INTO `apply_for_business` VALUES ('2', '张三', '1', '想赚点钱', '审批合格', '2018-05-08 11:06:10', '2018-05-08 22:14:31', '1', '3');
INSERT INTO `apply_for_business` VALUES ('3', 'xx同学', '2', '我想卖点书赚点钱', '用户姓名不完善', '2018-05-08 22:18:35', '2018-05-08 22:19:02', '0', '4');
INSERT INTO `apply_for_business` VALUES ('4', '李四', '2', '谢谢指导 已经修改', '不想理你', '2018-05-08 23:38:02', '2018-05-08 23:38:44', '0', '4');
INSERT INTO `apply_for_business` VALUES ('5', '李四', '1', '求你了', '审批合格', '2018-05-08 23:39:06', '2018-05-08 23:39:20', '1', '4');
INSERT INTO `apply_for_business` VALUES ('6', '何晓波', '1', '已经完善,想卖点书,保护环境', '审批合格', '2018-05-08 23:41:45', '2018-05-08 23:41:58', '1', '1');
INSERT INTO `apply_for_business` VALUES ('7', 'xx同学', '2', '我书太多，不好处理', '理由不充分', '2018-05-09 13:08:49', '2018-05-09 13:09:43', '0', '5');
INSERT INTO `apply_for_business` VALUES ('8', 'xx同学', '1', '书太多,扔了污染环境', '审批合格', '2018-05-09 13:12:28', '2018-05-09 13:12:44', '1', '5');
INSERT INTO `apply_for_business` VALUES ('9', 'xx同学', '2', '就是这么吊', '用户信息不完善', '2018-05-09 16:38:07', '2018-05-09 17:20:12', '0', '6');
INSERT INTO `apply_for_business` VALUES ('10', '二牛', '1', '想赚钱', '审批合格', '2018-05-09 17:21:11', '2018-05-09 17:22:25', '1', '6');
INSERT INTO `apply_for_business` VALUES ('11', 'xx同学', '1', '沙发里', '审批合格', '2018-05-09 20:02:30', '2018-05-09 20:02:56', '1', '7');

-- ----------------------------
-- Table structure for book_img
-- ----------------------------
DROP TABLE IF EXISTS `book_img`;
CREATE TABLE `book_img` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片保存路径',
  `book_id` int(10) DEFAULT NULL COMMENT '图片所属书籍的id',
  `img_upload_time` datetime DEFAULT NULL COMMENT '书籍图片上传时间',
  `img_modified_time` datetime DEFAULT NULL COMMENT '书籍图片最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_img
-- ----------------------------

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL COMMENT '书籍名称',
  `book_price` decimal(4,2) DEFAULT NULL COMMENT '书籍价格',
  `book_save` smallint(4) unsigned DEFAULT NULL COMMENT '书籍剩货',
  `book_introduction` varchar(200) DEFAULT NULL COMMENT '书籍简介 50字以内',
  `book_varety_id` int(10) DEFAULT NULL COMMENT '所属书籍分类的id',
  `user_id` int(10) DEFAULT NULL COMMENT '所属用户的id',
  `book_create_time` datetime DEFAULT NULL COMMENT '书籍信息创建时间',
  `book_modified-time` datetime DEFAULT NULL COMMENT '书籍信息最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------

-- ----------------------------
-- Table structure for book_variety
-- ----------------------------
DROP TABLE IF EXISTS `book_variety`;
CREATE TABLE `book_variety` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL COMMENT '书籍种类名称',
  `book_type_create_time` datetime DEFAULT NULL COMMENT '书籍种类创建时间',
  `book_type_modified_time` datetime DEFAULT NULL COMMENT '书籍种类最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_variety
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) NOT NULL,
  `seller_id` int(10) NOT NULL COMMENT '卖家用户的id',
  `buyers_id` int(10) NOT NULL COMMENT '买家用户的id',
  `book_id` int(10) NOT NULL COMMENT '售卖书籍的id',
  `order_create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `order_modified_time` datetime DEFAULT NULL COMMENT '订单最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_account` char(20) NOT NULL COMMENT '用户登录账号 10位字符  英文和数字组合(或电话号码)',
  `user_name` varchar(10) DEFAULT 'xx同学' COMMENT '用户姓名(2~3个汉字) 默认为 xx同学 ',
  `password` varchar(50) NOT NULL COMMENT '用户密码 (md5加密)',
  `salt` varchar(8) DEFAULT NULL COMMENT '盐值',
  `role_type` smallint(1) unsigned DEFAULT NULL COMMENT '用户角色 0-管理员  1-用户',
  `is_merchant` tinyint(1) unsigned DEFAULT NULL COMMENT '是否是商家(只考虑用户) 0-不是  1-是',
  `user_register_time` datetime DEFAULT NULL COMMENT '注册成为用户的时间',
  `register_merchant_time` datetime DEFAULT NULL COMMENT '用户注册成为商家的时间',
  `user_modified_time` datetime DEFAULT NULL COMMENT '用户信息最近修改的时间',
  `is_valid` tinyint(1) DEFAULT '1' COMMENT '该账号是否有效',
  `encrypted_problem` varchar(255) DEFAULT NULL COMMENT '密保问题(忘记密码时使用)',
  `encrypted_question` varchar(255) DEFAULT NULL COMMENT '密保答案(忘记密码时使用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hxb1', '何晓波', '7a85d6ffd258694c16ce64ac9024bd1e', '9qkqrvkz', '1', '1', '2018-05-05 18:24:47', null, '2018-05-06 11:43:32', '1', '我的学生证号是', '14101020105');
INSERT INTO `user` VALUES ('2', 'admin', '管理员', '58ecf8ba26e7571eaa4b7d7b82ee2d4d', '5xyil3i9', '0', '0', '2018-05-06 13:53:25', null, '2018-05-06 13:53:25', '1', null, null);
INSERT INTO `user` VALUES ('3', 'hxb2', '张三', '36c762dff807fce01b8046671f2b0442', 'k84xjnij', '1', '1', '2018-05-06 20:36:40', null, '2018-05-06 20:37:01', '1', '我的生日是', '不知道');
INSERT INTO `user` VALUES ('4', 'hxb3', '李四', 'd477bfb6def5a635aabe22209b53ed35', 'blnmrn5g', '1', '1', '2018-05-08 22:18:00', null, '2018-05-08 23:37:48', '1', null, null);
INSERT INTO `user` VALUES ('5', 'hxb4', 'xx同学', 'f514304128761d304ae8887c34d1cdef', '9qqagy0q', '1', '1', '2018-05-09 13:07:58', null, '2018-05-09 13:07:58', '1', null, null);
INSERT INTO `user` VALUES ('6', 'hxb5', '二牛', '1ce060b62704ac25dd91b8af0755f255', 'mm6cdrjl', '1', '1', '2018-05-09 16:37:45', null, '2018-05-09 17:20:48', '1', null, null);
INSERT INTO `user` VALUES ('7', 'hxb6', 'xx同学', '81e44de96b8116c78df345662126c6cd', 'rgydaope', '1', '1', '2018-05-09 20:01:29', '2018-05-09 20:02:56', '2018-05-09 20:01:29', '1', null, null);
