package com.xiaohuajun.rpcfxdemo;

import lombok.extern.slf4j.Slf4j;
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
public class ServerApplication {


  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }

}
