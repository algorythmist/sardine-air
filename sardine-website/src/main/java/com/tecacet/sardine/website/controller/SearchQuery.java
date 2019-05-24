package com.tecacet.sardine.website.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchQuery {

    private String origin;
    private String destination;
    private String flightDate;

    public SearchQuery(String origin, String destination, String flightDate) {
        super();
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
    }


}
