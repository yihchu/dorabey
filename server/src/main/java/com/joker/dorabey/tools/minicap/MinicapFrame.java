package com.joker.dorabey.tools.minicap;

public class MinicapFrame {

    private byte[] header;
    private int headerSize;
    private byte[] body;
    private int bodySize;
    private int offset;

    public MinicapFrame(byte[] bytes, int start, int end) {
        this.header = new byte[4];
        for (int i = start; this.headerSize < 4 && i < end; ++i) {
            this.header[this.headerSize ++] = bytes[i];
        }
        if (this.headerSize < 4) {
            return;
        }
        start += 4;
        this.offset = 0;
        this.bodySize = calcSize();
        this.body = new byte[this.bodySize];
        for (int i = start; i < end; ++i) {
            this.body[this.offset ++] = bytes[i];
        }
    }

    public MinicapFrame append(byte[] bytes, int len) {
        int idx = 0;
        if (this.headerSize < 4) {
            for (; this.headerSize < 4 && idx < len; ++idx) {
                this.header[this.headerSize ++] = bytes[idx];
            }
            if (this.headerSize < 4) {
                return this;
            }
            this.bodySize = calcSize();
        }

        for (; idx < len && this.offset < this.bodySize; ) {
            this.body[this.offset ++] = bytes[idx ++];
        }
        if (idx < len) {
            return new MinicapFrame(bytes, idx, len);
        }
        return null;
    }

    private int calcSize() {
        if (this.headerSize < 4) {
            return -1;
        }
        return ((this.header[3] & 0xFF) << 24)
                | ((this.header[2] & 0xFF) << 16)
                | ((this.header[1] & 0xFF) << 8)
                | ((this.header[0] & 0xFF) << 0);
    }

    public boolean isFull() {
        return this.bodySize == this.offset;
    }

}
