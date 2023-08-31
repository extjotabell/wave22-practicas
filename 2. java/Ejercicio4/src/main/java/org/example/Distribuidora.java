package org.example;

import java.util.ArrayList;

public class Distribuidora {

    private ArrayList<Producto> lista;

    public Distribuidora() {
        this.lista = new ArrayList<>();
    }

    public void ingresarProducto(Producto producto){
        this.lista.add(producto);
    }

    public void venderProductos(Integer cantidadDeProductos){
        for (Producto producto : this.lista){
            System.out.println("El precio total de "+ cantidadDeProductos+" "+producto.getNombre()+" es: "+ producto.calcular(cantidadDeProductos));
        }
    }
}
