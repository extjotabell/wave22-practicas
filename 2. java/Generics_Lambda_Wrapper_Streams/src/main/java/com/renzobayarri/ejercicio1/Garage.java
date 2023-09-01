package com.renzobayarri.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private int id;

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Garage() {
    }

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
