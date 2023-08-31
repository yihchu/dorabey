package com.joker.dorabey.repository.mapper;

import com.joker.dorabey.repository.entity.DeviceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceRepo {
    DeviceEntity findById(int id);
    List<DeviceEntity> findAll();
    int insert(DeviceEntity device);
    int update(DeviceEntity device);
}
