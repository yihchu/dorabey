package com.joker.dorabey.tools.minicap;

public class MinicapMeta {

    private int version;
    private int headerSize;
    private int pid;
    private int realWidth;
    private int realHeight;
    private int virtualWidth;
    private int virtualHeight;
    private int orientation;
    private int quirkBitFlag;

    public MinicapMeta(byte[] bytes) {
        this.version = bytes[0];
        this.headerSize = bytes[1];
        this.pid = toInt(bytes, 2);
        this.realWidth = toInt(bytes, 6);
        this.realHeight = toInt(bytes, 10);
        this.virtualWidth = toInt(bytes, 14);
        this.virtualHeight = toInt(bytes, 18);
        this.orientation = bytes[22];
        this.quirkBitFlag = bytes[23];
    }

    private int toInt(byte[] bytes, int start) {
        return ((bytes[start + 3] & 0xFF) << 24) |
                ((bytes[start + 2] & 0xFF) << 16) |
                ((bytes[start + 1] & 0xFF) << 8 ) |
                ((bytes[start + 0] & 0xFF) << 0 );
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(">>>>> version = " + this.version);
        builder.append(", headerSize = " + this.headerSize);
        builder.append(", pid = " + this.pid);
        builder.append(", realWidth = " + this.realWidth);
        builder.append(", realHeight = " + this.realHeight);
        builder.append(", virtualWidth = " + this.virtualWidth);
        builder.append(", virtualHeight = " + this.virtualHeight);
        builder.append(", orientation = " + this.orientation);
        builder.append(", quirkBitFlag = " + this.quirkBitFlag);
        return builder.toString();
    }

}
