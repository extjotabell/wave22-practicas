package com.concesionariaDeAutos.concesionariaDeAutos.repository;

import com.concesionariaDeAutos.concesionariaDeAutos.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryVehicle implements IRepositoryVehicle{

    private List<Vehicle> vehiclesDB;

    public RepositoryVehicle() {
        uploadDataBase();
    }

    public void uploadDataBase(){
        File carsFile = null;

        try {
            carsFile = ResourceUtils.getFile("classpath:cars.json");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Vehicle>> carsTypeRef = new TypeReference<>() {};

        try {
            List<Vehicle> vehicles = objectMapper.readValue(carsFile, carsTypeRef);

            System.out.println("Database load successfully!");
            vehiclesDB = vehicles;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehiclesDB.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehiclesDB;
    }
}
