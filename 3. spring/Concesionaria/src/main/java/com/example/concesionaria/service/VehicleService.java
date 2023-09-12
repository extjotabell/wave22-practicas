package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.VehicleGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicle);

    List<VehicleGetDTO> getAll();

    List<VehicleDTO> getFromDates(String since, String to);

    List<VehicleDTO> getFromPrices(Double since, Double to);

    VehicleDTO getVehicle(Integer id);
}
