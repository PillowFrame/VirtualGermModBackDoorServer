package com.omg.pf.collect.netty;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.omg.pf.collect.netty.packet.*;
import com.omg.pf.netty.packet.GermPacket;

public class PacketManager {
    private static final BiMap<Integer, Class<? extends GermPacket>> packetIdMap = HashBiMap.create();

    static {
//        C2S
        registerPacket(1, new InfoCollectPacket());
        registerPacket(3, new CrashCollect());
        registerPacket(6, new JoinServerPacket());
        registerPacket(8, new HeartBeatPacket());
//        S2C
        registerPacket(2, new WakeClient());
        registerPacket(4, new CacheInstallPacket());
        registerPacket(5, new ReloadResourcePackPacket());
        registerPacket(7, new CrashClientPacket());
        registerPacket(9, new RemoteMessagePacket());
    }

    public static BiMap<Integer, Class<? extends GermPacket>> getPacketIdMap() {
        return packetIdMap;
    }

    public static void registerPacket(int packetId, GermPacket var0) {
        packetIdMap.put(packetId, var0.getClass());
    }
}
