package com.tecacet.sardine.search.component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class SearchQuery {

    private final String origin;
    private final String destination;
    private final String flightDate;

}
