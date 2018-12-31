package com.tecacet.sardine.website.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Flight {

  	long id;
	
	String flightNumber;
	String origin;
	String destination;
	String flightDate;
 	Fares fares;

	public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.fares = fares;
	}

	
}
