package com.yubi.RHSB.repository.bus;

import com.yubi.RHSB.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String> {
    Bus findByRegisterationNumber(String regNumber);
}

