package com.psvbooking.Ticketbooking;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VehicleResponseDTO {
    private String plateNumber;
    private String operator;
    private String currentLocation;
    private String nextStop;
    private LocalDateTime estimatedArrivalTime;
    private String routeName;
    private int capacity;
    private int passengers;
    private String status;
    private String driverName;
    private String driverPhone;

}
