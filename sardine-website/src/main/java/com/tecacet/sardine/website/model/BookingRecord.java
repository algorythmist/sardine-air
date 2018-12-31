package com.tecacet.sardine.website.model;

import java.util.Date;
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
    private String flightDate;
    private Date bookingDate;
    private String fare;
    private String status;
    Set<Passenger> passengers;

	public BookingRecord(String flightNumber, String from, String to,
                         String flightDate, Date bookingDate, String fare) {
		this.flightNumber = flightNumber;
		this.origin = from;
		this.destination = to;
		this.flightDate = flightDate;
		this.bookingDate = bookingDate;
		this.fare = fare;
 	}

    
}
