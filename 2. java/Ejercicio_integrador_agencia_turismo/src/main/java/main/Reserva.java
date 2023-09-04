package main;

import main.paqueteTuristico.PaqueteCompleto;

import java.util.List;

public class Reserva {
    private Cliente cliente;
    protected double total;
    private List<String> detalles;

    public Reserva(Cliente cliente, double total, List<String> detalles) {
        this.cliente = cliente;
        this.total = total;
        this.detalles = detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
