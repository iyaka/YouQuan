/*
Navicat MySQL Data Transfer

Source Server         : youquan
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : nature

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-12 09:43:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` varchar(120) NOT NULL COMMENT '主键ID',
  `ACCOUNT` varchar(255) NOT NULL COMMENT '账号',
  `PASSWORD` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `NAME` varchar(255) NOT NULL COMMENT '用户名',
  `PHONE` varchar(20) NOT NULL COMMENT '手机号',
  `SEX` int(11) NOT NULL DEFAULT '0' COMMENT '性别（0男，1女）',
  `INTRODUCTION` varchar(500) DEFAULT NULL COMMENT '介绍',
  `BIRTHDAY` date DEFAULT NULL COMMENT '生日',
  `PHOTO` varchar(255) DEFAULT NULL COMMENT '照片地址',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `LOVE` int(11) DEFAULT '0' COMMENT '关注数',
  `LOVED` int(11) DEFAULT '0' COMMENT '被关注数',
  `TYPE` int(11) DEFAULT '0' COMMENT '账户类型(0表示用户，1表示圈子)',
  `STATUS` int(11) DEFAULT '0' COMMENT '状态(0表示正常，1表示封号)',
  `OFFICAL` int(11) DEFAULT '0' COMMENT '是否官方认证(0表示未认证，1表示认证通过)',
  `DEVICE_NO` varchar(255) DEFAULT NULL COMMENT '登录设备号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1520834703', 'yangkui', '123456', '杨奎', '18201488787', '0', '你从未顾及我的感受又怎知我难受。', '2018-03-12', 'http://192.168.100.212:8080/res/picture/me_b.jpg', '2018-03-15 10:09:03', '1', '1', '0', '0', '1', '1232312312312');
INSERT INTO `account` VALUES ('1521016352', 'youquan', '123456', '有圈', '18718281182', '0', '在这您可以与同学、同事、家人、好友，分享生活中的点点滴滴。赶快与朋友来体验一下吧！', '2018-03-14', 'http://192.168.100.212:8080/res/picture/a.jpeg', '2018-03-15 18:11:39', '0', '3', '1', '0', '1', null);
INSERT INTO `account` VALUES ('1521019344', 'zhongxinwang', '123456', '中新网', '15611012829', '0', '中国新闻网简称中新网，由中国新闻社主办。', '2018-03-14', 'http://192.168.100.212:8080/res/picture/e.jpeg', '2018-03-14 18:06:55', '0', '1', '1', '0', '1', null);
INSERT INTO `account` VALUES ('1521021154', 'ceshi', '123456', '测试', '15121938123', '1', '\r\n真理惟一可靠的标准就是永远自相符合。', '2018-03-14', 'http://192.168.100.212:8080/res/picture/me_a.jpg', '2018-03-15 10:09:11', '3', '0', '0', '0', '1', '8239230493022');
INSERT INTO `account` VALUES ('1521079761', 'zhangsan', '123456', '张三', '13291738292', '1', '时间是一切财富中最宝贵的财富。', '2018-03-15', 'http://192.168.100.212:8080/res/picture/me_c.jpg', '2018-03-15 10:12:13', '1', '0', '0', '0', '1', '8793732399238');

-- ----------------------------
-- Table structure for action_log
-- ----------------------------
DROP TABLE IF EXISTS `action_log`;
CREATE TABLE `action_log` (
  `ID` varchar(255) NOT NULL COMMENT '主键ID',
  `USE_ID` varchar(255) NOT NULL COMMENT '使用ID',
  `USED_ID` varchar(255) NOT NULL COMMENT '被使用ID',
  `ACTION_ID` varchar(255) NOT NULL COMMENT '行为ID',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action_log
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` varchar(255) NOT NULL COMMENT '主键ID',
  `CONTENT` varchar(1000) DEFAULT NULL COMMENT '评论内容',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `LAUD` int(11) DEFAULT '0' COMMENT '点赞数',
  `ESSAY_ID` varchar(255) NOT NULL COMMENT '所属帖子',
  `COMMENT_ID` varchar(255) NOT NULL COMMENT '评论上级ID（为空表示属于帖子）',
  PRIMARY KEY (`ID`),
  KEY `文章ID` (`ESSAY_ID`),
  KEY `评论ID` (`COMMENT_ID`),
  CONSTRAINT `文章ID` FOREIGN KEY (`ESSAY_ID`) REFERENCES `essay` (`ID`),
  CONSTRAINT `评论ID` FOREIGN KEY (`COMMENT_ID`) REFERENCES `comment` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for essay
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `ID` varchar(255) NOT NULL,
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '文字内容',
  `PICTURE` varchar(255) DEFAULT NULL COMMENT '图片地址（逗号隔开，被删除为问号）',
  `VIDEO` varchar(255) DEFAULT NULL COMMENT '视频地址',
  `LAUD` int(11) DEFAULT '0' COMMENT '点赞数',
  `COMMENT` int(11) DEFAULT '0' COMMENT '评论数',
  `FORWORD` int(11) DEFAULT '0' COMMENT '评论数',
  `LNG` double DEFAULT NULL COMMENT '经度',
  `LAT` double DEFAULT NULL COMMENT '纬度',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '位置',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `TRANSMIT` int(11) DEFAULT '0' COMMENT '是否属于转发(0非转发，1转发)',
  `TRANSMIT_URL` varchar(255) DEFAULT NULL COMMENT '转发地址',
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '属于用户ID',
  `GAM_ID` varchar(255) DEFAULT NULL COMMENT '所属帖子ID',
  PRIMARY KEY (`ID`),
  KEY `账户ID` (`USER_ID`),
  KEY `所属圈子ID` (`GAM_ID`),
  CONSTRAINT `所属圈子ID` FOREIGN KEY (`GAM_ID`) REFERENCES `account` (`ID`),
  CONSTRAINT `账户ID` FOREIGN KEY (`USER_ID`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essay
-- ----------------------------
INSERT INTO `essay` VALUES ('1521019891', '马云无人零售店横空出世 你必须知道这些', 'http://192.168.100.212:8080/res/picture/b.jpeg', null, '0', '0', '0', '116.490423', '39.971113', '酒仙桥街道', '2018-03-14 17:59:06', '0', null, '1520834703', '1521016352');
INSERT INTO `essay` VALUES ('1521021461', '中国是最早发现、命名南沙群岛，最早并持续对南沙群岛行使主权管辖的国家。', 'http://192.168.100.212:8080/res/picture/h.jpeg', null, '0', '0', '0', '116.495597', '39.998091', '望京街道', '2018-03-15 10:01:28', '0', null, '1521021154', '1521019344');
INSERT INTO `essay` VALUES ('1521079113', '人民币是中华人民共和国的法定货币，元是它的最基础单位，一百元人民币是人民币的一种面额。在数字前一般加上“¥”表示人民币的金额。市场流通的人民币券（纸币）100元。一百元纸币为最大面额的人民币。', 'http://192.168.100.212:8080/res/picture/i.jpeg', null, '0', '0', '0', '116.465126', '39.939698', '北京工人体育场', '2018-03-15 10:25:24', '0', null, '1521021154', '1521016352');
INSERT INTO `essay` VALUES ('1521080933', '《公共场所控制吸烟条例》是国家卫生计生委的重点立法项目，2014年10月底形成草案送审稿上报国务院。该条例规定所有室内公共场所一律禁止吸烟。', 'http://192.168.100.212:8080/res/picture/c.jpeg', null, '0', '0', '0', '116.419708', '39.91823', '天安门', '2018-03-15 10:32:35', '0', null, '1521079761', '1521016352');
INSERT INTO `essay` VALUES ('1521081345', '冬天,虽然没有春天迷人的鸟语花香,没有夏天壮观的闪电雷鸣,没有秋天诱人的丰硕果实,但它也有献给大自然的含蓄的美', 'http://192.168.100.212:8080/res/picture/d.jpeg,http://192.168.100.212:8080/res/picture/e.jpeg,http://192.168.100.212:8080/res/picture/f.jpeg', null, '0', '0', '0', '116.343819', '39.901848', '北京西站', '2018-03-15 10:36:57', '0', null, '1520834703', '1521016352');

-- ----------------------------
-- Table structure for laud
-- ----------------------------
DROP TABLE IF EXISTS `laud`;
CREATE TABLE `laud` (
  `ID` varchar(255) NOT NULL COMMENT '主键ID',
  `LAUD_ID` varchar(255) DEFAULT NULL COMMENT '点赞ID',
  `LAUDED_ID` varchar(255) DEFAULT NULL COMMENT '被点赞ID',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laud
-- ----------------------------

-- ----------------------------
-- Table structure for love
-- ----------------------------
DROP TABLE IF EXISTS `love`;
CREATE TABLE `love` (
  `ID` varchar(255) NOT NULL COMMENT '主键ID',
  `LOVE_ID` varchar(255) DEFAULT NULL COMMENT '关注ID',
  `LOVED_ID` varchar(255) DEFAULT NULL COMMENT '被关注ID',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`),
  KEY `关注者ID` (`LOVE_ID`),
  KEY `被关注者ID` (`LOVED_ID`),
  CONSTRAINT `关注者ID` FOREIGN KEY (`LOVE_ID`) REFERENCES `account` (`ID`),
  CONSTRAINT `被关注者ID` FOREIGN KEY (`LOVED_ID`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of love
-- ----------------------------
INSERT INTO `love` VALUES ('1521019148', '1520834703', '1521016352', '2018-03-14 17:19:39');
INSERT INTO `love` VALUES ('1521021316', '1521021154', '1520834703', '2018-03-14 17:55:57');
INSERT INTO `love` VALUES ('1521021686', '1521021154', '1521016352', '2018-03-14 18:01:53');
INSERT INTO `love` VALUES ('1521021735', '1521021154', '1521019344', '2018-03-14 18:02:28');
INSERT INTO `love` VALUES ('1521079940', '1521079761', '1521016352', '2018-03-15 10:13:11');
