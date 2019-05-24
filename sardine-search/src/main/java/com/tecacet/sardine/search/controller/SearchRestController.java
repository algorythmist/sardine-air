package com.tecacet.sardine.search.controller;

import com.tecacet.sardine.search.component.SearchComponent;
import com.tecacet.sardine.search.component.SearchQuery;
import com.tecacet.sardine.search.entity.Flight;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
