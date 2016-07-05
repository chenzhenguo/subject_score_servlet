/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : score

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2016-05-31 17:27:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1', ' 成都', '1');
INSERT INTO `t_city` VALUES ('2', '内江', '1');
INSERT INTO `t_city` VALUES ('3', '资阳', '1');
INSERT INTO `t_city` VALUES ('4', '达州', '1');
INSERT INTO `t_city` VALUES ('5', '广安', '1');
INSERT INTO `t_city` VALUES ('6', '绵阳', '1');
INSERT INTO `t_city` VALUES ('7', '长沙', '2');
INSERT INTO `t_city` VALUES ('8', '常德', '2');
INSERT INTO `t_city` VALUES ('9', '湘潭', '2');
INSERT INTO `t_city` VALUES ('10', '株洲', '2');
INSERT INTO `t_city` VALUES ('11', '郴州', '2');
INSERT INTO `t_city` VALUES ('12', '岳阳', '2');
INSERT INTO `t_city` VALUES ('13', '怀化', '2');
INSERT INTO `t_city` VALUES ('14', '济南', '3');
INSERT INTO `t_city` VALUES ('15', '青岛', '3');
INSERT INTO `t_city` VALUES ('16', '烟台', '3');
INSERT INTO `t_city` VALUES ('17', '菏泽', '3');
INSERT INTO `t_city` VALUES ('18', '日照', '3');
INSERT INTO `t_city` VALUES ('19', '德州', '3');
INSERT INTO `t_city` VALUES ('20', '武汉', '4');
INSERT INTO `t_city` VALUES ('21', '宜昌', '4');
INSERT INTO `t_city` VALUES ('22', '孝感', '4');
INSERT INTO `t_city` VALUES ('23', '十堰', '4');
INSERT INTO `t_city` VALUES ('24', '襄阳', '4');
INSERT INTO `t_city` VALUES ('25', '南京', '5');
INSERT INTO `t_city` VALUES ('26', '苏州', '5');
INSERT INTO `t_city` VALUES ('27', '常州', '5');
INSERT INTO `t_city` VALUES ('28', '昆山', '5');
INSERT INTO `t_city` VALUES ('29', '无锡', '5');

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` varchar(20) CHARACTER SET utf8 NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `type` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `openTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('20160301001001', 'java1班', 'java', '2016-03-01');
INSERT INTO `t_class` VALUES ('20160301001002', 'java2班', 'java', '2016-03-01');
INSERT INTO `t_class` VALUES ('20160301001003', 'java3班', 'java', '2016-03-01');
INSERT INTO `t_class` VALUES ('20160301002001', '大数据1班', '大数据', '2016-03-01');
INSERT INTO `t_class` VALUES ('20160308003001', '安卓1班', '安卓班', '2016-03-08');

-- ----------------------------
-- Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `manager` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '教务处', '东方不败');
INSERT INTO `t_dept` VALUES ('2', '教学部', '岳不群');

