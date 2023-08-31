package com.joker.dorabey.service;

import com.joker.dorabey.repository.entity.TestEntity;

import java.util.List;

public interface TestService {

    TestEntity findById(int id);

    List<TestEntity> findAll();
}
