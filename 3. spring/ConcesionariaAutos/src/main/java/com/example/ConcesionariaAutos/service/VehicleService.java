package com.example.ConcesionariaAutos.service;

import com.example.ConcesionariaAutos.dto.VehicleDTO;
import com.example.ConcesionariaAutos.entity.Vehicle;
import com.example.ConcesionariaAutos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehicleRepository repo;

    @Override
    public int addVehicle(VehicleDTO vehicleDto){
        Vehicle vehicle = new ModelMapper().map(vehicleDto, Vehicle.class);
        return repo.addVehicle(vehicle);
    }

    @Override
    public VehicleDTO getVehicleById(Integer id) {
        Vehicle vehicle = repo.getVehicleById(id);
        return new ModelMapper().map(vehicle, VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return this.repo.getVehicles()
                .stream()
                .map(v-> new ModelMapper().map(v, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByDate(LocalDate since, LocalDate to) {
        return this.repo.getVehiclesByDate(since, to)
                .stream()
                .map(v -> new ModelMapper().map(v, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(double from, double to) {
        return this.repo.getVehiclesByPrice(from, to)
                .stream()
                .map(v -> new ModelMapper().map(v, VehicleDTO.class))
                .collect(Collectors.toList());
    }
}
