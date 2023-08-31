package com.joker.dorabey.controller;

import com.joker.dorabey.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Dorabey App", tags = {"Test"})
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "Get By Id", response = String.class)
    @RequestMapping("/{id}/info")
    public Object getById(@PathVariable int id) {
        return testService.findById(id);
    }

    @ApiOperation(value = "Get All", response = String.class)
    @RequestMapping("/list")
    public Object getUsers() {
        return testService.findAll();
    }
}
