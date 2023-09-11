package com.example.ConcesionariaAutos.repository;

import com.example.ConcesionariaAutos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    Integer addVehicle(Vehicle v);

    List<Vehicle> getVehicles();

    List<Vehicle> getVehiclesByDate(LocalDate since, LocalDate to);

    List<Vehicle> getVehiclesByPrice(double from, double to);

    Vehicle getVehicleById(Integer id);
}
