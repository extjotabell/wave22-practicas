package com.renzobayarri.concesionaria.repository;

import com.renzobayarri.concesionaria.entity.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoRepository {

    List<Vehiculo> findAll();

    Vehiculo findById(int id);

    List<Vehiculo> findByManufacturingDateBetween(LocalDate since, LocalDate to);

    List<Vehiculo> findByPriceBetween(double since, double to);

    Vehiculo save(Vehiculo vehiculo);
}
