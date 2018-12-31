package com.tecacet.sardine.fares.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Fare {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String flightNumber;
	private LocalDate flightDate;
	private BigDecimal fare;

	public Fare(String flightNumber, LocalDate flightDate, BigDecimal fare) {
		super();
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.fare = fare;
	}
	
}
