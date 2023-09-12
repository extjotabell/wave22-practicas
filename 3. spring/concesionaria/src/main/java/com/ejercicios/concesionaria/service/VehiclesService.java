package com.ejercicios.concesionaria.service;

import com.ejercicios.concesionaria.Exception.NotFoundException;
import com.ejercicios.concesionaria.dto.ServicesDTO;
import com.ejercicios.concesionaria.dto.VehiclesDTO;
import com.ejercicios.concesionaria.dto.VehiclesDTOS;
import com.ejercicios.concesionaria.entity.Services;
import com.ejercicios.concesionaria.entity.Vehicles;
import com.ejercicios.concesionaria.repository.IRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiclesService implements IService{

    @Autowired
    IRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Integer save(VehiclesDTOS vehiclesDTOS) {
        Vehicles vehicles = mapper.convertValue(vehiclesDTOS, Vehicles.class);
        vehicles.setServices(vehiclesDTOS.getServices().stream().map(this::convertDTOToEntity).toList());
        return repository.save(vehicles);
    }

    @Override
    public List<VehiclesDTO> getAll() {
        return repository.getAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehiclesDTOS> getDates(LocalDate starDate, LocalDate endDate) {
        List<Vehicles> vehiclesList = repository.getDates(starDate,endDate);
        List<VehiclesDTOS> vehiclesDTOList = new ArrayList<>();

        for(Vehicles vehicle : vehiclesList){
            vehiclesDTOList.add(convertEntityToDTOS(vehicle));
        }
        return vehiclesDTOList;
    }

    @Override
    public List<VehiclesDTOS> getPrices(Double minPrice, Double maxPrice) {
        List<Vehicles> vehiclesList = repository.getPrices(minPrice,maxPrice);
        List<VehiclesDTOS> vehiclesDTOList = new ArrayList<>();

        for(Vehicles vehicle : vehiclesList){
            vehiclesDTOList.add(convertEntityToDTOS(vehicle));
        }
        return vehiclesDTOList;
    }

    @Override
    public VehiclesDTOS findById(Integer id) {
        Vehicles vehicles = repository.findById(id);
        if(vehicles == null){
            throw new NotFoundException();
        }
        return convertEntityToDTOS(vehicles);
    }

    private VehiclesDTO convertEntityToDTO(Vehicles vehicle) {
        VehiclesDTO vehiclesDTO = mapper.convertValue(vehicle, VehiclesDTO.class);
        return vehiclesDTO;
    }
    private VehiclesDTOS convertEntityToDTOS(Vehicles vehicle) {
        VehiclesDTOS vehiclesDTOS = mapper.convertValue(vehicle, VehiclesDTOS.class);
        vehiclesDTOS.setServices(vehicle.getServices().stream().map(this::convertEntityToDTO).toList());
        return vehiclesDTOS;
    }

    private Vehicles convertDTOToEntity(VehiclesDTOS vehiclesDTOS) {
        Vehicles vehicles = mapper.convertValue(vehiclesDTOS, Vehicles.class);
        vehicles.setServices(vehiclesDTOS.getServices().stream().map(this::convertDTOToEntity).toList());
        return vehicles;
    }
    private Services convertDTOToEntity(ServicesDTO servicesDTO) {
        return mapper.convertValue(servicesDTO, Services.class);
    }
    private ServicesDTO convertEntityToDTO(Services services) {
        return mapper.convertValue(services, ServicesDTO.class);
    }
}
