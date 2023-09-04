package Models;

import java.util.List;

public class PaqueteTuristico {
    double precio;
    private List<Integer> nroReserva;
    private List<String> nroBoleto;
    private boolean transporte;
    private boolean comida;

    public PaqueteTuristico(double precio, List<Integer> nroReserva, List<String> nroBoleto) {
        this.precio = precio;
        this.nroReserva = nroReserva;
        this.nroBoleto = nroBoleto;
    }

    public PaqueteTuristico(double precio, List<Integer> nroReserva, List<String> nroBoleto, boolean transporte, boolean comida) {
        this.precio = precio;
        this.nroReserva = nroReserva;
        this.nroBoleto = nroBoleto;
        this.transporte = transporte;
        this.comida = comida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Integer> getNroReserva() {
        return nroReserva;
    }

    public void setNroReserva(List<Integer> nroReserva) {
        this.nroReserva = nroReserva;
    }

    public List<String> getNroBoleto() {
        return nroBoleto;
    }

    public void setNroBoleto(List<String> nroBoleto) {
        this.nroBoleto = nroBoleto;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "precio=" + precio +
                ", reserva=" + nroReserva +
                ", nroBoleto=" + nroBoleto +
                ", transporte=" + transporte +
                ", comida=" + comida +
                '}';
    }
}
