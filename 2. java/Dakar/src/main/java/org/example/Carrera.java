package org.example;

import java.util.Comparator;
import java.util.List;

public class Carrera {

    private double distancia;

    private double premioEnDolares;

    private String nombre;

    private int cantidadVehiculosPermitidos;

    private List<Vehiculo> listaVehiculos;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        listaVehiculos.remove(vehículo);
    }
    public void eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculoAEliminar = listaVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst()
                .orElseThrow(() -> new RuntimeException("No existe un vehiculo con la patente indicada"));
        listaVehiculos.remove(vehiculoAEliminar);
    }

    public Vehiculo determinarGanador(){
        return listaVehiculos.stream().max(Comparator.comparingDouble(v -> v.getVelocidad() * (v.getAcelacion() / 2) / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100))))
                .orElseThrow(() -> new RuntimeException("No hay ganador"));

        //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    }

    public void socorrerAuto(String patente){
        this.socorristaAuto.socorrer((Auto) buscarPorPatente(patente));
    }
    public void socorrerMoto(String patente){
        this.socorristaMoto.socorrer((Moto) buscarPorPatente(patente));
    }

    private Vehiculo buscarPorPatente(String patente){
        return listaVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst().orElseThrow(() -> new RuntimeException("No existe vehículo con esa patente"));
    }




}
