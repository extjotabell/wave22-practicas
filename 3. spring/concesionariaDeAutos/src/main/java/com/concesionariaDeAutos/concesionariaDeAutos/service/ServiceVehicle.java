package com.concesionariaDeAutos.concesionariaDeAutos.service;

import com.concesionariaDeAutos.concesionariaDeAutos.dto.VehicleDto;
import com.concesionariaDeAutos.concesionariaDeAutos.dto.VehicleWoServicesDto;
import com.concesionariaDeAutos.concesionariaDeAutos.entity.Vehicle;
import com.concesionariaDeAutos.concesionariaDeAutos.exception.IdAlreadyExistsException;
import com.concesionariaDeAutos.concesionariaDeAutos.exception.NotFoundException;
import com.concesionariaDeAutos.concesionariaDeAutos.repository.IRepositoryVehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceVehicle implements IServiceVehicle{

    private final IRepositoryVehicle repository;

    public ServiceVehicle(IRepositoryVehicle repository) {
        this.repository = repository;
    }

    @Override
    public void addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Vehicle> vehicleIdCheck = repository.getAllVehicles().stream()
                        .filter(v -> v.getId() == vehicleDto.getId())
                        .findFirst();

        if(vehicleIdCheck.isPresent()){
            throw new IdAlreadyExistsException("There is already a vehicle with that id");
        }
        repository.addVehicle(mapper.convertValue(vehicleDto, Vehicle.class));
    }

    @Override
    public List<VehicleWoServicesDto> getAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleWoServicesDto> vehicleWoServicesDtos = repository.getAllVehicles().stream()
                .map(v -> mapper.convertValue(v, VehicleWoServicesDto.class))
                .toList();
        if(vehicleWoServicesDtos.isEmpty()){
            throw new NotFoundException("There are no vehicles to show");
        }

        return vehicleWoServicesDtos;
    }

    @Override
    public List<VehicleDto> getVehiclesPerDate(String since, String to) {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = repository.getAllVehicles().stream()
                .filter(v -> Integer.valueOf(v.getManufacturingDate().replaceAll("-", ""))  >= Integer.valueOf(since.replaceAll("-", ""))
                && Integer.valueOf(v.getManufacturingDate().replaceAll("-", "")) <= Integer.valueOf(to.replaceAll("-", "")))
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();

        if(vehicleDtos.isEmpty()){
            throw new NotFoundException("Theare are no vehicles in that range of dates");
        }

        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> getVehiclesPerPrice(double since, double to) {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = repository.getAllVehicles().stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();

        if(vehicleDtos.isEmpty()){
            throw new NotFoundException("Theare are no vehicles in that range of price");
        }

        return vehicleDtos;
    }

    @Override
    public VehicleDto getVehiclePerId(int id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<VehicleDto> vehicleDto = repository.getAllVehicles().stream()
                .filter(v -> v.getId() == id)
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .findFirst();

        if(!vehicleDto.isPresent()){
            throw new NotFoundException("There are no vehicles with that id");
        }

        return vehicleDto.get();

    }
}
