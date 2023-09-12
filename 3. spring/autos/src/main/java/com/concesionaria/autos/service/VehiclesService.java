package com.concesionaria.autos.service;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Vehicle;
import com.concesionaria.autos.mapper.VehiclesMapper;
import com.concesionaria.autos.repository.IVehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclesService implements IVehiclesService{

    @Autowired
    IVehiclesRepository repository;

    VehiclesMapper vMapper = new VehiclesMapper();

    @Override
    public Integer addVehicle(VehicleDTO v){

        return repository.addVehicle(vMapper.mapToEntity(v));

    }

    @Override
    public List<VehicleDTO> getSelectedVehicles(){
        List<VehicleDTO> vehicles = new ArrayList<>();

        for (Vehicle v:repository.getAll()) {
            vehicles.add(vMapper.mapToDto(v));
        }
        return vehicles;
    }


    @Override
    public List<VehicleDTO> getByDate(LocalDate since, LocalDate to){

        List<VehicleDTO> vehicles = new ArrayList<>();

        for (Vehicle v:repository.getVehiclesByDate(since, to)) {
            vehicles.add(vMapper.mapToDto(v));
        }

        return vehicles;
    }

    @Override
    public List<VehicleDTO> getByPrice(double from, double to){
        List<VehicleDTO> vehicles = new ArrayList<>();

        for (Vehicle v:repository.getVehicesByPrice(from, to)) {
            vehicles.add(vMapper.mapToDto(v));
        }

        return vehicles;
    }

    @Override
    public VehicleDTO getById(int id) {
        return vMapper.mapToDto(repository.getVehicleById(id));
    }
}
