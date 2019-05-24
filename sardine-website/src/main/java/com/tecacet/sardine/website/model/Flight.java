package com.tecacet.sardine.website.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Flight {

    private long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private Fares fares;

    public Flight(String flightNumber, String origin, String destination, LocalDate flightDate, Fares fares) {
        super();
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.fares = fares;
    }


}
