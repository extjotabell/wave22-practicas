package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;


    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        if(this.diasPorCaducar <= 1){
            return this.getPrecio()*cantidadDeProductos/4;
        }
        else if(this.diasPorCaducar <= 2){
            return this.getPrecio()*cantidadDeProductos/3;
        }
        else if(this.diasPorCaducar <= 3){
            return this.getPrecio()*cantidadDeProductos/2;
        }
        else{
            return this.getPrecio()*cantidadDeProductos;
        }
    }
}
