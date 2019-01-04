package com.tecacet.sardine.search.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface SearchSink {

    public static final String INVENTORY_Q = "inventoryQ";

    @Input(INVENTORY_Q)
    public MessageChannel inventoryQueue();
}
