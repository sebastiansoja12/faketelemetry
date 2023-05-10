package com.example.faketelemetry.service;

import com.example.faketelemetry.model.Vehicle;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class VehicleServiceImpl implements VehicleService {

    public final static Map<String, Vehicle> vehicles = new HashMap<>();

    @PostConstruct
    @Override
    public void init() {
        // Create some vehicles with initial coordinates
        vehicles.put("SR1234", new Vehicle(true, 50.1097081, 18.4792279));
        vehicles.put("SO1234", new Vehicle(true, 50.0468548, 19.9348336));

        // Start a timer that updates the coordinates of each vehicle every 5 minutes
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("Updating coordinates");
                for (Vehicle vehicle : vehicles.values()) {
                    double latitude = vehicle.getLatitude() + Math.random() * 0.01 - 0.005;
                    double longitude = vehicle.getLongitude() + Math.random() * 0.01 - 0.005;
                    vehicle.setLatitude(latitude);
                    vehicle.setLongitude(longitude);
                }
            }
        }, 0, 300000);
    }
}
