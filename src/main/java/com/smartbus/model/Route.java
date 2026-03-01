package com.smartbus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/*
Represents a bus route between two locations.
 */

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Duration getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Duration travelTime) {
        this.travelTime = travelTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Bus> getBus() {
        return bus;
    }

    public void setBus(List<Bus> bus) {
        this.bus = bus;
    }
}
