import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cecilia", "Morlacchi");
        Reserva reserva1 = new Reserva("Hotel", 100);
        Reserva reserva2 = new Reserva("Comida", 300);
        Reserva reserva3 = new Reserva("Boletos", 1000);
        Reserva reserva4 = new Reserva("Transporte", 500);
        List<Reserva> reservaCompleta = new ArrayList<>();
        reservaCompleta.add(reserva1);
        reservaCompleta.add(reserva2);
        reservaCompleta.add(reserva3);
        reservaCompleta.add(reserva4);
        Localizador localizador1 = new Localizador(cliente1, reservaCompleta);
        System.out.println(localizador1);

        Reserva reserva5 = new Reserva("Hotel", 100);
        Reserva reserva6 = new Reserva("Hotel", 100);
        Reserva reserva7 = new Reserva("Boletos", 1000);
        Reserva reserva8 = new Reserva("Boletos", 1000);
        List<Reserva> reservaMedia = new ArrayList<>();
        reservaMedia.add(reserva5);
        reservaMedia.add(reserva6);
        reservaMedia.add(reserva7);
        reservaMedia.add(reserva8);
        Localizador localizador2 = new Localizador(cliente1,reservaMedia);
        System.out.println(localizador2);

        Reserva resreva9 = new Reserva("Transporte", 500);
        List<Reserva> reservaUnica = new ArrayList<>();
        reservaUnica.add(resreva9);
        Localizador localizador3 = new Localizador(cliente1,reservaUnica);
        System.out.println(localizador3);
    }
}
