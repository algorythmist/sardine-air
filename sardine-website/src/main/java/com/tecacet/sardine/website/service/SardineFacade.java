package com.tecacet.sardine.website.service;

import com.tecacet.sardine.website.controller.SearchQuery;
import com.tecacet.sardine.website.model.BookingRecord;
import com.tecacet.sardine.website.model.CheckInRecord;
import com.tecacet.sardine.website.model.Flight;

public interface SardineFacade {

    Flight[] getFlights(SearchQuery searchQuery);

    long submitBooking(BookingRecord booking);

    BookingRecord findBooking(long id);

    long createCheckIn(CheckInRecord checkIn);
}
