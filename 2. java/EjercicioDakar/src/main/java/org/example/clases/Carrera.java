package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premio;
    private String nombre;
    private Integer cantodadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(Double distancia, Double premio, String nombre, Integer cantodadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantodadDeVehiculosPermitidos = cantodadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();

    }
    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantodadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            listaDeVehiculos.add(auto);
        }else {
            System.out.println("la carrera esta llena!");
        }
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantodadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            listaDeVehiculos.add(moto);
        }else {
            System.out.println("la carrera esta llena!");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculobuscado = null;
        for (Vehiculo vehiculo: this.listaDeVehiculos) {
            if(vehiculo.getPatente() == patente){
                vehiculobuscado = vehiculo;
                break;
            }
        }

        if (vehiculobuscado != null){
            listaDeVehiculos.remove(vehiculobuscado);
        }else {
            System.out.println("Vehiculo no encontrado!");
        }
    }

    public Vehiculo definirGanador(){
        Vehiculo ganador = listaDeVehiculos.get(0);
        double maximo = calcularFormula(ganador);
        for (int i = 1; i < listaDeVehiculos.size(); i++) {
            double calculoActual = calcularFormula(listaDeVehiculos.get(i));
            if (calculoActual>maximo){
                maximo=calculoActual;
                ganador=listaDeVehiculos.get(i);
            }
        }
        return ganador;
    }

    public double calcularFormula(Vehiculo vehiculo){
        return vehiculo.getVelocidad()*vehiculo.getAceleracion()*0.5/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
    }

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) socorristaAuto.socorrer((Auto)vehiculo); //Si se la pasa la patente de una moto se rompe
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) socorristaMoto.socorrer((Moto)vehiculo); //Si se la pasa la patente de un auto se rompe
        }
    }


}
