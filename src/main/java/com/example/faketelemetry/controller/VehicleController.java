package com.example.faketelemetry.controller;

import com.example.faketelemetry.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.faketelemetry.service.VehicleServiceImpl.vehicles;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @GetMapping("/coordinates/{id}")
    public ResponseEntity<?> getCurrentCoordinates(@PathVariable String id) {
        final Vehicle vehicle = vehicles.get(id);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }
}
