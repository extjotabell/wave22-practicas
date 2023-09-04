package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Juan","12345678");
        Reserva reservaCompleta = new ReservaPaqueteCompleto(1,100,"2 de marzo hasta el 3 de marzo");
        Reserva reservaHotel = new ReservaServicio(1,100,"2 de marzo hasta el 3 de marzo","Hotel");
        Reserva reservaBoleto = new ReservaServicio(1,100,"2 de marzo coso","Boleto");
        Reserva reservaCompleta2 = new ReservaPaqueteCompleto(2,100,"4 DE JUNIO");
        Reserva reservaHotel2 = new ReservaServicio(3,100,"20 de octubre","Hotel");

        List<Reserva> listaReservaHoteles = new ArrayList<>();
        listaReservaHoteles.add(reservaHotel);
        listaReservaHoteles.add(reservaHotel2);
        listaReservaHoteles.add(reservaCompleta2);

        List<Reserva> listaReserva = new ArrayList<>();
        listaReserva.add(reservaCompleta);
        listaReserva.add(reservaHotel);
        List<Reserva> listaReserva2 = new ArrayList<>();
        listaReserva2.add(reservaBoleto);
        listaReserva2.add(reservaCompleta2);

     //   Localizador localizador1 = new Localizador(cliente1,listaReserva);
      Localizador localizador2 = new Localizador(cliente1,listaReserva);
        Localizador localizador3 = new Localizador(cliente1,listaReserva2);
        Localizador localizador4 = new Localizador(cliente1,listaReservaHoteles);

     //   System.out.println(localizador1);
   //    System.out.println(localizador2);
     //   System.out.println(localizador3);
        System.out.println(localizador4);

    }
}