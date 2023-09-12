package com.example.concesionaria.repository;
import com.example.concesionaria.entity.Auto;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository implements IAutoRepository{

    List<Auto> autos;

    public AutoRepository() {
        this.autos = new ArrayList<>();
    }

    @Override
    public void createAuto(Auto auto){
        autos.add(auto);
    }

    @Override
    public List<Auto> obtenerAutos(){
        return autos;
    }

    @Override
    public List<Auto> obtenerAutosPorFechaDesde(LocalDate fecha, LocalDate to){
        return autos.stream()
                .filter(auto -> auto.getManufacturingDate().isAfter(fecha.minusDays(1)))
                .filter(auto -> auto.getManufacturingDate().isBefore(to.plusDays(1)))
                .toList();
    }

    @Override
    public List<Auto> obtenerAutosPorPrecioDesde(double precio, double to){
        return autos.stream()
                .filter(auto -> auto.getPrice() >= precio && auto.getPrice() <= to)
                .toList();
    }

    @Override
    public Auto obtenerAutoPorId(int autoId){
        return autos.stream()
                .filter(auto -> auto.getId() == autoId)
                .findFirst()
                .get();
    }
}
