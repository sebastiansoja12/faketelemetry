package com.example.faketelemetry.service;

import com.example.faketelemetry.model.Vehicle;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.*;

@Slf4j
public class VehicleServiceImpl implements VehicleService {

    public final static List<Vehicle> vehicles = new ArrayList<>();

    @PostConstruct
    @Override
    public void init() {
        // Create some vehicles with initial coordinates
        vehicles.add(new Vehicle("SR1234", true, 52.3256188, 14.4281651, Instant.now()));
        vehicles.add(new Vehicle("SO1234", true, 50.0468548, 19.9348336, Instant.now()));

        // Start a timer that updates the coordinates of each vehicle every 5 minutes
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("Updating coordinates");
                vehicles.forEach(
                        vehicle -> {
                            double latitude = vehicle.getLatitude() + Math.random() * 0.01 - 0.005;
                            double longitude = vehicle.getLongitude() + Math.random() * 0.01 - 0.005;
                            vehicle.setLatitude(latitude);
                            vehicle.setLongitude(longitude);
                            vehicle.setTimeStamp(Instant.now());
                        }
                );
            }
        }, 0, 300);
    }
}
