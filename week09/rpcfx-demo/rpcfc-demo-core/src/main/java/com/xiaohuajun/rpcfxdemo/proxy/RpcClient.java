package com.xiaohuajun.rpcfxdemo.proxy;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午4:47
 * @description RpcClient 用户创建rpc客户端，也就是与正在的调用端存根
 */
public interface RpcClient {

  /**
   * 调用端获取对应的服务存根
   *
   * @param serverClass  调用端需要调用的服务
   * @param url 服务地址
   * @param <T> 服务存根的类型
   * @return 服务存根
   */
  <T> T createServerStub(Class<T> serverClass,String url);

}
