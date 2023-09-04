package org.example;

import java.time.LocalDate;
import java.util.List;

public class Localizador {

    private Long id;

    private LocalDate fecha;

    private Cliente cliente;

    private List<Reserva> reservas;

    private double total;

    private double descuento;

    public Localizador(Long id, LocalDate fecha, Cliente cliente, List<Reserva> reservas) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.reservas = reservas;
        calcularTotal();
        calcularDescuento();
        this.cliente.agregarLocalizador(this);
    }

    private void calcularTotal() {
        this.total = reservas.stream().mapToDouble(Reserva::getMonto).sum();
    }

    private void calcularDescuento() {
        this.descuento = getDescuentosExtra() + getDescuentoPorComprasPrevias();

    }

    private double getDescuentoPorComprasPrevias() {
        if (cliente.getDescuentoFuturo() != 0) {
            return cliente.getDescuentoFuturo() * total;
        }
        return 0;
    }

    private double getDescuentosExtra() {
        if (this.reservas.size() < 4) {
            return 0;
        }
        int cantidadHotel = 0;
        int cantidadComida = 0;
        int cantidadBoleto = 0;
        int cantidadTransporte = 0;
        for (Reserva r : this.reservas) {
            if (r instanceof ReservaHotel) {
                cantidadHotel++;
            }else if(r instanceof ReservaComida){
                cantidadComida++;
            } else if (r instanceof ReservaBoletoViaje) {
                cantidadBoleto++;
            } else if (r instanceof ReservaTransporte) {
                cantidadTransporte++;
            }
        }

        if(cantidadBoleto == 1 && cantidadHotel == 1 && cantidadComida == 1 && cantidadTransporte == 1){
            return this.total * 0.1;
        }

        if(cantidadHotel == 2 || cantidadBoleto == 2){
            return reservas.stream()
                    .filter(r -> r instanceof ReservaHotel || r instanceof ReservaBoletoViaje)
                    .mapToDouble(Reserva::getMonto)
                    .sum() * 0.05;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                ", descuento=" + descuento +
                '}';
    }
}
