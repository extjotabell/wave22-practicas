package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    // Ejercicios

    @Override
    public void save(Vehicle vehicle) {
        this.listOfVehicles.add(vehicle);
    }

    @Override
    public Optional<Vehicle> findVehicle(Long id) {
        return this.listOfVehicles.stream()
                .filter(v -> Objects.equals(v.getId(), id))
                .findFirst();
//
//        Optional<Vehicle> vehicle = this.listOfVehicles.stream()
//                .filter(v -> Objects.equals(v.getId(), id))
//                .findFirst();
//
//        if (vehicle.isPresent()){
//            Vehicle v = vehicle.get();
//            int posList = this.listOfVehicles.indexOf(v);
//            System.out.println(posList);
//            v.setBrand("Charly");
//            this.listOfVehicles.set(posList, v);
//        }

//        return vehicle;
    }

    @Override
    public List<Vehicle> findByCharacteristics(Double min_width, Double max_width, Double min_height, Double max_height) {
        return this.listOfVehicles.stream()
                .filter(v -> min_width <= v.getWidth() && v.getWidth()<= max_width)
                .filter(v -> min_height <= v.getHeight() && v.getHeight() <= max_height)
                .toList();
    }


}
