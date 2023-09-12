package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    Map<Integer, Vehicle> vehicleMap = new HashMap<>();
    Integer idCounter = 0;

    @Override
    public void save(Vehicle vehicle) {
        vehicleMap.put(idCounter, vehicle);
        idCounter++;
    }

    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<Vehicle>(vehicleMap.values());

    }

    @Override
    public List<Vehicle> getFromDates(String from, String to) {
        LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Vehicle> vehicleList = getAll();
        System.out.println("From: "+fromDate);
        System.out.println("To: "+toDate);
        return vehicleList.stream().filter(vehicle -> vehicle.getManufacturingDate().isBefore(toDate) && vehicle.getManufacturingDate().isAfter(fromDate)).toList();
    }

    @Override
    public List<Vehicle> getFromPrices(Double from, Double to) {
        List<Vehicle> vehicleList = getAll();

        return vehicleList.stream().filter(vehicle -> vehicle.getPrice() >= from && vehicle.getPrice() <= to).toList();
    }

    @Override
    public Vehicle getVehicle(Integer id) {
        return vehicleMap.get(id);
    }
}
