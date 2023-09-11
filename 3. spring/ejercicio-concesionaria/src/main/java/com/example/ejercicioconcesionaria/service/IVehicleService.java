package com.example.ejercicioconcesionaria.service;

import com.example.ejercicioconcesionaria.dto.VehicleRequestDTO;
import com.example.ejercicioconcesionaria.dto.VehicleResponseDTO;

import java.util.List;

public interface IVehicleService {

    void addVehicle(VehicleRequestDTO veh);
    List<VehicleResponseDTO> getVehicles();
    List<VehicleResponseDTO> getVehiclesByManufacturingDate(String since, String to);
    List<VehicleResponseDTO> getVehiclesByPrice(int since, int to);
    VehicleResponseDTO getVehicle(int id);

}
