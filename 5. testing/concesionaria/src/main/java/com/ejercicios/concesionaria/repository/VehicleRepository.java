package com.ejercicios.concesionaria.repository;

import com.ejercicios.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements IRepository<Vehicle, Integer> {

    private final List<Vehicle> vehicles;

    public VehicleRepository(){
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void save(Vehicle obj) {
        obj.setId(vehicles.size()+1);
        vehicles.add(obj);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public Vehicle getById(Integer id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vehicle> getByDate(LocalDate since, LocalDate to) {

        return vehicles.stream()
                .filter(vehicle -> vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to))
                .toList();
    }

    @Override
    public List<Vehicle> getByPrice(Double since, Double to) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() > since && vehicle.getPrice() < to )
                .collect(Collectors.toList());
    }
}
