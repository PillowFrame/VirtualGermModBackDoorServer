package com.omg.pf.collect;


import com.omg.pf.collect.manager.PlayerManager;
import com.omg.pf.collect.netty.NettyMain;
import com.omg.pf.collect.netty.ServerPacketHandler;
import com.omg.pf.collect.netty.handler.HandlerManager;

public class MainServer {
    public static String ip = "0.0.0.0";
    public static int port = 29975;
    private static NettyMain nettyMain;
    public static ServerPacketHandler serverPacketHandler=new ServerPacketHandler();
    private static PlayerManager playerManager=new PlayerManager();


    public static void main(String[] var0) {
        nettyMain = new NettyMain();
        nettyMain.start();
        HandlerManager.registerHandler(serverPacketHandler);
        new Command().startcommand();
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }
}
