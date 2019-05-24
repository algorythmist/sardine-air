package com.tecacet.sardine.autoscaler.policy;

import java.util.Map;

public interface ScalingPolicy {

    boolean execute(String serviceId, Map metrics);
}
