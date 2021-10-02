CREATE TABLE `address` (
                           `address_id` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址id',
                           `address_detail` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址详情',
                           `user_id` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
                           `address_status` tinyint(1) NOT NULL COMMENT '地址状态0:删除，1:正常',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户地址表';