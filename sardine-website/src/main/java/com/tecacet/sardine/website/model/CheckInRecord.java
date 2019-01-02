package com.tecacet.sardine.website.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckInRecord {

 	private long id;
    private String lastName;
    private String firstName;
    private String seatNumber;
    private LocalDateTime checkInTime;
    private String flightNumber;
    private LocalDate flightDate;
    private long bookingId;

	public CheckInRecord(String lastName, String firstName, String seatNumber, LocalDateTime checkInTime, String flightNumber,
			LocalDate flightDate, long bookingId) {
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
