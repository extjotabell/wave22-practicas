package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    List<VehicleDto> findVehiclesByHeightAndWidth(double minHeight, double maxHeight, double minWidth, double maxWidth);
}
