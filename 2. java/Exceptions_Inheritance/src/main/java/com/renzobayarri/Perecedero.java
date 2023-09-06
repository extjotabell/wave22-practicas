package com.renzobayarri;

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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos) {
        int divisor = 0;
        if(diasPorCaducar == 1){
            divisor = 4;
        }else if(diasPorCaducar == 2){
            divisor = 3;
        }else if(diasPorCaducar == 3){
            divisor = 2;
        }
        return super.calcular(cantidadProductos)/4;
    }
}