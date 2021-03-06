package com.tecacet.sardine.booking.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
public class BookingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private LocalDateTime bookingDate;
    private BigDecimal fare;
    private BookingStatus status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bookingRecord")
    private Set<Passenger> passengers = new HashSet<>();

    public BookingRecord(String flightNumber, String from, String to, LocalDate flightDate, LocalDateTime bookingDate, BigDecimal fare) {
        this.flightNumber = flightNumber;
        this.origin = from;
        this.destination = to;
        this.flightDate = flightDate;
        this.bookingDate = bookingDate;
        this.fare = fare;
        this.status = status;
    }

    public void addPassenger(String firstName, String lastName, Passenger.Gender gender) {
        passengers.add(new Passenger(firstName, lastName, gender, this));
    }

}
