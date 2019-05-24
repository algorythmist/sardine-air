package com.tecacet.sardine.booking.repository;


import com.tecacet.sardine.booking.entity.BookingRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {

}
