package com.tecacet.sardine.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.tecacet.sardine.booking.entity.BookingRecord;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
	
}
