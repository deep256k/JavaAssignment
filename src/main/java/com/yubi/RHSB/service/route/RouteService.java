package com.yubi.RHSB.service.route;

import com.yubi.RHSB.model.Route;
import com.yubi.RHSB.model.RouteResponse;

import java.util.List;

public interface RouteService {

    Route addRoute(Route route) throws Exception;

    List<RouteResponse> getAllRoute();
}

