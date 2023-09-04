package main;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Reserva> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Reserva reserva) {
        localizadores.add(reserva);
    }
}
