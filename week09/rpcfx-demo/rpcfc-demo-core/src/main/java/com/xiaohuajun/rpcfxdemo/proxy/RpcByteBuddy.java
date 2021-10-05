package com.xiaohuajun.rpcfxdemo.proxy;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/5 下午5:37
 * @description RpcByteBuddy 使用字节增强技术-byteBuddy提供的api，实现动态代理
 */
@Slf4j
public class RpcByteBuddy extends AbstractRpcProxy implements RpcClient {

  @Override
  public <T> T createServerStub(Class<T> serverClass, String url) {
    if(!isExist(serverClass.getName())){
      addProxy(serverClass.getName(),newProxy(serverClass,url));
    }
    return (T) getProxy(serverClass.getName());
  }

  /**
   * SneakyThrows ： 不用自己处理异常
   * @param serverClass
   * @param url
   * @param <T>
   * @return
   */
  @SneakyThrows
  private <T> T newProxy(Class<T> serverClass, String url) {
    ByteBuddy byteBuddy = new ByteBuddy();
    Object instance = byteBuddy.subclass(Object.class).implement(serverClass).
        intercept(InvocationHandlerAdapter.of(new RpcInvocationHandler(serverClass, url))).make().
        load(RpcByteBuddy.class.getClassLoader()).getLoaded().getConstructor().newInstance();
    return (T)instance;
  }
}
