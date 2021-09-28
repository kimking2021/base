package priv.kimking.base.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>
 * Handles a server-side channel.
 *
 * @author kim
 * @date 2021/9/26
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * rdate -o <port> -p <host>
     * <p>
     * the channelActive() method will be invoked when a connection is established and ready to generate traffic.
     *
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        // // Get the current ByteBufAllocator via ChannelHandlerContext.alloc() and allocate a new buffer.
        // final ByteBuf time = ctx.alloc().buffer(4);
        // time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        //
        // final ChannelFuture f = ctx.writeAndFlush(time);
        //
        // //we get notified when a write request is finished
        // f.addListener(new ChannelFutureListener() {
        //     @Override
        //     public void operationComplete(ChannelFuture future) {
        //         assert f == future;
        //         ctx.close();
        //     }
        // });

        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * TimeServer
     * telnet localhost 8080
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // Discard the received data silently.
        // ((ByteBuf) msg).release();

        // ByteBuf in = (ByteBuf) msg;
        // try {
        //     while (in.isReadable()) {
        //         System.out.print((char) in.readByte());
        //         System.out.flush();
        //     }
        // } finally {
        //     ReferenceCountUtil.release(msg);
        // }

        // Netty releases msg Object for you when it is written out to the wire
        ctx.write(msg);
        ctx.flush();
        // ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
