package com.tecacet.sardine.search.component;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
@EnableBinding(SearchSink.class)
public class Receiver {

    private final SearchComponent searchComponent;

    @ServiceActivator(inputChannel = SearchSink.INVENTORY_Q)
    //TODO: get object as message
    public void accept(Map<String, Object> fare) {
        log.info(fare.toString());
        LocalDate date = (LocalDate) fare.get("FLIGHT_DATE");
        try {
            searchComponent.updateInventory((String) fare.get("FLIGHT_NUMBER"), date, (int) fare.get("NEW_INVENTORY"));
        } catch (FlightNotFoundException fne) {
            log.error(fne.getMessage());
        }
    }
}
