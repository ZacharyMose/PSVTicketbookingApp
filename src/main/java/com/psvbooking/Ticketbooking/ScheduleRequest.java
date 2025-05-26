package com.psvbooking.Ticketbooking;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleRequest {
    private String pickup;
    private String destination;
    private LocalDateTime pickUpTime;
}
