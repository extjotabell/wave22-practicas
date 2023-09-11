package com.example.ejercicioconcesionaria.service;

import com.example.ejercicioconcesionaria.dto.VehicleRequestDTO;
import com.example.ejercicioconcesionaria.dto.VehicleResponseDTO;
import com.example.ejercicioconcesionaria.model.Vehicle;
import com.example.ejercicioconcesionaria.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void addVehicle(VehicleRequestDTO veh) {
        Vehicle vehicle = mapper.convertValue(veh, Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public List<VehicleResponseDTO> getVehicles() {
        return vehicleRepository.getVehicles().stream().map(v -> mapper.convertValue(v, VehicleResponseDTO.class)).toList();
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByManufacturingDate(String since, String to) {
        return vehicleRepository.getVehiclesByManufacturingDate(since, to).stream().map(v -> mapper.convertValue(v, VehicleResponseDTO.class)).toList();
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByPrice(int since, int to) {
        return vehicleRepository.getVehiclesByPrice(since, to).stream().map(v -> mapper.convertValue(v, VehicleResponseDTO.class)).toList();
    }

    @Override
    public VehicleResponseDTO getVehicle(int id) {
        return mapper.convertValue(vehicleRepository.getVehicle(id), VehicleResponseDTO.class);
    }
}
