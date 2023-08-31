package com.joker.dorabey.model.phone;

import com.joker.dorabey.repository.type.DeviceStatus;
import com.joker.dorabey.repository.type.DeviceType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Phone {
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
