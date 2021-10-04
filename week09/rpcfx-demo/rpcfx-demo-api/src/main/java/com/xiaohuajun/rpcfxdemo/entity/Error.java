package com.xiaohuajun.rpcfxdemo.entity;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:04
 * @description Error 服务异常消息实体
 */
@Data
public class Error {

  private String message;

  private Integer status;

  public Error(String message, Integer status) {
    this.message = message;
    this.status = status;
  }
}
