package com.yubi.RHSB.dao.route;

import com.yubi.RHSB.model.Route;
import com.yubi.RHSB.repository.route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteDaoImpl implements RouteDao{

    @Autowired
    RouteRepository routeRepository;
    @Override
    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Route route) {
        return null;
    }

    @Override
    public Route deleteRoute(Route route) {
        return null;
    }

    @Override
    public List<Route> findAllRoute() {
        List<Route> allRoutes = new ArrayList<>();
        allRoutes= routeRepository.findAll();
        return allRoutes;
    }
}
