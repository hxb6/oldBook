/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : old_book

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-05-18 19:24:28
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply_for_business
-- ----------------------------
INSERT INTO `apply_for_business` VALUES ('1', '何晓波', '1', '我先卖书', '审批合格', '2018-05-09 22:30:27', '2018-05-09 22:31:49', '0', '2');
INSERT INTO `apply_for_business` VALUES ('2', '张三', '1', '书太多', '审批合格', '2018-05-09 22:30:53', '2018-05-09 22:32:01', '1', '3');
INSERT INTO `apply_for_business` VALUES ('3', '李四', '1', '我想买书啊', '审批合格', '2018-05-09 22:31:23', '2018-05-09 22:32:03', '1', '4');
INSERT INTO `apply_for_business` VALUES ('4', '王五', '1', '买书赚点钱', '审批合格', '2018-05-09 22:33:49', '2018-05-10 00:13:48', '1', '5');
INSERT INTO `apply_for_business` VALUES ('5', '何晓波', '1', '书籍太多，买点书', '审批合格', '2018-05-12 14:27:28', '2018-05-14 11:38:08', '1', '2');
INSERT INTO `apply_for_business` VALUES ('6', '赵六', '2', '我的二手书籍太多，扔了很可以。', '理由不充分', '2018-05-15 10:13:11', '2018-05-16 16:25:33', '0', '6');
INSERT INTO `apply_for_business` VALUES ('7', '赵六', '1', '求你同意', '审批合格', '2018-05-16 16:25:53', '2018-05-16 16:26:20', '1', '6');

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
  `book_price` decimal(6,2) DEFAULT NULL COMMENT '书籍价格',
  `book_save` smallint(4) unsigned DEFAULT NULL COMMENT '书籍剩货',
  `book_introduction` varchar(200) DEFAULT NULL COMMENT '书籍简介 50字以内',
  `img_url` varchar(255) DEFAULT NULL COMMENT '书籍图片保存路径',
  `book_variety_id` int(10) DEFAULT NULL COMMENT '所属书籍分类的id',
  `user_id` int(10) DEFAULT NULL COMMENT '所属用户的id',
  `book_status` smallint(1) DEFAULT NULL COMMENT '书籍状态 0-下架 1-上架',
  `book_create_time` datetime DEFAULT NULL COMMENT '书籍信息创建时间',
  `book_modified_time` datetime DEFAULT NULL COMMENT '书籍信息最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('1', '语文', '12.50', '2', '语文好', null, '3', '2', '2', '2018-05-15 09:35:09', '2018-05-16 14:28:29');
INSERT INTO `book_info` VALUES ('2', '数学', '22.50', '3', '数学好', null, '2', '2', '2', '2018-05-14 09:35:14', '2018-05-16 14:28:32');
INSERT INTO `book_info` VALUES ('3', '大学物理', '10.00', '1', '书籍还很新，笔记很全', '1526451117685u=695030613,2996189730&fm=27&gp=0.jpg', '2', '2', '1', '2018-05-16 14:11:57', '2018-05-17 16:41:14');
INSERT INTO `book_info` VALUES ('4', '大二大学英语', '5.50', '2', '基本没用，九成新,这个书还是很好的，你们可以买来用用哦', '1526451614955u=139016090,3804572485&fm=27&gp=0.jpg', '5', '2', '1', '2018-05-16 14:20:14', '2018-05-17 21:10:39');
INSERT INTO `book_info` VALUES ('5', '政治', '5.00', '1', '书很好', '1526452044395u=1761062654,2971595755&fm=11&gp=0.jpg', '4', '2', '1', '2018-05-16 14:27:24', '2018-05-17 16:41:18');
INSERT INTO `book_info` VALUES ('6', '微机原理', '13.00', '2', '知识点很难，但是我有笔记哦', '1526452152905u=3782262943,2722867756&fm=27&gp=0.jpg', '6', '2', '1', '2018-05-16 14:29:12', '2018-05-17 16:41:19');
INSERT INTO `book_info` VALUES ('7', 'java', '12.00', '2', 'java好啊', '1526452177294u=2052551378,1344131592&fm=27&gp=0.jpg', '6', '2', '1', '2018-05-16 14:29:37', '2018-05-17 16:41:21');
INSERT INTO `book_info` VALUES ('13', '大学物理', '12.00', '1', '撒地方', '1526453181256u=173320731,1177624536&fm=27&gp=0.jpg', '2', '3', '1', '2018-05-16 14:46:21', '2018-05-17 16:43:25');
INSERT INTO `book_info` VALUES ('20', '操作系统', '22.00', '2', '操作系统很牛逼哦', '1526455452723下载 (6).jpg', '6', '2', '1', '2018-05-16 15:24:12', '2018-05-16 21:13:10');
INSERT INTO `book_info` VALUES ('21', '音乐', null, null, '', '1526456976221u=993909324,2902327909&fm=27&gp=0.jpg', '0', '2', '2', '2018-05-16 15:49:36', '2018-05-16 15:52:56');
INSERT INTO `book_info` VALUES ('22', '发', null, null, '', '1526457158526u=218266674,542264134&fm=27&gp=0.jpg', '1', '2', '2', '2018-05-16 15:52:38', '2018-05-16 15:52:51');
INSERT INTO `book_info` VALUES ('23', 'C++', '11.00', '2', '这本书基本没用 所以很新', '1526459033270u=4294542727,3165775722&fm=27&gp=0.jpg', '6', '2', '1', '2018-05-16 16:23:53', '2018-05-16 21:13:04');
INSERT INTO `book_info` VALUES ('24', '哈哈', '22.00', '1', '花费是否', '1526459204512u=176785729,1974911395&fm=27&gp=0.jpg', '6', '6', '0', '2018-05-16 16:26:44', '2018-05-16 16:26:44');
INSERT INTO `book_info` VALUES ('25', 'fs', '1.00', '1', 'sf', '1526459360468u=934494229,462006115&fm=27&gp=0.jpg', '5', '2', '2', '2018-05-16 16:29:20', '2018-05-16 16:29:27');
INSERT INTO `book_info` VALUES ('26', '大丰收', '11.00', '2', '个施工个', '1526478852110u=505983834,183348478&fm=27&gp=0.jpg', '5', '2', '2', '2018-05-16 21:54:12', '2018-05-17 10:57:04');
INSERT INTO `book_info` VALUES ('27', 'ASP.NET动态网站开发教程', '23.00', '2', '沙发', '1526525967777u=431658770,204075981&fm=72.jpg', '2', '2', '1', '2018-05-17 10:59:27', '2018-05-17 16:46:26');
INSERT INTO `book_info` VALUES ('28', '软件测试', '452.88', '2', '这是个好东西', '1526526323192u=173320731,1177624536&fm=27&gp=0.jpg', '6', '2', '0', '2018-05-17 11:05:23', '2018-05-17 16:48:33');
INSERT INTO `book_info` VALUES ('29', 'Android应用程序设计', '12.00', '2', '清华大学出版社，8分新', '15265466638485882b2b7d0a20cf40262fe157f094b36adaf990d.jpg', '6', '3', '1', '2018-05-17 16:44:23', '2018-05-17 16:44:28');
INSERT INTO `book_info` VALUES ('30', 'JSP实用编程', '12.50', '1', '很多笔记，很好', '152654673450610dfa9ec8a1363271f2f52f9988fa0ec09fac73e.jpg', '6', '3', '1', '2018-05-17 16:45:34', '2018-05-17 16:45:41');

