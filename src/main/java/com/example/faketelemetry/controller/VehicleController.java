package com.example.faketelemetry.controller;

import com.example.faketelemetry.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.faketelemetry.service.VehicleServiceImpl.vehicles;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @GetMapping("/{id}/coordinates")
    public ResponseEntity<Map<String, Double>> getCurrentCoordinates(@PathVariable String id) {
        final Vehicle vehicle = vehicles.get(id);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        final Map<String, Double> coordinates = new HashMap<>();
        coordinates.put("latitude", vehicle.getLatitude());
        coordinates.put("longitude", vehicle.getLongitude());
        return ResponseEntity.ok(coordinates);
    }
}
