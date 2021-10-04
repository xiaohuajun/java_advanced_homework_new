package com.xiaohuajun.rpcfxdemo.entity;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:02
 * @description Order 订单实体
 */
@Data
public class Order {

  private String orderId;

  private Long userId;

  private String userName;

  public Order(String orderId, Long userId, String userName) {
    this.orderId = orderId;
    this.userId = userId;
    this.userName = userName;
  }
}
