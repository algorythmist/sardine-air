package com.tecacet.sardine.booking.component;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Fare {

    private String flightNumber;
    private LocalDate flightDate;
    private BigDecimal fare;
}
