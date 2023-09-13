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
    public List<Vehicle> findByHeight(Double min, Double max) {
        List<Vehicle> vehiclesByHeigth = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (min <= vehicle.getHeight() && vehicle.getHeight() <= max){
                vehiclesByHeigth.add(vehicle);
            }
        }
        return vehiclesByHeigth;
    }

    @Override
    public List<Vehicle> findByWidth(Double min, Double max) {
        List<Vehicle> vehiclesByWidth = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles) {
            if (min <= vehicle.getWidth() && vehicle.getWidth() <= max){
                vehiclesByWidth.add(vehicle);
            }
        }
        return vehiclesByWidth;
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
