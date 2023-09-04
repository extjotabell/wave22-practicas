package org.example.models;

public class Localizador {
    private String dniCliente;
    private double totalConDescuento;
    private Reserva reserva;

    public Localizador(String dniCliente, double totalConDescuento, Reserva reserva) {
        this.dniCliente = dniCliente;
        this.totalConDescuento = totalConDescuento;
        this.reserva = reserva;
    }

    public Localizador() {
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public double getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(double totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "dniCliente='" + dniCliente + '\'' +
                ", totalConDescuento=" + totalConDescuento +
                ", reserva=" + reserva +
                '}';
    }
}
