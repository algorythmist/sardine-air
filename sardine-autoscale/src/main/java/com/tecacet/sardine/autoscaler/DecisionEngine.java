package com.tecacet.sardine.autoscaler;

import com.tecacet.sardine.autoscaler.policy.ScalingPolicies;
import com.tecacet.sardine.autoscaler.rules.DeploymentRules;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class DecisionEngine {

    private final ScalingPolicies scalingPolicies;
    private final DeploymentEngine deploymentEngine;
    private final DeploymentRules deploymentRules;

    public boolean execute(String serviceId, Map metrics) {
        if (scalingPolicies.getPolicy(serviceId).execute(serviceId, metrics)) {
            return deploymentEngine.scaleUp(deploymentRules.getDeploymentRules(serviceId), serviceId);
        }
        return false;
    }
}
