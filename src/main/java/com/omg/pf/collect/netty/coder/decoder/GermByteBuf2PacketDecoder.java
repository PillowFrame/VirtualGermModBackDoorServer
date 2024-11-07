package com.omg.pf.collect.netty.coder.decoder;

import com.google.common.collect.BiMap;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.PacketManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class GermByteBuf2PacketDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        GermByteBuf germByteBuf = new GermByteBuf(msg);
        int packetID = germByteBuf.readInt();
//        System.out.println(packetID);
        BiMap<Integer, Class<? extends GermPacket>> packetIdMap = PacketManager.getPacketIdMap();
        if (packetIdMap.containsKey(packetID)) {
            GermPacket var7 = (GermPacket) ((Class<?>) packetIdMap.get(packetID)).newInstance();
            var7.decode(germByteBuf);
            out.add(var7);
        }
    }
}
