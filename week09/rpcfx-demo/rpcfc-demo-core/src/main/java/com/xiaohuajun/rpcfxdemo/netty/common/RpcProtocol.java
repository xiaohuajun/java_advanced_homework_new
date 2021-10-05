package com.xiaohuajun.rpcfxdemo.netty.common;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午10:45
 * @description RpcProtocol 自定义netty传输协议
 */
@Data
public class RpcProtocol {


  /**
   * 数据长度
   */
  private Integer len;

  /**
   * 数据内容：字节形式传输
   */
  private byte[] data;

}
