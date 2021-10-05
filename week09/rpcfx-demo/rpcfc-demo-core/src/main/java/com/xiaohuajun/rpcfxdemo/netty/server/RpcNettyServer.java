package com.xiaohuajun.rpcfxdemo.netty.server;

import com.xiaohuajun.rpcfxdemo.netty.common.RpcDecoder;
import com.xiaohuajun.rpcfxdemo.netty.common.RpcEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/5 下午6:06a
 * @description RpcNettyServer netty服务启动类:需要注册applicationContext，因为需要获取注册的服务
 */
@Component
@Slf4j
public class RpcNettyServer {

  private final ApplicationContext context;

  private EventLoopGroup boss;

  private EventLoopGroup worker;

  public RpcNettyServer(ApplicationContext context) {
    this.context = context;
  }

  public void run() {
    boss = new NioEventLoopGroup(1);
    worker = new NioEventLoopGroup();
    ServerBootstrap bootstrap = new ServerBootstrap();
    bootstrap.group(boss, worker).channel(NioServerSocketChannel.class).
        childHandler(new ChannelInitializer<>() {
          @Override
          protected void initChannel(Channel channel) throws Exception {
            ChannelPipeline pipeline = channel.pipeline();
            pipeline.addLast("Message Encoder", new RpcEncoder());
            pipeline.addLast("Message Decoder", new RpcDecoder());
            pipeline.addLast("Message Handler", new RpcServerHandler(context));
          }

        });


  }


  public void destroy() {
    worker.shutdownGracefully();
    boss.shutdownGracefully();
  }


}
