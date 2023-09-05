package domain;

import java.util.List;
import java.util.Objects;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
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

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, int anguloDeGiro,
                              String patente) {
        if(cantidadDeVehiculosPermitidos < listaDeVehiculos.size()) {
            Vehiculo vehiculoAuto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(vehiculoAuto);
        } else {
            System.out.println("Maima cantidad de vehiculos alcanzados.");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, int anguloDeGiro,
                              String patente) {
        if(cantidadDeVehiculosPermitidos < listaDeVehiculos.size()) {
            Vehiculo vehiculoMoto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(vehiculoMoto);
        } else {
            System.out.println("Maima cantidad de vehiculos alcanzados.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        for (Vehiculo vehi : listaDeVehiculos) {
            if(Objects.equals(vehi, vehiculo)) {
                listaDeVehiculos.remove(vehiculo);
                System.out.println("Vehiculo eliminado con exito. ");
            }
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for (Vehiculo vehi : listaDeVehiculos) {
            if(Objects.equals(vehi.getPatente(), unaPatente)) {
                listaDeVehiculos.remove(vehi);
                System.out.println("Vehiculo eliminado con exito. ");
            }
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }
}
