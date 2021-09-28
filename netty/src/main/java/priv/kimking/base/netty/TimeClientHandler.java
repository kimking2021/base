package priv.kimking.base.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * <p>
 * <p>
 * A ChannelHandler has two life cycle listener methods: handlerAdded() and handlerRemoved()
 *
 * @author kim
 * @date 2021/9/26
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // ByteBuf m = (ByteBuf) msg;
        // // all received data should be cumulated into buf
        // buf.writeBytes(m);
        // m.release();
        //
        // // the handler must check if buf has enough data
        // // Netty will call the channelRead() method again when more data arrives
        // if (buf.readableBytes() >= 4) {
        //     long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
        //     System.out.println(new Date(currentTimeMillis));
        //     ctx.close();
        // }

        UnixTime m = (UnixTime) msg;
        System.out.println(m);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
