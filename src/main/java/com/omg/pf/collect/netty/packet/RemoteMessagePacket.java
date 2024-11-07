package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class RemoteMessagePacket implements GermPacket {
    public List<String> msg;

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public RemoteMessagePacket() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this,var1);
    }


    public void decode(GermByteBuf byteBuf) {
        msg = byteBuf.readStringList();
    }

    public void encode(GermByteBuf byteBuf) {
        byteBuf.writeStringList(msg);
    }

}
