package com.example.faketelemetry.configuration;

import com.example.faketelemetry.service.VehicleService;
import com.example.faketelemetry.service.VehicleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelemetryConfiguration {
    @Bean
    public VehicleService vehicleService() {
        return new VehicleServiceImpl();
    }
}
