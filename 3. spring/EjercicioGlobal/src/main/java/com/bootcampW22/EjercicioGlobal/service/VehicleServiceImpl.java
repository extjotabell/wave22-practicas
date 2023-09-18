package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.RangeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehiclesDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    // Ejercicios
    // 1

    @Override
    public Boolean addVehicle(VehicleDto vehicle) {
        List<Vehicle> vehicleList = this.vehicleRepository.findAll();

        // verificar que no este vacío
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        List<Vehicle> collect = vehicleList.stream()
                .filter(vehicleFromList -> Objects.equals(vehicleFromList.getId(), vehicle.getId()))
                .toList();
        ObjectMapper mapper = new ObjectMapper();

        if (collect.isEmpty()){
            this.vehicleRepository.save(mapper.convertValue(vehicle, Vehicle.class));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public VehicleDto findVehicle(Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Vehicle> vehicle = this.vehicleRepository.findVehicle(id);
        if (vehicle.isPresent()){
            return mapper.convertValue(vehicle.get(), VehicleDto.class);
        } else {
            VehicleDto aux = new VehicleDto();
            return aux;
        }
    }

    @Override
    public VehiclesDto findByRange(RangeDto ranges) {
        List<Vehicle> vehicles = this.vehicleRepository.findByCharacteristics(ranges.getMin_width(), ranges.getMax_width(), ranges.getMin_height(), ranges.getMax_height());

        ObjectMapper mapper = new ObjectMapper();

        VehiclesDto vehiclesDto = new VehiclesDto();
        List<VehicleDto> auxList = new ArrayList<>();
        if (!vehicles.isEmpty()) {
            for (Vehicle v : vehicles) {
                auxList.add(mapper.convertValue(v, VehicleDto.class));
            }
        }
        // To do caso en que vehicles este vacío
        vehiclesDto.setVehicles(auxList);
        return vehiclesDto;
    }
}
