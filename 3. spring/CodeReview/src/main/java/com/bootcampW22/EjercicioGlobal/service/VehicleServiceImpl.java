package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findVehicleByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = vehicleRepository.findVehicleByColorAndYear(color, year);
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        if(vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            vehicleDtos = vehicles.stream()
                    .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                    .collect(Collectors.toList());
        }
        return vehicleDtos;
    }
}
