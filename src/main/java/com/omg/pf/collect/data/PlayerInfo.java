package com.omg.pf.collect.data;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfo {
    private String ip;
    private String playerName;
    private List<String> qqs=new ArrayList<>();
    private List<String> resPacks=new ArrayList<>();
    private String crashClass;
    private final long createTime=System.currentTimeMillis();
    private int joinServerPort;
    private String modUniCode;
    private String server;
    private String joinPlayerName;

    public int getJoinServerPort() {
        return joinServerPort;
    }

    public PlayerInfo setJoinServerPort(int joinServerPort) {
        this.joinServerPort = joinServerPort;
        return this;
    }

    public String getModUniCode() {
        return modUniCode;
    }

    public PlayerInfo setModUniCode(String modUniCode) {
        this.modUniCode = modUniCode;
        return this;
    }

    public String getServer() {
        return server;
    }

    public PlayerInfo setServer(String server) {
        this.server = server;
        return this;
    }

    public String getJoinPlayerName() {
        return joinPlayerName;
    }

    public PlayerInfo setJoinPlayerName(String joinPlayerName) {
        this.joinPlayerName = joinPlayerName;
        return this;
    }

    public String getCrashClass() {
        return crashClass;
    }

    public PlayerInfo setCrashClass(String crashClass) {
        this.crashClass = crashClass;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public PlayerInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerInfo setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public List<String> getQqs() {
        return qqs;
    }

    public PlayerInfo setQqs(List<String> qqs) {
        this.qqs = qqs;
        return this;
    }

    public List<String> getResPacks() {
        return resPacks;
    }

    public PlayerInfo setResPacks(List<String> resPacks) {
        this.resPacks = resPacks;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "ip='" + ip + '\'' +
                ", playerName='" + playerName + '\'' +
                ", qqs=" + qqs +
                ", resPacks=" + resPacks +
                ", crashClass='" + crashClass + '\'' +
                ", createTime=" + createTime +
                ", joinServerPort=" + joinServerPort +
                ", modUniCode='" + modUniCode + '\'' +
                ", server='" + server + '\'' +
                ", joinPlayerName='" + joinPlayerName + '\'' +
                '}';
    }
}
