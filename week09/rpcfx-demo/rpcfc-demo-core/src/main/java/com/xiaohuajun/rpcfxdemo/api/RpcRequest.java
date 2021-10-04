package com.xiaohuajun.rpcfxdemo.api;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午4:32
 * @description RpcRequest rpc请求实体封装
 */
@Data
public class RpcRequest {

  /**
   * 服务接口名称
   */
  private String serverClass;

  /**
   * 方法名
   */
  private String method;


  /**
   * 方法参数
   */
  private Object[] args;


}
