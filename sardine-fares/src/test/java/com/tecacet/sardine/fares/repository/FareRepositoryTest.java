package com.tecacet.sardine.fares.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.tecacet.sardine.fares.entity.Fare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FareRepositoryTest {


    @Autowired
    private FareRepository fareRepository;

    @Test
    public void testCrud() {
        Fare fare = new Fare("BF101", LocalDate.of(2018, 2, 12), BigDecimal.valueOf(100));
        fareRepository.save(fare);

        assertFalse(fareRepository.findByFlightNumberAndFlightDate("X", LocalDate.of(2018, 2, 12)).isPresent());
        assertTrue(fareRepository.findByFlightNumberAndFlightDate("BF101", LocalDate.of(2018, 2, 12)).isPresent());
    }

}
