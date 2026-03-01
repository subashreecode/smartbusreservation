package com.smartbus.dto;

import java.time.LocalTime;

public class BusSearchResponseDTO {

    private Long id;
    private String busNumber;
    private String operatorName;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Double price;
    private Double rating;
    private RouteDTO route;

    public BusSearchResponseDTO(Long id, String busNumber, String operatorName,
                  LocalTime departureTime, LocalTime arrivalTime,
                  Double price, Double rating, RouteDTO route) {
        this.id = id;
        this.busNumber = busNumber;
        this.operatorName = operatorName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.rating = rating;
        this.route = route;
    }

    public BusSearchResponseDTO() {}

    public BusSearchResponseDTO(Long id, String busNumber, String operatorName, LocalTime departureTime, LocalTime arrivalTime, Double price) {
    }

    public class RouteDTO {

        private Long id;
        private String source;
        private String destination;
        private Double distanceKm;

        public RouteDTO(Long id, String source, String destination, Double distanceKm) {
            this.id = id;
            this.source = source;
            this.destination = destination;
            this.distanceKm = distanceKm;
        }

        public RouteDTO() {}
    }

}
