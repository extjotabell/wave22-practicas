package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        if (diasPorCaducar==1)return (this.getPrecio()*cantidadDeProductos)/4;
        if (diasPorCaducar==2)return (this.getPrecio()*cantidadDeProductos)/3;
        else if (diasPorCaducar==3)return (this.getPrecio()*cantidadDeProductos)/2;
        else return this.getPrecio()*cantidadDeProductos;
    }
}
