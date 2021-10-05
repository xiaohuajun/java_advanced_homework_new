package com.xiaohuajun.rpcfxdemo;

import com.xiaohuajun.rpcfxdemo.entity.Order;
import com.xiaohuajun.rpcfxdemo.entity.User;
import com.xiaohuajun.rpcfxdemo.proxy.RpcByteBuddy;
import com.xiaohuajun.rpcfxdemo.proxy.RpcClient;
import com.xiaohuajun.rpcfxdemo.proxy.RpcClientJdk;
import com.xiaohuajun.rpcfxdemo.service.OrderService;
import com.xiaohuajun.rpcfxdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/5 下午6:29
 * @description ClientApplication 客户端
 */
@Slf4j
public class ClientApplication {

  public static void main(String[] args) {

    RpcClient jdk = new RpcClientJdk();
    UserService userService = jdk.createServerStub(UserService.class, "http://localhost:8080/");
    User user = userService.findByUserId(1);
    if (user == null) {
      log.info("Clint service invoke Error");
      return;
    }
    System.out.println("find user id=1 from server: " + user.getName());

    RpcClient buddy = new RpcByteBuddy();
    OrderService orderService = buddy.createServerStub(OrderService.class, "http://localhost:8080/");
    Order order = orderService.findByOrderId("192083");
    if (order == null) {
      log.info("Clint service invoke Error");
      return;
    }
    System.out.println(String.format("find order orderId=%s name=%s, user=%d",
        order.getOrderId(),order.getUserName(),order.getUserId()));

  }

}
