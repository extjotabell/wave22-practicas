package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        Reserva reserva1 = new Reserva(TipoReserva.HOTEL,1500);
        Reserva reserva2 = new Reserva(TipoReserva.COMIDA,1500);
        Reserva reserva3 = new Reserva(TipoReserva.TRANSPORTE,1500);
        Reserva reserva4 = new Reserva(TipoReserva.COMIDA,1500);
        Reserva reserva5 = new Reserva(TipoReserva.COMIDA, 100);
        List<Reserva> reservasCliente1= new ArrayList<>();
        List<Reserva> reservas2Cliente1 = new ArrayList<>();
        reservasCliente1.add(reserva1);
        reservasCliente1.add(reserva2);
        reservasCliente1.add(reserva3);
        reservasCliente1.add(reserva4);
        reservas2Cliente1.add(reserva5);
        Cliente cliente1 = new Cliente(1,"Juan Perez");
        Localizador localizador1 = new Localizador(cliente1, reservasCliente1);
        Localizador localizador2 = new Localizador(cliente1, reservas2Cliente1);
        repositorio.almacenarLocalizador(cliente1,localizador1);
        repositorio.almacenarLocalizador(cliente1,localizador2);
        localizador1.calculoTotalLocalizador(repositorio);
        localizador2.calculoTotalLocalizador(repositorio);
        System.out.println("El precio total del localizador 1 es de: "+localizador1.getTotal());
        System.out.println("El precio total del localizador 2 es de: "+localizador2.getTotal());
        System.out.println("Cantidad de localizadores del cliente 1: "+repositorio.cantidadLocalizadoresPorCliente(cliente1));
    }
}