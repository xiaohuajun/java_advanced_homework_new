package com.xiaohuajun.rpcfxdemo.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午10:43
 * @description RpcDecoder 解码器：把protocol转换byte
 */
@Slf4j
public class RpcDecoder extends ByteToMessageDecoder {

  private int dataLength = 0;

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
      List<Object> list) throws Exception {
    log.info("netty decoder start run");
    int c = 4;
    if (byteBuf.readableBytes() >= c) {
      if (dataLength == 0) {
        dataLength = byteBuf.readInt();
      }
      if (byteBuf.readableBytes() < dataLength) {
        log.info("readable data is less,wait");
        return;
      }
      byte[] content = new byte[dataLength];
      //读取数据
      if (byteBuf.readableBytes() >= dataLength) {
        byteBuf.readBytes(content);
        RpcProtocol rpcProtocol = new RpcProtocol();
        rpcProtocol.setLen(dataLength);
        rpcProtocol.setData(content);
        list.add(rpcProtocol);
      }
      dataLength = 0;
    }

  }
}
