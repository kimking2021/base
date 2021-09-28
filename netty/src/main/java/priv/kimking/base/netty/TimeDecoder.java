package priv.kimking.base.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * <p>
 *
 *  ByteToMessageDecoder:   deal with the fragmentation issue
 *
 * @author kim
 * @date 2021/9/26
 */
public class TimeDecoder extends ByteToMessageDecoder {

    /**
     * ByteToMessageDecoder calls the decode() method with an internally maintained cumulative buffer whenever new data is received.
     * @param ctx
     * @param in
     * @param out
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < 4) {
            return;
        }
        out.add(new UnixTime(in.readUnsignedInt()));
    }

}
