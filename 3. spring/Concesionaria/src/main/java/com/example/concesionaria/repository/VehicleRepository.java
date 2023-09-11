package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    void save(Vehicle vehicle);

    List<Vehicle> getAll();

    List<Vehicle> getFromDates(String from, String to);

    List<Vehicle> getFromPrices(Double from, Double to);

    Vehicle getVehicle(Integer id);
}
