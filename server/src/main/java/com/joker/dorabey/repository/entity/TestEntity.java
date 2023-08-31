package com.joker.dorabey.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestEntity {
    private int id;
    private String name;
}
