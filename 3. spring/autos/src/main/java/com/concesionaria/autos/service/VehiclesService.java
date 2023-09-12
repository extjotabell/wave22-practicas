package com.concesionaria.autos.service;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Vehicle;
import com.concesionaria.autos.exceptions.NotFoundVehicle;
import com.concesionaria.autos.mapper.VehiclesMapper;
import com.concesionaria.autos.repository.IVehiclesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclesService implements IVehiclesService{

    IVehiclesRepository repository;
    VehiclesMapper vehiclesMapper;

    public VehiclesService(IVehiclesRepository repository, VehiclesMapper vehiclesMapper) {
        this.repository = repository;
        this.vehiclesMapper = vehiclesMapper;
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO){
        System.out.println(vehicleDTO.getServices() + vehicleDTO.getModel());
        Vehicle vehicleCreated = repository.addVehicle(vehiclesMapper.mapToEntity(vehicleDTO));
        return vehiclesMapper.mapToDto(vehicleCreated);

    }

    @Override
    public List<VehicleDTO> getSelectedVehicles(){
        List<VehicleDTO> vehicles = new ArrayList<>();

        for (Vehicle vehicle: repository.getAll()) {
            vehicles.add(vehiclesMapper.mapToDto(vehicle));
        }
        return vehicles;
    }


    @Override
    public List<VehicleDTO> getByDate(LocalDate since, LocalDate to){

        List<VehicleDTO> vehicles = new ArrayList<>();
        for (Vehicle vehicle:repository.getVehiclesByDate(since, to)) {
            vehicles.add(vehiclesMapper.mapToDto(vehicle));
        }
        return vehicles;
    }

    @Override
    public List<VehicleDTO> getByPrice(double since, double to){
        List<VehicleDTO> vehicles = new ArrayList<>();

        for (Vehicle vehicle: repository.getVehicesByPrice(since, to)) {
            vehicles.add(vehiclesMapper.mapToDto(vehicle));
        }

        return vehicles;
    }

    @Override
    public VehicleDTO getById(int id) {
        Vehicle vehicleFounded = repository.getVehicleById(id);
        if (vehicleFounded == null) {
            throw new NotFoundVehicle("Vehicle not found");
        }
        return vehiclesMapper.mapToDto(vehicleFounded);
    }
}
