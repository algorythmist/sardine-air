package com.tecacet.sardine.autoscaler;

import java.util.Map;
import org.springframework.stereotype.Component;
import com.tecacet.sardine.autoscaler.policy.ScalingPolicies;
import com.tecacet.sardine.autoscaler.rules.DeploymentRules;
import lombok.RequiredArgsConstructor;

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
