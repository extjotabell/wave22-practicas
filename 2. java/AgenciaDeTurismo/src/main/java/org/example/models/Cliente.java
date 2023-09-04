package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre_completo;
    private String dni;

    public Cliente(String nombre_completo, String dni) {
        this.nombre_completo = nombre_completo;
        this.dni = dni;
    }

    public Cliente() {
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Localizador hacerCompra(int nroHoteles, int nroComidas, int nroBoletos, int nroTransportes, RepositorioLocalizadores repoLocalizadores){
        Reserva nuevaReserva = new Reserva(nroHoteles, nroComidas, nroBoletos, nroTransportes);
        return repoLocalizadores.agregarReserva(nuevaReserva, dni);
    }
}
