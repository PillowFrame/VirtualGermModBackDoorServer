package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

public class CrashCollect implements GermPacket {
    public String className;

    public CrashCollect() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this,var1);
    }


    public void decode(GermByteBuf byteBuf) {
        className = byteBuf.readString();
    }

    public void encode(GermByteBuf byteBuf) {
        byteBuf.writeString(className);
    }

}
