package com.joker.dorabey.repository.entity;

import com.joker.dorabey.repository.type.DeviceType;
import com.joker.dorabey.repository.type.DeviceStatus;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeviceEntity {

    private String serialNumber;
    private String name;
    private DeviceType type;
    private DeviceStatus status;
    private int realWidth;
    private int realHeight;
    private int virtualWidth;
    private int virtualHeight;
    private String image;

}
