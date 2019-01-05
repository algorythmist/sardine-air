package com.tecacet.sardine.booking.integration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookingSource {

    String INVENTORY_Q = "inventoryQ";

    @Output(INVENTORY_Q)
    MessageChannel inventoryQ();
}