-- ----------------------------
-- Table structure for `t_points`
-- ----------------------------
DROP TABLE IF EXISTS `t_points`;
CREATE TABLE `t_points` (
  `sid` int(15) NOT NULL,
  `score` int(10) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_points
-- ----------------------------
INSERT INTO `t_points` VALUES ('93', '100');
INSERT INTO `t_points` VALUES ('94', '100');
INSERT INTO `t_points` VALUES ('95', '100');
INSERT INTO `t_points` VALUES ('96', '100');
INSERT INTO `t_points` VALUES ('97', '100');
INSERT INTO `t_points` VALUES ('98', '100');
INSERT INTO `t_points` VALUES ('99', '90');
INSERT INTO `t_points` VALUES ('100', '82');
INSERT INTO `t_points` VALUES ('101', '95');
INSERT INTO `t_points` VALUES ('102', '100');
INSERT INTO `t_points` VALUES ('103', '100');
INSERT INTO `t_points` VALUES ('104', '100');
INSERT INTO `t_points` VALUES ('105', '100');
INSERT INTO `t_points` VALUES ('106', '100');
INSERT INTO `t_points` VALUES ('107', '90');
INSERT INTO `t_points` VALUES ('108', '100');
INSERT INTO `t_points` VALUES ('109', '100');
INSERT INTO `t_points` VALUES ('110', '100');
INSERT INTO `t_points` VALUES ('111', '100');
INSERT INTO `t_points` VALUES ('112', '100');
INSERT INTO `t_points` VALUES ('113', '100');
INSERT INTO `t_points` VALUES ('114', '100');
INSERT INTO `t_points` VALUES ('115', '100');
INSERT INTO `t_points` VALUES ('116', '100');

-- ----------------------------
-- Table structure for `t_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_position
-- ----------------------------
INSERT INTO `t_position` VALUES ('1', '教学部部长');
INSERT INTO `t_position` VALUES ('2', '年级长');
INSERT INTO `t_position` VALUES ('3', '教师');

-- ----------------------------
-- Table structure for `t_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES ('1', '四川省');
INSERT INTO `t_province` VALUES ('2', '湖南省');
INSERT INTO `t_province` VALUES ('3', '山东省');
INSERT INTO `t_province` VALUES ('4', '湖北省');
INSERT INTO `t_province` VALUES ('5', '江苏省');

-- ----------------------------
-- Table structure for `t_reason`
-- ----------------------------
DROP TABLE IF EXISTS `t_reason`;
CREATE TABLE `t_reason` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_reason
-- ----------------------------
INSERT INTO `t_reason` VALUES ('1', '迟到', '-5');
INSERT INTO `t_reason` VALUES ('2', '旷课', '-10');
INSERT INTO `t_reason` VALUES ('3', '早退', '-5');
INSERT INTO `t_reason` VALUES ('4', '未完成作业', '-8');

-- ----------------------------
-- Table structure for `t_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `sid` int(20) DEFAULT NULL,
  `reasonId` int(50) DEFAULT NULL,
  `tid` int(10) DEFAULT NULL,
  `operateTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES ('1', '100', '2', '1', '2016-05-27');
INSERT INTO `t_record` VALUES ('2', '101', '3', '1', '2016-05-25');
INSERT INTO `t_record` VALUES ('3', '99', '1', '2', '2016-05-02');
INSERT INTO `t_record` VALUES ('4', '107', '2', '1', '2016-03-11');
INSERT INTO `t_record` VALUES ('5', '99', '3', '3', '2016-05-17');
INSERT INTO `t_record` VALUES ('6', '100', '4', '1', '2016-05-26');

-- ----------------------------
-- Table structure for `t_status`
-- ----------------------------
DROP TABLE IF EXISTS `t_status`;
CREATE TABLE `t_status` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_status
-- ----------------------------
INSERT INTO `t_status` VALUES ('1', '在读');
INSERT INTO `t_status` VALUES ('2', '留级');
INSERT INTO `t_status` VALUES ('3', '退学');
INSERT INTO `t_status` VALUES ('4', '就业');
INSERT INTO `t_status` VALUES ('5', '休学');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(5) DEFAULT NULL,
  `statusId` int(20) DEFAULT NULL,
  `idCard` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `mayor` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `education` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `school` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `hireDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('93', '草小鸟', '20', '1', '2', '41032819959819', '15935095844', '电子', '大学', '美大', '周口', '2012-12-02');
INSERT INTO `t_student` VALUES ('94', '李四', '21', '1', '3', '41032819959819', '15935095844', '土木', '小学', '复旦', '北京', '2012-12-03');
INSERT INTO `t_student` VALUES ('95', '王五', '22', '0', '2', '41032819959819', '15935095844', '大众', '小学', '河大', '河南', '2012-12-04');
INSERT INTO `t_student` VALUES ('96', '张三风 ', '23', '1', '2', '41032819959819', '15935095844', '电子', '小学', '电大', '山西', '2012-12-05');
INSERT INTO `t_student` VALUES ('97', '王二蛋', '24', '1', '3', '41032819959819', '15935095844', '土木', '大学', '郑大', '上海', '2012-12-06');
INSERT INTO `t_student` VALUES ('98', '城池', '25', '1', '3', '41032819959819', '15935095844', '电子', '大学', '电大', '山西', '2012-12-07');
INSERT INTO `t_student` VALUES ('99', '画画', '26', '0', '2', '41032819959819', '15935095844', '传媒', '大学', '北电', '北京', '2012-12-08');
INSERT INTO `t_student` VALUES ('100', '李梅', '27', '0', '2', '41032819959819', '15935095844', '传媒', '大学', '北电', '上海', '2012-12-09');
INSERT INTO `t_student` VALUES ('101', '张刚', '28', '1', '3', '41032819959819', '15935095844', '大众', '小学', '电大', '山西', '2012-12-10');
INSERT INTO `t_student` VALUES ('102', '娜娜', '29', '0', '3', '41032819959819', '15935095844', '电子', '大学', '洛大', '上海', '2012-12-11');
INSERT INTO `t_student` VALUES ('103', '小章', '30', '1', '3', '41032819959819', '15935095844', '电子', '大学', '北电', '山西', '2012-12-12');
INSERT INTO `t_student` VALUES ('107', '昂昂', '34', '0', '2', '41032819959819', '15935095844', '机械', '大学', '北大', '北京', '2012-12-16');
INSERT INTO `t_student` VALUES ('108', '大鸟', '35', '1', '2', '41032819959819', '15935095844', '机械', '大学', '北大', '北京', '2012-12-17');
INSERT INTO `t_student` VALUES ('109', '草大棚', '36', '1', '3', '41032819959819', '15935095844', '软件', '大学', '洛大', '上海', '2012-12-18');
INSERT INTO `t_student` VALUES ('110', '小王', '17', '0', '1', '41032819959819', '15935095844', '软件', '大学', '洛大', '上海', '2012-12-19');
INSERT INTO `t_student` VALUES ('111', '小鹏', '38', '0', '2', '41032819959819', '15935095844', '软件', '大学', '洛大', '上海', '2012-12-20');
INSERT INTO `t_student` VALUES ('113', '夏天', '19', '1', '1', '41032719941413', '15225402467', '软件', '私塾', '郑大', '河南', '2013-12-05');
INSERT INTO `t_student` VALUES ('114', '欢欢', '22', '0', '1', '41089767897356', '15225404987', '会计', '大学', '河科大', '洛阳', '2013-02-19');
INSERT INTO `t_student` VALUES ('115', '千影', '5', '0', '4', '410897678967', '15225408987', '会计', '大学', '北大', '上海', '2013-02-22');
INSERT INTO `t_student` VALUES ('116', '俊俊', '22', '0', '4', '41032871944', '15225404398', '美术', '大学', '复旦', '香港', '2011-01-23');
INSERT INTO `t_student` VALUES ('117', 'ping', '23', '1', '2', '41089998934443', '14599384983', '绘画', '大学', '美院', '南京', '2014-01-07');

-- ----------------------------
-- Table structure for `t_student_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_student_class`;
CREATE TABLE `t_student_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `cid` varchar(10) DEFAULT NULL,
  `regTime` date DEFAULT NULL,
  `exitTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_subject`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('1', 'javase');
INSERT INTO `t_subject` VALUES ('2', 'sql');
INSERT INTO `t_subject` VALUES ('3', 'servlet');
INSERT INTO `t_subject` VALUES ('4', 'mvc');
INSERT INTO `t_subject` VALUES ('5', 'spring');
INSERT INTO `t_subject` VALUES ('6', 'ajax');
INSERT INTO `t_subject` VALUES ('7', 'script');
INSERT INTO `t_subject` VALUES ('8', 'html');
INSERT INTO `t_subject` VALUES ('9', 'session');
INSERT INTO `t_subject` VALUES ('10', 'jason');
INSERT INTO `t_subject` VALUES ('11', 'css');
INSERT INTO `t_subject` VALUES ('12', null);

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sex` int(5) DEFAULT NULL,
  `workAge` int(5) DEFAULT NULL,
  `positionId` int(10) DEFAULT NULL,
  `deptId` int(10) DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `hireDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '马老师', '1', '10', '2', '2', '18766678754', '2006-05-09');
