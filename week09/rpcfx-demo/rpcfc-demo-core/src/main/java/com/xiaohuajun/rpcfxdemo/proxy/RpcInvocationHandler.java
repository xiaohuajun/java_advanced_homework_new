package com.xiaohuajun.rpcfxdemo.proxy;

import com.alibaba.fastjson.parser.ParserConfig;
import com.xiaohuajun.rpcfxdemo.api.RpcRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午5:17
 * @description RpcInvokeHandle 用于gcLib，jdk，byteBuddy
 */
@Slf4j
public class RpcInvocationHandler implements InvocationHandler, MethodInterceptor {

  private final Class<?> serverClass;

  private final  String url;

  public RpcInvocationHandler(Class<?> serverClass, String url) {
    this.serverClass = serverClass;
    this.url = url;
    ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return process(serverClass, method, args, url);
  }


  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    return process(serverClass,method,objects,url);
  }


  private Object process(Class<?> serverClass, Method method, Object[] args, String url) {
    log.info("Client proxy instance method invoke");
    // 自定义了Rpc请求的结构 RpcRequest,放入接口名称、方法名、参数
    log.info("Build Rpc request");
    RpcRequest rpcRequest = new RpcRequest();
    rpcRequest.setServerClass(serverClass.getName());
    rpcRequest.setMethod(method.getName());
    rpcRequest.setArgs(args);


    //使用netty发送请求到客户端


    //序列化返回结果


    return null;
  }
}
