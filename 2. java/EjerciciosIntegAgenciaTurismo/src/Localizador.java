import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;


    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }



    @Override
    public String toString() {
        return "Localizador{" +
                ", reservas=" + reservas +
                '}';
    }
}
