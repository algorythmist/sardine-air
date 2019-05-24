package com.tecacet.sardine.search.integration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableBinding(SearchSink.class)
public class SearchReceiver {

    @ServiceActivator(inputChannel = SearchSink.INVENTORY_Q)
    public void accept(Message<Map<String, Object>> message) {
        System.out.println(message.getPayload()); //TODO
    }
}
