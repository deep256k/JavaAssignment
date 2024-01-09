package com.yubi.RHSB.repository.GeoLocation;

import com.yubi.RHSB.model.Geolocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocationRepository extends MongoRepository<Geolocation, String> {
    Geolocation findByName(String name);

}

