/*
 Navicat Premium Data Transfer

 Source Server         : localhost3306
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : mybatisreview2_0311

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 12/03/2021 18:41:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '李华', 25, '55362', '1994-06-15');
INSERT INTO `customer` VALUES (2, '俊杰', 21, '34453', '1995-07-06');
INSERT INTO `customer` VALUES (3, '李志伟', 32, '43332', '1983-07-26');
INSERT INTO `customer` VALUES (4, '李强', 25, '43342', '1994-05-18');
INSERT INTO `customer` VALUES (5, '东华', 28, '44333', '1993-06-26');
INSERT INTO `customer` VALUES (6, '白客', 30, '34432', '1990-02-14');

SET FOREIGN_KEY_CHECKS = 1;
