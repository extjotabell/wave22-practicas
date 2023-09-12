package com.ejercicios.concesionaria.repository;

import com.ejercicios.concesionaria.entity.Services;
import com.ejercicios.concesionaria.entity.Vehicles;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehiclesRepository implements IRepository{

    private final List<Vehicles> vehiclesList;
    private int nextVehicleId = 0;

    public VehiclesRepository(){
        this.vehiclesList = new ArrayList<>();
    }

    @Override
    public Integer save(Vehicles vehicles) {
        vehicles.setId(nextVehicleId++);
        vehiclesList.add(vehicles);
        return vehiclesList.size();
    }

    @Override
    public List<Vehicles> getAll() {
        return vehiclesList;
    }

    @Override
    public List<Vehicles> getDates(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas.");
        }

        return vehiclesList.stream()
                .filter(vehicle -> isManufacturingDateInRange(vehicle, startDate, endDate))
                .collect(Collectors.toList());
    }
    private boolean isManufacturingDateInRange(Vehicles vehicle, LocalDate startDate, LocalDate endDate) {
        LocalDate manufacturingDate = vehicle.getManufacturingDate();
        return manufacturingDate != null && !manufacturingDate.isBefore(startDate) && !manufacturingDate.isAfter(endDate);
    }

    @Override
    public List<Vehicles> getPrices(Double minPrice, Double maxPrice) {

        if (minPrice == null || maxPrice == null) {
            throw new IllegalArgumentException("Los Precios no pueden ser nulos.");
        }

        return vehiclesList.stream()
                .filter(vehicle -> isPriceInRange(vehicle, minPrice, maxPrice))
                .collect(Collectors.toList());
    }

    private boolean isPriceInRange(Vehicles vehicle, Double minPrice, Double maxPrice) {
        Double price = vehicle.getPrice();
        return price != null && price >= minPrice && price <= maxPrice;
    }

    @Override
    public Vehicles findById(Integer id) {
        if (vehiclesList == null || vehiclesList.isEmpty()) {
            return null; // La lista está vacía o es nula, por lo que no hay nada que buscar.
        }

        return vehiclesList
                .stream()
                .filter(vehicles -> vehicles != null && vehicles.getId() != null && vehicles.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
