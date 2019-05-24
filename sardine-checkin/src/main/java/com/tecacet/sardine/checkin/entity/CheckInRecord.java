package com.tecacet.sardine.checkin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CheckInRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String lastName;
    private String firstName;
    private String seatNumber;
    private LocalDateTime checkInTime;
    private String flightNumber;
    private LocalDate flightDate;
    private long bookingId;

    public CheckInRecord(String lastName, String firstName, String seatNumber, LocalDateTime checkInTime, String flightNumber, LocalDate flightDate,
            long bookingId) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.seatNumber = seatNumber;
        this.checkInTime = checkInTime;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.bookingId = bookingId;
    }

}
