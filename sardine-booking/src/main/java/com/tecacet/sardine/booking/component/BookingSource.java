package com.tecacet.sardine.booking.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookingSource {

    public static final String INVENTORY_Q = "inventoryQ";

    @Output(INVENTORY_Q)
    public MessageChannel inventoryQueue();
}
