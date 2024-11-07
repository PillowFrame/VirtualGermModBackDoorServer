package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class ReloadResourcePackPacket implements GermPacket {
    public String resourcePack;
    public String asset;
    public List<String> nousedList;

    public void setResourcePack(String resourcePack) {
        this.resourcePack = resourcePack;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setNousedList(List<String> nousedList) {
        this.nousedList = nousedList;
    }

    public ReloadResourcePackPacket() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this,var1);
    }


    public void decode(GermByteBuf byteBuf) {
        resourcePack = byteBuf.readString();
        asset = byteBuf.readString();
        nousedList = byteBuf.readStringList();
    }

    public void encode(GermByteBuf byteBuf) {
        byteBuf.writeString(resourcePack);
        byteBuf.writeString(asset);
        byteBuf.writeStringList(nousedList);
    }

}
