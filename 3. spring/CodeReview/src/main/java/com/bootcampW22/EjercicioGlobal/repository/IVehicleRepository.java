package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Vehicle> getVehiclesByDimensionRange(double min_length, double max_length , double min_width, double max_width );

}
