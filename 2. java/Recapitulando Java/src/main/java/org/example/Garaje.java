package org.example;
import java.util.List;
import java.util.ArrayList;

public class Garaje {
    private int id;
    private List <Vehiculo> listaVehiculos = new ArrayList<>();

    public Garaje(int id) {
        this.id = id;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        this.listaVehiculos.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
}

