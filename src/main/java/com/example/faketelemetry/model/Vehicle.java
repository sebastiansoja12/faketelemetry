package com.example.faketelemetry.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {

    private boolean telemetryEnabled;
    private double longitude;
    private double latitude;
}
