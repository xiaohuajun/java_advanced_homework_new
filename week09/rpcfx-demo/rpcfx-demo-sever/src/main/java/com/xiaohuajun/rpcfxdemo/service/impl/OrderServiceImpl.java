package com.xiaohuajun.rpcfxdemo.service.impl;

import com.xiaohuajun.rpcfxdemo.entity.Order;
import com.xiaohuajun.rpcfxdemo.service.OrderService;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:14
 * @description OrderServiceImpl 订单服务
 */
public class OrderServiceImpl implements OrderService {

  @Override
  public Order findByOrderId(String orderId) {
    return new Order("192083", 791L, "RPC-791");
  }
}
