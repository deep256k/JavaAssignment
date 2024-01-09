package com.yubi.RHSB.controller.geolocation;


import com.yubi.RHSB.model.Geolocation;
import com.yubi.RHSB.service.geolocation.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class GeoLocationController {

    @Autowired
    GeoLocationService geoLocationService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Geolocation>> getAllLocations(){
       List<Geolocation> allLocation =  geoLocationService.getLocations();
       if(!allLocation.isEmpty()){
           return ResponseEntity.ok(allLocation);
       }
        return ResponseEntity.noContent().build();
    }
}

