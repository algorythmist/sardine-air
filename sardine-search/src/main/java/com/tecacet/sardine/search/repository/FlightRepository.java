package com.tecacet.sardine.search.repository;


import com.tecacet.sardine.search.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);

    Optional<Flight> findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);
} 
