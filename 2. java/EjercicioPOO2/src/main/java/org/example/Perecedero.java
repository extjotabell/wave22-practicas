package org.example;

public class Perecedero extends Producto {
    public int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        diasPorCaducar = this.diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public double calcular(int cantidadDeProductos)
    {
        double precioProducto = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar)
        {
            case 1:
                return precioProducto/4;
            case 2:
                return precioProducto/3;
            case 3:
                return precioProducto/2;
            default: return precioProducto;
        }
    }
}
