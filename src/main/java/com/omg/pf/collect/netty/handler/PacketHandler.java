package com.omg.pf.collect.netty.handler;

import com.omg.pf.collect.netty.packet.*;
import io.netty.channel.ChannelHandlerContext;

public abstract class PacketHandler {
    public void onReceivePacket(CacheInstallPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(CrashClientPacket packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(CrashCollect packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(HeartBeatPacket packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(InfoCollectPacket packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(JoinServerPacket packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(ReloadResourcePackPacket packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(RemoteMessagePacket packet, ChannelHandlerContext ctx) {

    }
    public void onReceivePacket(WakeClient packet, ChannelHandlerContext ctx) {

    }
}
