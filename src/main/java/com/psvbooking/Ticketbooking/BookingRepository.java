package com.psvbooking.Ticketbooking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);

    // Find booking by route id
    List<Booking> findByRouteid(Long routeid);

    //Find bookings by route id and user id to avoid duplicates
    Booking findByUserIdAndRouteid(Long userId, Long routeid);
    }
