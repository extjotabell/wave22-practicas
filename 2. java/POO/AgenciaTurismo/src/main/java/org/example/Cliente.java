package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private double descuento;
    private List<Localizador> localizadores;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.descuento = 0;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public double getDescuento() {
        return descuento;
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

/*    private void futuroDescuento(){
        if(cliente.getLocalizadores().size()>=2){
            cliente.setDescuento(5);
        }
    }*/


}
