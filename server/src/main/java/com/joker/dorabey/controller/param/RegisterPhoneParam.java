package com.joker.dorabey.controller.param;

import com.joker.dorabey.repository.entity.DeviceEntity;
import com.joker.dorabey.annotations.FromEntity;
import lombok.Data;

@Data
@FromEntity(clazz = DeviceEntity.class)
public class RegisterPhoneParam {

    private String serialNumber;
    // TODO

}
