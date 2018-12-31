package com.tecacet.sardine.search.controller;

import com.tecacet.sardine.search.component.SearchComponent;
import com.tecacet.sardine.search.component.SearchQuery;
import com.tecacet.sardine.search.entity.Flight;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin //TODO: what is this?
@RestController
@RequestMapping("/search")
@RefreshScope //reload properties
@RequiredArgsConstructor
@Slf4j
public class SearchRestController {

    private final SearchComponent searchComponent;

    @Value("${originairports.shutdown}")
    private String originalAirportShutdownList;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query) {
        Set<String> closed = Arrays.stream(originalAirportShutdownList.split(",")).collect(Collectors.toSet());
        if (closed.contains(query.getOrigin())) {
            log.warn("Airport is shut down");
            return Collections.emptyList();
        }
        log.info("Input : {}", query);
        return searchComponent.search(query);
    }
}
