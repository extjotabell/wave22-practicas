package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto saveVehicle(VehicleDto vehicle);
    List<VehicleDto> saveVehicles(List<VehicleDto> vehicles);
    List<VehicleDto> searchByColorAndYear(String color, Integer year);
    List<VehicleDto> searchByBrandAndYears(String brand, Integer from, Integer to);
    List<VehicleDto> searchVehiclesByWeight(Double min, Double max);
    List<VehicleDto> searchVehiclesByHeigthYWidth(String heigth, String width);
    List<VehicleDto> searchByFuel(String fuel);
    List<VehicleDto> searchByTransmission(String transmission);
    SpeedAverageDto averageSpeed(String brand);
    CapacityAverageDto averageCapacity(String brand);
    VehicleDto updateSpeed(Long id, UpdateSpeedDto updateSpeedDto);
    VehicleDto updateFuel(Long id, UpdateFuelDto updateFuelDto);
    VehicleDto deleteVehicle(Long id);
}
