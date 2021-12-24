
-- ----------------------------
-- Table structure for zuul_route
-- ----------------------------
DROP TABLE IF EXISTS `zuul_route`;
CREATE TABLE `zuul_route`  (
  `id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表id（一般直接用service_id的值即可）',
  `service_id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务名',
  `path` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'zuul路由表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zuul_route
-- ----------------------------
INSERT INTO `zuul_route` VALUES ('service-a', 'service-a', '/service-a/**');
INSERT INTO `zuul_route` VALUES ('service-b', 'service-b', '/service-b/**');
INSERT INTO `zuul_route` VALUES ('service-c', 'service-c', '/service-c/**');
INSERT INTO `zuul_route` VALUES ('sso-server', 'sso-server', '/sso-server/**');

