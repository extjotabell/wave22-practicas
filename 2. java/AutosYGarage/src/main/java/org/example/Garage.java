package org.example;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private String id;
    private List<Vehiculo> vehiculos;

    public Garage(String id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void mostrarListaOrdenadaPorPrecio(){
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);
    }

    public void mostrarListaOrdenadaPorMarcaYPrecio(){
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio)).forEach(System.out::println);
    }

    public List<Vehiculo> retornarMenoresOIgualesA(int maximo){
        return vehiculos.stream().filter(v -> v.getPrecio() <= maximo).collect(Collectors.toList());
    }

    public List<Vehiculo> retornarMayoresOIgualesA(int minimo){
        return vehiculos.stream().filter(v -> v.getPrecio() >= minimo).collect(Collectors.toList());
    }

    public Double promedioDePrecios(){
        return vehiculos.stream().mapToDouble(Vehiculo::getPrecio).average().getAsDouble();
    }
}
