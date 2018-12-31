package com.tecacet.sardine.website.controller;

import java.util.List;
import com.tecacet.sardine.website.model.Flight;
import com.tecacet.sardine.website.model.Passenger;
import lombok.Data;

@Data
public class UIData {
	
	private SearchQuery searchQuery;
	private List<Flight> flights;
	private Flight selectedFlight;
	private Passenger passenger;
	private String bookingid;

}
