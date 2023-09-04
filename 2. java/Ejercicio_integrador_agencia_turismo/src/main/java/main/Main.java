package main;

import main.paqueteTuristico.PaqueteCompleto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // Crear un repositorio de clientes
        RepoCliente repositorio = new RepoCliente();

        // Crear un cliente
        Cliente cliente = repositorio.agregarCliente("Cliente1");

        // Crear un localizador con un paquete completo
        List<String> detallesPaqueteCompleto = new ArrayList<>();
        detallesPaqueteCompleto.add("hotel");
        detallesPaqueteCompleto.add("comida");
        detallesPaqueteCompleto.add("boletos");
        detallesPaqueteCompleto.add("transporte");
        Reserva reserva1 = new Reserva(cliente, 1000.0, detallesPaqueteCompleto);
        cliente.agregarLocalizador(reserva1);

        // Crear un localizador con 2 reservas de hotel y 2 de boletos
        List<String> detallesDosHotelesDosBoletos = new ArrayList<>();
        detallesDosHotelesDosBoletos.add("hotel");
        detallesDosHotelesDosBoletos.add("hotel");
        detallesDosHotelesDosBoletos.add("boletos");
        detallesDosHotelesDosBoletos.add("boletos");
        Reserva reserva2 = new Reserva(cliente, 800.0, detallesDosHotelesDosBoletos);
        cliente.agregarLocalizador(reserva2);

        // Crear un localizador con una sola reserva
        List<String> detallesUnaReserva = new ArrayList<>();
        detallesUnaReserva.add("hotel");
        Reserva reserva3 = new Reserva(cliente, 200.0, detallesUnaReserva);
        cliente.agregarLocalizador(reserva3);

        // Verificar que los descuentos fueron aplicados
        aplicarDescuentos(reserva1);
        aplicarDescuentos(reserva2);
        aplicarDescuentos(reserva3);

        // Imprimir los resultados
        System.out.println("Total con descuento para Cliente1, Reserva1: " + reserva1.getTotal());
        System.out.println("Total con descuento para Cliente1, Reserva2: " + reserva2.getTotal());
        System.out.println("Total con descuento para Cliente1, Reserva3: " + reserva3.getTotal());

}

public static void aplicarDescuentos(Reserva reserva) {
        Cliente cliente = reserva.getCliente();

        // Descuento del 5% si el cliente ha adquirido al menos 2 localizadores anteriormente
        if (cliente.getLocalizadores().size() >= 2) {
            reserva.total *= 0.95;
        }

        // Descuento del 10% si el cliente adquiere un paquete completo
        if (reserva.getDetalles().contains("hotel") && reserva.getDetalles().contains("comida")
                && reserva.getDetalles().contains("boletos") && reserva.getDetalles().contains("transporte")) {
            reserva.total *= 0.90;
        }
    }
}
