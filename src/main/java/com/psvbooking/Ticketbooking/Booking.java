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
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId; // The user who booked
    @Column(name = "routeid")
    private Long routeid; // The route the user is heading
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    @Column(name = "booking_time")
    private LocalDateTime bookingTime;
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "status")
    private String status;
}
