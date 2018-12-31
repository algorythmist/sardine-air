package com.tecacet.sardine.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
public class Flight {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String flightNumber;
	private String origin;
	private String destination;
	private LocalDate flightDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fare_Id")
	private Fares fares;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="inv_Id")
	private Inventory inventory;

	public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares,
			Inventory inventory) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = LocalDate.parse(flightDate, FORMATTER);
		this.fares = fares;
		this.inventory = inventory;
	}
	
}
