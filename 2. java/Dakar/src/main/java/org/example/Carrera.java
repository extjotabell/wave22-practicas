package org.example;

import org.example.Socorristas.VehiculoSocorrista;
import org.example.Vehiculos.Auto;
import org.example.Vehiculos.Moto;
import org.example.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioEnUsd;
    private String nombre;
    private int cantVehiculosPermitidos;
    private List<Vehiculo> inscriptos;
    private List<VehiculoSocorrista<? extends Vehiculo>> socorristas;

    public Carrera(double distancia, double premioEnUsd, String nombre, int cantVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnUsd = premioEnUsd;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.inscriptos = new ArrayList<>();
        this.socorristas = new ArrayList<>();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnUsd() {
        return premioEnUsd;
    }

    public void setPremioEnUsd(double premioEnUsd) {
        this.premioEnUsd = premioEnUsd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(int cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public List<Vehiculo> getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(List<Vehiculo> inscriptos) {
        this.inscriptos = inscriptos;
    }

    public List<VehiculoSocorrista<? extends Vehiculo>> getSocorristas() {
        return socorristas;
    }

    public void setSocorristas(List<VehiculoSocorrista<? extends Vehiculo>> socorristas) {
        this.socorristas = socorristas;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnUsd=" + premioEnUsd +
                ", nombre='" + nombre + '\'' +
                ", cantVehiculosPermitidos=" + cantVehiculosPermitidos +
                ", inscriptos=" + inscriptos +
                ", socorristas=" + socorristas +
                '}';
    }

    public void darDeAltaAuto(double v, double a, double angulo, String patente){
        Vehiculo auto = new Auto(v, a, angulo, patente);
        if(this.cantVehiculosPermitidos > this.inscriptos.size()){
            this.inscriptos.add(auto);
            System.out.println("Se incribiò el vehiculo: "+auto);
        }
        else
            System.out.println("La carrera ya esta completa con "+this.cantVehiculosPermitidos+" vehiculos incriptos");
    }
    public void darDeAltaMoto(double v, double a, double angulo, String patente){
        Vehiculo moto = new Moto(v, a, angulo, patente);
        if(this.cantVehiculosPermitidos > this.inscriptos.size()){
            this.inscriptos.add(moto);
            System.out.println("Se incribiò el vehiculo: "+moto);
        }
        else
            System.out.println("La carrera ya esta completa con "+this.cantVehiculosPermitidos+" vehiculos incriptos");

    }

    public void eliminarVehiculo(Vehiculo v){
        inscriptos.remove(v);
        System.out.println(this.inscriptos);
    }

    public void eliminarVehiculoXPatente(String patente){
        Vehiculo vehiculo = inscriptos.stream().filter(v -> v.getPatente().equals(patente)).findFirst().orElse(null);
        if(vehiculo != null)
            this.eliminarVehiculo(vehiculo);
        else
            System.out.println("no existe ningun vehiculo con esa patente");
    }


    public void definirGanador(){
        Vehiculo ganador = null;
        double contador = 0;
        for (Vehiculo v :
                inscriptos) {
           double a =  v.getVelocidad()*(v.getAceleracion()/2)/ (v.getAnguloGiro()*(v.getPeso()-v.getRuedas()*100));
           System.out.println("para el vehiculo "+v.getPatente()+" el resultado es: "+a);
           if(contador<a){
               contador = a;
               ganador = v;
           }
        }
        System.out.println("EL GANADOR ES...... "+ganador.getPatente());
    }
}
