import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        cliente.incrementarContadorLocalizadores();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public double calcularDescuento() {
        double total = calcularTotal();
        int contadorLocalizadores = cliente.getContadorLocalizadores();

        double descuento = 0.0;

        if (contadorLocalizadores >= 2) {
            descuento += total * 0.05;
        }

        if (contienePaqueteCompleto()) {
            descuento += total * 0.10;
        }

        for (Reserva reserva : reservas) {
            if (reserva.getTipo().equals("Hotel") || reserva.getTipo().equals("Boleto")) {
                if (reserva.getCosto() >= 2) {
                    descuento += reserva.getCosto() * 0.05;
                }
            }
        }

        return descuento;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Reserva reserva : reservas) {
            total += reserva.getCosto();
        }
        return total;
    }

    private boolean contienePaqueteCompleto() {
        boolean contieneHotel = false;
        boolean contieneComida = false;
        boolean contieneBoleto = false;
        boolean contieneTransporte = false;

        for (Reserva reserva : reservas) {
            if (reserva.getTipo().equals("Hotel")) {
                contieneHotel = true;
            } else if (reserva.getTipo().equals("Comida")) {
                contieneComida = true;
            } else if (reserva.getTipo().equals("Boleto")) {
                contieneBoleto = true;
            } else if (reserva.getTipo().equals("Transporte")) {
                contieneTransporte = true;
            }
        }

        return contieneHotel && contieneComida && contieneBoleto && contieneTransporte;
    }

    public void mostrarDetalles() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reservas:");

        for (Reserva reserva : reservas) {
            System.out.println("Tipo: " + reserva.getTipo() + ", Costo: " + reserva.getCosto());
        }

        double total = calcularTotal();
        System.out.println("Total: " + total);

        double descuento = calcularDescuento();
        System.out.println("Descuento aplicado: " + descuento);

        double totalConDescuento = total - descuento;
        System.out.println("Total con descuento: " + totalConDescuento);
    }
}