package com.psvbooking.Ticketbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
@CrossOrigin
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    //Get all routes
    @GetMapping
    public ResponseEntity<List<Route>> getRoutes() {
        return ResponseEntity.ok(routeService.getRoutes());
    }

    //Get route id
    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long routeId) {
        Route route = routeService.getRouteById(routeId);
        return ResponseEntity.ok(route);
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route routeCreated = routeService.createRoute(route);
        return ResponseEntity.ok(routeCreated);
    }

    //Update route
    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long routeId, @RequestBody Route updatedRoute) {
        Route route = routeService.updateRoute(updatedRoute,routeId);
        return ResponseEntity.ok(route);
    }

    //Delete route
    @DeleteMapping("/{id}")
    public ResponseEntity<Route> deleteRoute(@PathVariable Long routeId) {
        routeService.deleteRoute(routeId);
        return ResponseEntity.noContent().build();
    }
}
