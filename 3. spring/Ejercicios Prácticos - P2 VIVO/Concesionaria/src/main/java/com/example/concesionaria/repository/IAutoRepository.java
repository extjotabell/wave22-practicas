package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Auto;

import java.time.LocalDate;
import java.util.List;

public interface IAutoRepository {
    void createAuto(Auto auto);
    List<Auto> obtenerAutos();
    List<Auto> obtenerAutosPorFechaDesde(LocalDate fecha, LocalDate fecha2);
    List<Auto> obtenerAutosPorPrecioDesde(double precio, double precio2);
    Auto obtenerAutoPorId(int autoId);
}


