package com.tecacet.sardine.fares.repository;

import com.tecacet.sardine.fares.entity.Fare;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FareRepository extends JpaRepository<Fare, Long> {

    Optional<Fare> findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);
}
