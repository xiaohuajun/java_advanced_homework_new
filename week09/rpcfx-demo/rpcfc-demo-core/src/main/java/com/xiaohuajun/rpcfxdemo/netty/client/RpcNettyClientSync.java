package com.xiaohuajun.rpcfxdemo.netty.client;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.xiaohuajun.rpcfxdemo.api.RpcRequest;
import com.xiaohuajun.rpcfxdemo.api.RpcResponse;
import com.xiaohuajun.rpcfxdemo.netty.common.RpcProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/5 下午3:09
 * @description RpcNettyClientSync 获取rpc返回的结果处理器，应该是个单例
 */
@Slf4j
public class RpcNettyClientSync {


  private RpcNettyClientSync() {
  }

  /**
   * 枚举实现单例：防止反射和序列化：InputStream.readObject()破坏单例
   */
  private enum EnumSingleton {
    /**
     * 单例
     */
    INSTANCE;

    private RpcNettyClientSync clientSyncInstance;

    /**
     * jvm 保证此方法仅调用一次
     */
    EnumSingleton() {
      clientSyncInstance = new RpcNettyClientSync();
    }

    private RpcNettyClientSync getClientSyncInstance() {
      return clientSyncInstance;
    }
  }

  public static  RpcNettyClientSync getInstance() {
    return EnumSingleton.INSTANCE.getClientSyncInstance();
  }

  /**
   * 缓存channel，下次重复使用-key:ip + port  value:channel
   */
  private Map<String, Channel> channelMap = new ConcurrentHashMap<>();

  private EventLoopGroup clientGroup = new NioEventLoopGroup(
      new ThreadFactoryBuilder().setNameFormat("client work-%d").build());


  /**
   * 发送请求，从channel获取结果
   *
   * @param url 服务地址
   * @return 返回结果
   */
  public RpcResponse getRpcResponse(RpcRequest request,String url)
      throws URISyntaxException, InterruptedException {
    //RpcRequest 请求转化成 rpcProtocol
    RpcProtocol rpcProtocol = convertNettyRequest(request);
    //创建channel：如果不存在就放入map，存在则直接取用调用的chanel，否则新建channel
    URI uri = new URI(url);
    String requestKey = uri.getHost() + ":" +uri.getPort();
    if(channelMap.containsKey(requestKey)){
      Channel channel = channelMap.get(requestKey);
      if( !channel.isOpen() || !channel.isActive() || !channel.isWritable()){
          log.info("channel can't user");
      }else {
        try{
          RpcClientSyncHandler handler = new RpcClientSyncHandler();
          handler.addCountDownLatch(new CountDownLatch(1));
          //替换自定义的处理器
          channel.pipeline().replace("clientHandler","clientHandlerSync",handler);
          //请求写入和刷新channel
          channel.writeAndFlush(rpcProtocol).sync();
          return handler.getRpcResponse();
        }catch (Exception e){
          log.error("channel send msg failed!");
          channel.close();
          channelMap.remove(requestKey);
        }
      }
    }
    //新建channel
    RpcClientSyncHandler handlerForNew = new RpcClientSyncHandler();
    handlerForNew.addCountDownLatch(new CountDownLatch(1));
    //创建新的channel
    Channel newChannel = createChannel(uri);
    newChannel.pipeline().replace("clientHandler","clientHandlerSync",handlerForNew);
    channelMap.put(requestKey, newChannel);
    //请求写入和刷新channel
    newChannel.writeAndFlush(rpcProtocol).sync();
    return handlerForNew.getRpcResponse();
  }

  /**
   * 创建新的chanel
   *
   * @param uri channel的uri
   * @return 新的通道
   */
  private Channel createChannel(URI uri) throws InterruptedException {
    //BootStrap 设置和启动channel
    Bootstrap bootstrap = new Bootstrap();
    //AUTO_CLOSE:自动关闭
    bootstrap.group(clientGroup).option(ChannelOption.AUTO_CLOSE,true).
        //SO_REUSEADDR：可以重复使用端口，但是如果程序挂掉，可能端口一段时间内不释放
        option(ChannelOption.SO_REUSEADDR,true).
        //SO_KEEPALIVE:长连接:当2小时没有数据传输时，TCP 就会自动发起谈探测连接操作-用与TCP连接
        option(ChannelOption.SO_KEEPALIVE,true).
        //TCP_NODELAY:此参数与Nagel算法：将小的数据包组装完大的数据包再一起发送，有效利用网络资源，但是数据会有延迟
        //适合与文件传输
        option(ChannelOption.TCP_NODELAY,true).channel(NioSocketChannel.class)
        .handler(new RpcClientInitializer());
    //连接，绑定通道
    return bootstrap.connect(uri.getHost(),uri.getPort()).sync().channel();
  }


  /**
   * 将 {@RpcRequest} 转成 netty 自定义的通信格式 {@RpcProtocol}
   * @param rpcRequest RpcRequest
   * @return RpcProtocol
   */
  private RpcProtocol convertNettyRequest(RpcRequest rpcRequest) {
    RpcProtocol request = new RpcProtocol();
    String requestJson = JSON.toJSONString(rpcRequest);
    request.setLen(requestJson.getBytes(CharsetUtil.UTF_8).length);
    request.setData(requestJson.getBytes(CharsetUtil.UTF_8));
    return request;
  }

  /**
   * 关闭线程池
   */
  public void destroy() {
    clientGroup.shutdownGracefully();
  }
}
