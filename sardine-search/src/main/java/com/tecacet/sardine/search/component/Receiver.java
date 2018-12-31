package com.tecacet.sardine.search.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class Receiver {

    public static final String SEARCH_QUEUE = "SearchQ";
    private final SearchComponent searchComponent;

    @Bean
    Queue queue() {
        return new Queue(SEARCH_QUEUE, false);
    }

    @RabbitListener(queues = SEARCH_QUEUE)
    public void processMessage(Map<String, Object> fare) {
        log.info(fare.toString());
        LocalDate date = LocalDate.parse((String) fare.get("FLIGHT_DATE"));
        searchComponent.updateInventory((String) fare.get("FLIGHT_NUMBER"), date, (int) fare.get("NEW_INVENTORY"));
        //call repository and update the fare for the given flight
    }
}