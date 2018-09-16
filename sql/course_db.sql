/*
Navicat MySQL Data Transfer

Source Server         : jerry
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : course_db

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-06-25 12:02:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category_course
-- ----------------------------
DROP TABLE IF EXISTS `category_course`;
CREATE TABLE `category_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_course
-- ----------------------------
INSERT INTO `category_course` VALUES ('1', '学科基础');
INSERT INTO `category_course` VALUES ('2', '公共基础');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `enroll_year` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '软件技术一班', '2016');
INSERT INTO `class` VALUES ('2', '技术二班', '2017');

-- ----------------------------
-- Table structure for class_student
-- ----------------------------
DROP TABLE IF EXISTS `class_student`;
CREATE TABLE `class_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_class_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `gpa_score` tinyint(4) NOT NULL,
  `paper_score` tinyint(4) NOT NULL,
  `practice_score` tinyint(4) NOT NULL,
  `score` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_student
-- ----------------------------
INSERT INTO `class_student` VALUES ('1', '1', '1', '12', '10', '70', '92');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '流水号（自动增长），主键',
  `ccode` char(6) CHARACTER SET utf8 DEFAULT NULL COMMENT '课程号，唯一',
  `cname` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '课程中文名，唯一',
  `ename` varchar(100) DEFAULT NULL COMMENT '课程英文名，唯一',
  `score` tinyint(3) DEFAULT NULL COMMENT '学分',
  `category` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '理论总学时',
  `tlhour` smallint(5) DEFAULT NULL COMMENT '实验总学时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=780 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '001', '数据库 ', 'math', '7', '学科基础', '1');
INSERT INTO `course` VALUES ('2', '002', '高级语言设计1', 'math', '8', '公共基础', '1');
INSERT INTO `course` VALUES ('3', '003', '高级语言设计2', 'math', '7', '学科基础', '1');
INSERT INTO `course` VALUES ('4', '004', 'C语言', 'asd', '8', '公共基础', '2');
INSERT INTO `course` VALUES ('5', '005', '软件工程导论', 'asd', '7', '学科基础', '2');
INSERT INTO `course` VALUES ('6', '006', '数字逻辑', 'asd', '8', '公共基础', '2');

-- ----------------------------
-- Table structure for course_stu
-- ----------------------------
DROP TABLE IF EXISTS `course_stu`;
CREATE TABLE `course_stu` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '流水号（自动增长），主键',
  `ccode` char(6) CHARACTER SET utf8 NOT NULL COMMENT '课程号，唯一',
  `cname` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '课程中文名，唯一',
  `ename` varchar(100) DEFAULT NULL COMMENT '课程英文名，唯一',
  `score` tinyint(3) DEFAULT NULL COMMENT '学分',
  `category` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '理论总学时',
  `tlhour` smallint(5) DEFAULT NULL COMMENT '实验总学时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course_stu
-- ----------------------------

-- ----------------------------
-- Table structure for database_grade
-- ----------------------------
DROP TABLE IF EXISTS `database_grade`;
CREATE TABLE `database_grade` (
  `id` int(255) NOT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grade` (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of database_grade
-- ----------------------------
INSERT INTO `database_grade` VALUES ('1', '1078', '8');
INSERT INTO `database_grade` VALUES ('2', '1024', '80');
INSERT INTO `database_grade` VALUES ('3', '1002', '700');
INSERT INTO `database_grade` VALUES ('4', '1071', '90');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件工程');
INSERT INTO `major` VALUES ('2', '商务英语');

-- ----------------------------
-- Table structure for plan_study_course
-- ----------------------------
DROP TABLE IF EXISTS `plan_study_course`;
CREATE TABLE `plan_study_course` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `semester_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `semester_id` (`semester_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `plan_study_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `plan_study_course_ibfk_2` FOREIGN KEY (`semester_id`) REFERENCES `semester` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `plan_study_course_ibfk_3` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan_study_course
-- ----------------------------
INSERT INTO `plan_study_course` VALUES ('8', '2', '2', '2');
INSERT INTO `plan_study_course` VALUES ('29', '3', '2', '3');
INSERT INTO `plan_study_course` VALUES ('30', '1', '1', '4');
INSERT INTO `plan_study_course` VALUES ('31', '2', '1', '4');
INSERT INTO `plan_study_course` VALUES ('32', '3', '1', '4');
INSERT INTO `plan_study_course` VALUES ('33', '4', '1', '4');
INSERT INTO `plan_study_course` VALUES ('38', '2', '1', '1');
INSERT INTO `plan_study_course` VALUES ('39', '1', '1', '1');
INSERT INTO `plan_study_course` VALUES ('40', '3', '1', '2');
INSERT INTO `plan_study_course` VALUES ('41', '5', '1', '2');
INSERT INTO `plan_study_course` VALUES ('42', '6', '1', '2');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of semester
-- ----------------------------
INSERT INTO `semester` VALUES ('1', '2018第二学期');
INSERT INTO `semester` VALUES ('2', '2019第一学期');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '流水号（自动增长），主键',
  `scode` char(12) CHARACTER SET utf8 DEFAULT NULL COMMENT '学号，唯一',
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `gender` char(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别，取值{男，女}',
  `photo` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '照片，存放路径',
  `class_id` int(11) DEFAULT NULL COMMENT '外键（class[id])',
  `login_name` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grade` (`grade`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`grade`) REFERENCES `database_grade` (`grade`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '201626701078', '罗文杰', '男', 'images/wenjie.jpg', '1', '1078', '8');
INSERT INTO `student` VALUES ('2', '201626701024', '甘兆冬', '男', 'images/zhaodon.jpg', '1', '1024', '8');
INSERT INTO `student` VALUES ('3', '201626701071', '卢少鹏', '男', 'images/shaopeng.jpg', '1', '1071', '8');
INSERT INTO `student` VALUES ('4', '201626701002', '杨琳', '女', 'images/yanglin.jpg', '1', '1002', '8');

-- ----------------------------
-- Table structure for student_login
-- ----------------------------
DROP TABLE IF EXISTS `student_login`;
CREATE TABLE `student_login` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_login
-- ----------------------------
INSERT INTO `student_login` VALUES ('0', '1078', '123456');
INSERT INTO `student_login` VALUES ('1', '1024', '123456');
INSERT INTO `student_login` VALUES ('2', '1071', '123456');
INSERT INTO `student_login` VALUES ('3', '1002', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '流水号（自动增长），主键',
  `tcode` char(6) DEFAULT NULL COMMENT '工号',
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `gender` char(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `degree` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '学位',
  `title` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '职称',
  `introduction` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '个人简介',
  `photo` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '个人照片，存放路径',
  `teacher_user` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '110', '朱老师', '男', '硕士学位', '讲师', '无', 'images/zhuguohui.jpg', '002');
INSERT INTO `teacher` VALUES ('2', '111', '普京大帝', '男', '硕士学位', '讲师', '无', 'images/pujing.jpg', '001');
INSERT INTO `teacher` VALUES ('3', '110', '正恩同志', '男', '硕士学位', '讲师', '无', 'images/zhengen.jpg', '003');

-- ----------------------------
-- Table structure for teacher_login
-- ----------------------------
DROP TABLE IF EXISTS `teacher_login`;
CREATE TABLE `teacher_login` (
  `id` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_login
-- ----------------------------
INSERT INTO `teacher_login` VALUES ('0', '002', '123456');
INSERT INTO `teacher_login` VALUES ('1', '001', '123456');
INSERT INTO `teacher_login` VALUES ('2', '003', '123456');
