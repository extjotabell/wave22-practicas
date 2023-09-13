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
import java.util.Objects;
import java.util.Optional;

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
    public void updateVehicle(int index, Vehicle vehicleUpdate) {
        listOfVehicles.set(index, vehicleUpdate);
    }

    @Override
    public boolean existsVehicle(Long id) {
        Optional<Vehicle> vehicleOptional= listOfVehicles.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst();

        return vehicleOptional.isPresent();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return listOfVehicles.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst();
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
