package com.omg.pf.netty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

public class ExceptionHandler implements ChannelHandler {
    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        if (throwable instanceof IOException) {
            if (throwable.getMessage().contains("强迫")) return;
            if (throwable.getMessage().contains("Connection reset")) return;
        }
        throwable.printStackTrace();
    }
}
