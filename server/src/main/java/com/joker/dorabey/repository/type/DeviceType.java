package com.joker.dorabey.repository.type;

public enum DeviceType implements BaseCodeEnum {
    Android_Phone(11),
    Android_PAD(12),
    Android_Emulator(13);

    private int code;

    private DeviceType(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
