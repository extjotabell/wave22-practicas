package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle findByid(Long id);
    List<Vehicle> findByColorAndYear(String color, Integer year);
    List<Vehicle> findByBrandAndYears(String brand, Integer from, Integer to);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByFuel(String fuel);
    List<Vehicle> findByWeigth(Double min, Double max);
    List<Vehicle> findByHeigth(Double min, Double max);
    List<Vehicle> findByWidth(Double min, Double max);
    List<Vehicle> findBytransmission(String transmission);
    void save(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
