package hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloWorldChannelHandler extends ChannelInboundHandlerAdapter {
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		System.out.println("server channelRead...");
		System.out.println(ctx.channel().remoteAddress() + "->server:" + msg.toString());
		ctx.write("server write:" + msg );
		ctx.flush();
	}
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
		cause.printStackTrace();
		ctx.close();
	}
}
