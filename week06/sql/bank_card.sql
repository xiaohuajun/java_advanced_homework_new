CREATE TABLE `bank_card` (
                             `card_id` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡id',
                             `card_no` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡号',
                             `bank_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '开户行名称',
                             `card_status` int NOT NULL COMMENT '银行卡状态：0：解绑 1:正常',
                             `user_id` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
                             `bound_time` datetime NOT NULL COMMENT '绑定时间',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             PRIMARY KEY (`card_id`,`card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户银行卡表';