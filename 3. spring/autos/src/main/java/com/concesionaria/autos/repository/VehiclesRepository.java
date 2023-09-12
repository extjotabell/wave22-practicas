package com.concesionaria.autos.repository;

import com.concesionaria.autos.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class VehiclesRepository implements IVehiclesRepository{
    private Map<Integer, Vehicle> vehicleList;

    public VehiclesRepository(){
        this.vehicleList = new HashMap<>();
    }


    @Override
    public Integer addVehicle(Vehicle vehicle) {
        int id = vehicleList.size()+1;
        vehicleList.put(id, vehicle);
        return id;
    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehicleList.values().stream().toList();
    }

    @Override
    public List<Vehicle> getVehiclesByDate(LocalDate since, LocalDate to) {

        List<Vehicle> foundedVehicles = new ArrayList<>();

        for (Map.Entry<Integer, Vehicle> entry : vehicleList.entrySet()) {
            Integer id = entry.getKey();
            Vehicle vehicle = entry.getValue();
            LocalDate dateVehicle = vehicle.getManufacturingDate();

            // Verifica si la fecha de fabricación se encuentra entre el rango de "since" y "to"
            if (since.isAfter(dateVehicle) && to.isBefore(dateVehicle)) {
                foundedVehicles.add(vehicle);
            }
        }
        return foundedVehicles;
    }

    @Override
    public List<Vehicle> getVehicesByPrice(double from, double to) {
        return this.vehicleList.values().stream()
                .filter(vehicle -> vehicle.getPrice() >= from && vehicle.getPrice() <= to)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return this.vehicleList.get(id);
    }
}
