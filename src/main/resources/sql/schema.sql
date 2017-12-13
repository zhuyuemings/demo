-- 创建数据库
CREATE DATABASE `demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- 创建用户表
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '用户主键',
  `username` varchar(40) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '用户密码',
  `status` tinyint(4) NOT NULL COMMENT '用户状态（0：删除，1启用）',
  `truename` varchar(40) NOT NULL COMMENT '用户真实姓名',
  `sex` tinyint(4) NOT NULL COMMENT '用户性别（0：未知，1：男，2：女）',
  `tel` varchar(40) NOT NULL COMMENT '手机号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'ym', '123456', '1', '其琛', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'wj', '123456', '1', '文静', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'zz', '123456', '1', '蓁蓁', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'yf', '123456', '1', '燕飞', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'ss', '123456', '1', '淑慎', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'hr', '123456', '1', '惠然', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'js', '123456', '1', '静姝', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'wt', '123456', '1', '炜彤', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'xm', '123456', '1', '洵美', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'yw', '123456', '1', '燕婉', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'ry', '123456', '1', '如云', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'cy', '123456', '1', '朝雨', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'pp', '123456', '1', '芃芃', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'dy', '123456', '1', '德音', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'zp', '123456', '1', '子佩', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'ry', '123456', '1', '如英', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'jj', '123456', '1', '菁菁', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'wy', '123456', '1', '文茵', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'yn', '123456', '1', '攸宁', '1', '15800001234');
INSERT INTO `demo`.`sys_user` (`id`, `username`, `password`, `status`, `truename`, `sex`, `tel`)
VALUES (UUID(), 'hy', '123456', '1', '徽音', '1', '15800001234');