package com.tecacet.sardine.website.service;

import com.tecacet.sardine.website.controller.SearchQuery;
import com.tecacet.sardine.website.model.BookingRecord;
import com.tecacet.sardine.website.model.CheckInRecord;
import com.tecacet.sardine.website.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestSardineFacade implements SardineFacade {


    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Flight[] getFlights(SearchQuery searchQuery) {
        return restTemplate.postForObject("http://search-service/search/get", searchQuery, Flight[].class);
    }

    @Override
    public long submitBooking(BookingRecord booking) {
        return restTemplate.postForObject("http://booking-service/booking/create", booking, Long.class);
    }

    @Override
    public BookingRecord findBooking(long id) {
        return restTemplate.getForObject("http://booking-service/booking/get/" + id, BookingRecord.class);
    }

    @Override
    public long createCheckIn(CheckInRecord checkIn) {
        return restTemplate.postForObject("http://checkin-service/checkin/create", checkIn, long.class);
    }
}
