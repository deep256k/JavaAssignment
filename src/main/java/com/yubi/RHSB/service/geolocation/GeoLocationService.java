package com.yubi.RHSB.service.geolocation;

import com.yubi.RHSB.model.Geolocation;

import java.util.List;

public interface GeoLocationService {

    List<Geolocation> getLocations();

    Geolocation findByName(String name);
}

