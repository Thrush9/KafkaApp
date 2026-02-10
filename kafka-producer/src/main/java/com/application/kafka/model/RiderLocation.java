package com.application.kafka.model;

public record RiderLocation(String riderId, double latitude, double longitude, String message) {
}
