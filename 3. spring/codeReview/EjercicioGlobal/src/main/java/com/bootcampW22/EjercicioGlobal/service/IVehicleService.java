package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.UpdatedVehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void updateMaxSpeed(long id, UpdatedVehicleDto updatedVehicleDto);
}
