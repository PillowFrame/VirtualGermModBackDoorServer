package com.omg.pf.netty.coder.decoder;

import com.omg.pf.netty.util.GermByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;

import java.util.List;

//普通ByteBuf转为萌芽ByteBuf
public class ByteBuf2GermByteBufDecoder extends ByteToMessageDecoder {
    public void decode(ChannelHandlerContext var1, ByteBuf var2, List var3) throws Exception {
        var2.markReaderIndex();
        byte[] var4 = new byte[3];

        for (int var5 = 0; var5 < var4.length; ++var5) {
            if (!var2.isReadable()) {
                var2.resetReaderIndex();
                return;
            }

            var4[var5] = var2.readByte();
            if (var4[var5] >= 0) {
                GermByteBuf var6 = new GermByteBuf(Unpooled.wrappedBuffer(var4));

                try {
                    int var7 = var6.readVarInt();
                    if (var2.readableBytes() < var7) {
                        var2.resetReaderIndex();
                        return;
                    }

                    var3.add(var2.readBytes(var7));
                } finally {
                    var6.release();
                }

                return;
            }
        }

        throw new CorruptedFrameException("length wider than 21-bit");
    }
}
