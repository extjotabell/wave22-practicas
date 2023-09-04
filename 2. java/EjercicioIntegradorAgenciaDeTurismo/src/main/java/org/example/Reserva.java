package org.example;

public class Reserva {

    private TipoReserva tipo;
    private double monto;

    public Reserva(TipoReserva tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    public TipoReserva getTipo(){
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
