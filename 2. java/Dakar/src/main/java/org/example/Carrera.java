package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        vehiculos = new ArrayList<>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double AnguloDeGiro,String patente){
        if(vehiculos.size()<cantidadVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));
            System.out.println("Se dio de alta exitosamente al auto: "+ patente);
        } else System.out.println("No hay cupo para mas vehiculos");
    }

    public void darDeAltaMoto(double velocidad, double aceleracion,double AnguloDeGiro,String patente){
        if(vehiculos.size()<cantidadVehiculosPermitidos){
            vehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
            System.out.println("Se dio de alta exitosamente a la moto: "+ patente);
        } else System.out.println("No hay cupo para mas vehiculos");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculos.contains(vehiculo)){
            vehiculos.remove(vehiculo);
            System.out.println("El vehiculo de patente: " + vehiculo.getPatente() + " ha sido eliminado con exito");
        } else System.out.println("El vehiculo no corresponde a esta carrera");
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        int auxiliar = vehiculos.size();
        vehiculos = vehiculos.stream().filter(vehiculo->!vehiculo.getPatente().equals(unaPatente)).collect(Collectors.toList());
        if(vehiculos.size() < auxiliar){
            System.out.println("El vehiculo de patente: " + unaPatente + " ha sido eliminado con exito");
        } else{
            System.out.println("El vehiculo no fue encontrado");
        }
    }

    public Vehiculo encontrarVehiculo(String patente){
    //    return vehiculos.stream().filter(x->x.getPatente().compareTo(patente)).findFirst().get();
        for (Vehiculo vehiculo: vehiculos) {
            if(vehiculo.getPatente().equals(patente)){
                return vehiculo;
            } else System.out.println("El vehiculo no fue encontrado");
        }
        return null;
    }

    public void socorrerAuto(String patente){
        socorristaAuto.socorrer((Auto) encontrarVehiculo(patente));
    }

    public void setSocorristaMoto(String patente){
        socorristaMoto.socorrer((Moto) encontrarVehiculo(patente));
    }


}
