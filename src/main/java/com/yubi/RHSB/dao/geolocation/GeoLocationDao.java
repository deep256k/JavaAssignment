package com.yubi.RHSB.dao.geolocation;

import com.yubi.RHSB.model.Geolocation;

import java.util.List;

public interface GeoLocationDao {

    Geolocation findByName(String name);

    List<Geolocation> findAllLocation();

    String findLocationById(String id);

    String findNameById(String id);

}

