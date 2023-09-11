package com.example.ConcesionariaAutos.repository;

import com.example.ConcesionariaAutos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private final Map<Integer, Vehicle> vehicleList;

    public VehicleRepository(){
        this.vehicleList = new HashMap<>();
    }

    @Override
    public Integer addVehicle(Vehicle v){
        int id = vehicleList.size()+1;
        this.vehicleList.put(id, v);
        return id;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleList.values().stream().toList();
    }

    @Override
    public List<Vehicle> getVehiclesByDate(LocalDate since, LocalDate to) {
        return this.vehicleList.values().stream().filter(v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getVehiclesByPrice(double from, double to) {
        return this.vehicleList.values().stream()
                .filter(v -> v.getPrice() >= from && v.getPrice()<=to)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleList.get(id);
    }
}
