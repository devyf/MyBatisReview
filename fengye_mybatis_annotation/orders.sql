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

 Date: 12/03/2021 18:41:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordertime` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `total` int(50) NULL DEFAULT NULL COMMENT '总数',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_customer`(`uid`) USING BTREE,
  CONSTRAINT `fk_order_customer` FOREIGN KEY (`uid`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2019-02-15 11:53:53', 3000, 14533.58, 1);
INSERT INTO `orders` VALUES (2, '2018-10-10 15:56:40', 5800, 33652.50, 1);
INSERT INTO `orders` VALUES (3, '2019-02-08 15:55:40', 323, 6536.65, 1);
INSERT INTO `orders` VALUES (4, '2019-02-21 11:40:26', 332, 457.89, 2);
INSERT INTO `orders` VALUES (5, '2019-02-04 16:30:11', 100, 568.00, 4);
INSERT INTO `orders` VALUES (6, '2018-07-05 18:57:52', 258, 3443.12, 2);
INSERT INTO `orders` VALUES (7, '2020-05-19 12:30:02', 453, 3442.43, 3);

SET FOREIGN_KEY_CHECKS = 1;
