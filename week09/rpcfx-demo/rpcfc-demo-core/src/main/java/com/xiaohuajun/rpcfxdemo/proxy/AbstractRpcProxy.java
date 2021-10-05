package com.xiaohuajun.rpcfxdemo.proxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午4:54
 * @description AbstractRpcProxy 对代理的缓存，获取处理
 */
public abstract class AbstractRpcProxy {

  /**
   * key:className value:被代理的对象
   */
  private final Map<String, Object> proxyCache = new ConcurrentHashMap<>();


  Object getProxy(String className) {
    return proxyCache.get(className);
  }


  Boolean isExist(String className) {
    return proxyCache.containsKey(className);
  }


  void addProxy(String className, Object proxy) {
    proxyCache.put(className, proxy);
  }


}
