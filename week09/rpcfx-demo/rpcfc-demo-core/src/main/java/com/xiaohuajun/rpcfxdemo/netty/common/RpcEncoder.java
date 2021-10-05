package com.xiaohuajun.rpcfxdemo.netty.common;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午10:40
 * @description RpcEncoder 编码器：主要是把protocol转换byte
 */
@Slf4j
public class RpcEncoder extends MessageToByteEncoder<RpcProtocol> {


  @Override
  protected void encode(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcProtocol,
      ByteBuf byteBuf) throws Exception {
    log.info("netty rpc encode run");
    byteBuf.writeInt(rpcProtocol.getLen());
    byteBuf.writeBytes(rpcProtocol.getData());
  }
}
