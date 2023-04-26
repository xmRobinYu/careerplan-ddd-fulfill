CREATE
database if NOT EXISTS `ddd_fulfill` default character set utf8 collate utf8_general_ci;
use
`ddd_fulfill`;

SET NAMES utf8;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fulfill_order
-- ----------------------------
DROP TABLE IF EXISTS `fulfill_order`;
CREATE TABLE `fulfill_order` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                 `order_id` varchar(50) NOT NULL COMMENT '订单id',
                                 `fulfill_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '履约单号',
                                 `origin_amount` int(11) NOT NULL COMMENT '当前商品支付原总价',
                                 `pay_amount` int(11) NOT NULL COMMENT '付款金额',
                                 `pay_type` tinyint(4) NOT NULL COMMENT '支付类型 10 微信支付 20 支付宝支付',
                                 `user_id` varchar(50) DEFAULT NULL COMMENT '买家id',
                                 `warehouse_id` varchar(50) DEFAULT NULL COMMENT '仓库id',
                                 `fulfill_status` tinyint(4) NOT NULL COMMENT '履约单状态',
                                 `risk_status` tinyint(4) DEFAULT NULL COMMENT '风控状态：10 未通过 20 已通过',
                                 `manual_review_status` tinyint(4) DEFAULT NULL COMMENT '人工审核状态：10 未通过 20 已通过',
                                 `logistics_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物流单号',
                                 `delivery_mode` tinyint(4) DEFAULT NULL COMMENT '配送方式 10 自营配送 20 三方配送',
                                 `province` varchar(50) DEFAULT NULL COMMENT '省',
                                 `city` varchar(50) DEFAULT NULL COMMENT '市',
                                 `area` varchar(50) DEFAULT NULL COMMENT '区',
                                 `street` varchar(50) DEFAULT NULL COMMENT '街道',
                                 `detail_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
                                 `receiver_name` varchar(50) DEFAULT NULL COMMENT '收货人姓名',
                                 `receiver_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货人电话',
                                 `lon` decimal(20,10) DEFAULT NULL COMMENT '经度',
                                 `lat` decimal(20,10) DEFAULT NULL COMMENT '维度',
                                 `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='履约单信息表';

-- ----------------------------
-- Table structure for fulfill_order_item
-- ----------------------------
DROP TABLE IF EXISTS `fulfill_order_item`;
CREATE TABLE `fulfill_order_item` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                      `order_id` varchar(50) NOT NULL COMMENT '订单id',
                                      `fulfill_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '履约单号',
                                      `sku_code` varchar(50) NOT NULL COMMENT 'sku编码',
                                      `origin_amount` int(11) NOT NULL COMMENT '当前商品支付原总价',
                                      `pay_amount` int(11) NOT NULL COMMENT '付款金额',
                                      `sale_quantity` int(11) NOT NULL COMMENT '销售数量',
                                      `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='履约订单条目表';


-- ----------------------------
-- Table structure for fulfill_log
-- ----------------------------
DROP TABLE IF EXISTS `fulfill_log`;
CREATE TABLE `fulfill_log` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                               `fulfill_id` varchar(50) NOT NULL COMMENT '履约单号',
                               `before_status` tinyint(4) NOT NULL COMMENT '履约单前置状态 10 已创建 20 已出库 30 已配送',
                               `current_status` tinyint(4) NOT NULL COMMENT '履约单当前状态 10 已创建 20 已出库 30 已配送',
                               `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8 COMMENT='履约状态记录表';