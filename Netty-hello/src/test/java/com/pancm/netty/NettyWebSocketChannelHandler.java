package com.pancm.netty;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * 初始化连接时候的各个组件
 * @author liuyazhuang
 *
 */
public class NettyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		//入参说明: 读超时时间、写超时时间、所有类型的超时时间、时间格式
        //因为服务端设置的超时时间是5秒，所以设置4秒
		socketChannel.pipeline().addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));
		socketChannel.pipeline().addLast("http-codec", new HttpServerCodec());
		socketChannel.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
		socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
		socketChannel.pipeline().addLast("handler", new NettyWebSocketHandler());
	}

}
