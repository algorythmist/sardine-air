package com.tecacet.sardine.autoscaler.rules;


import com.tecacet.sardine.autoscaler.DeploymentEngine;

public class DummyDeploymentRule implements DeploymentRule {
    private static final int max_instance = 2;

    @Override
    public boolean execute() {
        return !(DeploymentEngine.num_instances >= max_instance);
    }
}
