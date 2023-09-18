package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    void save(Vehicle vehicle);

    Optional<Vehicle> findVehicle(Long id);

    List<Vehicle> findByCharacteristics(Double min_width, Double max_width, Double min_height, Double max_height);

}
