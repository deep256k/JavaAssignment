package com.yubi.RHSB.service.route;

import com.yubi.RHSB.dao.bus.BusDao;
import com.yubi.RHSB.dao.geolocation.GeoLocationDao;
import com.yubi.RHSB.dao.route.RouteDao;
import com.yubi.RHSB.model.Route;
import com.yubi.RHSB.model.RouteResponse;
import com.yubi.RHSB.service.bus.BusService;
import com.yubi.RHSB.service.geolocation.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDao routeDao;

    @Autowired
    BusDao busService;

    @Autowired
    GeoLocationDao geoLocationService;


    @Override
    public Route addRoute(Route route) throws Exception {
        validateAddRoute(route);
        return routeDao.addRoute(route);
    }

    public void validateAddRoute(Route route) throws Exception {
        String busId = route.getBusId();
        String sourceId = route.getSourceId();
        String destinationId = route.getDestinationId();
        if(busId == null) throw new Exception("Bus Id is not present");
        if(sourceId == null) throw new Exception("Source Id is not present");
        if(destinationId == null)  throw new Exception("Destination Id is not present");

        if(busService.findById(busId).isEmpty()) throw new Exception("Bus Id is not valid");
        if(geoLocationService.findLocationById(sourceId) ==  null) throw new Exception("Bus Id is not valid");
        if(geoLocationService.findLocationById(destinationId)== null)  throw new Exception("Bus Id is not valid");
    }

    @Override
    public List<RouteResponse> getAllRoute() {
        List<Route> allRoutes =  routeDao.findAllRoute();
        List<RouteResponse> routeResponses = new ArrayList<>();
        allRoutes.forEach(route -> {
            routeResponses.add(setRouteResponse(route));
        });
        return routeResponses;
    }

    public RouteResponse setRouteResponse(Route route){
        RouteResponse newRouteResponse = new RouteResponse();
        String busId = route.getBusId();
        String sourceId = route.getSourceId();
        String destinationId = route.getDestinationId();
        newRouteResponse.setBusRegNo(busService.getRegNoById(busId));
        newRouteResponse.setSource(geoLocationService.findNameById(sourceId));
        newRouteResponse.setDestination(geoLocationService.findNameById(destinationId));
        newRouteResponse.setRouteName(route.getRouteName());
        newRouteResponse.setId(route.getId());
        newRouteResponse.setArrivalTime(route.getArrivalTime());
        newRouteResponse.setDepartureTime(route.getDepartureTime());
        return newRouteResponse;
    }
}

