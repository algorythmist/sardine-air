package com.tecacet.sardine.fares;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tecacet.sardine.fares.entity.Fare;
import com.tecacet.sardine.fares.repository.FareRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SardineFaresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SardineFaresApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FareRepository fareRepository) {
		return (env) -> {
			LocalDate date = LocalDate.of(2016,1,22);
			List<Fare> fares = Arrays.asList(
					new Fare("SA-100",date, new BigDecimal("101")),
					new Fare("SA-101",date, new BigDecimal("101")),
					new Fare("SA-102",date, new BigDecimal("102")),
					new Fare("SA-103",date, new BigDecimal("103")),
					new Fare("SA-104",date, new BigDecimal("104")),
					new Fare("SA-105",date, new BigDecimal("105")),
					new Fare("SA-106",date, new BigDecimal("106")));

			fares.forEach(fare -> fareRepository.save(fare));
		};
	}
}

