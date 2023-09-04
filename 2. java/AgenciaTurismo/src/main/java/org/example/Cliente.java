package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String dni;

    private String nombre;

    private List<Localizador> localizadores;

    private double descuentoFuturo;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public double getDescuentoFuturo() {
        return descuentoFuturo;
    }

    public void setDescuentoFuturo(double descuentoFuturo) {
        this.descuentoFuturo = descuentoFuturo;
    }

    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
        if (localizadores.size() >= 2){
            this.descuentoFuturo = 0.05;
        }
    }
}
