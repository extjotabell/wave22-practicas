package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Cliente> cliente = new ArrayList<>();

    public static void main(String[] args) {

        Cliente renzo = new Cliente("12345678", "Renzo");

        ReservaHotel reservaHotel = new ReservaHotel(1L, 1000);
        ReservaBoletoViaje reservaViaje = new ReservaBoletoViaje(2L, 1000);
        ReservaComida reservaComida = new ReservaComida(3L, 1000);
        ReservaTransporte reserva = new ReservaTransporte(4L, 1000);

        List<Reserva> reservasRenzo = new ArrayList<>();
        reservasRenzo.add(reservaHotel);
        reservasRenzo.add(reservaViaje);
        reservasRenzo.add(reservaComida);
        reservasRenzo.add(reserva);

        Localizador localizador = new Localizador(1L, LocalDate.now(), renzo, reservasRenzo);
        System.out.println(localizador);

        List<Reserva> reservasRenzo2 = new ArrayList<>();
        reservasRenzo2.add(reservaHotel);
        reservasRenzo2.add(reservaHotel);
        reservasRenzo2.add(reservaViaje);
        reservasRenzo2.add(reservaViaje);
        reservasRenzo2.add(reservaComida);
        reservasRenzo2.add(reservaComida);

        Localizador l2 = new Localizador(2L, LocalDate.now(), renzo, reservasRenzo2);
        System.out.println(l2);

        List<Reserva> reservasRenzo3 = new ArrayList<>();
        reservasRenzo3.add(reservaHotel);

        Localizador l3 = new Localizador(3L, LocalDate.now(), renzo, reservasRenzo3);
        System.out.println(l3);
    }
}