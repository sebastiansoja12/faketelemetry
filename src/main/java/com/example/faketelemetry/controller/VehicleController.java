package com.example.faketelemetry.controller;

import com.example.faketelemetry.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.faketelemetry.service.VehicleServiceImpl.vehicles;

@RestController
@RequestMapping("/vehicles")
@Slf4j
public class VehicleController {

    @GetMapping("/coordinates/{id}")
    public ResponseEntity<?> getCurrentCoordinates(@PathVariable String id) {
        final Vehicle vehicle = vehicles.stream().filter(e -> e.getVehicleReg().equals(id)).findAny().orElse(null);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/coordinates")
    public ResponseEntity<?> getCurrentCoordinatesForAllVehicles() {
        log.info("Detected GET");
        final List<Vehicle> vehicle = vehicles;
        if (vehicle.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }
}
