package com.psvbooking.Ticketbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final RouteRepository routeRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public BookingService(RouteRepository routeRepository,
                          VehicleRepository vehicleRepository) {
        this.routeRepository = routeRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Returns all vehicle “schedules” (i.e., live vehicle info) for a given
     * pickup point, destination, and requested date-time.
     */
    public List<VehicleResponseDTO> getSchedules(ScheduleRequest request) {

        // 1. Find the route
        Route route = routeRepository
                .findByPickupAndDestination(request.getPickup(),
                        request.getDestination())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No route found from %s to %s".formatted(
                                request.getPickup(), request.getDestination())));

        // 2. Fetch vehicles assigned to that route
        List<Vehicle> vehicles = vehicleRepository.findByRouteId(route.getRoute_id());

        // 3. Map each vehicle to a response DTO
        return vehicles.stream()
                .map(this::toScheduleResponse)
                .collect(Collectors.toList());
    }

    /** Helper mapping method */
    private VehicleResponseDTO toScheduleResponse(Vehicle v) {
        return VehicleResponseDTO.builder()
                .plateNumber(v.getPlateNumber())
                .operator(v.getOperator())
                .routeName(v.getRouteName())              // e.g. “Nairobi CBD → Westlands”
                .currentLocation(v.getCurrentLocation())
                .nextStop(v.getNextStop())
                .estimatedArrivalTime(v.getEstimatedArrivalTime())
                .status(v.getStatus())
                .passengers(v.getPassengers())
                .capacity(v.getCapacity())
                .driverName(v.getDriverName())
                .driverPhone(v.getDriverPhoneNo())
                .build();
    }
}
