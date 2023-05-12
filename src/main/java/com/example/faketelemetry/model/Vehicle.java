package com.example.faketelemetry.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Vehicle {

    private String vehicleReg;
    private boolean telemetryEnabled;
    private double longitude;
    private double latitude;

    private Instant timeStamp;
}