INSERT INTO `t_teacher` VALUES ('2', '赵老师', '1', '8', '1', '1', '18765498765', '2008-01-01');
INSERT INTO `t_teacher` VALUES ('3', '范老师', '0', '6', '3', '2', '17687656789', '2010-01-06');
INSERT INTO `t_teacher` VALUES ('4', '刘老师', '1', '11', '3', '1', '15909435678', '2005-01-06');
INSERT INTO `t_teacher` VALUES ('5', '黄老师', '0', '5', '3', '1', '17689098765', '2008-01-01');

-- ----------------------------
-- Table structure for `t_teacher_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_class`;
CREATE TABLE `t_teacher_class` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `tid` int(15) DEFAULT NULL,
  `cid` varchar(15) DEFAULT NULL,
  `beginTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_teacher_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_teacher_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_student`;
CREATE TABLE `t_teacher_student` (
  `id` int(20) NOT NULL,
  `sid` int(20) DEFAULT NULL,
  `tid` int(20) DEFAULT NULL,
  `subjectId` int(20) DEFAULT NULL,
  `beginTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_teacher_student
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `roleId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `t_user` VALUES ('2', 'cc', 'cc123', '1');
INSERT INTO `t_user` VALUES ('3', '草小鸟', '1111', '2');
INSERT INTO `t_user` VALUES ('4', '李四', '1111', '2');
INSERT INTO `t_user` VALUES ('5', '王五', '1111', '2');
INSERT INTO `t_user` VALUES ('6', '张三风 ', '1111', '2');
INSERT INTO `t_user` VALUES ('7', '王二蛋', '1111', '2');
INSERT INTO `t_user` VALUES ('8', '城池', '1111', '2');
INSERT INTO `t_user` VALUES ('9', '画画', '1111', '2');
INSERT INTO `t_user` VALUES ('10', '李梅', '1111', '2');
INSERT INTO `t_user` VALUES ('11', '张刚', '1111', '2');
INSERT INTO `t_user` VALUES ('12', '娜娜', '1111', '2');
INSERT INTO `t_user` VALUES ('13', '小章', '1111', '2');
INSERT INTO `t_user` VALUES ('14', '王三三', '1111', '2');
INSERT INTO `t_user` VALUES ('15', '张海林', '1111', '2');
INSERT INTO `t_user` VALUES ('16', '小溪', '1111', '2');
INSERT INTO `t_user` VALUES ('17', '昂昂', '1111', '2');
INSERT INTO `t_user` VALUES ('18', '大鸟', '1111', '2');
INSERT INTO `t_user` VALUES ('19', '草大棚', '1111', '2');
INSERT INTO `t_user` VALUES ('20', '小猪猪', '1111', '2');
INSERT INTO `t_user` VALUES ('21', '小鹏', '1111', '2');
INSERT INTO `t_user` VALUES ('22', '小华华', '1111', '2');
INSERT INTO `t_user` VALUES ('23', '夏天', '1111', '2');
INSERT INTO `t_user` VALUES ('24', '欢欢', '1111', '2');
INSERT INTO `t_user` VALUES ('25', '千影', '1111', '2');
INSERT INTO `t_user` VALUES ('26', '俊俊', '1111', '2');
