package com.tecacet.sardine.website.service;

import com.tecacet.sardine.website.controller.SearchQuery;
import com.tecacet.sardine.website.model.BookingRecord;
import com.tecacet.sardine.website.model.CheckInRecord;
import com.tecacet.sardine.website.model.Flight;

//@Service
public class FakeSardineFacade implements SardineFacade {
    @Override
    public Flight[] getFlights(SearchQuery searchQuery) {
        return new Flight[0];
    }

    @Override
    public long submitBooking(BookingRecord booking) {
        return 0;
    }

    @Override
    public BookingRecord findBooking(long id) {
        return null;
    }

    @Override
    public long createCheckIn(CheckInRecord checkIn) {
        return 0;
    }
}
