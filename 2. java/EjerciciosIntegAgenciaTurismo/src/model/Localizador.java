package model;

import model.Cliente;

import java.util.*;
import java.util.stream.Collectors;

public class Localizador {

    private final Cliente cliente;
    private final List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.total = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        total = calcularTotal();
    }

    public boolean contienePaqueteCompleto(List<Reserva> reservas) {
        Set<String> nombresProductos = reservas.stream()
                .flatMap(reserva -> reserva.getProductos().stream())
                .map(Producto::getNombre)
                .collect(Collectors.toSet());

        return nombresProductos.containsAll(Arrays.asList("Hotel", "Comida", "Boleto de Viaje", "Transporte"));
    }

    public double calcularTotal(){
        double descuentoPaqueteCompleto = contienePaqueteCompleto(reservas) ? 0.10 : 0.0;
        double descuentoHotelBoletos = calcularDescuentoHotelBoletos(reservas) ? 0.05 : 0.0;
        System.out.println("descuentoPaqueteCompleto " + descuentoPaqueteCompleto);
        System.out.println("descuentoHotelBoletos " + descuentoHotelBoletos);
        double totalsinDescuento = reservas.stream()
                .mapToDouble(Reserva::getTotal)
                .sum();
        System.out.println("totalsinDescuento " + totalsinDescuento);
        double descuentoTotal = descuentoPaqueteCompleto + descuentoHotelBoletos;
        System.out.println("descuentoTotal " + descuentoTotal);
        return totalsinDescuento - (totalsinDescuento * descuentoTotal);
    }

    public boolean calcularDescuentoHotelBoletos(List<Reserva> reservas) {
        Set<String> nombresProductos = reservas.stream()
                .flatMap(reserva -> reserva.getProductos().stream())
                .map(Producto::getNombre)
                .collect(Collectors.toSet());

        return nombresProductos.containsAll(Arrays.asList("Hotel", "Boleto de Viaje" ));
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
