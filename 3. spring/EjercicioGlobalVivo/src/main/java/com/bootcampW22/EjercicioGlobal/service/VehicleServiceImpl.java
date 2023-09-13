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
    public List<VehicleDto> searchByHeightAndWidth(Double min_h, Double max_h, Double min_w, Double max_w) {
        List<Vehicle> vehiclesByHeigth = vehicleRepository.findByHeight(min_h,max_h);
        List<Vehicle> vehiclesByWidth = vehicleRepository.findByWidth(min_w,max_w);
        List<Vehicle> vehiclesByWidthAndHeigth = new ArrayList<>();
        for (Vehicle vehicle: vehiclesByHeigth) {
            if (vehiclesByWidth.contains(vehicle)){
                vehiclesByWidthAndHeigth.add(vehicle);
            }
        }
        if (vehiclesByWidthAndHeigth.isEmpty()){
            throw new NotFoundException("Not found vehicles for that Dimensions");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehiclesByWidthAndHeigth.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }
}
