package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Auto;

import java.time.LocalDate;
import java.util.List;

public interface IAutoRepository {
    void createAuto(Auto auto);
    List<Auto> obtenerAutos();
    List<Auto> obtenerAutosPorFechaDesde(LocalDate fecha);
    List<Auto> obtenerAutosPorPrecioDesde(double precio);
    Auto obtenerAutoPorId(int autoId);
}


