import java.util.ArrayList;

public class Localizador {
    String datos_cliente;
    int cantidad_reservas;
    ArrayList<Reserva> reservas = new ArrayList<>();

    public Localizador(String datos_cliente) {
        this.datos_cliente = datos_cliente;
    }

    public void anadir_reserva(Reserva reserva){
        this.reservas.add(reserva);
        this.cantidad_reservas = reservas.size();
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public int getCantidad_reservas() {
        return cantidad_reservas;
    }
}
