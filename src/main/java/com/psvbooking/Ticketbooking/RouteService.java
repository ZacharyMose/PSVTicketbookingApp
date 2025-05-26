package com.psvbooking.Ticketbooking;

import org.springframework.stereotype.Service;

import java.util.List;


public interface RouteService {
    List<Route> getRoutes();
    Route getRouteById(Long routeId);
    Route createRoute(Route route);
    Route updateRoute(Route updateRoute, Long routeId);
    Route deleteRoute(Long routeId);
}
