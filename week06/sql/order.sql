CREATE TABLE `order` (
                         `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
                         `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
                         `address_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收获地址id',
                         `order_time` datetime NOT NULL COMMENT '下单时间',
                         `order_amount` decimal(16,2) NOT NULL COMMENT '订单金额',
                         `pay_mode` int NOT NULL COMMENT '支付方式 1:银行卡',
                         `pay_time` datetime NOT NULL COMMENT '支付时间',
                         `express_id` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '快递id',
                         `order_status` tinyint(1) DEFAULT NULL COMMENT '订单状态：1:正常 0:取消',
                         `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除：1:是，0:否'
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单biao';