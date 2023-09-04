package org.example;


import java.util.ArrayList;
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

    public Carrera(Double distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void darDeAltaAuto(Double vel, Double ac, Integer ang, String pat){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo v = new Auto(vel, ac, ang, pat);
            this.listaDeVehiculos.add(v);
        }
    }

    public void darDeAltaMoto(Double vel, Double ac, Integer ang, String pat){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo v = new Moto(vel, ac, ang, pat);
            this.listaDeVehiculos.add(v);
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        this.listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(v.getPatente()));
    }

    public void eliminarVehiculo(String patente){
        this.listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void correr(){
        Double mayorValorFormula = this.getTiempoVehiculo(this.listaDeVehiculos.get(0));
        Vehiculo vehiculoMasRapido = this.listaDeVehiculos.get(0);

        for (Vehiculo v: this.listaDeVehiculos) {
            Double tiempoVehiculo = this.getTiempoVehiculo(v);
            if(mayorValorFormula < tiempoVehiculo){
                mayorValorFormula = tiempoVehiculo;
                vehiculoMasRapido = v;
            }
        }

        System.out.println("El vehiculo mas rapido es: " + vehiculoMasRapido);
    }

    private Double getTiempoVehiculo(Vehiculo v){
        return v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
    }

    public void socorrerAuto(String patente){
        Vehiculo auto = this.listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente) && vehiculo.getClass().equals(Auto.class)).findFirst().orElse(null);

        if(auto == null){
            System.out.println("No se encuentra auto con esa patente");
        }

        this.socorristaAuto.socorrerAuto((Auto) auto);
    }

    public void socorrerMoto(String patente){
        Vehiculo moto = this.listaDeVehiculos.stream().filter(
                vehiculo -> vehiculo.getPatente().equals(patente) && vehiculo.getClass().equals(Moto.class)
        ).findFirst().orElse(null);

        if(moto == null){
            System.out.println("No se encuentra Moto con esa patente");
            return;
        }

        this.socorristaMoto.socorrerMoto((Moto) moto);
    }
}
