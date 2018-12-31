package com.tecacet.sardine.booking.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Sender {

    private static final String SEARCH_QUEUE = "SearchQ";
    private static final String CHECK_IN_QUEUE = "CheckINQ";

    private final RabbitMessagingTemplate messagingTemplate;

    @Bean
    Queue queue() {
        return new Queue(SEARCH_QUEUE, false);
    }
    @Bean
    Queue queue1() {
        return new Queue(CHECK_IN_QUEUE, false);
    }

    public void send(Object message) {
        messagingTemplate.convertAndSend(SEARCH_QUEUE, message);
    }
}
