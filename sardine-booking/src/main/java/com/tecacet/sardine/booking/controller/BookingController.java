package com.tecacet.sardine.booking.controller;

import com.tecacet.sardine.booking.component.BookingComponent;
import com.tecacet.sardine.booking.entity.BookingRecord;
import com.tecacet.sardine.booking.integration.InventorySender;
import com.tecacet.sardine.booking.repository.BookingRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/booking")
@RequiredArgsConstructor
@Slf4j
public class BookingController {

    private final BookingComponent bookingComponent;
    private final BookingRepository bookingRepository;
    private final InventorySender sender;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public long book(@RequestBody BookingRecord record) {
        log.debug("Booking Request" + record);
        return bookingComponent.book(record);
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send() {
        Map<String, Object> message = new HashMap<String, Object>();
        message.put("FLIGHT_NUMBER", "SA-101");
        message.put("FLIGHT_DATE", LocalDate.of(2016, 1, 22));
        message.put("NEW_INVENTORY", 2);
        sender.send(message);
    }

    @RequestMapping("/get/{id}")
    public BookingRecord getBooking(@PathVariable long id) {
        return bookingRepository.getOne(id);
    }
}
