package com.joker.dorabey.controller;

import com.joker.dorabey.controller.param.RegisterPhoneParam;
import com.joker.dorabey.model.common.DRBResponse;
import com.joker.dorabey.service.phone.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value="Dorabey App", tags = {"Phone"})
@RestController
@RequestMapping("/phone")
public class DeviceController {

    @Autowired
    private PhoneService phoneService;

    @ApiOperation(value = "Connect Phone", response = DRBResponse.class)
    @GetMapping("/{serialNumber}/connect")
    public Object connect(@PathVariable String serialNumber) {
        return DRBResponse.success(phoneService.connect(serialNumber));
    }

    @ApiOperation(value = "List Phones", response = DRBResponse.class)
    @GetMapping("/list")
    public Object listPhones() {
        return DRBResponse.success(phoneService.list());
    }

    @ApiOperation(value = "Register Phone", response = DRBResponse.class)
    @PostMapping("/register")
    public Object registerPhone(@RequestBody RegisterPhoneParam param) {
        // TODO
        RegisterPhoneParam p = new RegisterPhoneParam();
        return DRBResponse.success();
    }

}