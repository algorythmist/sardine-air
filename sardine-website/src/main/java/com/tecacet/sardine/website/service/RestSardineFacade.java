package com.tecacet.sardine.website.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.tecacet.sardine.website.controller.SearchQuery;
import com.tecacet.sardine.website.model.BookingRecord;
import com.tecacet.sardine.website.model.CheckInRecord;
import com.tecacet.sardine.website.model.Flight;

//TODO:
//@Service
public class RestSardineFacade implements  SardineFacade {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Flight[] getFlights(SearchQuery searchQuery) {
        return restTemplate.postForObject("http://localhost:8090/search/get", searchQuery, Flight[].class);
    }

    @Override
    public long submitBooking(BookingRecord booking) {
        return restTemplate.postForObject("http://localhost:8060/booking/create", booking, long.class);
    }

    @Override
    public BookingRecord findBooking(long id) {
        return restTemplate.getForObject("http://localhost:8060/booking/get/" + id, BookingRecord.class);
    }

    @Override
    public long createCheckIn(CheckInRecord checkIn) {
        return restTemplate.postForObject("http://localhost:8070/checkin/create", checkIn, long.class);
    }
}
