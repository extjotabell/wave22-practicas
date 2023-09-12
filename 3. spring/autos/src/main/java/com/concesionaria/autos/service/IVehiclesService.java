package com.concesionaria.autos.service;

import com.concesionaria.autos.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehiclesService {

    Integer addVehicle(VehicleDTO vehicle);

    List<VehicleDTO> getSelectedVehicles();

    List<VehicleDTO> getByDate(LocalDate since, LocalDate to);

    List<VehicleDTO> getByPrice(double from, double to);

    VehicleDTO getById(int id);
}
