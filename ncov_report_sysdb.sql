/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : ncov_report_sysdb

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 07/03/2021 15:46:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���ұ��',
  `hos_id` int(11) NULL DEFAULT NULL COMMENT 'ҽԺ���',
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`dept_id`) USING BTREE,
  INDEX `FK_Reference_1`(`hos_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`hos_id`) REFERENCES `tb_hospital` (`hos_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1916 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tb_dictionary`;
CREATE TABLE `tb_dictionary`  (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�ֵ���',
  `dict_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ֵ�����',
  `dict_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ֵ�ֵ',
  `dict_mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ֵ���',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_doctor
-- ----------------------------
DROP TABLE IF EXISTS `tb_doctor`;
CREATE TABLE `tb_doctor`  (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ҽ�����',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '���ұ��',
  `doc_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ҽ������',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`doc_id`) USING BTREE,
  INDEX `FK_Reference_2`(`dept_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`dept_id`) REFERENCES `tb_department` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_hospital
-- ----------------------------
DROP TABLE IF EXISTS `tb_hospital`;
CREATE TABLE `tb_hospital`  (
  `hos_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ҽԺ���',
  `hos_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ҽԺ����',
  `hos_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ҽԺ��ַ',
  PRIMARY KEY (`hos_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1048 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�����˱��',
  `manager_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����������',
  `autograph` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������ǩ��',
  `manager_type` int(11) NULL DEFAULT NULL COMMENT '����������',
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_report
-- ----------------------------
DROP TABLE IF EXISTS `tb_report`;
CREATE TABLE `tb_report`  (
  `report_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '������',
  `specimen_id` int(11) NULL DEFAULT NULL COMMENT '�������',
  `reporter_id` int(11) NULL DEFAULT NULL COMMENT '������',
  `reviewer_id` int(11) NULL DEFAULT NULL COMMENT '�����',
  `create_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����ʱ��',
  `specimen_result_id` int(11) NULL DEFAULT NULL COMMENT '���',
  `reference_value_id` int(11) NULL DEFAULT NULL COMMENT '�ο�ֵ',
  PRIMARY KEY (`report_id`) USING BTREE,
  INDEX `FK_Reference_6`(`specimen_id`) USING BTREE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`specimen_id`) REFERENCES `tb_specimen` (`specimen_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 182517 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_right
-- ----------------------------
DROP TABLE IF EXISTS `tb_right`;
CREATE TABLE `tb_right`  (
  `right_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Ȩ�ޱ��',
  `parent_id` int(11) NOT NULL COMMENT '��Ȩ�ޱ��',
  `right_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Ȩ������',
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` int(11) NOT NULL COMMENT 'Ȩ�޵ȼ�',
  PRIMARY KEY (`right_id`) USING BTREE,
  UNIQUE INDEX `unique_path`(`path`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '��ɫ���',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ɫ����',
  `role_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ɫ����',
  `role_status` int(11) NULL DEFAULT NULL COMMENT '��ɫ״̬',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_role_right
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_right`;
CREATE TABLE `tb_role_right`  (
  `role_right_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '��ɫȨ�ޱ��',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '��ɫ���',
  `right_id` int(11) NULL DEFAULT NULL COMMENT 'Ȩ�ޱ��',
  PRIMARY KEY (`role_right_id`) USING BTREE,
  INDEX `FK_Reference_10`(`role_id`) USING BTREE,
  INDEX `FK_Reference_7`(`right_id`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`right_id`) REFERENCES `tb_right` (`right_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 836 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_specimen
-- ----------------------------
DROP TABLE IF EXISTS `tb_specimen`;
CREATE TABLE `tb_specimen`  (
  `specimen_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�������',
  `specimen_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�걾������',
  `bed_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��λ��',
  `hos_id` int(11) NULL DEFAULT NULL COMMENT 'ҽԺ���',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '���ұ��',
  `doc_id` int(11) NULL DEFAULT NULL COMMENT 'ҽ�����',
  `door_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
  `patient_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��������',
  `patient_age` int(11) NULL DEFAULT NULL COMMENT '��������',
  `patient_tellphone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ϵ��ʽ',
  `patient_gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����Ա�',
  `specimen_type_id` int(11) NULL DEFAULT NULL COMMENT '�걾����',
  `specimen_situation_id` int(11) NULL DEFAULT NULL COMMENT '�걾���',
  `specimen_status_id` int(11) NULL DEFAULT NULL COMMENT '����״̬',
  `create_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����ʱ��',
  `recv_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����ʱ��',
  `test_type_id` int(11) NULL DEFAULT NULL,
  `patient_type_id` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`specimen_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 188444 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '��ɫ���',
  `login_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�û���',
  `login_passwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����',
  `telephone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��ϵ�绰',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����',
  `register_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ע��ʱ��',
  `department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��������',
  `post` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ְ������',
  `user_status` int(11) NULL DEFAULT NULL COMMENT '�û�״̬',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `unique_loginname`(`login_name`) USING BTREE,
  INDEX `FK_Reference_11`(`role_id`) USING BTREE,
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dictionary
-- ----------------------------
INSERT INTO `tb_dictionary` VALUES (4, '6_result', '阴性', '阴性');
INSERT INTO `tb_dictionary` VALUES (5, '6_result', '阳性', '阳性');
INSERT INTO `tb_dictionary` VALUES (6, 'test_types', '核酸检测', 'ncov');
INSERT INTO `tb_dictionary` VALUES (7, 'test_types', '抗体检测', 'antibody');
INSERT INTO `tb_dictionary` VALUES (8, 'manager_type_reporter', '报告者', NULL);
INSERT INTO `tb_dictionary` VALUES (9, 'manager_type_reviewer', '审核者', NULL);
INSERT INTO `tb_dictionary` VALUES (10, '7_result', 'nCoVIgM（阴性）-nCoVIgG（阴性）', '阴性,阴性');
INSERT INTO `tb_dictionary` VALUES (11, '7_result', 'nCoVIgM（阳性）-nCoVIgG（阳性）', '阳性,阳性');
INSERT INTO `tb_dictionary` VALUES (12, '7_result', 'nCoVIgM（阳性）-nCoVIgG（阴性）', '阳性,阴性');
INSERT INTO `tb_dictionary` VALUES (13, '7_result', 'nCoVIgM（阴性）-nCoVIgG（阳性）', '阴性,阳性');
INSERT INTO `tb_dictionary` VALUES (14, '6_specimen_type', '口咽拭子', '口咽拭子');
INSERT INTO `tb_dictionary` VALUES (15, '7_specimen_type', '血清', '血清');
INSERT INTO `tb_dictionary` VALUES (16, '20_specimen_type', '口咽拭子和血清', '口咽拭子,血清');
INSERT INTO `tb_dictionary` VALUES (17, 'specimen_situation', '良好', NULL);
INSERT INTO `tb_dictionary` VALUES (18, 'specimen_situation', '漏液', NULL);
INSERT INTO `tb_dictionary` VALUES (19, 'specimen_situation', '结冰', NULL);
INSERT INTO `tb_dictionary` VALUES (20, 'test_types', '双联检测', 'ncov&antibody');
INSERT INTO `tb_dictionary` VALUES (21, '20_result', '核酸（阴性） nCoVIgM（阴性）-nCoVIgG（阴性）', '阴性,阴性,阴性');
INSERT INTO `tb_dictionary` VALUES (22, '20_result', '核酸（阴性） nCoVIgM（阴性）-nCoVIgG（阳性）', '阴性,阴性,阳性');
INSERT INTO `tb_dictionary` VALUES (23, '20_result', '核酸（阴性） nCoVIgM（阳性）-nCoVIgG（阴性）', '阴性,阳性,阴性');
INSERT INTO `tb_dictionary` VALUES (24, '20_result', '核酸（阴性） nCoVIgM（阳性）-nCoVIgG（阳性）', '阴性,阳性,阳性');
INSERT INTO `tb_dictionary` VALUES (25, '20_result', '核酸（阳性） nCoVIgM（阴性）-nCoVIgG（阴性）', '阳性,阴性,阴性');
INSERT INTO `tb_dictionary` VALUES (26, '20_result', '核酸（阳性） nCoVIgM（阴性）-nCoVIgG（阳性）', '阳性,阴性,阳性');
INSERT INTO `tb_dictionary` VALUES (27, '20_result', '核酸（阳性） nCoVIgM（阳性）-nCoVIgG（阴性）', '阳性,阳性,阴性');
INSERT INTO `tb_dictionary` VALUES (28, '20_result', '核酸（阳性） nCoVIgM（阳性）-nCoVIgG（阳性）', '阳性,阳性,阳性');
INSERT INTO `tb_dictionary` VALUES (29, 'patient_type', '发热门诊', '发热门诊');
INSERT INTO `tb_dictionary` VALUES (30, 'patient_type', '普通门诊', '普通门诊');
INSERT INTO `tb_dictionary` VALUES (31, 'patient_type', '急诊', '急诊');
INSERT INTO `tb_dictionary` VALUES (32, 'patient_type', '住院患者', '住院患者');
INSERT INTO `tb_dictionary` VALUES (33, 'patient_type', '陪护人员', '陪护人员');
INSERT INTO `tb_dictionary` VALUES (34, 'patient_type', '本院职工', '本院职工');
INSERT INTO `tb_dictionary` VALUES (35, 'patient_type', '院外采样人员', '院外采样人员');
INSERT INTO `tb_dictionary` VALUES (36, 'patient_type', '其他机构送检', '其他');
INSERT INTO `tb_dictionary` VALUES (37, '6_specimen_type', '鼻咽拭子', '鼻咽拭子');
INSERT INTO `tb_dictionary` VALUES (38, '20_specimen_type', '鼻咽拭子和血清', '鼻咽拭子,血清');

SET FOREIGN_KEY_CHECKS = 1;