-- ----------------------------
-- Table structure for book_order
-- ----------------------------
DROP TABLE IF EXISTS `book_order`;
CREATE TABLE `book_order` (
  `id` int(10) NOT NULL,
  `seller_id` int(10) NOT NULL COMMENT '卖家用户的id',
  `buyers_id` int(10) NOT NULL COMMENT '买家用户的id',
  `book_id` int(10) NOT NULL COMMENT '售卖书籍的id',
  `order_create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `order_modified_time` datetime DEFAULT NULL COMMENT '订单最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_order
-- ----------------------------

-- ----------------------------
-- Table structure for book_variety
-- ----------------------------
DROP TABLE IF EXISTS `book_variety`;
CREATE TABLE `book_variety` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `book_type_name` varchar(20) DEFAULT NULL COMMENT '书籍种类名称',
  `book_type_introduce` varchar(255) DEFAULT NULL COMMENT '书籍种类介绍',
  `book_type_create_time` datetime DEFAULT NULL COMMENT '书籍种类创建时间',
  `book_type_modified_time` datetime DEFAULT NULL COMMENT '书籍种类最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_variety
-- ----------------------------
INSERT INTO `book_variety` VALUES ('1', '其它', '不明确书籍的分类', '2018-05-09 22:57:33', '2018-05-09 23:46:45');
INSERT INTO `book_variety` VALUES ('2', '理工类', '高数，物理，化学等', '2018-05-10 00:17:15', '2018-05-10 00:17:38');
INSERT INTO `book_variety` VALUES ('3', '文学类', '语文，旅游等', '2018-05-10 00:19:39', '2018-05-15 17:05:43');
INSERT INTO `book_variety` VALUES ('4', '社会类', '政治，科学等', '2018-05-10 00:28:23', '2018-05-10 00:28:44');
INSERT INTO `book_variety` VALUES ('5', '外语类', '英语，法语等', '2018-05-14 18:57:22', '2018-05-14 18:57:22');
INSERT INTO `book_variety` VALUES ('6', '计算机类', 'java，c等', '2018-05-16 16:09:23', '2018-05-16 16:09:23');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '管理员', '58ecf8ba26e7571eaa4b7d7b82ee2d4d', '5xyil3i9', '0', '0', '2018-05-06 13:53:25', null, '2018-05-06 13:53:25', '1', null, null);
INSERT INTO `user` VALUES ('2', 'hxb1', '何晓波', 'dfeae316a575213f716d24e345d76c37', '4sjulgs1', '1', '1', '2018-05-09 22:29:40', '2018-05-14 11:38:08', '2018-05-15 17:06:25', '1', '我的学号是?', '14101020105');
INSERT INTO `user` VALUES ('3', 'hxb2', '张三', 'e691b1667cc9c734c381957d20d31f53', '8jygt00s', '1', '1', '2018-05-09 22:29:54', '2018-05-09 22:32:01', '2018-05-09 22:30:45', '1', null, null);
INSERT INTO `user` VALUES ('4', 'hxb3', '李四', '7c4d93b28ce62969c8c332a6c09678f8', '8bw4wfz5', '1', '1', '2018-05-09 22:30:00', '2018-05-09 22:32:03', '2018-05-14 21:04:15', '1', null, null);
INSERT INTO `user` VALUES ('5', 'hxb4', '王五', '5461a744f5117cb16229f03d14552a95', '1r8c2kwx', '1', '1', '2018-05-09 22:33:12', '2018-05-10 00:13:48', '2018-05-09 22:33:36', '1', null, null);
INSERT INTO `user` VALUES ('6', 'hxb5', '赵六', '94f851658b87d08ceb3daeef2905033a', 'gn4tvfbu', '1', '1', '2018-05-15 10:12:16', '2018-05-16 16:26:20', '2018-05-17 17:45:10', '1', null, null);
