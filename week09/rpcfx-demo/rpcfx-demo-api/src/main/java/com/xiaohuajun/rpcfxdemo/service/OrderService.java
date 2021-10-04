package com.xiaohuajun.rpcfxdemo.service;

import com.xiaohuajun.rpcfxdemo.entity.Order;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:07
 * @description OrderService 订单服务接口
 */
public interface OrderService {


  /**
   * 通过订单id查询订单信息
   *
   * @param orderId 订单id
   * @return 订单实体
   */
  Order findByOrderId(String orderId);

}
