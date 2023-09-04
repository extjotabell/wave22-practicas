package org.example;

public abstract class Reserva {

    private int id;
    private double monto;
    private String fechaEntradaSalida;

    public Reserva(int id, double monto, String fechaEntradaSalida) {
        this.id = id;
        this.monto = monto;
        this.fechaEntradaSalida = fechaEntradaSalida;
    }

    public Reserva(){

    }

    public void aplicarDescuento(double multiplicadorPorcentaje){
        monto = monto*multiplicadorPorcentaje;
    }

    public int getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public String getFechaEntradaSalida() {
        return fechaEntradaSalida;
    }


}
