package com.joker.dorabey.service.phone;

import com.joker.dorabey.model.phone.Phone;

import java.util.List;


public interface PhoneService {

    boolean restartADB();

    List<Phone> list();

    boolean connect(String serialNumber);

    boolean disconnect(String serialNumber);

    boolean heartBeat(String serialNumber);

}
