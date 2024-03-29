package com.yubi.RHSB.service.bus;

import com.yubi.RHSB.dao.bus.BusDao;
import com.yubi.RHSB.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusServiceImpl implements BusService {

    @Autowired
    BusDao busDao;

    @Override
    public List<Bus> getAllBus() {
        List<Bus> allBus = new ArrayList<>();
        allBus = busDao.findAllBus();
        return allBus;
    }

    @Override
    public Bus addBus(Bus bus) throws Exception {
        return busDao.addBus(bus);
    }

    @Override
    public Bus updateBus(Bus bus, String id) throws Exception{
        return busDao.updateBus(bus, id);
    }

    @Override
    public String getRegristrationNoById(String Id) {
       return busDao.getRegNoById(Id);
    }
}

