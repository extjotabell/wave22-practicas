package domain;

import java.util.ArrayList;
import java.util.List;

public class Paquete {
    public int quantityReservas;
    private List<Reserva> reservas;

    public Paquete() {
        this.reservas = new ArrayList<>();
    }

    public List<Reserva> getReserva() {
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Integer getQuantityReservas() {
        for (Reserva reserva : reservas) {
            quantityReservas++;
        }
        return quantityReservas;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "reservas=" + reservas +
                '}';
    }
}
