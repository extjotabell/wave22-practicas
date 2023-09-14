package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void add(VehicleDto vehicleDto);
    VehicleDto findById(Long id);
    List<VehicleDto> findBetweenYears(String brand, int start_year, int end_year);
    double avergareSpeed(String brand);

    void addList(List<VehicleDto> list);
}
