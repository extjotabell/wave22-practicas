package com.concesionaria.autos.service;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehiclesService {

    VehicleDTO addVehicle(VehicleDTO vehicle);

    List<VehicleDTO> getSelectedVehicles();

    List<VehicleDTO> getByDate(LocalDate since, LocalDate to);

    List<VehicleDTO> getByPrice(double since, double to);

    VehicleDTO getById(int id);
}
