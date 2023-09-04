package main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    List<Vehiculo> vehiculos = new ArrayList<>();

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if(cantidadDeVehiculosPermitidos > vehiculos.size())
            vehiculos.add(auto);
        else
            System.out.println("La carrera está llena.");
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if(cantidadDeVehiculosPermitidos > vehiculos.size())
            vehiculos.add(moto);
        else
            System.out.println("La carrera está llena.");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if(vehiculos.contains(vehiculo))
            vehiculos.remove(vehiculo);
        else
            System.out.println("El vehiculo no pertenece a la carrera.");
    }

    public void eliminarVehiculo(String patente) {
       Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(p -> p.getPatente().equals(patente)).findFirst();
       Vehiculo vehiculo = optionalVehiculo.orElse(null);
       if(vehiculo!= null)
           vehiculos.remove(vehiculo);
       else
           System.out.println("El vehiculo no pertenece a la carrera.");
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(p -> p.getPatente().equals(patente)).findFirst();
        Vehiculo vehiculo = optionalVehiculo.orElse(null);
        if(vehiculo!= null)
            socorristaAuto.socorrer(vehiculo);
        else
            System.out.println("El vehiculo no pertenece a la carrera.");
    }
    public void socorrerMoto(String patente) {
        Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(p -> p.getPatente().equals(patente)).findFirst();
        Vehiculo vehiculo = optionalVehiculo.orElse(null);
        if(vehiculo!= null)
            socorristaMoto.socorrer(vehiculo);
        else
            System.out.println("El vehiculo no pertenece a la carrera.");
    }

    public void determinarGanador() {
        Optional<Vehiculo> optionalVehiculo = vehiculos.stream().max(Comparator.comparing((Vehiculo::calcularValorParaGanar)));
        Vehiculo vehiculoGanador = optionalVehiculo.orElse(null);
        System.out.println("El ganador es " + vehiculoGanador.toString());
    }

}
