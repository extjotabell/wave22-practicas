import model.Cliente;
import model.Localizador;
import model.Producto;
import model.Reserva;
import repository.impl.LocalizadorImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        // Generar un localizador y cliente
        Cliente cliente1 = new Cliente(1,"Jose Pablo","32766941");
        Cliente cliente2 = new Cliente(2, "Mario Roberto","20742564");

        Reserva reserva1 = new Reserva();
        reserva1.agregarProducto(new Producto("Hotel", 1300));
        reserva1.agregarProducto(new Producto("Comida", 1600));
        reserva1.agregarProducto(new Producto("Boleto de Viaje", 1500));
        reserva1.agregarProducto(new Producto("Transporte", 1000));
        reserva1.setTotal(reserva1.calcularTotal());

        Reserva reserva2 = new Reserva();
        reserva2.agregarProducto(new Producto("Hotel", 1300));
        reserva2.agregarProducto(new Producto("Boleto de Viaje", 1500));
        reserva2.setTotal(reserva2.calcularTotal());
        System.out.println(reserva2);

        // Agregar las reservas a localizadores
        Localizador localizadores = new Localizador(cliente1);
        localizadores.agregarReserva(reserva1);
        localizadores.agregarReserva(reserva2);

        LocalizadorImpl localizador = new LocalizadorImpl();
        localizador.save(localizadores);

        localizador.mostrarPantalla();



        // Calcular el total de las reservas del cliente1
       // double totalCliente1 = reservasCliente1.stream()
         //       .mapToDouble(model.Reserva::getTotal)
           //     .sum();
/*
        // Aplicar descuentos según las reglas
        double descuento = 0.0;
        if (reservasCliente1.size() >= 2) {
            // Aplicar descuento del 5% si el cliente tiene al menos 2 reservas
            descuento = totalCliente1 * 0.05;
        }

        /*
        // Aplicar descuento del 10% si el cliente adquiere un paquete completo
        if (contienePaqueteCompleto(reservasCliente1)) {
            descuento = totalCliente1 * 0.10;
        }

        // Aplicar descuento del 5% en reservas de hotel o boletos de viaje
        descuento += calcularDescuentoHotelBoletos(reservasCliente1);

        // Imprimir el total y el descuento
        System.out.println("Total de las reservas de Cliente1: " + totalCliente1);
        System.out.println("Descuento aplicado: " + descuento); */
    }
}