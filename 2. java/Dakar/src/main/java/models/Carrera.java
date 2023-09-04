package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo nuevoAuto = new Auto(patente, velocidad, aceleracion, AnguloDeGiro);
            listaDeVehiculos.add(nuevoAuto);
        }

    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo nuevaMoto = new Moto(patente, velocidad, aceleracion, AnguloDeGiro);
            listaDeVehiculos.add(nuevaMoto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculoAEliminar){
        listaDeVehiculos.remove(vehiculoAEliminar);
    }
    public void eliminarVehiculoConPatente(String patenteDeVehiculoAEliminar){
        listaDeVehiculos = listaDeVehiculos.stream().filter(vehiculo -> !vehiculo.getPatente().equals(patenteDeVehiculoAEliminar)).toList();
    }

    public Vehiculo definirGanador(){
        if (listaDeVehiculos.isEmpty()) return null;
        return listaDeVehiculos.stream().max(Comparator.comparing(this::formulaGanador)).get();
    }

    private double formulaGanador(Vehiculo vehiculoACalcular){
        return (vehiculoACalcular.getVelocidad() * vehiculoACalcular.getAceleracion() / 2 )
                /
                (vehiculoACalcular.getAnguloDeGiro() * (vehiculoACalcular.getPeso() - vehiculoACalcular.getRuedas() * 100));
    }

    public void socorrerAuto(String patenteDeAutoASocorrer){
        Vehiculo autoASocorrer = listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patenteDeAutoASocorrer)).findFirst().get();
        socorristaAuto.socorrer((Auto) autoASocorrer);
    }
    public void socorrerMoto(String patenteDeMotoASocorrer){
        Vehiculo motoASocorrer = listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patenteDeMotoASocorrer)).findFirst().get();
        socorristaMoto.socorrer((Moto) motoASocorrer);
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }
}
