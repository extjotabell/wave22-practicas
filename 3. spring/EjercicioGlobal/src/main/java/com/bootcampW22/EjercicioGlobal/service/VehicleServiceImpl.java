package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.ArgumentsNotValidException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ObjectMapper();
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> this.mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicle) {
        if(vehicleRepository.findByid(vehicle.getId()) != null){
            throw new AlreadyExistsException("Id already exists!");
        }
        Vehicle vehicleToSave = this.mapper.convertValue(vehicle, Vehicle.class);
        vehicleRepository.save(vehicleToSave);
        return vehicle;
    }

    @Override
    public List<VehicleDto> saveVehicles(List<VehicleDto> vehicles) {
        for (VehicleDto vehicle: vehicles) {
            if (!vehicle.verifyFields()){
                throw new ArgumentsNotValidException("Error in the body arguments!");
            }
            if (vehicleRepository.findByid(vehicle.getId()) != null){
                throw new AlreadyExistsException("ID: "+vehicle.getId()+" already exists!");
            }
            Vehicle vehicleToSave = this.mapper.convertValue(vehicle, Vehicle.class);
            vehicleRepository.save(vehicleToSave);
        }
        return vehicles;
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, Integer year) {
        List<Vehicle> vehiclesColorYear = vehicleRepository.findByColorAndYear(color,year);
        if(vehiclesColorYear.isEmpty()){
            throw new NotFoundException("Empty search for this color and year!");
        }
        List<VehicleDto> vehicles = new ArrayList<>();
        for (Vehicle vehicle: vehiclesColorYear) {
            VehicleDto vehicleDto = this.mapper.convertValue(vehicle, VehicleDto.class);
            vehicles.add(vehicleDto);
        }
        return vehicles;
    }

    @Override
    public List<VehicleDto> searchByBrandAndYears(String brand, Integer from, Integer to) {
        List<Vehicle> vehiclesBrandAndYear = vehicleRepository.findByBrandAndYears(brand, from, to);
        if(vehiclesBrandAndYear.isEmpty()){
            throw new NotFoundException("Empty search for this brand and years!");
        }
        List<VehicleDto> vehicles = new ArrayList<>();
        for (Vehicle vehicle: vehiclesBrandAndYear) {
            VehicleDto vehicleDto = this.mapper.convertValue(vehicle, VehicleDto.class);
            vehicles.add(vehicleDto);
        }
        return vehicles;
    }

    @Override
    public List<VehicleDto> searchVehiclesByWeight(Double min, Double max) {
        List<Vehicle> vehiclesWeigth = vehicleRepository.findByWeigth(min,max);
        if (vehiclesWeigth.isEmpty()){
            throw new NotFoundException("Emprty search for that weigth!");
        }
        List<VehicleDto> vehicles = new ArrayList<>();
        for (Vehicle vehicle: vehiclesWeigth) {
            VehicleDto vehicleDto = this.mapper.convertValue(vehicle, VehicleDto.class);
            vehicles.add(vehicleDto);
        }
        return vehicles;

    }

    @Override
    public List<VehicleDto> searchVehiclesByHeigthYWidth(String heigth, String width) {
        String[] heigths = heigth.split("-");
        String[] widths = width.split("-");
        List<Vehicle> vehiclesHeight = vehicleRepository.findByHeigth(Double.parseDouble(heigths[0]),Double.parseDouble(heigths[1]));
        List<Vehicle> vehiclesWidth = vehicleRepository.findByWidth(Double.parseDouble(widths[0]),Double.parseDouble(widths[1]));
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle: vehiclesHeight) {
            if (vehiclesWidth.contains(vehicle)){
                vehicles.add(vehicle);
            }
        }
        if (vehicles.isEmpty()){
            throw new NotFoundException("Emprty search for that Height and width!");
        }
        List<VehicleDto> vehiclesDto = new ArrayList<>();
        for (Vehicle vehicle: vehicles) {
            VehicleDto vehicleDto = this.mapper.convertValue(vehicle, VehicleDto.class);
            vehiclesDto.add(vehicleDto);
        }
        return vehiclesDto;
    }

    @Override
    public List<VehicleDto> searchByFuel(String fuel) {
        List<Vehicle> vehiclesByFuel = vehicleRepository.findByFuel(fuel);
        if(vehiclesByFuel.isEmpty()){
            throw new NotFoundException("Empty search for this fuel!");
        }
        List<VehicleDto> vehicles = new ArrayList<>();
        for (Vehicle vehicle: vehiclesByFuel) {
            VehicleDto vehicleDto = this.mapper.convertValue(vehicle, VehicleDto.class);
            vehicles.add(vehicleDto);
        }
        return vehicles;
    }

    @Override
    public List<VehicleDto> searchByTransmission(String transmission) {
        List<Vehicle> vehiclesByTransmission = vehicleRepository.findBytransmission(transmission);
        if(vehiclesByTransmission.isEmpty()){
            throw new NotFoundException("Empty search for this transmission!");
        }
        List<VehicleDto> vehicles = new ArrayList<>();
        for (Vehicle vehicle: vehiclesByTransmission) {
            VehicleDto vehicleDto = this.mapper.convertValue(vehicle, VehicleDto.class);
            vehicles.add(vehicleDto);
        }
        return vehicles;
    }

    @Override
    public SpeedAverageDto averageSpeed(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(brand);
        if (vehiclesByBrand.isEmpty()){
            throw new NotFoundException("Brand not found!");
        }
        Double total = 0.0;
        for (Vehicle vehicle: vehiclesByBrand) {
            total+=Integer.parseInt(vehicle.getMax_speed());
        }
        return new SpeedAverageDto(brand,total/vehiclesByBrand.size());
    }

    @Override
    public CapacityAverageDto averageCapacity(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(brand);
        if (vehiclesByBrand.isEmpty()){
            throw new NotFoundException("Brand not found!");
        }
        Integer total = 0;
        for (Vehicle vehicle: vehiclesByBrand) {
            total+=vehicle.getPassengers();
        }
        return new CapacityAverageDto(brand, total/vehiclesByBrand.size());
    }

    @Override
    public VehicleDto updateSpeed(Long id, UpdateSpeedDto updateSpeedDto) {
        Vehicle vehicle = vehicleRepository.findByid(id);
        if (vehicle == null){
            throw new NotFoundException("Vehicle not found!");
        }
        vehicle.setMax_speed(updateSpeedDto.getMax_speed().toString());
        vehicleRepository.save(vehicle);
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto updateFuel(Long id, UpdateFuelDto updateFuelDto) {
        Vehicle vehicle = vehicleRepository.findByid(id);
        if (vehicle == null){
            throw new NotFoundException("Vehicle not found!");
        }
        vehicle.setFuel_type(updateFuelDto.getFuel());
        vehicleRepository.save(vehicle);
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto deleteVehicle(Long id) {
        Vehicle vehicleToDelete = vehicleRepository.findByid(id);
        if (vehicleToDelete == null){
            throw new NotFoundException("Vehicle not found!");
        }
        vehicleRepository.delete(vehicleToDelete);
        return mapper.convertValue(vehicleToDelete, VehicleDto.class);
    }

}
