package com.example.ejercicioconcesionaria.repository;

import com.example.ejercicioconcesionaria.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    @Autowired
    private List<Vehicle> database;
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
        return database.stream().filter(v -> v.getManufacturingDate().after(Date.valueOf(since)) && v.getManufacturingDate().before(Date.valueOf(to))).toList();
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
