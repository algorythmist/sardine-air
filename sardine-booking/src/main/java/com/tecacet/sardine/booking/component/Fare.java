package com.tecacet.sardine.booking.component;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Fare {

    private String flightNumber;
    private LocalDate flightDate;
    private BigDecimal fare;
}
