package com.xiaohuajun.rpcfxdemo.api;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午4:36
 * @description RpcResponse rpc返回结果实体封装
 */
@Data
public class RpcResponse {


  /**
   * 响应结果
   */
  private Object result;


  /**
   * 服务状态是否成功
   */
  private Boolean status;

  /**
   * 异常
   */
  private Exception exception;

}
