package com.tecacet.sardine.search.repository;

import com.tecacet.sardine.search.entity.Fares;
import com.tecacet.sardine.search.entity.Flight;
import com.tecacet.sardine.search.entity.Inventory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCrud() {
        Fares fares = new Fares("100");
        Inventory inventory = new Inventory(4);
        Flight flight = new Flight("SA-101", "Sardinia", "Lithuania", "2019-02-12", fares, inventory);
        flightRepository.save(flight);

        assertFalse(flightRepository.findByFlightNumberAndFlightDate("X", LocalDate.parse("2019-02-12")).isPresent());
        assertTrue(flightRepository.findByFlightNumberAndFlightDate("SA-101", LocalDate.parse("2019-02-12")).isPresent());
    }

}
