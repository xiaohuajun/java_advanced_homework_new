package com.xiaohuajun.rpcfxdemo;

import com.xiaohuajun.rpcfxdemo.netty.server.RpcNettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 上午10:57
 * @description ServerApplication:启动方式：spring boot 启动；netty 启动
 */
@SpringBootApplication
@Slf4j
public class ServerApplication  implements ApplicationRunner {

  private RpcNettyServer rpcNettyServer;

  public ServerApplication(RpcNettyServer rpcNettyServer) {
    this.rpcNettyServer = rpcNettyServer;
  }

  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try {
      rpcNettyServer.run();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      rpcNettyServer.destroy();
    }
  }
}
