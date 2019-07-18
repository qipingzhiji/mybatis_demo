/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 19/07/2019 01:40:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (2, '科教2');
INSERT INTO `dept` VALUES (3, '科教3');
INSERT INTO `dept` VALUES (4, '科教4');
INSERT INTO `dept` VALUES (5, '科教6');
INSERT INTO `dept` VALUES (6, '科教5');
INSERT INTO `dept` VALUES (7, '科教8');
INSERT INTO `dept` VALUES (16, '科教1');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` tinyint(4) NULL DEFAULT NULL,
  `birth` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (2, 'admin', 18, '2019-07-17 13:04:02');
INSERT INTO `employee` VALUES (3, 'admin', 18, '2019-07-17 13:04:03');
INSERT INTO `employee` VALUES (4, 'admin', 18, '2019-07-18 15:09:59');
INSERT INTO `employee` VALUES (5, 'admin', 18, '2019-07-18 15:10:04');
INSERT INTO `employee` VALUES (6, 'admin', 18, '2019-07-18 15:10:07');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deptNum` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `teacher_dept_fk`(`deptNum`) USING BTREE,
  CONSTRAINT `teacher_dept_fk` FOREIGN KEY (`deptNum`) REFERENCES `dept` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'admin', '信息技术', 16);
INSERT INTO `teacher` VALUES (2, 'xiaohong', '数学', 2);
INSERT INTO `teacher` VALUES (4, 'xiaogang', '计算机', 2);
INSERT INTO `teacher` VALUES (5, 'xiaoqiang', '语文', 3);
INSERT INTO `teacher` VALUES (6, 'john', '英语', 3);

SET FOREIGN_KEY_CHECKS = 1;
