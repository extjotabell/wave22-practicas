package com.concesionariaDeAutos.concesionariaDeAutos.repository;

import com.concesionariaDeAutos.concesionariaDeAutos.entity.Vehicle;

import java.util.List;

public interface IRepositoryVehicle {

    void uploadDataBase();
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}
