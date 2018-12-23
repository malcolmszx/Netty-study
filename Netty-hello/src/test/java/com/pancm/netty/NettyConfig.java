package com.pancm.netty;

import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 存储整个工程的全局配置
 * @author liuyazhuang
 *
 */
public class NettyConfig {
	
	/** 空闲次数 */
	public final static int idleCountMax = 2; 
    /** 发送次数 */
	public final static int count = 1;  
	
	/**
	 * 存储客户端接入进来时的channel对象的最大个数
	 */
	public final static Integer channelMaxSize = 1024*2;
	
	/**
	 * 存储每一个客户端接入进来时的channel对象
	 */
	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	
	 /**
     * 获取每一个连接的唯一标示并与channel对象绑定
     */
	
	public static ConcurrentHashMap<String, Channel> concurrentHashMap = new ConcurrentHashMap<String, Channel>(channelMaxSize);
}
