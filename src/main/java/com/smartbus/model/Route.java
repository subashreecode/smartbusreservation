package com.smartbus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/*
Represents a bus route between two locations.
 */
@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String destination;
    private Double distanceKm;
    private Duration travelTime;

    private Boolean active;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Bus> bus;

}
