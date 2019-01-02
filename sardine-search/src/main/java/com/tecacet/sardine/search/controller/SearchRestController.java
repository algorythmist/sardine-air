package com.tecacet.sardine.search.controller;

import java.util.List;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tecacet.sardine.search.component.SearchComponent;
import com.tecacet.sardine.search.component.SearchQuery;
import com.tecacet.sardine.search.entity.Flight;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin //TODO: what is this?
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@Slf4j
public class SearchRestController {

    private final SearchComponent searchComponent;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query) {
        log.info("Input : {}", query);
        return searchComponent.search(query);
    }
}
