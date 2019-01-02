package com.tecacet.sardine.website.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingRecord {

    private long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private LocalDateTime bookingDate;
    private String fare;
    private String status;
    private Set<Passenger> passengers = new HashSet<>();

    public BookingRecord(String flightNumber, String from, String to,
                         LocalDate flightDate, LocalDateTime bookingDate, String fare) {
        this.flightNumber = flightNumber;
        this.origin = from;
        this.destination = to;
        this.flightDate = flightDate;
        this.bookingDate = bookingDate;
        this.fare = fare;
    }

}
