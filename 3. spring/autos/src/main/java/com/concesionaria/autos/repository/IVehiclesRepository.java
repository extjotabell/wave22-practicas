package com.concesionaria.autos.repository;

import com.concesionaria.autos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehiclesRepository {
    Integer addVehicle(Vehicle vehicle);
    List<Vehicle> getAll();
    List<Vehicle> getVehiclesByDate(LocalDate since, LocalDate to);
    List<Vehicle> getVehicesByPrice(double from, double to);
    Vehicle getVehicleById(Integer id);

}
