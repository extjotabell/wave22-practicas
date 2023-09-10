package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        Cliente cliente1 = new Cliente("Taylor", "Swift", "37131213",
                                        "3517132198");

        List<Reserva> listaDeReservas1 = new ArrayList<>();
        listaDeReservas1.add(new Reserva(tiposDeReserva.HOTEL));
        listaDeReservas1.add(new Reserva(tiposDeReserva.COMIDA));
        listaDeReservas1.add(new Reserva(tiposDeReserva.TRANSPORTE));
        listaDeReservas1.add(new Reserva(tiposDeReserva.BOLETOS));

        Localizador localizador1 = new Localizador(cliente1, listaDeReservas1);

        double precioFinal = repositorio.calcularPrecioFinal(cliente1, localizador1);
        System.out.println("El monto final a pagar es de $" + precioFinal + "\n\n");

        List<Reserva> listaDeReservas2 = new ArrayList<>();
        listaDeReservas2.add(new Reserva(tiposDeReserva.HOTEL));
        listaDeReservas2.add(new Reserva(tiposDeReserva.HOTEL));
        listaDeReservas2.add(new Reserva(tiposDeReserva.BOLETOS));
        listaDeReservas2.add(new Reserva(tiposDeReserva.BOLETOS));

        Localizador localizador2 = new Localizador(cliente1, listaDeReservas2);

        precioFinal = repositorio.calcularPrecioFinal(cliente1, localizador2);
        System.out.println("El monto final a pagar es de $" + precioFinal + "\n\n");


        List<Reserva> listaDeReservas3 = new ArrayList<>();
        listaDeReservas3.add(new Reserva(tiposDeReserva.BOLETOS));

        Localizador localizador3 = new Localizador(cliente1, listaDeReservas3);

        precioFinal = repositorio.calcularPrecioFinal(cliente1, localizador3);
        System.out.println("El monto final a pagar es de $" + precioFinal + "\n\n");

        System.out.println("Se han vendido un total de " + repositorio.cantidadDeLocalizadoresVendidos() + " localizadores");
        System.out.println("Se han vendido un total de " + repositorio.cantidadDeReservasVendidas() + " reservas");
        System.out.println("Reservas por cada tipo:");
        repositorio.cantidadDeReservasPorTipo().entrySet().stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Total vendido $" + repositorio.totalVentas());
        System.out.println("Promedio de cada venta $" + Math.round(repositorio.promedioVentas().getAsDouble()));



    }
}