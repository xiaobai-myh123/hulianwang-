/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : internet

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 31/07/2020 11:43:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(255) NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1288708525777788929, 'demo', 'demo', 'demoData', 'demoData');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` bigint(20) NOT NULL COMMENT '募捐id',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名：手机号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `departaddr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物件集中地址',
  `destinationaddr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送地址',
  `begintime` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `state` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (1288702312885391360, 1288701593599922178, 'demo1', 'demo1', '湖北省', '贵州省', '2020-07-30 13:05:48', '2020-07-30 21:04:00', 'demoData22222', 1);
INSERT INTO `collection` VALUES (1288702339850571776, 1288701593599922178, 'demo1', 'demo1', '湖北省', '贵州省', '2020-07-30 13:05:55', '2020-07-30 21:04:00', 'demoData33333', 1);
INSERT INTO `collection` VALUES (1288702375200165888, 1288701593599922178, 'demo1', 'demo1', '湖北省', '贵州省', '2020-07-30 13:06:03', '2020-07-30 21:04:00', 'demoData44444', 0);

-- ----------------------------
-- Table structure for collectionid_userid
-- ----------------------------
DROP TABLE IF EXISTS `collectionid_userid`;
CREATE TABLE `collectionid_userid`  (
  `collectionid` bigint(20) NULL DEFAULT NULL COMMENT '活动id',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collectionid_userid
-- ----------------------------
INSERT INTO `collectionid_userid` VALUES (1288702312885391360, 1288701593599922178);
INSERT INTO `collectionid_userid` VALUES (1288702339850571776, 1288701593599922178);
INSERT INTO `collectionid_userid` VALUES (1288702375200165888, 1288701593599922178);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(255) NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `state` int(255) NOT NULL COMMENT '0:普通用户，1：解答师',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `stop` int(255) NULL DEFAULT NULL COMMENT '启用禁用'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1288701463681355777, 'demo1', 'demo1', '11111111111', 0, 'demo11', 0);
INSERT INTO `user` VALUES (1288701518937116673, 'demo2', 'demo2', '22222222222', 0, 'demo2', 0);
INSERT INTO `user` VALUES (1288701593599922178, 'demoData', 'demoData', 'demoData', 1, 'demoData', 0);
INSERT INTO `user` VALUES (1288730645652094978, 'demoData1', 'demoData', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730662500614146, 'demoDat2', 'demoData', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730784370311169, 'demoD22', 'demowa', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730793593585665, 'dem222', 'demowa', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730805807398914, 'de3222', 'demowa', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730815563350018, 'de3422', 'demowa', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730824463663106, 'd4522', 'demowa', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730834613878786, 'd44522', 'demowa', 'demoData', 1, 'demoData', 1);
INSERT INTO `user` VALUES (1288730844973809666, 'd44435522', 'demowa', 'demoData', 1, 'demoData', 1);

SET FOREIGN_KEY_CHECKS = 1;
