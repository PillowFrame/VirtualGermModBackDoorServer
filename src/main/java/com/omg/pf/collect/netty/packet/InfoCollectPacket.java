package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class InfoCollectPacket implements GermPacket {
    public String version;
    public String playerName;
    public List<String> resourcePackList;
    public String qqList;

    public InfoCollectPacket() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }


    public void decode(GermByteBuf byteBuf) {
        version = byteBuf.readString();
        resourcePackList = byteBuf.readStringList();
        playerName = byteBuf.readString();
        int versionInt = Integer.parseInt(version.replace(".", ""));
        if (versionInt > 439)
//            大于439才会有，之前的版本没有
            qqList = byteBuf.readString();

    }

    public void encode(GermByteBuf byteBuf) {
    }

}
