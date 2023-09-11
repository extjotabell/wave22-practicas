import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repositorio.clientes = new ArrayList<>();
        Repositorio.localizadores = new ArrayList<>();
        Cliente cliente1 = new Cliente("1", "A A");
        cliente1.save();
        List<Reserva> reservas = new ArrayList<>();
        //Paquete completo
        reservas.add(new Reserva(TipoReserva.HOTEL,"", 10));
        reservas.add(new Reserva(TipoReserva.COMIDA,"", 10));
        reservas.add(new Reserva(TipoReserva.VIAJE,"", 10));
        reservas.add(new Reserva(TipoReserva.TRANSPORTE,"", 10));
        Localizador l1 = new Localizador(cliente1, reservas);
        l1.save();
        System.out.println(l1.costo);

        //2 desc hotel 2 desc viaje
        reservas.clear();
        reservas.add(new Reserva(TipoReserva.HOTEL,"", 10));
        reservas.add(new Reserva(TipoReserva.HOTEL,"", 10));
        reservas.add(new Reserva(TipoReserva.VIAJE,"", 10));
        reservas.add(new Reserva(TipoReserva.VIAJE,"", 10));
        Localizador l2 = new Localizador(cliente1, reservas);
        l2.save();
        System.out.println(l2.costo);

        reservas.clear();
        reservas.add(new Reserva(TipoReserva.HOTEL,"", 10));
        Localizador l3 = new Localizador(cliente1, reservas);
        l3.save();
        System.out.println(l3.costo);
    }
}
