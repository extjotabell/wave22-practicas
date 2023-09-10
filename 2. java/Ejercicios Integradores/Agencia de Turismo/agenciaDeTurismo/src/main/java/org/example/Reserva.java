package org.example;

enum tiposDeReserva {
    HOTEL, COMIDA, BOLETOS, TRANSPORTE;
        };

public class Reserva {
    private tiposDeReserva tipo;
    private double precio;

    public Reserva(tiposDeReserva tipo) {
        this.tipo = tipo;
        if(tipo == tiposDeReserva.BOLETOS){
            precio = 500;
        }
        else if(tipo == tiposDeReserva.COMIDA){
            precio = 50;
        }
        else if(tipo == tiposDeReserva.HOTEL){
            precio = 200;
        }
        else{
            precio = 100;
        }
    }

    public tiposDeReserva getTipo() {
        return tipo;
    }

    public void setTipo(tiposDeReserva tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
