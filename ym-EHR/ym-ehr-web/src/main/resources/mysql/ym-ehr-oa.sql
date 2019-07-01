/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : ym-ehr-oa

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2019-01-12 18:14:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ym_user`
-- ----------------------------
DROP TABLE IF EXISTS `ym_user`;
CREATE TABLE `ym_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(1000) DEFAULT NULL COMMENT '登录名',
  `login_pwd` varchar(1000) DEFAULT NULL COMMENT '登录密码',
  `user_name` varchar(1000) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `head_img` varchar(2000) DEFAULT NULL COMMENT '头像',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` int(2) DEFAULT NULL COMMENT '删除标志(0：删除、1：未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of ym_user
-- ----------------------------
INSERT INTO `ym_user` VALUES ('1', '1', '1', '2', '1', '2018-02-05', null, null, '2019-01-11 18:05:08', '2019-01-11 18:05:08', '1');
INSERT INTO `ym_user` VALUES ('2', null, null, '2', null, null, null, null, '2019-01-11 18:05:10', '2019-01-11 18:05:10', '1');
INSERT INTO `ym_user` VALUES ('3', null, null, '1', null, null, null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('4', '2', '2', '1', '1', '2019-01-23', null, 'other/img/2019/01/11/62f44e8d-416d-4c1d-85bf-cc34adfcd508.jpg', '2019-01-11 22:00:18', '2019-01-11 22:00:18', '1');
INSERT INTO `ym_user` VALUES ('5', null, null, '1', null, null, null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('6', null, null, '1', null, null, null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('7', '惹我', '11', '1', '1', '2018-02-13', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('8', '惹我', '11', '1', '1', '2018-02-13', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('9', '但是', '2', '1', '1', '2018-02-16', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('10', 'dasdasd', '42331', '1', '0', '2018-02-22', null, '', '2019-01-11 18:04:50', '2019-01-11 18:04:50', '0');
INSERT INTO `ym_user` VALUES ('11', '231', '3213', '1', '1', '2018-02-21', null, '', '2019-01-11 18:04:50', '2019-01-11 18:04:50', '0');
INSERT INTO `ym_user` VALUES ('12', '诶我去', '1', '1', '1', '2018-02-28', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('13', '262', '121', '1', '1', '2018-03-20', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('14', '二人人', '32143', '1', '1', '2018-02-21', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('15', '发多少', '343', '1', '1', '2018-02-28', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('16', '对对对', 'ewq', '1', '1', '2018-02-20', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('17', '2', '22', '1', '1', '2018-02-22', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('18', '恶趣味', '1321', '1', '1', '2018-02-21', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('19', '恶趣味', 'eqw', '1', '1', '2018-02-13', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('20', '33', '33', '1', '0', '2018-02-13', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('21', '诶我去1', '423', '1', '0', '2018-02-14', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('22', '诶我去321323', '42332131', '1', '1', '2018-02-14', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('23', '诶我去', '42322', '1', '1', '2018-02-14', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('24', '诶我去', '423', '1', '1', '2018-02-14', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('25', '诶我去1', '423', '1', '0', '2018-02-14', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('26', 'ww', '11', '1', '1', '2018-02-21', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('27', '33', '33', '1', '1', '2018-02-20', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('28', 're', '42', '1', '1', '2018-02-14', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('29', 're', 'rew', '1', '1', '2018-02-28', null, null, '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('30', 'e', '3', '1', '1', '2018-03-21', null, 'other/img/2018/03/29/6c18daf9-45f4-40d4-837f-41b2457956fc.png', '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('31', 'ewe', 'eqw', '1', '1', '2018-03-27', null, 'other/img/2018/03/29/275c55eb-3ec6-4daa-a031-6e1a3a1d02e5.png', '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('32', '22', '22', '1', '1', '2018-03-27', null, 'other/img/2018/03/29/8a19dcd1-5bc9-4245-9ee7-a66cc04c400d.png', '2019-01-11 18:04:50', '2019-01-11 18:04:50', null);
INSERT INTO `ym_user` VALUES ('33', 'das', 'dsa', '1', '1', '2018-03-22', null, 'other/img/2018/03/29/ac5b5b6a-145b-4b3d-abae-46e02f7984ad.png', '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('34', 'ww', '11', '1', '1', '2018-12-19', null, '', '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('35', '231', '32131', '1', '1', '2018-12-27', null, 'other/img/2018/12/17/b937ad67-04e1-4b68-bdf3-b223f56b8b78.png', '2019-01-11 18:04:50', '2019-01-11 18:04:50', '1');
INSERT INTO `ym_user` VALUES ('37', '1312', '312', '1', '1', '2019-01-30', null, '', null, null, '1');
INSERT INTO `ym_user` VALUES ('38', '433', '1', '1', '1', '2019-01-24', null, 'other/img/2019/01/11/6bb6fffc-9537-4f03-b606-23cd1afc6b9f.jpg', '2019-01-11 15:08:06', '2019-01-11 15:08:06', '0');
INSERT INTO `ym_user` VALUES ('39', '2432', '4234', '2', '1', '2019-01-31', null, '', '2019-01-11 18:05:27', '2019-01-11 18:05:27', '0');
INSERT INTO `ym_user` VALUES ('40', '1', '31', '2', '0', '2019-01-25', null, 'other/img/2019/01/11/f29b5f7e-4df5-40b7-88c8-0555738c8d3d.jpg', '2019-01-11 18:05:26', '2019-01-11 18:05:26', '1');
