package com.tecacet.sardine.booking.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(BookingSource.class)
public class InventorySender {

    @Output(BookingSource.INVENTORY_Q)
    @Autowired
    private MessageChannel messageChannel;

    public void send(Object message) {
        System.out.println("Sending message " + message);
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }
}
