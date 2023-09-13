package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle findByid(Long id) {
        for (Vehicle vehicle: listOfVehicles) {
            if (vehicle.getId().equals(id)){
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, Integer year) {
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (color.equals(vehicle.getColor()) && year.equals(vehicle.getYear())){
                vehiclesByColor.add(vehicle);
            }
        }
        return vehiclesByColor;
    }

    @Override
    public List<Vehicle> findByBrandAndYears(String brand, Integer from, Integer to) {
        List<Vehicle> vehiclesByBrandAndYEars = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (brand.equals(vehicle.getBrand()) && (from.intValue() <= vehicle.getYear() && vehicle.getYear() <= to.intValue())){
                vehiclesByBrandAndYEars.add(vehicle);
            }
        }
        return vehiclesByBrandAndYEars;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        List<Vehicle> vehiclesByBrand = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (brand.equals(vehicle.getBrand())){
                vehiclesByBrand.add(vehicle);
            }
        }
        return vehiclesByBrand;
    }

    @Override
    public List<Vehicle> findByFuel(String fuel) {
        List<Vehicle> vehiclesByFuel = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (fuel.equals(vehicle.getFuel_type())){
                vehiclesByFuel.add(vehicle);
            }
        }
        return vehiclesByFuel;
    }

    @Override
    public List<Vehicle> findByWeigth(Double min, Double max) {
        List<Vehicle> vehiclesByWeigth = new ArrayList<>();
        for(Vehicle vehicle: listOfVehicles){
            if (min <= vehicle.getWeight() && vehicle.getWeight() <= max){
                vehiclesByWeigth.add(vehicle);
            }
        }
        return vehiclesByWeigth;
    }

    @Override
    public List<Vehicle> findByHeigth(Double min, Double max) {
        List<Vehicle> vehiclesByWeigth = new ArrayList<>();
        for(Vehicle vehicle: listOfVehicles){
            if (min <= vehicle.getHeight() && vehicle.getHeight() <= max){
                vehiclesByWeigth.add(vehicle);
            }
        }
        return vehiclesByWeigth;
    }

    @Override
    public List<Vehicle> findByWidth(Double min, Double max) {
        List<Vehicle> vehiclesByWeigth = new ArrayList<>();
        for(Vehicle vehicle: listOfVehicles){
            if (min <= vehicle.getWidth() && vehicle.getWidth() <= max){
                vehiclesByWeigth.add(vehicle);
            }
        }
        return vehiclesByWeigth;
    }

    @Override
    public List<Vehicle> findBytransmission(String transmission) {
        List<Vehicle> vehiclesBytransmission = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (transmission.equals(vehicle.getTransmission())){
                vehiclesBytransmission.add(vehicle);
            }
        }
        return vehiclesBytransmission;
    }

    @Override
    public void save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public void delete(Vehicle vehicle) {
        listOfVehicles.remove(vehicle);
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
