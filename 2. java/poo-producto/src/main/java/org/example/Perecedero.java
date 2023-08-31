package org.example;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular (int cantidadProductos){
        if(diasPorCaducar == 1){
            return (cantidadProductos * getPrecio() ) / 4;
        } else if (diasPorCaducar == 2) {
            return (cantidadProductos * getPrecio() ) / 3;
        } else if (diasPorCaducar == 3) {
            return (cantidadProductos * getPrecio() ) / 2;
        }else {
            return cantidadProductos * getPrecio();
        }

    }
}
