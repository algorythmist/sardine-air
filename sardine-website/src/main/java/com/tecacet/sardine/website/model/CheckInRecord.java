package com.tecacet.sardine.website.model;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckInRecord {

 	long id;
    String lastName;
    String firstName;
    String seatNumber;
    Date checkInTime;
    String flightNumber;
    String flightDate;
    long bookingId;

	public CheckInRecord(String lastName, String firstName, String seatNumber, Date checkInTime, String flightNumber,
			String flightDate, long bookingId) {
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
