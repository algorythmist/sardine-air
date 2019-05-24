package com.tecacet.sardine.website.controller;

import com.tecacet.sardine.website.model.Flight;
import com.tecacet.sardine.website.model.Passenger;

import lombok.Data;

import java.util.List;

@Data
public class UIData {

    private SearchQuery searchQuery;
    private List<Flight> flights;
    private Flight selectedFlight;
    private Passenger passenger;
    private String bookingid;

}
