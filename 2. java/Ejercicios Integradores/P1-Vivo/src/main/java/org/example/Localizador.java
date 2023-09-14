package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Repositorio repositorio;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public double calcularDescuento(){
        double descuento = 0.0;

        if(cliente.getLocalizadores().size() >= 2) {
            descuento += calcularTotal() * 0.05;
            System.out.println("Descuento 1 aplicado");
        }

        boolean tieneHotel = false;
        boolean tieneComida = false;
        boolean tieneBoletos = false;
        boolean tieneTransporte = false;

        for (Reserva reserva : reservas) {
            if (reserva.getTipo().equals(Reserva.TipoReserva.HOTEL)) {
                tieneHotel = true;
            } else if (reserva.getTipo().equals(Reserva.TipoReserva.COMIDA)) {
                tieneComida = true;
            } else if (reserva.getTipo().equals(Reserva.TipoReserva.BOLETOS)) {
                tieneBoletos = true;
            } else if (reserva.getTipo().equals(Reserva.TipoReserva.TRANSPORTE)) {
                tieneTransporte = true;
            }
        }

        if (tieneHotel && tieneComida && tieneBoletos && tieneTransporte) {
            descuento += calcularTotal() * 0.10;
            System.out.println("Descuento 2 aplicado");
        }

        int countHotel = 0;
        int countBoletos = 0;

        for (Reserva reserva : reservas) {
            if (reserva.getTipo().equals(Reserva.TipoReserva.HOTEL)) {
                countHotel++;
            } else if (reserva.getTipo().equals(Reserva.TipoReserva.BOLETOS)) {
                countBoletos++;
            }
        }

        if (countHotel >= 2 || countBoletos >= 2) {
            descuento += calcularTotal() * 0.05;
            System.out.println("Descuento 3 aplicado");
        }

        return descuento;
    }

    public double calcularTotal(){
        double total = 0.0;
        for (Reserva reserva : reservas) {
            total += reserva.getPrecio();
        }
        return total;
    }

    public void imprimirLocalizador() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reservas:");

        for (Reserva reserva : reservas) {
            System.out.println("- Tipo: " + reserva.getTipo() + ", Costo: " + reserva.getPrecio());
        }

        double descuento = calcularDescuento();
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Total a pagar: " + (calcularTotal() - descuento));
    }
}
