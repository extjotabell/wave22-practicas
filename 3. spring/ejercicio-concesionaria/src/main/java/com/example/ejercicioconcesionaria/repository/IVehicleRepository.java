package com.example.ejercicioconcesionaria.repository;

import com.example.ejercicioconcesionaria.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    void addVehicle(Vehicle veh);
    List<Vehicle> getVehicles();
    List<Vehicle> getVehiclesByManufacturingDate(String since, String to);
    List<Vehicle> getVehiclesByPrice(int since, int to);
    Vehicle getVehicle(int id);

}
