package com.tecacet.sardine.autoscaler;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class MetricsCollector {

    private final DiscoveryClient eurekaClient;
    private final DecisionEngine decisionEngine;
    private final RestTemplate restTemplate;

    public void start() {
        while (true) {
            eurekaClient.getServices().forEach(service -> {
                System.out.println("printing service " + service);
                Map metrics = restTemplate.getForObject("http://" + service + "/metrics", Map.class);
                decisionEngine.execute(service, metrics);
            });
        }
    }
}


@Configuration
class AppConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
