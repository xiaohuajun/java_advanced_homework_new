package com.xiaohuajun.rpcfxdemo.netty.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiaohuajun.rpcfxdemo.api.RpcRequest;
import com.xiaohuajun.rpcfxdemo.api.RpcResponse;
import com.xiaohuajun.rpcfxdemo.exception.RpcException;
import com.xiaohuajun.rpcfxdemo.netty.common.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/5 下午6:15
 * @description RpcServerHandler netty server handler
 */
@Slf4j
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcProtocol> {

  private ApplicationContext context;

  public RpcServerHandler(ApplicationContext context){
    this.context = context;
  }



  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcProtocol)
      throws Exception {
    int msgLen = rpcProtocol.getLen();
    String msgContent = new String(rpcProtocol.getData(), CharsetUtil.UTF_8);
    log.info("netty client is receive message:length:{},content:{}", msgLen, msgContent);
    // 获取 RpcProtocol中的 RpcRequest内容，反序列化成 RpcRequest 对象
    RpcRequest rpcRequest = JSON.parseObject(new String(rpcProtocol.getData(), CharsetUtil.UTF_8),
        RpcRequest.class);
    log.info("Netty server serializer : " + rpcRequest.toString());
    // 获取相应的bean，反射调用方法，获取结果
    RpcResponse response = invoke(rpcRequest);
    // 返回结果给netty 客户端
    RpcProtocol message = new RpcProtocol();
    String requestJson = JSON.toJSONString(response);
    message.setLen(requestJson.getBytes(CharsetUtil.UTF_8).length);
    message.setData(requestJson.getBytes(CharsetUtil.UTF_8));
    channelHandlerContext.writeAndFlush(message).sync();
    log.info("return response to client end");

  }


  /**
   * 获取注册spring的方法并且调用获取结果
   *
   * @param rpcRequest
   * @return 调用服务获取的结果
   */
  private RpcResponse invoke(RpcRequest rpcRequest) {
    RpcResponse response = new RpcResponse();
    String serviceClass = rpcRequest.getServerClass();
    // 作业1：改成泛型和反射
    Object service = context.getBean(serviceClass);
    try {
      Method method = resolveMethodFromClass(service.getClass(), rpcRequest.getMethod());
      Object result = method.invoke(service, rpcRequest.getArgs());
      log.info("Server method invoke result: " + result.toString());
      //两次json序列化能否合并成一个
      response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
      response.setStatus(true);
      log.info("Server Response serialize to string return");
      return response;
    } catch ( IllegalAccessException | InvocationTargetException | RpcException e) {
      e.printStackTrace();
      response.setException(e);
      response.setStatus(false);
      return response;
    }
  }

  private Method resolveMethodFromClass(Class<?> klass, String method) {
    return Arrays.stream(klass.getMethods()).filter(m -> method.equals(m.getName())).findFirst().get();
  }
}
