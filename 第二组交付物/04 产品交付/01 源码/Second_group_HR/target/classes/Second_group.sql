/*
Navicat MySQL Data Transfer

Source Server         : walense
Source Server Version : 50725
Source Host           : 47.107.71.85 :3306
Source Database       : Second_group

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-06-01 14:59:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ann`
-- ----------------------------
DROP TABLE IF EXISTS `ann`;
CREATE TABLE `ann` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `annName` varchar(15) DEFAULT NULL,
  `annContext` varchar(200) DEFAULT NULL,
  `announcer` varchar(15) DEFAULT NULL,
  `annTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ann
-- ----------------------------
INSERT INTO `ann` VALUES ('3', '修改名称', '修改', '高伟麟', '2019-05-31');
INSERT INTO `ann` VALUES ('4', 'qweqwe', 'qwqwtqwt', '高伟麟', '2019-05-31');

-- ----------------------------
-- Table structure for `filedownload`
-- ----------------------------
DROP TABLE IF EXISTS `filedownload`;
CREATE TABLE `filedownload` (
  `fid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `Creation_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) DEFAULT NULL COMMENT '描述',
  `Founder` varchar(255) DEFAULT NULL COMMENT '创建人',
  `operation` varchar(255) DEFAULT NULL COMMENT '操作',
  `download` varchar(255) DEFAULT NULL COMMENT '下载文档',
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filedownload
-- ----------------------------
INSERT INTO `filedownload` VALUES ('00000000009', '4', '2019-05-24 08:54:36.000000', '1', '2', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000011', '4', '2019-05-24 08:54:36.000000', '1', '2', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000014', '1', '2019-05-27 16:46:06.000000', null, 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000015', '1', '2019-05-27 16:46:52.000000', null, 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000016', '1', '2019-05-27 16:47:57.000000', null, '1', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000017', '1', '2019-05-27 16:48:55.000000', null, '1', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000018', '1', '2019-05-27 17:07:46.000000', '1', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000019', '1', '2019-05-27 17:09:39.000000', '1', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000020', '', '2019-05-27 17:43:43.000000', '', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000021', '', '2019-05-27 17:56:50.000000', '', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000022', '这是标题', '2019-05-31 10:10:56.718000', '这是描述', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000023', '', '2019-05-31 10:34:56.351000', '', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000024', '', '2019-05-31 10:35:03.124000', '', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000025', '', '2019-05-31 10:53:35.083000', '', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000026', 'rqwrqwr', '2019-05-31 10:59:05.868000', 'qwrqw', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000027', '', '2019-05-31 11:01:31.431000', '', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000028', 'qweqwe', '2019-05-31 11:03:25.129000', 'wtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwtwtqwtqwt', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000029', 'qweqwe', '2019-05-31 11:06:28.544000', 'qwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwtqwrqwtqwt', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000030', '1', '2019-05-31 11:08:16.086000', 'asdasafwfawgagawgasdasafwfawgagawgasdasafwfawgagawgasdasafwfawgagawgasdasafwfawgagawgasdasafwfawgagawgasdasafwfawgagawg', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');
INSERT INTO `filedownload` VALUES ('00000000031', 'qwqwt', '2019-05-31 11:56:25.702000', 'qwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwtqwt', 'yx', '<img  src=\"js/imgs/modi.png\" />', '<img  src=\"js/imgs/1.png\" />');

-- ----------------------------
-- Table structure for `first_menu`
-- ----------------------------
DROP TABLE IF EXISTS `first_menu`;
CREATE TABLE `first_menu` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of first_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `four`
-- ----------------------------
DROP TABLE IF EXISTS `four`;
CREATE TABLE `four` (
  `uid` int(66) NOT NULL AUTO_INCREMENT,
  `uname` varchar(66) CHARACTER SET utf8 DEFAULT NULL,
  `usname` varchar(66) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of four
-- ----------------------------
INSERT INTO `four` VALUES ('1', '总经理', '总经理');
INSERT INTO `four` VALUES ('2', '组长', '组长');
INSERT INTO `four` VALUES ('4', '项目部经理', '项目部经理');
INSERT INTO `four` VALUES ('6', '教育部经理', '教育部经理');
INSERT INTO `four` VALUES ('7', '人事部经理', '人事部经理');
INSERT INTO `four` VALUES ('8', '后勤部经理', '后勤部经理');
INSERT INTO `four` VALUES ('9', '保卫处经理', '保卫处经理');
INSERT INTO `four` VALUES ('11', '教育部员工', '教育部员工');
INSERT INTO `four` VALUES ('12', '人事部员工', '人事部员工');
INSERT INTO `four` VALUES ('13', '保卫处员工', '保卫处员工');

-- ----------------------------
-- Table structure for `information_yuangong`
-- ----------------------------
DROP TABLE IF EXISTS `information_yuangong`;
CREATE TABLE `information_yuangong` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `shouji` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `youxiang` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `zhiwei` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `xueli` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `shenfenzheng` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `bumen` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `lianxidizhi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `jiandangriqi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `chushengriqi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `minzu` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `youzhengbianma` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `qq` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `zhengzhimianmao` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dianhua` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of information_yuangong
-- ----------------------------
INSERT INTO `information_yuangong` VALUES ('1', '张已', '女', '15736038780', '1776528104@qq.com', '总经理', '本科', '500239199710133710', '技术部', '万州', '209.12.10', '1997.10.13', '汉', '49006', '1776528104', '群众', '17708379539');
INSERT INTO `information_yuangong` VALUES ('2', '张二', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');
INSERT INTO `information_yuangong` VALUES ('3', '杨已', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');
INSERT INTO `information_yuangong` VALUES ('4', '杨二', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');
INSERT INTO `information_yuangong` VALUES ('5', '杨三', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');
INSERT INTO `information_yuangong` VALUES ('6', '杨四', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');
INSERT INTO `information_yuangong` VALUES ('7', '杨无', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');
INSERT INTO `information_yuangong` VALUES ('8', '杨其', '男', '15736038780', '1776528104@qq.com', '职员', '本科', '500239199610133710', '技术部', '万州', '2019年4月23日', '1997.10.13', '汉族', '409006', '1776528104', '团员', '17708379539');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `loginname` char(18) NOT NULL,
  `password` char(18) NOT NULL,
  `power` int(1) NOT NULL,
  PRIMARY KEY (`loginname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '2', '1');

-- ----------------------------
-- Table structure for `menu_tree`
-- ----------------------------
DROP TABLE IF EXISTS `menu_tree`;
CREATE TABLE `menu_tree` (
  `order` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增长',
  `id` int(11) NOT NULL,
  `text` char(255) NOT NULL,
  `state` char(5) DEFAULT NULL,
  `chechked` char(5) DEFAULT NULL,
  `attributes` char(255) DEFAULT NULL,
  `children` int(11) unsigned zerofill NOT NULL,
  PRIMARY KEY (`order`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_tree
-- ----------------------------
INSERT INTO `menu_tree` VALUES ('1', '0', '下载中心', null, null, '', '00000000001');
INSERT INTO `menu_tree` VALUES ('2', '0', '用户管理', null, null, '', '00000000002');
INSERT INTO `menu_tree` VALUES ('3', '0', '部门管理', null, null, null, '00000000003');
INSERT INTO `menu_tree` VALUES ('4', '0', '职位管理', null, null, null, '00000000004');
INSERT INTO `menu_tree` VALUES ('5', '0', '公告管理', null, null, null, '00000000005');
INSERT INTO `menu_tree` VALUES ('6', '0', '员工管理', null, null, null, '00000000006');
INSERT INTO `menu_tree` VALUES ('10', '1', '文档查询', null, null, '{\"menupath\":\"wdcx.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('11', '1', '文档上传', null, null, '{\"menupath\":\"wdsc.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('12', '2', '用户查询', null, null, '{\"menupath\":\"yhcx.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('13', '2', '添加用户', null, null, '{\"menupath\":\"tjyh.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('14', '3', '部门查询', null, null, '{\"menupath\":\"bmcx.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('15', '3', '添加部门', null, null, '{\"menupath\":\"tjbm.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('16', '4', '职位查询', null, null, '{\"menupath\":\"zwcx.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('17', '4', '添加职位', null, null, '{\"menupath\":\"tjzw.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('18', '6', '员工查询', null, null, '{\"menupath\":\"ygcx.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('19', '6', '添加员工', null, null, '{\"menupath\":\"tjyg.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('20', '5', '公告查询', null, null, '{\"menupath\":\"ggcx.jsp\"}', '00000000000');
INSERT INTO `menu_tree` VALUES ('21', '5', '添加公告', null, null, '{\"menupath\":\"tjgg.jsp\"}', '00000000000');

-- ----------------------------
-- Table structure for `second_menu`
-- ----------------------------
DROP TABLE IF EXISTS `second_menu`;
CREATE TABLE `second_menu` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `spath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  KEY `pid` (`pid`) USING BTREE,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `first_menu` (`fid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `three`
-- ----------------------------
DROP TABLE IF EXISTS `three`;
CREATE TABLE `three` (
  `uid` int(3) NOT NULL AUTO_INCREMENT,
  `uname` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `usname` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of three
-- ----------------------------
INSERT INTO `three` VALUES ('1', '党委办', '党委办');
INSERT INTO `three` VALUES ('2', '安全部', '安全部');
INSERT INTO `three` VALUES ('3', '监察部', '监察部');
INSERT INTO `three` VALUES ('4', '董事会', '董事会');
INSERT INTO `three` VALUES ('5', '服务部', '服务部');
INSERT INTO `three` VALUES ('6', '项目部', '项目部');
INSERT INTO `three` VALUES ('7', '运营部', '运营部');
INSERT INTO `three` VALUES ('8', '总监办', '总监办');
INSERT INTO `three` VALUES ('9', '人事部', '人事部');
INSERT INTO `three` VALUES ('10', '宣传部', '宣传部');
INSERT INTO `three` VALUES ('11', '财务部', '财务部');
INSERT INTO `three` VALUES ('12', '卫生部', '卫生部');
INSERT INTO `three` VALUES ('13', '经营部', '经营部');
INSERT INTO `three` VALUES ('14', '后勤部', '后勤部');
INSERT INTO `three` VALUES ('15', '保卫部', '保卫部');
INSERT INTO `three` VALUES ('65', 'dfff', '啊是大');
INSERT INTO `three` VALUES ('66', '运营部', '你好');
INSERT INTO `three` VALUES ('67', '440啊', '123');
INSERT INTO `three` VALUES ('68', 'as', 'ag');
INSERT INTO `three` VALUES ('69', 'asg', 'asg');
INSERT INTO `three` VALUES ('70', 'qwe', 'etwet');
INSERT INTO `three` VALUES ('71', 'qw', 'qwr');
INSERT INTO `three` VALUES ('72', '123', '440啊');
INSERT INTO `three` VALUES ('73', '12345', '123456');
INSERT INTO `three` VALUES ('74', '按时的新啊', '123456');

-- ----------------------------
-- Table structure for `yuxin`
-- ----------------------------
DROP TABLE IF EXISTS `yuxin`;
CREATE TABLE `yuxin` (
  `username` char(16) NOT NULL,
  `password` char(16) NOT NULL,
  `pwer` int(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yuxin
-- ----------------------------
INSERT INTO `yuxin` VALUES ('111', '111', '1');
INSERT INTO `yuxin` VALUES ('123', '123', '1');
INSERT INTO `yuxin` VALUES ('123456', '123456', '1');
INSERT INTO `yuxin` VALUES ('123456789', '123456789', '2');
INSERT INTO `yuxin` VALUES ('147258', '147258', '1');
INSERT INTO `yuxin` VALUES ('2222', '2222', '1');
INSERT INTO `yuxin` VALUES ('321', '321', '1');
INSERT INTO `yuxin` VALUES ('987410', '987410.', '1');
