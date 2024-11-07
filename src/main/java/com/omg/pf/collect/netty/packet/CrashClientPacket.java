package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

public class CrashClientPacket implements GermPacket {
    public CrashClientPacket() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this,var1);
    }


    public void decode(GermByteBuf var1) {

    }

    public void encode(GermByteBuf var1) {
    }
}
