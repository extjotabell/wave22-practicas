package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    List<Vehicle> findVehiclesByHeightAndWidth(double minHeight, double maxHeight, double minWidth, double maxWidth);

    void addVehicle(Vehicle vehicle);
    boolean verifyVehicleExists(long id);

}
