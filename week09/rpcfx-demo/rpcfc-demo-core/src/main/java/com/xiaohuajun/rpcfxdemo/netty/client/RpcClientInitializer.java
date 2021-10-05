package com.xiaohuajun.rpcfxdemo.netty.client;


import com.xiaohuajun.rpcfxdemo.netty.common.RpcDecoder;
import com.xiaohuajun.rpcfxdemo.netty.common.RpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午10:35
 * @description RpcClientInitializer 使用netty处理请求然后发给真实的服务-初始化netty
 */
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {


  @Override
  protected void initChannel(SocketChannel socketChannel) throws Exception {
    ChannelPipeline channelPipeline = socketChannel.pipeline();
    channelPipeline.addLast("Message Encoder", new RpcEncoder());
    channelPipeline.addLast("Message Decoder", new RpcDecoder());
    channelPipeline.addLast("clientHandler", new RpcClientSyncHandler());
  }
}
