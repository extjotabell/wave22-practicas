package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void updateVehicle(int index, Vehicle vehicleUpdate);
    boolean existsVehicle(Long id);
    Optional<Vehicle> getVehicleById(Long id);
}