package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.VehicleGetDTO;
import com.example.concesionaria.entity.Vehicle;
import com.example.concesionaria.exception.NonSenseException;
import com.example.concesionaria.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    public VehicleDTO saveVehicle(VehicleDTO vehicle){
        Vehicle v = new Vehicle(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getServices(), vehicle.getCountOfOwners());
        repository.save(v);
        return vehicle;
    }

    @Override
    public List<VehicleGetDTO> getAll() {
        List<VehicleGetDTO> vehicleDTOList = new ArrayList<>();
        List<Vehicle> vehicleList= repository.getAll();

        for (Vehicle vehicle : vehicleList) {
            VehicleGetDTO vehicleDTO = new VehicleGetDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners());
            vehicleDTOList.add(vehicleDTO);
        }
        return vehicleDTOList;
    }

    @Override
    public List<VehicleDTO> getFromDates(String since, String to) {
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : repository.getFromDates(since, to)){
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getServices(), vehicle.getCountOfOwners());
            vehicleDTOList.add(vehicleDTO);
        }
        return vehicleDTOList;
    }

    @Override
    public List<VehicleDTO> getFromPrices(Double since, Double to) {
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        if(since>to){
            throw new NonSenseException("Since should be smaller than to!");
        }
        for (Vehicle vehicle : repository.getFromPrices(since, to)){
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getServices(), vehicle.getCountOfOwners());
            vehicleDTOList.add(vehicleDTO);
        }
        return vehicleDTOList;
    }

    @Override
    public VehicleDTO getVehicle(Integer id) {
        Vehicle vehicle = repository.getVehicle(id);
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getServices(), vehicle.getCountOfOwners());
        return vehicleDTO;
    }
}
