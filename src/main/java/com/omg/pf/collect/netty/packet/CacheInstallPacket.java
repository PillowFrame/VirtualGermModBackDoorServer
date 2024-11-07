package com.omg.pf.collect.netty.packet;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import com.omg.pf.collect.netty.handler.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

public class CacheInstallPacket implements GermPacket {
    public String string;
    public int intVal;

    public void setString(String string) {
        this.string = string;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public CacheInstallPacket() {
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this,var1);
    }


    public void decode(GermByteBuf byteBuf) {
        string = byteBuf.readString();
        intVal = byteBuf.readInt();
    }

    public void encode(GermByteBuf byteBuf) {
        byteBuf.writeString(string);
        byteBuf.writeInt(intVal);
    }

}
