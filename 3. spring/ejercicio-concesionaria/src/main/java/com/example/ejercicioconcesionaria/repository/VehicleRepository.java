package com.example.ejercicioconcesionaria.repository;

import com.example.ejercicioconcesionaria.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> database = new ArrayList<>();
    private int contadorId = 0;

    @Override
    public void addVehicle(Vehicle veh) {
        contadorId++;
        veh.setId(contadorId);
        database.add(veh);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return database;
    }

    @Override
    public List<Vehicle> getVehiclesByManufacturingDate(String since, String to) {
        return database.stream().filter(v -> v.getManufacturingDate().isAfter(LocalDate.parse(since)) && v.getManufacturingDate().isBefore(LocalDate.parse(to))).toList();
    }

    @Override
    public List<Vehicle> getVehiclesByPrice(int since, int to) {
        return database.stream().filter(v -> v.getPrice() > since && v.getPrice() < to).toList();
    }

    @Override
    public Vehicle getVehicle(int id) {
        return database.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }
}
