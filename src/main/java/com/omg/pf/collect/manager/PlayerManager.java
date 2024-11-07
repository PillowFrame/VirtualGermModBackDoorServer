package com.omg.pf.collect.manager;

import com.omg.pf.collect.data.PlayerInfo;
import io.netty.channel.ChannelHandlerContext;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

public class PlayerManager {
    //    这里的String是IP
    private final Map<String, PlayerInfo> playerInfoMap = new ConcurrentHashMap<>();
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private final Map<String, ChannelHandlerContext> ctxMap = new ConcurrentHashMap<>();

    public PlayerManager() {
        executor.scheduleAtFixedRate(() -> {
//            检索一直不进入服务器的玩家
            long time = TimeUnit.MINUTES.toMillis(1);
            playerInfoMap.values().forEach(playerInfo -> {
                if (System.currentTimeMillis() - playerInfo.getCreateTime() > time && playerInfo.getJoinServerPort() == 0) {
//                    这个玩家有问题
                    System.out.println("警告:玩家 " + playerInfo.getPlayerName() + " 超过1分钟没有进入服务器");
//                    防止再次检测
                    playerInfo.setJoinServerPort(-1);
                }
            });
        }, 0, 1, TimeUnit.MINUTES);
    }

    public Collection<PlayerInfo> getAllPlayerInfo() {
        return playerInfoMap.values();
    }

    public Map<String, PlayerInfo> getPlayerInfoMap() {
        return playerInfoMap;
    }

    public Map<String, ChannelHandlerContext> getCtxMap() {
        return ctxMap;
    }

    public void onConnect(ChannelHandlerContext ctx) {
        PlayerInfo playerInfo = new PlayerInfo();
        String ip = getIP(ctx);
        playerInfoMap.put(ip, playerInfo);
        playerInfo.setIp(ip);
        ctxMap.put(ip,ctx);
    }

    private String getIP(ChannelHandlerContext ctx) {
        return ctx.channel().remoteAddress().toString();
    }

    public PlayerInfo getPlayerInfo(ChannelHandlerContext ctx) {
        String ip = getIP(ctx);
        return playerInfoMap.get(ip);
    }

    public void onDisConnect(ChannelHandlerContext ctx) {
        String ip = getIP(ctx);
        playerInfoMap.remove(ip);
    }
}
