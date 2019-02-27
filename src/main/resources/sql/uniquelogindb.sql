/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : uniquelogindb

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/02/2019 13:08:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xiaoyu', '18007520206', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `login_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `device_info` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `is_availability` int(2) NOT NULL,
  `user_id` bigint(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES (30, 'xiaoyu.token.login.Android9bbe753fa9b74849907b99be889a9f95', 'Android', 'Nokia', 0, 1, '2019-02-27 13:05:37', '2019-02-27 13:05:37');
INSERT INTO `user_token` VALUES (31, 'xiaoyu.token.login.Android87db168ac1c74a7ea64901f1a0e8bd62', 'Android', 'Nokia', 0, 1, '2019-02-27 13:06:10', '2019-02-27 13:06:10');
INSERT INTO `user_token` VALUES (32, 'xiaoyu.token.login.Android24b8948d2feb4f19aba9eddf3efee43f', 'Android', 'Nokia', 0, 1, '2019-02-27 13:06:25', '2019-02-27 13:06:25');
INSERT INTO `user_token` VALUES (33, 'xiaoyu.token.login.Androida2769d2f370f40d28ab3408500953b07', 'Android', 'Nokia', 0, 1, '2019-02-27 13:06:29', '2019-02-27 13:06:29');
INSERT INTO `user_token` VALUES (34, 'xiaoyu.token.login.Androidb15fbc3bda9b4294bbb8dc90dc21627e', 'Android', 'Nokia', 0, 1, '2019-02-27 13:06:34', '2019-02-27 13:06:34');
INSERT INTO `user_token` VALUES (35, 'xiaoyu.token.login.Android272348a49f824ba2b625e3703740b026', 'Android', 'Nokia', 1, 1, '2019-02-27 13:06:34', '2019-02-27 13:06:34');
INSERT INTO `user_token` VALUES (36, 'xiaoyu.token.login.PC50c952c23ead4e9a9ff7064fb337908b', 'PC', 'Nokia', 0, 1, '2019-02-27 13:06:51', '2019-02-27 13:06:51');
INSERT INTO `user_token` VALUES (37, 'xiaoyu.token.login.PC13e76677705148f4b2ea04391787572d', 'PC', 'Nokia', 0, 1, '2019-02-27 13:06:56', '2019-02-27 13:06:56');
INSERT INTO `user_token` VALUES (38, 'xiaoyu.token.login.PC66e63272283a43c1a89ab01178bf9a70', 'PC', 'Nokia', 0, 1, '2019-02-27 13:07:04', '2019-02-27 13:07:04');
INSERT INTO `user_token` VALUES (39, 'xiaoyu.token.login.PC5c4a92442d6e49ef8d35f8bc399b0d86', 'PC', 'Nokia', 0, 1, '2019-02-27 13:08:12', '2019-02-27 13:08:12');
INSERT INTO `user_token` VALUES (40, 'xiaoyu.token.login.PC7a3ada699e574ec4a2ddc12443688145', 'PC', 'Nokia', 1, 1, '2019-02-27 13:08:12', '2019-02-27 13:08:12');

SET FOREIGN_KEY_CHECKS = 1;
