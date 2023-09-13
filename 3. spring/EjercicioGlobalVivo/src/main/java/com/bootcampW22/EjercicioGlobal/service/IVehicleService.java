package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    List<VehicleDto> searchByHeightAndWidth(Double min_h, Double max_h, Double min_w, Double max_w);

}
