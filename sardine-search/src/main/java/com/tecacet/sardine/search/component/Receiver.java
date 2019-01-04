package com.tecacet.sardine.search.component;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class Receiver {

    private final SearchComponent searchComponent;

    @Bean
    Queue queue() {
        return new Queue("SearchQ", false);
    }

    @RabbitListener(queues = "SearchQ")
    public void processMessage(Map<String,Object> fare) {
        System.out.println(fare);
        searchComponent.updateInventory((String)fare.get("FLIGHT_NUMBER"),
                (LocalDate) fare.get("FLIGHT_DATE"),
                (int)fare.get("NEW_INVENTORY"));
        //call repository and update the fare for the given flight
    }
}
