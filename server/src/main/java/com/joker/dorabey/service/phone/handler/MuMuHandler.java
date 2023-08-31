package com.joker.dorabey.service.phone.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MuMuHandler extends ChannelInboundHandlerAdapter {

//    private int readBannerBytes = 0;
//    private int bannerLength = 2;
//    private int readFrameBytes = 0;
//    private int frameBodyLength = 0;
//    private byte[] frameBody = new byte[0];

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // TODO
//        if (msg instanceof ByteBuf) {
//            byte[] bytes = ((ByteBuf)msg).array();
//            int len = bytes.length;
//            for (int cursor = 0; cursor < len;) {
//                int byte10 = bytes[cursor] & 0xff;
//                if (readBannerBytes < bannerLength) {
//
//                } else if (readFrameBytes < 4) {
//
//                } else {
//
//                }
//            }
//        }
//        ctx.channel().close();
    }

}
