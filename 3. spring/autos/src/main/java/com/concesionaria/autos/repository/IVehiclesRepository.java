package com.concesionaria.autos.repository;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehiclesRepository {
    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> getAll();
    List<Vehicle> getVehiclesByDate(LocalDate since, LocalDate to);
    List<Vehicle> getVehicesByPrice(double since, double to);
    Vehicle getVehicleById(Integer id);

}
