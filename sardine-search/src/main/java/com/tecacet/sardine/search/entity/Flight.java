package com.tecacet.sardine.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Flight {

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
		this.flightDate = LocalDate.parse(flightDate);
		this.fares = fares;
		this.inventory = inventory;
	}
	
}
