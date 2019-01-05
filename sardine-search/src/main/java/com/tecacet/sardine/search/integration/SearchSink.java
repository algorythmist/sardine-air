package com.tecacet.sardine.search.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface SearchSink {

    String INVENTORY_Q = "inventoryQ";

    @Input(INVENTORY_Q)
    MessageChannel inventoryQ();
}
