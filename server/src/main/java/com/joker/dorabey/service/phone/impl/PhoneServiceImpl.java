package com.joker.dorabey.service.phone.impl;

import com.google.common.collect.Lists;
import com.joker.dorabey.repository.mapper.DeviceRepo;
import com.joker.dorabey.util.CommandUtil;
import com.joker.dorabey.model.phone.Phone;
import com.joker.dorabey.service.phone.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PhoneServiceImpl implements PhoneService {

    @Resource
    private DeviceRepo deviceRepo;

    @Override
    public boolean restartADB() {
        if (CommandUtil.execute("adb kill-server") < 0)
            return false;
        return CommandUtil.execute("adb start-server") > 0;
    }

    @Override
    public List<Phone> list() {
//        deviceRepo.findAll().stream().map(e -> )
        List<Phone> phones = Lists.newArrayList();
        InputStream in = CommandUtil.executeWithOutput("adb devices");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        if (Objects.isNull(reader)) {
            return phones;
        }
        try {
            System.out.println(">>>>>>>>>>");
            String line;
            while (true) {
                if (!((line = reader.readLine()) != null)) break;
                System.out.println(line);
            }
            System.out.println("<<<<<<<<<<");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public boolean connect(String serialNumber) {

        return false;
    }

    @Override
    public boolean disconnect(String serialNumber) {
        return false;
    }

    @Override
    public boolean heartBeat(String serialNumber) {
        return false;
    }
}
