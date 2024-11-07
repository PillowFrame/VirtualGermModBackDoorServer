package com.omg.pf.collect.netty;

import com.omg.pf.collect.MainServer;
import com.omg.pf.collect.data.PlayerInfo;
import com.omg.pf.collect.netty.handler.PacketHandler;
import com.omg.pf.collect.netty.packet.CrashCollect;
import com.omg.pf.collect.netty.packet.InfoCollectPacket;
import com.omg.pf.collect.netty.packet.JoinServerPacket;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerPacketHandler extends PacketHandler {
    @Override
    public void onReceivePacket(CrashCollect packet, ChannelHandlerContext ctx) {
        PlayerInfo playerInfo = MainServer.getPlayerManager().getPlayerInfo(ctx);
        playerInfo.setCrashClass(packet.className);
//        进行打印
        System.out.println("玩家发生崩溃 " + playerInfo);
    }

    @Override
    public void onReceivePacket(InfoCollectPacket packet, ChannelHandlerContext ctx) {
        PlayerInfo playerInfo = MainServer.getPlayerManager().getPlayerInfo(ctx);
        playerInfo.setPlayerName(packet.playerName);
        String qqList = packet.qqList;
        if (qqList != null && !qqList.isEmpty()) {
            List<String> qqs = new ArrayList<>();
            Collections.addAll(qqs, qqList.split(","));
            playerInfo.setQqs(qqs);
        }
        playerInfo.setResPacks(packet.resourcePackList);
//        进行打印
        System.out.println("玩家后门接入 " + packet.playerName + " 版本：" + packet.version + " QQ：" + packet.qqList + " 材质包列表：" + packet.resourcePackList);
    }

    @Override
    public void onReceivePacket(JoinServerPacket packet, ChannelHandlerContext ctx) {
        PlayerInfo playerInfo = MainServer.getPlayerManager().getPlayerInfo(ctx);
        playerInfo.setModUniCode(packet.uniCode);
        playerInfo.setServer(packet.server);
        playerInfo.setJoinPlayerName(packet.player);
        playerInfo.setJoinServerPort(packet.port);
//        进行打印
        System.out.println("玩家加入服务器 " + playerInfo.getPlayerName() + " mod唯一码：" + packet.uniCode + " 服务器IP地址：" + packet.server + ":" + packet.port + " 加入使用玩家名：" + packet.player);
    }
}
