package com.discover.emp.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealthCheckIndicator implements HealthIndicator {
    private final String message_key = "Employee Service";
    @Override
    public Health health() {
        if (!isRunningService()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private Boolean isRunningService() {
    	return true;
    }
}