package com.yubi.RHSB.repository.route;

import com.yubi.RHSB.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}

