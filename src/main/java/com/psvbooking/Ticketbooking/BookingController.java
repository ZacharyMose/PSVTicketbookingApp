package com.psvbooking.Ticketbooking;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //Get available schedules(Vehicles) based on pickup, destination and date
    @PostMapping
    public List<VehicleResponseDTO> getAvailableSchedules(@RequestBody ScheduleRequest request) {
        return bookingService.getSchedules(request);
    }
}
