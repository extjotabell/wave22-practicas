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
    public double calcular(int cantidadDeProductos) {
        double total = super.calcular(cantidadDeProductos);
        double resp = 0.0;
        if(diasPorCaducar == 1){
            resp = total * 0.25;
        } else if (diasPorCaducar == 2) {
            resp = total * 0.33;
        } else if (diasPorCaducar == 3) {
            resp = total * 0.5;
        }
        return resp;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
