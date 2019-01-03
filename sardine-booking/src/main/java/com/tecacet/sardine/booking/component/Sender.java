package com.tecacet.sardine.booking.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(BookingSource.class)
public class Sender {

    @Autowired
    @Output(BookingSource.INVENTORY_Q)
    private MessageChannel messageChannel;

    public void send(Object message) {
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }
}
