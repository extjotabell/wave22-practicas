
public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Juan");

        System.out.println("CREO LOCALIZADOR 1");
        Localizador localizador1 = new Localizador(cliente);
        localizador1.agregarReserva(new Reserva("Hotel", 200.0));
        localizador1.agregarReserva(new Reserva("Comida", 100.0));
        localizador1.agregarReserva(new Reserva("Boleto", 50.0));
        localizador1.agregarReserva(new Reserva("Transporte", 80.0));
        localizador1.mostrarDetalles();


        System.out.println("CREO LOCALIZADOR 2");
        Localizador localizador2 = new Localizador(cliente);
        localizador2.agregarReserva(new Reserva("Hotel", 150.0));
        localizador2.agregarReserva(new Reserva("Hotel", 120.0));
        localizador2.agregarReserva(new Reserva("Boleto", 40.0));
        localizador2.agregarReserva(new Reserva("Boleto", 55.0));
        localizador2.mostrarDetalles();

        System.out.println("CREO LOCALIZADOR 3");
        Localizador localizador3 = new Localizador(cliente);
        localizador3.agregarReserva(new Reserva("Hotel", 180.0));
        localizador3.mostrarDetalles();

    }
}