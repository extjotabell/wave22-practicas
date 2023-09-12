package com.renzobayarri.concesionaria.repository;

import com.renzobayarri.concesionaria.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public List<Vehiculo> findAll() {
        return vehiculos;
    }

    @Override
    public Vehiculo findById(int id) {
        return vehiculos.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Vehiculo> findByManufacturingDateBetween(LocalDate since, LocalDate to) {
        return vehiculos.stream().filter(v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to)).toList();
    }

    @Override
    public List<Vehiculo> findByPriceBetween(double since, double to) {
        return vehiculos.stream().filter(v -> v.getPrice() >= since && v.getPrice() <= to).toList();
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        vehiculo.setId(vehiculos.size() + 1);
        vehiculos.add(vehiculo);
        return vehiculo;
    }

}
