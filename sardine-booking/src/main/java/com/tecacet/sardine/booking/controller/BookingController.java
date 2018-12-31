package com.tecacet.sardine.booking.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tecacet.sardine.booking.component.BookingComponent;
import com.tecacet.sardine.booking.entity.BookingRecord;
import com.tecacet.sardine.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/booking")
@RequiredArgsConstructor
@Slf4j
public class BookingController {

	private final BookingComponent bookingComponent;
	private final BookingRepository bookingRepository;

	@RequestMapping(value="/create" , method = RequestMethod.POST)
	public long book(@RequestBody BookingRecord record){
		log.debug("Booking Request" + record);
		return bookingComponent.book(record);
	}
	
	@RequestMapping("/get/{id}")
	public BookingRecord getBooking(@PathVariable long id) {
		return bookingRepository.getOne(id);
	}	
}
