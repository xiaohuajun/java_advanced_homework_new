package com.xiaohuajun.rpcfxdemo.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/5 下午5:29
 * @description RpcClientCglib cglib实现
 */
@Slf4j
public class RpcClientCglib extends AbstractRpcProxy implements RpcClient {

  @Override
  public <T> T createServerStub(Class<T> serverClass, String url) {
    if (!isExist(serverClass.getName())) {
      addProxy(serverClass.getName(), newProxy(serverClass, url));
    }
    return (T) getProxy(serverClass.getName());
  }

  private <T> T newProxy(Class<T> serverClass, String url) {
    Enhancer enhancer = new Enhancer();
    enhancer.setCallback(new RpcInvocationHandler(serverClass, url));
    enhancer.setSuperclass(serverClass);
    log.info("client cglib proxy instance create and return");
    return (T) enhancer.create();
  }
}
