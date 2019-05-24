package com.tecacet.sardine.booking.repository;


import com.tecacet.sardine.booking.entity.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);

}
