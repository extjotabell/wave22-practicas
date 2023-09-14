package org.example;

public class Reserva {

    public enum TipoReserva {
        HOTEL,
        COMIDA,
        BOLETOS,
        TRANSPORTE
    }
    private TipoReserva tipo;
    private double precio;

    public Reserva(TipoReserva tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }


}
