package com.tecacet.sardine.checkin.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Sender {

    private final RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue("CheckINQ", false);
    }

    public void send(Object message) {
        template.convertAndSend("CheckINQ", message);
    }
}
