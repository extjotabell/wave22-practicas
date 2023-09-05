import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente ,List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        guardarRepositorio();
        calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }

    private void guardarRepositorio(){
        Repositorio.localizadores.add(this);
    }

    private void calcularTotal(){
        double costo = reservas.stream().mapToDouble(x -> x.getCosto()).sum();
        if(Repositorio.localizadores.stream().filter(c-> c.cliente == cliente).count() >= 2){
            total = costo - (costo*5)/100;
        }
        if(reservas.stream().collect(Collectors.groupingBy(Reserva::getTipo)).size() == 4){
            total = costo - (costo*10)/100;
        }
        if(reservas.stream().filter(r-> r.getTipo().equals("Hotel")).count() > 2 || reservas.stream().filter(r-> r.getTipo().equals("Boletos")).count() > 2){
            total = costo - (costo-5)/100;
        }

    }
}
