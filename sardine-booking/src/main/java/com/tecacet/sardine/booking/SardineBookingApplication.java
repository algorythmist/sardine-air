package com.tecacet.sardine.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SardineBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SardineBookingApplication.class, args);
	}

}

