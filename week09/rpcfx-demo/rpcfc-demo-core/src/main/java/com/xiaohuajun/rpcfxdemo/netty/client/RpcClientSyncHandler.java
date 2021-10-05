package com.xiaohuajun.rpcfxdemo.netty.client;

import com.alibaba.fastjson.JSON;
import com.xiaohuajun.rpcfxdemo.api.RpcResponse;
import com.xiaohuajun.rpcfxdemo.netty.common.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午10:48
 * @description RpcClientSyncHandler 并发等待拿到结果，从 netty channel 获取结果
 */
@Slf4j
public class RpcClientSyncHandler extends SimpleChannelInboundHandler<RpcProtocol> {

  private CountDownLatch countDownLatch;

  private RpcResponse rpcResponse;

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcProtocol)
      throws Exception {
    int msgLen = rpcProtocol.getLen();
    String msgContent = new String(rpcProtocol.getData(), CharsetUtil.UTF_8);
    log.info("netty client is receive message:length:{},content:{}", msgLen, msgContent);
    //将byte：反序列化；转换response对象
    RpcResponse response = JSON.parseObject(msgContent, RpcResponse.class);
    log.info("Netty client serializer:{} ", rpcResponse.toString());
    rpcResponse = response;
    countDownLatch.countDown();
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }


  /**
   * 为获取结果加锁
   *
   * @param latch 锁
   */
  public void addCountDownLatch(CountDownLatch latch){
    countDownLatch = latch;
  }


  /**
   * 阻塞地获取结果
   *
   * @return netty channel 返回的结果
   * @throws InterruptedException
   */
  public RpcResponse getRpcResponse() throws InterruptedException {
    countDownLatch.await();
    return rpcResponse;
  }


}
