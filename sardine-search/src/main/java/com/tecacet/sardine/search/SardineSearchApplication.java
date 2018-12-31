package com.tecacet.sardine.search;

import com.tecacet.sardine.search.entity.Fares;
import com.tecacet.sardine.search.entity.Flight;
import com.tecacet.sardine.search.entity.Inventory;
import com.tecacet.sardine.search.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class SardineSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SardineSearchApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FlightRepository flightRepository) {
		return (env) -> {
			List<Flight> flights = new ArrayList<>();
			flights.add(new Flight("BF100", "SEA","SFO","2016-01-22",new Fares("100"),new Inventory(100)));
			flights.add(new Flight("BF101", "NYC","SFO","2016-01-22",new Fares("101"),new Inventory(100)));
			flights.add(new Flight("BF105", "NYC","SFO","2016-01-22",new Fares("105"),new Inventory(100)));
			flights.add(new Flight("BF106", "NYC","SFO","2016-01-22",new Fares("106"),new Inventory(100)));
			flights.add(new Flight("BF102", "CHI","SFO","2016-01-22",new Fares("102"),new Inventory(100)));
			flights.add(new Flight("BF103", "HOU","SFO","2016-01-22",new Fares("103"),new Inventory(100)));
			flights.add(new Flight("BF104", "LAX","SFO","2016-01-22",new Fares("104"),new Inventory(100)));
			flightRepository.saveAll(flights);
		};
	}

}

