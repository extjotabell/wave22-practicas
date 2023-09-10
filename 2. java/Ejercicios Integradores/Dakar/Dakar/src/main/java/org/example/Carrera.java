package org.example;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else{
            System.out.println("No se aceptan más vehículos para esta carrera");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else{
            System.out.println("No se aceptan más vehículos para esta carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> vehiculoAEliminar = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
        if (vehiculoAEliminar.isPresent()) {
            vehiculos.remove(vehiculoAEliminar.get());
            System.out.println("Vehículo con patente " + patente + " eliminado.");
        } else {
            System.out.println("No se ha encontrado un vehículo con esa patente.");
        }
    }

    public void determinarGanador(){
        Optional<Vehiculo> ganador = vehiculos.stream()
                .max(Comparator.comparingDouble(vehiculo -> {
                    double velocidad = vehiculo.getVelocidad();
                    double aceleracion = vehiculo.getAceleracion();
                    double anguloDeGiro = vehiculo.getAnguloDeGiro();
                    double peso = vehiculo.getPeso();
                    int ruedas = vehiculo.getRuedas();

                    return velocidad * 0.5 * aceleracion / (anguloDeGiro * (peso - ruedas * 100));
                }));
        if(ganador.isPresent()){
            Vehiculo vehiculoGanador = ganador.get();
            if(vehiculoGanador instanceof Auto){
                System.out.println("El ganador es el auto de patente: " + vehiculoGanador.getPatente());
            }
            else if(vehiculoGanador instanceof Moto){
                System.out.println("El ganador es la moto de patente: " + vehiculoGanador.getPatente());
            }
            else{
                System.out.println("Ha ocurrido un error");
            }
        }
        else{
            System.out.println("No hay vehículos inscriptos para esta carrera");
        }
    }

        public String socorrer(String patente){
        Optional<Vehiculo> vehiculoASocorrer = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
        if(vehiculoASocorrer.isPresent()){
            if(vehiculoASocorrer.get() instanceof Auto){
                SocorristaAuto.socorrer((Auto) vehiculoASocorrer.get());
            }
            else if(vehiculoASocorrer.get() instanceof Moto){
                SocorristaMoto.socorrer((Moto) vehiculoASocorrer.get());
            }
            return vehiculoASocorrer.get().getPatente();

        }
        else {
            System.out.println("No existe vehículo con esa patente");
            return null;
        }
    }

}
