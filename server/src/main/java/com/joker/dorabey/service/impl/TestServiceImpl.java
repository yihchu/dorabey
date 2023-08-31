package com.joker.dorabey.service.impl;

import com.joker.dorabey.annotations.FromEntity;
import com.joker.dorabey.repository.entity.TestEntity;
import com.joker.dorabey.repository.mapper.TestRepo;
import com.joker.dorabey.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestRepo testRepo;

    @Override
    public TestEntity findById(int id) {
        return testRepo.findById(id);
    }

    @Override
    public List<TestEntity> findAll() {
        return testRepo.findAll();
    }
}
