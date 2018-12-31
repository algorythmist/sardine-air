package com.tecacet.sardine.fares.controller;

import com.tecacet.sardine.fares.entity.Fare;
import com.tecacet.sardine.fares.repository.FareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/fares")
@RequiredArgsConstructor
public class FareController {

	private final FareRepository fareRepository;

	@RequestMapping("/get")
	public Fare getFare(@RequestParam(value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate){
		LocalDate date = LocalDate.parse(flightDate);
		return fareRepository.findByFlightNumberAndFlightDate(flightNumber, date).orElse(null);
	}
}
