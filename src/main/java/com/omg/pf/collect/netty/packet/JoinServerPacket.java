package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

public class JoinServerPacket implements GermPacket {
    public String uniCode;
    public String player;
    public String server;
    public int port;

    public JoinServerPacket() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this,var1);
    }


    public void decode(GermByteBuf byteBuf) {
        uniCode = byteBuf.readString();
        player = byteBuf.readString();
        server = byteBuf.readString();
        port = byteBuf.readInt();
    }

    public void encode(GermByteBuf byteBuf) {
        byteBuf.writeString(uniCode);
        byteBuf.writeString(player);
        byteBuf.writeString(server);
        byteBuf.writeInt(port);
    }

}
