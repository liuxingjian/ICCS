/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50519
 Source Host           : localhost:3306
 Source Schema         : 创新学分认证

 Target Server Type    : MySQL
 Target Server Version : 50519
 File Encoding         : 65001

 Date: 20/11/2022 14:14:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('000', '000');
INSERT INTO `admin` VALUES ('001', '001');
INSERT INTO `admin` VALUES ('003', '003');
INSERT INTO `admin` VALUES ('004', '004');
INSERT INTO `admin` VALUES ('10010', '10010');
INSERT INTO `admin` VALUES ('110', '110');

-- ----------------------------
-- Table structure for s_t
-- ----------------------------
DROP TABLE IF EXISTS `s_t`;
CREATE TABLE `s_t`  (
  `s_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_t
-- ----------------------------
INSERT INTO `s_t` VALUES ('33', '33');
INSERT INTO `s_t` VALUES ('0001', '001');
INSERT INTO `s_t` VALUES ('15', '15');
INSERT INTO `s_t` VALUES ('002', '002');
INSERT INTO `s_t` VALUES ('003', '003');
INSERT INTO `s_t` VALUES ('005', '005');
INSERT INTO `s_t` VALUES ('110', '110');
INSERT INTO `s_t` VALUES ('03', '03');
INSERT INTO `s_t` VALUES ('0004', '4');
INSERT INTO `s_t` VALUES ('000', '000');
INSERT INTO `s_t` VALUES ('10011', '10010');

-- ----------------------------
-- Table structure for stu_l
-- ----------------------------
DROP TABLE IF EXISTS `stu_l`;
CREATE TABLE `stu_l`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `leave_m` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `get_m` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`, `leave_m`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_l
-- ----------------------------
INSERT INTO `stu_l` VALUES ('0004', 'yes', '45', '');
INSERT INTO `stu_l` VALUES ('10010', 'yes', '老师好', '');

-- ----------------------------
-- Table structure for stu_m
-- ----------------------------
DROP TABLE IF EXISTS `stu_m`;
CREATE TABLE `stu_m`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_m
-- ----------------------------
INSERT INTO `stu_m` VALUES ('000', '000', '000', '000');
INSERT INTO `stu_m` VALUES ('0001', '张二风', '2020级', '软件学院');
INSERT INTO `stu_m` VALUES ('0004', '45', '45', '4545');
INSERT INTO `stu_m` VALUES ('002', '张二', '软件学院', '2020');
INSERT INTO `stu_m` VALUES ('003', '0003', '0003', '0003');
INSERT INTO `stu_m` VALUES ('005', '张五', '软件学院', '2020');
INSERT INTO `stu_m` VALUES ('10011', '张同学', '软件学院', '2020级');

-- ----------------------------
-- Table structure for stu_path
-- ----------------------------
DROP TABLE IF EXISTS `stu_path`;
CREATE TABLE `stu_path`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_path
-- ----------------------------
INSERT INTO `stu_path` VALUES ('17', 'src//材料下载//1639910729849//requirements.txt');
INSERT INTO `stu_path` VALUES ('33', 'src//材料下载//1639917901246//requirements.txt');
INSERT INTO `stu_path` VALUES ('0001', 'src//材料下载//1639920034388//requirements.txt');
INSERT INTO `stu_path` VALUES ('15', 'src//材料下载//1639986223325//requirements.txt');
INSERT INTO `stu_path` VALUES ('002', 'src//材料下载//1640069775282//requirements.txt');
INSERT INTO `stu_path` VALUES ('003', 'src//材料下载//1640072191085//requirements.txt');
INSERT INTO `stu_path` VALUES ('005', 'src//材料下载//1640136106354//软件工程培养方案.pdf');
INSERT INTO `stu_path` VALUES ('05', 'src//材料下载//1640136191065//requirements.txt');
INSERT INTO `stu_path` VALUES ('110', 'src//材料下载//1640162779906//requirements.txt');
INSERT INTO `stu_path` VALUES ('03', 'src//材料下载//1640171956360//requirements.txt');
INSERT INTO `stu_path` VALUES ('002', 'src//材料下载//1640189965592//requirements.txt');
INSERT INTO `stu_path` VALUES ('002', 'src//材料下载//1640190923227//requirements.txt');
INSERT INTO `stu_path` VALUES ('002', 'src//材料下载//1640191682497//requirements.txt');
INSERT INTO `stu_path` VALUES ('020', 'src//材料下载//1640191939994//requirements.txt');
INSERT INTO `stu_path` VALUES ('021', 'null');
INSERT INTO `stu_path` VALUES ('023', 'src//材料下载//1640219652173//requirements.txt');
INSERT INTO `stu_path` VALUES ('0004', 'src//材料下载//1640220291070//requirements.txt');
INSERT INTO `stu_path` VALUES ('000', 'src//材料下载//1640223745918//软件工程培养方案.pdf');
INSERT INTO `stu_path` VALUES ('10010', 'src//材料下载//1640922387235//软件工程培养方案.pdf');

-- ----------------------------
-- Table structure for stu_pro
-- ----------------------------
DROP TABLE IF EXISTS `stu_pro`;
CREATE TABLE `stu_pro`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `st` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `r_score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `a`(`st`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_pro
-- ----------------------------
INSERT INTO `stu_pro` VALUES ('001', '比赛', '蓝桥杯', '4', '2021', '已审核', '4', '不及格');
INSERT INTO `stu_pro` VALUES ('002', '考试', '英语四级', '5', '2020', '已审核', '6', '良好');
INSERT INTO `stu_pro` VALUES ('003', '志愿者', '迎新生', '6', '2021', '已审核', '6', '中等');
INSERT INTO `stu_pro` VALUES ('004', '证书', '计算机证书', '7', '2020', '已审核', '7', '良好');
INSERT INTO `stu_pro` VALUES ('005', '比赛', '蓝桥杯', '1', '2021', '已审核', '1', '不及格');
INSERT INTO `stu_pro` VALUES ('0004', '0', '0', '5', '2021-09-06', '已审核', '6', '良好');
INSERT INTO `stu_pro` VALUES ('000', '0', '0', '0', '2021-12-06', '已审核', '6', '良好');
INSERT INTO `stu_pro` VALUES ('10010', '比赛', 'ACM', '5', '2021-09-01', '已审核', '5', '中等');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('000', '000');
INSERT INTO `student` VALUES ('0001', '0001');
INSERT INTO `student` VALUES ('0004', '0004');
INSERT INTO `student` VALUES ('002', '002');
INSERT INTO `student` VALUES ('10011', '10011');

-- ----------------------------
-- Table structure for tea_m
-- ----------------------------
DROP TABLE IF EXISTS `tea_m`;
CREATE TABLE `tea_m`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tea_m
-- ----------------------------
INSERT INTO `tea_m` VALUES ('000', '000', '000', '00');
INSERT INTO `tea_m` VALUES ('0004', '0004', '0004', '0004');
INSERT INTO `tea_m` VALUES ('001', '张三', '10086', '河南省郑州市区');
INSERT INTO `tea_m` VALUES ('002', '李四', '100100', '河南开封');
INSERT INTO `tea_m` VALUES ('10010', '张老师', '13312302301', '河南郑州');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('000', '000');
INSERT INTO `teacher` VALUES ('0004', '0004');
INSERT INTO `teacher` VALUES ('001', '001');
INSERT INTO `teacher` VALUES ('002', '002');
INSERT INTO `teacher` VALUES ('10010', '10010');

SET FOREIGN_KEY_CHECKS = 1;
