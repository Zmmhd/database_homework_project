/*
 Navicat Premium Data Transfer

 Source Server         : tianti
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 24/03/2022 12:15:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo`  (
  `admin_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('super', '123456');

-- ----------------------------
-- Table structure for commentinfo
-- ----------------------------
DROP TABLE IF EXISTS `commentinfo`;
CREATE TABLE `commentinfo`  (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `show_id` int NULL DEFAULT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `comment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commentinfo
-- ----------------------------
INSERT INTO `commentinfo` VALUES (1, 1, '19121381', '好康');

-- ----------------------------
-- Table structure for feedbackinfo
-- ----------------------------
DROP TABLE IF EXISTS `feedbackinfo`;
CREATE TABLE `feedbackinfo`  (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `feedback_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `feedback` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`feedback_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedbackinfo
-- ----------------------------

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `show_id` int NULL DEFAULT NULL,
  `seat_id` int NULL DEFAULT NULL,
  `seat_info` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `show_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `show_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 136 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES (111, '19121381', 1, 5, '普通座位', NULL, NULL);
INSERT INTO `orderinfo` VALUES (116, '777', 2, 7, '普通座位', '三打白骨精', '2022-03-26');
INSERT INTO `orderinfo` VALUES (120, 'qqq', 2, 7, '普通座位', '三打白骨精', '2022-03-26');
INSERT INTO `orderinfo` VALUES (124, 'fff', 1, 5, '普通座位', '大话西游', NULL);
INSERT INTO `orderinfo` VALUES (127, 'xxx', 4, 17, '普通座位', '霸王别姬', '2022-05-04');
INSERT INTO `orderinfo` VALUES (128, '12345', 5, 22, '普通座位', '空城计', '2022-05-05');
INSERT INTO `orderinfo` VALUES (129, '345', 3, 16, '普通座位', '西厢记', '2022-05-02');
INSERT INTO `orderinfo` VALUES (130, '345', 2, 13, '普通座位', '牡丹亭', '2022-05-01');
INSERT INTO `orderinfo` VALUES (131, '345', 5, 21, '普通座位', '空城计', '2022-05-05');
INSERT INTO `orderinfo` VALUES (133, '123456', 4, 18, '普通座位', '霸王别姬', '2022-05-04');
INSERT INTO `orderinfo` VALUES (134, '123456', 4, 18, '普通座位', '霸王别姬', '2022-05-04');
INSERT INTO `orderinfo` VALUES (135, '123456', 4, 17, '普通座位', '霸王别姬', '2022-05-04');
INSERT INTO `orderinfo` VALUES (136, '123456', 4, 18, '普通座位', '霸王别姬', '2022-05-04');

-- ----------------------------
-- Table structure for seatinfo
-- ----------------------------
DROP TABLE IF EXISTS `seatinfo`;
CREATE TABLE `seatinfo`  (
  `seat_id` int NOT NULL AUTO_INCREMENT,
  `show_id` int NULL DEFAULT NULL,
  `coordinate_x` int NULL DEFAULT NULL,
  `coordinate_y` int NULL DEFAULT NULL,
  `choosen` tinyint(1) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`seat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seatinfo
-- ----------------------------
INSERT INTO `seatinfo` VALUES (3, 1, 5, 3, 1, 1);
INSERT INTO `seatinfo` VALUES (4, 1, 5, 4, 1, 1);
INSERT INTO `seatinfo` VALUES (6, 1, 5, 5, 1, 1);
INSERT INTO `seatinfo` VALUES (7, 1, 5, 7, 1, 1);
INSERT INTO `seatinfo` VALUES (8, 1, 5, 9, 1, 1);
INSERT INTO `seatinfo` VALUES (9, 1, 5, 10, 1, 1);
INSERT INTO `seatinfo` VALUES (10, 1, 5, 11, 1, 1);
INSERT INTO `seatinfo` VALUES (11, 2, 6, 1, 1, 1);
INSERT INTO `seatinfo` VALUES (12, 2, 6, 2, 1, 1);
INSERT INTO `seatinfo` VALUES (13, 2, 6, 3, 1, 1);
INSERT INTO `seatinfo` VALUES (14, 3, 1, 1, 1, 1);
INSERT INTO `seatinfo` VALUES (15, 3, 1, 2, 1, 1);
INSERT INTO `seatinfo` VALUES (16, 3, 1, 3, 1, 1);
INSERT INTO `seatinfo` VALUES (17, 4, 2, 1, 1, 1);
INSERT INTO `seatinfo` VALUES (18, 4, 2, 2, 1, 1);
INSERT INTO `seatinfo` VALUES (19, 4, 2, 3, 1, 1);
INSERT INTO `seatinfo` VALUES (20, 5, 3, 5, 1, 1);
INSERT INTO `seatinfo` VALUES (21, 5, 5, 6, 1, 1);
INSERT INTO `seatinfo` VALUES (22, 5, 5, 7, 1, 1);
INSERT INTO `seatinfo` VALUES (23, 6, 1, 1, 1, 1);
INSERT INTO `seatinfo` VALUES (24, 6, 1, 2, 1, 1);
INSERT INTO `seatinfo` VALUES (25, 6, 1, 3, 1, 1);
INSERT INTO `seatinfo` VALUES (26, 7, 1, 1, 1, 1);
INSERT INTO `seatinfo` VALUES (27, 7, 1, 2, 1, 1);
INSERT INTO `seatinfo` VALUES (28, 7, 1, 3, 1, 1);
INSERT INTO `seatinfo` VALUES (29, 2, 1, 2, 1, 0);
INSERT INTO `seatinfo` VALUES (30, 41, 2, 3, 1, 1);

-- ----------------------------
-- Table structure for selectinfo
-- ----------------------------
DROP TABLE IF EXISTS `selectinfo`;
CREATE TABLE `selectinfo`  (
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `show_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `show_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `show_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `seat_id` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of selectinfo
-- ----------------------------
INSERT INTO `selectinfo` VALUES ('19121381', '1', '大话西游', NULL, 5);

-- ----------------------------
-- Table structure for showinfo
-- ----------------------------
DROP TABLE IF EXISTS `showinfo`;
CREATE TABLE `showinfo`  (
  `show_id` int NOT NULL AUTO_INCREMENT,
  `show_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `show_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `show_site` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `show_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `show_introduction` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total` int NULL DEFAULT NULL,
  `for_sell` int NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  `img_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`show_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of showinfo
-- ----------------------------
INSERT INTO `showinfo` VALUES (2, '牡丹亭', '爱情', NULL, '2022-05-01', NULL, NULL, NULL, 30, NULL);
INSERT INTO `showinfo` VALUES (3, '西厢记', '爱情', NULL, '2022-05-02', NULL, NULL, NULL, 35, NULL);
INSERT INTO `showinfo` VALUES (4, '霸王别姬', '爱情', NULL, '2022-05-04', NULL, NULL, NULL, 50, NULL);
INSERT INTO `showinfo` VALUES (5, '空城计', '历史', NULL, '2022-05-05', NULL, NULL, NULL, 35, NULL);
INSERT INTO `showinfo` VALUES (6, '白蛇传', '传说', NULL, '2022-05-07', NULL, NULL, NULL, 45, NULL);
INSERT INTO `showinfo` VALUES (7, '贵妃醉酒', '历史', NULL, '2022-05-08', NULL, NULL, NULL, 45, NULL);
INSERT INTO `showinfo` VALUES (41, '拜月停', '爱情', '上海', '2022-03-17', '好看', NULL, NULL, 200, NULL);

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
  `area_id` int NOT NULL AUTO_INCREMENT,
  `area_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `priority` int NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `last_edit_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`area_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (1, '上海', 5, NULL, NULL);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `country` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hobby` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `introduction` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('000', '佘雨琪', '女', NULL, NULL, '上海', '23333', 19, '000', '1169591397@qq.com', NULL, '我要好好学java', NULL);
INSERT INTO `userinfo` VALUES ('0000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '000', NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES ('111', '解家祥', '男', '中国', '安徽', '合肥', '1804208024', 20, '123', 'zmm@qq.com', NULL, '不写完项目不睡觉的组长', '宝山校区上海大学');
INSERT INTO `userinfo` VALUES ('1111', '王媛媛', '女', '中国', '贵州', '贵阳', '2379127412', 19, '1234', 'syq@qq.com', NULL, '一定学会数据库', '宝山校区上海大学');
INSERT INTO `userinfo` VALUES ('111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '11111111', NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES ('123', '倪园', '女', '中国', '上海', '上海', '2321423123', 19, '12345', 'lzz@qq.com', NULL, '数据库我们可以', '宝山校区上海大学');
INSERT INTO `userinfo` VALUES ('12345', '姚逸歌', '女', NULL, NULL, '上海', '37923792323', 19, '12345', 'tianti@shu.edu.cn', NULL, 'java真不错', NULL);
INSERT INTO `userinfo` VALUES ('123456', '佘雨琪', NULL, NULL, NULL, '上海', '23333', 19, '123456', '1169591397@qq.com', NULL, 'java真不错', NULL);
INSERT INTO `userinfo` VALUES ('345', '佘雨琪', NULL, NULL, NULL, '', '', NULL, '345', '', NULL, '', NULL);
INSERT INTO `userinfo` VALUES ('xxx', '佘雨琪', NULL, NULL, NULL, '上海', '23333', 19, 'xxx', '1169591397@qq.com', NULL, '我要好好学java', NULL);

SET FOREIGN_KEY_CHECKS = 1;
