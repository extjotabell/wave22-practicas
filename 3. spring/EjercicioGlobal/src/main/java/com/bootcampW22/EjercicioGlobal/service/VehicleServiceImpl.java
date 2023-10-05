package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    ObjectMapper mapper;
    List<Vehicle> vehicleList;
    @Override
    public List<VehicleDto> searchAllVehicles() {
        mapper = new ObjectMapper();
        vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getVehiclesDtoByBY(String brand, int start, int end) {
        mapper = new ObjectMapper();
        vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehiclesFiltered = vehicleList.stream()
                .filter(v-> v.getBrand().equalsIgnoreCase(brand))
                .filter(v-> (v.getYear() >= start) && (v.getYear() <= end))
                .toList();
        if (vehiclesFiltered.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehiclesFiltered.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }
}
