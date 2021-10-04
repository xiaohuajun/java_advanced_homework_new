package com.xiaohuajun.rpcfxdemo.service_register;

import com.xiaohuajun.rpcfxdemo.service.UserService;
import com.xiaohuajun.rpcfxdemo.service.impl.OrderServiceImpl;
import com.xiaohuajun.rpcfxdemo.service.OrderService;
import com.xiaohuajun.rpcfxdemo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:35
 * @description ServerRegister 服务注册：为了简单实现，使用spring 注册bean的方式注册服务;
 * 后续优化用zk
 */
@Configuration
public class ServerRegister {


  @Bean("com.xiaohuajun.rpcfxdemo.service.OrderService")
  public OrderService configOrderServer(){
    return new OrderServiceImpl();
  }

  @Bean("com.xiaohuajun.rpcfxdemo.service.UserService")
  public UserService configUserServer(){
    return new UserServiceImpl();
  }

}
