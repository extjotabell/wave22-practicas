package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Repositorio {
    Map<Cliente, List<Localizador>> comprasAnteriores;

    public Repositorio() {
        this.comprasAnteriores = new HashMap<>();
    }

    public Map<Cliente, List<Localizador>> getComprasAnteriores() {
        return comprasAnteriores;
    }

    public void setComprasAnteriores(Map<Cliente, List<Localizador>> comprasAnteriores) {
        this.comprasAnteriores = comprasAnteriores;
    }

    public void añadirCompra(Cliente cliente, Localizador localizador){
        List<Localizador> comprasCliente = comprasAnteriores.get(cliente);

        if(comprasCliente == null) {
            comprasCliente = new ArrayList<>();
        }

        comprasCliente.add(localizador);
        comprasAnteriores.put(cliente, comprasCliente);
    }

    public double calcularPrecioFinal(Cliente cliente, Localizador localizador){
        double descuento = 0;

        if(comprasAnteriores.get(cliente) != null && comprasAnteriores.get(cliente).size() >= 2){
            descuento += 0.05;
        }

        AtomicBoolean reservoHotel = new AtomicBoolean(false);
        AtomicBoolean reservoComida = new AtomicBoolean(false);
        AtomicBoolean reservoVuelo = new AtomicBoolean(false);
        AtomicBoolean reservoTransporte = new AtomicBoolean(false);
        localizador.getReservas().forEach(n -> {
            if(n.getTipo() == tiposDeReserva.HOTEL){
                reservoHotel.set(true);
            }
            else if(n.getTipo() == tiposDeReserva.TRANSPORTE){
                reservoTransporte.set(true);
            }
            else if(n.getTipo() == tiposDeReserva.COMIDA){
                reservoComida.set(true);
            }
            else{
                reservoVuelo.set(true);
            }
        });
        if(reservoTransporte.get() && reservoHotel.get() && reservoVuelo.get() && reservoComida.get()){
            descuento += 0.10;
        }

        localizador.setTotal(localizador.getTotal() - calcularDescuentoPorReserva(localizador));

        if(descuento != 0){
            System.out.println("Se le aplicará un descuento del " + Math.round(descuento*100) + "% sobre la compra del " +
                    "localizador de precio $" + localizador.getTotal());
        }

        añadirCompra(cliente, localizador);
        localizador.setTotal(localizador.getTotal() - descuento * localizador.getTotal());

        return localizador.getTotal();
    }

    public double calcularDescuentoPorReserva(Localizador localizador){
        double descuento = 0;
        List<Reserva> hoteles = localizador.getReservas().stream()
                .filter(n -> n.getTipo().equals(tiposDeReserva.HOTEL))
                .collect(Collectors.toList());

        List<Reserva> boletos = localizador.getReservas().stream()
                .filter(n -> n.getTipo().equals(tiposDeReserva.BOLETOS))
                .collect(Collectors.toList());

        if(hoteles.size() >= 2){
            descuento += hoteles.size() * hoteles.get(0).getPrecio() * 0.05;
            System.out.println("Se aplica descuento por comprar 2 reservas de hotel");
        }

        if(boletos.size() >= 2){
            descuento += boletos.size() * boletos.get(0).getPrecio() * 0.05;
            System.out.println("Se aplica descuento por comprar 2 boletos de viaje");
        }

        return descuento;
    }

    public int cantidadDeLocalizadoresVendidos(){
        return comprasAnteriores.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .size();
    }

    public int cantidadDeReservasVendidas(){
        return comprasAnteriores.values().stream()
                .flatMap(List::stream)
                .mapToInt(n -> n.getReservas().size())
                .sum();
    }

    public Map<String, Integer> cantidadDeReservasPorTipo(){
        Map<String, Integer> reservasPorTipo = new HashMap<>();

        comprasAnteriores.values().stream()
                .flatMap(List::stream)
                .flatMap(n -> n.getReservas().stream())
                .forEach(reserva -> {
                    String tipoReserva= reserva.getTipo().name();
                    reservasPorTipo.put(tipoReserva, reservasPorTipo.getOrDefault(tipoReserva, 0) + 1);
                });
        return reservasPorTipo;
    }

    public double totalVentas(){
        return comprasAnteriores.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public OptionalDouble promedioVentas(){
        return comprasAnteriores.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Localizador::getTotal)
                .average();
    }
}
