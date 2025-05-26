package com.psvbooking.Ticketbooking;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long route_id;
    @Column(name = "pick_up")
    private String pickup;
    @Column(name = "destination")
    private String destination;
    @Column(name = "distance")
    private  Double distance;
}
