package com.yubi.RHSB.dao.bus;

import com.yubi.RHSB.model.Bus;
import com.yubi.RHSB.repository.bus.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class BusDaoImpl implements BusDao {
    @Autowired
    BusRepository busRepository;


    @Override
    public Bus addBus(Bus bus) throws Exception {

        Bus existingBus = findByRegNo(bus.getRegisterationNumber());
        if (existingBus==null)
            bus = busRepository.save(bus);
        else
            throw new Exception("Bus already exist");
        return bus;
    }

    public List<Bus> findAllBus() {
        List<Bus> allBus = new ArrayList<>();
        allBus = busRepository.findAll();
        return allBus;
    }

    public Bus updateBus(Bus bus, String id) throws Exception {
        Optional<Bus> existingBus = findById(id);
        if(existingBus.isPresent()){
            System.out.println("existingBus.get().getRegisterationNumber()"+ existingBus.get().getRegisterationNumber());
            System.out.println("bus.getRegisterationNumber()" + bus.getRegisterationNumber());

            if(!Objects.equals(existingBus.get().getRegisterationNumber(), bus.getRegisterationNumber())){
                throw new Exception("Bus registration number does not match");
            } else{
                bus.setId(id);
                return busRepository.save(bus);
            }

        } else{
          throw new Exception("Bus does not exist");
        }
    }


    @Override
    public Bus findByRegNo(String regNo) {
        return busRepository.findByRegisterationNumber(regNo);
    }

    @Override
    public Bus findByType(String type) {
        return null;
    }

    @Override
    public Optional<Bus> findById(String id){
        return busRepository.findById(id);
    }

    @Override
    public String getRegNoById(String id){
        Optional<Bus> newBus = busRepository.findById(id);
        if(newBus.isPresent()){
            return newBus.get().getRegisterationNumber();
        }
        return "";
    }
}

