package com.yubi.RHSB.service.geolocation;

import com.yubi.RHSB.dao.geolocation.GeoLocationDao;
import com.yubi.RHSB.model.Geolocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationDao geoLocationDao;
    @Override
    public List<Geolocation> getLocations() {
        return geoLocationDao.findAllLocation();
    }

    @Override
    public Geolocation findByName (String name){
        return geoLocationDao.findByName(name);
    }

}
