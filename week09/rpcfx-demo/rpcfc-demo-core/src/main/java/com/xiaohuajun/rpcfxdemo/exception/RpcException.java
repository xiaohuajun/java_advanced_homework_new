package com.xiaohuajun.rpcfxdemo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午4:39
 * @description RpcException 自定义异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RpcException extends RuntimeException {

  /**
   * 异常消息
   */
  private String message;

  public RpcException(){
    super();
  }

  public RpcException(String message) {
    super(message);
    this.message = message;
  }
}
