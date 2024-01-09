package com.yubi.RHSB.service.bus;

import com.yubi.RHSB.model.Bus;

import java.util.List;

public interface BusService {

    List<Bus> getAllBus();

    Bus addBus(Bus bus) throws Exception;

    Bus updateBus(Bus bus, String id) throws Exception;

    String getRegristrationNoById(String Id);
}

