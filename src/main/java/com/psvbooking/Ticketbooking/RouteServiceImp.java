package com.psvbooking.Ticketbooking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImp implements RouteService{
    private RouteRepository routeRepository;

    public RouteServiceImp(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route getRouteById(Long routeId){
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Route updateRoute, Long routeId){
        Route existingRoute = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));

        existingRoute.setPickup(updateRoute.getPickup());
        existingRoute.setDestination(updateRoute.getDestination());
        existingRoute.setDistance(updateRoute.getDistance());

        return routeRepository.save(existingRoute);
    }

    @Override
    public Route deleteRoute(Long routeId) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));
        routeRepository.delete(route);
        return route;
    }
}
