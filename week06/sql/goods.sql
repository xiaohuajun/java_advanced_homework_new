CREATE TABLE `goods` (
                         `goods_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品id',
                         `goods_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
                         `goods_title_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '商品标题描述',
                         `goods_price` decimal(10,2) NOT NULL COMMENT '商品价格',
                         `goods_img_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品图片',
                         `goods_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品详情',
                         `goods_status` int DEFAULT NULL COMMENT '商品状态 0：删除，1:正常 ',
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品表';