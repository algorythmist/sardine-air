package com.tecacet.sardine.search.component;

import com.tecacet.sardine.search.entity.Flight;
import com.tecacet.sardine.search.entity.Inventory;
import com.tecacet.sardine.search.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class SearchComponent {

    private final FlightRepository flightRepository;

    public List<Flight> search(SearchQuery query) {
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(query.getOrigin(),
                query.getDestination(),
                LocalDate.parse(query.getFlightDate()));
        return flights.stream()
                .filter(flight -> flight.getInventory().getCount() > 0)
                .collect(Collectors.toList());
    }

    public void updateInventory(String flightNumber, LocalDate flightDate, int inventory) {
        log.info("Updating inventory for flight {}: inventory = {} ", flightNumber, inventory);
        Flight flight =
                flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate)
                        .orElseThrow(() -> new FlightNotFoundException());
        Inventory inv = flight.getInventory();
        inv.setCount(inventory);
        flightRepository.save(flight);
    }
}
