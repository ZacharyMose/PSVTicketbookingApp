package com.psvbooking.Ticketbooking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    // Find by pick up and destination
    Optional<Route> findByPickupAndDestination(String pickup, String destination);
}
