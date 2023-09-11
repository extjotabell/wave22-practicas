package com.example.ConcesionariaAutos.service;

import com.example.ConcesionariaAutos.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IVehicleService {
    int addVehicle(VehicleDTO vehicleDto);

    VehicleDTO getVehicleById(Integer id);

    List<VehicleDTO> getVehicles();

    List<VehicleDTO> getVehiclesByDate(LocalDate since, LocalDate to);

    List<VehicleDTO> getVehiclesByPrice(double from, double to);
}
