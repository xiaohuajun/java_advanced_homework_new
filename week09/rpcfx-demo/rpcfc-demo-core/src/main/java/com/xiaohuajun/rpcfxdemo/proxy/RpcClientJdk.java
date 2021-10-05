package com.xiaohuajun.rpcfxdemo.proxy;

import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午4:52
 * @description RpcClientJdk 使用jdk的动态代理创建服务
 */
@Slf4j
public class RpcClientJdk extends AbstractRpcProxy implements RpcClient {

  @Override
  public <T> T createServerStub(Class<T> serverClass, String url) {
    if (!isExist(serverClass.getName())) {
      addProxy(serverClass.getName(), newProxy(serverClass, url));
    }
    return (T) getProxy(serverClass.getName());
  }


  /**
   * 创建代理对象
   *
   * @param serverClass 被代理的对象
   * @param url         服务地址
   * @param <T>         代理对象的类型
   * @return 代理对象
   */
  private <T> Object newProxy(Class<T> serverClass, String url) {
    //当前类的类加载器
    ClassLoader classLoader = RpcClientJdk.class.getClassLoader();
    //被代理的对象
    Class[] classes = new Class[]{serverClass};
    log.info("client jdk proxy instance create and return");
    //invokeHandle:invoke方法中传被代理对象
    return  (T)Proxy.newProxyInstance(classLoader,classes,new RpcInvocationHandler(serverClass,url));
  }


}
