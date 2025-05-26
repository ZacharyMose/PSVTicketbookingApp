package com.psvbooking.Ticketbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
List<Vehicle> findByRouteId(Long routeId);
}
