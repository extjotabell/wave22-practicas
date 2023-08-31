package org.example;

public class Pecedero extends Producto {
    int diasPorCaducar;

    public Pecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double total;
        if (this.diasPorCaducar == 1 ) {
            total = precio * 1/4 * cantidadDeProductos;
        } else if (this.diasPorCaducar == 2) {
            total = precio * 1/3 * cantidadDeProductos;
        } else if (this.diasPorCaducar == 3 ) {
            total = precio * 1/2 * cantidadDeProductos;
        } else {
            total = super.calcular(cantidadDeProductos);
        }
        return total;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Pecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
