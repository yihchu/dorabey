package com.joker.dorabey.repository.type;

public enum DeviceStatus implements BaseCodeEnum {
    USING(10),
    MAINTAIN(40),
    ERROR(70);

    private int code;

    private DeviceStatus(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
