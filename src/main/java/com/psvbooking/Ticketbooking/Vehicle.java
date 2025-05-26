package com.psvbooking.Ticketbooking;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plate_number")
    private String plateNumber;
    @Column(name = "operator_name")
    private String operator;
    @Column(name = "route_id")
    private Long routeId;
    @Column(name = "route_name")
    private String routeName;
    @Column(name = "current_location")
    private String currentLocation;
    @Column(name = "next_stop")
    private String nextStop;
    @Column(name = "estimated_arrival_time")
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime estimatedArrivalTime;
    @Column(name = "status")
    private String status;
    @Column(name ="passengers")
    private int passengers;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "driver_name")
    private String driverName;
    @Column(name = "driver_phone_no")
    private String driverPhoneNo;

}
