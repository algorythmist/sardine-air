package com.tecacet.sardine.booking.repository;


import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tecacet.sardine.booking.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);
	
}
