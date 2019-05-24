package com.tecacet.sardine.autoscaler.rules;

import org.springframework.stereotype.Component;

@Component
public class DeploymentRules {

    public DeploymentRule getDeploymentRules(String serviceId) {
        return new DummyDeploymentRule();
    }
}
