package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private Double distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public void darDeAltaAuto(Auto auto){
            listaDeVehiculos.add(auto);
            System.out.println("Alta auto " + auto.getPatente());
    }

    public void darDeAltaMoto(Moto moto){
            listaDeVehiculos.add(moto);
            System.out.println("Alta moto " + moto.getPatente());
    }

    public void eliminarVehiculo(Integer pos){
        listaDeVehiculos.remove(pos);
        System.out.println("Vehiculo eliminado en la posicion " + pos);
    }

    public void eliminarVehiculoConPatente(String patente){
        listaDeVehiculos.remove(listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst().get());
        System.out.println("Vehiculo eliminado " + patente);
    }

/*
    El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
*/
public Optional<Vehiculo> determinarGanador(List<Vehiculo> vehiculos) {
    return vehiculos.stream()
            .max(Comparator.comparingDouble(vehiculo -> {
                double numerador = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2);
                double denominador = vehiculo.getAnguloGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100);
                return numerador / denominador;
            }));
}

    public Carrera(Double distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Integer premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
}
