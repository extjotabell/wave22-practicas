package org.example;

import java.time.LocalDate;

public abstract class Reserva {

    private long id;

    private double monto;

    public Reserva(long id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
