package com.joker.dorabey.repository.mapper;

import com.joker.dorabey.repository.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestRepo {
    TestEntity findById(int id);
    List<TestEntity> findAll();
}
