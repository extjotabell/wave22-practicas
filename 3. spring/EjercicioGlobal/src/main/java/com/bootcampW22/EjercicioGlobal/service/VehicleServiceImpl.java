package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

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
    public List<VehicleDto> findVehiclesByHeightAndWidth(double minHeight, double maxHeight, double minWidth, double maxWidth) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByHeightAndWidth(minHeight, maxHeight, minWidth, maxWidth);
        if(vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }
        return vehicleList.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public void addVehicle(VehicleDto vehicleDto) throws ConflictException {
        ObjectMapper mapper = new ObjectMapper();
        if(vehicleRepository.verifyVehicleExists(vehicleDto.getId()))
            throw new ConflictException("Ya existe un vehículo con el id "+vehicleDto.getId());
        vehicleRepository.addVehicle(mapper.convertValue(vehicleDto, Vehicle.class));
    }



}
